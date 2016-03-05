package testingPackage;

import java.sql.*;
import javax.swing.*;

public class sqliteConnectionTEST {
	Connection conn = null;
	public static Connection dbConnector(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn= DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "\\Sqlite\\TestDB.sqlite");
 
			//JOptionPane.showMessageDialog(null, "Connection Successful!");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
