package testingPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class testClass {
	 

	private JFrame frame;
	private static JTable testTable;
	
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
					testClass window = new testClass();
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
	public testClass() throws SQLException {
		Connection conn = sqliteConnectionTEST.dbConnector();
		initialize();
		UpDateTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setSize(1440, 865);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 1418, 814);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		 

		Connection conn = sqliteConnectionTEST.dbConnector();

		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new TestInsert();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
	
		btnNewButton.setBounds(20, 24, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int[] row = testTable.getSelectedRows();
				System.out.println(testTable.getSelectedRows());
			}
		});
		btnDelete.setBounds(133, 24, 89, 23);
		panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(254, 24, 89, 23);
		panel.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UpDateTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 55, 1406, 773);
		panel.add(scrollPane);
		
		
		
		
		testTable = new JTable();
		scrollPane.setViewportView(testTable);
		testTable.setAutoCreateColumnsFromModel(true);

		
	}
	
	public static void UpDateTable() 
	{
		
		
		try 
		{
			Connection conn = sqliteConnectionTEST.dbConnector();
			DefaultTableModel dm = new DefaultTableModel();
	        //query and resultset
			String testTable_String = "Select * from Electronics";
			PreparedStatement showTestTable = conn.prepareStatement(testTable_String);
			ResultSet rsTest = showTestTable.executeQuery();
			addRowsAndColumns(rsTest, dm);
			
			testTable.setModel(dm);
			
			//testTable.setModel(DbUtils.resultSetToTableModel(rsTest));
		    DefaultTableModel tableModel = (DefaultTableModel) testTable.getModel();

			//Refresh the table
		   // tableModel.fireTableStructureChanged();
			//testTable.setModel(tableModel);
			testTable.revalidate();
			testTable.repaint();
			testTable.validate();//			
			System.out.println(tableModel.getRowCount());
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
//	public static void deleteRow()
//	{
//		 DefaultTableModel dm = new DefaultTableModel();
//
//		 dm.removeRow(row);
//		
//		 JTable table = (JTable)e.getSource();
//	        int modelRow = Integer.valueOf( e.getActionCommand() );
//	        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
//		  
//		  for(int i =0; i<row.length;i++)
//		  {
//			  
//		  }
		
		
//		try {
//			Connection conn = sqliteConnectionTEST.dbConnector();
//			PreparedStatement pst;
//	          pst = conn
//	              .prepareStatement("DELETE FROM Electronics WHERE EmployeeName = ?");
//	          pst.setString(1, empName.getText());
//	          pst.executeUpdate();
//	          JOptionPane.showMessageDialog(null, "Removed");
//
//	        } catch (Exception e) {
//	          JOptionPane.showMessageDialog(null, e);
//	        }
//	        UpDateTable();
//	      }
	
	
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
	
	
	
	
}
