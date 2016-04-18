<<<<<<< HEAD
=======
//
//package testingPackage;
//
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Dimension;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JTabbedPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.JScrollPane;
//import javax.swing.ComboBoxModel;
//import javax.swing.DefaultCellEditor;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//
//import java.awt.Font;
//import java.awt.GridLayout;
//
//import javax.swing.border.LineBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableColumnModel;
//
////import org.apache.poi.util.SystemOutLogger;
//
//import java.awt.SystemColor;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//
//import javax.swing.ScrollPaneConstants;
//import javax.swing.UIManager;
//import javax.swing.UnsupportedLookAndFeelException;
//import javax.swing.JPanel;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.SpringLayout;
//import javax.swing.border.EmptyBorder;
//import java.awt.LayoutManager;
//import javax.swing.BoxLayout;
//import javax.swing.SwingConstants;
//
//public class reportsFrame{
//
//	private JFrame reportFrame;
//	//private JComboBox <String> field3;
//	private static JTable testTable;
//	
//	// instantiating textfields for each jlabel
//			JComboBox assetQuery = new JComboBox();
//		    JTextField roomNo = new JTextField();
//		    JTextField year = new JTextField();
//		    JTextField yearStart = new JTextField();
//		    JTextField yearEnd = new JTextField();
//		    JComboBox categoryAsset = new JComboBox();
//		    
//		    JComboBox deactivatedQuery = new JComboBox();
//		    JComboBox categoryDeactivated = new JComboBox();
//		    
//		    JComboBox categoryQuery = new JComboBox();
//		    JComboBox category = new JComboBox();
//		    
//		    JComboBox expiredQuery = new JComboBox();
//		    JTextField yearExpired = new JTextField();
//		    
//		    JLabel empty = new JLabel(" ");
//
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//					reportsFrame window = new reportsFrame();
////					window.display();
//					window.reportFrame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 * @throws UnsupportedLookAndFeelException 
//	 * @throws IllegalAccessException 
//	 * @throws InstantiationException 
//	 * @throws ClassNotFoundException 
//	 */
//	public reportsFrame() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
//		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//		Connection conn = sqliteConnectionTEST.dbConnector();
//		initialize();
//		UpDateTable();
//		
//	}
//	
//	
//	
//	
//	/**
//	 * Initialize the contents of the frame.
//	 */
//	private void initialize() {
//		
//		Connection conn = sqliteConnectionTEST.dbConnector();
//		
//		reportFrame = new JFrame();
//		reportFrame.setVisible(true);
//		reportFrame.getContentPane().setBackground(new Color(244, 244, 244));
//		reportFrame.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
//		reportFrame.setTitle("Reports");
//		reportFrame.setBounds(100, 100, 1504, 793);
//		reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		reportFrame.setLocationRelativeTo(null);
//		reportFrame.getContentPane().setLayout(null);
//		reportFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//		SpringLayout springLayout = new SpringLayout();
//		reportFrame.getContentPane().setLayout(springLayout);
//		
//		ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));
//		reportFrame.setIconImage(icon.getImage());
//		
//		JScrollPane scrollPane_1 = new JScrollPane();
//		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 720, SpringLayout.WEST, reportFrame.getContentPane());
//		scrollPane_1.setSize(792, 616);
//		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 24, SpringLayout.NORTH, reportFrame.getContentPane());
//		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, -98, SpringLayout.SOUTH, reportFrame.getContentPane());
//		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, -21, SpringLayout.EAST, reportFrame.getContentPane());
//		reportFrame.getContentPane().add(scrollPane_1);
//		
//
//		//bullshitcomment
//		
//		
//		// Font styling for TextFields
//		Font font = new Font("Segoe UI Semilight", Font.PLAIN, 20);
//	    
////		// instantiating textfields for each jlabel
////		JTextField field1 = new JTextField();
////		
////	    JTextField field2 = new JTextField();
////	    field3 = new JComboBox();
//	    addCategoryColumns();
//
//	    
//	    assetQuery.setFont(font);
//	    roomNo.setFont(font);
//	    year.setFont(font);
//	    yearStart.setFont(font);
//	    yearEnd.setFont(font);
//	    categoryAsset.setFont(font);
//	    deactivatedQuery.setFont(font);
//	    categoryDeactivated.setFont(font);
//	    categoryQuery.setFont(font);
//	    category.setFont(font);
//	    expiredQuery.setFont(font);
//	    yearExpired.setFont(font);
//	    
//	    //query options for assets
//	    String[] assetQueries = {
//	    		"Assets over $500",
//	    		"Assets by Room #",
//	    		"Assets over $500 & Year acquired",
//	    		"Assets over $500 within year range",
//	    		"Assets over $500 from category",
//	    		"Assets over $500 from category & year acquired"
//	    };
//	    
//	    for(int i = 0; i < assetQueries.length; i++){
//	    	assetQuery.addItem(assetQueries[i]);
//	    }
//	    
//	  //query options for deactivated assets
//	    String [] deactivatedQueries = {
//	    		"Deactivated assets",
//	    		"Deactivated assets from category"
//	    };
//	    
//	    for(int i = 0; i < deactivatedQueries.length; i++){
//	    	deactivatedQuery.addItem(deactivatedQueries[i]);
//	    }
//	    
//	    //query options for assets by category
//	    String [] categoryQueries = {
//	    		"Assets from category"
//	    };
//	    
//	    for(int i = 0; i < categoryQueries.length; i++){
//	    	categoryQuery.addItem(categoryQueries[i]);
//	    }
//	    
//	  //query options for expired assets
//	    String [] expiredQueries = {
//	    		"Expired assets to date",
//	    		"Expired assets by year",
//	    		"Warranty expiration by year",
//	    		"Lease expiration by year"
//	    };
//	    
//	    for(int i = 0; i < expiredQueries.length; i++){
//	    	expiredQuery.addItem(expiredQueries[i]);
//	    }
//	    
////	    JComboBox assetQuery = new JComboBox();
////	    JTextField roomNo = new JTextField();
////	    JTextField year = new JTextField();
////	    JTextField yearStart = new JTextField();
////	    JTextField yearEnd = new JTextField();
////	    JComboBox categoryAsset = new JComboBox();
//	    JButton btnLoad1 = new JButton("Run");
//	    btnLoad1.setFont(font);
//
//	    btnLoad1.addMouseListener(new MouseAdapter(){
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				try {
//					if (assetQuery.getSelectedItem().equals("Assets over $500")) {
//						
//						UpDateTable_Assets_Over_500();
//						
//					}
//					else if(assetQuery.getSelectedItem().equals("Assets over $500 & Year acquired")) {
//						
//						String year3 =year.getText();						
//						//System.out.println(year3);
//						UpDateTable_Assets_Over_500_By_Year(year3);
// 
//					}
//					else if (assetQuery.getSelectedItem().equals("Assets over $500 within year range")) {
//						
//						String year1 = yearStart.getText();
//						String year2 = yearEnd.getText();
//						//System.out.println(year1 + "  " + year2);
//						update_Table_Assets_Over_500_Year_Range(year1,year2);
//						
//					}
//					else if (assetQuery.getSelectedItem().equals("Assets by Room #")) {
//						
//						int room_Number = Integer.parseInt(roomNo.getText());
//						
//						//System.out.println(room_Number);
//						Update_Table_Search_By_Room(room_Number);
//					}
//					else if (assetQuery.getSelectedItem().equals("Assets over $500 from category")) {
//						
//						String category_500 = (String) categoryAsset.getSelectedItem();
//						//System.out.println(category_500);
//						UpDateTable_Assets_Over_500_By_Category(category_500);		
//					}
//					
//					else if (assetQuery.getSelectedItem().equals("Assets over $500 from category & year acquired")) {
//						
//						String user_Category = (String) categoryAsset.getSelectedItem();
//						String year_Category = year.getText();
//						//System.out.println(user_Category +"  " + year_Category);
//						UpDateTable_Assets_Over_500_By_Category_And_Year(year_Category, user_Category);
//					}
//					
//					
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//			
//			}
//		});
//
////	    
////	    JComboBox deactivatedQuery = new JComboBox();
////	    JComboBox categoryDeactivated = new JComboBox();
//	    JButton btnLoad2 = new JButton("Run");
//	    btnLoad2.setFont(font);
//	    btnLoad2.setFont(font);
//	    btnLoad2.addMouseListener(new MouseAdapter(){
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				try {
//					
//				if (deactivatedQuery.getSelectedItem().equals("Deactivated assets")) {
//					
//					UpDateTable_Retired_Assets();
//				}
//				
//				else if (deactivatedQuery.getSelectedItem().equals("Deactivated assets from category")) {
//					
//					String deactivated_Category = (String) categoryDeactivated.getSelectedItem();
//					System.out.println(deactivated_Category);
//					UpDateTable_Retired_Assets_By_Category(deactivated_Category);	
//				}
//				 
//	    
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		
//		}
//	});
//	    
////	    JComboBox categoryQuery = new JComboBox();
////	    JComboBox category = new JComboBox();
//	    
//	    
//	    //	    
////	    JComboBox categoryQuery = new JComboBox();
////	    JComboBox category = new JComboBox();
//	    JButton btnLoad3 = new JButton("Run");
//	    btnLoad3.setFont(font);
//	    btnLoad3.addMouseListener(new MouseAdapter(){
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				try {
//					
//				if (categoryQuery.getSelectedItem().equals("Assets from category")){
//					
//					String all_Category = (String) category.getSelectedItem();
//					System.out.println(all_Category);
//					UpDateTable_All_Assets_By_Category(all_Category);
//					
//					
//				}
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		
//		}
//	});
////	    JComboBox expiredQuery = new JComboBox();
////	    JTextField yearExpired = new JTextField();
//	    JButton btnLoad4 = new JButton("Run");
//	    btnLoad4.setFont(font);
//	    btnLoad4.addMouseListener(new MouseAdapter(){
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				try {
//					
//				if (expiredQuery.getSelectedItem().equals("Expired assets")) {
//					
//					String all_Expired = yearExpired.getText();
//					UpDateTable_Expired_Assets(all_Expired);
//					
//				}
//				
//				else if (expiredQuery.getSelectedItem().equals("Expired assets by year")){
//					
//					String year_Expired = yearExpired.getText();
//					System.out.println(year_Expired);
//					UpDateTable_Expired_Assets(year_Expired);
//				}
//					
//					
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		
//		}
//	});
//				
//	   // JUST A COMMENT 
//	    
//	    //These empty Jlabels are spacers between query groups
//	    empty = new JLabel("");
//	    JLabel empty2 = new JLabel("");
//	    JLabel empty3 = new JLabel("");
//	    JLabel empty4 = new JLabel("");
//	    
//	    //This check to see what query has been selected to enable pertenant fields
//	    assetQuery.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent e) {
//                assetUpdateState();                  
//
//            }
//        });
//	    assetUpdateState();
//	    
//	  //This check to see what query has been selected to enable pertenant fields
//	    deactivatedQuery.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent e) {
//                deactivatedUpdateState();                  
//
//            }
//        });
//	    deactivatedUpdateState();
//	    
//	  //This check to see what query has been selected to enable pertenant fields
//	    expiredQuery.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent e) {
//                expiredUpdateState();                  
//
//            }
//        });
//	    expiredUpdateState();
//	    
//	    // array of labels and corresponding textFields for use in display()
//	    Object[] fields = {
//	    		//Assets Queries
//	    	"Select All:    ", assetQuery,
//	    	"From Room No.:    ", roomNo,
//	    	"From Year:    ", year,
//	    	"From Year:    ", yearStart,
//	    	"to Year:    ", yearEnd,
//	    	"From Category:    ", categoryAsset,
//	    	"    ", btnLoad1,
//	    	
//	    	"Deactivated Assets   ",empty, //Spacer
//	    	
//	    	//Deactivated Queries
//	    	"Select all:    ", deactivatedQuery,
//	    	"From Category:    ", categoryDeactivated,
//	    	"    ", btnLoad2,
//	    	
//	    	"Assets by Categories   ",empty2, //Spacer
//	    	
//	    	//Category Queries
//	    	"Select All:    ", categoryQuery,
//	    	"From Category:    ", category,	    	
//	    	"    ", btnLoad3,
//	    	
//	    	"Expired Assets    ",empty3,  //spacer
//	    	
//	    	//Expired Queries
//	    	"Select All:    ", expiredQuery,
//	    	"From Year:    ", yearExpired,
//	    	"    ", btnLoad4
//	    };
//    	JPanel compPanel = new JPanel();
//    	compPanel.setBorder(new EmptyBorder(45, 0, 0, 25));
//    	compPanel.setBackground(new Color(244, 244, 244));
//    	JScrollPane scrollPane = new JScrollPane();
//    	springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -32, SpringLayout.SOUTH, reportFrame.getContentPane());
//    	springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 24, SpringLayout.NORTH, reportFrame.getContentPane());
//    	springLayout.putConstraint(SpringLayout.WEST, scrollPane, 15, SpringLayout.WEST, reportFrame.getContentPane());
//    	springLayout.putConstraint(SpringLayout.EAST, scrollPane, 710, SpringLayout.WEST, reportFrame.getContentPane());
//    	scrollPane.setLocation(15, 80);
//    	scrollPane.setSize(561, 610);
//    	scrollPane.getVerticalScrollBar().setUnitIncrement(16);
//    	scrollPane.setViewportView(compPanel);
//    	compPanel.setLayout(new BoxLayout(compPanel, BoxLayout.X_AXIS));
//    	
//    	JPanel labelPanel = new JPanel((LayoutManager) null);
//    	labelPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
//    	labelPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
//    	labelPanel.setBackground(new Color(244, 244, 244));
//    	compPanel.add(labelPanel);
//    	GridLayout gl_labelPanel = new GridLayout(0, 1);
//    	gl_labelPanel.setVgap(20);
//    	labelPanel.setLayout(gl_labelPanel);
//    	
//    	JPanel textPanel = new JPanel((LayoutManager) null);
//    	textPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
//    	textPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
//    	textPanel.setBackground(new Color(244, 244, 244));
//    	compPanel.add(textPanel);
//    	GridLayout gl_textPanel = new GridLayout(0, 1);
//    	gl_textPanel.setVgap(20);
//    	textPanel.setLayout(gl_textPanel);
//    	reportFrame.getContentPane().add(scrollPane);
//    	
//    	int i=0;
//    	while (i < fields.length) {
//    		JLabel label = new JLabel((String) fields[i++], JLabel.RIGHT);
//    		label.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
//    		label.setForeground(new Color(98, 98, 98));
//    		labelPanel.add(label);
//    		textPanel.add((Component) fields[i++]);
//    	}
//    	
//
//		testTable = new JTable();
//		testTable.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
//		
//		 ((DefaultCellEditor) testTable.getDefaultEditor(Object.class))
//         .getComponent().setFont(testTable.getFont());
//		 
//		testTable.getTableHeader().setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
//		testTable.setRowHeight(testTable.getRowHeight() + 20);
//		testTable.putClientProperty("terminateEditOnFocusLost", true);
//		scrollPane_1.setViewportView(testTable);
//		//testTable.setAutoCreateColumnsFromModel(true);
//		testTable.setAutoCreateRowSorter(true);
//    	testTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//    	
//    	JPanel buttonPanel = new JPanel();
//    	buttonPanel.setBackground(new Color(244, 244, 244));
//    	buttonPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
//    	springLayout.putConstraint(SpringLayout.WEST, buttonPanel, 10, SpringLayout.EAST, scrollPane);
//    	springLayout.putConstraint(SpringLayout.SOUTH, buttonPanel, -10, SpringLayout.SOUTH, reportFrame.getContentPane());
//    	springLayout.putConstraint(SpringLayout.EAST, buttonPanel, -20, SpringLayout.EAST, reportFrame.getContentPane());
//    	buttonPanel.setSize(10, 50);
//    	buttonPanel.setLocation(719, 645);
//    	springLayout.putConstraint(SpringLayout.NORTH, buttonPanel, 11, SpringLayout.SOUTH, scrollPane_1);
//    	reportFrame.getContentPane().add(buttonPanel);
//    	buttonPanel.setLayout(new GridLayout(0, 2, 20, 0));
//    	
//    	JButton btnInsert = new JButton("Print");
//    	buttonPanel.add(btnInsert);
//    	springLayout.putConstraint(SpringLayout.WEST, btnInsert, 750, SpringLayout.WEST, reportFrame.getContentPane());
//    	springLayout.putConstraint(SpringLayout.NORTH, btnInsert, 23, SpringLayout.SOUTH, scrollPane_1);
//    	springLayout.putConstraint(SpringLayout.SOUTH, btnInsert, -28, SpringLayout.SOUTH, reportFrame.getContentPane());
//    	btnInsert.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
//    	
//    	JButton btnNewButton_1 = new JButton("Export to Excel");
//    	buttonPanel.add(btnNewButton_1);
//    	springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, (int)((scrollPane_1.getWidth() / 2) + 15), SpringLayout.WEST, scrollPane_1);
//    	springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -50, SpringLayout.EAST, reportFrame.getContentPane());
//    	springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 23, SpringLayout.SOUTH, scrollPane_1);
//    	springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -28, SpringLayout.SOUTH, reportFrame.getContentPane());
//    	btnNewButton_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
//    	springLayout.putConstraint(SpringLayout.EAST, btnInsert, -80, SpringLayout.WEST, btnNewButton_1);
//    	
//    	//testTable.getColumnModel().getColumn(1).setMinWidth(30);
//    	//testTable.getColumnModel().getColumn(1).setMaxWidth(80);
//    	//testTable.getColumnModel().getColumn(1).setPreferredWidth(50);
//	}
//	
//	public static void UpDateTable() 
//	{
//		try 
//		{
//			Connection conn = sqliteConnectionTEST.dbConnector();
//			DefaultTableModel dm = new DefaultTableModel();
//	        //query and resultset
//			String testTable_String = "Select * from MasterTable";
//			PreparedStatement showTestTable = conn.prepareStatement(testTable_String);
//			ResultSet rsTest = showTestTable.executeQuery();
//			addRowsAndColumns(rsTest, dm);
//			
//			testTable.setModel(dm);
//			
//			//testTable.setModel(DbUtils.resultSetToTableModel(rsTest));
//
//			//Refresh the table
//		   // tableModel.fireTableStructureChanged();
//			//testTable.setModel(tableModel);
//			refreshScreen();
//			//System.out.println(tableModel.getRowCount());
//			conn.close();
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e);
//		}
//	}
//	
//	/*WORKING PROPERLY ALL ASSETS OVER 500 WITHIN USER CHOSEN RANGE OF DATES*/
//	public static void update_Table_Assets_Over_500_Year_Range(String date, String date2) { 
//																							
//		Connection conn2 = sqliteConnectionTEST.dbConnector();
//		java.sql.Statement stmt;
//
//		try {
//
//			stmt = conn2.createStatement();
//			DefaultTableModel dm = new DefaultTableModel();
//
//			String showTestTable = "SELECT * From MasterTable" + " WHERE (Date_Acquired >= '" + date + "%'"
//					+ " AND Date_Acquired <='" + date2 + "%' AND MasterTable.Price>=500)" + ";";
//
//			PreparedStatement statement = conn2.prepareStatement(showTestTable);
//			ResultSet rs = statement.executeQuery();
//
//			addRowsAndColumns(rs, dm);
//			testTable.setModel(dm);
//
//			refreshScreen();
//			conn2.close();
//
//		} catch (SQLException e) {
//			System.out.println("sql exception caught");
//			e.printStackTrace();
//		}
//	}
//	
//	/* WORKING PROPERLY ALL ASSETS OVER 500*/
//	public static void UpDateTable_Assets_Over_500() {
//
//		Connection conn2 = sqliteConnectionTEST.dbConnector();
//		java.sql.Statement stmt;
//
//		try {
//			stmt = conn2.createStatement();
//
//			DefaultTableModel dm = new DefaultTableModel();
//			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Price>=500");
//
//			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
//			ResultSet rsTest = showTestTable.executeQuery();
//			addRowsAndColumns(rsTest, dm);
//
//			testTable.setModel(dm);
//
//			refreshScreen();
//			conn2.close();
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e);
//		}
//	}
//		
//	
//	/* WORKING PROPERLY ALL ASSETS OVER 500 FOR SINGLE YEAR CHOSEN BY USER*/
//	public static void UpDateTable_Assets_Over_500_By_Year(String year2) {  
//
//		Connection conn2 = sqliteConnectionTEST.dbConnector();
//		java.sql.Statement stmt;
//
//		try {
//			stmt = conn2.createStatement();
//			DefaultTableModel dm = new DefaultTableModel();
//			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Price>=500 AND"
//									+ " MasterTable.Date_Acquired LIKE '" + year2 + "%';'");
//			
//			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
//			ResultSet rsTest = showTestTable.executeQuery();
//
//					addRowsAndColumns(rsTest, dm);
//					testTable.setModel(dm);
//					refreshScreen();
//					conn2.close();
//		
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e);
//		}
//	}
//	
//	
//	/* RETURNS ASSEYS BASED OFF SPECIFIC ROOM NUMBER */
//	public static void Update_Table_Search_By_Room(int room_Number) {
//
//		Connection conn2 = sqliteConnectionTEST.dbConnector();
//		java.sql.Statement stmt;
//
//		try {
//			stmt = conn2.createStatement();
//			DefaultTableModel dm = new DefaultTableModel();
//			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Room = " + room_Number + ";");
//
//			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
//			ResultSet rsTest = showTestTable.executeQuery();
//
//			addRowsAndColumns(rsTest, dm);
//			testTable.setModel(dm);
//			refreshScreen();
//			conn2.close();
//
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e);
//		}
//	}
//	
//	/* RETURNS ASSETS OVER 500 BY YEAR AND CATEGORY */
//	public static void UpDateTable_Assets_Over_500_By_Category(String category) {  
//
//		Connection conn2 = sqliteConnectionTEST.dbConnector();
//		java.sql.Statement stmt;
//
//		try {
//			stmt = conn2.createStatement();
//			DefaultTableModel dm = new DefaultTableModel();
//			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Price>=500 AND"
//									+ " MasterTable.Category LIKE '" + category + "%';'");
//			
//			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
//			ResultSet rsTest = showTestTable.executeQuery();
//
//					addRowsAndColumns(rsTest, dm);
//					testTable.setModel(dm);
//					refreshScreen();
//					conn2.close();
//		
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e);
//		}
//	}
//	
//	
//	public static void UpDateTable_All_Assets_By_Category(String category) {  
//
//		Connection conn2 = sqliteConnectionTEST.dbConnector();
//		java.sql.Statement stmt;
//
//		try {
//			stmt = conn2.createStatement();
//			DefaultTableModel dm = new DefaultTableModel();
//			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Category = '" + category + "';'");
//			
//			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
//			ResultSet rsTest = showTestTable.executeQuery();
//
//					addRowsAndColumns(rsTest, dm);
//					testTable.setModel(dm);
//					refreshScreen();
//					conn2.close();
//		
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e);
//		}
//	}
//	
//	
///*	public static void UpDateTable_Deactivated_Assets(String category) {  
//
//		Connection conn2 = sqliteConnectionTEST.dbConnector();
//		java.sql.Statement stmt;
//
//		try {
//			stmt = conn2.createStatement();
//			DefaultTableModel dm = new DefaultTableModel();
//			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Category = '" + category + "';'");
//			
//			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
//			ResultSet rsTest = showTestTable.executeQuery();
//
//					addRowsAndColumns(rsTest, dm);
//					testTable.setModel(dm);
//					refreshScreen();
//					conn2.close();
//		
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e);
//		}
//	}
//*/	
//	
//	
//	
//	
//	/* RETURNS ASSETS OVER 500 BY YEAR AND CATEGORY */
//	public static void UpDateTable_Assets_Over_500_By_Category_And_Year(String year, String category) {  
//
//		Connection conn2 = sqliteConnectionTEST.dbConnector();
//		java.sql.Statement stmt;
//
//		try {
//			stmt = conn2.createStatement();
//			DefaultTableModel dm = new DefaultTableModel();
//			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Price>=500 AND"
//									+ " MasterTable.Category LIKE '" + category + "%' "
//											+ "AND Date_Acquired LIKE '" + year + "%';'");
//			
//			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
//			ResultSet rsTest = showTestTable.executeQuery();
//
//					addRowsAndColumns(rsTest, dm);
//					testTable.setModel(dm);
//					refreshScreen();
//					conn2.close();
//		
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e);
//		}
//	}
//	
//	
//	//Where MasterTable.Deactivated LIKE 'Removed'"
//	public static void UpDateTable_Retired_Assets() {
//
//		Connection conn2 = sqliteConnectionTEST.dbConnector();
//		java.sql.Statement stmt;
//
//		try {
//			stmt = conn2.createStatement();
//			DefaultTableModel dm = new DefaultTableModel();
//			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Deactivated LIKE 'Removed'");
//
//			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
//			ResultSet rsTest = showTestTable.executeQuery();
//
//			addRowsAndColumns(rsTest, dm);
//			testTable.setModel(dm);
//			refreshScreen();
//			conn2.close();
//
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e);
//		}
//	}
//	
//	/* RETURN ALL EXPIRED ASSETS*/
//	public static void UpDateTable_Expired_Assets(String year) {
//
//		Connection conn2 = sqliteConnectionTEST.dbConnector();
//		java.sql.Statement stmt;
//
//		try {
//			stmt = conn2.createStatement();
//			DefaultTableModel dm = new DefaultTableModel();
//			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Expiration_Date LIKE '" +year + "%';'");
//
//			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
//			ResultSet rsTest = showTestTable.executeQuery();
//
//			addRowsAndColumns(rsTest, dm);
//			testTable.setModel(dm);
//			refreshScreen();
//			conn2.close();
//
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e);
//		}
//	}
//	
//	public static void UpDateTable_Expired_Assets_To_Date(String year) {
//
//		Connection conn2 = sqliteConnectionTEST.dbConnector();
//		java.sql.Statement stmt;
//
//		try {
//			stmt = conn2.createStatement();
//			DefaultTableModel dm = new DefaultTableModel();
//			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Expiration_Date <= '" +year + "%';'");
//
//			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
//			ResultSet rsTest = showTestTable.executeQuery();
//
//			addRowsAndColumns(rsTest, dm);
//			testTable.setModel(dm);
//			refreshScreen();
//			conn2.close();
//
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e);
//		}
//	}
//	
//	/* Return EVERY ASSETS IN A CATEGORY*/
//	public static void UpDateTable_Retired_Assets_By_Category(String category) {  
//
//		Connection conn2 = sqliteConnectionTEST.dbConnector();
//		java.sql.Statement stmt;
//
//		try {
//			stmt = conn2.createStatement();
//			DefaultTableModel dm = new DefaultTableModel();
//			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Deactivated LIKE 'Removed'"
//					+ " AND MasterTable.Category = '" + category + "';'");
//			
//			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
//			ResultSet rsTest = showTestTable.executeQuery();
//
//					addRowsAndColumns(rsTest, dm);
//					testTable.setModel(dm);
//					refreshScreen();
//					conn2.close();
//		
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e);
//		}
//	}
//	
//	
//
//	
//	
//	public static void addRowsAndColumns(ResultSet rs, DefaultTableModel dm) throws SQLException
//	{
//        ResultSetMetaData rsmd=rs.getMetaData();
//        //Coding to get columns-
//        int cols=rsmd.getColumnCount();
//        String c[]=new String[cols];
//        for(int i=0;i<cols;i++){
//            c[i]=rsmd.getColumnName(i+1);
//            dm.addColumn(c[i]);
//        }
//        
//        Object row[]=new Object[cols];
//        while(rs.next()){
//             for(int i=0;i<cols;i++){
//                    row[i]=rs.getString(i+1);
//                }
//            dm.addRow(row);
//        }
//	}
//	public static void refreshScreen()
//	{
//		testTable.revalidate();
//		testTable.repaint();
//		testTable.validate();//
//		
//		testTable.getColumnModel().getColumn(0).setPreferredWidth(280);
//		testTable.getColumnModel().getColumn(1).setPreferredWidth(80);
//		testTable.getColumnModel().getColumn(2).setPreferredWidth(320);
//		testTable.getColumnModel().getColumn(3).setPreferredWidth(180);
//		testTable.getColumnModel().getColumn(4).setPreferredWidth(100);
//		testTable.getColumnModel().getColumn(5).setPreferredWidth(120);
//		testTable.getColumnModel().getColumn(6).setPreferredWidth(220);
//		testTable.getColumnModel().getColumn(7).setPreferredWidth(180);
//		testTable.getColumnModel().getColumn(8).setPreferredWidth(180);
//		testTable.getColumnModel().getColumn(9).setPreferredWidth(220);
//		testTable.getColumnModel().getColumn(10).setPreferredWidth(320);
//		testTable.getColumnModel().getColumn(11).setPreferredWidth(320);
//		testTable.getColumnModel().getColumn(12).setPreferredWidth(180);
//	}
//	
//	public void addCategoryColumns() {
//
//        Connection conn2 = sqliteConnectionTEST.dbConnector();
//        java.sql.Statement stmt;
//        
//        try {
//            stmt = conn2.createStatement(); 
//            ResultSet rs = stmt.executeQuery("SELECT Distinct Category From MasterTable");
//
//            String group = "";
//            while (rs.next()) {
//                group = rs.getString("Category");
//                categoryAsset.addItem(group);
//        	    categoryDeactivated.addItem(group);
//        	    category.addItem(group);
//                //field3.addItem(group);
//                
//                //System.out.println("Group name: " + group);
//            }
//        } catch (SQLException e) {
//            System.out.println("sql exception caught");
//            e.printStackTrace();
//        }
//    }
//
//
//	protected void assetUpdateState() {
//		    
//	    boolean assetByRoomEnabled = assetQuery.getSelectedItem().equals("Assets by Room #");
//	    roomNo.setEnabled(assetByRoomEnabled);
//	    
//	    boolean assetByYearEnabled = assetQuery.getSelectedItem().equals("Assets over $500 & Year acquired");
//	    year.setEnabled(assetByYearEnabled);
//	    
//	    boolean assetByYearRangeEnabled = assetQuery.getSelectedItem().equals("Assets over $500 within year range");
//	    yearStart.setEnabled(assetByYearRangeEnabled);
//	    yearEnd.setEnabled(assetByYearRangeEnabled);
//	    
//	    boolean assetByCategoryEnabled = assetQuery.getSelectedItem().equals("Assets over $500 from category");
//	    categoryAsset.setEnabled(assetByCategoryEnabled);
//	    
//	    boolean assetByCategoryAndYearEnabled = assetQuery.getSelectedItem().equals("Assets over $500 from category & year acquired");
//	    year.setEnabled(assetByCategoryAndYearEnabled);
//	    categoryAsset.setEnabled(assetByCategoryAndYearEnabled);
//	    
//	    if(assetByYearEnabled || assetByCategoryAndYearEnabled)
//	    	year.setEnabled(true);
//	    
//	    if(assetByCategoryAndYearEnabled || assetByCategoryEnabled)
//	    	categoryAsset.setEnabled(true);
//	    	
//	}
//	
//	protected void deactivatedUpdateState() {
//	    
//	    boolean deactivatedByCategoryEnabled = deactivatedQuery.getSelectedItem().equals("Deactivated assets from category");
//	    categoryDeactivated.setEnabled(deactivatedByCategoryEnabled);
//	    	
//	}
//	
//	protected void expiredUpdateState() {
//	    
//	    boolean ByYearEnabled = expiredQuery.getSelectedItem().equals("Expired assets to date");
//	    yearExpired.setEnabled(!ByYearEnabled);
//	    
//	    //if (ByYearEnabled || )
//	    	
//	}
//}

