package view;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import DB.Doctor;
import Model.DoctorHandler;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AddVacation extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public AddVacation() {
		
		String[] s = new String[31];
		for (int i = 0; i <= 30; i++) {

			String str = "" + (i + 1);
			s[i] = str;
		}
		String[] m = new String[12];
		for (int i = 0; i <= 11; i++) {

			String str = "" + (i + 1);
			m[i] = str;
		}
		String[] y = new String[5];
		for (int i = 0; i <= 4; i++) {

			String str = "" + (2018 + i);
			y[i] = str;
		}
		
		ArrayList<Doctor> doc= DoctorHandler.getInstance().refreshDoctor();
	
		String[] ati= new String[doc.size()];
		
		System.out.println(doc.size());
		System.out.println(ati.length);
		
		for(int i=0; i<=ati.length-1;i++) {
			
			ati[i]=doc.get(i).getID()+ "-"+ doc.get(i).getSurName()+ " "+ doc.get(i).getFirstName();
		}
		
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblAddVacation = new JLabel("Add Vacation");
		lblAddVacation.setForeground(Color.RED);
		lblAddVacation.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblAddVacation.setBounds(292, 50, 217, 47);
		add(lblAddVacation);
		
		JLabel lblDoctorId = new JLabel("Doctor ID:");
		lblDoctorId.setForeground(Color.RED);
		lblDoctorId.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblDoctorId.setBounds(169, 121, 78, 25);
		add(lblDoctorId);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(ati));
		comboBox.setBounds(169, 157, 186, 20);
		add(comboBox);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(Color.RED);
		lblDate.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblDate.setBounds(394, 121, 52, 25);
		add(lblDate);
		
		JButton button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					changePanel(new Calendar());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Aharoni", Font.BOLD, 12));
		button.setBackground(Color.RED);
		button.setBounds(112, 466, 89, 23);
		add(button);
		
		JComboBox<Object> day = new JComboBox<Object>();
		day.setModel(new DefaultComboBoxModel<Object>(s));
		day.setBounds(394, 157, 41, 20);
		add(day);
		
		JComboBox<Object> month = new JComboBox<Object>();
		month.setModel(new DefaultComboBoxModel<Object>(m));
		month.setBounds(445, 157, 37, 21);
		add(month);
		
		JComboBox<String> year = new JComboBox<String>();
		year.setModel(new DefaultComboBoxModel<String>(y));
		year.setBounds(492, 157, 58, 20);
		add(year);
		
		JButton button_1 = new JButton("Add");
		button_1.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent arg0) {
				
				String[] parts =comboBox.getSelectedItem().toString().split("-");
				
			
				
				String d1 = year.getSelectedItem().toString()+"-"+month.getSelectedItem().toString()+
						"-"+day.getSelectedItem().toString();
				Date d = java.sql.Date.valueOf(d1);
			
				// create a java calendar instance
				java.util.Calendar calendar = java.util.Calendar.getInstance();

				// get a java date (java.util.Date) from the Calendar instance.
				// this java date will represent the current date, or "now".
				java.util.Date currentDate = calendar.getTime();

				// now, create a java.sql.Date from the java.util.Date
				java.sql.Date date = new java.sql.Date(currentDate.getTime());
				
				
				System.out.println(date);
				
				if(d.before(date)) {
					
					JOptionPane.showMessageDialog(null,"Incorrect dates \nInsert dates again","Error",JOptionPane.ERROR_MESSAGE);
				}else{
					DoctorHandler.getInstance().addVacation(d, parts[0]);
					JOptionPane.showMessageDialog(null, "Vacation added", "Success", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_1.setBackground(Color.RED);
		button_1.setBounds(342, 466, 89, 23);
		add(button_1);

	}
	
	protected void changePanel(JPanel panel) {
	    
		MainFrame topFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.changePanel(panel);
		
	}
}
