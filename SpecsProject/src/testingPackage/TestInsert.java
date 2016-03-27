package testingPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.nitido.utils.toaster.Toaster;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TestInsert extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	
	private JLabel lblDatepurchace;
	private JLabel lblPrice;
	private JLabel lblType;
	private JTextField textField_5;
	private MaskFormatter formatter;
	private String DatePurchaseString;
	private String DateExpirationString;
	private PreparedStatement prepare;
	private Connection conn;
	private Toaster toasterManager;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					TestInsert frame = new TestInsert();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public TestInsert() throws SQLException {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/////Variables
		conn = sqliteConnectionTEST.dbConnector();
		String query = "insert into Artwork(\"group\",Asset,Property_Description,Date_In_Service,Price)"
				+ "values(?,?,?,?,?)";
		prepare = conn.prepareStatement(query);
		insertLabels();
		insertTextFields();
		insertButtons();
		
	
	}//end of TestInsert
	
	
	private void insertButtons() {
		JButton btnSubmit = new JButton("Insert");
		btnSubmit.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//if(prepare.executeUpdate() > 1)
					//{
						prepare.executeUpdate();
						toasterManager.showToaster("Insert Successful");
						TestMain.UpDateTable();
						TestMain.refreshScreen();
						dispose();
					//}
					//else
//					{
//						toasterManager = new Toaster();
//						toasterManager.showToaster("Incorrect data inserted. Insert Failed.");
//					}
					
					
				} catch (SQLException e1) {//checks if asset key duplicate is beng inserted
					if(e1.getMessage().contains("UNIQUE constraint failed"))
					{//when prepareStatement fails it needs to be redeclare to insert again
						System.out.println("NOOOOO");
						toasterManager = new Toaster();
						toasterManager.showToaster("[SQLITE_CONSTRAINT]  Abort due to constraint violation");
						try {
							prepare.close();
							String query = "insert into Artwork(\"group\",Asset,Property_Description,Date_In_Service,Price)"
									+ "values(?,?,?,?,?)";							
							prepare = conn.prepareStatement(query);
							reInsertPrepareStatement();
							
							
							
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnSubmit.setBounds(151, 315, 140, 40);
		contentPane.add(btnSubmit);
	}

	public void insertLabels()
	{
		//LABELS
		JLabel lblNewLabel = new JLabel("Insert Data Into Table");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		lblNewLabel.setBounds(43, 11, 243, 39);
		contentPane.add(lblNewLabel);

		JLabel lblId = new JLabel("Group");
		lblId.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblId.setBounds(41, 75, 125, 25);
		contentPane.add(lblId);

		JLabel lblNewLabel_1 = new JLabel("Asset");
		lblNewLabel_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(41, 115, 125, 25);
		contentPane.add(lblNewLabel_1);
		
		lblPrice = new JLabel("Property Description");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblPrice.setBounds(6, 158, 175, 25);
		contentPane.add(lblPrice);


		lblDatepurchace = new JLabel("Date In Service");
		lblDatepurchace.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblDatepurchace.setBounds(41, 195, 125, 25);
		contentPane.add(lblDatepurchace);

		JLabel lblExpiration = new JLabel("Price");
		lblExpiration.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblExpiration.setBounds(41, 235, 140, 25);
		contentPane.add(lblExpiration);
	}
	
	public  boolean isInt(String textField)
	{
		//if()
		return rootPaneCheckingEnabled;
		
	}

	public void insertTextFields()
	{
		//TextFields
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setBounds(181, 75, 212, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		//Group
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					prepare.setString(1, textField.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		textField_1.setBounds(182, 115, 211, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		//Asset
		textField_1.addKeyListener(new KeyAdapter() {
			String main;
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String temp = textField_1.getText();
					String regex = "^[1-9]\\d*$";
					if(temp.matches(regex))
					{//refractor to method
						main = temp;
						double round = (Double.parseDouble(textField_1.getText()));
						prepare.setDouble(5, round);
					}
					else if((e.getKeyCode() == KeyEvent.VK_BACK_SPACE) || (e.getKeyCode() == KeyEvent.VK_DELETE) 
							&& temp.length() == 0)
				    {//deletes the element in textbox if it contains a string
						textField_1.setText("");
						main="";
				    }
					else if(temp.length() == 0)
					{//in case string returns when textbox is empty, empty string
						textField_1.setText("");
						main="";
					}
					else
						textField_1.setText(main);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		textField_2.setBounds(182, 155, 211, 35);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		//Property Description
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					prepare.setString(3, textField_2.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		try {
			formatter = new MaskFormatter("##'/##'/####");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		textField_3 = new JFormattedTextField(formatter);
		textField_3.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		textField_3.setBounds(182, 195, 211, 35);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		//Date in Service
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					prepare.setString(4, String.valueOf(textField_3.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
	
		textField_4 = new JFormattedTextField();
		textField_4.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		textField_4.setBounds(182, 235, 211, 35);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_4.addKeyListener(new KeyAdapter() {
			//Price
			String main = null;

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String temp = textField_4.getText();
					//only accepts positives doubles
					String regex = "^[0-9.]+([,.][0-9]+)?$";

					if(temp.matches(regex))
					{
						main = temp;
						double round = (Double.parseDouble(textField_4.getText()));
						prepare.setDouble(5, round);
					}
					else if((e.getKeyCode() == KeyEvent.VK_BACK_SPACE) || (e.getKeyCode() == KeyEvent.VK_DELETE) 
							&& temp.length() == 0)
				    {//deletes the element in textbox
						textField_4.setText("");
						main="";
				    }
					else if(temp.length() == 0)
					{
						textField_4.setText("");
						main="";
					}
					else
						textField_4.setText(main);
					//Must not have any characters and any negative value
//					if(temp.matches(regex) &&  Double.parseDouble(textField_4.getText()) > 0)
//					{
//						double round = (Double.parseDouble(textField_4.getText()));
//						prepare.setDouble(5, round);
//					}
//					else
//						textField_4.setText("");
						

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
	
	
	public void reInsertPrepareStatement() throws SQLException
	{
		prepare.setString(1, textField.getText());
		prepare.setInt(2, Integer.parseInt(textField_1.getText()));
		prepare.setString(3, textField_2.getText());
		prepare.setString(4, String.valueOf(textField_3.getText()));
		prepare.setDouble(5, Double.parseDouble(textField_4.getText()));
	}
	
}