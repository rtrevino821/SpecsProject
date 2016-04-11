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
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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


/**
 *  Converts Data from JTable to excel
 *  boolean tempalteState, when true only writes the column header for excel 
 */
public class ConvertExcel {
	public static void writeExcel(boolean templateState)throws IOException
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

	    if(templateState == true)
	    {//When Template is chosen only print columns
	    	 wb.write(new FileOutputStream(file.toString()));//Save the file     
	  	    openExcel(file);
	    	return;
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
	/**
	 *  
	 *  
	 */
	private static void writeExcel(JTable table)throws IOException
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
		//Receives a a prepare statement with query to insert to table
		PreparedStatement prepare = initPrepare();

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
        int columnLength = 0;
        for(int count = 0; count < row.getLastCellNum(); count++)
        {//get column headers from excel
        	Cell cell = row.getCell(count);
        	columnLength = count+1; 
        	colHeader[count] = cell.getStringCellValue();
        	//System.out.println(colHeader[count]);
        }
	    
	  
        //System.out.println("Total Number of Rows: " + (rowsCount + 1));
        for (int i = 3; i <= rowsCount-1; i++) {//start at 1 to skip column
            row = sheet.getRow(i);//change colcounts to row
            int colCounts = columnLength;//assign colCounts to the length of max num of cols
            Cell [] cellArray = new Cell[colCounts];
            System.out.println("Total Number of Cols: " + colCounts);
            for (int j = 0; j <= columnLength; j++) {
            	if(j==23)
            	{
            		prepare.executeUpdate();
            	}
            	
            	else if (row.getCell(j) == null)
            	{//if cel is blank, create a blank cell
            		//break;
            		//System.out.println("NULL at " + i + " , " + j );
            		cellArray[j] = row.getCell(j, Row.CREATE_NULL_AS_BLANK);
                    prepare = getParepareValues(cellArray,j,prepare);

            	}
            	else{
            		cellArray[j] = row.getCell(j);
					//System.out.println("Loc: " + i +" ," + j);
		            prepare = getParepareValues(cellArray,j,prepare);
            	}
            	
            }// end of j loop
            
        }//end of i loop
	    try {
			file.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
}//end of method

	public static PreparedStatement initPrepare()
	{
		Connection conn = sqliteConnectionTEST.dbConnector();
		PreparedStatement prepare = null;
		
     	String query = "insert into MasterTable (Item_Name,Item_Description,Category,ID_Tag,Room,"//1-5
     			+ "Floor, Date_Acquired, Ownership, Lease_Term,Lease_Expiration,"//5-10
     			+ "Rent_Due_Date,Supplier,Manufacturer,Model_Number,Serial_Number,"//10-15
     			+ "Warranty_Expiration_Date,Replacement_Date,Deactivation_Date,Deactivated,Deactivation_Method,"//15-20
     			+ "Price, Condition,Quality)"//20-23
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
				+ ",?,?,?,?,?)";  //removed asset over 500 //removed picture
			
     	try {
			prepare = conn.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	return prepare;
	}
	
	/**
	 *  Inputs value from excel into preparedStamtent
	 */
	public static PreparedStatement getParepareValues(Cell[] cellArray, int j, PreparedStatement prepare) 
	{
		//Vars will be used multiple times
		double cellTempDbl;
		int cellTempInt;
		String cellTempString = null;
		//For Date Parsing
		DateFormat cellTempDate;
		cellTempDate = new SimpleDateFormat("yyyy-MM-dd");
		Date typeDate; 
		String dateFormattedString;

		//System.out.println("J is :" + j);
		//Ints col 3,5
			
		if(j==3 || j == 4)
		{
			if(cellArray[j].getCellType() == Cell.CELL_TYPE_BLANK)
			{
				try {
					prepare.setNull(j+1, Types.INTEGER);
					return prepare;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			cellTempDbl  = cellArray[j].getNumericCellValue();
			cellTempInt = (int) cellTempDbl;
			try {
				if(j+1 == 4)
				{
					System.out.println("Asset num: " + cellTempInt);
				}
				prepare.setInt(j+1, cellTempInt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return prepare;
		}
		//Dates 
		else if(j==6||j==8||j==9||j==10|
				j==15||j==16||j==17)
		{
			if(cellArray[j] == null || cellArray[j].getCellType() == Cell.CELL_TYPE_BLANK)
			{
				try {
					prepare.setString(j+1, null);
					return prepare;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return prepare;
			}
			
		 	typeDate =  cellArray[j].getDateCellValue();
		 	dateFormattedString = cellTempDate.format(typeDate);
		 	try {
		 		prepare.setString(j+1, dateFormattedString);
		 		return prepare;
		 	} catch (SQLException e) {
		 		// TODO Auto-generated catch block
		 		e.printStackTrace();
		 	}
		 	return prepare;

		}
		//Double
		else if(j==20)
		{
			if(cellArray[j].getCellType() == Cell.CELL_TYPE_BLANK)
			{
				try {
					prepare.setNull(j+1, Types.DOUBLE);
					return prepare;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			cellTempDbl  = cellArray[j].getNumericCellValue();
			try {
				prepare.setDouble(j+1, cellTempDbl);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(cellTempDbl);
			return prepare;

		}
		//String
		else
		{
			if(cellArray[j] == null || cellArray[j].getCellType() == Cell.CELL_TYPE_BLANK)
	     	{
	         	try {
					prepare.setString(j+1, null);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return prepare;
	     	}
	     	else{
	         	cellTempString = cellArray[j].getStringCellValue();
	     		try {
					prepare.setString(j+1, cellTempString);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return prepare;
	     	}
		}
     	
	}//end of method
			
	public static void main(String args[]) throws IOException
	{
		//writeExcel();
		long startTime = System.currentTimeMillis();

		try {
			importExcel();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR");
			e.printStackTrace();
		}
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");    
		Date resultdate = new Date(totalTime);
		//System.out.println(sdf.format(resultdate));
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
	/**
	 *  Verifies File import meets sqlite's standard by checking if the columns match
	 */
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
				conn.close();
				return false;
				
			}
//			else
//				System.out.println(cell.getStringCellValue());
		}
		
		conn.close();
		return true;
		
	}
	
	//checks dir if fielname already, if it does output new filename 
	public static String excelName()
	{
		String fileLocation  = System.getProperty("user.dir");
		
		File theDir = new File("Excel");

		// if the directory does not exist, create it
		if (!theDir.exists()) {
			//System.out.println("creating directory: " + System.getProperty("user.dir") + "/Excel");
			boolean result = false;

			try{
				theDir.mkdir();
				result = true;
			} 
			catch(SecurityException se){
				//handle it
			}        
			if(result) {    
				System.out.println("DIR created");  
			}
		}
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

	//Overload for user to import excel
	public static void importExcel(File fs) throws SQLException
	{//uncomment
		PreparedStatement prepare = initPrepare();

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
		int columnLength = 0;
		for(int count = 0; count < row.getLastCellNum(); count++)
		{//get column headers from excel
			Cell cell = row.getCell(count);
			columnLength = count+1; 
			colHeader[count] = cell.getStringCellValue();
			//System.out.println(colHeader[count]);
		}

		//System.out.println("Total Number of Rows: " + (rowsCount + 1));
		for (int i = 3; i <= rowsCount-1; i++) {//start at 1 to skip column
			row = sheet.getRow(i);//change colcounts to row
			int colCounts = columnLength;//assign colCounts to the length of max num of cols
			Cell [] cellArray = new Cell[colCounts];
			//System.out.println("Total Number of Cols: " + colCounts);
			for (int j = 0; j <= columnLength; j++) {
				if(j==23)
				{
					prepare.executeUpdate();
				}

				else if (row.getCell(j) == null)
				{//if cel is blank, create a blank cell
					//break;
					//System.out.println("NULL at " + i + " , " + j );
					cellArray[j] = row.getCell(j, Row.CREATE_NULL_AS_BLANK);
					prepare = getParepareValues(cellArray,j,prepare);

				}
				else{
					cellArray[j] = row.getCell(j);
					//System.out.println("Loc: " + i +" ," + j);
					prepare = getParepareValues(cellArray,j,prepare);
				}

			}// end of j loop

		}//end of i loop
		try {
			file.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
	}//end of method
		
}//End of ConvertExcel
