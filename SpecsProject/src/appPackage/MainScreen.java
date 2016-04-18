package appPackage;

import java.awt.Font;
import java.sql.*;
import javax.swing.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;

import testingPackage.LineChartSample;
import testingPackage.InsertPanel;
import testingPackage.reportsFrame;


import java.net.URISyntaxException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import testingPackage.InsertPanel;
import testingPackage.ExcelFrame;
import testingPackage.ExcelFilter;
//------------------------
import javafx.scene.chart.*;
public class MainScreen extends JFrame{
//---------------------------
	private static JFrame frame;

	//****** ADDED
	//private static InsertPanel insert;
	private static JFXPanel chartFxPanel;
	private Chart chart;
	//-------------------------
	
	Connection connection = null;

	/**
	 * Create the Main Application.
	 * 
	 */
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainScreen mainScreen = new MainScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public MainScreen() throws URISyntaxException {
		super();
		connection = sqliteConnection.dbConnector();
		initialize();
		// UpdateTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() throws URISyntaxException {
		frame = new JFrame();
		final JFXPanel fxPanel = new JFXPanel();
		fxPanel.setPreferredSize(new Dimension(300,300));
		frame.add(fxPanel);
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(244, 244, 244));
		frame.setBackground(Color.WHITE);
		frame.setTitle("GFP Asset Report System");
		frame.setSize(1440, 865);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		
		
		
		//Platform.runLater(() -> initFX(fxPanel));
		
		
		
		JLabel Logo_MainScreen = new JLabel("");
		Logo_MainScreen.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/Logo_Alt_2.jpg")));
		Logo_MainScreen.setBounds(15, 16, 300, 65);
		frame.getContentPane().add(Logo_MainScreen);
		
		JLabel dividerIconLabel = new JLabel("");
		dividerIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/Divider.png")));
		dividerIconLabel.setBounds(274, 127, 4, 620);
		frame.getContentPane().add(dividerIconLabel);
		
		JLabel reportIconLabel = new JLabel("");
		reportIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/reportIcon.png")));
		reportIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reportIconLabel.setBounds(54, 127, 174, 170);
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
					//new InsertPanel();
					//new ExcelFrame();
					new reportsFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	
		
		JLabel graphIconLabel = new JLabel("");
		graphIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/graphIcon.png")));
		graphIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		graphIconLabel.setBounds(54, 297, 174, 170);
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
					//new LineChartSample();
					//new reportsFrame();
					new ExcelFrame();
					//report.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		JLabel excelLabel = new JLabel("");
		excelLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/excelIcon.png")));
		excelLabel.setHorizontalAlignment(SwingConstants.CENTER);
		excelLabel.setBounds(54, 467, 174, 170);
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
					ExcelFrame frame = new ExcelFrame();
					frame.setVisible(true);
					
					//report.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		JLabel helpIconLabel = new JLabel("");
		helpIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		helpIconLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/Resources/helpIcon.png")));
		helpIconLabel.setBounds(54, 637, 174, 170);
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
		lblCompanyAssetsAt.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 34));
		lblCompanyAssetsAt.setForeground(new Color(98, 98, 98));
		lblCompanyAssetsAt.setBounds(454, 134, 471, 56);
		frame.getContentPane().add(lblCompanyAssetsAt);
		
//   GREETING MESSAGE AT TOP OF SCREEN		
		
/*		JLabel lblHelloSteve = new JLabel("Hello Steve!");
		lblHelloSteve.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHelloSteve.setForeground(new Color(98, 98, 98));
		lblHelloSteve.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 36));
		lblHelloSteve.setBounds(961, 25, 400, 56);
		frame.getContentPane().add(lblHelloSteve);
*/

		/** OLD PIE CHART TO BE REPLACED **/
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/Resources/pieChart.jpg")));
//		lblNewLabel.setBounds(648, 272, 471, 411);
//		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/Resources/pieChart.jpg")));
		lblNewLabel.setBounds(648, 272, 471, 411);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblATeamSoftware = new JLabel("A Team Software Suite 2016");
		lblATeamSoftware.setHorizontalAlignment(SwingConstants.RIGHT);
		lblATeamSoftware.setForeground(new Color(98, 98, 98));
		lblATeamSoftware.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		lblATeamSoftware.setBounds(1086, 773, 317, 20);
		frame.getContentPane().add(lblATeamSoftware);
		frame.setVisible(true);

		// JTable Cell Spacing Height
		int gap = 20;

		// Application Icon Image
//		ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));
//		frame.setIconImage(icon.getImage());
		
	//TODO replace static graph image with dynamic graph from testingPackage
	
		// Website Button to links to Company Website
				//JLabel webLabel = new JLabel("Hello Steve!");
				ImageIcon websiteButtonBG = new ImageIcon("src/Grant.jpg");  //Grant-Fridkin-Pearson-PA.jpg
				JButton websiteButton = new JButton(websiteButtonBG);
				websiteButton.setOpaque(false);
				websiteButton.setBorderPainted(false);
				websiteButton.setBounds(940, 9, 500, 76);
				websiteButton.setToolTipText("http://www.gfpac.com/");  //http://www.gfpac.com/  //http://www.gfpac.com/
				websiteButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String command1 = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe http://www.gfpac.com/";
							Process link1 = Runtime.getRuntime().exec(command1);
						} catch (Exception ex) {
							System.out.println("cannot execute command. " + ex);
						}
					}
				});
				frame.add(websiteButton);
		
		
		
		
		
	}

	private static void initFX(JFXPanel fxPanel) {
		 // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
	}
	
	private static Scene createScene() {
		Group  root  =  new  Group();
        Scene  scene  =  new  Scene(root, javafx.scene.paint.Color.ALICEBLUE);
        Text  text  =  new  Text();
        
        text.setX(40);
        text.setY(100);
        text.setFont(new javafx.scene.text.Font(25));
        text.setText("Welcome JavaFX!");

        root.getChildren().add(text);

        return (scene);
	}


}
