package testingPackage;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
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
                    frame.setLocationRelativeTo(null);
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
    	setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(ExcelFrame.class.getResource("/Resources/appIconImage.png")));
        setTitle("Excel Options");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setBounds(100, 100, 905, 330);
        setSize(905,330);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(244, 244, 244));
        setContentPane(contentPane);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));


		final JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new ExcelFilter());


        JLabel btnImportExcel = new JLabel("");
        btnImportExcel.setIcon(new ImageIcon(ExcelFrame.class.getResource("/Resources/importIcon.jpg")));
        btnImportExcel.setToolTipText("Inserts Excel files to database.Insertion of Excel Start at Row 4, "
        		+ "Anything before Row 4 will not be inserted to database");
        btnImportExcel.addFocusListener(new FocusAdapter() {


        });
        btnImportExcel.addMouseListener(new MouseAdapter() {
        	
        	@Override
            public void mouseEntered(MouseEvent arg0) {
        		//btnImportExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        		btnImportExcel.setIcon(new ImageIcon(ExcelFrame.class.getResource("/Resources/importIcon_Hover.jpg")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	btnImportExcel.setIcon(new ImageIcon(ExcelFrame.class.getResource("/Resources/importIcon.jpg")));
            }
        	
        	@Override
            public void mouseClicked(MouseEvent e) {

                //Handle open button action.
                if (e.getSource() == btnImportExcel) {
                    int returnVal = fc.showOpenDialog(btnImportExcel);
                    Connection conn = sqliteConnectionTEST.dbConnector();
                    //disable auto commit
                    try {
                        conn.setAutoCommit(false);
                    } catch (SQLException e3) {
                        // TODO Auto-generated catch block
                        e3.printStackTrace();
                    }
                    //create a sv point incase sql exception
                    Savepoint sv = null;
                    try {
                        sv = conn.setSavepoint("sv");
                    } catch (SQLException e4) {
                        // TODO Auto-generated catch block
                        e4.printStackTrace();
                    }
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
                                System.out.println("Successfully imported");
                                JOptionPane.showMessageDialog(contentPane,
                                        "Successfully imported " + file.getName() +" to database."
                                                +"\nTime: " + sdf.format(resultdate) ,
                                                "Import",
                                                JOptionPane.INFORMATION_MESSAGE
                                        );    
                            }
                            else{//The excel imported does not match format
                                //custom title, warning icon
                                Scanner input = null;
                                String line;
                                StringBuilder sb = new StringBuilder();
                                try {
                                    input = new Scanner(new File("LogMissingColumns.txt"));
                                } catch (FileNotFoundException e2) {
                                    e2.printStackTrace();
                                }
                                sb.append("\n");

                                while((input.hasNext()))
                                {
                                    line = input.nextLine();
                                    sb.append(line + ",");
                                    sb.append("\n");

                                }
                                String temp = sb.toString();
                                String output = null;

                                if(temp.substring(temp.length()-2).contains(","))
                                {
                                    output = temp.substring(0, temp.length()-2);
                                }
                                //System.out.println(output.substring(output.length()-1).contains(","));
                                JOptionPane.showMessageDialog(contentPane,
                                        file.getName() +" is missing columns: "
                                                + output,
                                                "ERROR",
                                                JOptionPane.ERROR_MESSAGE);    
                                conn.close();
                            }

                        } catch (SQLException e1) {
                            if(e1.toString().contains(" [SQLITE_BUSY]  The database file is locked "
                                    + "(database is locked)"))
                            {//Occurs when connection is not closed
                                JOptionPane.showMessageDialog(contentPane,
                                        "CLOSE All SQLITE APPLICATIONS, and try again",
                                        "ERROR",
                                        JOptionPane.ERROR_MESSAGE);
                                try {
									conn.close();
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}

                            }
                            else if(e1.toString().contains("[SQLITE_CONSTRAINT]  Abort due to constraint violation"))
                            {
                                try {
                                    //rollback the changes because of constraint
                                    conn.rollback(sv);;
                                    conn.rollback();
                                    //conn.commit();
                                    try {
                                        conn.close();
                                    } catch (SQLException e2) {
                                        // TODO Auto-generated catch block
                                        e1.printStackTrace();
                                    }
                                } catch (SQLException e3) {
                                    // TODO Auto-generated catch block
                                    e3.printStackTrace();
                                }
                                Scanner input = null;
                                String line;
                                try {
                                    input = new Scanner(new File("LogDuplicateID_Tag.txt"));
                                } catch (FileNotFoundException e2) {
                                    e2.printStackTrace();
                                }

                                line = input.nextLine();
                                JOptionPane.showMessageDialog(contentPane,
                                        file.getName() +" was not imported\n"
                                                +"Duplicates Entry found in: "
                                                + line +"\nFix duplicate and reimport file."
                                                ,
                                                "ERROR",
                                                JOptionPane.ERROR_MESSAGE);
                                try {
									conn.close();
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}


                            }
                            e1.printStackTrace();

                        }
                        try {
                            conn.close();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
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

        JLabel btnExportExcel = new JLabel("");
        btnExportExcel.setIcon(new ImageIcon(ExcelFrame.class.getResource("/Resources/exportIcon.jpg")));
        btnExportExcel.setToolTipText("Exports all data from database into an excel file.");
        btnExportExcel.addMouseListener(new MouseAdapter() {
        	
        	@Override
            public void mouseEntered(MouseEvent arg0) {
        		//btnImportExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        		btnExportExcel.setIcon(new ImageIcon(ExcelFrame.class.getResource("/Resources/exportIcon_Hover.jpg")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	btnExportExcel.setIcon(new ImageIcon(ExcelFrame.class.getResource("/Resources/exportIcon.jpg")));
            }
        	
        	@Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ConvertExcel.writeExcel(false);
                } catch (IOException e1) {e1.printStackTrace();
                
                if(e1.toString().contains("java.lang.NumberFormatException:"))
				{
					Scanner input = null;
					String line;
					try {
						input = new Scanner(new File("LogReportNumberFormatException.txt"));
					} catch (FileNotFoundException e2) {
						e2.printStackTrace();
					}
					line = input.nextLine();
					JOptionPane.showMessageDialog(null, "Check ID_Tag: " + line  +"'s rows for errors");

				}
                
                
                }
            }
        });

        btnImportExcel.addMouseListener(new MouseAdapter() {
        	
        	@Override
            public void mouseEntered(MouseEvent arg0) {
        		//btnImportExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        		btnImportExcel.setIcon(new ImageIcon(ExcelFrame.class.getResource("/Resources/importIcon_Hover.jpg")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	btnImportExcel.setIcon(new ImageIcon(ExcelFrame.class.getResource("/Resources/importIcon.jpg")));
            }
        	
        	@Override
            public void mouseClicked(MouseEvent e) {

                //Handle open button action.
                if (e.getSource() == btnImportExcel) {
                    int returnVal = fc.showOpenDialog(btnImportExcel);
                    Connection conn = sqliteConnectionTEST.dbConnector();
                    //disable auto commit
                    try {
                        conn.setAutoCommit(false);
                    } catch (SQLException e3) {
                        // TODO Auto-generated catch block
                        e3.printStackTrace();
                    }
                    //create a sv point incase sql exception
                    Savepoint sv = null;
                    try {
                        sv = conn.setSavepoint("sv");
                    } catch (SQLException e4) {
                        // TODO Auto-generated catch block
                        e4.printStackTrace();
                    }
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
                                System.out.println("Successfully imported");
                                JOptionPane.showMessageDialog(contentPane,
                                        "Successfully imported " + file.getName() +" to database."
                                                +"\nTime: " + sdf.format(resultdate) ,
                                                "Import",
                                                JOptionPane.INFORMATION_MESSAGE
                                        );    
                            }
                            else{//The excel imported does not match format
                                //custom title, warning icon
                                Scanner input = null;
                                String line;
                                StringBuilder sb = new StringBuilder();
                                try {
                                    input = new Scanner(new File("LogC.txt"));
                                } catch (FileNotFoundException e2) {
                                    e2.printStackTrace();
                                }
                                sb.append("\n");

                                while((input.hasNext()))
                                {
                                    line = input.nextLine();
                                    sb.append(line + ",");
                                    sb.append("\n");

                                }
                                String temp = sb.toString();
                                String output = null;

                                if(temp.substring(temp.length()-2).contains(","))
                                {
                                    output = temp.substring(0, temp.length()-2);
                                }
                                //System.out.println(output.substring(output.length()-1).contains(","));
                                JOptionPane.showMessageDialog(contentPane,
                                        file.getName() +" is missing columns: "
                                                + output,
                                                "ERROR",
                                                JOptionPane.ERROR_MESSAGE);    
                            }

                        } catch (SQLException e1) {
                            if(e1.toString().contains(" [SQLITE_BUSY]  The database file is locked "
                                    + "(database is locked)"))
                            {//Occurs when connection is not closed
                                JOptionPane.showMessageDialog(contentPane,
                                        "CLOSE All SQLITE APPLICATIONS, and try again",
                                        "ERROR",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            else if(e1.toString().contains("[SQLITE_CONSTRAINT]  Abort due to constraint violation"))
                            {
                                try {
                                    //rollback the changes because of constraint
                                    conn.rollback(sv);;
                                    conn.rollback();
                                    //conn.commit();
                                    try {
                                        conn.close();
                                    } catch (SQLException e2) {
                                        // TODO Auto-generated catch block
                                        e1.printStackTrace();
                                    }
                                } catch (SQLException e3) {
                                    // TODO Auto-generated catch block
                                    e3.printStackTrace();
                                }
                                Scanner input = null;
                                String line;
                                try {
                                    input = new Scanner(new File("Log.txt"));
                                } catch (FileNotFoundException e2) {
                                    e2.printStackTrace();
                                }

                                line = input.nextLine();
                                JOptionPane.showMessageDialog(contentPane,
                                        file.getName() +" was not imported\n"
                                                +"Duplicates Entry found in: "
                                                + line +"\nFix duplicate and reimport file."
                                                ,
                                                "ERROR",
                                                JOptionPane.ERROR_MESSAGE);    

                            }
                            e1.printStackTrace();

                        }
                        try {
                            conn.close();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
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

        btnExportExcel.setIcon(new ImageIcon(ExcelFrame.class.getResource("/Resources/exportIcon.jpg")));
        btnExportExcel.setToolTipText("Exports all data from database into an excel file.");
        btnExportExcel.addMouseListener(new MouseAdapter() {
        	
        	@Override
            public void mouseEntered(MouseEvent arg0) {
        		//btnImportExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        		btnExportExcel.setIcon(new ImageIcon(ExcelFrame.class.getResource("/Resources/exportIcon_Hover.jpg")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	btnExportExcel.setIcon(new ImageIcon(ExcelFrame.class.getResource("/Resources/exportIcon.jpg")));
            }
        	
        	@Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ConvertExcel.writeExcel(false);
                } catch (IOException e1) {e1.printStackTrace();}
            }
        });

        JLabel button = new JLabel("");
        button.setIcon(new ImageIcon(ExcelFrame.class.getResource("/Resources/templateIcon.jpg")));
        button.addMouseListener(new MouseAdapter() {
        	
        	@Override
            public void mouseEntered(MouseEvent arg0) {
        		//btnImportExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        		button.setIcon(new ImageIcon(ExcelFrame.class.getResource("/Resources/templateIcon_Hover.jpg")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
            	button.setIcon(new ImageIcon(ExcelFrame.class.getResource("/Resources/templateIcon.jpg")));
            }
        	
        	@Override
            public void mouseClicked(MouseEvent e) {
                try {
                    ConvertExcel.writeExcel(true);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        button.setToolTipText("Opens a template with all necessary column names in Excel to import data.");
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        contentPane.add(btnExportExcel);
        contentPane.add(button);
        contentPane.add(btnImportExcel);


		
		
		
		
		
	}
}