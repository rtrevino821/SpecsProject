package testingPackage;

import java.awt.Desktop;
import java.awt.Label;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;

//private fields

public class ConvertExcel {
	public static void writeExcel()throws IOException
	{
		
		JTable table = new JTable();
	    DateTime dt = new DateTime();
	    UpDateTable(table);

	    String date = getDate();

	    String excelName = excelName();
		File file = new File(excelName);
	    Workbook wb = new XSSFWorkbook(); //Excel workbook
	    Sheet sheet = wb.createSheet(); //WorkSheet
	    Row row = sheet.createRow(1); //Row created at line 3
	    TableModel model = table.getModel(); //Table model
	    
	    Row headerRow = sheet.createRow(0); //Create row at line 0
	    String [] colName = new String[model.getColumnCount()];
	    for(int headings = 0; headings < model.getColumnCount(); headings++){ //For each column
	        headerRow.createCell(headings).setCellValue(model.getColumnName(headings));//Write column name
        	colName[headings] = table.getColumnName(headings);

	    }

	    for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
	        for(int cols = 0; cols < table.getColumnCount(); cols++){ //For each table column
	        	if(table.getColumnName(cols).equals(colName[cols]) )
	        	{
	            	String columnString = colName[cols];
	            	if(isColumnIntType(columnString))
	            	{//writes cell as doubles
	            		XSSFCell cell = (XSSFCell) row.createCell(cols);//create a cell at the row,col location
	            		double x = Double.parseDouble((String) (model.getValueAt(rows, cols)));//get he  value from table
			            cell.setCellValue(x);
			           //row.createCell(cols).setCellValue(model.getValueAt(rows, cols).toString()); //Write value
	            	}
	            	else//writes the cell as strings
	            	{
	            		XSSFCell cell = (XSSFCell) row.createCell(cols);//create a cell at the row,col location
	            		String x = (String) (model.getValueAt(rows, cols));//get he  value from table
			            cell.setCellValue(x);
	            	}

	        	}
	        }

	        //Set the row to the next one in the sequence 
	        row = sheet.createRow((rows + 1)); 
	    }//end of row loop
	    wb.write(new FileOutputStream(file.toString()));//Save the file     
	    openExcel(file);
	}//end of method
	
	//overloaded method for TestMain
	public static void writeExcel(JTable table)throws IOException
	{

	    String excelName = excelName();
		File file = new File(excelName);
	    Workbook wb = new XSSFWorkbook(); //Excel workbook
	    Sheet sheet = wb.createSheet(); //WorkSheet
	    Row row = sheet.createRow(1); //Row created at line 3
	    TableModel model = table.getModel(); //Table model
	    
	    Row headerRow = sheet.createRow(0); //Create row at line 0
	    String [] colName = new String[model.getColumnCount()];
	    for(int headings = 0; headings < model.getColumnCount(); headings++){ //For each column
	        headerRow.createCell(headings).setCellValue(model.getColumnName(headings));//Write column name
        	colName[headings] = table.getColumnName(headings);

	    }

	    for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
	        for(int cols = 0; cols < table.getColumnCount(); cols++){ //For each table column
	        	if(table.getColumnName(cols).equals(colName[cols]) )
	        	{
	            	String columnString = colName[cols];
	            	if(isColumnIntType(columnString))
	            	{//writes cell as doubles
	            		XSSFCell cell = (XSSFCell) row.createCell(cols);//create a cell at the row,col location
	            		double x = Double.parseDouble((String) (model.getValueAt(rows, cols)));//get he  value from table
			            cell.setCellValue(x);
			           //row.createCell(cols).setCellValue(model.getValueAt(rows, cols).toString()); //Write value
	            	}
	            	else//writes the cell as strings
	            	{
	            		XSSFCell cell = (XSSFCell) row.createCell(cols);//create a cell at the row,col location
	            		String x = (String) (model.getValueAt(rows, cols));//get he  value from table
			            cell.setCellValue(x);
	            	}

	        	}
	        }

	        //Set the row to the next one in the sequence 
	        row = sheet.createRow((rows + 1)); 
	    }//end of row loop
	    wb.write(new FileOutputStream(file.toString()));//Save the file     
	    openExcel(file);
	}//end of method
	
	
	
	public static void readExcel()
	{
		
	}
	
	
	
	public static void main(String args[]) throws IOException
	{
		//convertToExcel();
		writeExcel();
		System.out.println("SUCCESS");
		
	}
	
	public static boolean isColumnIntType(String colName)
	{
		if(colName.equals("ID")||(colName.equals("Price")))
				{
					return true;
				}
		return false;
				
	}
	
	public static void openExcel(File file)
	{
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	//checks dir if fielname already, if it does output new filename 
	public static String excelName()
	{
		String fileLocation  = System.getProperty("user.dir");
		File folder = new File(fileLocation + "/Excel/");
		File[] listOfFiles = folder.listFiles();
		
		File file = new File("Excel\\Form.xlsx");
		//File file2 = new File("Excel\\Apachi " + date + ".xlsx");
	
		String fileName = fileLocation + "\\" + file.toString();
		
		//loop will rename file if the filename exist already at the directory
		for(int i =0; i<listOfFiles.length;i++)
		{
			//System.out.println(listOfFiles[i]);

			if(fileName.equals(listOfFiles[i].toString()))
			{
				file = new File("Excel\\Form" + "(" + (i) +")" + ".xlsx");
				fileName = (file.toString());
				break;
			}
		}
		return fileName;	
	}//end of method
	
	public static String getDate()
	{
		DateTime dt = new DateTime();
	    String b = dt.toString("MM-dd-yyyy");
		return b;
	}
	
	public static void UpDateTable(JTable table) 
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
			
			table.setModel(dm);
			
			//testTable.setModel(DbUtils.resultSetToTableModel(rsTest));

			//Refresh the table
		   // tableModel.fireTableStructureChanged();
			//testTable.setModel(tableModel);
			table.revalidate();
			table.repaint();
			table.validate();//			
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
	
	
}
