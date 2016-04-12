<<<<<<< HEAD:SpecsProject/src/testingPackage/InsertPanel.java
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

import org.apache.poi.util.SystemOutLogger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class InsertPanel {

	private JFrame frmInsertAsset;
	//private JComboBox <String> field3;
	private static JTable testTable;
	
	// instantiating textfields for each jlabel
			JTextField field1 = new JTextField();
			
		    JTextField field2 = new JTextField();
		    JComboBox field3 = new JComboBox();
		    //test_All_Groups();
		    JTextField field4 = new JTextField();
		    JTextField field5 = new JTextField();
		    JTextField field6 = new JTextField();
		    JTextField field7 = new JTextField();
		    JComboBox field8;
		    JTextField field8a = new JTextField();
		    JTextField field8b = new JTextField();
		    JTextField field8c = new JTextField();
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
		
		frmInsertAsset = new JFrame();
		frmInsertAsset.setVisible(true);
		frmInsertAsset.getContentPane().setBackground(new Color(244, 244, 244));
		frmInsertAsset.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		frmInsertAsset.setTitle("Insert Asset");
		frmInsertAsset.setBounds(100, 100, 1504, 793);
		frmInsertAsset.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInsertAsset.setLocationRelativeTo(null);
		frmInsertAsset.getContentPane().setLayout(null);
		SpringLayout springLayout = new SpringLayout();
		frmInsertAsset.getContentPane().setLayout(springLayout);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));
		frmInsertAsset.setIconImage(icon.getImage());
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 24, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 669, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, -37, SpringLayout.SOUTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, -21, SpringLayout.EAST, frmInsertAsset.getContentPane());
		frmInsertAsset.getContentPane().add(scrollPane_1);
		
		JButton btnInsert = new JButton("Insert");
		springLayout.putConstraint(SpringLayout.WEST, btnInsert, 59, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnInsert, -23, SpringLayout.SOUTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnInsert, 239, SpringLayout.WEST, frmInsertAsset.getContentPane());
		btnInsert.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		frmInsertAsset.getContentPane().add(btnInsert);
		
		JButton btnNewButton_1 = new JButton("Clear Fields");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnInsert);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -28, SpringLayout.SOUTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 413, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 593, SpringLayout.WEST, frmInsertAsset.getContentPane());
		btnNewButton_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		frmInsertAsset.getContentPane().add(btnNewButton_1);
		

		//bullshitcomment
		
		
		// Font styling for TextFields
		Font font = new Font("Segoe UI Semilight", Font.PLAIN, 20);
	    
//		// instantiating textfields for each jlabel
//		JTextField field1 = new JTextField();
//		
//	    JTextField field2 = new JTextField();
//	    field3 = new JComboBox();
	    addCategoryColumns();
//	    JTextField field4 = new JTextField();
//	    JTextField field5 = new JTextField();
//	    JTextField field6 = new JTextField();
//	    JTextField field7 = new JTextField();
	    field8 = new JComboBox();
