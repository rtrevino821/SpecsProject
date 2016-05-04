package graphs;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javafx.scene.Node;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sqliteConnection.SqliteConnectionCarmaDB;

public class LineChartSample extends Application{
    @Override public void start(Stage stage) {
        stage.setTitle("Cost Per Year");
       
        TreeMap<String,Double> map = test_Everything_Total_Spent();
       
       
        //defining the axes
//        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final CategoryAxis xAxis = new CategoryAxis();
       
        xAxis.setLabel("Year");
        yAxis.setLabel("Total Spent");
       
        //creating the chart
        final LineChart<String,Number> lineChart =
                new LineChart<String,Number>(xAxis,yAxis);
       
        final Label caption = new Label("");

       
        lineChart.setTitle("Total Spending Per Year");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Total Spent");
        //populating the series with data
        for(Entry<String,Double> e : map.entrySet()){
//            System.out.println("year: "+e.getKey()+", spent: "+e.getValue());
            series.getData().add(new XYChart.Data(e.getKey(), e.getValue()));
        }
//        series.getData().add(new XYChart.Data(1, 23));
//        series.getData().add(new XYChart.Data(2, 14));
//        series.getData().add(new XYChart.Data(3, 15));
//        series.getData().add(new XYChart.Data(4, 24));
//        series.getData().add(new XYChart.Data(5, 34));
//        series.getData().add(new XYChart.Data(6, 36));
//        series.getData().add(new XYChart.Data(7, 22));
//        series.getData().add(new XYChart.Data(8, 45));
//        series.getData().add(new XYChart.Data(9, 43));
//        series.getData().add(new XYChart.Data(10, 17));
//        series.getData().add(new XYChart.Data(11, 29));
//        series.getData().add(new XYChart.Data(12, 25));
       
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
     
        stage.setScene(scene);
        stage.show();
    }
   
    public static TreeMap<String,Double> test_Everything_Total_Spent() {
        Connection conn2 = SqliteConnectionCarmaDB.dbConnector();
        java.sql.Statement stmt;

        TreeMap<String,Double> yearlyTotalSpent = new TreeMap<String,Double>();
       
        try {
            stmt = conn2.createStatement(); //\"group\",price  //\"group\",price       //(MasterTable.\"group\" Like 'Furniture & Fixtures' And
            ResultSet rs = stmt.executeQuery("SELECT Category,Price, substr(Date_Acquired, 0, 5) AS y From MasterTable Where MasterTable.Price>0 ORDER BY y ASC" );// WHERE price >= 500
           
            // sum =0;
            while (rs.next()) {
                Double price = rs.getDouble("Price");
                String year = rs.getString("y");
                System.out.println(year);
                if ( yearlyTotalSpent.containsKey(year))
                {
                    double oldValue = yearlyTotalSpent.get(year);
                    yearlyTotalSpent.replace(year, oldValue, round(oldValue+price));
                } else {
                    yearlyTotalSpent.put(year, price);
                }
            }
            for (Entry<String,Double> e : yearlyTotalSpent.entrySet()){
                System.out.println("year: "+e.getKey()+", spent: "+e.getValue());
            }
        } catch (SQLException e) {
            System.out.println("sql exception caught");
            e.printStackTrace();
        }
        return yearlyTotalSpent;
    }
   
    public static double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
 
    public static void main(String[] args) {
        launch(args);
//        Map<String,Integer> map = test_Everything_Total_Spent();
//        for(Entry<String,Integer> e : map.entrySet()){
//            System.out.println("year: "+e.getKey()+", Total Spent: "+e.getValue());
//        }
    }
}