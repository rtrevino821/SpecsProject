package appPackage;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import testingPackage.InsertPanel;
import testingPackage.LineChartSample;

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

	private static InsertPanel insert;
	private static JFXPanel chartFxPanel;
	private Chart chart;
	private static int btnPanelWidth;
	private static int btnPanelHeight;
	private static int FX_PANEL_WIDTH = 1000;
	private static int FX_PANEL_HEIGHT = 500;
	private static int headerPanelWidth;
	private static int headerPanelHeight;


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
		chartFxPanel.setPreferredSize(new Dimension(FX_PANEL_WIDTH, FX_PANEL_HEIGHT));
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
					// create JavaFX scene
					Platform.runLater(() -> createScene());
					JFrame fxFrame = setFrame();
					fxFrame.add(chartFxPanel);
					fxFrame.setVisible(true);
//					frame.add(chartFxPanel);

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

		JLabel lblHelloSteve = new JLabel("Hello Steve!");
		springLayout.putConstraint(SpringLayout.NORTH, lblHelloSteve, 25, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblHelloSteve, 961, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblHelloSteve, 81, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblHelloSteve, 1361, SpringLayout.WEST, frame.getContentPane());
		lblHelloSteve.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHelloSteve.setForeground(new Color(98, 98, 98));
		lblHelloSteve.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 36));
		frame.getContentPane().add(lblHelloSteve);


		/** OLD PIE CHART TO BE REPLACED **/
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/Resources/pieChart.jpg")));
//		lblNewLabel.setBounds(648, 272, 471, 411);
//		frame.getContentPane().add(lblNewLabel);

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
		fxFrame.setSize(new Dimension(FX_PANEL_WIDTH, FX_PANEL_HEIGHT));

		ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));
		fxFrame.setIconImage(icon.getImage());
		return fxFrame;
	}

	/**
	 * Initialize the contents of the btnPanel.
	 */
//	@Override
	public void initialize(){
		connection = sqliteConnection.dbConnector();

		// create javafx panel for charts
		//-----------------------------------------------------------------------------------//
		chartFxPanel = new JFXPanel();
		chartFxPanel.setPreferredSize(new Dimension(FX_PANEL_WIDTH, FX_PANEL_HEIGHT));
		//-----------------------------------------------------------------------------------//


		JPanel mainPanel = new JPanel();
		mainPanel.setSize(FX_PANEL_WIDTH, FX_PANEL_HEIGHT);
//		mainPanel.setBackground(Color.DARK_GRAY);

		// Button Pane
		JPanel btnPane = new JPanel(new GridLayout(6,0));
		btnPane.setVisible(true);
		btnPane.setBackground(Color.WHITE);
		btnPane.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
//		btnPane.setSize(1440, 865);

		// Button Dimensions
		int btnHeight;
		int btnWidth;
		int btnX = 50;
		int btnY = 200;

		// Button Labels
		JLabel reportIconLabel = new JLabel("");
		JLabel graphIconLabel = new JLabel("");
		JLabel excelLabel = new JLabel("");
		JLabel helpIconLabel = new JLabel("");

		// Other Labels

		JLabel lblATeamSoftware = new JLabel("A Team Software Suite 2016");

		// lay out buttons from top to bottom
//		btnPane.add(Logo_MainScreen);
		btnPane.add(reportIconLabel);
		btnPane.add(graphIconLabel);
		btnPane.add(excelLabel);
		btnPane.add(helpIconLabel);
		btnPane.add(lblATeamSoftware);


		// A-Team label
		lblATeamSoftware.setHorizontalAlignment(SwingConstants.RIGHT);
		lblATeamSoftware.setForeground(new Color(98, 98, 98));
		lblATeamSoftware.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblATeamSoftware.setBounds(btnX, 2*btnY, 317, 20);
		btnPane.setVisible(true);


		// Report button functionality
		reportIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/reportIcon.png")));
		reportIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reportIconLabel.setBounds(btnX, 3*btnY, 174, 170);
//		.setBounds(x,y,width,height);

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
					// TODO: find location of right panel and add new InsertPanel to it
					insert = new InsertPanel();
					JScrollPane insertPanel = new JScrollPane(insert);

					btnPane.add(insertPanel);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});



		// Graph button functionality
		graphIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/graphIcon.png")));
		graphIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		graphIconLabel.setBounds(btnX, 4*btnY, 174, 170);
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
					// create JavaFX scene
					Platform.runLater(() -> createScene());
					//report.setVisible(true);
				} catch (Exception e) {e.printStackTrace();}
			}
		});


		// Excel button functionality
		excelLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/excelIcon.png")));
		excelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		excelLabel.setBounds(btnX, 5*btnY, 174, 170);
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
//					new LineChartSample();
				} catch (Exception e) {e.printStackTrace();}
			}
		});

		// Help button functionality
		helpIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		helpIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/helpIcon.png")));
		helpIconLabel.setBounds(btnX, 637, 174, 170);
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
		// Logo Pane (Company Asset Logo)
		JPanel logoPane = new JPanel();
		JLabel Logo_MainScreen = new JLabel("");
		Logo_MainScreen.setIcon(new ImageIcon(((
				new ImageIcon(MainScreen.class.getResource("/Resources/Logo_Alt_2.jpg"))
						.getImage().getScaledInstance(265,100, Image.SCALE_SMOOTH)))));
		logoPane.add(Logo_MainScreen);

		// Header Pane
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(Color.WHITE);


		// TODO: swap current JFrame implementation for JSplitPane
		// vertical split pane for header and main panels
		JSplitPane vSplitPaneLeft= new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		vSplitPaneLeft.setTopComponent(logoPane);
		vSplitPaneLeft.setBottomComponent(btnPane);
		vSplitPaneLeft.setDividerLocation(100);

		JSplitPane vSplitPaneRight= new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		vSplitPaneRight.setTopComponent(headerPanel);
		vSplitPaneRight.setBottomComponent(mainPanel);
		vSplitPaneRight.setDividerLocation(100);


		// horizontal split pane for button panel and above splitPane
		JSplitPane hSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		hSplitPane.setLeftComponent(vSplitPaneLeft);
		hSplitPane.setRightComponent(vSplitPaneRight);
		hSplitPane.setDividerLocation(265);

		add(hSplitPane,BorderLayout.CENTER);


		JLabel lblCompanyAssetsAt = new JLabel("Company Assets At A Glance");
		lblCompanyAssetsAt.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 34));
		lblCompanyAssetsAt.setForeground(new Color(98, 98, 98));
		lblCompanyAssetsAt.setBounds(454, 134, 471, 56);
		headerPanel.add(lblCompanyAssetsAt, BorderLayout.SOUTH);

		mainPanel.add(chartFxPanel);

		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/Resources/pieChart.jpg")));
		lblNewLabel.setBounds(648, 272, 471, 411);
		btnPane.add(lblNewLabel);



	}
	private void createScene() {
		chart = createBarChart();
		chartFxPanel.setScene(new Scene(chart));
	}

	private BarChart createBarChart() {
		XYChart.Series series = new XYChart.Series();
		TreeMap<String,Double> map = LineChartSample.test_Everything_Total_Spent();
		for(Map.Entry<String,Double> e : map.entrySet()){
			System.out.println("year: "+e.getKey()+", spent: "+e.getValue());
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

}
