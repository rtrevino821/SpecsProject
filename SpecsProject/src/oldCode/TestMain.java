package oldCode;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import excelPackage.ConvertExcel;
import net.proteanit.sql.DbUtils;
import sqliteConnection.SqliteConnectionTESTDB;

import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.Font;

public class TestMain {
	 

	private JFrame frame;
	private static JTable testTable;
	private JScrollPane scrollPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestMain window = new TestMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public TestMain() throws SQLException {
		Connection conn = SqliteConnectionTESTDB.dbConnector();
		initialize();
		
	}

	/**
	 * Initializev2 the contents of the frame.
	 */

	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(1440, 865);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 1418, 768);
		frame.getContentPane().add(panel);
		
		 

		Connection conn = SqliteConnectionTESTDB.dbConnector();

		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		btnNewButton.setBounds(171, 21, 140, 40);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new TestInsert();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		//DELETE
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		btnDelete.setBounds(482, 21, 140, 40);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = testTable.getSelectedRow();
				int rowCount = testTable.getRowCount();
				
				  if (row != -1 && !(rowCount >= row)) {
			            try {
			            	System.out.println("Row Count: " + rowCount);
							deleteRow(row+1);
						} catch (SQLException e) {
							e.printStackTrace();
						}
			        }// end of if condition
				  else{
					  try {
			            System.out.println("Num of Rows in Else: " + rowCount);
			            deleteLastRow(row);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					  
				  }
						

			}
		});
		panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		btnUpdate.setBounds(793, 21, 140, 40);
		panel.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UpDateTable();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(6, 97, 1406, 665);
		panel.add(scrollPane);
		
		
		//TABLE
		initTable();
		scrollPane.setViewportView(testTable);
		
		
		
		
		JButton btnExportExcel = new JButton("Export Excel");
		btnExportExcel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		btnExportExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ConvertExcel.writeExcel(testTable);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnExportExcel.setBounds(1104, 21, 140, 40);
		panel.add(btnExportExcel);

		
	}
	
	public void initTable() throws SQLException
	{
		Connection conn = SqliteConnectionTESTDB.dbConnector();
		DefaultTableModel dm = new DefaultTableModel()
		{
//			Class[] types = new Class [] {
//					//COL. TYPES ARE HERE!!!
//					java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
//					,java.lang.Integer.class
//			};

			@Override
			public Class getColumnClass(int c) {
				//System.out.println(getValueAt(0, c).getClass().toString());
				if(c == 1)
				{
					return Double.class;
				}
				else if(c==4)
				{
					return Double.class;

				}
				else
				   return getValueAt(0, c).getClass();
				}
		};
        //query and resultset
		String testTable_String = "Select * from Artwork";
		PreparedStatement showTestTable = conn.prepareStatement(testTable_String);
		ResultSet rsTest = showTestTable.executeQuery();
		addRowsAndColumns(rsTest, dm);
		
		testTable = new JTable(dm)	{


		};
		testTable.setColumnSelectionAllowed(true);
		testTable.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		
		 ((DefaultCellEditor) testTable.getDefaultEditor(Object.class))
         .getComponent().setFont(testTable.getFont());
		 
		testTable.getTableHeader().setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		testTable.setRowHeight(testTable.getRowHeight() + 20);
		testTable.putClientProperty("terminateEditOnFocusLost", true);
		//testTable.setAutoCreateColumnsFromModel(true);
		//testTable.setAutoCreateRowSorter(true);
		TableRowSorter<TableModel> sorter= new TableRowSorter<TableModel>(dm);
		testTable.setRowSorter(sorter);
		

		int y = testTable.getSelectedColumn();
		int x = testTable.getSelectedColumn();

		System.out.println("x: " + x + " y: " + y);
		
	}
	

	
	
	
	public static void UpDateTable() 
	{
		try 
		{
			Connection conn = SqliteConnectionTESTDB.dbConnector();
			DefaultTableModel dm = new DefaultTableModel()
			{
				
			};
	        //query and resultset
			String testTable_String = "Select * from Artwork";
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
            dm.addColumn(rsmd.getColumnName(i+1));
        }
        
        Object row[]=new Object[cols];
        while(rs.next()){
             for(int i=0;i<cols;i++){
            	 if(i== 1)
            	 {
                     row[i]=rs.getDouble(2);
                    // System.out.println(row[i].getClass().toString());
            	 }
            	 if(i ==4)
            	 {
            		 //System.out.println(Double.parseDouble(rs.getString(5)));
                     row[i]=rs.getDouble(5);

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
	}
	
	public static void CellEdits()
	{
		
	}
	
	public static void deleteLastRow(int row) throws SQLException 
	{
		// remove selected row from the model
		DefaultTableModel dm = (DefaultTableModel) testTable.getModel();
		String delRowString;
		
		delRowString  = (dm.getValueAt(row, 1).toString());//row-1 because db starts at 1

		System.out.println("Data: " + delRowString);
		//System.out.println(testTable.getSelectedRow());
		Connection conn = SqliteConnectionTESTDB.dbConnector();
		String query = "DELETE FROM Artwork WHERE Asset = ? ";
		PreparedStatement prepareDel = conn.prepareStatement(query);
		prepareDel.setString(1, delRowString);
		prepareDel.executeUpdate();
		UpDateTable();

	}
	
	public static void deleteRow(int row) throws SQLException
	{
		// remove selected row from the model
		DefaultTableModel dm = (DefaultTableModel) testTable.getModel();
		String delRowString;
		
		dm.removeRow(row);
		testTable.setModel(dm);
		delRowString  = (dm.getValueAt(row-1, 1).toString());//row-1 because db starts at 1

		
		System.out.println("Data: " + delRowString);
		//System.out.println(testTable.getSelectedRow());
		Connection conn = SqliteConnectionTESTDB.dbConnector();
		String query = "DELETE FROM Artwork WHERE Asset = ? ";
		PreparedStatement prepareDel = conn.prepareStatement(query);
		prepareDel.setString(1, delRowString);
		prepareDel.executeUpdate();
		UpDateTable();

	}
	
	
}//end of TestMain	

