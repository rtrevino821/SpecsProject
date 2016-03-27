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
		stage.setWidth(500);
		stage.setHeight(500);

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Electronics", test_Electronic_Total_Spent()),
				new PieChart.Data("Artwork", test_Artwork_Total_Spent()),
				new PieChart.Data("Furniture", 10000));

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
	    Color[] colors = { Color.web("#e0c300"), Color.web("#e05300"), Color.web("#00ad40") };// Color.web("#0181e2"), Color.web("#2f357f") };
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
		System.out.println(test_Artwork_Total_Spent());
		System.out.println(test_Electronic_Total_Spent() + "\n");
	    test_Electronic_Assets_Over_500();

	}

	
	public static double test_Electronic_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;

		Double sum = 0.0;

		try {
			stmt = conn2.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Electronics ");// WHERE price >= 500
			
			// sum =0;
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

	public static double test_Artwork_Total_Spent() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();
		java.sql.Statement stmt;
		Double sum = 0.0;
		try {
			stmt = conn2.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Artwork ");// WHERE price >= 500
																		
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
	
	
	public static void test_Electronic_Assets_Over_500() {
		Connection conn2 = sqliteConnectionTEST.dbConnector();

		java.sql.Statement stmt;
		try {
			stmt = conn2.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Type,Price FROM Electronics WHERE price >= 500");
			// double sum =0;
			while (rs.next()) {
				String price = rs.getString("Type");
				System.out.println(price + "\n");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

	
