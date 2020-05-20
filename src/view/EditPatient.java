package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import DB.Patient;
import Model.PatientHandler;
import utils.E_BloodType;
import utils.E_Gender;

public class EditPatient extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField IDtextField;
	private JTextField city;
	private JTextField fn;
	private JTextField Street;
	private JTextField sn;
	private JTextField phone;
	private JTextField contact;
	@SuppressWarnings("unused")
	private JComboBox<E_BloodType> bt;
	@SuppressWarnings("unused")
	private JComboBox<String> careF;

	private Patient p;
	private JTextField DOB;
	private final ButtonGroup Gender = new ButtonGroup();
	@SuppressWarnings("unused")
	private JRadioButton male;
	@SuppressWarnings("unused")
	private JRadioButton female;

	/**
	 * Create the panel.
	 */
	public EditPatient() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);

		JRadioButton male = new JRadioButton("Male");
		Gender.add(male);
		male.setBackground(Color.WHITE);
		male.setBounds(316, 244, 55, 23);
		add(male);

		JRadioButton female = new JRadioButton("Female");
		Gender.add(female);
		female.setBackground(Color.WHITE);
		female.setBounds(375, 244, 65, 23);
		add(female);

		JLabel lblEditPatient = new JLabel("Edit Patient");
		lblEditPatient.setForeground(Color.RED);
		lblEditPatient.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblEditPatient.setBounds(297, 22, 183, 34);
		add(lblEditPatient);

		JLabel label_1 = new JLabel("ID:");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_1.setBounds(113, 94, 32, 25);
		add(label_1);

		JLabel label_2 = new JLabel("City:");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_2.setBounds(316, 99, 50, 21);
		add(label_2);

		IDtextField = new JTextField();
		IDtextField.setColumns(10);
		IDtextField.setBounds(113, 129, 156, 20);
		add(IDtextField);

		city = new JTextField();
		city.setColumns(10);
		city.setBounds(316, 131, 156, 20);
		add(city);

		JLabel label_3 = new JLabel("First Name:");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_3.setBounds(113, 161, 130, 23);
		add(label_3);

		JLabel label_4 = new JLabel("Street:");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_4.setBounds(316, 162, 75, 20);
		add(label_4);

		fn = new JTextField();
		fn.setColumns(10);
		fn.setBounds(113, 188, 156, 20);
		add(fn);

		Street = new JTextField();
		Street.setColumns(10);
		Street.setBounds(316, 189, 156, 20);
		add(Street);

		JLabel label_5 = new JLabel("Surname:");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_5.setBounds(113, 221, 109, 23);
		add(label_5);

		JLabel label_6 = new JLabel("Gender:");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_6.setBounds(316, 221, 65, 23);
		add(label_6);

		sn = new JTextField();
		sn.setColumns(10);
		sn.setBounds(113, 247, 156, 20);
		add(sn);

		JLabel label_7 = new JLabel("Date Of Birth:");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_7.setBounds(113, 288, 156, 23);
		add(label_7);

		JLabel label_8 = new JLabel("Phone Number:");
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_8.setBounds(316, 284, 109, 30);
		add(label_8);

		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(316, 322, 156, 20);
		add(phone);

		JLabel label_9 = new JLabel("Blood Type:");
		label_9.setForeground(Color.RED);
		label_9.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_9.setBounds(113, 354, 89, 23);
		add(label_9);

		JComboBox<E_BloodType> bt = new JComboBox<E_BloodType>();
		bt.setModel(new DefaultComboBoxModel<E_BloodType>(E_BloodType.values()));
		bt.setBounds(113, 388, 156, 20);
		add(bt);

		JLabel label_10 = new JLabel("Care Facility:");
		label_10.setForeground(Color.RED);
		label_10.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_10.setBounds(316, 353, 89, 24);
		add(label_10);

		JComboBox<String> careF = new JComboBox<String>();
		careF.setModel(new DefaultComboBoxModel<String>(new String[] { "Leumit", "Macabi", "Clatlit", "Meuhedet" }));
		careF.setBounds(316, 388, 156, 20);
		add(careF);

		JButton btnCancel = new JButton("Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					changePanel(new view.Patient());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Aharoni", Font.BOLD, 12));
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(114, 466, 89, 23);
		add(btnCancel);

		JButton btnS = new JButton("Save");
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				E_Gender g = null;
				String gender = Gender.getSelection().toString();

				if (gender.equals("Male"))
					g = E_Gender.M;
				else
					g = E_Gender.F;

				PatientHandler.getInstance().updatePatient(p.getID(), fn.getText().toString(), sn.getText().toString(), p.getDateOfBirth(),
						city.getText().toString(), Street.getText().toString(), g, phone.getText().toString(), p.getBloodtype(), 
						careF.getSelectedItem().toString(),contact.getText().toString());
				JOptionPane.showMessageDialog(null, "Patient was edited!");
				
				
			}
		});
		btnS.setForeground(Color.WHITE);
		btnS.setFont(new Font("Aharoni", Font.BOLD, 12));
		btnS.setBackground(Color.RED);
		btnS.setBounds(345, 466, 89, 23);
		add(btnS);

		JLabel label_11 = new JLabel("Contact ID:");
		label_11.setForeground(Color.RED);
		label_11.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_11.setBounds(515, 95, 82, 23);
		add(label_11);

		contact = new JTextField();
		contact.setColumns(10);
		contact.setBounds(515, 131, 156, 20);
		add(contact);

		DOB = new JTextField();
		DOB.setColumns(10);
		DOB.setBounds(113, 322, 156, 20);
		add(DOB);

	}

	public void setPatient(Patient pat) {

		p = pat;

		System.out.println(p.toString());
	}

	public void upload() {
		IDtextField.setText(p.getID());
		IDtextField.setEnabled(false);
		fn.setText(p.getFirstName());
		sn.setText(p.getSurName());
		/// DOB
		DOB.setText(p.getDateOfBirth().toString());
		DOB.setEnabled(false);

		// bloodtype
/*
		if (p.getBloodtype().equals(E_BloodType.O))
			bt.setSelectedIndex(0);
		if (p.getBloodtype().equals(E_BloodType.A))
			bt.setSelectedIndex(1);
		if (p.getBloodtype().equals(E_BloodType.B))
			bt.setSelectedIndex(2);
		if (p.getBloodtype().equals(E_BloodType.AB))
			bt.setSelectedIndex(3);
*/
		city.setText(p.getCity());
		Street.setText(p.getStreet());
		phone.setText("0"+p.getPhone().toString());

		// care facility
/*
		if (p.getCareFacility().equals("Leumit"))
			careF.setSelectedIndex(0);
		if (p.getCareFacility().equals("Macabi"))
			careF.setSelectedIndex(1);
		if (p.getCareFacility().equals("Clalit"))
			careF.setSelectedIndex(2);
		if (p.getCareFacility().equals("Meuhedet"))
			careF.setSelectedIndex(3);
*/
		// gender
	/*	if (p.getGender().equals(E_Gender.M)) {
			male.setSelected(true);
		} else {

			female.setSelected(true);
			Gender.setSelected(female.getModel(), true);
		}*/

		contact.setText(p.getContactID());

	}
	
	protected void changePanel(JPanel panel) {
		// TODO Auto-generated method stub
    
		MainFrame topFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.changePanel(panel);
		
	}
}
