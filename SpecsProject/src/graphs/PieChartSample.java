package graphs;

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
import sqliteConnection.SqliteConnectionTESTDB;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Set;

public class PieChartSample extends PieChart {
	ObservableList<PieChart.Data> pieChartData;
//	@Override

	public ObservableList<PieChart.Data> getPieChartData(){
		return pieChartData;
	}

	public PieChartSample () {
		super();
//		Pane root = new Pane();
//		Scene scene = new Scene(root);
//		stage.setTitle("Pie Graph Company Total Spent");
//		stage.setWidth(600);
//		stage.setHeight(575);

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

//        root.getChildren().addAll(chart, caption);
//        stage.setScene(scene);
//        stage.show();

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

//    public static void main(String[] args) {
////        launch(args);
//
//
//       // Search_By_Room(0);
//        //Search_Retired_Assets_By_Category("Computer Software");
//        Search_Retired_Assets();
//        //test_individual_Category_Total_Spent("Computers", "2013");
//        //test_Assets_Over_500_By_Year("1997");
//        //test_individual_Category_Total_Spent("Computers", "2008");
//        //All_Assets_Over_500();
//
//        /*String date = "1997-01-01";
//        String date2 = "2002-12-31";
//        try {
//			test_Date_Range_Over_500(date,date2);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        */
//
//
////      System.out.println("new method  "+test_Total_By_Category("Computers") + " good");
////    System.out.println("Pc's++++++++++++++:  "+test_Computers_Total_Spent()+"  correct value"+"\n");
////      System.out.println("new method  "+test_Total_By_Category("ArtWork"));
////    System.out.println("Art:  "+test_ArtWork_Total_Spent()+ "  correct value" + "\n");
////      System.out.println("new method  "+test_Total_By_Category("Computer Software"));
////    System.out.println("Software:  "+test_Computer_Software_Total_Spent()+ "  correct value"+"\n");
////      System.out.println("new method  "+test_Total_By_Category("Computers Battery Backups"));
////    System.out.println("battery:  "+test_Batter_Backup_Total_Spent()+ "  correct value"+"\n");
////      System.out.println("new method  "+test_Total_By_Category("Computers MISC & Server E"));
////    System.out.println("Misc:  " +test_Computer_MISC_Total_Spent()+ "  correct value"+"\n");
////      System.out.println("new method  "+test_Total_By_Category("Personal Property"));
////    System.out.println("personal property:  "  + test_Personal_Property_Total_Spent()+ "  correct value" +"\n");
////      System.out.println("new method  "+test_Total_By_Category("Computers Printers"));
////    System.out.println("printers:  "+ test_Printers_Total_Spent()+ "  correct value"+ "\n");
////      System.out.println("new method  "+test_Total_By_Category("Computers Transcription"));
////    System.out.println("transcription:  "+ test_Transcription_Total_Spent()+ "  correct value" + "\n");
////      System.out.println("new method  "+test_Total_By_Category("Computers Video/Proj Eq"));
////    System.out.println("video_projectors:  " + test_Video_Projector_Total_Spent()+ "  correct value" +  "\n");
////      System.out.println("new method  "+test_Total_By_Category("Furniture & Fixtures"));
////    System.out.println("furniture:  " + test_Furniture_Fixtures_Total_Spent() + "  correct value"+"\n");
////     System.out.println("new method  "+test_Total_By_Category("Furniture & Fixture Cabinets"));
////    System.out.println("Cabinets:  "+test_Furniture_Total_Spent()+ "  correct value "+ "\n");
////      System.out.println("new method  "+test_Total_By_Category("Leasehold Improvements"));
////    System.out.println("LeaseHold: "+test_LeaseHold_Total_Spent()+ "\n");
//
// }
       
    private void applyCustomColorSequence(ObservableList<PieChart.Data> pieChartData, String... pieColors) {
        int i = 0;
        for (PieChart.Data data : pieChartData) {
          data.getNode().setStyle("-fx-pie-color: " + pieColors[i % pieColors.length] + ";");
          i++;
        }
      }
   
    
    //     FINISH THIS SHIT!!!!!!!!!!!!!!!!!
    public static void display_entire_Report() { 
    	
    	Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			ResultSet rs = stmt.executeQuery("Select");
    	
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
    }

    // QUERY RETURNS ALL RETIRED ASSETS           
	public static void Search_Retired_Assets() {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Category,Deactivated"
					+ " From MasterTable Where MasterTable.Deactivated LIKE 'Removed'");

			while (rs.next()) {
				String category = rs.getString("Category");

				String retired = rs.getString("Deactivated");
				System.out.println("Group: " + category + "  " + retired);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
	// SEARCH RETIRED ASSETS BY CATEGORY NAME         
	public static void Search_Retired_Assets_By_Category(String group1) {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT Category, Deactivated From MasterTable Where MasterTable.Deactivated Like 'Removed'");

			while (rs.next()) {
				// does_Room_Exist = true; // sets room exists to true

				String group = rs.getString("Category");
				String retired = rs.getString("Deactivated");

				if (group.contains(group1)) {

					System.out.println("Category: " + group + "  " + retired);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void All_Assets_Over_500() { // String date
        Connection conn2 = SqliteConnectionTESTDB.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Category,Price,Item_Name,Date_Acquired"
                    + " From MasterTable Where MasterTable.Price>=500");

            while (rs.next()) {
	
            	String date_in = rs.getString("Date_Acquired");
                Double price = rs.getDouble("Price");
                String item_Description = rs.getString("Item_Name");
                
                System.out.println(item_Description + "  " + price + " " + date_in);
            }
        } catch (SQLException e) {
            System.out.println("sql exception caught");
            e.printStackTrace();
        }
	}
	
	/* RETURNS ITEMS PURCHASED OVER 500 FOR SELECTED YEAR SEARCH BY YEAR ONLY (DONT INCLUDE DAY OR MONTH*/
    public static void test_Assets_Over_500_By_Year(String date) { // String date
        Connection conn2 = SqliteConnectionTESTDB.dbConnector();
        java.sql.Statement stmt;

        try {
            stmt = conn2.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Category,Price,Item_Name,Date_Acquired"
                    + " From MasterTable Where MasterTable.Price>=500");

            while (rs.next()) {

                String date_in = rs.getString("Date_Acquired");
                Double price = rs.getDouble("Price");
                String item_Description = rs.getString("Item_Name");
               
                if (date_in.contains(date) ) { // if contains chosen year

                    System.out.println(item_Description + "  " + price + " " + date_in);
                }
            }
        } catch (SQLException e) {
            System.out.println("sql exception caught");
            e.printStackTrace();
        }
    }
	
    /* FIND ALL ASSETS PURCHASED OVER 500 DOLLARS SEARCH BY EXACT DATE RANGE */ 
    public static void test_Date_Range_Over_500(String date, String date2) throws SQLException, ParseException { // String date
        Connection conn2 = SqliteConnectionTESTDB.dbConnector();
        java.sql.Statement stmt;

        String str_rs = ("SELECT Category,Price,Item_Name,Date_Acquired From MasterTable"
                + " Where (MasterTable.Date_Acquired Between ? and ? AND MasterTable.Price>=500)ORDER BY MasterTable.Date_Acquired DESC");
       
        PreparedStatement statement = conn2.prepareStatement(str_rs);
       
        try { 
           
            statement.setString(1, date);   
            statement.setString(2, date2);   
            ResultSet rs = statement.executeQuery();
             
            while (rs.next()) {
            	String date_in = rs.getString("Date_Acquired");
                Double price = rs.getDouble("Price");
                String item_Description = rs.getString("Item_Name");
               
                System.out.println(item_Description + "  " + price + "      " + date_in);
                }
            
        } catch (SQLException e) {
            System.out.println("sql exception caught");
            e.printStackTrace();
        }
    }
    
    
    
    /* TOTAL DOLLAR SPENT PER CATEGORY (SEARCH BY CATEGORY NAME AND YEAR)*/
	public static void test_individual_Category_Total_Spent(String group, String year) {
		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		double sum = 0;
		try {
			stmt = conn2.createStatement(); 
			ResultSet rs = stmt.executeQuery("SELECT Category,Price,Date_Acquired"
					               + " From MasterTable Where MasterTable.Price>0");
			while (rs.next()) {
				String group1 = rs.getString("Category");
                String date_in = rs.getString("Date_Acquired");

				if (group1.equals(group) && date_in.contains(year) ) { //
					
					Double price = rs.getDouble("Price");
					sum += price;
				}
			}
			System.out.println("Total Spent On " + group + " in " + year + " " +round(sum));
		
		} catch (SQLException e) {
			System.out.println("sql exception caught");
			e.printStackTrace();
		}
	}
    
   
	/* SEARCH BY ROOM_NUMBER RETURNS ITEM BY ROOM NUMBERS */
	public static void Search_By_Room(int room_Number) {

		Connection conn2 = SqliteConnectionTESTDB.dbConnector();
		java.sql.Statement stmt;

		try {
			stmt = conn2.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Category,Item_Name,Room"
					+ " From MasterTable Where MasterTable.Room = " + room_Number + ";");

			boolean does_Room_Exist = false;

			while (rs.next()) {
				does_Room_Exist = true; // sets room exists to true
				room_Number = rs.getInt("Room");
				String item_Description = rs.getString("Item_Name");
				System.out.println("Room Number: " + room_Number + "  " + item_Description);
			}
			if (!does_Room_Exist)
				System.out.println("Error Enter Valid Room Number");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
   
   
        
    
    /*  FINDS TOTAL AMOUNT SPENT ENTIRE INVENTORY SYSTEM*/
    public static double test_Everything_Total_Spent() {
        Connection conn2 = SqliteConnectionTESTDB.dbConnector();
        java.sql.Statement stmt;

        Double sum = 0.0;

        try {
            stmt = conn2.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Category,Price,Asset From MasterTable Where MasterTable.Price>0 " );
           
   
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
    
    
   
    /*FOLLOWING QUERYS USED FOR PIE CHART TO DISPLAY INDIVIDUAL CATEGORY TOTALS*/
    
    public static double test_Total_By_Category(String group) {
        Connection conn2 = SqliteConnectionTESTDB.dbConnector();
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

	}

//    public static double test_LeaseHold_Total_Spent() {
//        Connection conn2 = sqliteConnectionTEST.dbConnector();
//        java.sql.Statement stmt;
//
//        Double sum = 0.0;
//
//        try {
//            stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
//            ResultSet rs = stmt.executeQuery("SELECT \"group\",Price,Asset From MasterTable"
//                    + " Where (MasterTable.\"group\" Like 'Leasehold Improvements' And MasterTable.Price>0) " );
//           
//            while (rs.next()) {
//                Double price = rs.getDouble("Price");
//                sum += price;
//            }
//            //System.out.println(sum + "\n");
//        } catch (SQLException e) {
//            System.out.println("sql exception caught");
//            e.printStackTrace();
//        }
//        return round(sum);
//    }
//   
//   
//    public static double test_Furniture_Fixtures_Total_Spent() {
//        Connection conn2 = sqliteConnectionTEST.dbConnector();
//        java.sql.Statement stmt;
//
//        Double sum = 0.0;
//
//        try {
//            stmt = conn2.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT \"group\",Price,Asset From MasterTable"
//                    + " Where (MasterTable.\"group\" Like 'Furniture & Fixtures' And MasterTable.Price>0) " );
//           
//            // sum =0;
//            while (rs.next()) {
//                Double price = rs.getDouble("Price");
//                //int asset =rs.getInt("Asset");
//               
//                //System.out.println("asset number: "+asset);
//                sum += price;
//            }
//            //System.out.println(sum + "\n");
//        } catch (SQLException e) {
//            System.out.println("sql exception caught");
//            e.printStackTrace();
//        }
//        return round(sum);
//    }
//
//    public static double test_Computer_MISC_Total_Spent() {
//        Connection conn2 = sqliteConnectionTEST.dbConnector();
//        java.sql.Statement stmt;
//
//        Double sum = 0.0;
//
//        try {
//            stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
//            ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable"
//                        + " Where (MasterTable.\"group\" Like '%Server%' And MasterTable.Price>0) " );
//           
//            // sum =0;
//            while (rs.next()) {
//                Double price = rs.getDouble("Price");
//                //System.out.println(price);
//                sum += price;
//            }
//            //System.out.println(sum + "\n");
//        } catch (SQLException e) {
//            System.out.println("sql exception caught");
//            e.printStackTrace();
//        }
//        return round(sum);
//    }
//   
//   
//   
//   
//   
//   
//    public static double test_Transcription_Total_Spent() {
//        Connection conn2 = sqliteConnectionTEST.dbConnector();
//        java.sql.Statement stmt;
//
//        Double sum = 0.0;
//
//        try {
//            stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
//            ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable"
//                    + " Where (MasterTable.\"group\" Like '%Transcription%' And MasterTable.Price>0) " );
//           
//            // sum =0;
//            while (rs.next()) {
//                Double price = rs.getDouble("Price");
//                //System.out.println(price);
//                sum += price;
//            }
//            //System.out.println(sum + "\n");
//        } catch (SQLException e) {
//            System.out.println("sql exception caught");
//            e.printStackTrace();
//        }
//        return round(sum);
//    }
//   
//   
//   
//    public static double test_ArtWork_Total_Spent() {
//        Connection conn2 = sqliteConnectionTEST.dbConnector();
//        java.sql.Statement stmt;
//
//        Double sum = 0.0;
//
//        try {
//            stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
//            ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable"
//                        + " Where (MasterTable.\"group\" Like '%ArtWork%' And MasterTable.Price>0) " );
//           
//            // sum =0;
//            while (rs.next()) {
//                Double price = rs.getDouble("Price");
//                //System.out.println(price);
//                sum += price;
//            }
//            //System.out.println(sum + "\n");
//        } catch (SQLException e) {
//            System.out.println("sql exception caught");
//            e.printStackTrace();
//        }
//        return round(sum);
//    }
//
//    public static double test_Batter_Backup_Total_Spent() {
//        Connection conn2 = sqliteConnectionTEST.dbConnector();
//        java.sql.Statement stmt;
//
//        Double sum = 0.0;
//
//        try {
//            stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
//            ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable"
//                        + " Where (MasterTable.\"group\" Like '%Battery%' And MasterTable.Price>0) " );
//           
//            while (rs.next()) {
//                Double price = rs.getDouble("Price");
//                sum += price;
//            }
//        } catch (SQLException e) {
//            System.out.println("sql exception caught");
//            e.printStackTrace();
//        }
//        return round(sum);
//    }
//   
//   
//    public static double test_Personal_Property_Total_Spent() {
//        Connection conn2 = sqliteConnectionTEST.dbConnector();
//        java.sql.Statement stmt;
//
//        Double sum = 0.0;
//
//        try {
//            stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
//            ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable"
//                        + " Where (MasterTable.\"group\" Like 'Personal Property' And MasterTable.Price>0) " );
//           
//            // sum =0;
//            while (rs.next()) {
//                Double price = rs.getDouble("Price");
//                //System.out.println(price);
//                sum += price;
//            }
//            //System.out.println(sum + "\n");
//        } catch (SQLException e) {
//            System.out.println("sql exception caught");
//            e.printStackTrace();
//        }
//        return round(sum);
//    }
//   
//   
//   
//    public static double test_Computer_Software_Total_Spent() {
//        Connection conn2 = sqliteConnectionTEST.dbConnector();
//        java.sql.Statement stmt;
//
//        Double sum = 0.0;
//
//        try {
//            stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
//            ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable"
//                        + " Where (MasterTable.\"group\" Like '%Software%' And MasterTable.Price>0) " );
//           
//            // sum =0;
//            while (rs.next()) {
//                Double price = rs.getDouble("Price");
//                //System.out.println(price);
//                sum += price;
//            }
//            //System.out.println(sum + "\n");
//        } catch (SQLException e) {
//            System.out.println("sql exception caught");
//            e.printStackTrace();
//        }
//        return round(sum);
//    }
//   
//   
//    public static double test_Printers_Total_Spent() {
//        Connection conn2 = sqliteConnectionTEST.dbConnector();
//        java.sql.Statement stmt;
//
//        Double sum = 0.0;
//
//        try {
//            stmt = conn2.createStatement(); //\"group\",price  //\"group\",price
//            ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable"
//                            + " Where (MasterTable.\"group\" Like '%Printers%' And MasterTable.Price>0) " );
//           
//            // sum =0;
//            while (rs.next()) {
//                Double price = rs.getDouble("Price");
//                //System.out.println(price);
//                sum += price;
//            }
//            //System.out.println(sum + "\n");
//        } catch (SQLException e) {
//            System.out.println("sql exception caught");
//            e.printStackTrace();
//        }
//        return round(sum);
//    }
//   
//    public static double test_Computers_Total_Spent() {
//        Connection conn2 = sqliteConnectionTEST.dbConnector();
//        java.sql.Statement stmt;
//
//        Double sum = 0.0;
//
//        try {
//            stmt = conn2.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable"
//                        + " Where (MasterTable.\"group\" Like 'Computers' And MasterTable.Price>0) " );
//           
//            while (rs.next()) {
//                Double price = rs.getDouble("Price");
//                //System.out.println(price);
//                sum += price;
//            }
//        } catch (SQLException e) {
//            System.out.println("sql exception caught");
//            e.printStackTrace();
//        }
//        return round(sum);
//    }
//       
//    public static double test_Video_Projector_Total_Spent() {
//        Connection conn2 = sqliteConnectionTEST.dbConnector();
//        java.sql.Statement stmt;
//        Double sum = 0.0;
//        try {
//            stmt = conn2.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable "
//                        + "Where (MasterTable.\"group\" Like '%Video/Proj%' And MasterTable.Price>0) " );
//                                                                       
//            while (rs.next()) {
//                Double price = rs.getDouble("Price");
//                sum += price;
//            }
//            // System.out.println(sum + "\n");
//
//        } catch (SQLException e) {
//            System.out.println("sql exception caught");
//            e.printStackTrace();
//        }
//        return round(sum);
//    }
//   
//   
//   
//    public static double test_Furniture_Total_Spent() {
//        Connection conn2 = sqliteConnectionTEST.dbConnector();
//        java.sql.Statement stmt;
//        Double sum = 0.0;
//        try {
//            stmt = conn2.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT \"group\",Price From MasterTable "
//                       + "Where (MasterTable.\"group\" Like '%Cabinets' And MasterTable.Price>0) " );
//                                                                       
//            while (rs.next()) {
//                Double price = rs.getDouble("Price");
//                sum += price;
//            }
//
//        } catch (SQLException e) {
//            System.out.println("sql exception caught");
//            e.printStackTrace();
//        }
//        return round(sum);
//    }
   
}