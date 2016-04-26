package testingPackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Reflection;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class PieChartSample extends PieChart {
	ObservableList<PieChart.Data> pieChartData;
//	@Override

	public ObservableList<PieChart.Data> getPieChartData(){
		pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Art: ", test_Total_By_Category("ArtWork")),
				new PieChart.Data("Cabinets: ", test_Total_By_Category("Furniture & Fixture Cabinets")),
				new PieChart.Data("Pc's: ", test_Total_By_Category("Computers")),
				new PieChart.Data("Software: ", test_Total_By_Category("Computer Software")),
				new PieChart.Data("Battery backups: ", test_Total_By_Category("Computers Battery Backups")),
				new PieChart.Data("Pc/misc", test_Total_By_Category("Computers MISC & Server E")),
				new PieChart.Data("Printers", test_Total_By_Category("Computers Printers")),
				new PieChart.Data("Transcription.", test_Total_By_Category("Computers Transcription")),
				new PieChart.Data("Video/Projectors", test_Total_By_Category("Computers Video/Proj Eq")),
				new PieChart.Data("Fixtures", test_Total_By_Category("Furniture & Fixtures")),
				new PieChart.Data("LeaseHold", test_Total_By_Category("Leasehold Improvements")),
				new PieChart.Data("Property.", test_Total_By_Category("Personal Property")));

		return pieChartData;
	}

	public PieChartSample () {

		super();
		setData(getPieChartData());

//		final PieChart chart = new PieChart(pieChartData);
		this.setTitle("Group Totals");
		this.setLegendSide(Side.RIGHT); // sets legends position
		this.setLabelsVisible(false); // set label visibility
		// chart.setLabelLineLength(50);
		final Label caption = new Label("");
		caption.setTextFill(Color.WHITE);
		caption.setStyle("-fx-font: 24 arial;");

		applyCustomColorSequence(pieChartData, "#AA0114", "#CCCCCC", "#FF0000", "#FF6600", "#336699", "#666666",
				"#003366", "#000000", "#FFCC00", "#FF9900", "#00FF00", "#3399FF");

		for (final PieChart.Data data : this.getData()) {
			data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
				double total = 0;
				for (PieChart.Data value : this.getData()) {
					total += value.getPieValue();
				}
				caption.setTranslateX(e.getSceneX());
				caption.setTranslateY(e.getSceneY());
				String text = String.format("%.1f%%", 100 * data.getPieValue() / total);
				caption.setText(text);
			});
		}

        // SETS LEGEND SETTINGS GLOW AND COLORs FOR THE PIE SLICES //
        Set<Node> items = this.lookupAll("Label.chart-legend-item");
        int i = 0;
        Color[] colors_Settings = { Color.web("#AA0114"), Color.web("#CCCCCC"), Color.web("#FF0000"),
                Color.web("#FF6600"), Color.web("#336699"), Color.web("#666666"), Color.web("#003366"),
                Color.web("#000000"), Color.web("#FFCC00"), Color.web("#FF9900"), Color.web("#00FF00"),
                Color.web("#3399FF"), };// Color.web("#2f357f"),
                                        // };
        for (Node item : items) {
            Label label = (Label) item;
            final Rectangle colors = new Rectangle(10, 10, colors_Settings[i]);
            final Glow legend_glow = new Glow();
            legend_glow.setInput(new Reflection());
            colors.setEffect(legend_glow);
            label.setGraphic(colors);
            i++;
        }

//		applyCustomColorSequence(pieChartData);
    }

    private void applyCustomColorSequence(ObservableList<PieChart.Data> pieChartData, String... pieColors) {
        int i = 0;
        for (PieChart.Data data : pieChartData) {
          data.getNode().setStyle("-fx-pie-color: " + pieColors[i % pieColors.length] + ";");
          i++;
        }
      }

    /*FOLLOWING QUERYS USED FOR PIE CHART TO DISPLAY INDIVIDUAL CATEGORY TOTALS*/
    
    public static double test_Total_By_Category(String group) {
        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        double sum = 0;
		try {
			stmt = conn2.createStatement(); 
			ResultSet rs = stmt.executeQuery("SELECT Category,Price"
					               + " From MasterTable Where MasterTable.Price>0");
			while (rs.next()) {
				String group1 = rs.getString("Category");
				
				if (group1.equals(group)) { //
					
					Double price = rs.getDouble("Price");
					sum += price;
				}
			}
			//System.out.println("New method  " + group + " " + round(sum));
		
        } catch (SQLException e) {
            System.out.println("sql exception caught");
            e.printStackTrace();
        }
       // return round(sum);
		return round(sum);
    }
    
    /* ROUNDS DECIMAL NUMBERS TWO PLACES*/
    public static double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

	@Override
	protected void layoutChartChildren(double top, double left, double width, double height) {
		super.layoutChartChildren(top,left,width,height);
	}

}