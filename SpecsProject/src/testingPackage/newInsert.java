package testingPackage;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

public class newInsert {

	private JFrame frmInsertAsset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					newInsert window = new newInsert();
					window.frmInsertAsset.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public newInsert() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInsertAsset = new JFrame();
		frmInsertAsset.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 12));
		frmInsertAsset.setTitle("Insert Asset");
		frmInsertAsset.setBounds(100, 100, 1439, 928);
		frmInsertAsset.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInsertAsset.setLocationRelativeTo(null);
		frmInsertAsset.getContentPane().setLayout(null);
		SpringLayout springLayout = new SpringLayout();
		frmInsertAsset.getContentPane().setLayout(springLayout);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane_1, 135, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane_1, 602, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane_1, 745, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane_1, 1402, SpringLayout.WEST, frmInsertAsset.getContentPane());
		frmInsertAsset.getContentPane().add(scrollPane_1);
		
		JButton btnInsert = new JButton("Insert");
		springLayout.putConstraint(SpringLayout.NORTH, btnInsert, 778, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnInsert, 15, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnInsert, 838, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnInsert, 195, SpringLayout.WEST, frmInsertAsset.getContentPane());
		btnInsert.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		frmInsertAsset.getContentPane().add(btnInsert);
		
		JButton btnNewButton_1 = new JButton("Clear Fields");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 778, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 369, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 838, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 549, SpringLayout.WEST, frmInsertAsset.getContentPane());
		btnNewButton_1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 22));
		frmInsertAsset.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(125, 90));
		scrollPane.
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 135, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 15, SpringLayout.WEST, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 745, SpringLayout.NORTH, frmInsertAsset.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 556, SpringLayout.WEST, frmInsertAsset.getContentPane());
		frmInsertAsset.getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setBounds(100, 100, 1439, 928);
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("Item Name:");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 48, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 29, SpringLayout.WEST, panel);
		panel.add(lblNewLabel);
		
		JLabel lblItemDescription = new JLabel("Item Description:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblItemDescription, 21, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblItemDescription, 0, SpringLayout.WEST, lblNewLabel);
		lblItemDescription.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		panel.add(lblItemDescription);
		
		JLabel lblCategory = new JLabel("Category:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblCategory, 22, SpringLayout.SOUTH, lblItemDescription);
		sl_panel.putConstraint(SpringLayout.WEST, lblCategory, 0, SpringLayout.WEST, lblNewLabel);
		lblCategory.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		panel.add(lblCategory);
		
		JLabel lblIdTag = new JLabel("ID Tag:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblIdTag, 21, SpringLayout.SOUTH, lblCategory);
		sl_panel.putConstraint(SpringLayout.WEST, lblIdTag, 0, SpringLayout.WEST, lblNewLabel);
		lblIdTag.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		panel.add(lblIdTag);
		
		JLabel lblRoom = new JLabel("Room #:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblRoom, 21, SpringLayout.SOUTH, lblIdTag);
		sl_panel.putConstraint(SpringLayout.WEST, lblRoom, 0, SpringLayout.WEST, lblNewLabel);
		lblRoom.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		panel.add(lblRoom);
		
		JLabel lblFloor = new JLabel("Floor #:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblFloor, 24, SpringLayout.SOUTH, lblRoom);
		sl_panel.putConstraint(SpringLayout.WEST, lblFloor, 0, SpringLayout.WEST, lblNewLabel);
		lblFloor.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		panel.add(lblFloor);
		
		JLabel lblDateAquired = new JLabel("Date Aquired:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblDateAquired, 26, SpringLayout.SOUTH, lblFloor);
		sl_panel.putConstraint(SpringLayout.WEST, lblDateAquired, 0, SpringLayout.WEST, lblNewLabel);
		lblDateAquired.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		panel.add(lblDateAquired);
		
		JLabel lblOwnership = new JLabel("Ownership:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblOwnership, 25, SpringLayout.SOUTH, lblDateAquired);
		sl_panel.putConstraint(SpringLayout.WEST, lblOwnership, 0, SpringLayout.WEST, lblNewLabel);
		lblOwnership.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		panel.add(lblOwnership);
		
		JLabel lblSupplier = new JLabel("Supplier:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblSupplier, 29, SpringLayout.SOUTH, lblOwnership);
		sl_panel.putConstraint(SpringLayout.WEST, lblSupplier, 0, SpringLayout.WEST, lblNewLabel);
		lblSupplier.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		panel.add(lblSupplier);
		
		JLabel lblManufacturer = new JLabel("Manufacturer:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblManufacturer, 28, SpringLayout.SOUTH, lblSupplier);
		sl_panel.putConstraint(SpringLayout.WEST, lblManufacturer, 0, SpringLayout.WEST, lblNewLabel);
		lblManufacturer.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		panel.add(lblManufacturer);
		
		JLabel lblSerial = new JLabel("Serial #:");
		sl_panel.putConstraint(SpringLayout.WEST, lblSerial, 0, SpringLayout.WEST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblSerial, 0, SpringLayout.SOUTH, panel);
		lblSerial.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		panel.add(lblSerial);
	}
}
