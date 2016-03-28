package testingPackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class newInsert {

	private JFrame frmInsertAsset;
	private JComboBox <String> field3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					newInsert window = new newInsert();
//					window.display();
					window.frmInsertAsset.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public newInsert() {
		initialize();
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmInsertAsset = new JFrame();
		frmInsertAsset.getContentPane().setBackground(new Color(244, 244, 244));
		frmInsertAsset.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		frmInsertAsset.setTitle("Insert Asset");
		frmInsertAsset.setBounds(100, 100, 1439, 928);
		frmInsertAsset.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInsertAsset.setLocationRelativeTo(null);
		frmInsertAsset.getContentPane().setLayout(null);
		SpringLayout springLayout = new SpringLayout();
		frmInsertAsset.getContentPane().setLayout(springLayout);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));
		frmInsertAsset.setIconImage(icon.getImage());
		
		JScrollPane scrollPane_1 = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 135, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 602, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, 745, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, 1402, SpringLayout.WEST, frmInsertAsset.getContentPane());
		frmInsertAsset.getContentPane().add(scrollPane_1);
		
		JButton btnInsert = new JButton("Insert");
		springLayout.putConstraint(SpringLayout.NORTH, btnInsert, 778, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnInsert, 15, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnInsert, 838, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnInsert, 195, SpringLayout.WEST, frmInsertAsset.getContentPane());
		btnInsert.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		frmInsertAsset.getContentPane().add(btnInsert);
		
		JButton btnNewButton_1 = new JButton("Clear Fields");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 778, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 369, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 838, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 549, SpringLayout.WEST, frmInsertAsset.getContentPane());
		btnNewButton_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		frmInsertAsset.getContentPane().add(btnNewButton_1);
		

		// Font styling for TextFields
		Font font = new Font("Segoe UI Semilight", Font.PLAIN, 20);
	    
		// instantiating textfields for each jlabel
		JTextField field1 = new JTextField();
		
	    JTextField field2 = new JTextField();
	    field3 = new JComboBox();
	    test_All_Groups();
	    JTextField field4 = new JTextField();
	    JTextField field5 = new JTextField();
	    JTextField field6 = new JTextField();
	    JTextField field7 = new JTextField();
	    JComboBox field8 = new JComboBox();
	    JTextField field8a = new JTextField();
	    JTextField field8b = new JTextField();
	    JTextField field9 = new JTextField();
	    JTextField field10 = new JTextField();
	    JTextField field11 = new JTextField();
	    JTextField field12 = new JTextField();
	    JTextField field13 = new JTextField();
	    JTextField field14 = new JTextField();
	    JTextField field15 = new JTextField();
	    JTextField field16 = new JTextField();
	    JTextField field17 = new JTextField();
	    JTextField field18 = new JTextField();
	    JTextField field19 = new JTextField();
	    JTextField field20 = new JTextField();
	    JTextField field21 = new JTextField();
	    JTextField field22 = new JTextField();
	    JTextField field23 = new JTextField();
	    
	    field1.setFont(font);
	    field2.setFont(font);
	    field3.setFont(font);
	    field4.setFont(font);
	    field5.setFont(font);
	    field6.setFont(font);
	    field7.setFont(font);
	    field8.setFont(font);
	    field8a.setFont(font);
	    field8b.setFont(font);
	    field9.setFont(font);
	    field10.setFont(font);
	    field11.setFont(font);
	    field12.setFont(font);
	    field13.setFont(font);
	    field14.setFont(font);
	    field15.setFont(font);
	    field16.setFont(font);
	    field17.setFont(font);
	    field18.setFont(font);
	    field19.setFont(font);
	    field20.setFont(font);
	    field21.setFont(font);
	    field22.setFont(font);
	    field23.setFont(font);
	    
	    String[] categories = {
	    		""
	    };
	    
	    // array of labels and corresponding textFields for use in display()
	    Object[] fields = {
	    	"Item Name:    ", field1,
	    	"Item Description:    ", field2,
	    	"Category:    ", field3,
	    	"ID Tag:    ", field4,
	    	"Room #:    ", field5,
	    	"Floor #:    ", field6,
	    	"Date Aquired:    ", field7,
	    	"Ownership:    ", field8,
	    	"Lease Term:    ", field8a,
	    	"Lease Expiration:    ", field8b,
	    	"Supplier:    ", field9,
	    	"Manufacturer:    ", field10,
	    	"Serial #:    ", field11,
	    	"Warranty Expiration:    ", field12,
	    	"Replacement Date:    ", field13,
	    	"Deactivation Date:    ", field14,
	    	"Deactivation Method:    ", field15,
	    	"Price:    ", field16,
	    	"Quality:    ", field17,
	    	"Condition:    ", field18
	    };
		
		GridLayout gl_panel = new GridLayout(0,2);
		gl_panel.setVgap(20);
		JPanel panel = new JPanel(gl_panel);
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel.setBackground(new Color(244, 244, 244));
		panel.setBounds(100, 100, 1439, 928);
    	int i=0;
    	while (i < fields.length) {
    		JLabel label = new JLabel((String) fields[i++], JLabel.RIGHT);
    		label.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
    		panel.add(label);
    		panel.add((Component) fields[i++]);
    	}
    	JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(panel);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 135, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 15, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 745, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 556, SpringLayout.WEST, frmInsertAsset.getContentPane());
    	frmInsertAsset.getContentPane().add(scrollPane);
	}
	
	
	public void test_All_Groups() {

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement(); // \"group\",price //\"group\",price
            ResultSet rs = stmt.executeQuery("SELECT Distinct \"group\" From MasterTable");

            String group = "";
            while (rs.next()) {
                group = rs.getString("Group");
                field3.addItem(group);
                
                System.out.println("Group name: " + group);
            }
        } catch (SQLException e) {
            System.out.println("sql exception caught");
            e.printStackTrace();
        }
    }
			   
}
