package appPackage;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import testingPackage.InsertPanel;
import testingPackage.LineChartSample;
import testingPackage.PieChartSample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.util.Map;
import java.util.TreeMap;

public class MainScreen extends JApplet{

//	private static JFrame frame;

	Connection connection = null;

	private static JFXPanel chartFxPanel;
	private Chart chart;
	private static int BAR_PANEL_WIDTH = 1000;
	private static int BAR_PANEL_HEIGHT = 600;
	private static int PIE_PANEL_HEIGHT = 600;
	private static int PIE_PANEL_WIDTH = 1000;


	/**
	 * Create the Main Application.
	 *
	 */

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
            try {
                MainScreen mainScreen = new MainScreen();
			} catch (Exception e) {e.printStackTrace();}
        });
	}


	public MainScreen() throws URISyntaxException {
		super();
		connection = sqliteConnection.dbConnector();
		init();
//		 UpdateTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@Override
	public void init() {

		// create javafx panel for charts
		//-----------------------------------------------------------------------------------//
		chartFxPanel = new JFXPanel();
		chartFxPanel.setPreferredSize(new Dimension(BAR_PANEL_WIDTH, BAR_PANEL_HEIGHT));
		//-----------------------------------------------------------------------------------//

		JFrame frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/Resources/appIconImage.png")));
		frame.setResizable(false);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		final JFXPanel fxPanel = new JFXPanel();
		springLayout.putConstraint(SpringLayout.NORTH, fxPanel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, fxPanel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, fxPanel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, fxPanel, 0, SpringLayout.WEST, frame.getContentPane());
		fxPanel.setPreferredSize(new Dimension(300,300));
		frame.getContentPane().add(fxPanel);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(244, 244, 244));
		frame.setBackground(Color.WHITE);
		frame.setTitle("GFP Asset Report System");
		frame.setSize(1440, 865);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);




//		Platform.runLater(() -> initFX(fxPanel));



		JLabel Logo_MainScreen = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, Logo_MainScreen, 16, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, Logo_MainScreen, 15, SpringLayout.WEST, frame.getContentPane());
		Logo_MainScreen.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/Logo_Alt_2.jpg")));
		frame.getContentPane().add(Logo_MainScreen);

		JLabel dividerIconLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, dividerIconLabel, 127, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, dividerIconLabel, 274, SpringLayout.WEST, frame.getContentPane());
		dividerIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/Divider.png")));
		frame.getContentPane().add(dividerIconLabel);

		JLabel reportIconLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, reportIconLabel, 127, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, reportIconLabel, 54, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, reportIconLabel, 297, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, reportIconLabel, 228, SpringLayout.WEST, frame.getContentPane());
		reportIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/reportIcon.png")));
		reportIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(reportIconLabel);
		reportIconLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				reportIconLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				reportIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/reportIcon_Hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				reportIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/reportIcon.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					new InsertPanel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});



		JLabel graphIconLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, graphIconLabel, 297, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, graphIconLabel, 54, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, graphIconLabel, 467, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, graphIconLabel, 228, SpringLayout.WEST, frame.getContentPane());
		graphIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/graphIcon.png")));
		graphIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(graphIconLabel);
		graphIconLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				graphIconLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				graphIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/graphIcon_Hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				graphIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/graphIcon.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
//					// create JavaFX scene
					Platform.runLater(() -> createScene());
					JFrame fxFrame = setFrame();
					fxFrame.add(chartFxPanel);
					fxFrame.setVisible(true);

					// BarChart ^^^^ ---- vvvv PieChart

