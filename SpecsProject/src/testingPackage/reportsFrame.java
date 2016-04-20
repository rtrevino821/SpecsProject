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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
		    
		    //booleans for printing reports
		    boolean printAsset_500 = false;
		    boolean printAsset_500_Year =false;
		    boolean printAsset_500_Range = false;
		    boolean printAsset_Room =false;
		    boolean printAsset_500_Cat =false;
		    boolean printAsset_500_Year_Cat =false;
		    boolean printDeactivated =false;  
		    boolean printDeactivated_Cat =false;
		    boolean printExpired_ToDate =false;
		    boolean printExpired_Year =false;  
		    boolean printAssets_Warranty =false;
		    boolean printAsset_Leased =false;  
		    boolean printAssets_All_Category=false;	
		    
		    
		    
		    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					reportsFrame window = new reportsFrame();
//					window.display();
					window.reportFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public reportsFrame() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
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
		
		reportFrame = new JFrame();
		reportFrame.setVisible(true);
		reportFrame.getContentPane().setBackground(new Color(244, 244, 244));
		reportFrame.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		reportFrame.setTitle("Reports");
		reportFrame.setBounds(100, 100, 1504, 793);
		reportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		reportFrame.setLocationRelativeTo(null);
		reportFrame.getContentPane().setLayout(null);
		reportFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		SpringLayout springLayout = new SpringLayout();
		reportFrame.getContentPane().setLayout(springLayout);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));
		reportFrame.setIconImage(icon.getImage());
		
		JScrollPane scrollPane_1 = new JScrollPane();
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 720, SpringLayout.WEST, reportFrame.getContentPane());
		scrollPane_1.setSize(792, 616);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 24, SpringLayout.NORTH, reportFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, -98, SpringLayout.SOUTH, reportFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, -21, SpringLayout.EAST, reportFrame.getContentPane());
		reportFrame.getContentPane().add(scrollPane_1);
		
		
		
		// Font styling for TextFields
		Font font = new Font("Segoe UI Semilight", Font.PLAIN, 20);
	    
		// instantiating textfields for each jlabel

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
	    
	    
	    JButton btnLoad1 = new JButton("Run");
	    btnLoad1.setFont(font);

	    // btnLoad1-4 Queries to run speciic reports....
	    btnLoad1.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e)  {
				try {
					if (assetQuery.getSelectedItem().equals("Assets over $500")) {
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
						//System.out.println(year3);
						UpDateTable_Assets_Over_500_By_Year(year3);
 
					}
					else if (assetQuery.getSelectedItem().equals("Assets over $500 within year range")) {
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
					    
						String year1 = yearStart.getText();
						String year2 = yearEnd.getText();
						//System.out.println(year1 + "  " + year2);
						update_Table_Assets_Over_500_Year_Range(year1,year2);
						
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
						
						try {
							int room_Number = Integer.parseInt(roomNo.getText());
							Update_Table_Search_By_Room(room_Number);
						} catch (NumberFormatException e1) {

							//e1.printStackTrace();
							if (e1.toString().contains("java.lang.NumberFormatException: For input string:")) {
								JOptionPane.showMessageDialog(null, "Enter valid Room Number");

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
					    
						String user_Category = (String) categoryAsset.getSelectedItem();
						String year_Category = year.getText();
						//System.out.println(user_Category +"  " + year_Category);
						UpDateTable_Assets_Over_500_By_Category_And_Year(year_Category, user_Category);
					}
					
					
				} catch (Exception  e1) {
					e1.printStackTrace();
				}
			
			
			}
		});