>>>>>>> origin/master
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

//import org.apache.poi.util.SystemOutLogger;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
<<<<<<< HEAD
import java.text.MessageFormat;
=======
>>>>>>> origin/master
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
import java.awt.LayoutManager;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

public class reportsFrame{

    private JFrame reportFrame;
    //private JComboBox <String> field3;
    private static JTable testTable;
<<<<<<< HEAD
   
    // instantiating textfields for each jlabel
            JComboBox assetQuery = new JComboBox();
            JTextField roomNo = new JTextField();
            JTextField year = new JTextField();
            JTextField yearStart = new JTextField();
            JTextField yearEnd = new JTextField();
            JComboBox categoryAsset = new JComboBox();
           
            JComboBox deactivatedQuery = new JComboBox();
            JComboBox categoryDeactivated = new JComboBox();
           
            JComboBox categoryQuery = new JComboBox();
            JComboBox category = new JComboBox();
           
            JComboBox expiredQuery = new JComboBox();
            JTextField yearExpired = new JTextField();
           
            JLabel empty = new JLabel(" ");
           
            boolean printAsset_500 = false;//done
            boolean printAsset_500_Year =false; //done
            boolean printAsset_500_Range = false; //done
            boolean printAsset_Room =false; //done
            boolean printAsset_500_Cat =false; //done
            boolean printAsset_500_Year_Cat =false; //done
            boolean printDeactivated =false;  //done
            boolean printDeactivated_Cat =false; //done
            boolean printExpired_ToDate =false;  //done
            boolean printExpired_Year =false;  //done
            boolean printAssets_Warranty =false;
            boolean printAsset_Leased =false; 
            boolean printAssets_All_Category=false;   
           
           
           
           
    /**
     * Launch the application.
     */
=======
    
