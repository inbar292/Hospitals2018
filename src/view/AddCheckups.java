package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import DB.Doctor;
import DB.MedicalEvent;
import Model.CheckUpHandler;
import Model.DoctorHandler;
import Model.HospitalizationHandler;

public class AddCheckups extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField DoctorID;
	private JTextField PatientID;
	private JTextField checkTIME;
	private JTextField bodyTemp;
	private JTextField bloodX;
	private JTextField BloodY;

	/**
	 * Create the panel.
	 */
	public AddCheckups(String patID, String desc, Date date, int numDays) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblAddCheckup = new JLabel("Add Checkup");
		lblAddCheckup.setBounds(281, 22, 211, 34);
		lblAddCheckup.setForeground(Color.RED);
		lblAddCheckup.setFont(new Font("Aharoni", Font.BOLD, 34));
		add(lblAddCheckup);
		
		JLabel lblDoctorId = new JLabel("Doctor ID:");
		lblDoctorId.setForeground(Color.RED);
		lblDoctorId.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblDoctorId.setBounds(89, 75, 67, 25);
		add(lblDoctorId);
		
		DoctorID = new JTextField();
		DoctorID.setColumns(10);
		DoctorID.setBounds(89, 110, 156, 20);
		add(DoctorID);
		
		JLabel lblPatientId = new JLabel("Patient ID:");
		lblPatientId.setForeground(Color.RED);
		lblPatientId.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblPatientId.setBounds(281, 75, 75, 25);
		add(lblPatientId);
		
		PatientID = new JTextField();
		PatientID.setColumns(10);
		PatientID.setBounds(281, 110, 156, 20);
		PatientID.setText(patID);
		PatientID.setEnabled(false);
		add(PatientID);
		
		JLabel lblEventCode = new JLabel("Event Code:");
		lblEventCode.setForeground(Color.RED);
		lblEventCode.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblEventCode.setBounds(281, 154, 89, 23);
		add(lblEventCode);

		JComboBox<String> eventCode = new JComboBox<String>();
		eventCode.setBounds(281, 188, 156, 20);
		eventCode.setModel(new DefaultComboBoxModel<String>(new String[] {desc}));
		eventCode.setEnabled(false);
		add(eventCode);
		
		JLabel lblShiftNumber = new JLabel("Shift Number:");
		lblShiftNumber.setForeground(Color.RED);
		lblShiftNumber.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblShiftNumber.setBounds(89, 154, 99, 23);
		add(lblShiftNumber);
		
		JComboBox<String> shiftNum = new JComboBox<String>();
		shiftNum.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"}));
		shiftNum.setBounds(89, 188, 156, 20);
		add(shiftNum);
		
		JLabel lblCheckUpTime = new JLabel("Day in Hospital:");
		lblCheckUpTime.setForeground(Color.RED);
		lblCheckUpTime.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblCheckUpTime.setBounds(89, 240, 108, 25);
		add(lblCheckUpTime);
		
		checkTIME = new JTextField();
		checkTIME.setColumns(10);
		checkTIME.setBounds(89, 275, 156, 20);
		//add(checkTIME);
		
		JLabel lblBodyTemperature = new JLabel("Body Temperature:");
		lblBodyTemperature.setForeground(Color.RED);
		lblBodyTemperature.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblBodyTemperature.setBounds(477, 75, 130, 25);
		add(lblBodyTemperature);
		
		bodyTemp = new JTextField();
		bodyTemp.setColumns(10);
		bodyTemp.setBounds(477, 110, 156, 20);
		add(bodyTemp);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure:");
		lblBloodPressure.setForeground(Color.RED);
		lblBloodPressure.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblBloodPressure.setBounds(477, 153, 130, 25);
		add(lblBloodPressure);
		
		bloodX = new JTextField();
		bloodX.setColumns(10);
		bloodX.setBounds(477, 188, 67, 20);
		add(bloodX);
		
		BloodY = new JTextField();
		BloodY.setColumns(10);
		BloodY.setBounds(566, 188, 67, 20);
		add(BloodY);
		
		JLabel label = new JLabel("/");
		label.setForeground(Color.RED);
		label.setFont(new Font("Aharoni", Font.PLAIN, 34));
		label.setBounds(550, 184, 16, 25);
		add(label);
		
		
		
		String[] d = new String[numDays];
		for (int i = 0; i < numDays; i++) {
			String str = "" + (i + 1);
			d[i] = str;
		}
		
		JComboBox<Object> combo_days = new JComboBox<Object>();
		combo_days.setModel(new DefaultComboBoxModel<Object>(d));
		combo_days.setBounds(89, 275, 156, 20);
		add(combo_days);		
		
		JButton button = new JButton("Add");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Aharoni", Font.BOLD, 12));
		button.setBackground(Color.RED);
		button.setBounds(342, 466, 89, 23);
		add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Doctor doc = null;
				DoctorHandler dh = DoctorHandler.getInstance();
				for(Doctor d : dh.refreshDoctor()) {
					if(d.getID().equals(DoctorID.getText()))
						doc =d;
				}
				if(doc==null) {
					JOptionPane.showMessageDialog(null,"Doctor's ID not in System","Error",JOptionPane.ERROR_MESSAGE);
					DoctorID.setText("");
				}
				else {
					if(!isDouble(bodyTemp.getText())|| !isNumeric(bloodX.getText()) || !isNumeric(BloodY.getText())){
						JOptionPane.showMessageDialog(null,"Error in Parameters","Error",JOptionPane.ERROR_MESSAGE);
						bodyTemp.setText("");
						bloodX.setText("");
						BloodY.setText("");
					}
					else {
						int code = 0;
						HospitalizationHandler hh = HospitalizationHandler.getInstance();
						ArrayList<MedicalEvent> lisMe = hh.refreshMedicalEvent();
						for(MedicalEvent me : lisMe) {
							if(me.getDiscription().equals(desc))
								code = me.getEventCode();
						}
						
						String dt = date.toString();  // Start date
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Calendar c = Calendar.getInstance();
						try {
							c.setTime(sdf.parse(dt));
						} catch (ParseException e2) {
							e2.printStackTrace();
						}
						c.add(Calendar.DATE, numDays);  // number of days to add
						dt = sdf.format(c.getTime());  // dt is now the new date
						Date checkD = java.sql.Date.valueOf(dt);
						
						if(CheckUpHandler.getInstance().insertCheckUp(patID, code, DoctorID.getText(), shiftNum.getSelectedIndex()+1,
								checkD, Double.parseDouble(bodyTemp.getText()), bloodX.getText()+"/"+BloodY.getText())) {
							JOptionPane.showMessageDialog(null, "Check Up Added", "Success", JOptionPane.INFORMATION_MESSAGE);
							try {
								changePanel(new Hospitalization());
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
							
						else {
							JOptionPane.showMessageDialog(null,"Try Again","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
					
				}
				
			}
		});

		JButton button_1 = new JButton("Back");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_1.setBackground(Color.RED);
		button_1.setBounds(89, 466, 89, 23);
		add(button_1);
		
		button_1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					changePanel(new Hospitalization());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	protected void changePanel(JPanel panel) {
		// TODO Auto-generated method stub
		try {
			DoctorMainFrame frame = (DoctorMainFrame) SwingUtilities.getWindowAncestor(this);
			frame.changePanel(panel);
		}

		catch (ClassCastException e) {
			// TODO: handle exception
			MainFrame topFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
			topFrame.changePanel(panel);
		}

	}
	private static boolean isNumeric(String str)  {  
		try {  
			Integer.parseInt(str);  
		}  
		catch(NumberFormatException nfe) {  
			return false;  
		}  
		return true;  
	}
	private static boolean isDouble(String str)  {  
		try {  
			Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe) {  
			return false;  
		}  
		return true;  
	}
	
}
