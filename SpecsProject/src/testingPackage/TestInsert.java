package testingPackage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setBounds(100, 100, 264, 326);
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

		JLabel lblNewLabel = new JLabel("Insert Data Into Table Test");
		lblNewLabel.setBounds(47, 11, 162, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
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
		textField.setBounds(152, 47, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
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
		textField_1.setBounds(152, 79, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
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
		textField_2.setBounds(152, 110, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
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
		textField_3.setBounds(152, 133, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
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
		textField_4.setBounds(152, 165, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(47, 47, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel("Room");
		lblNewLabel_1.setBounds(47, 79, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblDatepurchace = new JLabel("Date_Purchase");
		lblDatepurchace.setBounds(47, 136, 93, 14);
		contentPane.add(lblDatepurchace);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBounds(47, 110, 46, 14);
		contentPane.add(lblPrice);
		
		lblType = new JLabel("Type");
		lblType.setBounds(47, 198, 46, 14);
		contentPane.add(lblType);
		
		textField_5 = new JTextField();
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
		textField_5.setBounds(152, 197, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					prepare.execute();
					testClass.UpDateTable();
					dispose();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnSubmit.setBounds(152, 227, 89, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblExpiration = new JLabel("Expiration_Date");
		lblExpiration.setBounds(47, 162, 93, 16);
		contentPane.add(lblExpiration);
		
	
	}
}