    // instantiating textfields for each jlabel
            JComboBox assetQuery = new JComboBox();
           JTextField roomNo = new JTextField();
           JTextField year = new JTextField();
           JTextField yearStart = new JTextField();
           JTextField yearEnd = new JTextField();
           JComboBox categoryAsset = new JComboBox();
           
           JComboBox deactivatedQuery = new JComboBox();
           JComboBox categoryDeactivated = new JComboBox();
           
           JComboBox categoryQuery = new JComboBox();
           JComboBox category = new JComboBox();
           
           JComboBox expiredQuery = new JComboBox();
           JTextField yearExpired = new JTextField();
           
           JLabel empty = new JLabel(" ");


    /**
    * Launch the application.
    */
>>>>>>> origin/master
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    reportsFrame window = new reportsFrame();
//                    window.display();
                    window.reportFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

<<<<<<< HEAD
   
=======
    /**
    * Create the application.
    * @throws UnsupportedLookAndFeelException 
    * @throws IllegalAccessException 
    * @throws InstantiationException 
    * @throws ClassNotFoundException 
    */
>>>>>>> origin/master
    public reportsFrame() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        Connection conn = sqliteConnectionTEST.dbConnector();
        initialize();
        UpDateTable();
<<<<<<< HEAD
       
    }
   
   
   
   
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
       
        Connection conn = sqliteConnectionTEST.dbConnector();
       
