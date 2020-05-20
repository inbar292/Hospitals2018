package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import DB.Doctor;
import Model.DoctorHandler;

public class AddShifts extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AddShifts() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblAddAShift = new JLabel("Add Shift");
		lblAddAShift.setForeground(Color.RED);
		lblAddAShift.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblAddAShift.setBounds(310, 22, 153, 34);
		add(lblAddAShift);
		
		JLabel lblShiftNum = new JLabel("Shift Num:");
		lblShiftNum.setForeground(Color.RED);
		lblShiftNum.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblShiftNum.setBounds(209, 101, 104, 25);
		add(lblShiftNum);
		
		JButton button = new JButton("Add");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Aharoni", Font.BOLD, 12));
		button.setBackground(Color.RED);
		button.setBounds(360, 466, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					changePanel(new Shifts());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_1.setBackground(Color.RED);
		button_1.setBounds(110, 466, 89, 23);
		add(button_1);
		
		JLabel lblDoctorId = new JLabel("Doctor ID:");
		lblDoctorId.setForeground(Color.RED);
		lblDoctorId.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblDoctorId.setBounds(392, 101, 104, 25);
		add(lblDoctorId);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"}));
		comboBox.setBounds(209, 137, 153, 20);
		add(comboBox);
		

		ArrayList<Doctor> doc= DoctorHandler.getInstance().refreshDoctor();
	
		String[] ati= new String[doc.size()];
		
		System.out.println(doc.size());
		System.out.println(ati.length);
		
		for(int i=0; i<=ati.length-1;i++) {
			
			ati[i]=doc.get(i).getID()+ "-"+ doc.get(i).getSurName()+ " "+ doc.get(i).getFirstName();
		}
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(ati));
		comboBox_1.setBounds(392, 137, 150, 20);
		add(comboBox_1);

	}
	
	protected void changePanel(JPanel panel) {
		// TODO Auto-generated method stub

		MainFrame topFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.changePanel(panel);

	}
}
