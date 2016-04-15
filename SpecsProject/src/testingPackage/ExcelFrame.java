package testingPackage;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExcelFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcelFrame frame = new ExcelFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExcelFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ExcelFrame.class.getResource("/Resources/appIconImage.png")));
		setTitle("Excel Options");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 268, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));

		final JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new ExcelFilter());

		JButton btnImportExcel = new JButton("Import Excel");
		btnImportExcel.addFocusListener(new FocusAdapter() {
			
		});
		btnImportExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Handle open button action.
				if (e.getSource() == btnImportExcel) {
					int returnVal = fc.showOpenDialog(btnImportExcel);

					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();

						//excelFilter.accept(file);
						try {
							if(ConvertExcel.validateExcel(file)){
								//ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/black-check-mark-md.png"));

								long startTime = System.currentTimeMillis();
								
								ConvertExcel.importExcel(file);
								//Logs how long import took
								long endTime   = System.currentTimeMillis();
								long totalTime = endTime - startTime;
								SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");    
								Date resultdate = new Date(totalTime);
								System.out.println(sdf.format(resultdate));
								System.out.println("SUCCESS");
								JOptionPane.showMessageDialog(contentPane,
									    "Successfully added excel file to database."
										+"\nTime: " + sdf.format(resultdate) ,
									    "Loading",
									    JOptionPane.INFORMATION_MESSAGE
									    );	
								
							}
							else{
								//custom title, warning icon
								JOptionPane.showMessageDialog(contentPane,
								    "XLS. File does not meet requied standard.",
								    "ERROR",
								    JOptionPane.ERROR_MESSAGE);	
							}
								
						} catch (SQLException e1) {
							if(e1.toString().contains(" [SQLITE_BUSY]  The database file is locked "
									+ "(database is locked)"))
							{//Occurs when connection is not closed
								JOptionPane.showMessageDialog(contentPane,
									    "CLOSE All SQLITE APPLICATIONS",
									    "ERROR",
									    JOptionPane.ERROR_MESSAGE);
							}
							else if(e1.toString().contains("[SQLITE_CONSTRAINT]  Abort due to constraint violation"))
							{
								Scanner input = null;
								String line;
								try {
									input = new Scanner(new File("Log.txt"));
								} catch (FileNotFoundException e2) {
									e2.printStackTrace();
								}
								
								line = input.nextLine();
								JOptionPane.showMessageDialog(contentPane,
									    "Duplicates Entry found in .XLS \n" 
									   + line
									    ,
									    "ERROR",
									    JOptionPane.ERROR_MESSAGE);	
								
							}
							e1.printStackTrace();
							
						}
						
						
						//This is where a real application would open the file.
						//System.out.println(("Opening: " + file.getName() + "."));
					} else {
						//System.out.println(("Open command cancelled by user."));
					}
				}
			}

		});
		
		JButton btnExportExcel = new JButton("Export Excel");
		btnExportExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConvertExcel.writeExcel(false);
				} catch (IOException e1) {e1.printStackTrace();}
			}
		});
		
		JButton btnTemplate = new JButton("Excel Template");
		btnTemplate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ConvertExcel.writeExcel(true);
				} catch (IOException e) {e.printStackTrace();}

			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(44, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnExportExcel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnImportExcel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnTemplate, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
					.addGap(40))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnTemplate, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnImportExcel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(btnExportExcel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	
		
		
		
		
		
	}
}
