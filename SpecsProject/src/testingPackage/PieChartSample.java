package testingPackage;

import java.beans.Statement;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;

import org.joda.time.DateTime;

import javafx.scene.Node;
import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Reflection;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;

public class PieChartSample extends Application {

	@Override
	public void start(Stage stage) {
		
		Pane root = new Pane();
		Scene scene = new Scene(root);
		stage.setTitle("Category Totals");
		stage.setWidth(700);
		stage.setHeight(700);

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Art: ", test_ArtWork_Total_Spent()),
				new PieChart.Data("Cabinets: ", test_Furniture_Total_Spent()),
       			new PieChart.Data("Pc's: " , test_Computers_Total_Spent()), 
				new PieChart.Data("Software: ",test_Computer_Software_Total_Spent()),
				new PieChart.Data("BB: ",test_Batter_Backup_Total_Spent()),
				new PieChart.Data("Pc/misc",test_Computer_MISC_Total_Spent()),
				new PieChart.Data("p", test_Printers_Total_Spent()),
				new PieChart.Data("t.",test_Transcription_Total_Spent()),
				new PieChart.Data("v",test_Video_Projector_Total_Spent()),	
				new PieChart.Data("Fixture",test_Furniture_Fixtures_Total_Spent()), 		
				new PieChart.Data("LeaseHold",test_LeaseHold_Total_Spent()),			
				new PieChart.Data("Property.",test_Personal_Property_Total_Spent()));
		
				
		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Category Totals");

		final Label caption = new Label("");
		caption.setTextFill(Color.DARKBLUE);
		caption.setStyle("-fx-font: 24 arial;");

				
		
