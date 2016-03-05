package testingPackage;
//comment comment
import java.awt.Desktop;
import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;



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
	            	//System.out.println(colName[cols]);
	            	//System.out.println((model.getValueAt(rows, cols)));
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
	            	{//writes cell as doubles to remove error checking from excel
	            		XSSFCell cell = (XSSFCell) row.createCell(cols);//create a cell at the row,col location
	            		double x = Double.parseDouble((String) (model.getValueAt(rows, cols)));//get he  value from table
			            cell.setCellValue(x);
			           //row.createCell(cols).setCellValue(model.getValueAt(rows, cols).toString()); //Write value
	            	}
	            	else//writes the cell as strings
	            	{
	            		XSSFCell cell = (XSSFCell) row.createCell(cols);//create a cell at the row,col location
	            		String x = (String) (model.getValueAt(rows, cols));//get he  value from table
	            		//cell.setCellType(Cell.CELL_TYPE_STRING);
			            DataFormatter dfTemp = new DataFormatter();
	            		cell.setCellValue(x);
	            		cell.setCellValue( dfTemp.formatCellValue(cell)); 
	            	}
	        	}
	        }
	        //Set the row to the next one in the sequence 
	        row = sheet.createRow((rows + 1)); 
	    }//end of row loop
	    wb.write(new FileOutputStream(file.toString()));//Save the file     
	    openExcel(file);
	}//end of method
	
	public static void importExcel() throws SQLException
	{
		FileInputStream file = null;
		try {
			file = new FileInputStream(new File("Excel\\Inventory_Project_Specifications.xlsx"));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	     
	    //Get the workbook instance for XLS file 
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
	    //Get first sheet from the workbook
	    XSSFSheet sheet = workbook.getSheetAt(0);
	     
	    //Iterate through each rows from first sheet
	    Iterator<Row> rowIterator = sheet.iterator();
        Row row = sheet.getRow(0);
        int rowsCount = sheet.getLastRowNum();
        
        String [] colHeader =  new String[rowsCount];
        for(int count = 0; count < row.getLastCellNum(); count++)
        {//get column headers from excel
        	Cell cell = row.getCell(count);
        	colHeader[count] = cell.getStringCellValue();
        	System.out.println(colHeader[count]);
        }
	    
	    
        System.out.println("Total Number of Rows: " + (rowsCount + 1));
        for (int i = 3; i <= rowsCount; i++) {//start at 1 to skip column
            row = sheet.getRow(i);
            int colCounts = row.getLastCellNum();//null pointer needs to be handled
            Cell [] cellArray = new Cell[colCounts];
            System.out.println("Total Number of Cols: " + colCounts);
            for (int j = 0; j < colCounts; j++) {
            	if (row.getCell(j) == null)
            	{
            		//break;
                    System.out.println("NULL");

            	}
            	else
            		cellArray[j] = row.getCell(j);
               //System.out.println("[" + i + "," + j + "]=" + cell.getStringCellValue());
            }// end of j loop
            InsertToDatabase(cellArray);
			
        }//end of i loop
	    try {
			file.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
}//end of method
	
	public static void InsertToDatabase(Cell[] cellArray)
	{
		 Connection conn = sqliteConnectionTEST.dbConnector();
			PreparedStatement prepare = null;
//     	String query = "insert into Presidents(AlphaID,Years,Presidents,VP,TermLeft) "
//					+ "values(?,?,?,?,?)";
     	String query = "insert into Artwork(\"group\",Asset,Property_Description,Date_In_Service,Price)"
				+ "values(?,?,?,?,?)";
			try {
				prepare = conn.prepareStatement(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//begin parsing to send to sqlite //1
			String cellTempString = cellArray[0].getStringCellValue();
			try {
				prepare.setString(1, cellTempString);
				System.out.println("Group: "+cellTempString);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//2
			double cellTempDbl = cellArray[1].getNumericCellValue();
			int cellTempInt = (int) cellTempDbl;
			try {
				prepare.setInt(2, cellTempInt);
				System.out.println("Asset: "+cellTempInt);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//3
			cellTempString = cellArray[2].getStringCellValue();
			try {
				prepare.setString(3, cellTempString);
				System.out.println("Property: "+cellTempString);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//4
			//new SimpleDateFormat("dd/MM/yyyy").parse(yourDateString);
		    DateFormat cellTempDate = new SimpleDateFormat("MM/dd/yyyy");
		    Date today =  cellArray[3].getDateCellValue();
		    String reportDate = cellTempDate.format(today);
			try {
				prepare.setString(4, reportDate);
				System.out.println("Date: "+reportDate);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//5
			cellTempDbl = cellArray[4].getNumericCellValue();
			try {
				prepare.setDouble(5, cellTempDbl);
				System.out.println("Price: " + cellTempDbl);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				prepare.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}//end of method
	
		
	public static void main(String args[]) throws IOException
	{
		//writeExcel();
		try {
			importExcel();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String a = getDate();
		System.out.println(a);
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
	
	public static String getDate()
	{
		DateTime dt = new DateTime();
	    String b = dt.toString("MM-dd-yyyy");
	    
		return b;
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
				file = new File("Excel\\Form" + "(" + (i) +")" + ".xlsx");//need to change i to i plus 1
				fileName = (file.toString());
				break;
			}
		}
		return fileName;	
	}//end of method
	
	
	public static void UpDateTable(JTable table) 
	{//Duplicate
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
