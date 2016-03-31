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
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.apache.poi.util.SystemOutLogger;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class newInsert{

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
