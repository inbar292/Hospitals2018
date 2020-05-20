package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import DB.Hospital;
import DB.Hospitalized;
import Model.HospitalizationHandler;
import Model.RoomHandler;

public class AddHospitalization extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_2;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_5;
	private JComboBox<String> comboBox_6;
	private JComboBox<String> comboBox_7;
	private ArrayList<Hospitalized> lis;
	private JButton button_1;
	/**
	 * Create the panel.
	 */
	public AddHospitalization(String id) {
		
		String[] d = new String[31];
		for (int i = 0; i <= 30; i++) {

			String str = "" + (i + 1);
			d[i] = str;
		}
		String[] m = new String[12];
		for (int i = 0; i <= 11; i++) {

			String str = "" + (i + 1);
			m[i] = str;
		}
		String[] y = new String[100];
		for (int i = 0; i <= 99; i++) {

			String str = "" + (2018 - i);
			y[i] = str;
		}
		
		HospitalizationHandler hh = HospitalizationHandler.getInstance();
		String[] code = new String[hh.refreshMedicalEvent().size()];
		
		for (int i = 0; i < hh.refreshMedicalEvent().size(); i++) {
			String c = "" + hh.refreshMedicalEvent().get(i).getDiscription();
			code[i] = c;
		}
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblAddHospitalization = new JLabel("Add Hospitalization");
		lblAddHospitalization.setForeground(Color.RED);
		lblAddHospitalization.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblAddHospitalization.setBounds(229, 22, 316, 34);
		add(lblAddHospitalization);
		
		JLabel lblPatientId = new JLabel("Patient ID:");
		lblPatientId.setForeground(Color.RED);
		lblPatientId.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblPatientId.setBounds(158, 103, 75, 25);
		add(lblPatientId);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(158, 138, 156, 20);
		textField.setText(id);
		textField.setEnabled(false);
		add(textField);
		
		lis= new ArrayList<>();
		
		JButton button = new JButton("Add");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Aharoni", Font.BOLD, 12));
		button.setBackground(Color.RED);
		button.setBounds(342, 466, 89, 23);
		add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int eventC = 0;
				for (int i = 0; i < hh.refreshMedicalEvent().size(); i++) {
					if(comboBox.getSelectedItem().equals(hh.refreshMedicalEvent().get(i).getDiscription()))
						eventC = hh.refreshMedicalEvent().get(i).getEventCode();
				}
				if(!isNumeric(textField_1.getText())) //num days
					JOptionPane.showMessageDialog(null,"Number Is Only Digits\nInsert Again","Error",JOptionPane.ERROR_MESSAGE);
				else {
					int hospID=0;
					for(Hospital h : RoomHandler.getInstance().refreshHospital()) {
						if(h.getName().equals(comboBox_2.getSelectedItem().toString()))
							hospID = h.getHospitalID();
					}
					String d1 = comboBox_7.getSelectedItem().toString()+"-"+comboBox_6.getSelectedItem().toString()+
							"-"+comboBox_5.getSelectedItem().toString();
					Date d = java.sql.Date.valueOf(d1);

					Hospitalized h = new Hospitalized(id, eventC, Integer.parseInt(textField_1.getText()), d, 
							Integer.parseInt(comboBox_1.getSelectedItem().toString()), hospID, 0, 0);
					lis.add(h);
					
					int reply = JOptionPane.showConfirmDialog(null, "More Medical Events?", "?", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						comboBox_7.setEnabled(false);
						comboBox_6.setEnabled(false);
						comboBox_5.setEnabled(false);
						comboBox_2.setEnabled(false);
						textField_1.setText("");
						button_1.setEnabled(false);								
					}
					else {
						try {
							if (HospitalizationHandler.getInstance().insertHospitalization(lis)) {
								JOptionPane.showMessageDialog(null, "Added Hospitalization/s", "Success", JOptionPane.INFORMATION_MESSAGE);
								try {
									changePanel(new Hospitalization());
								} catch (Exception e1) {
									e1.printStackTrace();
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Could not Add Hospitalization", "Error", JOptionPane.ERROR_MESSAGE);
								try {
									changePanel(new Hospitalization());
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
			}
		});
		
		button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changePanel(new Hospitalization());
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_1.setBackground(Color.RED);
		button_1.setBounds(131, 466, 89, 23);
		add(button_1);
		
		JLabel lblEventCode = new JLabel("Event Code:");
		lblEventCode.setForeground(Color.RED);
		lblEventCode.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblEventCode.setBounds(158, 169, 89, 25);
		add(lblEventCode);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(158, 205, 156, 20);
		comboBox.setModel(new DefaultComboBoxModel<String>(code));
		add(comboBox);
		
		JLabel lblNumberOfDays = new JLabel("Number Of Days:");
		lblNumberOfDays.setForeground(Color.RED);
		lblNumberOfDays.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblNumberOfDays.setBounds(158, 250, 121, 25);
		add(lblNumberOfDays);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(158, 286, 156, 20);
		add(textField_1);
		
		JLabel lblDateOfArrival = new JLabel("Date Of Arrival:");
		lblDateOfArrival.setForeground(Color.RED);
		lblDateOfArrival.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblDateOfArrival.setBounds(158, 328, 121, 25);
		add(lblDateOfArrival);
		
		JLabel lblSeverityLevel = new JLabel("Severity Level:");
		lblSeverityLevel.setForeground(Color.RED);
		lblSeverityLevel.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblSeverityLevel.setBounds(337, 103, 99, 25);
		add(lblSeverityLevel);
		
		String[] sev = new String[10];
		for (int i = 0; i <= 9; i++) {

			String str = "" + (i + 1);
			sev[i] = str;
		}
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(337, 138, 156, 20);
		comboBox_1.setModel(new DefaultComboBoxModel<String>(sev));
		add(comboBox_1);
		
		JLabel lblHospitalId = new JLabel("Hospital ID:");
		lblHospitalId.setForeground(Color.RED);
		lblHospitalId.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblHospitalId.setBounds(520, 103, 89, 25);
		add(lblHospitalId);
		
		
		RoomHandler rh = RoomHandler.getInstance();
		ArrayList<Hospital> hos = rh.refreshHospital();
		String[] h = new String[hos.size() ];
		for (int i = 0; i <= h.length - 1; i++) {

			String str = "" + hos.get(i).getName();
			h[i] = str;
		}
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(520, 138, 156, 20);
		comboBox_2.setModel(new DefaultComboBoxModel<String>(h));
		add(comboBox_2);
		
		JLabel lblDepartmentId = new JLabel("Department ID:");
		lblDepartmentId.setForeground(Color.RED);
		lblDepartmentId.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblDepartmentId.setBounds(520, 169, 108, 25);
		add(lblDepartmentId);
		
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3"}));
		comboBox_3.setBounds(520, 205, 156, 20);
		add(comboBox_3);
		
		JComboBox<String> comboBox_4 = new JComboBox<String>();
		comboBox_4.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3"}));
		comboBox_4.setBounds(520, 286, 156, 20);
		add(comboBox_4);
		
		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setForeground(Color.RED);
		lblRoomNumber.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblRoomNumber.setBounds(520, 250, 108, 25);
		add(lblRoomNumber);
		
		comboBox_5 = new JComboBox<String>();
		comboBox_5.setBounds(158, 364, 41, 20);
		comboBox_5.setModel(new DefaultComboBoxModel<String>(d));
		add(comboBox_5);
		
		comboBox_6 = new JComboBox<String>();
		comboBox_6.setBounds(209, 364, 37, 21);
		comboBox_6.setModel(new DefaultComboBoxModel<String>(m));
		add(comboBox_6);
		
		comboBox_7 = new JComboBox<String>();
		comboBox_7.setBounds(256, 364, 58, 20);
		comboBox_7.setModel(new DefaultComboBoxModel<String>(y));
		add(comboBox_7);

	}
	
	protected void changePanel(JPanel panel) {
		MainFrame topFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.changePanel(panel);

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

}