//	    
//	    JComboBox deactivatedQuery = new JComboBox();
//	    JComboBox categoryDeactivated = new JComboBox();
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
				}
				 
	    
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
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
					
					
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		}
	});

	    
	    
	    JButton btnLoad4 = new JButton("Run");
	    btnLoad4.setFont(font);
	    btnLoad4.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
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
					
					DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
					Date date = new Date();
					//System.out.println(dateFormat.format(date));
					UpDateTable_Expired_Assets_To_Date(dateFormat.format(date));
					
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
					
					String year_Expired = yearExpired.getText();
					System.out.println(year_Expired);
					UpDateTable_Expired_Assets(year_Expired);
				}
				
				
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
	});   // End of Queries for buttons btnLoad1-4
				
	  
	    
	    //These empty Jlabels are spacers between query groups
	    empty = new JLabel("");
	    JLabel empty2 = new JLabel("");
	    JLabel empty3 = new JLabel("");
	    JLabel empty4 = new JLabel("");
	    
	    //This check to see what query has been selected to enable pertenant fields
	    assetQuery.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                assetUpdateState();                  

            }
        });
	    assetUpdateState();
	    
	  //This check to see what query has been selected to enable pertenant fields
	    deactivatedQuery.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                deactivatedUpdateState();                  

            }
        });
	    deactivatedUpdateState();
	    
	  //This check to see what query has been selected to enable pertenant fields
	    expiredQuery.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                expiredUpdateState();                  

            }
        });
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
    	
    	JPanel labelPanel = new JPanel((LayoutManager) null);
    	labelPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    	labelPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
    	labelPanel.setBackground(new Color(244, 244, 244));
    	compPanel.add(labelPanel);
    	GridLayout gl_labelPanel = new GridLayout(0, 1);
    	gl_labelPanel.setVgap(20);
    	labelPanel.setLayout(gl_labelPanel);
    	
    	JPanel textPanel = new JPanel((LayoutManager) null);
    	textPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    	textPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
    	textPanel.setBackground(new Color(244, 244, 244));
    	compPanel.add(textPanel);
    	GridLayout gl_textPanel = new GridLayout(0, 1);
    	gl_textPanel.setVgap(20);
    	textPanel.setLayout(gl_textPanel);
    	reportFrame.getContentPane().add(scrollPane);
    	
    	int i=0;
    	while (i < fields.length) {
    		JLabel label = new JLabel((String) fields[i++], JLabel.RIGHT);
    		label.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
    		label.setForeground(new Color(98, 98, 98));
    		labelPanel.add(label);
    		textPanel.add((Component) fields[i++]);
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
    	
    	//Print button for reports 
    	JButton btnInsert = new JButton("Print");
    	buttonPanel.add(btnInsert);
    	springLayout.putConstraint(SpringLayout.WEST, btnInsert, 750, SpringLayout.WEST, reportFrame.getContentPane());
    	springLayout.putConstraint(SpringLayout.NORTH, btnInsert, 23, SpringLayout.SOUTH, scrollPane_1);
    	springLayout.putConstraint(SpringLayout.SOUTH, btnInsert, -28, SpringLayout.SOUTH, reportFrame.getContentPane());
    	btnInsert.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
    	
    	btnInsert.addActionListener(new ActionListener() {
    	     
    		// Individualize Reports based off which report is selected  
    		public void actionPerformed(ActionEvent e) {
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
    	        	//	System.out.println(footer1.toString());
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
    	        	
    	        	else  {
    	        		footer1 = new MessageFormat("All Assets"); 
    	        		testTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
    	        	}
    	        	
    	        } catch (PrinterException e1) {

    	          e1.printStackTrace();
    	        }
    	      }
    	    });
    	
    	
    	JButton btnNewButton_1 = new JButton("Export to Excel");
    	btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try {
					ConvertExcel.writeExcel(testTable);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		catch(NullPointerException e1)
        		{
        			if(e1.toString().contains("java.lang.NullPointerException"))
					{
						Scanner input = null;
						String line;
						try {
							input = new Scanner(new File("LogReportFrameNullPointer.txt"));
						} catch (FileNotFoundException e2) {
							e2.printStackTrace();
						}
						line = input.nextLine();
						JOptionPane.showMessageDialog(null, "Check ID_Tag: " + line  +"'s rows for errors");

					}
        		}
        		
        	}
        });
    	buttonPanel.add(btnNewButton_1);
    	springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, (int)((scrollPane_1.getWidth() / 2) + 15), SpringLayout.WEST, scrollPane_1);
    	springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, -50, SpringLayout.EAST, reportFrame.getContentPane());
    	springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 23, SpringLayout.SOUTH, scrollPane_1);
    	springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -28, SpringLayout.SOUTH, reportFrame.getContentPane());
    	btnNewButton_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
    	springLayout.putConstraint(SpringLayout.EAST, btnInsert, -80, SpringLayout.WEST, btnNewButton_1);
    	
    	
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
			
			
			refreshScreen();
			//System.out.println(tableModel.getRowCount());
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	/*WORKING PROPERLY ALL ASSETS OVER 500 WITHIN USER CHOSEN RANGE OF DATES*/
	public static void update_Table_Assets_Over_500_Year_Range(String date, String date2) { 
																							
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
		
	
	/* WORKING PROPERLY ALL ASSETS OVER 500 FOR SINGLE YEAR CHOSEN BY USER*/
	public static void UpDateTable_Assets_Over_500_By_Year(String year2) {  

		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Price>=500 AND"
									+ " MasterTable.Date_Acquired LIKE '" + year2 + "%';'");
			
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
	
	/* RETURNS ASSETS OVER 500 BY YEAR AND CATEGORY */
	public static void UpDateTable_Assets_Over_500_By_Category(String category) {  

		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Price>=500 AND"
									+ " MasterTable.Category LIKE '" + category + "%';'");
			
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
	
	
	public static void UpDateTable_All_Assets_By_Category(String category) {  

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
	

	
	/* RETURNS ASSETS OVER 500 BY YEAR AND CATEGORY */
	public static void UpDateTable_Assets_Over_500_By_Category_And_Year(String year, String category) {

		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Price>=500 AND"
					+ " MasterTable.Category LIKE '" + category + "%' " + "AND Date_Acquired LIKE '" + year + "%';'");

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

	// Where MasterTable.Deactivated LIKE 'Removed'"
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

	/* RETURN ALL EXPIRED ASSETS */
	public static void UpDateTable_Expired_Assets(String year) {

		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Expiration_Date LIKE '" + year
					+ "%';'");

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

	/* RETURNS ALL EXPIRED ASSETS UP TO THE CURRENT DATE*/
	public static void UpDateTable_Expired_Assets_To_Date(String string) {

		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable Where" + " MasterTable.Expiration_Date <= '"
					+ string + "';'");

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

	/* Return EVERY ASSETS IN A CATEGORY */
	public static void UpDateTable_Retired_Assets_By_Category(String category) {

		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable"
					+ " Where MasterTable.Deactivated LIKE 'Removed'" + " AND MasterTable.Category = '" + category
					+ "';'");

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

	public static void addRowsAndColumns(ResultSet rs, DefaultTableModel dm) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		// Coding to get columns-
		int cols = rsmd.getColumnCount();
		String c[] = new String[cols];
		for (int i = 0; i < cols; i++) {
			c[i] = rsmd.getColumnName(i + 1);
			dm.addColumn(c[i]);
		}

		Object row[] = new Object[cols];
		while (rs.next()) {
			for (int i = 0; i < cols; i++) {
				row[i] = rs.getString(i + 1);
			}
			dm.addRow(row);
		}
	}

	public static void refreshScreen() {
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

		try {
			stmt = conn2.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Distinct Category From MasterTable");

			String group = "";
			while (rs.next()) {
				group = rs.getString("Category");
				categoryAsset.addItem(group);
				categoryDeactivated.addItem(group);
				category.addItem(group);
				// field3.addItem(group);

				// System.out.println("Group name: " + group);
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
