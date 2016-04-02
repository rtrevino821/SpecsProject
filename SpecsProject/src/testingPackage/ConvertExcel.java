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

import javax.swing.JFileChooser;
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
			file = new FileInputStream(new File("Excel\\Inventory_Project_SpecificationsV2.xlsx"));
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

	public static void importExcel(File fs) throws SQLException
	{
		FileInputStream file = null;
		try {
			file = new FileInputStream(fs);
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
					//row.

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
	
	public static void InsertToDatabase(Cell[] cellArray) throws SQLException
	{
		//Vars will be used multiple times
		double cellTempDbl;
		int cellTempInt;
		String cellTempString = null;
		//For Date Parsing
		DateFormat cellTempDate;
		cellTempDate = new SimpleDateFormat("yyyy-MM-dd");
		Date today; 
		String reportDate;

		
		Connection conn = sqliteConnectionTEST.dbConnector();
		PreparedStatement prepare = null;
		
     	String query = "insert into MasterTable (Item_Name,Item_Description,Category,ID_Tag,Room,"//1-5
     			+ "Floor, Date_Acquired, Ownership, Lease_Term,Lease_Expiration,"//5-10
     			+ "Rent_Due_Date,Supplier,Manufacturer,Model_Number,Serial_Number,"//10-15
     			+ "Warranty_Expiration_Date,Replacement_Date,Deactivated, Deactivation_Date,Deactivation_Method,"//15-20
     			+ "Price, Condition,Quality)"//20-23
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?)";  //removed asset over 500 //removed picture
			
     	prepare = conn.prepareStatement(query);
     	//count maatches array index
     	//begin parsing to send to sqlite 
     	//0 Item Name
     	if(cellArray[0].getStringCellValue()== null)
     	{
         	prepare.setString(1, null);

     	}
     	else{
         	cellTempString = cellArray[0].getStringCellValue();
     		prepare.setString(1, cellTempString);
     	}
     	//System.out.println("Group: "+cellTempString);

     	//System.out.println(cellTempString);
     	//1 Item-Description
    	if(cellArray[1] == null)
     	{
         	prepare.setString(2, null);

     	}
     	else{
         	cellTempString = cellArray[1].getStringCellValue();
     		prepare.setString(2, cellTempString);
     	}
     	//System.out.println("Property: "+cellTempString);
    
     	//2 Category
    	cellTempString = cellArray[2].getStringCellValue();
     	prepare.setString(3, cellTempString);
     	
     	//3 ID_Tag
     	cellTempDbl  = cellArray[3].getNumericCellValue();
     	cellTempInt = (int) cellTempDbl;
     	prepare.setDouble(4, cellTempInt);

     	//4 Room
     	cellTempDbl  = cellArray[4].getNumericCellValue();
     	cellTempInt = (int) cellTempDbl;
     	prepare.setDouble(5, cellTempInt);
     	
     	//5 floor
    	if(cellArray[5] == null)
     	{
         	prepare.setString(6, null);

     	}
     	else{
         	cellTempString = cellArray[5].getStringCellValue();
     		prepare.setString(6, cellTempString);
     	}
     	
     	//6 Date_Acquired
     	today =  cellArray[6].getDateCellValue();
      	if(today == null)
     	{
         	prepare.setString(7, null);
     	}
     	else
     	{
     		reportDate = cellTempDate.format(today);
         	prepare.setString(7, reportDate);
     	}

     	//7 Ownership
    	cellTempString = cellArray[7].getStringCellValue();
     	prepare.setString(8, cellTempString);
      	
     	//8 Lease Term
     	today =  cellArray[8].getDateCellValue();
      	if(today == null)
     	{
         	prepare.setString(9, null);
     	}
     	else
     	{
     		reportDate = cellTempDate.format(today);
         	prepare.setString(9, reportDate);
     	}

     	//9 Lease_Expiraion
    	today =  cellArray[9].getDateCellValue();
      	if(today == null)
     	{
         	prepare.setString(10, null);
     	}
     	else
     	{
     		reportDate = cellTempDate.format(today);
         	prepare.setString(10, reportDate);
     	}
      	
     	//10 Rent_Due_Day
    	today =  cellArray[10].getDateCellValue();
      	if(today == null)
     	{
         	prepare.setString(11, null);
     	}
     	else
     	{
     		reportDate = cellTempDate.format(today);
         	prepare.setString(11, reportDate);
     	}
      	
      	//11 Supplier
      	cellTempString = cellArray[11].getStringCellValue();
     	prepare.setString(12, cellTempString);
      	
      	//12 Manufacturer
     	cellTempString = cellArray[12].getStringCellValue();
     	prepare.setString(13, cellTempString);
      	
      	//13 Model_Number
     	cellTempString = cellArray[13].getStringCellValue();
     	prepare.setString(14, cellTempString);
     	
     	//14 Serial_Number
     	cellTempString = cellArray[14].getStringCellValue();
     	prepare.setString(15, cellTempString);
     	
     	//15 Warranty_Expiration
     	today =  cellArray[15].getDateCellValue();
      	if(today == null)
     	{
         	prepare.setString(16, null);
     	}
     	else
     	{
     		reportDate = cellTempDate.format(today);
         	prepare.setString(16, reportDate);
     	}
     	//16 Replacement Date
      	today =  cellArray[16].getDateCellValue();
      	if(today == null)
     	{
         	prepare.setString(17, null);
     	}
     	else
     	{
     		reportDate = cellTempDate.format(today);
         	prepare.setString(17, reportDate);
     	}
     	//17 Deactivation_Date
      	today =  cellArray[17].getDateCellValue();
      	if(today == null)
     	{
         	prepare.setString(18, null);
     	}
     	else
     	{
     		reportDate = cellTempDate.format(today);
         	prepare.setString(18, reportDate);
     	}
     	//18 Deactivation
    	cellTempString = cellArray[18].getStringCellValue();
     	prepare.setString(19, cellTempString);
     	
     	//19 Deactivation_Method
     	cellTempString = cellArray[19].getStringCellValue();
     	prepare.setString(20, cellTempString);
     	
     	//20 Price
     	cellTempDbl  = cellArray[20].getNumericCellValue();
     	prepare.setDouble(21, cellTempDbl);
     	
     	//21 Condition
     	cellTempString = cellArray[21].getStringCellValue();
     	prepare.setString(22, cellTempString);
     	
     	//22 Quality
     	cellTempString = cellArray[22].getStringCellValue();
     	prepare.setString(23, cellTempString);
     	
    	
     	
     	
     	
     	//execute query close connectionS
     	prepare.executeUpdate();
     	conn.close();

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
	
	public static boolean validateExcel(File fs) throws SQLException 
	{
		Connection conn = sqliteConnectionTEST.dbConnector();
		String testTable_String = "Select * from MasterTable";
		PreparedStatement showTestTable = null;
		ResultSet rs = null;
		try {
			showTestTable = conn.prepareStatement(testTable_String);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs = showTestTable.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		ResultSetMetaData rsmd=rs.getMetaData();
        //Coding to get columns-
        int cols=rsmd.getColumnCount();
        String c[]=new String[cols];
        for(int i=0;i<cols;i++){
            c[i]=rsmd.getColumnName(i+1);
        }
        
        FileInputStream file = null;
		try {
			file = new FileInputStream(fs);
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
			if(!cell.getStringCellValue().equals(c[count]))
			{
				return false;
			}
		}
		return true;
		
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
	
	public static String getDate()
	{
		DateTime dt = new DateTime();
	    String b = dt.toString("MM-dd-yyyy");
		return b;
	}
	
	public static void UpDateTable(JTable table) 
	{//Duplicate
		try 
		{
			Connection conn = sqliteConnectionTEST.dbConnector();
			DefaultTableModel dm = new DefaultTableModel();
	        //query and resultset
			String testTable_String = "Select * from MasterTable";
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