		for (final PieChart.Data data : chart.getData()) {
			data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
				double total = 0;
				for (PieChart.Data value : chart.getData()) {
					total += value.getPieValue();
				}
				caption.setTranslateX(e.getSceneX());
				caption.setTranslateY(e.getSceneY());
				String text = String.format("%.1f%%", 100 * data.getPieValue() / total);
				caption.setText(text);
			});
		}

		root.getChildren().addAll(chart, caption);
		stage.setScene(scene);
		stage.show();

	
		Set<Node> items = chart.lookupAll("Label.chart-legend-item");
	    int i = 0;
	    Color[] colors = { Color.web("#f4950b"), Color.web("#e0c300"), Color.web("#00ad40"), Color.web("#0181e2"), Color.web("#526b7f"),
	    		Color.web("#9536d0"),Color.web("#be4418"),Color.web("#526b7f"),Color.web("#e05300"),
	    		Color.web("#f4950b"),Color.web("#00ad40"),Color.web("#0181e2"),};//Color.web("#2f357f"), };
	    for (Node item : items) {  //#0181e2 was the sixth color  526b7f
	      Label label = (Label) item;
	      final Rectangle rectangle = new Rectangle(10, 10, colors[i]);
	      final Glow glowEffect = new Glow();
	      glowEffect.setInput(new Reflection());
	      rectangle.setEffect(glowEffect);
	      label.setGraphic(rectangle);
	      i++;
	
	    }
	}

	public static void main(String[] args) {
		launch(args);
//		System.out.println("Cabinets:  "+test_Furniture_Total_Spent()+ "  correct value "+ "\n");
//		System.out.println("Pc's:  "+test_Computers_Total_Spent()+"  correct value"+"\n");
//		System.out.println("furniture:  " + test_Furniture_Fixtures_Total_Spent() + "  correct value"+"\n");
//		System.out.println("Art:  "+test_ArtWork_Total_Spent()+ "  correct value" + "\n");
//		System.out.println("Software:  "+test_Computer_Software_Total_Spent()+ "  correct value"+"\n");
//		System.out.println("battery:  "+test_Batter_Backup_Total_Spent()+ "  correct value"+"\n");	
//		System.out.println("Misc:  " +test_Computer_MISC_Total_Spent()+ "  correct value"+"\n");
//		System.out.println("printers:  "+ test_Printers_Total_Spent()+ "  correct value"+ "\n");
//		System.out.println("transcription:  "+ test_Transcription_Total_Spent()+ "  correct value" + "\n");
//		System.out.println("video_projectors:  " + test_Video_Projector_Total_Spent()+ "  correct value" +  "\n");
//		System.out.println("personal property:  "  + test_Personal_Property_Total_Spent()+ "  correct value" +"\n");
//		System.out.println("LeaseHold: "+test_LeaseHold_Total_Spent()+ "\n");
//	
//		System.out.println("TOTAL DOLLAR SPENT:  " +test_Everything_Total_Spent());
		
		
		//String date ="2001";
		//test_Assets_Over_500(date);
		
		
		/*// DATA  FOR TOTAL SPENT BY YEAR
		Map<String, Double> map = test_Total_By_Year_Spent();
		for (Entry<String, Double> e : map.entrySet()) {
			System.out.println("year " + e.getKey() + ", Total Spent: " + e.getValue());
			;
		}
		*/
		

		//String date = "01/01/2001";
		//String date2 = "12/31/2010";
		
			//test_Date_Range_Over_500(date,date2);
	}
	
	public static void test_Date_Range_Over_500(String date, String date2) throws SQLException { // String date
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		
		String str_rs = ("SELECT Price,Property_Description,Date_In_Service"
				+ " From MasterTable Where MasterTable.Date_In_Service BETWEEN '?' AND '?'");
		
		PreparedStatement statement = conn2.prepareStatement(str_rs);
		
		try {  //SELECT * FROM ORDERS WHERE DATE BETWEEN '03/01/2015' AND '03/30/2015'
			stmt = conn2.createStatement();  // \"group\",
			
			
			statement.setString(1,date);
			statement.setString(2,date2);
			ResultSet rs = statement.executeQuery();
			 
			while (rs.next()) {

				String date_in = rs.getString("Date_In_Service");
				Double price = rs.getDouble("Price");
				String item_Description = rs.getString("Property_Description");
				
				//if (date_in.contains(date)) { // if contains chosen year

					System.out.println(item_Description + "  " + price + "      " + date_in);
				}
			//}
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
	}
	
	
	
	
	/*FINDS TOTAL SPENT BY YEAR*/
	public static Map<String, Double> test_Total_By_Year_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Map<String, Double> yearlyTotalSpent = new HashMap<String, Double>();

		try {
			stmt = conn2.createStatement();
																			
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price,Asset,Date_In_Service"
					                              + " AS y From MasterTable Where MasterTable.Price>0 "); 
			while (rs.next()) {
				Double price = rs.getDouble("Price");
				String year = rs.getString("y").substring(6);
				
				if (yearlyTotalSpent.containsKey(year)) {
					Double oldValue = yearlyTotalSpent.get(year);
					yearlyTotalSpent.replace(year, oldValue, round(oldValue + price));// round for correct output.
				} else {
					yearlyTotalSpent.put(year, price);
				}
			}
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
		return (yearlyTotalSpent);
	}
	
	
	/* FINDS ALL GROUP NAMES */
	public static void test_All_Groups() {

		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement(); // \"group\",price //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT Distinct \"group\" From MasterTable");

			String group = "";
			while (rs.next()) {
				group = rs.getString("Group");

				System.out.println("Group name: " + group);
			}
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
	}
	

	/* RETURNS ITEMS PURCHASED OVER 500 FOR SELECTED YEAR */
	public static void test_Assets_Over_500(String date) { // String date
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price,Property_Description,Date_In_Service"
					+ " From MasterTable Where MasterTable.Price>=0 ");

			while (rs.next()) {

				String date_in = rs.getString("Date_In_Service");
				Double price = rs.getDouble("Price");
				String item_Description = rs.getString("Property_Description");
				
				if (date_in.contains(date) ) { // if contains chosen year

					System.out.println(item_Description + "  " + price + " " + date_in);
				}
			}
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
	}
	
	
	public static double test_LeaseHold_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price,Asset From MasterTable"
					+ " Where (MasterTable.\"group\" Like 'Leasehold Improvements' And MasterTable.Price>0) " );
			
			
			while (rs.next()) {
				Double price = rs.getDouble("Price");
				//int asset =rs.getInt("Asset"); 
				
				//System.out.println("asset number: "+asset);
				sum += price;
			}
			//System.out.println(sum + "\n");
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
		return round(sum);
	}
	
	
	public static double test_Furniture_Fixtures_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); 
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price,Asset From MasterTable"
					+ " Where (MasterTable.\"group\" Like 'Furniture & Fixtures' And MasterTable.Price>0) " );
			
			// sum =0;
			while (rs.next()) {
				Double price = rs.getDouble("Price");
				//int asset =rs.getInt("Asset"); 
				
				//System.out.println("asset number: "+asset);
				sum += price;
			}
			//System.out.println(sum + "\n");
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
		return round(sum);
	}
	
	
	/*  FINDS TOTAL AMOUNT SPENT ENTIRE INVENTORY SYSTEM*/
	public static double test_Everything_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); 
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price,Asset From MasterTable Where MasterTable.Price>0 " );
			
	
			while (rs.next()) {
				Double price = rs.getDouble("Price");
				//int asset =rs.getInt("Asset"); 
				
				//System.out.println("asset number: "+asset);
				sum += price;
			}
			//System.out.println(sum + "\n");
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
		return round(sum);
	}
	
	

	public static double test_Computer_MISC_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable"
						+ " Where (MasterTable.\"group\" Like '%Server%' And MasterTable.Price>0) " );
			
			// sum =0;
			while (rs.next()) {
				Double price = rs.getDouble("Price");
				//System.out.println(price);
				sum += price;
			}
			//System.out.println(sum + "\n");
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
		return round(sum);
	}
	
	
	
	
	
	
	public static double test_Transcription_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable"
					+ " Where (MasterTable.\"group\" Like '%Transcription%' And MasterTable.Price>0) " );
			
			// sum =0;
			while (rs.next()) {
				Double price = rs.getDouble("Price");
				//System.out.println(price);
				sum += price;
			}
			//System.out.println(sum + "\n");
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
		return round(sum);
	}
	
	
	
	public static double test_ArtWork_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable"
						+ " Where (MasterTable.\"group\" Like '%ArtWork%' And MasterTable.Price>0) " );
			
			// sum =0;
			while (rs.next()) {
				Double price = rs.getDouble("Price");
				//System.out.println(price);
				sum += price;
			}
			//System.out.println(sum + "\n");
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
		return round(sum);
	}

	public static double test_Batter_Backup_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable"
						+ " Where (MasterTable.\"group\" Like '%Battery%' And MasterTable.Price>0) " );
			
			while (rs.next()) {
				Double price = rs.getDouble("Price");
				sum += price;
			}
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
		return round(sum);
	}
	
	
	public static double test_Personal_Property_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable"
						+ " Where (MasterTable.\"group\" Like 'Personal Property' And MasterTable.Price>0) " );
			
			// sum =0;
			while (rs.next()) {
				Double price = rs.getDouble("Price");
				//System.out.println(price);
				sum += price;
			}
			//System.out.println(sum + "\n");
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
		return round(sum);
	}
	
	
	
	public static double test_Computer_Software_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable"
						+ " Where (MasterTable.\"group\" Like '%Software%' And MasterTable.Price>0) " );
			
			// sum =0;
			while (rs.next()) {
				Double price = rs.getDouble("Price");
				//System.out.println(price);
				sum += price;
			}
			//System.out.println(sum + "\n");
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
		return round(sum);
	}
	
	
	public static double test_Printers_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable"
							+ " Where (MasterTable.\"group\" Like '%Printers%' And MasterTable.Price>0) " );
			
			// sum =0;
			while (rs.next()) {
				Double price = rs.getDouble("Price");
				//System.out.println(price);
				sum += price;
			}
			//System.out.println(sum + "\n");
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
		return round(sum);
	}
	
	public static double test_Computers_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); 
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable"
						+ " Where (MasterTable.\"group\" Like 'Computers' And MasterTable.Price>0) " );
			
			while (rs.next()) {
				Double price = rs.getDouble("Price");
				//System.out.println(price);
				sum += price;
			}
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
		return round(sum);
	}
		
	public static double test_Video_Projector_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;
		Double sum = 0.0;
		try {
			stmt = conn2.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable "
						+ "Where (MasterTable.\"group\" Like '%Video/Proj%' And MasterTable.Price>0) " );
																		
			while (rs.next()) {
				Double price = rs.getDouble("Price");
				sum += price;
			}
			// System.out.println(sum + "\n");

		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
		return round(sum);
	}
	
	
	
	public static double test_Furniture_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;
		Double sum = 0.0;
		try {
			stmt = conn2.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable "
					   + "Where (MasterTable.\"group\" Like '%Cabinets' And MasterTable.Price>0) " );
																		
			while (rs.next()) {
				Double price = rs.getDouble("Price");
				sum += price;
			}

		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
		return round(sum);
	}
	
	/* ROUNDS DECIMAL NUMBERS TWO PLACES*/
	public static double round(double value) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}

	