=======
        
    }
    
    
    
    
    /**
    * Initialize the contents of the frame.
    */
    private void initialize() {
        
        Connection conn = sqliteConnectionTEST.dbConnector();
        
>>>>>>> origin/master
        reportFrame = new JFrame();
        reportFrame.setVisible(true);
        reportFrame.getContentPane().setBackground(new Color(244, 244, 244));
        reportFrame.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        reportFrame.setTitle("Reports");
        reportFrame.setBounds(100, 100, 1504, 793);
        reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        reportFrame.setLocationRelativeTo(null);
        reportFrame.getContentPane().setLayout(null);
<<<<<<< HEAD
        reportFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        SpringLayout springLayout = new SpringLayout();
        reportFrame.getContentPane().setLayout(springLayout);
       
        ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));
        reportFrame.setIconImage(icon.getImage());
       
=======
        reportFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        SpringLayout springLayout = new SpringLayout();
        reportFrame.getContentPane().setLayout(springLayout);
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));
        reportFrame.setIconImage(icon.getImage());
        
>>>>>>> origin/master
        JScrollPane scrollPane_1 = new JScrollPane();
        springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 720, SpringLayout.WEST, reportFrame.getContentPane());
        scrollPane_1.setSize(792, 616);
        scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 24, SpringLayout.NORTH, reportFrame.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, -98, SpringLayout.SOUTH, reportFrame.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, -21, SpringLayout.EAST, reportFrame.getContentPane());
        reportFrame.getContentPane().add(scrollPane_1);
<<<<<<< HEAD
       

        //bullshitcomment
       
       
=======
        

        //bullshitcomment
        
        
>>>>>>> origin/master
        // Font styling for TextFields
        Font font = new Font("Segoe UI Semilight", Font.PLAIN, 20);
       
//        // instantiating textfields for each jlabel
//        JTextField field1 = new JTextField();
<<<<<<< HEAD
//       
//        JTextField field2 = new JTextField();
//        field3 = new JComboBox();
        addCategoryColumns();

       
        assetQuery.setFont(font);
        roomNo.setFont(font);
        year.setFont(font);
        yearStart.setFont(font);
        yearEnd.setFont(font);
        categoryAsset.setFont(font);
        deactivatedQuery.setFont(font);
        categoryDeactivated.setFont(font);
        categoryQuery.setFont(font);
        category.setFont(font);
        expiredQuery.setFont(font);
        yearExpired.setFont(font);
       
        //query options for assets
        String[] assetQueries = {
                "Assets over $500",
                "Assets by Room #",
                "Assets over $500 & Year acquired",
                "Assets over $500 within year range",
                "Assets over $500 from category",
                "Assets over $500 from category & year acquired"
        };
       
        for(int i = 0; i < assetQueries.length; i++){
            assetQuery.addItem(assetQueries[i]);
        }
       
      //query options for deactivated assets
        String [] deactivatedQueries = {
                "Deactivated assets",
                "Deactivated assets from category"
        };
       
        for(int i = 0; i < deactivatedQueries.length; i++){
            deactivatedQuery.addItem(deactivatedQueries[i]);
        }
       
        //query options for assets by category
        String [] categoryQueries = {
                "Assets from category"
        };
       
        for(int i = 0; i < categoryQueries.length; i++){
            categoryQuery.addItem(categoryQueries[i]);
        }
       
      //query options for expired assets
        String [] expiredQueries = {
                "Expired assets to date",
                "Expired assets by year",
                "Warranty expiration by year",
                "Lease expiration by year"
        };
       
        for(int i = 0; i < expiredQueries.length; i++){
            expiredQuery.addItem(expiredQueries[i]);
        }
       
