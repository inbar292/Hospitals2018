package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import DB.Person;
import Model.PatientHandler;
import Model.PersonHandler;
import utils.E_BloodType;
import utils.E_Gender;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;

public class AddPatientInHospitalization extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField idtext;
	private JTextField city;
	private JTextField fn;
	private JTextField street;
	private JTextField sn;
	private JTextField phone;
	private JTextField contactID;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public AddPatientInHospitalization () {

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
		String[] y = new String[100];
		for (int i = 0; i <= 99; i++) {

			String str = "" + (2018 - i);
			y[i] = str;
		}

		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);

		JLabel lblAddPatient = new JLabel("Add Patient");
		lblAddPatient.setForeground(Color.RED);
		lblAddPatient.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblAddPatient.setBounds(299, 22, 195, 34);
		add(lblAddPatient);

		JLabel label_1 = new JLabel("ID:");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_1.setBounds(112, 91, 32, 25);
		add(label_1);

		JLabel label_2 = new JLabel("City:");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_2.setBounds(315, 96, 50, 21);
		add(label_2);

		idtext = new JTextField();
		idtext.setColumns(10);
		idtext.setBounds(112, 126, 156, 20);
		add(idtext);

		city = new JTextField();
		city.setColumns(10);
		city.setBounds(315, 128, 156, 20);
		add(city);

		JLabel label_3 = new JLabel("First Name:");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_3.setBounds(112, 158, 130, 23);
		add(label_3);

		JLabel label_4 = new JLabel("Street:");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_4.setBounds(315, 159, 75, 20);
		add(label_4);

		fn = new JTextField();
		fn.setColumns(10);
		fn.setBounds(112, 185, 156, 20);
		add(fn);

		street = new JTextField();
		street.setColumns(10);
		street.setBounds(315, 186, 156, 20);
		add(street);

		JLabel label_5 = new JLabel("Surname:");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_5.setBounds(112, 218, 109, 23);
		add(label_5);

		JLabel label_6 = new JLabel("Gender:");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_6.setBounds(315, 218, 65, 23);
		add(label_6);

		sn = new JTextField();
		sn.setColumns(10);
		sn.setBounds(112, 244, 156, 20);
		add(sn);

		JRadioButton radioButton = new JRadioButton("Male");
		buttonGroup.add(radioButton);
		radioButton.setBackground(Color.WHITE);
		radioButton.setBounds(315, 241, 55, 23);
		add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("Female");
		buttonGroup.add(radioButton_1);
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setBounds(374, 241, 65, 23);
		add(radioButton_1);

		JLabel label_7 = new JLabel("Date Of Birth:");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_7.setBounds(112, 285, 156, 23);
		add(label_7);

		JLabel phoneLabel = new JLabel("Phone Number:");
		phoneLabel.setForeground(Color.RED);
		phoneLabel.setFont(new Font("Aharoni", Font.PLAIN, 14));
		phoneLabel.setBounds(315, 281, 109, 30);
		add(phoneLabel);

		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(315, 319, 156, 20);
		add(phone);

		JLabel label_9 = new JLabel("Blood Type:");
		label_9.setForeground(Color.RED);
		label_9.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_9.setBounds(112, 351, 89, 23);
		add(label_9);

		JComboBox<E_BloodType> btcombo = new JComboBox<E_BloodType>();
		btcombo.setModel(new DefaultComboBoxModel<E_BloodType>(E_BloodType.values()));
		btcombo.setBounds(112, 385, 156, 20);
		add(btcombo);

		JLabel label_10 = new JLabel("Care Facility:");
		label_10.setForeground(Color.RED);
		label_10.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_10.setBounds(315, 350, 89, 24);
		add(label_10);

		JComboBox<String> careFacility = new JComboBox<String>();
		careFacility
				.setModel(new DefaultComboBoxModel<String>(new String[] { "Leumit", "Macabi", "Clalit", "Meuhedet" }));
		careFacility.setBounds(315, 385, 156, 20);
		add(careFacility);

		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					changePanel(new Hospitalization());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Aharoni", Font.BOLD, 12));
		button.setBackground(Color.RED);
		button.setBounds(112, 466, 89, 23);
		add(button);

		JLabel label_11 = new JLabel("Contact ID:");
		label_11.setForeground(Color.RED);
		label_11.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_11.setBounds(514, 92, 82, 23);
		add(label_11);

		contactID = new JTextField();
		contactID.setColumns(10);
		contactID.setBounds(514, 126, 156, 20);
		add(contactID);

		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setModel(new DefaultComboBoxModel<String>(s));
		comboBox_3.setBounds(112, 318, 41, 20);
		add(comboBox_3);

		JComboBox<String> comboBox_4 = new JComboBox<String>();
		comboBox_4.setModel(new DefaultComboBoxModel<String>(m));
		comboBox_4.setBounds(163, 318, 37, 21);
		add(comboBox_4);

		JComboBox<String> comboBox_5 = new JComboBox<String>();
		comboBox_5.setModel(new DefaultComboBoxModel<String>(y));
		comboBox_5.setBounds(210, 318, 58, 20);
		add(comboBox_5);

		JButton button_1 = new JButton("Add");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * add patient
				 */
				// checkPerson();
				
				

				E_Gender g = null;
				if (radioButton.isSelected())
					g = E_Gender.M;
				else
					g = E_Gender.F;

				String d1 = comboBox_5.getSelectedItem().toString()+"-"+comboBox_4.getSelectedItem().toString()+
						"-"+comboBox_3.getSelectedItem().toString();
				Date bd = java.sql.Date.valueOf(d1);
			

				E_BloodType bt = E_BloodType.type(btcombo.getSelectedItem().toString());
				
				
				int i=0;
				for(Person p : PersonHandler.getInstance().refreshPerson()) {
					if(Integer.parseInt(p.getID()) == Integer.parseInt(contactID.getText())) {
						if(!isNumeric(phone.getText()))
							JOptionPane.showMessageDialog(null,"Phone number must be disits only\nInsert again","Error",JOptionPane.ERROR_MESSAGE);
						else {

							if(PatientHandler.getInstance().insertPatient(idtext.getText().toString(),
									fn.getText().toString(), sn.getText().toString(), bd, city.getText().toString(),
									street.getText().toString(), g, phone.getText().toString(), bt,
									careFacility.getSelectedItem().toString(), contactID.getText().toString())) {
								JOptionPane.showMessageDialog(null, "Patient Added", "Success", JOptionPane.INFORMATION_MESSAGE);
								changePanel(new AddHospitalization(idtext.getText()));
								
								/*idtext.setText("");
								fn.setText("");
								sn.setText("");
								city.setText("");
								street.setText("");
								phone.setText("");
								contactID.setText("");*/
								
							}

						}
					}
					else {
						i++;
						continue;
					}
				}
				if(PersonHandler.getInstance().refreshPerson().size()==i)
					JOptionPane.showMessageDialog(null,"Contact Person does not Exist in System","Error",JOptionPane.ERROR_MESSAGE);

			}
		});
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_1.setBackground(Color.RED);
		button_1.setBounds(345, 466, 89, 23);
		add(button_1);

	}

	protected void changePanel(JPanel panel) {
		// TODO Auto-generated method stub
	try {	DoctorMainFrame frame= (DoctorMainFrame) SwingUtilities.getWindowAncestor(this);
		frame.changePanel(panel);}
	
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

	
}
