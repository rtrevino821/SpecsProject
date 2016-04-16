package testingPackage;


import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class InsertPanel {

	//private JComboBox <String> field3;
	private static JTable testTable;
	
	//init Frame and springLayout
	private JFrame frmInsertAsset = new JFrame();
	private SpringLayout springLayout = new SpringLayout();
	private JPanel g1_Jpanel;

	//prepare statemnt
	private PreparedStatement prepare;
	private String numSwap;
	private MaskFormatter formatter;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	//For Lease and Rented
	private boolean leasedFlag;
	private boolean rentedFlag;

	// instantiating textfields for each jlabel
	private JTextField field1 = new JTextField();

	private JTextField field2 = new JTextField();
	private JComboBox field3 = new JComboBox();
	//test_All_Groups();
	private JTextField field4 = new JTextField();
	private JTextField field5 = new JTextField();
	private JTextField field6 = new JTextField();	
	private JFormattedTextField field7;
	JComboBox field8 = new JComboBox();
	JFormattedTextField field8a = new JFormattedTextField();
	JFormattedTextField field8b = new JFormattedTextField();
	JFormattedTextField field8c = new JFormattedTextField();
	JTextField field9 = new JTextField();
	JTextField field10 = new JTextField();
	JTextField field10a = new JTextField();
	JTextField field11 = new JTextField();
	JFormattedTextField field12 = new JFormattedTextField();
	JFormattedTextField field13 = new JFormattedTextField();
	JFormattedTextField field14 = new JFormattedTextField();
	JCheckBox field14a = new JCheckBox();
	JTextField field15 = new JTextField();
	JTextField field16 = new JTextField();
	JTextField field17 = new JTextField();
	JTextField field18 = new JTextField();
	JTextField field19 = new JTextField();
	JTextField field20 = new JTextField();
	JTextField field21 = new JTextField();
	JTextField field22 = new JTextField();
	JTextField field23 = new JTextField();
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					InsertPanel window = new InsertPanel();
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
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public InsertPanel() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		Connection conn = sqliteConnectionTEST.dbConnector();
		initialize();
		UpDateTable();
		
	}
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Connection conn = sqliteConnectionTEST.dbConnector();
		setFrame();
		initPrepareStatment();
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 24, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 669, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, -37, SpringLayout.SOUTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, -21, SpringLayout.EAST, frmInsertAsset.getContentPane());
		frmInsertAsset.getContentPane().add(scrollPane_1);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.setLocation(15, 662);
		springLayout.putConstraint(SpringLayout.WEST, btnInsert, 15, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnInsert, -28, SpringLayout.SOUTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnInsert, 202, SpringLayout.WEST, frmInsertAsset.getContentPane());
		btnInsert.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		frmInsertAsset.getContentPane().add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		springLayout.putConstraint(SpringLayout.NORTH, btnUpdate, 0, SpringLayout.NORTH, btnInsert);
		springLayout.putConstraint(SpringLayout.WEST, btnUpdate, 38, SpringLayout.EAST, btnInsert);
		springLayout.putConstraint(SpringLayout.SOUTH, btnUpdate, -28, SpringLayout.SOUTH, frmInsertAsset.getContentPane());
		btnUpdate.setLocation(275, 662);
    	btnUpdate.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
    	frmInsertAsset.getContentPane().add(btnUpdate);
    	
    	
		
		JButton btnNewButton_1 = new JButton("Clear Fields");
		springLayout.putConstraint(SpringLayout.EAST, btnUpdate, -37, SpringLayout.WEST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnInsert);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 457, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -28, SpringLayout.SOUTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -32, SpringLayout.WEST, scrollPane_1);
		btnNewButton_1.setLocation(413, 653);
		btnNewButton_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		frmInsertAsset.getContentPane().add(btnNewButton_1);
	
		
	
	    addCategoryColumns();

	    field3.setSelectedIndex(-1);
	    field3.addActionListener(new ActionListener(){
			@Override
			//new category is clicked, remove it from combobox, insert a blank string and set it that item
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				if(cb.getSelectedItem().equals("<New Category>"))
				{
					field3.removeItem("<New Category>");
					field3.insertItemAt("", 0);
					field3.setSelectedItem("");
				}
				else{
					System.out.println(field3.getSelectedItem());
					try {
						prepare.setString(3, field3.getSelectedItem().toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
					
			}
	    });
		field3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				//after combobox is inserted with "", it will enable user to edit field
				if(e.getItem().equals(""))
				{	
					if(e.getStateChange() == ItemEvent.SELECTED)
					{
	                    field3.getEditor().setItem("");
	                    field3.setEditable(true);
					}
					else
					{
	                    System.out.println(field3.getEditor().getItem().toString());
	                    try {
							prepare.setString(3, field3.getEditor().getItem().toString());
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
				else//if not make all boxes uneditbale
					field3.setEditable(false);
			}
		});
	    
	    field8.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            	if(e.getItem().equals("Owned"))
            	{
            		try {
						prepare.setString(8, "Owned");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            	else if((e.getItem().equals("Leased")))
            	{
            		try {
						prepare.setString(8, "Leased");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            	else if((e.getItem().equals("Rented")))
            	{
            		try {
						prepare.setString(8, "Rented");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
      
                updateState();                  
                if (leasedFlag == false) {
                	//8b Lease Expiration
                	try {//default behavior assumed field is empty
                		prepare.setNull(9, Types.NULL);
                		prepare.setNull(10, Types.NULL);
                		
                	} catch (SQLException e1) {
                		// TODO Auto-generated catch block
                		e1.printStackTrace();
                	} 
                }
                if(rentedFlag == false)
				{
            		try {
						prepare.setNull(11, Types.NULL);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					
				}
            }
        });
	    
	    String[] ownership = {
	    		"Leased", "Owned", "Rented"
	    };
	    
	    field8.addItem(ownership[1]);
	    field8.addItem(ownership[0]);
	    field8.addItem(ownership[2]);
	    
	    //Adding mask to Date textFields
		try {
			formatter = new MaskFormatter("##'-##'-####");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		field7 = new JFormattedTextField(formatter);
		field8a  = new JFormattedTextField(formatter);
		field8a.setEnabled(false);
		field8b  = new JFormattedTextField(formatter);
		field8b.setEnabled(false);
		field8c  = new JFormattedTextField(formatter);
		field8c.setEnabled(false);
		field12 = new JFormattedTextField(formatter);
		field13 = new JFormattedTextField(formatter);
		field14 = new JFormattedTextField(formatter);
		field8a.setFocusLostBehavior(JFormattedTextField.COMMIT);
		field8b.setFocusLostBehavior(JFormattedTextField.COMMIT);
		field8c.setFocusLostBehavior(JFormattedTextField.COMMIT);
		field12.setFocusLostBehavior(JFormattedTextField.COMMIT);
		field7.setFocusLostBehavior(JFormattedTextField.COMMIT);
		field13.setFocusLostBehavior(JFormattedTextField.COMMIT);
		field14.setFocusLostBehavior(JFormattedTextField.COMMIT);

		field15.setEnabled(false);

	    
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
	    	"Rent Due Date:    ", field8c,
	    	"Supplier:    ", field9,
	    	"Manufacturer:    ", field10,
	    	"Model #:    ",field10a,
	    	"Serial #:    ", field11,
	    	"Warranty Expiration:    ", field12,
	    	"Replacement Date:    ", field13,
	    	"Deactivation Date:    ", field14,
	    	"Deactivated:    ",field14a,
	    	"Deactivation Method:    ", field15,
	    	"Price:    ", field16,
	    	"Quality:    ", field17,
	    	"Condition:    ", field18
	    };
		//panel.setBounds(100, 100, 1439, 928);
    	setFont();
    	setTextFieldName();
    	
    	GridLayout gl_panel = new GridLayout(0,2);
    	gl_panel.setVgap(20);
    	g1_Jpanel = new JPanel(gl_panel);
    	g1_Jpanel.setBorder(new EmptyBorder(20, 20, 20, 20));
    	g1_Jpanel.setBackground(new Color(244, 244, 244));
    	JScrollPane scrollPane = new JScrollPane();
    	springLayout.putConstraint(SpringLayout.NORTH, btnInsert, 23, SpringLayout.SOUTH, scrollPane);
    	springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -98, SpringLayout.SOUTH, frmInsertAsset.getContentPane());
    	springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 24, SpringLayout.NORTH, frmInsertAsset.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, scrollPane, 15, SpringLayout.WEST, frmInsertAsset.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, scrollPane, 636, SpringLayout.WEST, frmInsertAsset.getContentPane());
    	scrollPane.setLocation(15, 80);
    	//scrollPane.setSize(561, 610);
    	scrollPane.getVerticalScrollBar().setUnitIncrement(16);
    	
    	
    	scrollPane.setViewportView(g1_Jpanel);
    	frmInsertAsset.getContentPane().add(scrollPane);
    	
    	int i=0;
    	while (i < fields.length) {
    		JLabel label = new JLabel((String) fields[i++], JLabel.RIGHT);
    		label.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
    		g1_Jpanel.add(label);
    		g1_Jpanel.add((Component) fields[i++]);
    	}
    	

		testTable = new JTable(){
			
		};
		testTable.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		
		 ((DefaultCellEditor) testTable.getDefaultEditor(Object.class))
         .getComponent().setFont(testTable.getFont());
		 
		testTable.getTableHeader().setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		testTable.setRowHeight(testTable.getRowHeight() + 20);
		testTable.putClientProperty("terminateEditOnFocusLost", true);
		scrollPane_1.setViewportView(testTable);
		//testTable.setAutoCreateColumnsFromModel(true);
		testTable.setAutoCreateRowSorter(true);
    	testTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    	testTable.getTableHeader().setReorderingAllowed(false);
    	
    	//testTable.getColumnModel().getColumn(1).setMinWidth(30);
    	//testTable.getColumnModel().getColumn(1).setMaxWidth(80);
    	//testTable.getColumnModel().getColumn(1).setPreferredWidth(50);
    	
    	
    	//Inserting
		
    	getInsert();

    	insertingFields(btnInsert);
    	

    	
    	
    	btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prepare = null;
				try {
					//int row = testTable.getSelectedRow();
					
					//if(testTable.getModel().getValueAt(row, 0) != null)
						 //String value1 = field1.getText();
					
					String value1 = field1.getText();
					String value2 = field2.getText();
					String value3 = field3.getSelectedItem().toString();
					String value4 = field4.getText();
					String value5 = field5.getText();
					String value6 = field6.getText();
					String value7 = field7.getText();
					String value8 = field8.getSelectedItem().toString();

					String sql = "Update MasterTable set Item_Name='" + value1 + "' , Item_Description ='" + value2
							+ "' , Category ='" + value3 + "' ,ID_Tag ='" + value4 + "' ,Room ='" + value5
							+ "' ,Floor ='" + value6 + "' ,Date_Acquired ='" + value7 + "',Ownership ='" + value8
							+ "' where ID_Tag ='" + value4 + "'";
					System.out.println(sql);
					prepare = conn.prepareStatement(sql);
					prepare.execute();
					JOptionPane.showMessageDialog(null, "Updated");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e);
				}
				UpDateTable();
			}
		});
    	
    	
    	
    	testTable.addMouseListener(new MouseAdapter() {
//
//			// Program that when the mouse clicks a spot of the table autofills
//			// the textboxes
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				try {
					int row = testTable.getSelectedRow();					

					//Gets text from row and fills jtext if cell is not empty

					if(testTable.getModel().getValueAt(row, 0) != null)
						field1.setText(testTable.getModel().getValueAt(row, 0).toString());
					if(testTable.getModel().getValueAt(row, 1) != null)
						field2.setText(testTable.getModel().getValueAt(row, 1).toString());
					if(testTable.getModel().getValueAt(row, 2) != null)
						field3.setSelectedItem(testTable.getModel().getValueAt(row, 2).toString());
					if(testTable.getModel().getValueAt(row, 3) != null)
						field4.setText(testTable.getModel().getValueAt(row, 3).toString());
					if(testTable.getModel().getValueAt(row, 4) != null)
						field5.setText(testTable.getModel().getValueAt(row, 4).toString());
					if(testTable.getModel().getValueAt(row, 5) != null)
						field6.setText(testTable.getModel().getValueAt(row, 5).toString());
					if(testTable.getModel().getValueAt(row, 6) != null)
						field7.setText(testTable.getModel().getValueAt(row, 6).toString());
					if(testTable.getModel().getValueAt(row, 7) != null)
						field8.setSelectedItem(testTable.getModel().getValueAt(row, 7).toString());
					if(testTable.getModel().getValueAt(row, 8) != null)
						field8a.setText(testTable.getModel().getValueAt(row, 8).toString());
					if(testTable.getModel().getValueAt(row, 9) != null)
						field8b.setText(testTable.getModel().getValueAt(row, 9).toString());
					if(testTable.getModel().getValueAt(row, 10) != null)
						field8c.setText(testTable.getModel().getValueAt(row, 10).toString());
					if(testTable.getModel().getValueAt(row, 11) != null)
						field9.setText(testTable.getModel().getValueAt(row, 11).toString());
					if(testTable.getModel().getValueAt(row, 12) != null)
						field10.setText(testTable.getModel().getValueAt(row, 12).toString());
					if(testTable.getModel().getValueAt(row, 13) != null)
						field10a.setText(testTable.getModel().getValueAt(row, 13).toString());
					if(testTable.getModel().getValueAt(row, 14) != null)
						field11.setText(testTable.getModel().getValueAt(row, 14).toString());
					if(testTable.getModel().getValueAt(row, 15) != null)
						field12.setText(testTable.getModel().getValueAt(row, 15).toString());
					if(testTable.getModel().getValueAt(row, 16) != null)
						field13.setText(testTable.getModel().getValueAt(row, 16).toString());
					if(testTable.getModel().getValueAt(row, 17) != null)
						field14.setText(testTable.getModel().getValueAt(row, 17).toString());
					if(testTable.getModel().getValueAt(row, 18) != null)
						field14a.setSelected((testTable.getModel().getValueAt(row, 18).toString() == "YES"));
					if(testTable.getModel().getValueAt(row, 19) != null)
						field15.setText(testTable.getModel().getValueAt(row, 19).toString());
					if(testTable.getModel().getValueAt(row, 20) != null)
						field16.setText(testTable.getModel().getValueAt(row, 20).toString());
					if(testTable.getModel().getValueAt(row, 21) != null)
						field17.setText(testTable.getModel().getValueAt(row, 21).toString());
					if(testTable.getModel().getValueAt(row, 22) != null)
						field18.setText(testTable.getModel().getValueAt(row, 22).toString());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
	}
	
	private void insertingFields(JButton btnInsert) {
		btnInsert.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					prepare.executeUpdate();
					UpDateTable();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
    		
    	});		
	}

	public void setFrame()
	{
		frmInsertAsset.setVisible(true);
		frmInsertAsset.getContentPane().setBackground(new Color(244, 244, 244));
		frmInsertAsset.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		frmInsertAsset.setTitle("Insert Asset");
		frmInsertAsset.setBounds(100, 100, 1504, 793);
		frmInsertAsset.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInsertAsset.setLocationRelativeTo(null);
		frmInsertAsset.getContentPane().setLayout(null);
		frmInsertAsset.getContentPane().setLayout(springLayout);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));
		frmInsertAsset.setIconImage(icon.getImage());
	}
	
	public void setFont(){
		// Font styling for TextFields
		Font font = new Font("Segoe UI Semilight", Font.PLAIN, 20);
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
	    field8c.setFont(font);
	    field9.setFont(font);
	    field10.setFont(font);
	    field10a.setFont(font);
	    field11.setFont(font);
	    field12.setFont(font);
	    field13.setFont(font);
	    field14.setFont(font);
	    field14a.setFont(font);
	    field15.setFont(font);
	    field16.setFont(font);
	    field17.setFont(font);
	    field18.setFont(font);
	    field19.setFont(font);
	    field20.setFont(font);
	    field21.setFont(font);
	    field22.setFont(font);
	    field23.setFont(font);
	}
	public void setTextFieldName()
	{
		field1.setName("1");
		field2.setName("2");
		field3.setName("3");
		field4.setName("4");
		field5.setName("5");
		field6.setName("6");
		field7.setName("7");
		field8.setName("8");
		field8a.setName("9");
		field8b.setName("10");
		field8c.setName("11");
		field9.setName("12");
		field10.setName("13"); 
		field10a.setName("14"); 
		field11.setName("15");
		field12.setName("16");
		field13.setName("17");
		field14.setName("18");
		field14a.setName("19");
		field15.setName("20");
		field16.setName("21");
		field17.setName("22");
		field18.setName("23");
		field19.setName("field19");
		field20.setName("field20");
		field21.setName("field21");
		field22.setName("field22");
		field23.setName("field23");

	}
	
	
	public static void UpDateTable() 
	{
		try 
		{
			Connection conn = sqliteConnectionTEST.dbConnector();
			DefaultTableModel dm = new DefaultTableModel(){
				@Override
				public Class getColumnClass(int c) {
					//System.out.println(getValueAt(0, c).getClass().toString());
					if(c == 3)
					{
						return Integer.class;
					}
					else if(c==6||c==8||c==9||c==10|
							c==15||c==16||c==17)
					{
						return String.class;
					}
					else if(c==20)
					{
						return Integer.class;
					}
					else
						return String.class;
			
			}
				
			};
	        //query and resultset
			String testTable_String = "Select * from MasterTable";
			PreparedStatement showTestTable = conn.prepareStatement(testTable_String);
			ResultSet rsTest = showTestTable.executeQuery();
			addRowsAndColumns(rsTest, dm);
			
			testTable.setModel(dm);
			
			//testTable.setModel(DbUtils.resultSetToTableModel(rsTest));

			//Refresh the table
		   // tableModel.fireTableStructureChanged();
			//testTable.setModel(tableModel);
			refreshScreen();
			//System.out.println(tableModel.getRowCount());
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public static void addRowsAndColumns(ResultSet rs, DefaultTableModel dm) throws SQLException
	{
        ResultSetMetaData rsmd=rs.getMetaData();
        //Coding to get columns-
        int cols=rsmd.getColumnCount();
        String c[]=new String[cols];
        for(int i=0;i<cols;i++){
            c[i]=rsmd.getColumnName(i+1);
            dm.addColumn(c[i]);
        }
        
        Object row[]=new Object[cols];
        while(rs.next()){
             for(int i=0;i<cols;i++){
            	 if(i==3)
            	 {
                     row[i]=Integer.parseInt(rs.getString(4));

            	 }
            	 else
                    row[i]=rs.getString(i+1);
                }
            dm.addRow(row);
        }
	}
	public static void refreshScreen()
	{
		testTable.revalidate();
		testTable.repaint();
		testTable.validate();//
		
		testTable.getColumnModel().getColumn(0).setPreferredWidth(280);
		testTable.getColumnModel().getColumn(1).setPreferredWidth(80);
		testTable.getColumnModel().getColumn(2).setPreferredWidth(320);
		testTable.getColumnModel().getColumn(3).setPreferredWidth(180);
		testTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		testTable.getColumnModel().getColumn(5).setPreferredWidth(120);
		testTable.getColumnModel().getColumn(6).setPreferredWidth(220);
		testTable.getColumnModel().getColumn(7).setPreferredWidth(180);
		testTable.getColumnModel().getColumn(8).setPreferredWidth(180);
		testTable.getColumnModel().getColumn(9).setPreferredWidth(220);
		testTable.getColumnModel().getColumn(10).setPreferredWidth(320);
		testTable.getColumnModel().getColumn(11).setPreferredWidth(320);
		testTable.getColumnModel().getColumn(12).setPreferredWidth(180);
		//Edit
		testTable.getColumnModel().getColumn(13).setPreferredWidth(180);
		testTable.getColumnModel().getColumn(14).setPreferredWidth(180);
		testTable.getColumnModel().getColumn(15).setPreferredWidth(180);
		testTable.getColumnModel().getColumn(16).setPreferredWidth(180);
		testTable.getColumnModel().getColumn(17).setPreferredWidth(180);
		testTable.getColumnModel().getColumn(18).setPreferredWidth(180);
		testTable.getColumnModel().getColumn(19).setPreferredWidth(180);
		testTable.getColumnModel().getColumn(20).setPreferredWidth(180);
		testTable.getColumnModel().getColumn(21).setPreferredWidth(180);
		testTable.getColumnModel().getColumn(22).setPreferredWidth(360);

	}
	
	public void addCategoryColumns() {

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;
        field3.addItem("<New Category>");

        
        try {
            stmt = conn2.createStatement(); // \"group\",price //\"group\",price
            ResultSet rs = stmt.executeQuery("SELECT Distinct Category From MasterTable");

            String group = "";
            while (rs.next()) {
                group = rs.getString("Category");
                field3.addItem(group);
                
                //System.out.println("Group name: " + group);
            }
        } catch (SQLException e) {
            System.out.println("sql exception caught");
            e.printStackTrace();
        }
    }


	protected void updateState() {
		boolean leaseEnabled;
		boolean rentEnabled;
		if(	leaseEnabled = field8.getSelectedItem().equals("Leased"))
		{
			field8a.setEnabled(leaseEnabled);
			field8b.setEnabled(leaseEnabled);
			leasedFlag = true;
		}
		else
		{
			field8a.setEnabled(leaseEnabled);
			field8b.setEnabled(leaseEnabled);
			leasedFlag = false;

//			field8a = new JFormattedTextField(formatter);
//			field8b = new JFormattedTextField(formatter);
		}

		if(rentEnabled = field8.getSelectedItem().equals("Rented")){
			field8c.setEnabled(rentEnabled );
			rentedFlag = true;
		}
		else{
			//field8c = new JFormattedTextField(formatter);
			field8c.setEnabled(rentEnabled );
			rentedFlag = false;

		}

	}
	

	public void getInsert()
	{
		stringTextBox();
		dateTextBox();
		//4 Id Tag
		field4.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				//System.out.println(Integer.parseInt(field4.getName().substring(0, 1)));
				getIntegerInput(field4, e);
			
			}
		});
		
		
		
		//14a Deactivated JCheckBox 
		field14a.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
					field15.setEnabled(true);
					try {
						prepare.setString(19, "YES");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {//checkbox has been deselected
					field15.setEnabled(false);
					try {
						prepare.setString(19, "NO");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				};
			}
		});
		
		field16.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				//System.out.println(Integer.parseInt(field4.getName().substring(0, 1)));
				getDoubleInput(field16, e);
			
			}
		});
		
	}


	private void dateTextBox(){
		//7 Date Acquired
		dateFocusListener(field7);
		field7.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getDateInput(field7, e);
			}
		});
		//8a LeaseTerm
		dateFocusListener(field8a);
		field8a.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getDateInput(field8a, e);

			}
		});
		//8b Lease Expiration
		dateFocusListener(field8b);			
		field8b.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getDateInput(field8b, e);
			}
		});
		//8c Rent
		dateFocusListener(field8c);
		field8c.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getDateInput(field8c, e);
			}
		});
		//12 Warranty Expiration
		dateFocusListener(field12);
		field12.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getDateInput(field12, e);
			}
		});
		//13 Replacement Expiration
		dateFocusListener(field13);
		field13.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getDateInput(field13, e);
			}
		});
		//14 Deactivation Date
		dateFocusListener(field14);
		field14.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getDateInput(field14, e);
			}
		});

	}
	
	private void stringTextBox() {
		//1 1Item Name
		field1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getStringInput(field1, e);
				stringFocusLost(field1);
			}
		});
		//2 Item Description
		field2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getStringInput(field2, e);
				stringFocusLost(field2);

			}
		});
		//6 Floor
		field6.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getStringInput(field6, e);
				stringFocusLost(field6);

			}
		});
		//9 Supplier
		field9.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getStringInput(field9, e);
				stringFocusLost(field9);

			}
		});
		//10 Manufactor
		field10.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getStringInput(field10, e);
				stringFocusLost(field10);

			}
		});
		//10a Model
		field10a.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getStringInput(field10a, e);
				stringFocusLost(field10a);

			}
		});
		field11.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getStringInput(field11, e);
				stringFocusLost(field11);

			}
		});
		//15 Deactivation Method
		field15.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getStringInput(field15, e);
				stringFocusLost(field15);

			}
		});
		//Quality
		field17.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getStringInput(field17, e);
				stringFocusLost(field17);

			}
		});
		//Condition
		field18.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				getStringInput(field18, e);
				stringFocusLost(field18);

			}
		});
		
	}

	public void stringFocusLost(JTextField jText)
	{
		jText.addFocusListener(new FocusAdapter(){
			@Override
			
			public void focusLost(FocusEvent arg0) {
				//field7.setFocusLostBehavior(JFormattedTextField.PERSIST);
				if(jText.getText().contains(""))
				{
					try {
						prepare.setString(Integer.parseInt(jText.getName()), jText.getText());
						System.out.println("EMpty Field");
					} catch (NumberFormatException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
	}
	
	/**
	 *  Gets Input from Textfield and preparedStatment sets String on that value
	 */
	public void getStringInput(JTextField jText, KeyEvent e)
	{
		try {
			prepare.setString(Integer.parseInt(jText.getName()), jText.getText());
			System.out.println("TextBox: Field" + jText.getName() + "\nValue: " + jText.getText());
		} catch (NumberFormatException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	
	/**
	 *  For all date inputs, converts user's input to sqlite's format
	 */
	public void getDateInput(JFormattedTextField jText, KeyEvent e)
	{
		jText.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) {
				String input = jText.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				if(jText.getName().equals(field8b.getName()))
				{//For Lease expiration
					try{
						leasedValidation(jText, sdf,sdf1,input);
					}
					catch(NullPointerException np)
					{
//						DefaultFormatterFactory factory = new DefaultFormatterFactory(formatter);
//						 jText.setFormatterFactory(factory);
					}
				}// End of If Statement
				
				
				
				else{//for dates that are not expiring
					try {
						//date1 = dateFormat.parse(field7.getText());

						input=sdf1.format(sdf.parse(jText.getText().toString()));
						//System.out.println("Substring: " + jText.getText().substring(0, 10));
						prepare.setString(Integer.parseInt(jText.getName()), input);
						System.out.println(jText.getName() + ": " + jText.getText());
						//System.out.println(input);

					} catch (ParseException e1) {
//						DefaultFormatterFactory factory = new DefaultFormatterFactory(formatter);
//						 jText.setFormatterFactory(factory);
					}
					//field7text = dateFormat.format(date1);
					catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
	}
	/**
	 *  Implements a focusLisnter for jtextfield param to check when box is empty
	 */
	public void dateFocusListener(JFormattedTextField jText)
	{
		//regular expression for mm/dd/yyyy
		String regex = "\\d\\d\\d\\d\\W\\d\\d\\W\\d\\d" ;
		String yearPattern ="\\d\\d\\d\\d";
		String dayPattern ="\\d\\d";

		Pattern p = Pattern.compile(regex);
		Pattern pYear = Pattern.compile(yearPattern);
		Pattern pDay = Pattern.compile(dayPattern);
		jText.addFocusListener(new FocusAdapter(){
			@Override
			public void focusLost(FocusEvent arg0) {
				//When user empties field, prevent it from reverting
				System.out.println();
//				jText.addPropertyChangeListener(new PropertyChangeListener()
//				{
//
//					@Override
//					public void propertyChange(PropertyChangeEvent evt) {
//						if(evt.getSource().equals(field7))
//						System.out.println("NameField: " + jText.getName() + "\n"+ evt.getOldValue().toString());
//						System.out.println("NameField: " + jText.getName() + "\n newValue"+ evt.getNewValue().toString());
//						
//					}
//					
//				});
				if(jText.getText().contains("  -  -    ") && jText.getName().equals("7"))
				{
					//PlaceHolder
					//jText.setFocusLostBehavior(JFormattedTextField.PERSIST);
					 DefaultFormatterFactory factory = new DefaultFormatterFactory(formatter);
					 jText.setFormatterFactory(factory);
					
				}
				
				if(!(jText.getText().substring(0,2).matches(dayPattern) &&
				   jText.getText().substring(3,5).matches(dayPattern) &&
				   jText.getText().substring(6,10).matches(yearPattern)))
				{
					DefaultFormatterFactory factory = new DefaultFormatterFactory(formatter);
					jText.setFormatterFactory(factory);
					jText.setValue(null);
					try {
						prepare.setNull(Integer.parseInt(jText.getName()), Types.NULL);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(jText.getText().contains("  -  -    "))
				{
					DefaultFormatterFactory factory = new DefaultFormatterFactory(formatter);
					jText.setFormatterFactory(factory);
					jText.setValue(null);
					try {
						prepare.setNull(Integer.parseInt(jText.getName()), Types.NULL);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		});
		//sets textfield to default behavior
		//jText.setFocusLostBehavior(JFormattedTextField.COMMIT);

	}
	
	
	/**
	 *  Verifies that integers are only accept in textboxW
	 */
	public void getIntegerInput(JTextField jText, KeyEvent e){
		numSwap = null;

		jText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String temp = jText.getText();
				//only accepts positives doubles
				
				String regex = "(?<![-.])\\b[0-9]+\\b(?!\\.[0-9])";

//				(?<![-.])   # Assert that the previous character isn't a minus sign or a dot.
//				\b          # Anchor the match to the start of a number.
//				[0-9]+      # Match a number.
//				\b          # Anchor the match to the end of the number.
//				(?!\.[0-9]) # Assert that no decimal part follows.

				if(temp.matches(regex))
				{
					numSwap = temp;
					int round = (Integer.parseInt(jText.getText()));
					try {
						prepare.setInt(Integer.parseInt(jText.getName()), round);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else if((e.getKeyCode() == KeyEvent.VK_BACK_SPACE) || (e.getKeyCode() == KeyEvent.VK_DELETE) 
						&& temp.length() == 0)
			    {//deletes the element in textbox
					jText.setText("");
					numSwap="";
			    }
				else if(temp.length() == 0)
				{//empties textbox
					jText.setText("");
					numSwap="";
				}
				else{
					jText.setText(numSwap);
				}

			}
		});
	}//End of Method
	
	/**
	 *  Verifies that Doubles are only accept in textbox
	 */
	public void getDoubleInput(JTextField jText, KeyEvent e){
		numSwap = null;

		jText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String temp = jText.getText();
				//only accepts positives doubles

				String regex = "^[0-9.]+([,.][0-9]+)?$";

				//				(?<![-.])   # Assert that the previous character isn't a minus sign or a dot.
				//				\b          # Anchor the match to the start of a number.
				//				[0-9]+      # Match a number.
				//				\b          # Anchor the match to the end of the number.
				//				(?!\.[0-9]) # Assert that no decimal part follows.

				if(temp.matches(regex))
				{
					numSwap = temp;
					int round = (Integer.parseInt(jText.getText()));
					try {
						prepare.setInt(Integer.parseInt(jText.getName()), round);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if((e.getKeyCode() == KeyEvent.VK_BACK_SPACE) || (e.getKeyCode() == KeyEvent.VK_DELETE) 
						&& temp.length() == 0)
				{//deletes the element in textbox
					jText.setText("");
					numSwap="";
				}
				else if(temp.length() == 0)
				{//empties textbox
					jText.setText("");
					numSwap="";
				}
				else{
					jText.setText(numSwap);
				}

			}
		});		
	}//End of Method
	public void dateValidation(JFormattedTextField jText,String input,SimpleDateFormat sdf, SimpleDateFormat sdf1)
	{
		Date date2 = null;		
		//regular expression for mm/dd/yyyy
		String regex = "\\d\\d\\d\\d\\W\\d\\d\\W\\d\\d" ;
		String yearPattern ="\\d\\d\\d\\d";
		String dayPattern ="\\d\\d";
		//compile patterns 
		Pattern p = Pattern.compile(regex);
		Pattern pYear = Pattern.compile(yearPattern);
		Pattern pDay = Pattern.compile(dayPattern);
		
		try {
			input=sdf1.format(sdf.parse(jText.getText().toString()));
			date2 = sdf.parse(jText.getText().toString());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Matcher m = p.matcher(date2.toLocaleString());
		if(m.find())
		{
			if(jText.getText().substring(0,2).matches(dayPattern) &&
			   jText.getText().substring(3,5).matches(dayPattern) &&
	           jText.getText().substring(6,10).matches(yearPattern))
			{
				 System.out.println("FIELD 7 VALID");

			}
			else
			{
				DefaultFormatterFactory factory = new DefaultFormatterFactory(formatter);
				 jText.setFormatterFactory(factory);
				 System.out.println("FIELD 7 Else");
			}
		}

		
	}
	public void leasedValidation(JFormattedTextField jText, SimpleDateFormat sdf, SimpleDateFormat sdf1, String input)
	{
		String leaseTerm = null;
		Date date1 = null;
		Date date2 = null;
		//regular expression for mm/dd/yyyy
		String regex = "\\d\\d\\d\\d\\W\\d\\d\\W\\d\\d" ;
		String yearPattern ="\\d\\d\\d\\d";
		String dayPattern ="\\d\\d";

		//
		Pattern p = Pattern.compile(regex);
		Pattern pYear = Pattern.compile(yearPattern);
		Pattern pDay = Pattern.compile(dayPattern);

	   //pase input for date	
		try {
			leaseTerm =sdf1.format(sdf.parse(field8a.getText()));
			date1 = sdf.parse(field8a.getText());
			input=sdf1.format(sdf.parse(jText.getText()));
			date2 = sdf.parse(jText.getText().toString());

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

		Matcher m = p.matcher(date2.toLocaleString());
		if(m.find())
		{
			
			if(date1.before(date2))
			{//Verified Lease Expiratin is before date
				try {
					System.out.println(jText.getName() + ": " + jText.getText());
					jText.setBackground(Color.green);

					prepare.setString(Integer.parseInt(jText.getName()), input);
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block]\[
					e1.printStackTrace();
				}
			}
			//Handles invalid input for when input matches and is not after lease term
			else if(jText.getText().substring(0,2).matches(dayPattern) &&
					jText.getText().substring(3,5).matches(dayPattern) &&
					jText.getText().substring(6,10).matches(yearPattern) &&
					!date1.before(date2))						   
			{
				
				 DefaultFormatterFactory factory = new DefaultFormatterFactory(formatter);
				 jText.setFormatterFactory(factory);
				 jText.setBackground(Color.red);
			}
		}//End of m.find		
	}//End of Method
	
	public void initPrepareStatment()
	{
		Connection conn = sqliteConnectionTEST.dbConnector();
		prepare = null;
		
     	String query = "insert into MasterTable (Item_Name,Item_Description,Category,ID_Tag,Room,"//1-5
     			+ "Floor, Date_Acquired, Ownership, Lease_Term,Lease_Expiration,"//5-10
     			+ "Rent_Due_Date,Supplier,Manufacturer,Model_Number,Serial_Number,"//10-15
     			+ "Warranty_Expiration_Date,Replacement_Date,Deactivation_Date,Deactivated,Deactivation_Method,"//15-20
     			+ "Price, Condition,Quality)"//20-23
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?)";  //removed asset over 500 //removed picture
			
     	try {
			prepare = conn.prepareStatement(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}//End of NewInsert
