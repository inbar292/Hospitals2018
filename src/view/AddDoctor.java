package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;

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

import DB.Department;
import DB.Hospital;
import DB.Person;
import Model.DoctorHandler;
import Model.PersonHandler;
import Model.RoomHandler;
import utils.E_BloodType;
import utils.E_Gender;

public class AddDoctor extends JPanel {
	/**
	 * 
	 */

	private javax.swing.JLabel Imessage;
	private static final long serialVersionUID = 1L;
	private JTextField idTXT;
	private JTextField FNtextField;
	private JTextField SNtxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField citytextField_2;
	private JTextField Street;
	private JTextField phonetextField_4;
	private JTextField ContacttextField_5;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	@SuppressWarnings("unused")
	private JComboBox<String> DepartmentcomboBox_4;
	@SuppressWarnings("unused")
	private JComboBox<String> HospitalcomboBox_3 = new JComboBox<String>();
	private JTextField depID;
	
	/**
	 * Create the panel.
	 */
	public AddDoctor() {

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

		new RoomHandler();
		RoomHandler rh = RoomHandler.getInstance();

		ArrayList<Hospital> hos = rh.refreshHospital();

		String[] h = new String[hos.size() ];
		for (int i = 0; i <= h.length - 1; i++) {

			String str = "" + hos.get(i).getHospitalID();
			h[i] = str;
		}

		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);

		JComboBox<Object> GDDcomboBox_2 = new JComboBox<Object>();
		GDDcomboBox_2.setModel(new DefaultComboBoxModel<Object>(s));
		GDDcomboBox_2.setBounds(510, 126, 41, 20);
		add(GDDcomboBox_2);

		JComboBox<String> GDYcomboBox = new JComboBox<String>();
		GDYcomboBox.setModel(new DefaultComboBoxModel<String>(y));
		GDYcomboBox.setBounds(608, 126, 58, 20);
		add(GDYcomboBox);

		JComboBox<Object> GDMcomboBox_1 = new JComboBox<Object>();
		GDMcomboBox_1.setModel(new DefaultComboBoxModel<Object>(m));
		GDMcomboBox_1.setBounds(561, 126, 37, 21);
		add(GDMcomboBox_1);

		JComboBox<String> DaycomboBox = new JComboBox<String>();

		DaycomboBox.setModel(new DefaultComboBoxModel<String>(s));
		DaycomboBox.setBounds(110, 320, 41, 20);
		add(DaycomboBox);

		JComboBox<Object> MonthcomboBox = new JComboBox<Object>();

		MonthcomboBox.setModel(new DefaultComboBoxModel<Object>(m));
		MonthcomboBox.setBounds(161, 320, 37, 21);
		add(MonthcomboBox);

		JComboBox<Object> yearcomboBox_1 = new JComboBox<Object>();

		yearcomboBox_1.setModel(new DefaultComboBoxModel<Object>(y));
		yearcomboBox_1.setBounds(208, 320, 58, 20);
		add(yearcomboBox_1);

		JComboBox<String> HospitalcomboBox_3 = new JComboBox<String>();
		HospitalcomboBox_3.setModel(new DefaultComboBoxModel<String>(h));
		HospitalcomboBox_3.setBounds(510, 243, 156, 20);
		add(HospitalcomboBox_3);
				
			
		//JComboBox<String> DepartmentcomboBox_4 = new JComboBox<String>();
		//DepartmentcomboBox_4.setModel(new DefaultComboBoxModel<String>(new String[] {"1"}));
		
		//DepartmentcomboBox_4.setBounds(510, 320, 156, 20);
		//add(DepartmentcomboBox_4);
		
		depID = new JTextField();
		depID.setBounds(510, 320, 156, 20);
		add(depID);
		depID.setColumns(10);

		HospitalcomboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JLabel lblAddDoctor = new JLabel("Add Doctor");
		lblAddDoctor.setBounds(297, 22, 181, 34);
		lblAddDoctor.setForeground(Color.RED);
		lblAddDoctor.setFont(new Font("Aharoni", Font.BOLD, 34));
		add(lblAddDoctor);

		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblId.setForeground(Color.RED);
		lblId.setBounds(110, 92, 32, 25);
		add(lblId);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblFirstName.setForeground(Color.RED);
		lblFirstName.setBounds(110, 159, 130, 23);
		add(lblFirstName);

		JLabel lblSurName = new JLabel("Surname:");
		lblSurName.setForeground(Color.RED);
		lblSurName.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblSurName.setBounds(110, 219, 109, 23);
		add(lblSurName);

		JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
		lblDateOfBirth.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblDateOfBirth.setForeground(Color.RED);
		lblDateOfBirth.setBounds(110, 286, 156, 23);
		add(lblDateOfBirth);

		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblCity.setForeground(Color.RED);
		lblCity.setBounds(313, 97, 50, 21);
		add(lblCity);

		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setForeground(Color.RED);
		lblStreet.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblStreet.setBounds(313, 160, 75, 20);
		add(lblStreet);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.RED);
		lblGender.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblGender.setBounds(313, 219, 65, 23);
		add(lblGender);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setForeground(Color.RED);
		lblPhoneNumber.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblPhoneNumber.setBounds(313, 282, 109, 30);
		add(lblPhoneNumber);

		JLabel lblBloodType = new JLabel("Blood Type:");
		lblBloodType.setForeground(Color.RED);
		lblBloodType.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblBloodType.setBounds(110, 352, 89, 23);
		add(lblBloodType);

		JLabel lblCareFacility = new JLabel("Care Facility:");
		lblCareFacility.setForeground(Color.RED);
		lblCareFacility.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblCareFacility.setBounds(313, 351, 89, 24);
		add(lblCareFacility);

		JLabel lblContactId = new JLabel("Contact ID:");
		lblContactId.setForeground(Color.RED);
		lblContactId.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblContactId.setBounds(510, 352, 82, 23);
		add(lblContactId);

		JLabel lblDateOfGraduation = new JLabel("Date Of\r\n\r\n Graduation:");
		lblDateOfGraduation.setForeground(Color.RED);
		lblDateOfGraduation.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblDateOfGraduation.setBounds(510, 98, 186, 23);
		add(lblDateOfGraduation);

		JLabel lblManager = new JLabel("Manager:");
		lblManager.setForeground(Color.RED);
		lblManager.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblManager.setBounds(510, 158, 119, 24);
		add(lblManager);

		JLabel lblHospitalId = new JLabel("Hospital ID:");
		lblHospitalId.setForeground(Color.RED);
		lblHospitalId.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblHospitalId.setBounds(510, 213, 142, 35);
		add(lblHospitalId);

		JLabel lblDepartmentId = new JLabel("Department ID:");
		lblDepartmentId.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblDepartmentId.setForeground(Color.RED);
		lblDepartmentId.setBounds(510, 286, 109, 23);
		add(lblDepartmentId);

		idTXT = new JTextField();
		idTXT.setBounds(110, 127, 156, 20);
		add(idTXT);
		idTXT.setColumns(10);

		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBackground(Color.WHITE);
		rdbtnMale.setBounds(313, 242, 55, 23);
		add(rdbtnMale);

		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBackground(Color.WHITE);
		rdbtnFemale.setBounds(372, 242, 65, 23);
		add(rdbtnFemale);

		FNtextField = new JTextField();
		FNtextField.setColumns(10);
		FNtextField.setBounds(110, 186, 156, 20);
		add(FNtextField);

		SNtxt = new JTextField();
		SNtxt.setColumns(10);
		SNtxt.setBounds(110, 245, 156, 20);
		add(SNtxt);

		citytextField_2 = new JTextField();
		citytextField_2.setColumns(10);
		citytextField_2.setBounds(313, 129, 156, 20);
		add(citytextField_2);

		Street = new JTextField();
		Street.setColumns(10);
		Street.setBounds(313, 187, 156, 20);
		add(Street);

		phonetextField_4 = new JTextField();
		phonetextField_4.setColumns(10);
		phonetextField_4.setBounds(313, 320, 156, 20);
		add(phonetextField_4);

		JComboBox<String> careFacility = new JComboBox<String>();
		careFacility.setModel(new DefaultComboBoxModel<String>(new String[] {"Leumit", "Macabi", "Clatlit", "Meuhedet"}));
		careFacility.setBounds(313, 386, 156, 20);
		add(careFacility);

		JComboBox<E_BloodType> BTcombo = new JComboBox<E_BloodType>();
		BTcombo.setModel(new DefaultComboBoxModel<E_BloodType>(E_BloodType.values()));
		BTcombo.setBounds(110, 386, 156, 20);
		add(BTcombo);

		ContacttextField_5 = new JTextField();
		ContacttextField_5.setColumns(10);
		ContacttextField_5.setBounds(510, 386, 156, 20);
		add(ContacttextField_5);

		JRadioButton rdbtnYes = new JRadioButton("Yes");
		buttonGroup_1.add(rdbtnYes);
		rdbtnYes.setBackground(Color.WHITE);
		rdbtnYes.setBounds(510, 181, 49, 23);
		add(rdbtnYes);

		JRadioButton rdbtnNo = new JRadioButton("No");
		buttonGroup_1.add(rdbtnNo);
		rdbtnNo.setBackground(Color.WHITE);
		rdbtnNo.setBounds(561, 181, 55, 23);
		add(rdbtnNo);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Aharoni", Font.BOLD, 12));
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					changePanel(new Doctors());
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(110, 466, 89, 23);
		add(btnBack);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				checkPerson();
				
				int dID = 0;
				try {
					Integer.parseInt(depID.getText());
					int hospID = Integer.parseInt(HospitalcomboBox_3.getSelectedItem().toString());
					for (Department d : RoomHandler.getInstance().refreshDepartment()) {
						if(d.getHospitalID() == hospID && d.getDepartmentID() == Integer.parseInt(depID.getText())) 
							dID = Integer.parseInt(depID.getText());
					}
				}
				catch (Exception e) {
					depID.setText("");
					e.printStackTrace();
				}
				
				E_Gender g = null;
				if(rdbtnMale.isSelected())
					g = E_Gender.M;
				else
					g = E_Gender.F;
				
				Boolean manager = null;
				if(rdbtnYes.isSelected())
					manager = true;
				else
					manager = false;
				
				
							
				String d1 = yearcomboBox_1.getSelectedItem().toString()+"-"+MonthcomboBox.getSelectedItem().toString()+
						"-"+DaycomboBox.getSelectedItem().toString();
				Date bd = java.sql.Date.valueOf(d1);
	
				String d2 = GDYcomboBox.getSelectedItem().toString()+"-"+GDMcomboBox_1.getSelectedItem().toString()+
						"-"+GDDcomboBox_2.getSelectedItem().toString();
				Date gd = java.sql.Date.valueOf(d2);
				
				E_BloodType bt= E_BloodType.type(BTcombo.getSelectedItem().toString());
				
				int i=0;
				for(Person p : PersonHandler.getInstance().refreshPerson()) {
					if(Integer.parseInt(p.getID()) == Integer.parseInt(ContacttextField_5.getText())) {
						if(bd.after(gd))
							JOptionPane.showMessageDialog(null,"Incorrect dates \nInsert dates again","Error",JOptionPane.ERROR_MESSAGE);
						else {
							if(dID==0)
								JOptionPane.showMessageDialog(null,"Incorrect department number \nInsert again","Error",JOptionPane.ERROR_MESSAGE);
							else 
							{
								if(!isNumeric(phonetextField_4.getText()))
									JOptionPane.showMessageDialog(null,"Phone number must be disits only\nInsert again","Error",JOptionPane.ERROR_MESSAGE);
								else {
									if(DoctorHandler.getInstance().insertDoctor(idTXT.getText(), FNtextField.getText(), SNtxt.getText(), bd,
											citytextField_2.getText(), Street.getText(), g, phonetextField_4.getText(), bt,
											careFacility.getSelectedItem().toString(), ContacttextField_5.getText(), gd, manager,
											Integer.parseInt(HospitalcomboBox_3.getSelectedItem().toString()),
											dID))
										JOptionPane.showMessageDialog(null, "Doctor added", "Success", JOptionPane.INFORMATION_MESSAGE);
								}

								idTXT.setText("");
								FNtextField.setText("");
								SNtxt.setText("");
								citytextField_2.setText("");
								Street.setText("");
								phonetextField_4.setText("");
								ContacttextField_5.setText("");
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
		btnAdd.setFont(new Font("Aharoni", Font.BOLD, 12));
		btnAdd.setBackground(Color.RED);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBounds(343, 466, 89, 23);
		add(btnAdd);

	}

	protected void changePanel(JPanel panel) {
		// TODO Auto-generated method stub

		MainFrame topFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.changePanel(panel);

	}

	protected boolean checkPerson() {

		/*
		 * String iD, String firstName, String surName, Date dateOfBirth, String city,
		 * String street, E_Gender gender, String phone, E_BloodType bloodtype, String
		 * careFacility, String contactID, Date dateOfGraduation, boolean manager, int
		 * hospitalID,int departmentID
		 */

		if (idTXT.getText().equals(null)) {
			Imessage.setText("ID should not be blank");
			return false;
		}
		@SuppressWarnings("unused")
		int numID;
		try {
			numID = Integer.parseInt(idTXT.getText());
			if (idTXT.getText().length() != 9) {
				JOptionPane.showMessageDialog(null,"Please enter a valid ID","Error",JOptionPane.ERROR_MESSAGE);
				idTXT.setText("");
				return false;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Please enter a valid ID","Error",JOptionPane.ERROR_MESSAGE);
			
			idTXT.setText("");
			return false;
		}
		if (FNtextField.getText().length() == 0) {
			Imessage.setText("First name should not be blank");
			return false;
		} else if (SNtxt.getText().equals(null)) {
			Imessage.setText("Last name should not be blank");
			return false;
		} else if (citytextField_2.getText().equals(null)) {
			Imessage.setText("City  should not be blank");
			return false;
		} else if (Street.getText().equals(null)) {
			Imessage.setText("Street should not be blank");
			return false;
		} else if (phonetextField_4.getText().trim().equals(null)) {
			Imessage.setText("Phone Number should not be blank");
			return false;
		} else if (ContacttextField_5.getText().equals(null)) {
			Imessage.setText("Contact ID should not be blank");
			return false;
		}
		@SuppressWarnings("unused")
		int CnumID;
		try {
			CnumID = Integer.parseInt(ContacttextField_5.getText());
			if (ContacttextField_5.getText().length() != 9) {
				JOptionPane.showMessageDialog(null,"Please enter a valid ID","Error",JOptionPane.ERROR_MESSAGE);
				
				ContacttextField_5.setText("");
				return false;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,"Please enter a valid ID","Error",JOptionPane.ERROR_MESSAGE);
			
			ContacttextField_5.setText("");
			return false;
		}
		return true;

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