//					// create JavaFX scene
//					Platform.runLater(() -> createPieScene());
//					JFrame fxFrame = setFrame();
//					fxFrame.add(chartFxPanel);
//					fxFrame.setVisible(true);

					//report.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});


		JLabel excelLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, excelLabel, 467, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, excelLabel, 54, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, excelLabel, 637, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, excelLabel, 228, SpringLayout.WEST, frame.getContentPane());
		excelLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/excelIcon.png")));
		excelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(excelLabel);
		excelLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				excelLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				excelLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/excelIcon_Hover.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				excelLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/excelIcon.png")));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {

					//TestMain.intialize
					new LineChartSample();
					//report.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		JLabel helpIconLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, helpIconLabel, 637, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, helpIconLabel, 54, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, helpIconLabel, 807, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, helpIconLabel, 228, SpringLayout.WEST, frame.getContentPane());
		helpIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		helpIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/helpIcon.png")));
		frame.getContentPane().add(helpIconLabel);
		helpIconLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//helpIconLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
				helpIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/helpIcon_Hover.png")));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				helpIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/helpIcon.png")));
			}
		});


		JLabel lblCompanyAssetsAt = new JLabel("Company Assets At A Glance");
		springLayout.putConstraint(SpringLayout.NORTH, lblCompanyAssetsAt, 134, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblCompanyAssetsAt, 454, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblCompanyAssetsAt, 190, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblCompanyAssetsAt, 925, SpringLayout.WEST, frame.getContentPane());
		lblCompanyAssetsAt.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 34));
		lblCompanyAssetsAt.setForeground(new Color(98, 98, 98));
		frame.getContentPane().add(lblCompanyAssetsAt);


		JLabel lblNewLabel = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 272, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 648, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, 683, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 1119, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel);

		JLabel lblATeamSoftware = new JLabel("A Team Software Suite 2016");
		springLayout.putConstraint(SpringLayout.NORTH, lblATeamSoftware, 773, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblATeamSoftware, 1086, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblATeamSoftware, 793, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblATeamSoftware, 1403, SpringLayout.WEST, frame.getContentPane());
		lblATeamSoftware.setHorizontalAlignment(SwingConstants.RIGHT);
		lblATeamSoftware.setForeground(new Color(98, 98, 98));
		lblATeamSoftware.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		frame.getContentPane().add(lblATeamSoftware);
		frame.setVisible(true);

		// JTable Cell Spacing Height
		int gap = 20;

		// Application Icon Image
//		ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));
//		frame.setIconImage(icon.getImage());

		//TODO replace static graph image with dynamic graph from testingPackage

	}


	public JFrame setFrame()
	{
		JFrame fxFrame = new JFrame();
		fxFrame.setVisible(true);
		fxFrame.getContentPane().setBackground(new Color(244, 244, 244));
		fxFrame.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		fxFrame.setTitle("Insert Asset");
		fxFrame.setBounds(100, 100, 1504, 793);
		fxFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fxFrame.setLocationRelativeTo(null);
		fxFrame.getContentPane().setLayout(null);
		fxFrame.getContentPane().setLayout(new SpringLayout());
		fxFrame.setSize(new Dimension(PIE_PANEL_WIDTH, PIE_PANEL_HEIGHT));

//		fxFrame.setSize(new Dimension(BAR_PANEL_WIDTH, BAR_PANEL_HEIGHT));

		ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));
		fxFrame.setIconImage(icon.getImage());
		return fxFrame;
	}


	private void createScene() {
		chart = createBarChart();
		chartFxPanel.setScene(new Scene(chart));
	}

	private BarChart createBarChart() {
		XYChart.Series series = new XYChart.Series();
		TreeMap<String,Double> map = testingPackage.LineChartSample.test_Everything_Total_Spent();
		for(Map.Entry<String,Double> e : map.entrySet())
			series.getData().add(new XYChart.Data(e.getKey(), e.getValue()));

		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("Year");

		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Units Sold");

		final BarChart chart = new BarChart(xAxis, yAxis);
		chart.getData().add(series);

		return chart;
	}

//	private PieChart createPieChart() {
//		TreeMap<String,Double> map = testingPackage.LineChartSample.test_Everything_Total_Spent();
//	}

	private void createPieScene() {
		PieChartSample pc = new PieChartSample();
		chart = new PieChart(pc.getPieChartData());

		chartFxPanel.setScene(new Scene(chart));
	}



}
