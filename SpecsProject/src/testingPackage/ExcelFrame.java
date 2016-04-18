//package testingPackage;
//
//import javax.swing.*;
//import javax.swing.GroupLayout.Alignment;
//import javax.swing.LayoutStyle.ComponentPlacement;
//import javax.swing.border.EmptyBorder;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.FocusAdapter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Scanner;
//
//public class ExcelFrame extends JFrame {
//
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ExcelFrame frame = new ExcelFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public ExcelFrame() {
//		setIconImage(Toolkit.getDefaultToolkit().getImage(ExcelFrame.class.getResource("/Resources/appIconImage.png")));
//		setTitle("Excel Options");
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 268, 223);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));
//
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		final JFileChooser fc = new JFileChooser();
//        fc.setFileFilter(new ExcelFilter());
//
//		JButton btnImportExcel = new JButton("Import Excel");
//		btnImportExcel.addFocusListener(new FocusAdapter() {
//			
//		});
//		btnImportExcel.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//
//                //Handle open button action.
//                if (e.getSource() == btnImportExcel) {
//                    int returnVal = fc.showOpenDialog(btnImportExcel);
//
//                    if (returnVal == JFileChooser.APPROVE_OPTION) {
//                        File file = fc.getSelectedFile();
//
//                        //excelFilter.accept(file);
//                        try {
//                            if (ConvertExcel.validateExcel(file)) {
//                                //ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/black-check-mark-md.png"));
//
//                                long startTime = System.currentTimeMillis();
//
//                                ConvertExcel.importExcel(file);
//                                //Logs how long import took
//                                long endTime = System.currentTimeMillis();
//                                long totalTime = endTime - startTime;
//                                SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
//                                Date resultdate = new Date(totalTime);
//                                System.out.println(sdf.format(resultdate));
//                                System.out.println("SUCCESS");
//                                JOptionPane.showMessageDialog(contentPane,
//                                        "Successfully added excel file to database."
//                                                + "\nTime: " + sdf.format(resultdate),
//                                        "Loading",
//                                        JOptionPane.INFORMATION_MESSAGE
//                                );
//
//                            } else {
//                                //custom title, warning icon
//                                JOptionPane.showMessageDialog(contentPane,
//                                        "XLS. File does not meet requied standard.",
//                                        "ERROR",
//                                        JOptionPane.ERROR_MESSAGE);
//                            }
//
//                        } catch (SQLException e1) {
//                            if (e1.toString().contains(" [SQLITE_BUSY]  The database file is locked "
//                                    + "(database is locked)")) {//Occurs when connection is not closed
//                                JOptionPane.showMessageDialog(contentPane,
//                                        "CLOSE All SQLITE APPLICATIONS",
//                                        "ERROR",
//                                        JOptionPane.ERROR_MESSAGE);
//                            } else if (e1.toString().contains("[SQLITE_CONSTRAINT]  Abort due to constraint violation")) {
//                                Scanner input = null;
//                                String line;
//                                try {
//                                    input = new Scanner(new File("Log.txt"));
//                                } catch (FileNotFoundException e2) {
//                                    e2.printStackTrace();
//                                }
//
//                                line = input.nextLine();
//                                JOptionPane.showMessageDialog(contentPane,
//                                        "Duplicates Entry found in .XLS \n"
//                                                + line
//                                        ,
//                                        "ERROR",
//                                        JOptionPane.ERROR_MESSAGE);
//
//                            }
//                            try {
//                                if (ConvertExcel.validateExcel(file)) {
//                                    ConvertExcel.importExcel(file);
//                                    //This is where a real application would open the file.
//                                    System.out.println(("Opening: " + file.getName() + "."));
//                                } else {
//                                    System.out.println(("Open command cancelled by user."));
//                                }
//                            } catch (SQLException e2) {
//                                e2.printStackTrace();
//                            }
//                        }
//                    }
//
//
//                    JButton btnExportExcel = new JButton("Export Excel");
//                    btnExportExcel.addActionListener(new ActionListener() {
//                        public void actionPerformed(ActionEvent e) {
//                            try {
//                                ConvertExcel.writeExcel(false);
//                            } catch (IOException e1) {
//                                e1.printStackTrace();
//                            }
//                        }
//                    });
//
//                    JButton btnTemplate = new JButton("Excel Template");
//                    btnTemplate.addActionListener(new ActionListener() {
//                        public void actionPerformed(ActionEvent arg0) {
//                            try {
//                                ConvertExcel.writeExcel(true);
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//
//                        }
//                    });
//                    GroupLayout gl_contentPane = new GroupLayout(contentPane);
//                    gl_contentPane.setHorizontalGroup(
//                            gl_contentPane.createParallelGroup(Alignment.LEADING)
//                                    .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
//                                            .addContainerGap(44, Short.MAX_VALUE)
//                                            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
//                                                    .addComponent(btnExportExcel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
//                                                    .addComponent(btnImportExcel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
//                                                    .addComponent(btnTemplate, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
//                                            .addGap(40))
//                                    .addComponent(btnImportExcel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
//                                    .addGap(130));
//                    gl_contentPane.setVerticalGroup(
//                            gl_contentPane.createParallelGroup(Alignment.LEADING)
//                                    .addGroup(gl_contentPane.createSequentialGroup()
//                                            .addComponent(btnTemplate, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
//                                            .addPreferredGap(ComponentPlacement.RELATED)
//                                            .addComponent(btnImportExcel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
//                                            .addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
//                                            .addComponent(btnExportExcel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
//                                    .addGap(99)
//                                    .addComponent(btnImportExcel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE));
//                    contentPane.setLayout(gl_contentPane);
//                }
//            }
//
//});}}