//	    JTextField field8a = new JTextField();
//	    JTextField field8b = new JTextField();
//	    JTextField field9 = new JTextField();
//	    JTextField field10 = new JTextField();
//	    JTextField field11 = new JTextField();
//	    JTextField field12 = new JTextField();
//	    JTextField field13 = new JTextField();
//	    JTextField field14 = new JTextField();
//	    JTextField field15 = new JTextField();
//	    JTextField field16 = new JTextField();
//	    JTextField field17 = new JTextField();
//	    JTextField field18 = new JTextField();
//	    JTextField field19 = new JTextField();
//	    JTextField field20 = new JTextField();
//	    JTextField field21 = new JTextField();
//	    JTextField field22 = new JTextField();
//	    JTextField field23 = new JTextField();
	    
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
					}
					
				}
				else//if not make all boxes uneditbale
					field3.setEditable(false);
			}
		});
	    
	    field8.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                updateState();                  

            }
        });
	    
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
	    
	    String[] ownership = {
	    		"Leased", "Owned", "Rented"
	    };
	    
	    field8.addItem(ownership[1]);
	    field8.addItem(ownership[0]);
	    field8.addItem(ownership[2]);
	    
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
	    	"Serial #:    ", field11,
	    	"Warranty Expiration:    ", field12,
	    	"Replacement Date:    ", field13,
	    	"Deactivation Date:    ", field14,
	    	"Deactivation Method:    ", field15,
	    	"Price:    ", field16,
	    	"Quality:    ", field17,
	    	"Condition:    ", field18
	    };
		//panel.setBounds(100, 100, 1439, 928);
    	
    	
    	GridLayout gl_panel = new GridLayout(0,2);
    	gl_panel.setVgap(20);
    	JPanel panel = new JPanel(gl_panel);
    	panel.setBorder(new EmptyBorder(20, 20, 20, 20));
    	panel.setBackground(new Color(244, 244, 244));
    	JScrollPane scrollPane = new JScrollPane();
    	springLayout.putConstraint(SpringLayout.NORTH, btnInsert, 23, SpringLayout.SOUTH, scrollPane);
    	springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -98, SpringLayout.SOUTH, frmInsertAsset.getContentPane());
    	springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 24, SpringLayout.NORTH, frmInsertAsset.getContentPane());
    	springLayout.putConstraint(SpringLayout.WEST, scrollPane, 15, SpringLayout.WEST, frmInsertAsset.getContentPane());
    	springLayout.putConstraint(SpringLayout.EAST, scrollPane, 636, SpringLayout.WEST, frmInsertAsset.getContentPane());
    	scrollPane.setLocation(15, 80);
    	//scrollPane.setSize(561, 610);
    	scrollPane.getVerticalScrollBar().setUnitIncrement(16);
    	scrollPane.setViewportView(panel);
    	frmInsertAsset.getContentPane().add(scrollPane);
    	
    	int i=0;
    	while (i < fields.length) {
    		JLabel label = new JLabel((String) fields[i++], JLabel.RIGHT);
    		label.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
    		panel.add(label);
    		panel.add((Component) fields[i++]);
    	}
    	

		testTable = new JTable();
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
    	
    	//testTable.getColumnModel().getColumn(1).setMinWidth(30);
    	//testTable.getColumnModel().getColumn(1).setMaxWidth(80);
    	//testTable.getColumnModel().getColumn(1).setPreferredWidth(50);
	}
	
	public static void UpDateTable() 
	{
		try 
		{
			Connection conn = sqliteConnectionTEST.dbConnector();
			DefaultTableModel dm = new DefaultTableModel();
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
	}
	
	public void addCategoryColumns() {

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;
        field3.addItem("<New Category>");

        
        try {
            stmt = conn2.createStatement(); // \"group\",price //\"group\",price
            ResultSet rs = stmt.executeQuery("SELECT Distinct \"group\" From MasterTable");

            String group = "";
            while (rs.next()) {
                group = rs.getString("Group");
                field3.addItem(group);
                
                //System.out.println("Group name: " + group);
            }
        } catch (SQLException e) {
            System.out.println("sql exception caught");
            e.printStackTrace();
        }
    }


	protected void updateState() {
	    boolean leaseEnabled = field8.getSelectedItem().equals("Leased");
	    field8a.setEnabled(leaseEnabled);
	    field8b.setEnabled(leaseEnabled);
	    
	    boolean rentEnabled = field8.getSelectedItem().equals("Rented");
	    field8c.setEnabled(rentEnabled );
	}

	public void categoriesLisnter ()
	{
		field3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getSource().equals("<New Category>"))
				{
					System.out.println("NEW");
				}
			}
		});
	}


}
=======
package testingPackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

