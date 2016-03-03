package testingPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
	private String yearAdd2;
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
		Connection conn = sqliteConnectionTEST.dbConnector();
		String query = "Insert into Electronics(ID, Room, Price, Date_Purchase, Expiration_Date, Type)"
		+ "values(?,?,?,?,?,?)";
		PreparedStatement prepare = conn.prepareStatement(query);
		
		
		System.out.println(System.getProperty("user.dir") + "\\TestDB.sqlite");

		JLabel lblNewLabel = new JLabel("Insert Data Into Table");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		lblNewLabel.setBounds(43, 11, 243, 39);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
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
		textField.setBounds(181, 75, 212, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					prepare.setString(2, textField_1.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textField_1.setBounds(182, 115, 211, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
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
		textField_2.setBounds(182, 155, 211, 35);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
	    try {//formats date input 
			formatter = new MaskFormatter("##'/##'/####");
			
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		textField_3 = new JFormattedTextField(formatter);
		textField_3.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					prepare.setString(4, String.valueOf(textField_3.getText()));
					yearAdd2 = textField_3.getText().substring(6, 10);
					System.out.println(yearAdd2);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textField_3.setBounds(182, 195, 211, 35);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		try {
			formatter = new MaskFormatter("##'/##'/####");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		textField_4 = new JFormattedTextField(formatter);
		textField_4.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		textField_4.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					prepare.setString(5, textField_4.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		textField_4.setBounds(182, 235, 211, 35);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblId.setBounds(41, 75, 125, 25);
		contentPane.add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel("Room");
		lblNewLabel_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(41, 115, 125, 25);
		contentPane.add(lblNewLabel_1);
		
		lblDatepurchace = new JLabel("Date Purchase");
		lblDatepurchace.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblDatepurchace.setBounds(41, 195, 125, 25);
		contentPane.add(lblDatepurchace);
		
		lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblPrice.setBounds(41, 155, 125, 25);
		contentPane.add(lblPrice);
		
		lblType = new JLabel("Type");
		lblType.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblType.setBounds(41, 275, 125, 25);
		contentPane.add(lblType);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					prepare.setString(6, textField_5.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JLabel lblExpiration = new JLabel("Expiration Date");
		lblExpiration.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblExpiration.setBounds(41, 235, 140, 25);
		contentPane.add(lblExpiration);
		textField_5.setBounds(182, 275, 211, 35);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSubmit = new JButton("Insert");
		btnSubmit.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					prepare.executeUpdate();
					TestMain.UpDateTable();
					conn.close();
					dispose();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnSubmit.setBounds(152, 345, 140, 40);
		contentPane.add(btnSubmit);
		
	
	}
}