package testingPackage;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExcelFrame extends JFrame {

<<<<<<< HEAD
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExcelFrame frame = new ExcelFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExcelFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ExcelFrame.class.getResource("/Resources/appIconImage.png")));
		setTitle("Excel Options");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 268, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));

		final JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new ExcelFilter());

		JButton btnImportExcel = new JButton("Import Excel");
		btnImportExcel.setToolTipText("Inserts Excel files to database.");
		btnImportExcel.addFocusListener(new FocusAdapter() {

		});
		btnImportExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Handle open button action.
				if (e.getSource() == btnImportExcel) {
					int returnVal = fc.showOpenDialog(btnImportExcel);
					Connection conn = sqliteConnectionTEST.dbConnector();
					//disable auto commit
					try {
						conn.setAutoCommit(false);
					} catch (SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					//create a sv point incase sql exception
					Savepoint sv = null;
					try {
						sv = conn.setSavepoint("sv");
					} catch (SQLException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();

						//excelFilter.accept(file);
						try {
							if(ConvertExcel.validateExcel(file)){
								//ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/black-check-mark-md.png"));

								long startTime = System.currentTimeMillis();

								ConvertExcel.importExcel(file);
								//Logs how long import took
								long endTime   = System.currentTimeMillis();
								long totalTime = endTime - startTime;
								SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");    
								Date resultdate = new Date(totalTime);
								System.out.println(sdf.format(resultdate));
								System.out.println("Successfully imported");
								JOptionPane.showMessageDialog(contentPane,
										"Successfully imported " + file.getName() +" to database."
												+"\nTime: " + sdf.format(resultdate) ,
												"Import",
												JOptionPane.INFORMATION_MESSAGE
										);	
							}
							else{//The excel imported does not match format
								//custom title, warning icon
								Scanner input = null;
								String line;
								StringBuilder sb = new StringBuilder();
								try {
									input = new Scanner(new File("LogC.txt"));
								} catch (FileNotFoundException e2) {
									e2.printStackTrace();
								}
								sb.append("\n");

								while((input.hasNext()))
								{
									line = input.nextLine();
									sb.append(line + ",");
									sb.append("\n");

								}
								String temp = sb.toString();
								String output = null;

								if(temp.substring(temp.length()-2).contains(","))
								{
									output = temp.substring(0, temp.length()-2);
								}
								//System.out.println(output.substring(output.length()-1).contains(","));
								JOptionPane.showMessageDialog(contentPane,
										file.getName() +" is missing columns: "
												+ output,
												"ERROR",
												JOptionPane.ERROR_MESSAGE);	
							}

						} catch (SQLException e1) {
							if(e1.toString().contains(" [SQLITE_BUSY]  The database file is locked "
									+ "(database is locked)"))
							{//Occurs when connection is not closed
								JOptionPane.showMessageDialog(contentPane,
										"CLOSE All SQLITE APPLICATIONS, and try again",
										"ERROR",
										JOptionPane.ERROR_MESSAGE);
							}
							else if(e1.toString().contains("[SQLITE_CONSTRAINT]  Abort due to constraint violation"))
							{
								try {
									//rollback the changes because of constraint
									conn.rollback(sv);;
									conn.rollback();
									//conn.commit();
									try {
										conn.close();
									} catch (SQLException e2) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								} catch (SQLException e3) {
									// TODO Auto-generated catch block
									e3.printStackTrace();
								}
								Scanner input = null;
								String line;
								try {
									input = new Scanner(new File("Log.txt"));
								} catch (FileNotFoundException e2) {
									e2.printStackTrace();
								}

								line = input.nextLine();
								JOptionPane.showMessageDialog(contentPane,
										file.getName() +" was not imported\n"
												+"Duplicates Entry found in: "
												+ line +"\nFix duplicate and reimport file."
												,
												"ERROR",
												JOptionPane.ERROR_MESSAGE);	

							}
							e1.printStackTrace();

						}
						try {
							conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						//This is where a real application would open the file.
						//System.out.println(("Opening: " + file.getName() + "."));
					} else {
						//System.out.println(("Open command cancelled by user."));
					}
				}
			}

		});

		JButton btnExportExcel = new JButton("Export Excel");
		btnExportExcel.setToolTipText("Exports all data from database into an excel file.");
		btnExportExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConvertExcel.writeExcel(false);
				} catch (IOException e1) {e1.printStackTrace();}
			}
		});

		JButton button = new JButton("Excel Template");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					ConvertExcel.writeExcel(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setToolTipText("Opens a template in Excel to import file.");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap(44, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnExportExcel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnImportExcel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
						.addGap(40))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnImportExcel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnExportExcel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
				);
		contentPane.setLayout(gl_contentPane);






	}
}
=======
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ExcelFrame frame = new ExcelFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ExcelFrame() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(ExcelFrame.class.getResource("/Resources/appIconImage.png")));
        setTitle("Excel Options");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 268, 223);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/appIconImage.png"));

        final JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new ExcelFilter());

        JButton btnImportExcel = new JButton("Import Excel");
        btnImportExcel.setToolTipText("Inserts Excel files to database.");
        btnImportExcel.addFocusListener(new FocusAdapter() {

        });
        btnImportExcel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //Handle open button action.
                if (e.getSource() == btnImportExcel) {
                    int returnVal = fc.showOpenDialog(btnImportExcel);
                    Connection conn = sqliteConnectionTEST.dbConnector();
                    //disable auto commit
                    try {
                        conn.setAutoCommit(false);
                    } catch (SQLException e3) {
                        // TODO Auto-generated catch block
                        e3.printStackTrace();
                    }
                    //create a sv point incase sql exception
                    Savepoint sv = null;
                    try {
                        sv = conn.setSavepoint("sv");
                    } catch (SQLException e4) {
                        // TODO Auto-generated catch block
                        e4.printStackTrace();
                    }
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File file = fc.getSelectedFile();

                        //excelFilter.accept(file);
                        try {
                            if(ConvertExcel.validateExcel(file)){
                                //ImageIcon icon = new ImageIcon(getClass().getResource("/Resources/black-check-mark-md.png"));

                                long startTime = System.currentTimeMillis();

                                ConvertExcel.importExcel(file);
                                //Logs how long import took
                                long endTime   = System.currentTimeMillis();
                                long totalTime = endTime - startTime;
                                SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");    
                                Date resultdate = new Date(totalTime);
                                System.out.println(sdf.format(resultdate));
                                System.out.println("Successfully imported");
                                JOptionPane.showMessageDialog(contentPane,
                                        "Successfully imported " + file.getName() +" to database."
                                                +"\nTime: " + sdf.format(resultdate) ,
                                                "Import",
                                                JOptionPane.INFORMATION_MESSAGE
                                        );    
                            }
                            else{//The excel imported does not match format
                                //custom title, warning icon
                                Scanner input = null;
                                String line;
                                StringBuilder sb = new StringBuilder();
                                try {
                                    input = new Scanner(new File("LogC.txt"));
                                } catch (FileNotFoundException e2) {
                                    e2.printStackTrace();
                                }
                                sb.append("\n");

                                while((input.hasNext()))
                                {
                                    line = input.nextLine();
                                    sb.append(line + ",");
                                    sb.append("\n");

                                }
                                String temp = sb.toString();
                                String output = null;

                                if(temp.substring(temp.length()-2).contains(","))
                                {
                                    output = temp.substring(0, temp.length()-2);
                                }
                                //System.out.println(output.substring(output.length()-1).contains(","));
                                JOptionPane.showMessageDialog(contentPane,
                                        file.getName() +" is missing columns: "
                                                + output,
                                                "ERROR",
                                                JOptionPane.ERROR_MESSAGE);    
                            }

                        } catch (SQLException e1) {
                            if(e1.toString().contains(" [SQLITE_BUSY]  The database file is locked "
                                    + "(database is locked)"))
                            {//Occurs when connection is not closed
                                JOptionPane.showMessageDialog(contentPane,
                                        "CLOSE All SQLITE APPLICATIONS, and try again",
                                        "ERROR",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                            else if(e1.toString().contains("[SQLITE_CONSTRAINT]  Abort due to constraint violation"))
                            {
                                try {
                                    //rollback the changes because of constraint
                                    conn.rollback(sv);;
                                    conn.rollback();
                                    //conn.commit();
                                    try {
                                        conn.close();
                                    } catch (SQLException e2) {
                                        // TODO Auto-generated catch block
                                        e1.printStackTrace();
                                    }
                                } catch (SQLException e3) {
                                    // TODO Auto-generated catch block
                                    e3.printStackTrace();
                                }
                                Scanner input = null;
                                String line;
                                try {
                                    input = new Scanner(new File("Log.txt"));
                                } catch (FileNotFoundException e2) {
                                    e2.printStackTrace();
                                }

                                line = input.nextLine();
                                JOptionPane.showMessageDialog(contentPane,
                                        file.getName() +" was not imported\n"
                                                +"Duplicates Entry found in: "
                                                + line +"\nFix duplicate and reimport file."
                                                ,
                                                "ERROR",
                                                JOptionPane.ERROR_MESSAGE);    

                            }
                            e1.printStackTrace();

                        }
                        try {
                            conn.close();
                        } catch (SQLException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }

                        //This is where a real application would open the file.
                        //System.out.println(("Opening: " + file.getName() + "."));
                    } else {
                        //System.out.println(("Open command cancelled by user."));
                    }
                }
            }

        });

        JButton btnExportExcel = new JButton("Export Excel");
        btnExportExcel.setToolTipText("Exports all data from database into an excel file.");
        btnExportExcel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ConvertExcel.writeExcel(false);
                } catch (IOException e1) {e1.printStackTrace();}
            }
        });

        JButton button = new JButton("Excel Template");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
                try {
                    ConvertExcel.writeExcel(true);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        button.setToolTipText("Opens a template in Excel to import file.");
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addContainerGap(44, Short.MAX_VALUE)
                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                .addComponent(btnExportExcel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnImportExcel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
                        .addGap(40))
                );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnImportExcel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(btnExportExcel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(button, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
                );
        contentPane.setLayout(gl_contentPane);






    }
}
>>>>>>> refs/remotes/origin/master