//        JComboBox assetQuery = new JComboBox();
//        JTextField roomNo = new JTextField();
//        JTextField year = new JTextField();
//        JTextField yearStart = new JTextField();
//        JTextField yearEnd = new JTextField();
//        JComboBox categoryAsset = new JComboBox();
        JButton btnLoad1 = new JButton("Run");
        btnLoad1.setFont(font);

        btnLoad1.addMouseListener(new MouseAdapter(){
=======
//        
//       JTextField field2 = new JTextField();
//       field3 = new JComboBox();
       addCategoryColumns();

       
       assetQuery.setFont(font);
       roomNo.setFont(font);
       year.setFont(font);
       yearStart.setFont(font);
       yearEnd.setFont(font);
       categoryAsset.setFont(font);
       deactivatedQuery.setFont(font);
       categoryDeactivated.setFont(font);
       categoryQuery.setFont(font);
       category.setFont(font);
       expiredQuery.setFont(font);
       yearExpired.setFont(font);
       
       //query options for assets
       String[] assetQueries = {
               "Assets over $500",
               "Assets by Room #",
               "Assets over $500 & Year acquired",
               "Assets over $500 within year range",
               "Assets over $500 from category",
               "Assets over $500 from category & year acquired"
       };
       
       for(int i = 0; i < assetQueries.length; i++){
           assetQuery.addItem(assetQueries[i]);
       }
       
     //query options for deactivated assets
       String [] deactivatedQueries = {
               "Deactivated assets",
               "Deactivated assets from category"
       };
       
       for(int i = 0; i < deactivatedQueries.length; i++){
           deactivatedQuery.addItem(deactivatedQueries[i]);
       }
       
       //query options for assets by category
       String [] categoryQueries = {
               "Assets from category"
       };
       
       for(int i = 0; i < categoryQueries.length; i++){
           categoryQuery.addItem(categoryQueries[i]);
       }
       
     //query options for expired assets
       String [] expiredQueries = {
               "Expired assets to date",
               "Expired assets by year",
               "Warranty expiration by year",
               "Lease expiration by year"
       };
       
       for(int i = 0; i < expiredQueries.length; i++){
           expiredQuery.addItem(expiredQueries[i]);
       }
       
//       JComboBox assetQuery = new JComboBox();
//       JTextField roomNo = new JTextField();
//       JTextField year = new JTextField();
//       JTextField yearStart = new JTextField();
//       JTextField yearEnd = new JTextField();
//       JComboBox categoryAsset = new JComboBox();
       JButton btnLoad1 = new JButton("Run");
       btnLoad1.setFont(font);

       btnLoad1.addMouseListener(new MouseAdapter(){
>>>>>>> origin/master
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (assetQuery.getSelectedItem().equals("Assets over $500")) {
<<<<<<< HEAD
                        printAsset_500_Year =false;
                        printAsset_500_Range = false;
                        printAsset_Room =false;
                        printAsset_500_Cat =false;
                        printAsset_500_Year_Cat =false;
                        printDeactivated =false;
                        printDeactivated_Cat =false;
                        printExpired_ToDate =false;
                        printExpired_Year =false;
                        printAssets_Warranty =false;
                        printAsset_Leased =false;
                        printAsset_500 =true;
                        printAssets_All_Category=false;
                       
                        UpDateTable_Assets_Over_500();
                       
                    }
                    else if(assetQuery.getSelectedItem().equals("Assets over $500 & Year acquired")) {
                        printAsset_500_Range = false;
                        printAsset_Room =false;
                        printAsset_500_Cat =false;
                        printAsset_500_Year_Cat =false;
                        printDeactivated =false;
                        printDeactivated_Cat =false;
                        printExpired_ToDate =false;
                        printExpired_Year =false;
                        printAssets_Warranty =false;
                        printAsset_Leased =false;
                        printAsset_500 =false;
                        printAsset_500_Year =true;
                        printAssets_All_Category=false;
                       
                        String year3 =year.getText();                       
=======
                        
                        UpDateTable_Assets_Over_500();
                        
                    }
                    else if(assetQuery.getSelectedItem().equals("Assets over $500 & Year acquired")) {
                        
                        String year3 =year.getText();                        
>>>>>>> origin/master
                        //System.out.println(year3);
                        UpDateTable_Assets_Over_500_By_Year(year3);
 
                    }
                    else if (assetQuery.getSelectedItem().equals("Assets over $500 within year range")) {
<<<<<<< HEAD
                        printAsset_500_Range = true;
                        printAsset_Room =false;
                        printAsset_500_Cat =false;
                        printAsset_500_Year_Cat =false;
                        printDeactivated =false;
                        printDeactivated_Cat =false;
                        printExpired_ToDate =false;
                        printExpired_Year =false;
                        printAssets_Warranty =false;
                        printAsset_Leased =false;
                        printAsset_500 =false;
                        printAsset_500_Year =false;
                        printAssets_All_Category=false;
                       
=======
                        
>>>>>>> origin/master
                        String year1 = yearStart.getText();
                        String year2 = yearEnd.getText();
                        //System.out.println(year1 + "  " + year2);
                        update_Table_Assets_Over_500_Year_Range(year1,year2);
<<<<<<< HEAD
                       
                    }
                    else if (assetQuery.getSelectedItem().equals("Assets by Room #")) {
                       
                        printAsset_500_Range = false;
                        printAsset_Room =true;
                        printAsset_500_Cat =false;
                        printAsset_500_Year_Cat =false;
                        printDeactivated =false;
                        printDeactivated_Cat =false;
                        printExpired_ToDate =false;
                        printExpired_Year =false;
                        printAssets_Warranty =false;
                        printAsset_Leased =false;
                        printAsset_500 =false;
                        printAsset_500_Year =false;
                        printAssets_All_Category=false;
                       
                        boolean shit = false;
                        while(shit =false) {
                        try {
                            int room_Number = Integer.parseInt(roomNo.getText());    
                            Update_Table_Search_By_Room(room_Number);
                            //break;
                        }
                        catch (NumberFormatException e2) {
                            // do nothing.
                        }
                        }
                    }
                    else if (assetQuery.getSelectedItem().equals("Assets over $500 from category")) {
                       
                        printAsset_500_Range = false;
                        printAsset_Room =false;
                        printAsset_500_Cat =true;
                        printAsset_500_Year_Cat =false;
                        printDeactivated =false;
                        printDeactivated_Cat =false;
                        printExpired_ToDate =false;
                        printExpired_Year =false;
                        printAssets_Warranty =false;
                        printAsset_Leased =false;
                        printAsset_500 =false;
                        printAsset_500_Year =false;
                        printAssets_All_Category=false;
                       
                        String category_500 = (String) categoryAsset.getSelectedItem();
                        //System.out.println(category_500);
                        UpDateTable_Assets_Over_500_By_Category(category_500);       
                    }
                   
                    else if (assetQuery.getSelectedItem().equals("Assets over $500 from category & year acquired")) {
                       
                        printAsset_500_Range = false;
                        printAsset_Room =false;
                        printAsset_500_Cat =false;
                        printAsset_500_Year_Cat =true;
                        printDeactivated =false;
                        printDeactivated_Cat =false;
                        printExpired_ToDate =false;
                        printExpired_Year =false;
                        printAssets_Warranty =false;
                        printAsset_Leased =false;
                        printAsset_500 =false;
                        printAsset_500_Year =false;
                        printAssets_All_Category=false;
                       
=======
                        
                    }
                    else if (assetQuery.getSelectedItem().equals("Assets by Room #")) {
                        
                        int room_Number = Integer.parseInt(roomNo.getText());
                        
                        //System.out.println(room_Number);
                        Update_Table_Search_By_Room(room_Number);
                    }
                    else if (assetQuery.getSelectedItem().equals("Assets over $500 from category")) {
                        
                        String category_500 = (String) categoryAsset.getSelectedItem();
                        //System.out.println(category_500);
                        UpDateTable_Assets_Over_500_By_Category(category_500);        
                    }
                    
                    else if (assetQuery.getSelectedItem().equals("Assets over $500 from category & year acquired")) {
                        
>>>>>>> origin/master
                        String user_Category = (String) categoryAsset.getSelectedItem();
                        String year_Category = year.getText();
                        //System.out.println(user_Category +"  " + year_Category);
                        UpDateTable_Assets_Over_500_By_Category_And_Year(year_Category, user_Category);
                    }
<<<<<<< HEAD
                   
                   
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
           
=======
                    
                    
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            
>>>>>>> origin/master
            }
        });

//       
<<<<<<< HEAD
//        JComboBox deactivatedQuery = new JComboBox();
//        JComboBox categoryDeactivated = new JComboBox();
        JButton btnLoad2 = new JButton("Run");
        btnLoad2.setFont(font);
        btnLoad2.setFont(font);
        btnLoad2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                   
                if (deactivatedQuery.getSelectedItem().equals("Deactivated assets")) {
                   
                    printAsset_500_Range = false;
                    printAsset_Room =false;
                    printAsset_500_Cat =false;
                    printAsset_500_Year_Cat =false;
                    printDeactivated =true;
                    printDeactivated_Cat =false;
                    printExpired_ToDate =false;
                    printExpired_Year =false;
                    printAssets_Warranty =false;
                    printAsset_Leased =false;
                    printAsset_500 =false;
                    printAsset_500_Year =false;
                    printAssets_All_Category=false;
                   
                    UpDateTable_Retired_Assets();
                }
               
                else if (deactivatedQuery.getSelectedItem().equals("Deactivated assets from category")) {
                   
                    printAsset_500_Range = false;
                    printAsset_Room =false;
                    printAsset_500_Cat =false;
                    printAsset_500_Year_Cat =false;
                    printDeactivated =false;
                    printDeactivated_Cat =true;
                    printExpired_ToDate =false;
                    printExpired_Year =false;
                    printAssets_Warranty =false;
                    printAsset_Leased =false;
                    printAsset_500 =false;
                    printAsset_500_Year =false;
                    printAssets_All_Category=false;
                   
                    String deactivated_Category = (String) categoryDeactivated.getSelectedItem();
                    System.out.println(deactivated_Category);
                    UpDateTable_Retired_Assets_By_Category(deactivated_Category);   
=======
//       JComboBox deactivatedQuery = new JComboBox();
//       JComboBox categoryDeactivated = new JComboBox();
       JButton btnLoad2 = new JButton("Run");
       btnLoad2.setFont(font);
       btnLoad2.setFont(font);
       btnLoad2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    
                if (deactivatedQuery.getSelectedItem().equals("Deactivated assets")) {
                    
                    UpDateTable_Retired_Assets();
                }
                
                else if (deactivatedQuery.getSelectedItem().equals("Deactivated assets from category")) {
                    
                    String deactivated_Category = (String) categoryDeactivated.getSelectedItem();
                    System.out.println(deactivated_Category);
                    UpDateTable_Retired_Assets_By_Category(deactivated_Category);    
>>>>>>> origin/master
                }
                 
       
            } catch (Exception e2) {
                e2.printStackTrace();
            }
<<<<<<< HEAD
       
        }
    });
       

       
       
        JButton btnLoad3 = new JButton("Run");
        btnLoad3.setFont(font);
        btnLoad3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                   
                if (categoryQuery.getSelectedItem().equals("Assets from category")){
                   
                    printAsset_500_Range = false;
                    printAsset_Room =false;
                    printAsset_500_Cat =false;
                    printAsset_500_Year_Cat =false;
                    printDeactivated =false;
                    printDeactivated_Cat =false;
                    printExpired_ToDate =false;
                    printExpired_Year =false;
                    printAssets_Warranty =false;
                    printAsset_Leased =false;
                    printAsset_500 =false;
                    printAsset_500_Year =false;
                    printAssets_All_Category=true;
                   
                    String all_Category = (String) category.getSelectedItem();
                    System.out.println(all_Category);
                    UpDateTable_All_Assets_By_Category(all_Category);
                   
                   
=======
        
        }
    });
       
//       JComboBox categoryQuery = new JComboBox();
//       JComboBox category = new JComboBox();
       
       
       //       
//       JComboBox categoryQuery = new JComboBox();
//       JComboBox category = new JComboBox();
       JButton btnLoad3 = new JButton("Run");
       btnLoad3.setFont(font);
       btnLoad3.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    
                if (categoryQuery.getSelectedItem().equals("Assets from category")){
                    
                    String all_Category = (String) category.getSelectedItem();
                    System.out.println(all_Category);
                    UpDateTable_All_Assets_By_Category(all_Category);
                    
                    
>>>>>>> origin/master
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
<<<<<<< HEAD
       
        }
    });

       
       
        JButton btnLoad4 = new JButton("Run");
=======
        
        }
    });
//       JComboBox expiredQuery = new JComboBox();
//       JTextField yearExpired = new JTextField();
       JButton btnLoad4 = new JButton("Run");
>>>>>>> origin/master
        btnLoad4.setFont(font);
        btnLoad4.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
