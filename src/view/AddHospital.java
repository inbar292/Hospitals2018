package view;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class AddHospital extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAuto;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public AddHospital() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblAddHospital = new JLabel("Add a Hospital");
		lblAddHospital.setForeground(Color.RED);
		lblAddHospital.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblAddHospital.setBounds(264, 22, 246, 34);
		add(lblAddHospital);
		
		JButton button = new JButton("Add");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Aharoni", Font.BOLD, 12));
		button.setBackground(Color.RED);
		button.setBounds(342, 466, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					changePanel(new Hospitals());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_1.setBackground(Color.RED);
		button_1.setBounds(141, 466, 89, 23);
		add(button_1);
		
		JLabel lblHospitalId = new JLabel("Hospital ID:");
		lblHospitalId.setForeground(Color.RED);
		lblHospitalId.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblHospitalId.setBounds(141, 101, 78, 25);
		add(lblHospitalId);
		
		txtAuto = new JTextField();
		txtAuto.setEnabled(false);
		txtAuto.setText("Auto");
		txtAuto.setColumns(10);
		txtAuto.setBounds(141, 136, 156, 20);
		add(txtAuto);
		
		JLabel lblHospitalName = new JLabel("Hospital Name:");
		lblHospitalName.setForeground(Color.RED);
		lblHospitalName.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblHospitalName.setBounds(141, 177, 104, 25);
		add(lblHospitalName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(141, 212, 156, 20);
		add(textField);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setForeground(Color.RED);
		lblCity.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblCity.setBounds(328, 101, 104, 25);
		add(lblCity);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(328, 136, 156, 20);
		add(textField_1);
		
		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setForeground(Color.RED);
		lblStreet.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblStreet.setBounds(328, 177, 104, 25);
		add(lblStreet);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(328, 212, 156, 20);
		add(textField_2);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setForeground(Color.RED);
		lblPhoneNumber.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(512, 101, 104, 25);
		add(lblPhoneNumber);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(512, 136, 156, 20);
		add(textField_3);

	}
	
	protected void changePanel(JPanel panel) {
		// TODO Auto-generated method stub

		MainFrame topFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.changePanel(panel);

	}


}
