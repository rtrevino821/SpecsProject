

package testingPackage;

import appPackage.sqliteConnection;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.util.Map;
import java.util.TreeMap;


public class MainScreen extends JApplet{

//    private static JFrame frame;

    Connection connection = null;

    private JFrame frame;
    private InsertPanel insertPane;
    private JFXPanel fxPanel;
    private JFrame fxFrame;
    private JFXPanel chartFxPanel;
    private JFXPanel pieChartFxPanel;
    private Chart chart;

    private JLabel Logo_MainScreen;
    private JLabel lblATeamSoftware;
    private JLabel reportsIcon;
    private JLabel insertIcon;
    private JLabel infoGraphIcon;
    private JLabel excelFuncIcon;
    private JLabel interWebIcon;
    private JLabel helpIcon;

    private static final int MAINSCREEN_WIDTH = 1440;
    private static final int MAINSCREEN_HEIGHT = 865;
    private static final int FX_PANEL_WIDTH = 1000;
    private static final int FX_PANEL_HEIGHT = 700;
    private static final int FX_CHART_HEIGHT = 800;


    /**
    * Create the Main Application.
    *
    */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                MainScreen mainScreen = new MainScreen();
            } catch (Exception e) {
            	e.printStackTrace();
            	}
        });
    }


    public MainScreen() throws URISyntaxException {
        super();
        connection = sqliteConnection.dbConnector();
        init();
//        UpdateTable();
    }

    /**
    * Initialize the contents of the frame.
    */
    @Override
    public void init() {

        setFXPanels();
        setFrame();

        setMiscLabels();

        setReportsIcon();
        setInsertIcon();
        setInfoGraphIcon();
        setExcelFuncIcon();
        setInterWebIcon();
        setHelpIcon();
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
        fxFrame.setSize(new Dimension(FX_PANEL_WIDTH, FX_CHART_HEIGHT));

        ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));
        fxFrame.setIconImage(icon.getImage());
    }

    private void setFrame() {
        frame = new JFrame();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/Resources/appIconImage.png")));
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(fxPanel);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(244, 244, 244));
        frame.setBackground(Color.WHITE);
        frame.setTitle("GFP Asset Report System");
        frame.setSize(MAINSCREEN_WIDTH, MAINSCREEN_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
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

    private void setMiscLabels() {
        Logo_MainScreen = new JLabel("");
        Logo_MainScreen.setBounds(15, 16, 300, 65);
        Logo_MainScreen.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/Logo_Alt_2.jpg")));
        frame.getContentPane().add(Logo_MainScreen);

        lblATeamSoftware = new JLabel("A Team Software Suite 2016");
        lblATeamSoftware.setBounds(1086, 773, 317, 20);
        lblATeamSoftware.setHorizontalAlignment(SwingConstants.RIGHT);
        lblATeamSoftware.setForeground(new Color(98, 98, 98));
        lblATeamSoftware.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
        frame.getContentPane().add(lblATeamSoftware);
    }
    //------BUTTON SETUP METHODS----------//

    private void setReportsIcon() {
        reportsIcon = new JLabel("");
        reportsIcon.setHorizontalAlignment(SwingConstants.CENTER);
        reportsIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/reportIcon.jpg")));
        reportsIcon.setBounds(59, 123, 394, 301);
        frame.getContentPane().add(reportsIcon);
        reportsIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //helpIconLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                reportsIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/reportIcon_Hover.jpg")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                reportsIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/reportIcon.jpg")));
            }
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    new reportsFrame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void setInsertIcon() {
        insertIcon = new JLabel("");
        insertIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/editReportIcon.jpg")));
        insertIcon.setHorizontalAlignment(SwingConstants.CENTER);
        insertIcon.setBounds(512, 123, 394, 301);
        frame.getContentPane().add(insertIcon);
        insertIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //helpIconLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                insertIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/editReportIcon_Hover.jpg")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                insertIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/editReportIcon.jpg")));
            }
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    insertPane = new InsertPanel();
                    insertPane.setVisible(true);
                } catch (Exception e) {e.printStackTrace();}
            }
        });
    }

    private void setInfoGraphIcon(){
        infoGraphIcon = new JLabel("");
        infoGraphIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/infoGraphic.jpg")));
        infoGraphIcon.setHorizontalAlignment(SwingConstants.CENTER);
        infoGraphIcon.setBounds(965, 123, 394, 301);
        frame.getContentPane().add(infoGraphIcon);
        infoGraphIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //helpIconLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                infoGraphIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/infoGraphic_Hover.jpg")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                infoGraphIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/infoGraphic.jpg")));
            }
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    // create JavaFX scene
                    setFXFrame();
                    JTabbedPane tabbedPane = new JTabbedPane();
                    fxFrame.getContentPane().add(tabbedPane);

                    Platform.runLater(() -> createScene());
                    tabbedPane.addTab("Bar Chart", chartFxPanel);

                    Platform.runLater(() -> createPieScene());
                    tabbedPane.addTab("Pie Chart", pieChartFxPanel);

                    tabbedPane.setVisible(true);

                    //report.setVisible(true);
                } catch (Exception e) {e.printStackTrace();}
            }
        });
    }

    private void setExcelFuncIcon() {
        excelFuncIcon = new JLabel("");
        excelFuncIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/excelIcon.jpg")));
        excelFuncIcon.setHorizontalAlignment(SwingConstants.CENTER);
        excelFuncIcon.setBounds(59, 432, 394, 301);
        frame.getContentPane().add(excelFuncIcon);
        excelFuncIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //helpIconLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                excelFuncIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/excelIcon_Hover.jpg")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                excelFuncIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/excelIcon.jpg")));
            }
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    ExcelFrame frame = new ExcelFrame();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {e.printStackTrace();}
            }
        });
    }

    private void setInterWebIcon() {
        interWebIcon = new JLabel("");
        interWebIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/interWeb.jpg")));
        interWebIcon.setHorizontalAlignment(SwingConstants.CENTER);
        interWebIcon.setBounds(512, 432, 394, 301);
        frame.getContentPane().add(interWebIcon);
        interWebIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //helpIconLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                interWebIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/interWeb_Hover.jpg")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                interWebIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/interWeb.jpg")));
            }
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    String command1 = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe http://www.gfpac.com/";
                    Process link1 = Runtime.getRuntime().exec(command1);
                } catch (Exception ex) {System.out.println("cannot execute command. " + ex);}
            }
        });
    }

    private void setHelpIcon(){
        helpIcon = new JLabel("");
        helpIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/helpIcon.jpg")));
        helpIcon.setHorizontalAlignment(SwingConstants.CENTER);
        helpIcon.setBounds(965, 432, 394, 301);
        frame.getContentPane().add(helpIcon);
        frame.setVisible(true);
        helpIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                //helpIconLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                helpIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/helpIcon_Hover.jpg")));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                helpIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/helpIcon.jpg")));
            }
        });

    }
}