<<<<<<< HEAD
                   
                if (expiredQuery.getSelectedItem().equals("Expired assets to date")) {
                   
                    printAsset_500_Range = false; 
                    printAsset_Room =false; //done
                    printAsset_500_Cat =false;// done
                    printAsset_500_Year_Cat =false;
                    printDeactivated_Cat =false;
                    printExpired_ToDate =true;
                    printExpired_Year =false;  //done
                    printAssets_Warranty =false; 
                    printAsset_Leased =false; 
                    printAsset_500 =false;  //done
                    printAsset_500_Year =false; //done
                    printAssets_All_Category=false;
                   
=======
                    
                if (expiredQuery.getSelectedItem().equals("Expired assets to date")) {
                    
>>>>>>> origin/master
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    Date date = new Date();
                    //System.out.println(dateFormat.format(date));
                    UpDateTable_Expired_Assets_To_Date(dateFormat.format(date));
<<<<<<< HEAD
                   
                }
               
                else if (expiredQuery.getSelectedItem().equals("Expired assets by year")){
                   
                    printAsset_500_Range = false;
                    printAsset_Room =false;
                    printAsset_500_Cat =false;
                    printAsset_500_Year_Cat =false;
                    printDeactivated =false;
                    printDeactivated_Cat =false;
                    printExpired_ToDate =false;
                    printExpired_Year =true;
                    printAssets_Warranty =false;
                    printAsset_Leased =false;
                    printAsset_500 =false;
                    printAsset_500_Year =false;
                    printAssets_All_Category=false;
                   
=======
                    
                }
                
                else if (expiredQuery.getSelectedItem().equals("Expired assets by year")){
                    
>>>>>>> origin/master
                    String year_Expired = yearExpired.getText();
                    System.out.println(year_Expired);
                    UpDateTable_Expired_Assets(year_Expired);
                }
<<<<<<< HEAD
               
               
                else if(expiredQuery.getSelectedItem().equals("Warranty expiration by year")) {
                   
                    printAsset_500_Range = false;
                    printAsset_Room =false;
                    printAsset_500_Cat =false;
                    printAsset_500_Year_Cat =false;
                    printDeactivated =false;
                    printDeactivated_Cat =false;
                    printExpired_ToDate =false;
                    printExpired_Year =false;
                    printAssets_Warranty =true;
                    printAsset_Leased =false;
                    printAsset_500 =false;
                    printAsset_500_Year =false;
                    printAssets_All_Category=false;
                   
                   
                    String warranty_Date = yearExpired.getText();
                    UpDateTable_Warranty_Assets(warranty_Date);
                   
                }
               
                else if(expiredQuery.getSelectedItem().equals("Lease expiration by year")) {
                   
                    printAsset_500_Range = false;
                    printAsset_Room =false;
                    printAsset_500_Cat =false;
                    printAsset_500_Year_Cat =false;
                    printDeactivated =false;
                    printDeactivated_Cat =false;
                    printExpired_ToDate =false;
                    printExpired_Year =false;
                    printAssets_Warranty =false;
                    printAsset_Leased =true;
                    printAsset_500 =false;
                    printAsset_500_Year =false;
                    printAssets_All_Category=false;
                   
                    String assets_Leased = yearExpired.getText();
                    UpDateTable_Leased_Assets(assets_Leased);
                   
                }
                   
                   
            } catch (Exception e2) {
                e2.printStackTrace();
            }
       
        }
    });
               
     
       
        //These empty Jlabels are spacers between query groups
        empty = new JLabel("");
        JLabel empty2 = new JLabel("");
        JLabel empty3 = new JLabel("");
        JLabel empty4 = new JLabel("");
       
        //This check to see what query has been selected to enable pertenant fields
        assetQuery.addItemListener(new ItemListener() {
=======
                
                
                else if(expiredQuery.getSelectedItem().equals("Warranty expiration by year")) {
                    
                    String warranty_Date = yearExpired.getText();
                    UpDateTable_Warranty_Assets(warranty_Date);
                    
                }
                
                else if(expiredQuery.getSelectedItem().equals("Lease expiration by year")) {
                    
                    String assets_Leased = yearExpired.getText();
                    UpDateTable_Leased_Assets(assets_Leased);
                    
                }
                    
                    
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        
        }
    });
                
      // JUST A COMMENT 
       
       //These empty Jlabels are spacers between query groups
       empty = new JLabel("");
       JLabel empty2 = new JLabel("");
       JLabel empty3 = new JLabel("");
       JLabel empty4 = new JLabel("");
       
       //This check to see what query has been selected to enable pertenant fields
       assetQuery.addItemListener(new ItemListener() {
>>>>>>> origin/master
            public void itemStateChanged(ItemEvent e) {
                assetUpdateState();                 

            }
        });
<<<<<<< HEAD
        assetUpdateState();
       
      //This check to see what query has been selected to enable pertenant fields
        deactivatedQuery.addItemListener(new ItemListener() {
=======
       assetUpdateState();
       
     //This check to see what query has been selected to enable pertenant fields
       deactivatedQuery.addItemListener(new ItemListener() {
>>>>>>> origin/master
            public void itemStateChanged(ItemEvent e) {
                deactivatedUpdateState();                 

            }
        });
<<<<<<< HEAD
        deactivatedUpdateState();
       
      //This check to see what query has been selected to enable pertenant fields
        expiredQuery.addItemListener(new ItemListener() {
=======
       deactivatedUpdateState();
       
     //This check to see what query has been selected to enable pertenant fields
       expiredQuery.addItemListener(new ItemListener() {
>>>>>>> origin/master
            public void itemStateChanged(ItemEvent e) {
                expiredUpdateState();                 

            }
        });
<<<<<<< HEAD
        expiredUpdateState();
       
        // array of labels and corresponding textFields for use in display()
        Object[] fields = {
                //Assets Queries
            "Select All:    ", assetQuery,
            "From Room No.:    ", roomNo,
            "From Year:    ", year,
            "From Year:    ", yearStart,
            "to Year:    ", yearEnd,
            "From Category:    ", categoryAsset,
            "    ", btnLoad1,
           
            "Deactivated Assets   ",empty, //Spacer
           
            //Deactivated Queries
            "Select all:    ", deactivatedQuery,
            "From Category:    ", categoryDeactivated,
            "    ", btnLoad2,
           
            "Assets by Categories   ",empty2, //Spacer
           
            //Category Queries
            "Select All:    ", categoryQuery,
            "From Category:    ", category,           
            "    ", btnLoad3,
           
            "Expired Assets    ",empty3,  //spacer
           
            //Expired Queries
            "Select All:    ", expiredQuery,
            "From Year:    ", yearExpired,
            "    ", btnLoad4
        };
=======
       expiredUpdateState();
       
       // array of labels and corresponding textFields for use in display()
       Object[] fields = {
               //Assets Queries
           "Select All:    ", assetQuery,
           "From Room No.:    ", roomNo,
           "From Year:    ", year,
           "From Year:    ", yearStart,
           "to Year:    ", yearEnd,
           "From Category:    ", categoryAsset,
           "    ", btnLoad1,
           
           "Deactivated Assets   ",empty, //Spacer
           
           //Deactivated Queries
           "Select all:    ", deactivatedQuery,
           "From Category:    ", categoryDeactivated,
           "    ", btnLoad2,
           
           "Assets by Categories   ",empty2, //Spacer
           
           //Category Queries
           "Select All:    ", categoryQuery,
           "From Category:    ", category,           
           "    ", btnLoad3,
           
           "Expired Assets    ",empty3,  //spacer
           
           //Expired Queries
           "Select All:    ", expiredQuery,
           "From Year:    ", yearExpired,
           "    ", btnLoad4
       };
>>>>>>> origin/master
        JPanel compPanel = new JPanel();
        compPanel.setBorder(new EmptyBorder(45, 0, 0, 25));
        compPanel.setBackground(new Color(244, 244, 244));
        JScrollPane scrollPane = new JScrollPane();
        springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -32, SpringLayout.SOUTH, reportFrame.getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 24, SpringLayout.NORTH, reportFrame.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, scrollPane, 15, SpringLayout.WEST, reportFrame.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, scrollPane, 710, SpringLayout.WEST, reportFrame.getContentPane());
        scrollPane.setLocation(15, 80);
        scrollPane.setSize(561, 610);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setViewportView(compPanel);
        compPanel.setLayout(new BoxLayout(compPanel, BoxLayout.X_AXIS));
<<<<<<< HEAD
       
=======
        
>>>>>>> origin/master
        JPanel labelPanel = new JPanel((LayoutManager) null);
        labelPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        labelPanel.setBackground(new Color(244, 244, 244));
        compPanel.add(labelPanel);
        GridLayout gl_labelPanel = new GridLayout(0, 1);
        gl_labelPanel.setVgap(20);
        labelPanel.setLayout(gl_labelPanel);
<<<<<<< HEAD
       
=======
        
>>>>>>> origin/master
        JPanel textPanel = new JPanel((LayoutManager) null);
        textPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        textPanel.setBackground(new Color(244, 244, 244));
        compPanel.add(textPanel);
        GridLayout gl_textPanel = new GridLayout(0, 1);
        gl_textPanel.setVgap(20);
        textPanel.setLayout(gl_textPanel);
        reportFrame.getContentPane().add(scrollPane);
<<<<<<< HEAD
       
=======
        
>>>>>>> origin/master
        int i=0;
        while (i < fields.length) {
            JLabel label = new JLabel((String) fields[i++], JLabel.RIGHT);
            label.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
            label.setForeground(new Color(98, 98, 98));
            labelPanel.add(label);
            textPanel.add((Component) fields[i++]);
        }
<<<<<<< HEAD
       

        testTable = new JTable();
        testTable.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
       
         ((DefaultCellEditor) testTable.getDefaultEditor(Object.class))
=======
        

        testTable = new JTable();
        testTable.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
        
        ((DefaultCellEditor) testTable.getDefaultEditor(Object.class))
>>>>>>> origin/master
         .getComponent().setFont(testTable.getFont());
         
        testTable.getTableHeader().setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
        testTable.setRowHeight(testTable.getRowHeight() + 20);
        testTable.putClientProperty("terminateEditOnFocusLost", true);
        scrollPane_1.setViewportView(testTable);
        //testTable.setAutoCreateColumnsFromModel(true);
        testTable.setAutoCreateRowSorter(true);
        testTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
<<<<<<< HEAD
       
=======
        
>>>>>>> origin/master
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(244, 244, 244));
        buttonPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        springLayout.putConstraint(SpringLayout.WEST, buttonPanel, 10, SpringLayout.EAST, scrollPane);
        springLayout.putConstraint(SpringLayout.SOUTH, buttonPanel, -10, SpringLayout.SOUTH, reportFrame.getContentPane());
        springLayout.putConstraint(SpringLayout.EAST, buttonPanel, -20, SpringLayout.EAST, reportFrame.getContentPane());
        buttonPanel.setSize(10, 50);
        buttonPanel.setLocation(719, 645);
        springLayout.putConstraint(SpringLayout.NORTH, buttonPanel, 11, SpringLayout.SOUTH, scrollPane_1);
        reportFrame.getContentPane().add(buttonPanel);
        buttonPanel.setLayout(new GridLayout(0, 2, 20, 0));
<<<<<<< HEAD
       
=======
        
>>>>>>> origin/master
        JButton btnInsert = new JButton("Print");
        buttonPanel.add(btnInsert);
        springLayout.putConstraint(SpringLayout.WEST, btnInsert, 750, SpringLayout.WEST, reportFrame.getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, btnInsert, 23, SpringLayout.SOUTH, scrollPane_1);
        springLayout.putConstraint(SpringLayout.SOUTH, btnInsert, -28, SpringLayout.SOUTH, reportFrame.getContentPane());
        btnInsert.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
<<<<<<< HEAD
       
        btnInsert.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                // checks the currently selected tab to check which tab to print
                 MessageFormat footer1;
                 MessageFormat header = new MessageFormat("Company Assets"); 
                try {
                   
                    if (printAsset_500 ==true ) {
                        footer1 = new MessageFormat("All Assets Over 500$");
                        testTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
                    }
                   
                    else if (printAsset_500_Year == true) {
                       
                        footer1 = new MessageFormat("By Year All Assets Over 500$");
                       // System.out.println(footer1.toString());
                        testTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
                       
                    }
                    else if (printExpired_Year == true) {
                        footer1 = new MessageFormat("Expired Assets");
                    //    System.out.println(footer1.toString());
                        testTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
                       
                    }
                    else if ( printAsset_500_Range == true ){
                        footer1 = new MessageFormat("Assets Over 500$ By Range Of Years");
                        testTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
                       
                    }
                   
                    else if ( printAsset_Room == true ){
                        footer1 = new MessageFormat("Assets By Room");
                        testTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
                   
                    }      
                   
                    else if ( printAsset_500_Cat == true ){   
                        footer1 = new MessageFormat("Assets Over 500$ By Category");
                        testTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
                   
                    }
                   
                    else if ( printAsset_500_Year_Cat == true ){
                        footer1 = new MessageFormat("Assets Over 500$ Specific Year & Category");
                        testTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
                   
                    }
                   
                    else if ( printDeactivated == true ){   
                        footer1 = new MessageFormat("Assets Removed From System");
                        testTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
                   
                    }
                   
                    else if ( printDeactivated_Cat == true ){
                        footer1 = new MessageFormat("Assets Removed By Category");
                        testTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
                    }
                   
                    else if ( printExpired_ToDate == true ){
                        footer1 = new MessageFormat("All Expired Assets To Date");
                        testTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
                    }
                   
                    else if ( printAssets_Warranty == true ){
                        footer1 = new MessageFormat("Assets By Warranty Date");
                        testTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
                    }
                   
                    else if ( printAsset_Leased == true ){
                        footer1 = new MessageFormat("Leased Assets Due Date" );
                        testTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
                    }
                   
                    else if ( printAssets_All_Category == true ){
                        footer1 = new MessageFormat("All Assets By Category");
                        testTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
                    }
                   
                } catch (PrinterException e1) {

                  e1.printStackTrace();
                }
              }
            });
       
       
