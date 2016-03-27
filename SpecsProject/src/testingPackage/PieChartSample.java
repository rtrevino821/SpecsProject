package testingPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

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
				new PieChart.Data("Furniture: ", test_Furniture_Total_Spent()),
       			new PieChart.Data("Pc's: " , test_Computers_Total_Spent()),//, 
				new PieChart.Data("Software: ",test_Computer_Software_Total_Spent()),
				new PieChart.Data("Backups: ",test_Batter_Backup_Total_Spent()),
				new PieChart.Data("Pc Misc",test_Computer_MISC_Total_Spent()),
				new PieChart.Data("Printers", test_Printers_Total_Spent()),
//				new PieChart.Data("Computers Printers ",test_Electronic_Total_Spent()));
				new PieChart.Data("Computers Transcription",test_Transcription_Total_Spent()),
				new PieChart.Data("Computers Video/Proj Eq",test_Video_Projector_Total_Spent()));	
//				new PieChart.Data("Furniture & Fixtures",test_Electronic_Total_Spent()), 		
//				new PieChart.Data("Furniture & Fixture Cabinets",test_Electronic_Total_Spent()),
//				new PieChart.Data("Leasehold Improvements",test_Electronic_Total_Spent()),			
//				new PieChart.Data("Personal Property",test_Electronic_Total_Spent()));
		
				
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
	    // these colors came from caspian.css .default-color0..4.chart-pie
	    Color[] colors = { Color.web("#e0c300"), Color.web("#e05300"), Color.web("#00ad40"), Color.web("#0181e2"), Color.web("#2f357f"),
	    		Color.web("#0181e2"),Color.web("#2f357f"),Color.web("#2f357f"),Color.web("#2f357f"),
	    		Color.web("#2f357f"),Color.web("#2f357f"),Color.web("#2f357f"),Color.web("#2f357f"), };
	    for (Node item : items) {
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
		System.out.println("furniture cabinets:  "+test_Furniture_Total_Spent()+ "\n");
		
		
		System.out.println("furniture:  " + test_Furniture_Fixtures_Total_Spent()+"\n");
		
		System.out.println("Art:  "+test_ArtWork_Total_Spent() + "\n");
		System.out.println("Pc's:  "+test_Computers_Total_Spent()+"\n");
		System.out.println("Software:  "+test_Computer_Software_Total_Spent()+"\n");
		System.out.println("battery:  "+test_Batter_Backup_Total_Spent()+"\n");	
		System.out.println("Misc:  " +test_Computer_MISC_Total_Spent()+"\n");
		System.out.println("printers:  "+ test_Printers_Total_Spent()+ "\n");
		System.out.println("transcription:  "+ test_Transcription_Total_Spent()+ "\n");
		System.out.println("video_projectors:  " + test_Video_Projector_Total_Spent() +  "\n");
	
	
	}
	
	public static double test_Furniture_Fixtures_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable Where (MasterTable.\"group\" Like 'Furniture & Fixtures' And MasterTable.Price>0) " );// WHERE price >= 500
			
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
		return sum;
	}
	
	
	
	

	public static double test_Computer_MISC_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable Where (MasterTable.\"group\" Like '%Server%' And MasterTable.Price>0) " );// WHERE price >= 500
			
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
		return sum;
	}
	
	
	
	
	
	
	public static double test_Transcription_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable Where (MasterTable.\"group\" Like '%Transcription%' And MasterTable.Price>0) " );// WHERE price >= 500
			
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
		return sum;
	}
	
	
	
	public static double test_ArtWork_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable Where (MasterTable.\"group\" Like '%ArtWork%' And MasterTable.Price>0) " );// WHERE price >= 500
			
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
		return sum;
	}

	public static double test_Batter_Backup_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable Where (MasterTable.\"group\" Like '%Battery%' And MasterTable.Price>0) " );// WHERE price >= 500
			
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
		return sum;
	}
	
	public static double test_Computer_Software_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable Where (MasterTable.\"group\" Like '%Software%' And MasterTable.Price>0) " );// WHERE price >= 500
			
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
		return sum;
	}
	
	
	public static double test_Printers_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable Where (MasterTable.\"group\" Like '%Printers%' And MasterTable.Price>0) " );// WHERE price >= 500
			
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
		return sum;
	}
	
	
	
	
	
	
	
	
	
	public static double test_Computers_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable Where (MasterTable.\"group\" Like 'Computers' And MasterTable.Price>0) " );// WHERE price >= 500
			
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
		return sum;
	}
		
	public static double test_Video_Projector_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;
		Double sum = 0.0;
		try {
			stmt = conn2.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable Where (MasterTable.\"group\" Like '%Video/Proj%' And MasterTable.Price>0) " );// WHERE price >= 500
																		
			while (rs.next()) {
				Double price = rs.getDouble("Price");
				sum += price;
			}
			// System.out.println(sum + "\n");

		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
		return sum;
	}
	
	
	
	public static double test_Furniture_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;
		Double sum = 0.0;
		try {
			stmt = conn2.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable Where (MasterTable.\"group\" Like '%Cabinets%' And MasterTable.Price>0) " );// WHERE price >= 500
																		
			while (rs.next()) {
				Double price = rs.getDouble("Price");
				sum += price;
			}
			// System.out.println(sum + "\n");

		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
		return sum;
	}
//	
//	
//	public static void test_Electronic_Assets_Over_500() {
//		Connection conn2 = sqliteConnectionTEST.dbConnector();
//
//		java.sql.Statement stmt;
//		try {
//			stmt = conn2.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT Type,Price FROM Electronics WHERE price >= 500");
//			// double sum =0;
//			while (rs.next()) {
//				String price = rs.getString("Type");
//				System.out.println(price + "\n");
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}

	
