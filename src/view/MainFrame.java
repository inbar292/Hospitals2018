package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel changingPanel = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JLabel lblDoctor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public void setCurrentWindow(JPanel panel) {
    	changingPanel = panel;
        
    }
    public JPanel getCurrentWindow() {
    	
        return changingPanel;
    }
    
  

	/**
	 * 
	 * Create the frame.
	 * @throws Exception 
	 */
	public MainFrame() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMain = new JMenu("File");
		menuBar.add(mnMain);

		JMenuItem mntmChangeUser = new JMenuItem("Change User");
		mntmChangeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				     Login l= new Login();
			         l.setVisible(true);
			         l.pack();
			         l.setSize(502, 502);
			         l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			         l.setResizable(false);
			         dispose();
			      
			}
			
		});
		mnMain.add(mntmChangeUser);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int input =  JOptionPane.showConfirmDialog(null, " Are you sure you want to exit?", "Confermation", JOptionPane.YES_NO_OPTION);
			       if(input==1) {
			        //SAVE
			     
			       }
			       if(input==0){
			          dispose();
			         
			       }				
			}
		});
		
		JMenuItem mntmCalendar = new JMenuItem("Calendar");
		mntmCalendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				changePanel(new Calendar());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Home");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					changePanel(new Graphs());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnMain.add(mntmNewMenuItem);
		
		mnMain.add(mntmCalendar);
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnMain.add(mntmExit);

		JMenu mnNewMenu_1 = new JMenu("Window");
		menuBar.add(mnNewMenu_1);

		JMenu mnDoctors = new JMenu("Doctors");
		mnNewMenu_1.add(mnDoctors);

		JMenuItem mntmView_3 = new JMenuItem("View");
		mntmView_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					changePanel(new Doctors());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnDoctors.add(mntmView_3);

		JMenuItem mntmAdd_3 = new JMenuItem("Add");
		mntmAdd_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				changePanel(new AddDoctor());
			}
		});
		mnDoctors.add(mntmAdd_3);

		JMenu mnPatient = new JMenu("Patient");
		mnNewMenu_1.add(mnPatient);

		JMenuItem mntmView_4 = new JMenuItem("View");
		mntmView_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					changePanel(new Patient());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnPatient.add(mntmView_4);

		JMenuItem mntmAdd_4 = new JMenuItem("Add");
		mntmAdd_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(new AddPatient());
			}
		});
		mnPatient.add(mntmAdd_4);

		JMenu mnRooms = new JMenu("Rooms");
		mnNewMenu_1.add(mnRooms);

		JMenuItem mntmView_5 = new JMenuItem("View");
		 mntmView_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changePanel(new Rooms());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnRooms.add(mntmView_5);

		JMenuItem mntmAdd_5 = new JMenuItem("Add");
		mntmAdd_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changePanel(new AddRooms());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnRooms.add(mntmAdd_5);

		JMenu mnShifts = new JMenu("Shifts");
		mnNewMenu_1.add(mnShifts);

		JMenuItem mntmView_6 = new JMenuItem("View");
		mntmView_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changePanel(new Shifts());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnShifts.add(mntmView_6);

		JMenuItem mntmAdd_6 = new JMenuItem("Add");
		 mntmAdd_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						changePanel(new AddShifts());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		
		mnShifts.add(mntmAdd_6);

		JMenu mnHospitalization = new JMenu("Hospitalization");
		mnNewMenu_1.add(mnHospitalization);

		JMenuItem mntmView_7 = new JMenuItem("View");
		 mntmView_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changePanel(new Hospitalization());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnHospitalization.add(mntmView_7);

		JMenuItem mntmAdd_7 = new JMenuItem("Add");
		mntmAdd_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changePanel(new AddHospitalization(""));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnHospitalization.add(mntmAdd_7);

		JMenu mnHspital = new JMenu("Hospital");
		mnNewMenu_1.add(mnHspital);

		JMenu mnDepartment = new JMenu("Department");
		mnHspital.add(mnDepartment);

		JMenu mnRooms_1 = new JMenu("Rooms");
		mnDepartment.add(mnRooms_1);

		JMenuItem mntmView_2 = new JMenuItem("View");
		mntmView_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					changePanel(new Rooms());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnRooms_1.add(mntmView_2);

		JMenuItem mntmAdd_2 = new JMenuItem("Add");
		mntmAdd_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				changePanel(new AddRooms());
			}
		});
		mntmView_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					changePanel(new AddRooms());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnRooms_1.add(mntmAdd_2);

		JMenuItem mntmView_1 = new JMenuItem("View");
		mntmView_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changePanel(new Departmens());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnDepartment.add(mntmView_1);

		JMenuItem mntmAdd_1 = new JMenuItem("Add");
		 mntmAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanel(new AddDepartment());
			}
		});
		mnDepartment.add(mntmAdd_1);

		JMenuItem mntmView = new JMenuItem("View");
		mntmView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					changePanel(new Hospitals());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnHspital.add(mntmView);

		JMenuItem mntmAdd = new JMenuItem("Add");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				changePanel(new AddHospital());
			}
		});
		mnHspital.add(mntmAdd);
		
		JMenu mnCheckups = new JMenu("Checkups");
		mnNewMenu_1.add(mnCheckups);
		
		JMenuItem mntmView_8 = new JMenuItem("View");
		mntmView_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					changePanel(new Checkups());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnCheckups.add(mntmView_8);
		
		JMenu mnProperties = new JMenu("Payment");
		
		 mnProperties.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					try {
						changePanel(new Payments());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		 menuBar.add(mnProperties);
		
		JMenuItem menuItem = new JMenuItem("");
		mnProperties.add(menuItem);
		
		JMenu mnQueries = new JMenu("Queries");
		mnQueries.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				changePanel(new QueriesMenu());
				
			}
		});
		menuBar.add(mnQueries);
		
		JMenu mnAboutUs = new JMenu("About Us");
		mnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				AboutUs about = new AboutUs();
				about.setVisible(true);
				
			}
		});
		mnAboutUs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				AboutUs about = new AboutUs();
				about.setVisible(true);
			}
		});
		menuBar.add(mnAboutUs);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 0, 774, 87);
		panel.add(panel_1);

		lblDoctor = new JLabel("");
		lblDoctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					changePanel(new Doctors());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
		});
		lblDoctor.setToolTipText("doctors");
		lblDoctor.setBounds(20, 22, 50, 50);
		Image img = new ImageIcon(this.getClass().getResource("/icons8-medical-doctor-50.png")).getImage();
		panel_1.setLayout(null);

		lblDoctor.setIcon(new ImageIcon(img));
		panel_1.add(lblDoctor);
		Image img1 = new ImageIcon(this.getClass().getResource("/icons8-cast-50.png")).getImage();

		JLabel lblPatient = new JLabel("");
		lblPatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					changePanel(new Patient());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		lblPatient.setToolTipText("patients");
		lblPatient.setBounds(107, 22, 50, 50);
		panel_1.add(lblPatient);
		lblPatient.setIcon(new ImageIcon(img1));

		Image img4 = new ImageIcon(this.getClass().getResource("/icons8-room-50.png")).getImage();
		JLabel lblRoom = new JLabel("");
		lblRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					changePanel(new Rooms());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblRoom.setToolTipText("rooms");
		lblRoom.setBounds(194, 22, 50, 50);
		panel_1.add(lblRoom);
		lblRoom.setIcon(new ImageIcon(img4));

		Image img5 = new ImageIcon(this.getClass().getResource("/icons8-time-card-50.png")).getImage();
		JLabel lblshifts = new JLabel("");
		lblshifts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					changePanel(new Shifts());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblshifts.setToolTipText("shifts");
		lblshifts.setBounds(281, 22, 50, 50);
		panel_1.add(lblshifts);
		lblshifts.setIcon(new ImageIcon(img5));

		Image img6 = new ImageIcon(this.getClass().getResource("/icons8-ambulance-50.png")).getImage();
		JLabel lblHospitaliztion = new JLabel("");
		lblHospitaliztion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					changePanel(new Hospitalization());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		lblHospitaliztion.setToolTipText("hospitalization");
		lblHospitaliztion.setBounds(368, 22, 50, 50);
		panel_1.add(lblHospitaliztion);
		lblHospitaliztion.setIcon(new ImageIcon(img6));
		
		lblHospitaliztion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try {
					changePanel(new Hospitalization());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		Image img7 = new ImageIcon(this.getClass().getResource("/icons8-documents-50.png")).getImage();
		JLabel lblQueries = new JLabel("");
		lblQueries.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				changePanel(new QueriesMenu());
			}
			
		});
		lblQueries.setToolTipText("queries");
		lblQueries.setBounds(455, 22, 50, 50);
		panel_1.add(lblQueries);
		lblQueries.setIcon(new ImageIcon(img7));

		Image img705 = new ImageIcon(this.getClass().getResource("/icons8-calendar-50.png")).getImage();
		JLabel lblCalendar = new JLabel("");
		lblCalendar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					changePanel(new Calendar());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		
				//changePanel(new DatePicker());
			}
		});
		lblCalendar.setToolTipText("calendar");
		lblCalendar.setBounds(542, 22, 50, 50);
		panel_1.add(lblCalendar);
		lblCalendar.setIcon(new ImageIcon(img705));

		Image img8 = new ImageIcon(this.getClass().getResource("/icons8-about-50.png")).getImage();
		JLabel lblAbout = new JLabel("");
		lblAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				AboutUs about = new AboutUs();
				about.setVisible(true);
			}

		});
		lblAbout.setToolTipText("about us");
		lblAbout.setBounds(629, 22, 50, 50);
		panel_1.add(lblAbout);
		lblAbout.setIcon(new ImageIcon(img8));

		Image img9 = new ImageIcon(this.getClass().getResource("/icons8-exit-50.png")).getImage();
		JLabel lblExit = new JLabel("");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				Component frame = null;
				// Ask for confirmation before terminating the program.
				int option = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close the application?",
						"Close Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}
		});
		lblExit.setToolTipText("exit");
		lblExit.setBounds(714, 22, 50, 50);
		panel_1.add(lblExit);
		lblExit.setIcon(new ImageIcon(img9));

		JSeparator separator = new JSeparator();
		separator.setBounds(87, 0, 10, 87);
		separator.setOrientation(SwingConstants.VERTICAL);
		panel_1.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(174, 0, 10, 87);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		panel_1.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(261, 0, 10, 87);
		panel_1.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(348, 0, 10, 87);
		panel_1.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(435, 0, 10, 87);
		panel_1.add(separator_4);

		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(522, 0, 10, 87);
		panel_1.add(separator_5);

		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(609, 0, 10, 87);
		panel_1.add(separator_6);

		JSeparator separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(696, 0, 10, 87);
		panel_1.add(separator_7);
		
		changingPanel=new Graphs();
		changingPanel.setBounds(0, 88, 774, 540);
		panel.add(changingPanel);
		
	/*	
		JButton btnNewButton = new JButton("graphs");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changePanel(new Graphs());
				
			}
		});
		changingPanel.add(btnNewButton);
		
		*/

	}

	protected void changePanel(JPanel panel) {
		// TODO Auto-generated method stub
		//getContentPane().removeAll();
		changingPanel.removeAll();
	    getContentPane().add(panel);
	    changingPanel.add(panel);
	    invalidate();
	    repaint();
	    getContentPane().setVisible(true);
	    panel_1.setVisible(true);
	    panel.setBounds(0, 0, 774, 540);
	    panel.setVisible(true);
	    changingPanel=panel;
		
	}
}
