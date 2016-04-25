
package mainPackage;

import javax.swing.*;

import excelPackage.ExcelFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URISyntaxException;


public class MainScreen extends JApplet{

//    private static JFrame frame;

    protected static JFrame frame;
    private InsertPanel insertPane;
    private Infographics infoGraphPane;

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

    /**
    * Create the Main Application.
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
        setFrame();
        setMiscLabels();
        setReportsIcon();
        setInsertIcon();
        setInfoGraphIcon();
        setExcelFuncIcon();
        setInterWebIcon();
        setHelpIcon();
//        UpdateTable();
    }

    private void setFrame() {
        frame = new JFrame();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/Resources/appIconImage.png")));
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(244, 244, 244));
        frame.setBackground(Color.WHITE);
        frame.setTitle("GFP Asset Report System");
        frame.setSize(MAINSCREEN_WIDTH, MAINSCREEN_HEIGHT);
      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
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
                	reportsFrame  ReportFrame = new reportsFrame();
                    ReportFrame.setVisible(true);
                    frame.setVisible(false);
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
                    frame.setVisible(false);
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
//                try {
                    infoGraphPane = new Infographics();
//                } catch (Exception e) {e.printStackTrace();}
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
