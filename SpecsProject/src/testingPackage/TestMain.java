package testingPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class TestMain {
	 

	private JFrame frame;
	private static JTable testTable;
	private TableModelListener tableModelListener;
	
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
		
		 

		Connection conn = sqliteConnectionTEST.dbConnector();

		
		JButton btnNewButton = new JButton("Insert");
		btnNewButton.setBounds(20, 24, 89, 23);
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
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		//DELETE
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(133, 24, 89, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = testTable.getSelectedRow();
				  if (row != -1) {
			            try {
							deleteRow(row+1);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        }
			}
		});
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
		
		
		
		//TestTable
		testTable = new JTable();
		testTable.putClientProperty("terminateEditOnFocusLost", true);
        testTable.setCellSelectionEnabled(true);
		scrollPane.setViewportView(testTable);
		
		//testTable.setAutoCreateColumnsFromModel(true);
		setTableModelListener();
		JButton btnExportExcel = new JButton("Export Excel");
		btnExportExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ConvertExcel.writeExcel(testTable);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnExportExcel.setBounds(433, 21, 113, 28);
		panel.add(btnExportExcel);

		
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

			//Refresh the table
		   // tableModel.fireTableStructureChanged();
			//testTable.setModel(tableModel);
			testTable.revalidate();
			testTable.repaint();
			testTable.validate();//			
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
	
	private void setTableModelListener() {
        tableModelListener = new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    System.out.println("Cell " + e.getFirstRow() + ", "
                            + e.getColumn() + " changed. The new value: "
                            + testTable.getModel().getValueAt(e.getFirstRow(),
                            e.getColumn()));
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    if (column == 1 || column == 2) {
                        TableModel model = testTable.getModel();
                        int quantity = ((Integer) model.getValueAt(row, 1)).intValue();
                        double price = ((Double) model.getValueAt(row, 2)).doubleValue();
                        Double value = new Double(quantity * price);
                        model.setValueAt(value, row, 3);
                    }
                }
            }
        };
        testTable.getModel().addTableModelListener(tableModelListener);
    }
	
	
	public static void deleteRow(int row) throws SQLException
	{
		// remove selected row from the model
		DefaultTableModel dm = (DefaultTableModel) testTable.getModel();
		dm.removeRow(row);
		
		testTable.setModel(dm);
		String delRowString  = (dm.getValueAt(row-1, 0).toString());//row-1 because db starts at 1
		System.out.println("Data: " + delRowString);
		//System.out.println(testTable.getSelectedRow());
		Connection conn = sqliteConnectionTEST.dbConnector();
		String query = "DELETE FROM  Electronics WHERE ID = ? ";
		PreparedStatement prepareDel = conn.prepareStatement(query);
		prepareDel.setString(1, delRowString);
		prepareDel.executeUpdate();
		UpDateTable();

	}
	
}//end of TestMain	