=======
        
>>>>>>> origin/master
        JButton btnNewButton_1 = new JButton("Export to Excel");
        buttonPanel.add(btnNewButton_1);
        springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, (int)((scrollPane_1.getWidth() / 2) + 15), SpringLayout.WEST, scrollPane_1);
        springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -50, SpringLayout.EAST, reportFrame.getContentPane());
        springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 23, SpringLayout.SOUTH, scrollPane_1);
        springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -28, SpringLayout.SOUTH, reportFrame.getContentPane());
        btnNewButton_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
        springLayout.putConstraint(SpringLayout.EAST, btnInsert, -80, SpringLayout.WEST, btnNewButton_1);
<<<<<<< HEAD
       
       
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
					if(c==6||c==8||c==9||c==10|
							c==15||c==16||c==17)
					{
						return String.class;
					}
//					else if(c==20)
//					{
//						return Double.class;
//					}
					else
						return String.class;
			
			}
				
			};
           
            //query and resultset
=======
        
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
>>>>>>> origin/master
            String testTable_String = "Select * from MasterTable";
            PreparedStatement showTestTable = conn.prepareStatement(testTable_String);
            ResultSet rsTest = showTestTable.executeQuery();
            addRowsAndColumns(rsTest, dm);
<<<<<<< HEAD
           
            testTable.setModel(dm);
           
           
=======
            
            testTable.setModel(dm);
            
            //testTable.setModel(DbUtils.resultSetToTableModel(rsTest));

            //Refresh the table
          // tableModel.fireTableStructureChanged();
            //testTable.setModel(tableModel);
