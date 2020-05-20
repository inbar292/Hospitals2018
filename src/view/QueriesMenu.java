package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DB.DBconn;
import DB.Doctor;
import DB.Hospital;
import DB.Patient;
import Model.DoctorHandler;
import Model.PatientHandler;
import Model.RoomHandler;

public class QueriesMenu extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JTable table;
	private JScrollPane js;

	/**
	 * Create the panel.
	 */
	public QueriesMenu() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);

		JLabel lblQueries = new JLabel("Queries");
		lblQueries.setForeground(Color.RED);
		lblQueries.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblQueries.setBounds(325, 22, 124, 38);
		add(lblQueries);

		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(220, 71, 508, 407);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		DBconn d = new DBconn();
		try {
			d.initConn();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Query 1 Haifa Doctors");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {	
				table.setModel(new DefaultTableModel( new Object[][] {}, new String[] {"First Name", "Surname"}));

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				DoctorHandler doc = DoctorHandler.getInstance();
				ArrayList<Doctor> lis = doc.q1a();

				Object[] rowdata = new Object[2];
				model.addRow(new String[] { "First Name", "Surname" });

				try {
					for (int i = 0; i < lis.size(); i++) {
						rowdata[0] = lis.get(i).getFirstName();
						rowdata[1] = lis.get(i).getSurName();
						model.addRow(rowdata);
					}
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "There are no Doctors in the system", "Error",JOptionPane.ERROR_MESSAGE);
				}
				js = new JScrollPane(table);
				js.setBounds(254, 71, 474, 407);
				js.setVisible(true);
				add(js);
				}
		});
		
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(43, 83, 171, 23);
		add(rdbtnNewRadioButton);

		JRadioButton rdbtnQuerySevirety = new JRadioButton("Query 2 Sevirety Level 10 or 3 Hospitalizations");
		rdbtnQuerySevirety.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnQuerySevirety);
		rdbtnQuerySevirety.setBounds(43, 118, 171, 23);
		add(rdbtnQuerySevirety);
		
		rdbtnQuerySevirety.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(new DefaultTableModel( new Object[][] {}, new String[] {"ID","First Name", "Surname"}));
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				PatientHandler ph = PatientHandler.getInstance();
				ArrayList<Patient> lis = ph.q1b();
				Object[] rowdata = new Object[3];

				try {
					for (int i = 0; i < lis.size(); i++) {
						rowdata[0] = lis.get(i).getID();
						rowdata[1] = lis.get(i).getFirstName();
						rowdata[2] = lis.get(i).getSurName();
						model.addRow(rowdata);
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "There are no Patients in the system", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				js = new JScrollPane(table);
				js.setBounds(254, 71, 474, 407);
				js.setVisible(true);
				add(js);
				
			}
		});

		JRadioButton rdbtnQuerySurgery = new JRadioButton("Query 3 Surgery Convention");
		rdbtnQuerySurgery.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnQuerySurgery);
		rdbtnQuerySurgery.setBounds(43, 153, 219, 23);
		add(rdbtnQuerySurgery);
		
		rdbtnQuerySurgery.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(new DefaultTableModel( new Object[][] {}, new String[] {"ID","Full Name", "Hospital"}));
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				DoctorHandler dh = DoctorHandler.getInstance();
				ArrayList<Doctor> lis = dh.q2();
				Object[] rowdata = new Object[3];

				try {
					for (int i = 0; i < lis.size(); i++) {
						rowdata[0] = lis.get(i).getID();
						rowdata[1] = lis.get(i).getFirstName() +" " +lis.get(i).getSurName();
						
						for(Hospital h : RoomHandler.getInstance().refreshHospital()) {
							if(h.getHospitalID() == lis.get(i).getHospitalID())
								rowdata[2] = h.getName();
						}
						model.addRow(rowdata);
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "There are no Doctors in the system", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				js = new JScrollPane(table);
				js.setBounds(254, 71, 474, 407);
				js.setVisible(true);
				add(js);
			}
		});

		JRadioButton rdbtnQueryInfected = new JRadioButton("Query 4 Infected");
		rdbtnQueryInfected.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnQueryInfected);
		rdbtnQueryInfected.setBounds(43, 188, 171, 23);
		add(rdbtnQueryInfected);
		
		rdbtnQueryInfected.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				table.setModel(new DefaultTableModel( new Object[][] {}, new String[] {"Hospital Name","Status"}));
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				RoomHandler r = RoomHandler.getInstance();
				ArrayList<String> lis = r.q3();
				Object[] rowdata = new Object[2];

				try {
					String [] s;
					for (int i = 0; i < lis.size(); i++) {
						s= lis.get(i).split(" ");
						if(s.length==3)
							rowdata[0] = s[0] +" "+ s[1];
						else
							rowdata[0] = s[0];
						rowdata[1] = s[s.length-1];
						model.addRow(rowdata);
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "There are no Hospitals in the system", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				js = new JScrollPane(table);
				js.setBounds(254, 71, 474, 407);
				js.setVisible(true);
				add(js);
				
			}
		});

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Query 5 Busy Doctors");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(43, 223, 171, 23);
		add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel( new Object[][] {}, new String[] {"Hospital Name","Doctor ID", "Full Name"}));
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				DoctorHandler d = DoctorHandler.getInstance();
				ArrayList<String> lis = d.q4();
				Object[] rowdata = new Object[3];

				try {
					String [] s;
					
					for (int i = 0; i < lis.size(); i++) {
						s= lis.get(i).split(" ");
						
						if(s.length==5)
							rowdata[0] = s[0] +" "+ s[1];
						else
							rowdata[0] = s[0];
						
						rowdata[1] = s[s.length-3];
						rowdata[2] =  s[s.length-2] + " " + s[s.length-1];
						
						model.addRow(rowdata);
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "There are no Doctors in the system", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				js = new JScrollPane(table);
				js.setBounds(254, 71, 474, 407);
				js.setVisible(true);
				add(js);
				
			}
		});

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Query 6 Vacation Check Up");
		rdbtnNewRadioButton_2.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(43, 258, 219, 23);
		add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel( new Object[][] {}, new String[] {"ID","Full Name", "CheckUp Time", "BP", "Temp"}));
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				DoctorHandler d = DoctorHandler.getInstance();
				ArrayList<String> lis = d.q5();
				if(lis.isEmpty())
					JOptionPane.showMessageDialog(null, "No Missed Check Ups", "Info",JOptionPane.INFORMATION_MESSAGE);
				else {
					Object[] rowdata = new Object[5];
					try {						
						String [] s;
						for (int i = 0; i < lis.size(); i++) {
							s= lis.get(i).split(" ");
							rowdata[0] = s[0];
							rowdata[1] = s[1] + " "+ s[2];
							rowdata[2] = s[3];
							rowdata[3] = s[4];
							rowdata[4] = s[5];
							model.addRow(rowdata);
						}
					} catch (NullPointerException e1) {
						JOptionPane.showMessageDialog(null, "There are no Doctors in the system", "Error",JOptionPane.ERROR_MESSAGE);
					}
					js = new JScrollPane(table);
					js.setBounds(254, 71, 474, 407);
					js.setVisible(true);
					add(js);
				}
			}
		});

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Query 7 2018 Payments");
		rdbtnNewRadioButton_3.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.setBounds(43, 293, 171, 23);
		add(rdbtnNewRadioButton_3);
		
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel( new Object[][] {}, new String[] {"Hospital","Month", "Total Payment"}));
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				RoomHandler r = RoomHandler.getInstance();
				ArrayList<String> lis = r.q6();

				Object[] rowdata = new Object[3];
				try {						
					String [] s;
					for (int i = 0; i < lis.size(); i++) {
						s= lis.get(i).split(" ");
						if(s.length==4)
							rowdata[0] = s[0] + " "+ s[1];
						else
							rowdata[0] = s[0];

						rowdata[1] = s[s.length-2];
						rowdata[2] = s[s.length-1];

						model.addRow(rowdata);
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "There are no Doctors in the system", "Error",JOptionPane.ERROR_MESSAGE);
				}
				js = new JScrollPane(table);
				js.setBounds(254, 71, 474, 407);
				js.setVisible(true);
				add(js);
			}
		});

		JRadioButton rdbtnQueryDepartments = new JRadioButton("Query 8.1 Departments Issue");
		rdbtnQueryDepartments.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnQueryDepartments);
		rdbtnQueryDepartments.setBounds(43, 328, 235, 23);
		add(rdbtnQueryDepartments);
		
		rdbtnQueryDepartments.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel( new Object[][] {}, new String[] {"Hospital Number","Hospital Name",
						"Department Number","Department Name", "Manager Name", "Number of Doctors"}));
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				RoomHandler r = RoomHandler.getInstance();
				ArrayList<String> lis = r.q7a();

				Object[] rowdata = new Object[6];
				try {						
					String [] s;
					for (int i = 0; i < lis.size(); i++) {
						s= lis.get(i).split(" ");

						rowdata[0] =s[0];

						if(s.length==8)
							rowdata[1] = s[1]+" "+s[2];
						else
							rowdata[1] = s[1];
						rowdata[2] = s[s.length-5];
						rowdata[3] = s[s.length-4];
						rowdata[4] = s[s.length-3] + " "+ s[s.length-2];
						rowdata[5] = s[s.length-1];

						model.addRow(rowdata);
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "No Data in the system", "Error",JOptionPane.ERROR_MESSAGE);
				}
				js = new JScrollPane(table);
				js.setBounds(254, 71, 474, 407);
				js.setVisible(true);
				add(js);
				
			}
		});

		JRadioButton rdbtnQueryLowest = new JRadioButton("Query 8.2 Lowest Department");
		rdbtnQueryLowest.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnQueryLowest);
		rdbtnQueryLowest.setBounds(43, 363, 235, 23);
		add(rdbtnQueryLowest);
		
		rdbtnQueryLowest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel( new Object[][] {}, new String[] {"Hospital Number","Hospital Name",
						"Department Number","Department Name", "Manager Name", "Number of Doctors"}));
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				RoomHandler r = RoomHandler.getInstance();
				ArrayList<String> lis = r.q7b();

				Object[] rowdata = new Object[6];
				try {						
					String [] s;
					for (int i = 0; i < lis.size(); i++) {
						s= lis.get(i).split(" ");

						rowdata[0] =s[0];

						if(s.length==8)
							rowdata[1] = s[1]+" "+s[2];
						else
							rowdata[1] = s[1];
						rowdata[2] = s[s.length-5];
						rowdata[3] = s[s.length-4];
						rowdata[4] = s[s.length-3] + " "+ s[s.length-2];
						rowdata[5] = s[s.length-1];

						model.addRow(rowdata);
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "There are no Doctors in the system", "Error",JOptionPane.ERROR_MESSAGE);
				}
				js = new JScrollPane(table);
				js.setBounds(254, 71, 474, 407);
				js.setVisible(true);
				add(js);
			}
		});

		JRadioButton rdbtnQueryRare = new JRadioButton("Query 9 Rare Blood");
		rdbtnQueryRare.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnQueryRare);
		rdbtnQueryRare.setBounds(43, 398, 171, 23);
		add(rdbtnQueryRare);
		
		rdbtnQueryRare.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel( new Object[][] {}, new String[] {"ID","First Name",
						"Surname","DoB", "City", "Street", "Gender", "Phone", "Blood Type", "Care Facility", "Contact ID"}));
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				PatientHandler p = PatientHandler.getInstance();
				ArrayList<Patient> lis = p.q8();

				Object[] rowdata = new Object[11];
				try {						
					
					for (int i = 0; i < lis.size(); i++) {
						
						rowdata[0]=lis.get(i).getID();
						rowdata[1]=lis.get(i).getFirstName();
						rowdata[2]=lis.get(i).getSurName();
						rowdata[3]=lis.get(i).getDateOfBirth().toString();
						rowdata[4]=lis.get(i).getCity();
						rowdata[5]=lis.get(i).getStreet();
						rowdata[6]=lis.get(i).getGender().toString();
						rowdata[7]=lis.get(i).getPhone();
						rowdata[8]=lis.get(i).getBloodtype().toString();
						rowdata[9]=lis.get(i).getCareFacility(); 
						rowdata[10]=lis.get(i).getContactID();
						model.addRow(rowdata);
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "There are no Patients in the system", "Error",JOptionPane.ERROR_MESSAGE);
				}
				js = new JScrollPane(table);
				js.setBounds(254, 71, 474, 407);
				js.setVisible(true);
				add(js);
				
			}
		});

		JRadioButton rdbtnQueryLoad = new JRadioButton("Query 10 Load Of Department");
		rdbtnQueryLoad.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnQueryLoad);
		rdbtnQueryLoad.setBounds(43, 433, 271, 23);
		add(rdbtnQueryLoad);
		
		rdbtnQueryLoad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel( new Object[][] {}, new String[] {"Hospital","Department",
						"Free Beds","Status"}));
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				RoomHandler p = RoomHandler.getInstance();
				ArrayList<String> lis = p.q9();

				Object[] rowdata = new Object[4];
				try {						
					String [] s;
					for (int i = 0; i < lis.size(); i++) {
						s= lis.get(i).split(" ");

						if(s.length==5)
							rowdata[0]=s[0];
						else
							rowdata[0]=s[0]+" "+s[1];
						rowdata[1]=s[s.length-4];
						rowdata[2]=s[s.length-3];
						rowdata[3]=s[s.length-2]+" "+s[s.length-1];
						
						model.addRow(rowdata);
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "There is no Data in the system", "Error",JOptionPane.ERROR_MESSAGE);
				}
				js = new JScrollPane(table);
				js.setBounds(254, 71, 474, 407);
				js.setVisible(true);
				add(js);
				
			}
		});
		
		JRadioButton rdbtnHypochondriac = new JRadioButton("Query 11 Hypochondriac");
		rdbtnHypochondriac.setBackground(Color.WHITE);
		buttonGroup.add(rdbtnHypochondriac);
		rdbtnHypochondriac.setBounds(43, 468, 371, 23);
		add(rdbtnHypochondriac);
		
		rdbtnHypochondriac.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel( new Object[][] {}, new String[] {"ID","First Name","Surname","Phone"}));
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				PatientHandler p = PatientHandler.getInstance();
				
				ArrayList<Patient> lis = new ArrayList<Patient>();
				String inStr = JOptionPane.showInputDialog(null, "Enter Patient ID:",
						"Patient ID", JOptionPane.PLAIN_MESSAGE);
				if(inStr==null) {
					lis = p.q11(null);
				}
				else {
					String patientID=null;
					if(isNumeric(inStr)) {
						for(Patient pat : PatientHandler.getInstance().refreshPatient()) {
							if(pat.getID().equals(inStr))
								patientID=inStr;
						}
					}
					if(patientID==null) 
						JOptionPane.showMessageDialog(null, "The Patient is not in the system", "Error",JOptionPane.ERROR_MESSAGE);
					lis = p.q11(patientID);
				}

				Object[] rowdata = new Object[4];
				try {						
					
					for (int i = 0; i < lis.size(); i++) {
						
						rowdata[0]=lis.get(i).getID();
						rowdata[1]=lis.get(i).getFirstName();
						rowdata[2]=lis.get(i).getSurName();
						rowdata[3]=lis.get(i).getPhone();
						
						model.addRow(rowdata);
					}
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "There are no Patients in the system", "Error",JOptionPane.ERROR_MESSAGE);
				}
				js = new JScrollPane(table);
				js.setBounds(254, 71, 474, 407);
				js.setVisible(true);
				add(js);
				
			}
		});

	}
	
	public static boolean isNumeric(String str)  {  
		  try {  
		    Integer.parseInt(str);  
		  }  
		  catch(NumberFormatException nfe) {  
		    return false;  
		  }  
		  return true;  
		}
}
