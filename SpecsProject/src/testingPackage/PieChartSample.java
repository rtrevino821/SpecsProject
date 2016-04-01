package testingPackage;

import java.beans.Statement;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.chart.PieChart.Data;
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
		stage.setTitle("Pie Graph Company Total Spent");
		stage.setWidth(600);
		stage.setHeight(575);

			ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Art: ", test_ArtWork_Total_Spent()),
				new PieChart.Data("Cabinets: ", test_Furniture_Total_Spent()),
				new PieChart.Data("Pc's: ", test_Computers_Total_Spent()),
				new PieChart.Data("Software: ", test_Computer_Software_Total_Spent()),
				new PieChart.Data("Battery backups: ", test_Batter_Backup_Total_Spent()),
				new PieChart.Data("Pc/misc", test_Computer_MISC_Total_Spent()),
				new PieChart.Data("Printers", test_Printers_Total_Spent()),
				new PieChart.Data("Transcription.", test_Transcription_Total_Spent()),
				new PieChart.Data("Video/Projectors", test_Video_Projector_Total_Spent()),
				new PieChart.Data("Fixtures", test_Furniture_Fixtures_Total_Spent()),
				new PieChart.Data("LeaseHold", test_LeaseHold_Total_Spent()),
				new PieChart.Data("Property.", test_Personal_Property_Total_Spent()));

		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Group Totals");
		chart.setLegendSide(Side.RIGHT); // sets legends position
		chart.setLabelsVisible(false); // set label visibility
		// chart.setLabelLineLength(50);
		final Label caption = new Label("");
		caption.setTextFill(Color.WHITE);
		caption.setStyle("-fx-font: 24 arial;");

		applyCustomColorSequence(pieChartData, "#AA0114", "#CCCCCC", "#FF0000", "#FF6600", "#336699", "#666666",
				"#003366", "#000000", "#FFCC00", "#FF9900", "#00FF00", "#3399FF");

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

        // SETS LEGEND SETTINGS GLOW AND COLORs FOR THE PIE SLICES //
        Set<Node> items = chart.lookupAll("Label.chart-legend-item");
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
    }

    public static void main(String[] args) {
        launch(args);
//        System.out.println("Cabinets:  "+test_Furniture_Total_Spent()+ "  correct value "+ "\n");
//        System.out.println("Pc's:  "+test_Computers_Total_Spent()+"  correct value"+"\n");
//        System.out.println("furniture:  " + test_Furniture_Fixtures_Total_Spent() + "  correct value"+"\n");
//        System.out.println("Art:  "+test_ArtWork_Total_Spent()+ "  correct value" + "\n");
//        System.out.println("Software:  "+test_Computer_Software_Total_Spent()+ "  correct value"+"\n");
//        System.out.println("battery:  "+test_Batter_Backup_Total_Spent()+ "  correct value"+"\n");   
//        System.out.println("Misc:  " +test_Computer_MISC_Total_Spent()+ "  correct value"+"\n");
//        System.out.println("printers:  "+ test_Printers_Total_Spent()+ "  correct value"+ "\n");
//        System.out.println("transcription:  "+ test_Transcription_Total_Spent()+ "  correct value" + "\n");
//        System.out.println("video_projectors:  " + test_Video_Projector_Total_Spent()+ "  correct value" +  "\n");
//        System.out.println("personal property:  "  + test_Personal_Property_Total_Spent()+ "  correct value" +"\n");
//        System.out.println("LeaseHold: "+test_LeaseHold_Total_Spent()+ "\n");
//        System.out.println("\n" +"TOTAL DOLLAR SPENT:  " +test_Everything_Total_Spent());
       
       
    //    String date ="2001-10-17";
    //    test_Assets_Over_500(date);
       
       

//        String date = "2001-01-01";
//        String date2 = "2003-12-31";
//       
//            try {
//                test_Date_Range_Over_500(date,date2);
//            } catch (SQLException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (ParseException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }

       
        //Search_By_Room(0);
        Search_Retired_Assets();
       
    }
       
    private void applyCustomColorSequence(ObservableList<PieChart.Data> pieChartData, String... pieColors) {
        int i = 0;
        for (PieChart.Data data : pieChartData) {
          data.getNode().setStyle("-fx-pie-color: " + pieColors[i % pieColors.length] + ";");
          i++;
        }
      }
   
   
    public static void Search_Retired_Assets() {

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;
       String retired= " ";
        try {
            stmt = conn2.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT \"group\",Retired"
                    + " From MasterTable Where MasterTable.Retired Like 'Removed'");

            //boolean does_Room_Exist = false;

            while (rs.next()) {
              //  does_Room_Exist = true;  // sets room exists to true 
                retired = rs.getString("Retired");
                String group = rs.getString("Group");
                System.out.println("Group: " + group + "  " + retired);
            }
            //if (!does_Room_Exist)
                //System.out.println("Error Enter Valid Room Number");
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
   
   
    /* SEARCH BY ROOM_NUMBER RETURNS ITEM BY ROOM NUMBERS */
    public static void Search_By_Room(int room_Number) {

        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;
       
        try {
            stmt = conn2.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT \"group\",Property_Description,Room_Number"
                    + " From MasterTable Where MasterTable.Room_Number = " + room_Number + ";");

            boolean does_Room_Exist = false;

            while (rs.next()) {
                does_Room_Exist = true;  // sets room exists to true 
                room_Number = rs.getInt("Room_Number");
                String item_Description = rs.getString("Property_Description");
                System.out.println("Room Number: " + room_Number + "  " + item_Description);
            }
            if (!does_Room_Exist)
                System.out.println("Error Enter Valid Room Number");
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
   
    public static void test_Date_Range_Over_500(String date, String date2) throws SQLException, ParseException { // String date
        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

                                                            //
        String str_rs = ("SELECT \"group\",Price,Property_Description,Date_In_Service From MasterTable"
                + " Where MasterTable.Date_In_Service Between ? and ? ORDER BY MasterTable.Date_In_Service DESC");
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
       
        //java.util.Date startDate = formatter.parse(date);
        //java.util.Date endDate = formatter.parse(date2);
        PreparedStatement statement = conn2.prepareStatement(str_rs);
       
        try { 
           
            statement.setString(1, date);   
            statement.setString(2, date2);   
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
   
   

    /* RETURNS ITEMS PURCHASED OVER 500 FOR SELECTED YEAR */
    public static void test_Assets_Over_500(String date) { // String date
        Connection conn2 = sqliteConnectionTEST.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT \"group\",Price,Property_Description,Date_In_Service"
                    + " From MasterTable Where MasterTable.Price>=0");

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