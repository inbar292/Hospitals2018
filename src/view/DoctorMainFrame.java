package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DoctorMainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel changingPanel = new JPanel();
	private JPanel panel_1 = new JPanel();
	private JLabel lblDoctor;
	private JPanel panel_2;

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
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public DoctorMainFrame() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMain = new JMenu("File");
		menuBar.add(mnMain);

		JMenuItem mntmChangeUser = new JMenuItem("Change User");
		mntmChangeUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Login l = new Login();
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

				int input = JOptionPane.showConfirmDialog(null, " Are you sure you want to exit?", "Confermation",
						JOptionPane.YES_NO_OPTION);
				if (input == 1) {
					// SAVE

				}
				if (input == 0) {
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

		mnMain.add(mntmCalendar);
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnMain.add(mntmExit);
		
		JMenu mnHome = new JMenu("Home");
		mnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				changePanel(new DoctorMainPanel());
			}
		});
		menuBar.add(mnHome);

		JMenu mnNewMenu_1 = new JMenu("Window");
		menuBar.add(mnNewMenu_1);

		JMenu mnDoctors = new JMenu("Doctors");
		mnDoctors.setEnabled(false);
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
					Patient p= new Patient();
					p.disable();
					
					changePanel(p);
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
		mntmAdd_5.setEnabled(false);
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
		mnShifts.setEnabled(false);
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
		mnShifts.add(mntmAdd_6);

		JMenu mnHospitalization = new JMenu("Hospitalization");
		mnNewMenu_1.add(mnHospitalization);

		JMenuItem mntmView_7 = new JMenuItem("View");
		mntmView_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Hospitalization h= new Hospitalization();
					h.disable();
					changePanel(h);
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
		mnHspital.setEnabled(false);
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
				// changePanel(new Department);
			}
		});
		mnDepartment.add(mntmView_1);

		JMenuItem mntmAdd_1 = new JMenuItem("Add");
		mntmAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// changePanel(new AddDepartment);
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
		
		JMenu mnQueries_1 = new JMenu("Queries");
		mnQueries_1.setEnabled(false);
		mnQueries_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				changePanel(new QueriesMenu());
			}
		});
		menuBar.add(mnQueries_1);

		JMenu mnAboutUs = new JMenu("About Us");
		mnAboutUs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				AboutUs about = new AboutUs();
				about.setVisible(true);
			}
		});
		mnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AboutUs about = new AboutUs();
				about.setVisible(true);

			}
		});
		menuBar.add(mnAboutUs);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		//contentPane.add(panel_2, BorderLayout.NORTH);
		
		JLabel label = new JLabel("Hello Inbar!");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Aharoni", Font.BOLD, 25));
		label.setBounds(82, 44, 146, 34);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Your Vacation request for 01-12-2018 was granted.");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(82, 139, 590, 41);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Please remember to fill your check ups on time and on shift.");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(82, 240, 590, 41);
		panel_2.add(label_2);
		
		JSeparator separator_12 = new JSeparator();
		separator_12.setBackground(Color.RED);
		separator_12.setBounds(82, 81, 574, 2);
		panel_2.add(separator_12);
		
		JSeparator separator_13 = new JSeparator();
		separator_13.setBackground(Color.RED);
		separator_13.setBounds(82, 178, 574, 2);
		panel_2.add(separator_13);
		
		JSeparator separator_14 = new JSeparator();
		separator_14.setBackground(Color.RED);
		separator_14.setBounds(82, 279, 574, 2);
		panel_2.add(separator_14);
		
		JLabel label_3 = new JLabel("It seems you are a very busy doctor.  Please consider to take down at least one shift.");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(82, 337, 590, 41);
		panel_2.add(label_3);
		
		JSeparator separator_15 = new JSeparator();
		separator_15.setBackground(Color.RED);
		separator_15.setBounds(82, 376, 574, 2);
		panel_2.add(separator_15);
		
		doctorShift doctorShift_ = new doctorShift();
		doctorShift_.setBounds(483, 403, 232, 114);
		panel_2.add(doctorShift_);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 0, 774, 87);
		panel.add(panel_1);

		lblDoctor = new JLabel("");
		lblDoctor.setEnabled(false);
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
					
					Patient p= new Patient();
					p.disable();
					changePanel(p);
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
					
					Rooms r= new Rooms();
					r.disable();
					changePanel(r);
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
		lblshifts.setEnabled(false);
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
						Hospitalization h= new Hospitalization();
						h.disable();
					
					changePanel(h);
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
					Hospitalization h=new Hospitalization();
					h.disable();
					
					changePanel(h);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		Image img7 = new ImageIcon(this.getClass().getResource("/icons8-documents-50.png")).getImage();
		JLabel lblQueries = new JLabel("");
		lblQueries.setEnabled(false);
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
					
					Calendar c= new Calendar();
					c.disable();
					changePanel(c);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// changePanel(new DatePicker());
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

		changingPanel = new JPanel();
		changingPanel.setBackground(Color.WHITE);
		changingPanel.setBounds(0, 88, 774, 540);
		panel.add(changingPanel);
		changingPanel.setLayout(null);

		JLabel lblHelloInbar = new JLabel("Hello Inbar!");
		lblHelloInbar.setBounds(82, 44, 146, 34);
		lblHelloInbar.setForeground(Color.BLACK);
		lblHelloInbar.setFont(new Font("Aharoni", Font.BOLD, 25));
		changingPanel.add(lblHelloInbar);
		
		JLabel lblItSeemsThat = new JLabel("Your Vacation request for 01-12-2018 was granted.");
		lblItSeemsThat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblItSeemsThat.setBounds(82, 139, 590, 41);
		changingPanel.add(lblItSeemsThat);
		
		JLabel lblPleaseRememberTo = new JLabel("Please remember to fill your check ups on time and on shift.");
		lblPleaseRememberTo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPleaseRememberTo.setBounds(82, 240, 590, 41);
		changingPanel.add(lblPleaseRememberTo);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBackground(Color.RED);
		separator_8.setBounds(82, 81, 574, 2);
		changingPanel.add(separator_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBackground(Color.RED);
		separator_9.setBounds(82, 178, 574, 2);
		changingPanel.add(separator_9);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBackground(Color.RED);
		separator_10.setBounds(82, 279, 574, 2);
		changingPanel.add(separator_10);
		
		JLabel lblItSeemsYou = new JLabel("It seems you are a very busy doctor.  Please consider to take down at least one shift.");
		lblItSeemsYou.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblItSeemsYou.setBounds(82, 337, 590, 41);
		changingPanel.add(lblItSeemsYou);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBackground(Color.RED);
		separator_11.setBounds(82, 376, 574, 2);
		changingPanel.add(separator_11);

		// create a java calendar instance
		java.util.Calendar calendar = java.util.Calendar.getInstance();

		// get a java date (java.util.Date) from the Calendar instance.
		// this java date will represent the current date, or "now".
		java.util.Date currentDate = calendar.getTime();

		/*
		 * JLabel lblNewLabel = new JLabel("Good Morning");
		 * lblNewLabel.setForeground(Color.RED); lblNewLabel.setFont(new Font("Aharoni",
		 * Font.PLAIN, 15)); lblNewLabel.setBounds(227, 58, 166, 14);
		 * changingPanel.add(lblNewLabel);
		 */

		if (currentDate.getHours() >= 6 && currentDate.getHours() <= 12) {
			JLabel lblNewLabel = new JLabel("Good Morning");
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Aharoni", Font.PLAIN, 15));
			lblNewLabel.setBounds(227, 58, 166, 14);
			changingPanel.add(lblNewLabel);
		}
		if (currentDate.getHours() >= 13 && currentDate.getHours() <= 17) {
			JLabel lblNewLabel = new JLabel("Good Day");
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Aharoni", Font.PLAIN, 15));
			lblNewLabel.setBounds(227, 58, 166, 14);
			changingPanel.add(lblNewLabel);
		}
		if (currentDate.getHours() >= 18 && currentDate.getHours() <= 24) {
			JLabel lblNewLabel = new JLabel("Good Evening");
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Aharoni", Font.PLAIN, 15));
			lblNewLabel.setBounds(227, 58, 166, 14);
			changingPanel.add(lblNewLabel);
		}
		if (currentDate.getHours() >= 1 && currentDate.getHours() <= 5) {
			JLabel lblNewLabel = new JLabel("Good Night");
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Aharoni", Font.PLAIN, 15));
			lblNewLabel.setBounds(227, 58, 166, 14);
			changingPanel.add(lblNewLabel);
		}
		
		doctorShift progress= new doctorShift();
		int hour= currentDate.getHours()-8;
		int shiftLong=12;
		
		
		float x=(float) ((hour*100)/shiftLong);
		
	
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					///precents
					for(int i=1;i<=x;i++) {
						
					// TODO Auto-generated method stub
					try {
						((doctorShift) progress).updateProgress(i);
						progress.repaint();
						Thread.sleep(25);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}
			}).start();	
		progress.setBounds(483, 403, 232, 114);
		changingPanel.add(progress);

	}

	protected void changePanel(JPanel panel) {
		// TODO Auto-generated method stub
		// getContentPane().removeAll();
		changingPanel.removeAll();
		getContentPane().add(panel);
		changingPanel.add(panel);
		invalidate();
		repaint();
		getContentPane().setVisible(true);
		panel_1.setVisible(true);
		panel.setBounds(0, 0, 774, 540);
		panel.setVisible(true);
		changingPanel = panel;

	}
}