>>>>>>> origin/master
            refreshScreen();
            //System.out.println(tableModel.getRowCount());
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
<<<<<<< HEAD
   
    /*WORKING PROPERLY ALL ASSETS OVER 500 WITHIN USER CHOSEN RANGE OF DATES*/
    public static void update_Table_Assets_Over_500_Year_Range(String date, String date2) {
                                                                                           
=======
    
    /*WORKING PROPERLY ALL ASSETS OVER 500 WITHIN USER CHOSEN RANGE OF DATES*/
    public static void update_Table_Assets_Over_500_Year_Range(String date, String date2) { 
                                                                                            
>>>>>>> origin/master
        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {

            stmt = conn2.createStatement();
            DefaultTableModel dm = new DefaultTableModel();

            String showTestTable = "SELECT * From MasterTable" + " WHERE (Date_Acquired >= '" + date + "%'"
                    + " AND Date_Acquired <='" + date2 + "%' AND MasterTable.Price>=500)" + ";";

            PreparedStatement statement = conn2.prepareStatement(showTestTable);
            ResultSet rs = statement.executeQuery();

            addRowsAndColumns(rs, dm);
            testTable.setModel(dm);

            refreshScreen();
            conn2.close();

        } catch (SQLException e) {
            System.out.println("sql exception caught");
            e.printStackTrace();
        }
    }
<<<<<<< HEAD
   
=======
    
>>>>>>> origin/master
    /* WORKING PROPERLY ALL ASSETS OVER 500*/
    public static void UpDateTable_Assets_Over_500() {

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();

            DefaultTableModel dm = new DefaultTableModel();
            String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Price>=500");

            PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
            ResultSet rsTest = showTestTable.executeQuery();
            addRowsAndColumns(rsTest, dm);

            testTable.setModel(dm);

            refreshScreen();
            conn2.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
<<<<<<< HEAD
       
   
    /* WORKING PROPERLY ALL ASSETS OVER 500 FOR SINGLE YEAR CHOSEN BY USER*/
    public static void UpDateTable_Assets_Over_500_By_Year(String year2) { 
=======
        
    
    /* WORKING PROPERLY ALL ASSETS OVER 500 FOR SINGLE YEAR CHOSEN BY USER*/
    public static void UpDateTable_Assets_Over_500_By_Year(String year2) {  
>>>>>>> origin/master

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();
            DefaultTableModel dm = new DefaultTableModel();
            String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Price>=500 AND"
                                    + " MasterTable.Date_Acquired LIKE '" + year2 + "%';'");
<<<<<<< HEAD
           
=======
            
>>>>>>> origin/master
            PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
            ResultSet rsTest = showTestTable.executeQuery();

                    addRowsAndColumns(rsTest, dm);
                    testTable.setModel(dm);
                    refreshScreen();
                    conn2.close();
<<<<<<< HEAD
       
=======
        
>>>>>>> origin/master
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
<<<<<<< HEAD
   
   
=======
    
    
>>>>>>> origin/master
    /* RETURNS ASSEYS BASED OFF SPECIFIC ROOM NUMBER */
    public static void Update_Table_Search_By_Room(int room_Number) {

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();
            DefaultTableModel dm = new DefaultTableModel();
            String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Room = " + room_Number + ";");

            PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
            ResultSet rsTest = showTestTable.executeQuery();

            addRowsAndColumns(rsTest, dm);
            testTable.setModel(dm);
            refreshScreen();
            conn2.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
<<<<<<< HEAD
   
    /* RETURNS ASSETS OVER 500 BY YEAR AND CATEGORY */
    public static void UpDateTable_Assets_Over_500_By_Category(String category) { 
=======
    
    /* RETURNS ASSETS OVER 500 BY YEAR AND CATEGORY */
    public static void UpDateTable_Assets_Over_500_By_Category(String category) {  
>>>>>>> origin/master

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();
            DefaultTableModel dm = new DefaultTableModel();
            String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Price>=500 AND"
                                    + " MasterTable.Category LIKE '" + category + "%';'");
<<<<<<< HEAD
           
=======
            
>>>>>>> origin/master
            PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
            ResultSet rsTest = showTestTable.executeQuery();

                    addRowsAndColumns(rsTest, dm);
                    testTable.setModel(dm);
                    refreshScreen();
                    conn2.close();
<<<<<<< HEAD
       
=======
        
>>>>>>> origin/master
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
<<<<<<< HEAD
   
   
    public static void UpDateTable_All_Assets_By_Category(String category) { 
=======
    
    
    public static void UpDateTable_All_Assets_By_Category(String category) {  
>>>>>>> origin/master

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();
            DefaultTableModel dm = new DefaultTableModel();
            String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Category = '" + category + "';'");
<<<<<<< HEAD
           
=======
            
>>>>>>> origin/master
            PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
            ResultSet rsTest = showTestTable.executeQuery();

                    addRowsAndColumns(rsTest, dm);
                    testTable.setModel(dm);
                    refreshScreen();
                    conn2.close();
<<<<<<< HEAD
       
=======
        
>>>>>>> origin/master
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
<<<<<<< HEAD
   

   
    /* RETURNS ASSETS OVER 500 BY YEAR AND CATEGORY */
    public static void UpDateTable_Assets_Over_500_By_Category_And_Year(String year, String category) {
=======
    
    
/*    public static void UpDateTable_Deactivated_Assets(String category) {  

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();
            DefaultTableModel dm = new DefaultTableModel();
            String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Category = '" + category + "';'");
            
            PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
            ResultSet rsTest = showTestTable.executeQuery();

                    addRowsAndColumns(rsTest, dm);
                    testTable.setModel(dm);
                    refreshScreen();
                    conn2.close();
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
*/    
    
    
    
    
    /* RETURNS ASSETS OVER 500 BY YEAR AND CATEGORY */
    public static void UpDateTable_Assets_Over_500_By_Category_And_Year(String year, String category) {  
>>>>>>> origin/master

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();
            DefaultTableModel dm = new DefaultTableModel();
            String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Price>=500 AND"
<<<<<<< HEAD
                    + " MasterTable.Category LIKE '" + category + "%' " + "AND Date_Acquired LIKE '" + year + "%';'");

            PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
            ResultSet rsTest = showTestTable.executeQuery();

            addRowsAndColumns(rsTest, dm);
            testTable.setModel(dm);
            refreshScreen();
            conn2.close();

=======
                                    + " MasterTable.Category LIKE '" + category + "%' "
                                            + "AND Date_Acquired LIKE '" + year + "%';'");
            
            PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
            ResultSet rsTest = showTestTable.executeQuery();

                    addRowsAndColumns(rsTest, dm);
                    testTable.setModel(dm);
                    refreshScreen();
                    conn2.close();
        
>>>>>>> origin/master
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
<<<<<<< HEAD

    // Where MasterTable.Deactivated LIKE 'Removed'"
=======
    
    
    //Where MasterTable.Deactivated LIKE 'Removed'"
>>>>>>> origin/master
    public static void UpDateTable_Retired_Assets() {

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();
            DefaultTableModel dm = new DefaultTableModel();
            String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Deactivated LIKE 'Removed'");

            PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
            ResultSet rsTest = showTestTable.executeQuery();

            addRowsAndColumns(rsTest, dm);
            testTable.setModel(dm);
            refreshScreen();
            conn2.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
<<<<<<< HEAD

    /* RETURN ALL EXPIRED ASSETS */
=======
    
    /* RETURN ALL EXPIRED ASSETS*/
>>>>>>> origin/master
    public static void UpDateTable_Expired_Assets(String year) {

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();
            DefaultTableModel dm = new DefaultTableModel();
<<<<<<< HEAD
            String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Expiration_Date LIKE '" + year
                    + "%';'");
=======
            String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Expiration_Date LIKE '" +year + "%';'");
>>>>>>> origin/master

            PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
            ResultSet rsTest = showTestTable.executeQuery();

            addRowsAndColumns(rsTest, dm);
            testTable.setModel(dm);
            refreshScreen();
            conn2.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
<<<<<<< HEAD

    /* RETURNS ALL EXPIRED ASSETS UP TO THE CURRENT DATE*/
    public static void UpDateTable_Expired_Assets_To_Date(String string) {
=======
    
    public static void UpDateTable_Expired_Assets_To_Date(String year) {
>>>>>>> origin/master

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();
            DefaultTableModel dm = new DefaultTableModel();
<<<<<<< HEAD
            String testTable_String = ("SELECT *" + " From MasterTable Where" + " MasterTable.Expiration_Date <= '"
                    + string + "';'");
=======
            String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Expiration_Date <= '" +year + "%';'");
>>>>>>> origin/master

            PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
            ResultSet rsTest = showTestTable.executeQuery();

            addRowsAndColumns(rsTest, dm);
            testTable.setModel(dm);
            refreshScreen();
            conn2.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
<<<<<<< HEAD

    /* Return EVERY ASSETS IN A CATEGORY */
    public static void UpDateTable_Retired_Assets_By_Category(String category) {
=======
    
    /* Return EVERY ASSETS IN A CATEGORY*/
    public static void UpDateTable_Retired_Assets_By_Category(String category) {  
>>>>>>> origin/master

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();
            DefaultTableModel dm = new DefaultTableModel();
<<<<<<< HEAD
            String testTable_String = ("SELECT *" + " From MasterTable"
                    + " Where MasterTable.Deactivated LIKE 'Removed'" + " AND MasterTable.Category = '" + category
                    + "';'");

            PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
            ResultSet rsTest = showTestTable.executeQuery();

            addRowsAndColumns(rsTest, dm);
            testTable.setModel(dm);
            refreshScreen();
            conn2.close();

=======
            String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Deactivated LIKE 'Removed'"
                    + " AND MasterTable.Category = '" + category + "';'");
            
            PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
            ResultSet rsTest = showTestTable.executeQuery();

                    addRowsAndColumns(rsTest, dm);
                    testTable.setModel(dm);
                    refreshScreen();
                    conn2.close();
        
>>>>>>> origin/master
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
<<<<<<< HEAD

=======
    
>>>>>>> origin/master
    /* RETURN ALL ASSETS WITH A WARRANTY EXPIRATION BY SPECIFIC YEAR */
    public static void UpDateTable_Warranty_Assets(String year) {

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();
            DefaultTableModel dm = new DefaultTableModel();
            String testTable_String = ("SELECT *" + " From MasterTable Where"
                    + " MasterTable.Warranty_Expiration_Date LIKE '" + year + "%';'");

            PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
            ResultSet rsTest = showTestTable.executeQuery();

            addRowsAndColumns(rsTest, dm);
            testTable.setModel(dm);
            refreshScreen();
            conn2.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /*RETURNS ALL ASSETS WITH LEASE EXPIRATION BY YEAR*/
    public static void UpDateTable_Leased_Assets(String year) {

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();
            DefaultTableModel dm = new DefaultTableModel();
            String testTable_String = ("SELECT *" + " From MasterTable " + "Where MasterTable.Lease_Expiration LIKE '"
                    + year + "%';'");

            PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
            ResultSet rsTest = showTestTable.executeQuery();

            addRowsAndColumns(rsTest, dm);
            testTable.setModel(dm);
            refreshScreen();
            conn2.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

<<<<<<< HEAD
    public static void addRowsAndColumns(ResultSet rs, DefaultTableModel dm) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        // Coding to get columns-
        int cols = rsmd.getColumnCount();
        String c[] = new String[cols];
        for (int i = 0; i < cols; i++) {
            c[i] = rsmd.getColumnName(i + 1);
=======

    
    
    public static void addRowsAndColumns(ResultSet rs, DefaultTableModel dm) throws SQLException
    {
        ResultSetMetaData rsmd=rs.getMetaData();
        //Coding to get columns-
        int cols=rsmd.getColumnCount();
        String c[]=new String[cols];
        for(int i=0;i<cols;i++){
            c[i]=rsmd.getColumnName(i+1);
>>>>>>> origin/master
            dm.addColumn(c[i]);
        }

        Object row[] = new Object[cols];
        while (rs.next()) {
            for (int i = 0; i < cols; i++) {
            	 if(i==3)
            	 {
                     row[i]=Integer.parseInt(rs.getString(4));

            	 }
//            	 if(i==20)
//            	 {
//                     row[i]=Double.parseDouble(rs.getString(21));
//            	 }
            	 else
                    row[i]=rs.getString(i+1);
                
            }
            dm.addRow(row);
        }
    }
<<<<<<< HEAD

    public static void refreshScreen() {
        testTable.revalidate();
        testTable.repaint();
        testTable.validate();//

=======
    public static void refreshScreen()
    {
        testTable.revalidate();
        testTable.repaint();
        testTable.validate();//
        
>>>>>>> origin/master
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
<<<<<<< HEAD

=======
    
>>>>>>> origin/master
    public void addCategoryColumns() {

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Distinct Category From MasterTable");

            String group = "";
            while (rs.next()) {
                group = rs.getString("Category");
                categoryAsset.addItem(group);
<<<<<<< HEAD
                categoryDeactivated.addItem(group);
                category.addItem(group);
                // field3.addItem(group);

                // System.out.println("Group name: " + group);
=======
               categoryDeactivated.addItem(group);
               category.addItem(group);
                //field3.addItem(group);
                
                //System.out.println("Group name: " + group);
>>>>>>> origin/master
            }
        } catch (SQLException e) {
            System.out.println("sql exception caught");
            e.printStackTrace();
        }
    }

    protected void assetUpdateState() {

        boolean assetByRoomEnabled = assetQuery.getSelectedItem().equals("Assets by Room #");
        roomNo.setEnabled(assetByRoomEnabled);

        boolean assetByYearEnabled = assetQuery.getSelectedItem().equals("Assets over $500 & Year acquired");
        year.setEnabled(assetByYearEnabled);

        boolean assetByYearRangeEnabled = assetQuery.getSelectedItem().equals("Assets over $500 within year range");
        yearStart.setEnabled(assetByYearRangeEnabled);
        yearEnd.setEnabled(assetByYearRangeEnabled);

        boolean assetByCategoryEnabled = assetQuery.getSelectedItem().equals("Assets over $500 from category");
        categoryAsset.setEnabled(assetByCategoryEnabled);

<<<<<<< HEAD
        boolean assetByCategoryAndYearEnabled = assetQuery.getSelectedItem()
                .equals("Assets over $500 from category & year acquired");
        year.setEnabled(assetByCategoryAndYearEnabled);
        categoryAsset.setEnabled(assetByCategoryAndYearEnabled);

        if (assetByYearEnabled || assetByCategoryAndYearEnabled)
            year.setEnabled(true);

        if (assetByCategoryAndYearEnabled || assetByCategoryEnabled)
            categoryAsset.setEnabled(true);

    }

    protected void deactivatedUpdateState() {

        boolean deactivatedByCategoryEnabled = deactivatedQuery.getSelectedItem()
                .equals("Deactivated assets from category");
        categoryDeactivated.setEnabled(deactivatedByCategoryEnabled);

    }

    protected void expiredUpdateState() {

        boolean ByYearEnabled = expiredQuery.getSelectedItem().equals("Expired assets to date");
        yearExpired.setEnabled(!ByYearEnabled);


    }
}
=======
    protected void assetUpdateState() {
           
       boolean assetByRoomEnabled = assetQuery.getSelectedItem().equals("Assets by Room #");
       roomNo.setEnabled(assetByRoomEnabled);
       
       boolean assetByYearEnabled = assetQuery.getSelectedItem().equals("Assets over $500 & Year acquired");
       year.setEnabled(assetByYearEnabled);
       
       boolean assetByYearRangeEnabled = assetQuery.getSelectedItem().equals("Assets over $500 within year range");
       yearStart.setEnabled(assetByYearRangeEnabled);
       yearEnd.setEnabled(assetByYearRangeEnabled);
       
       boolean assetByCategoryEnabled = assetQuery.getSelectedItem().equals("Assets over $500 from category");
       categoryAsset.setEnabled(assetByCategoryEnabled);
       
       boolean assetByCategoryAndYearEnabled = assetQuery.getSelectedItem().equals("Assets over $500 from category & year acquired");
       year.setEnabled(assetByCategoryAndYearEnabled);
       categoryAsset.setEnabled(assetByCategoryAndYearEnabled);
       
       if(assetByYearEnabled || assetByCategoryAndYearEnabled)
           year.setEnabled(true);
       
       if(assetByCategoryAndYearEnabled || assetByCategoryEnabled)
           categoryAsset.setEnabled(true);
           
    }
    
    protected void deactivatedUpdateState() {
       
       boolean deactivatedByCategoryEnabled = deactivatedQuery.getSelectedItem().equals("Deactivated assets from category");
       categoryDeactivated.setEnabled(deactivatedByCategoryEnabled);
           
    }
    
    protected void expiredUpdateState() {
       
       boolean ByYearEnabled = expiredQuery.getSelectedItem().equals("Expired assets to date");
       yearExpired.setEnabled(!ByYearEnabled);
       
       //if (ByYearEnabled || )
           
    }
}
>>>>>>> origin/master
