package testingPackage;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by JMDeS on 4/21/2016.
 */
public class Infographics {

    private JFXPanel fxPanel;
    private JFrame fxFrame;
    private JTabbedPane tabbedPane;
    private JFXPanel chartFxPanel;
    private JFXPanel pieChartFxPanel;
    private Chart chart;

    private static final int FX_PANEL_WIDTH = 1000;
    private static final int FX_PANEL_HEIGHT = 700;
    private static final int FX_CHART_WIDTH = 1000;
    private static final int FX_CHART_HEIGHT = 800;

    public Infographics() {
        setFXFrame();
        setFXPanels();

        tabbedPane = new JTabbedPane();
        fxFrame.getContentPane().add(tabbedPane);

        Platform.runLater(() -> createScene());
        tabbedPane.addTab("Bar Chart", chartFxPanel);

        Platform.runLater(() -> createPieScene());
        tabbedPane.addTab("Pie Chart", pieChartFxPanel);

        tabbedPane.setVisible(true);
        
        
    }


    private void createScene() {
        chart = createBarChart();
        chartFxPanel.setScene(new Scene(chart));
       

    }

    private void createPieScene() {
        PieChartSample pcs = new PieChartSample();
        chart = new PieChart(pcs.getPieChartData());
        pieChartFxPanel.setScene(new Scene(chart));
    }

    private BarChart createBarChart() {
        XYChart.Series series = new XYChart.Series();
        TreeMap<String,Double> map = testingPackage.LineChartSample.test_Everything_Total_Spent();
        for(Map.Entry<String,Double> e : map.entrySet()){
            series.getData().add(new XYChart.Data(e.getKey(), e.getValue()));
        }
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Year");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Units Sold");

        final BarChart chart = new BarChart(xAxis, yAxis);
        chart.getData().add(series);

        
        return chart;
    }

    public void setFXFrame() {
        fxFrame = new JFrame();
//        fxFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fxFrame.setVisible(true);
        fxFrame.getContentPane().setBackground(new Color(244, 244, 244));
        fxFrame.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
        fxFrame.setTitle("Insert Asset");
        fxFrame.setBounds(100, 100, 1504, 793);
        fxFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fxFrame.setLocationRelativeTo(null);
        fxFrame.getContentPane().setLayout(null);
        fxFrame.getContentPane().setLayout(new SpringLayout());
        fxFrame.setSize(new Dimension(FX_CHART_WIDTH, FX_CHART_HEIGHT));

        ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));
        fxFrame.setIconImage(icon.getImage());
    }

    private void setFXPanels() {
        // create javafx panel for charts
        //-----------------------------------------------------------------------------------//
        chartFxPanel = new JFXPanel();
        chartFxPanel.setPreferredSize(new Dimension(FX_PANEL_WIDTH, FX_PANEL_HEIGHT));
        //-----------------------------------------------------------------------------------//
        pieChartFxPanel = new JFXPanel();
        pieChartFxPanel.setPreferredSize(new Dimension(FX_PANEL_WIDTH, FX_PANEL_HEIGHT));
        //-----------------------------------------------------------------------------------//
        fxPanel = new JFXPanel();
        fxPanel.setBounds(0, 0, 0, 0);
        fxPanel.setPreferredSize(new Dimension(300,300));
    }




}
