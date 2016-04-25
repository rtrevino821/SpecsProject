package mainPackage;
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

import excelPackage.ConvertExcel;
import sqliteConnection.SqliteConnectionTESTDB;

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

public class reportsFrame {

	private JFrame reportFrame;
	private static JTable reportsTable;

	// instantiating textfields for each jlabel
	JComboBox assetQuery = new JComboBox();
	JTextField roomNo = new JTextField();
	JTextField year = new JTextField();
	JTextField yearStart = new JTextField();
	JTextField yearEnd = new JTextField();
	JComboBox categoryAsset = new JComboBox();

	JComboBox deactivatedQuery = new JComboBox();
	JComboBox categoryDeactivated = new JComboBox();

	JComboBox expiredQuery = new JComboBox();
	JTextField yearExpired = new JTextField();

	JLabel empty = new JLabel(" ");


	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					reportsFrame window = new reportsFrame();
					// window.display();
					window.reportFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public reportsFrame() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		Connection conn = SqliteConnectionTESTDB.dbConnector();
		initialize();
		UpDateTable();

	}

	/**
	* Initialize the contents of the frame.
	*/
	private void initialize() {

		Connection conn = SqliteConnectionTESTDB.dbConnector();

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
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 720, SpringLayout.WEST,
				reportFrame.getContentPane());
		scrollPane_1.setSize(792, 616);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 24, SpringLayout.NORTH,
				reportFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, -98, SpringLayout.SOUTH,
				reportFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, -21, SpringLayout.EAST,
				reportFrame.getContentPane());
		reportFrame.getContentPane().add(scrollPane_1);

		// Font styling for TextFields
		Font font = new Font("Segoe UI Semilight", Font.PLAIN, 20);

		// instantiating textfields for each jlabel
		addCategoriesToJCombo();
		
		//setting custom font
		assetQuery.setFont(font);
		roomNo.setFont(font);
		year.setFont(font);
		yearStart.setFont(font);
		yearEnd.setFont(font);
		categoryAsset.setFont(font);
		deactivatedQuery.setFont(font);
		categoryDeactivated.setFont(font);
		expiredQuery.setFont(font);
		yearExpired.setFont(font);

		// drop down options for assets
		String[] assetQueries = { "Select Asset Query", "Assets by Room #", "Assets by Category", "Assets over $500",
				"Assets over $500 & Year acquired", "Assets over $500 within year range",
				"Assets over $500 from category", "Assets over $500 from category & year acquired" };

		//inserts options into assetQuery JComboBox
		for (int i = 0; i < assetQueries.length; i++) {
			assetQuery.addItem(assetQueries[i]);
		}

		// drop down options for deactivated assets
		String[] deactivatedQueries = { "Select Deactivated Asset Query", "Deactivated assets",
				"Deactivated assets from category" };
		
		//inserts options into deactivatedQuery JComboBox
		for (int i = 0; i < deactivatedQueries.length; i++) {
			deactivatedQuery.addItem(deactivatedQueries[i]);
		}

		// drop down options for expired assets
		String[] expiredQueries = { "Expired assets to date", "Expired assets by year", "Warranty expiration by year",
				"Lease expiration by year" };

		//inserts options into expiredQuery JComboBox
		for (int i = 0; i < expiredQueries.length; i++) {
			expiredQuery.addItem(expiredQueries[i]);
		}

		JButton btnRunAssetQuery = new JButton("Run");
		btnRunAssetQuery.setFont(font);

		// Button to run specific reports....
		btnRunAssetQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					deactivatedQuery.setSelectedIndex(0);
					expiredQuery.setSelectedIndex(0);

					if (assetQuery.getSelectedItem().equals("Assets over $500")) {

						UpDateTable_Assets_Over_500();

					} else if (assetQuery.getSelectedItem().equals("Assets by Category")) {
						String all_Category = (String) categoryAsset.getSelectedItem();
						UpDateTable_All_Assets_By_Category(all_Category);
					} else if (assetQuery.getSelectedItem().equals("Assets over $500 & Year acquired")) {

						String year3 = year.getText();
						UpDateTable_Assets_Over_500_By_Year(year3);

					} else if (assetQuery.getSelectedItem().equals("Assets over $500 within year range")) {

						String year1 = yearStart.getText();
						String year2 = yearEnd.getText();
						update_Table_Assets_Over_500_Year_Range(year1, year2);

					} else if (assetQuery.getSelectedItem().equals("Assets by Room #")) {

						try {
							int room_Number = Integer.parseInt(roomNo.getText());
							Update_Table_Search_By_Room(room_Number);
						} catch (NumberFormatException e1) {

							// e1.printStackTrace();
							if (e1.toString().contains("java.lang.NumberFormatException: For input string:")) {
								JOptionPane.showMessageDialog(null, "Enter valid Room Number");

							}
						}

					}

					else if (assetQuery.getSelectedItem().equals("Assets over $500 from category")) {

						String category_500 = (String) categoryAsset.getSelectedItem();
						UpDateTable_Assets_Over_500_By_Category(category_500);

					}

					else if (assetQuery.getSelectedItem().equals("Assets over $500 from category & year acquired")) {

						String user_Category = (String) categoryAsset.getSelectedItem();
						String year_Category = year.getText();
						UpDateTable_Assets_Over_500_By_Category_And_Year(year_Category, user_Category);
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});


		JButton btnRunDeactivatedQuery = new JButton("Run");
		btnRunDeactivatedQuery.setFont(font);
		btnRunDeactivatedQuery.setFont(font);
		btnRunDeactivatedQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					assetQuery.setSelectedIndex(0);
					expiredQuery.setSelectedIndex(0);

					if (deactivatedQuery.getSelectedItem().equals("Deactivated assets")) {

						UpDateTable_Retired_Assets();
					}

					else if (deactivatedQuery.getSelectedItem().equals("Deactivated assets from category")) {

						String deactivated_Category = (String) categoryDeactivated.getSelectedItem();
						System.out.println(deactivated_Category);
						UpDateTable_Retired_Assets_By_Category(deactivated_Category);
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});

		JButton btnRunExpiredQuery = new JButton("Run");
		btnRunExpiredQuery.setFont(font);
		btnRunExpiredQuery.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					assetQuery.setSelectedIndex(0);
					deactivatedQuery.setSelectedIndex(0);

					if (expiredQuery.getSelectedItem().equals("Expired assets to date")) {

						DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
						Date date = new Date();
						UpDateTable_Expired_Assets_To_Date(dateFormat.format(date));

					}

					else if (expiredQuery.getSelectedItem().equals("Expired assets by year")) {

						String year_Expired = yearExpired.getText();
						System.out.println(year_Expired);
						upDateTable_Expired_Assets_By_Year(year_Expired);

					}

					else if (expiredQuery.getSelectedItem().equals("Warranty expiration by year")) {

						String warranty_Date = yearExpired.getText();
						UpDateTable_Warranty_Assets(warranty_Date);

					}

					else if (expiredQuery.getSelectedItem().equals("Lease expiration by year")) {

						String assets_Leased = yearExpired.getText();
						UpDateTable_Leased_Assets(assets_Leased);

					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		}); // End of Queries for Run buttons

		// These empty Jlabels are spacers between query groups
		empty = new JLabel("");
		JLabel empty2 = new JLabel("");
		JLabel empty3 = new JLabel("");

		// This check to see what query has been selected to enable pertinent
		// fields (Set options to editable)
		assetQuery.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				assetUpdateState();
			}
		});
		
		assetUpdateState();

		// This check to see what query has been selected to enable pertinent
		// fields (Set options to editable)
		deactivatedQuery.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				deactivatedUpdateState();

			}
		});
		deactivatedUpdateState();

		// This check to see what query has been selected to enable pertinent
		// fields  (Set options to editable)
		expiredQuery.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				expiredUpdateState();

			}
		});
		expiredUpdateState();

		// array of labels and corresponding textFields for use in display()
		Object[] fields = {
				// Assets Queries
				"General Assets   ", 			empty, // Spacer

				"Select All:    ", 				assetQuery,
				"From Room No.:    ",			roomNo, 
				"From Year:    ", 				year, 
				"From Year:    ",				yearStart, 
				"to Year:    ", 				yearEnd, 
				"From Category:    ", 			categoryAsset,
				"    ", 						btnRunAssetQuery, //Run Button

				// Deactivated Queries
				"Deactivated Assets   ", 		empty2, // Spacer

				"Select all:    ", 				deactivatedQuery, 
				"From Category:    ", 			categoryDeactivated, 
				"    ", 						btnRunDeactivatedQuery, //Run Button

				// Expired Queries
				"Expired Assets    ", 			empty3, // spacer

				"Select All:    ", 				expiredQuery, 
				"From Year:    ", 				yearExpired, 
				"    ", 						btnRunExpiredQuery //Run Button
				};
		
		
		JPanel compPanel = new JPanel();
		compPanel.setBorder(new EmptyBorder(45, 0, 0, 25));
		compPanel.setBackground(new Color(244, 244, 244));
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -32, SpringLayout.SOUTH,
				reportFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 24, SpringLayout.NORTH,
				reportFrame.getContentPane());
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

		
		int i = 0;
		while (i < fields.length) {
			JLabel label = new JLabel((String) fields[i++], JLabel.RIGHT);
			label.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
			label.setForeground(new Color(98, 98, 98));
			labelPanel.add(label);
			textPanel.add((Component) fields[i++]);
		}

		reportsTable = new JTable();
		reportsTable.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		((DefaultCellEditor) reportsTable.getDefaultEditor(Object.class)).getComponent().setFont(reportsTable.getFont());
		reportsTable.getTableHeader().setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		reportsTable.setRowHeight(reportsTable.getRowHeight() + 20);
		reportsTable.putClientProperty("terminateEditOnFocusLost", true);
		scrollPane_1.setViewportView(reportsTable);
		reportsTable.setAutoCreateRowSorter(true);
		reportsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//JPanel to hold buttons for x=scaling purposes
		JPanel buttonPanel = new JPanel(); 
		buttonPanel.setBackground(new Color(244, 244, 244));
		buttonPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
		springLayout.putConstraint(SpringLayout.WEST, buttonPanel, 10, SpringLayout.EAST, scrollPane);
		springLayout.putConstraint(SpringLayout.SOUTH, buttonPanel, -10, SpringLayout.SOUTH,
				reportFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonPanel, -20, SpringLayout.EAST,
				reportFrame.getContentPane());
		buttonPanel.setSize(10, 50);
		buttonPanel.setLocation(719, 645);
		springLayout.putConstraint(SpringLayout.NORTH, buttonPanel, 11, SpringLayout.SOUTH, scrollPane_1);
		reportFrame.getContentPane().add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(0, 2, 20, 0));

		// Print button for reports
		JButton btnPrint = new JButton("Print");
		buttonPanel.add(btnPrint);
		springLayout.putConstraint(SpringLayout.WEST, btnPrint, 750, SpringLayout.WEST, reportFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnPrint, 23, SpringLayout.SOUTH, scrollPane_1);
		springLayout.putConstraint(SpringLayout.SOUTH, btnPrint, -28, SpringLayout.SOUTH, reportFrame.getContentPane());
		btnPrint.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));

		btnPrint.addActionListener(new ActionListener() {

			// Individualize Reports based off which report is selected
			public void actionPerformed(ActionEvent e) {
				MessageFormat footer1;
				MessageFormat header = new MessageFormat("Company Assets");
				try {

					if (assetQuery.getSelectedItem().equals("Assets by Room #")) {

						footer1 = new MessageFormat("Assets By Room");
						reportsTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
					}

					else if (assetQuery.getSelectedItem().equals("Assets by Category")) {

						footer1 = new MessageFormat("All Assets By Category");
						reportsTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
					}

					else if (assetQuery.getSelectedItem().equals("Assets over $500")) {
						footer1 = new MessageFormat("All Assets Over $500");
						reportsTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
					}

					else if (assetQuery.getSelectedItem().equals("Assets over $500 & Year acquired")) {
						footer1 = new MessageFormat("By Year All Assets Over $500");
						reportsTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
					}

					else if (assetQuery.getSelectedItem().equals("Assets over $500 within year range")) {

						footer1 = new MessageFormat("Assets Over $500 By Range Of Years");
						reportsTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
					}

					else if (assetQuery.getSelectedItem().equals("Assets over $500 from category")) {

						footer1 = new MessageFormat("Assets Over $500 By Category");
						reportsTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
					}

					else if (assetQuery.getSelectedItem().equals("Assets over $500 from category & year acquired")) {

						footer1 = new MessageFormat("Assets Over $500 Specific Year & Category");
						reportsTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
					}

					else if (expiredQuery.getSelectedItem().equals("Expired assets by year")) {
						footer1 = new MessageFormat("Expired Assets");
						reportsTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
					}

					else if (deactivatedQuery.getSelectedItem().equals("Deactivated assets")) {

						footer1 = new MessageFormat("Assets Removed From System");
						reportsTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
					}

					else if (deactivatedQuery.getSelectedItem().equals("Deactivated assets from category")) {

						footer1 = new MessageFormat("Assets Removed By Category");
						reportsTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
					}

					else if (expiredQuery.getSelectedItem().equals("Expired assets to date")) {

						footer1 = new MessageFormat("All Expired Assets To Date");
						reportsTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
					}

					else if (expiredQuery.getSelectedItem().equals("Warranty expiration by year")) {

						footer1 = new MessageFormat("Assets By Warranty Date");
						reportsTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
					}

					else if (expiredQuery.getSelectedItem().equals("Lease expiration by year")) {

						footer1 = new MessageFormat("Leased Assets Due Date");
						reportsTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
					}

					else {

						footer1 = new MessageFormat("All Assets");
						reportsTable.print(JTable.PrintMode.FIT_WIDTH, header, footer1);
					}

				} catch (PrinterException e1) {

					e1.printStackTrace();
				}
			}
		});

		//Export to Excel Button
		JButton btnExportToExcel = new JButton("Export to Excel");
		btnExportToExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ConvertExcel.writeExcel(reportsTable);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (NullPointerException e1) {
					if (e1.toString().contains("java.lang.NullPointerException")) {
						Scanner input = null;
						String line;
						try {
							input = new Scanner(new File("LogReportFrameNullPointer.txt"));
						} catch (FileNotFoundException e2) {
							e2.printStackTrace();
						}
						line = input.nextLine();
						JOptionPane.showMessageDialog(null, "Check ID_Tag: " + line + "'s rows for errors");
					}
				}

			}
		});
		buttonPanel.add(btnExportToExcel);
		springLayout.putConstraint(SpringLayout.WEST, btnExportToExcel, (int) ((scrollPane_1.getWidth() / 2) + 15),
				SpringLayout.WEST, scrollPane_1);
		springLayout.putConstraint(SpringLayout.EAST, btnExportToExcel, -50, SpringLayout.EAST,
				reportFrame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnExportToExcel, 23, SpringLayout.SOUTH, scrollPane_1);
		springLayout.putConstraint(SpringLayout.SOUTH, btnExportToExcel, -28, SpringLayout.SOUTH,
				reportFrame.getContentPane());
		btnExportToExcel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		springLayout.putConstraint(SpringLayout.EAST, btnPrint, -80, SpringLayout.WEST, btnExportToExcel);

	} //end initialize

	//update table from most recent data in database
	public static void UpDateTable() {
		try {
			Connection conn = SqliteConnectionTESTDB.dbConnector();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = "Select * from MasterTable";
			PreparedStatement showTestTable = conn.prepareStatement(testTable_String);
			ResultSet rsTest = showTestTable.executeQuery();
			addRowsAndColumns(rsTest, dm);
			reportsTable.setModel(dm);
			refreshScreen();

			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// Filters assets to "All assets over 500 within user chosen range of dates"
	public static void update_Table_Assets_Over_500_Year_Range(String startDate, String endDate) {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {

			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();

			String showTestTable = "SELECT * From MasterTable" + " WHERE (Date_Acquired >= '" + startDate + "%'"
					+ " AND Date_Acquired <='" + endDate + "%' AND MasterTable.Price>=500)" + ";";

			PreparedStatement statement = conn2.prepareStatement(showTestTable);
			ResultSet rs = statement.executeQuery();

			addRowsAndColumns(rs, dm);
			reportsTable.setModel(dm);

			refreshScreen();
			conn2.close();

		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
	}

	// Filters assets to "All assets over 500"
	public static void UpDateTable_Assets_Over_500() {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();

			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Price>=500");

			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
			ResultSet rsTest = showTestTable.executeQuery();
			addRowsAndColumns(rsTest, dm);

			reportsTable.setModel(dm);

			refreshScreen();
			conn2.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// Filters assets to "All assets over 500 for single year chosen by user
	public static void UpDateTable_Assets_Over_500_By_Year(String year) {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Price>=500 AND"
					+ " MasterTable.Date_Acquired LIKE '" + year + "%';'");

			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
			ResultSet rsTest = showTestTable.executeQuery();

			addRowsAndColumns(rsTest, dm);
			reportsTable.setModel(dm);
			refreshScreen();
			conn2.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// Filters assets to all assets in specified room
	public static void Update_Table_Search_By_Room(int room_Number) {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Room = " + room_Number + ";");

			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
			ResultSet rsTest = showTestTable.executeQuery();

			addRowsAndColumns(rsTest, dm);
			reportsTable.setModel(dm);
			refreshScreen();
			conn2.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	//Filters assets to all assets over 500 by category specified by user
	public static void UpDateTable_Assets_Over_500_By_Category(String category) {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Price>=500 AND"
					+ " MasterTable.Category LIKE '" + category + "%';'");

			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
			ResultSet rsTest = showTestTable.executeQuery();

			addRowsAndColumns(rsTest, dm);
			reportsTable.setModel(dm);
			refreshScreen();
			conn2.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// Filters assets to all assets of user specified category
	public static void UpDateTable_All_Assets_By_Category(String category) {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Category = '" + category
					+ "';'");

			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
			ResultSet rsTest = showTestTable.executeQuery();

			addRowsAndColumns(rsTest, dm);
			reportsTable.setModel(dm);
			refreshScreen();
			conn2.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// Filters assets to all assets over 500 by year and by category
	public static void UpDateTable_Assets_Over_500_By_Category_And_Year(String year, String category) {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Price>=500 AND"
					+ " MasterTable.Category LIKE '" + category + "%' " + "AND Date_Acquired LIKE '" + year + "%';'");

			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
			ResultSet rsTest = showTestTable.executeQuery();

			addRowsAndColumns(rsTest, dm);
			reportsTable.setModel(dm);
			refreshScreen();
			conn2.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// Filters assets to all assets with Y in the deactivated column
	public static void UpDateTable_Retired_Assets() {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Deactivated LIKE 'Y'");

			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
			ResultSet rsTest = showTestTable.executeQuery();

			addRowsAndColumns(rsTest, dm);
			reportsTable.setModel(dm);
			refreshScreen();
			conn2.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// Filters assets to all expired assets within year specified
	public static void upDateTable_Expired_Assets_By_Year(String year) {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable Where MasterTable.Expiration_Date LIKE '" + year
					+ "%';'");

			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
			ResultSet rsTest = showTestTable.executeQuery();

			addRowsAndColumns(rsTest, dm);
			reportsTable.setModel(dm);
			refreshScreen();
			conn2.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	//Filters assets to all expired assets to date
	public static void UpDateTable_Expired_Assets_To_Date(String string) {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable Where" + " MasterTable.Expiration_Date <= '"
					+ string + "';'");

			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
			ResultSet rsTest = showTestTable.executeQuery();

			addRowsAndColumns(rsTest, dm);
			reportsTable.setModel(dm);
			refreshScreen();
			conn2.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// FIlters assets to all assets within specified category
	public static void UpDateTable_Retired_Assets_By_Category(String category) {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
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
			reportsTable.setModel(dm);
			refreshScreen();
			conn2.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// Filters assets to all assets with warranty expiration matching specified year
	public static void UpDateTable_Warranty_Assets(String year) {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable Where"
					+ " MasterTable.Warranty_Expiration_Date LIKE '" + year + "%';'");

			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
			ResultSet rsTest = showTestTable.executeQuery();

			addRowsAndColumns(rsTest, dm);
			reportsTable.setModel(dm);
			refreshScreen();
			conn2.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// Filter assets to all assets with lease expiration matching user specified year
	public static void UpDateTable_Leased_Assets(String year) {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			DefaultTableModel dm = new DefaultTableModel();
			String testTable_String = ("SELECT *" + " From MasterTable " + "Where MasterTable.Lease_Expiration LIKE '"
					+ year + "%';'");

			PreparedStatement showTestTable = conn2.prepareStatement(testTable_String);
			ResultSet rsTest = showTestTable.executeQuery();

			addRowsAndColumns(rsTest, dm);
			reportsTable.setModel(dm);
			refreshScreen();
			conn2.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	// Populates JTable and names columns
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

	// Repaints the paints the Jtable
	public static void refreshScreen() {
		reportsTable.revalidate();
		reportsTable.repaint();
		reportsTable.validate();
		
		//setting column widths in reports table
		reportsTable.getColumnModel().getColumn(0).setPreferredWidth(380);
		reportsTable.getColumnModel().getColumn(1).setPreferredWidth(380);
		reportsTable.getColumnModel().getColumn(2).setPreferredWidth(320);
		reportsTable.getColumnModel().getColumn(3).setPreferredWidth(150);
		reportsTable.getColumnModel().getColumn(4).setPreferredWidth(100);
		reportsTable.getColumnModel().getColumn(5).setPreferredWidth(120);
		reportsTable.getColumnModel().getColumn(6).setPreferredWidth(220);
		reportsTable.getColumnModel().getColumn(7).setPreferredWidth(220);
		reportsTable.getColumnModel().getColumn(8).setPreferredWidth(220);																		
		reportsTable.getColumnModel().getColumn(9).setPreferredWidth(220);																	
		reportsTable.getColumnModel().getColumn(10).setPreferredWidth(220);																			
		reportsTable.getColumnModel().getColumn(11).setPreferredWidth(320);
		reportsTable.getColumnModel().getColumn(12).setPreferredWidth(320);
		reportsTable.getColumnModel().getColumn(13).setPreferredWidth(320);
		reportsTable.getColumnModel().getColumn(14).setPreferredWidth(320);
		reportsTable.getColumnModel().getColumn(15).setPreferredWidth(320);
		reportsTable.getColumnModel().getColumn(16).setPreferredWidth(320);
		reportsTable.getColumnModel().getColumn(17).setPreferredWidth(320);
		reportsTable.getColumnModel().getColumn(18).setPreferredWidth(320);
		reportsTable.getColumnModel().getColumn(19).setPreferredWidth(320);
		reportsTable.getColumnModel().getColumn(20).setPreferredWidth(320);
		reportsTable.getColumnModel().getColumn(21).setPreferredWidth(180);
		reportsTable.getColumnModel().getColumn(22).setPreferredWidth(320);
		reportsTable.getColumnModel().getColumn(23).setPreferredWidth(320);
	}

	// Adds categories to category drop down boxes
	public void addCategoriesToJCombo() {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Distinct Category From MasterTable");

			String group = "";
			while (rs.next()) {
				group = rs.getString("Category");
				categoryAsset.addItem(group);
				categoryDeactivated.addItem(group);

			}
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
	}

	//Sets certain JTextFields and Drop downs to editable based of what query is selected
	// Example: "Assets by Room #" is selected then Room # JTextField becomes available
	protected void assetUpdateState() {

		boolean assetByRoomEnabled = assetQuery.getSelectedItem().equals("Assets by Room #");
		roomNo.setEnabled(assetByRoomEnabled);

		boolean assetByCategoryEnabled = assetQuery.getSelectedItem().equals("Assets by Category");
		categoryAsset.setEnabled(assetByCategoryEnabled);

		boolean assetByYearEnabled = assetQuery.getSelectedItem().equals("Assets over $500 & Year acquired");
		year.setEnabled(assetByYearEnabled);

		boolean assetByYearRangeEnabled = assetQuery.getSelectedItem().equals("Assets over $500 within year range");
		yearStart.setEnabled(assetByYearRangeEnabled);
		yearEnd.setEnabled(assetByYearRangeEnabled);

		boolean asset500ByCategoryEnabled = assetQuery.getSelectedItem().equals("Assets over $500 from category");
		categoryAsset.setEnabled(asset500ByCategoryEnabled);

		boolean assetByCategoryAndYearEnabled = assetQuery.getSelectedItem()
				.equals("Assets over $500 from category & year acquired");
		year.setEnabled(assetByCategoryAndYearEnabled);
		categoryAsset.setEnabled(assetByCategoryAndYearEnabled);

		if (assetByYearEnabled || assetByCategoryAndYearEnabled)
			year.setEnabled(true);

		if (assetByCategoryAndYearEnabled || assetByCategoryEnabled || asset500ByCategoryEnabled)
			categoryAsset.setEnabled(true);

	}

	//Sets certain JTextFields and Drop downs to editable based of what query is selected
	protected void deactivatedUpdateState() {

		boolean deactivatedByCategoryEnabled = deactivatedQuery.getSelectedItem()
				.equals("Deactivated assets from category");
		categoryDeactivated.setEnabled(deactivatedByCategoryEnabled);

	}

	//Sets certain JTextFields and Drop downs to editable based of what query is selected
	protected void expiredUpdateState() {

		boolean ByYearEnabled = expiredQuery.getSelectedItem().equals("Expired assets to date");
		yearExpired.setEnabled(!ByYearEnabled);

	}
} //end of ReportsFrame
	