import org.apache.poi.util.SystemOutLogger;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class newInsert{

	//private JComboBox <String> field3;
	private static JTable testTable;
	
	//init Frame and springLayout
	private JFrame frmInsertAsset = new JFrame();
	SpringLayout springLayout = new SpringLayout();
	JPanel g1_Jpanel;

	//prepare statemnt
	private PreparedStatement prepare;
	private String numSwap;
	private MaskFormatter formatter;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	
	
	// instantiating textfields for each jlabel
	JTextField field1 = new JTextField();

	JTextField field2 = new JTextField();
	JComboBox field3 = new JComboBox();
	//test_All_Groups();
	JTextField field4 = new JTextField();
	JTextField field5 = new JTextField();
	JTextField field6 = new JTextField();	
	JFormattedTextField field7;
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
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public newInsert() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 24, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 669, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, -37, SpringLayout.SOUTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, -21, SpringLayout.EAST, frmInsertAsset.getContentPane());
		frmInsertAsset.getContentPane().add(scrollPane_1);
		
		JButton btnInsert = new JButton("Insert");
		springLayout.putConstraint(SpringLayout.WEST, btnInsert, 59, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnInsert, -28, SpringLayout.SOUTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnInsert, 239, SpringLayout.WEST, frmInsertAsset.getContentPane());
		btnInsert.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		frmInsertAsset.getContentPane().add(btnInsert);
		
		JButton btnNewButton_1 = new JButton("Clear Fields");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 413, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -28, SpringLayout.SOUTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 593, SpringLayout.WEST, frmInsertAsset.getContentPane());
		btnNewButton_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		frmInsertAsset.getContentPane().add(btnNewButton_1);
	
		//bullshitcomment
	
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
					}
					
				}
				else//if not make all boxes uneditbale
					field3.setEditable(false);
			}
		});
	    
	    field8.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                updateState();                  

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
    	
    	GridLayout gl_panel = new GridLayout(0,2);
    	gl_panel.setVgap(20);
    	g1_Jpanel = new JPanel(gl_panel);
    	g1_Jpanel.setBorder(new EmptyBorder(20, 20, 20, 20));
    	g1_Jpanel.setBackground(new Color(244, 244, 244));
    	JScrollPane scrollPane = new JScrollPane();
    	springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 23, SpringLayout.SOUTH, scrollPane);
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
    	
    	//testTable.getColumnModel().getColumn(1).setMinWidth(30);
    	//testTable.getColumnModel().getColumn(1).setMaxWidth(80);
    	//testTable.getColumnModel().getColumn(1).setPreferredWidth(50);
    	
    	
    	//Inserting
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	getInsert();
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
	
	
	public static void UpDateTable() 
	{
		try 
		{
			Connection conn = sqliteConnectionTEST.dbConnector();
			DefaultTableModel dm = new DefaultTableModel(){
				@Override
				public Class getColumnClass(int c) {
					//System.out.println(getValueAt(0, c).getClass().toString());
					if(c == 3 || c == 4 )
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
						return Double.class;
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
	    boolean leaseEnabled = field8.getSelectedItem().equals("Leased");
	    field8a.setEnabled(leaseEnabled);
	    field8b.setEnabled(leaseEnabled);
	    
	    boolean rentEnabled = field8.getSelectedItem().equals("Rented");
	    field8c.setEnabled(rentEnabled );
	}

	public void getInsert()
	{
		//1 1Item Name
		field1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {

				System.out.println(field1.getText());

			}
		});

		//4 Id Tag
		field4.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				field4.setName("field4");
				System.out.println(Integer.parseInt(field4.getName().substring(5, 6)));
				getIntegerInput(field4, e);
			
			}
		});
		
		//7 Date Acquired
		field7.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				field7.setName("field7");
				getDateInput(field7, e);
				dateFocusListener(field7);
			}
		});
		
		
		//14a Deactivated JCheckBox 
		field14a.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
					field15.setEnabled(true);
				} else {//checkbox has been deselected
					field15.setEnabled(false);
				};
			}
		});


		
	
	}

//	public boolean nullCheckJTextField(JTextField jText){
//		if(jText.getText().equals(""))
//		{
//			System.out.println("NO");
//			
//		}
//		return false;
//	}
	
	/**
	 *  For all date inputs, converts user's input to sqlite's format
	 */
	public void getDateInput(JFormattedTextField jText, KeyEvent e)
	{
		jText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String input = jText.getText();
				Date date1 = null;
				SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				//field7text=dateFormat.format(sdf.parse(date1));
				try {
					//date1 = dateFormat.parse(field7.getText());

					input=sdf1.format(sdf.parse(jText.getText()));
					//System.out.println("Substring: " + jText.getText().substring(0, 10));
					prepare.setString(Integer.parseInt(jText.getName().substring(5, 6)), input);
					System.out.println(jText.getName() + ": " + jText.getValue());
					//System.out.println(input);

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//field7text = dateFormat.format(date1);
				catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				//System.out.println(jText.getText().substring(0, 10));


			}
		});
	}
	/**
	 *  Implements a focusLisnter for jtextfield param to check when box is empty
	 */
	public void dateFocusListener(JFormattedTextField jText)
	{
		jText.addFocusListener(new FocusAdapter(){
			@Override
			
			public void focusLost(FocusEvent arg0) {
				//field7.setFocusLostBehavior(JFormattedTextField.PERSIST);
				if(jText.getText().contains("  -  -    "))
				{
					//PlaceHolder
					System.out.println("----");
					System.out.println("GOT YA");
					System.out.println("----");

				}
			}
		});
	}
	
	public boolean isDateEmpty(JFormattedTextField jText)
	{
		
//		if(jText.getText().substring(0).contains(""))
//		{
//			//custom title, warning icon
//			JOptionPane.showMessageDialog(g1_Jpanel,
//			    "Eggs are not supposed to be green.",
//			    "Inane warning",
//			    JOptionPane.WARNING_MESSAGE);		}

		return false;
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
						prepare.setInt(Integer.parseInt(jText.getName().substring(5, 6)), round);
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
						prepare.setInt(Integer.parseInt(jText.getName().substring(5, 6)), round);
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
}//End of NewInsert
>>>>>>> 6ac9b7702283420cdfd820a65e2f0c29197bb0f1:SpecsProject/src/testingPackage/newInsert.java