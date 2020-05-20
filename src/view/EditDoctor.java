package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import DB.Doctor;
import DB.Hospital;
import DB.Person;
import Model.DoctorHandler;
import Model.PersonHandler;
import Model.RoomHandler;
import utils.E_BloodType;
import utils.E_Gender;

public class EditDoctor extends JPanel {
	/**
	 * 
	 */

	private Doctor d = null;
	String id = null;
	private static final long serialVersionUID = 1L;
	private JTextField IDField;
	private JTextField citytextField_1;
	private JTextField FNfield;
	private JTextField street;
	private JTextField SNtextField;
	private JTextField phone;
	private JTextField ContacttextField_6;
	@SuppressWarnings("unused")
	private JComboBox<Integer> DOBD;
	@SuppressWarnings("unused")
	private JComboBox<Integer> DOBM;
	@SuppressWarnings("unused")
	private JComboBox<Integer> DOBY;
	@SuppressWarnings("unused")
	private JComboBox<Integer> DOGD;
	@SuppressWarnings("unused")
	private JComboBox<Integer> DOGM;
	@SuppressWarnings("unused")
	private JComboBox<Integer> DOGY;
	@SuppressWarnings("unused")
	private JComboBox<E_BloodType> bloodTypeComboBox_3 = new JComboBox<E_BloodType>();
	private JTextField bloodT;
	private JComboBox<Object> HospitalID;
	@SuppressWarnings("unused")
	private JComboBox<Object> DEpartment;
	private final ButtonGroup Gender = new ButtonGroup();
	private final ButtonGroup MANAGER = new ButtonGroup();
	private JTextField DOB;
	private JTextField DOG;
	//private JRadioButton male = new JRadioButton("Male");
	//private JRadioButton female = new JRadioButton("Female");
	private JComboBox<String> CareFcomboBox_4_1;
	private String[] h;
	private JTextField depID;

	/**
	 * Create the panel.
	 */
	public EditDoctor() {

		new RoomHandler();
		RoomHandler rh = RoomHandler.getInstance();
		ArrayList<Hospital> hos = rh.refreshHospital();

		h = new String[hos.size()+1];
		for (int i = 0; i <= h.length - 2; i++) {
			String str = "" + hos.get(i).getHospitalID();
			h[i] = str;
		}

		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel lblEditDoctor = new JLabel("Edit Doctor");
		lblEditDoctor.setForeground(Color.RED);
		lblEditDoctor.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblEditDoctor.setBounds(302, 22, 173, 34);
		add(lblEditDoctor);

		JLabel label_1 = new JLabel("ID:");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_1.setBounds(120, 109, 32, 25);
		add(label_1);

		JLabel label_2 = new JLabel("First Name:");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_2.setBounds(120, 176, 130, 23);
		add(label_2);

		JLabel label_3 = new JLabel("Surname:");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_3.setBounds(120, 236, 109, 23);
		add(label_3);

		JLabel label_4 = new JLabel("Date Of Birth:");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_4.setBounds(120, 303, 156, 23);
		add(label_4);

		JLabel label_5 = new JLabel("City:");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_5.setBounds(323, 114, 50, 21);
		add(label_5);

		JLabel label_6 = new JLabel("Street:");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_6.setBounds(323, 177, 75, 20);
		add(label_6);

		JLabel label_7 = new JLabel("Gender:");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_7.setBounds(323, 236, 65, 23);
		add(label_7);

		JLabel label_8 = new JLabel("Phone Number:");
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_8.setBounds(323, 299, 109, 30);
		add(label_8);

		JLabel label_9 = new JLabel("Blood Type:");
		label_9.setForeground(Color.RED);
		label_9.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_9.setBounds(120, 369, 89, 23);
		add(label_9);

		JLabel label_10 = new JLabel("Care Facility:");
		label_10.setForeground(Color.RED);
		label_10.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_10.setBounds(323, 368, 89, 24);
		add(label_10);

		JLabel label_11 = new JLabel("Contact ID:");
		label_11.setForeground(Color.RED);
		label_11.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_11.setBounds(520, 369, 82, 23);
		add(label_11);

		JLabel label_12 = new JLabel("Date Of\r\n\r\n Graduation:");
		label_12.setForeground(Color.RED);
		label_12.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_12.setBounds(520, 115, 186, 23);
		add(label_12);

		JLabel label_13 = new JLabel("Manager:");
		label_13.setForeground(Color.RED);
		label_13.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_13.setBounds(520, 175, 119, 24);
		add(label_13);

		JLabel label_14 = new JLabel("Hospital ID:");
		label_14.setForeground(Color.RED);
		label_14.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_14.setBounds(520, 230, 142, 35);
		add(label_14);

		JLabel label_15 = new JLabel("Department ID:");
		label_15.setForeground(Color.RED);
		label_15.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_15.setBounds(520, 303, 109, 23);
		add(label_15);

		CareFcomboBox_4_1 = new JComboBox<String>();
		CareFcomboBox_4_1.setModel(new DefaultComboBoxModel<String>(new String[] { "Leumit", "Macabi", "Clatlit", "Meuhedet" }));
		CareFcomboBox_4_1.setBounds(323, 393, 156, 20);
		add(CareFcomboBox_4_1);

		IDField = new JTextField();
		IDField.setColumns(10);
		IDField.setBounds(120, 141, 156, 20);
		add(IDField);

		citytextField_1 = new JTextField();
		citytextField_1.setColumns(10);
		citytextField_1.setBounds(323, 143, 156, 20);
		add(citytextField_1);

		FNfield = new JTextField();
		FNfield.setColumns(10);
		FNfield.setBounds(120, 200, 156, 20);
		add(FNfield);

		street = new JTextField();
		street.setColumns(10);
		street.setBounds(323, 201, 156, 20);
		add(street);

		SNtextField = new JTextField();
		SNtextField.setColumns(10);
		SNtextField.setBounds(120, 259, 156, 20);
		add(SNtextField);

		JRadioButton male = new JRadioButton("Male");
		Gender.add(male);
		male.setBackground(Color.WHITE);
		male.setBounds(323, 256, 55, 23);
		add(male);

		JRadioButton female = new JRadioButton("Female");
		Gender.add(female);
		female.setBackground(Color.WHITE);
		female.setBounds(382, 256, 65, 23);
		add(female);

		JRadioButton yes = new JRadioButton("Yes");
		MANAGER.add(yes);
		yes.setBackground(Color.WHITE);
		yes.setBounds(520, 195, 49, 23);
		add(yes);

		JRadioButton no = new JRadioButton("No");
		MANAGER.add(no);
		no.setBackground(Color.WHITE);
		no.setBounds(571, 195, 55, 23);
		add(no);

		HospitalID = new JComboBox<Object>();
		HospitalID.setModel(new DefaultComboBoxModel<Object>(h));
		HospitalID.setBounds(520, 257, 156, 20);
		add(HospitalID);

		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(323, 327, 156, 20);
		add(phone);

		//JComboBox<Object> DEpartment = new JComboBox<Object>();
		//DEpartment.setModel(new DefaultComboBoxModel(new String[] { "1" }));
		//DEpartment.setBounds(520, 327, 156, 20);
		//add(DEpartment);
		depID = new JTextField();
		depID.setBounds(520, 327, 156, 20);
		add(depID);
		depID.setColumns(10);

		bloodT = new JTextField();
		bloodT.setBounds(120, 393, 156, 20);
		add(bloodT);
		//JComboBox<E_BloodType> bloodTypeComboBox_3 = new JComboBox<E_BloodType>();
		//bloodTypeComboBox_3.setModel(new DefaultComboBoxModel(E_BloodType.values()));
		//bloodTypeComboBox_3.setBounds(120, 393, 156, 20);
		//add(bloodTypeComboBox_3);

		ContacttextField_6 = new JTextField();
		ContacttextField_6.setColumns(10);
		ContacttextField_6.setBounds(520, 393, 156, 20);
		add(ContacttextField_6);

		JButton btnCancel = new JButton("Back");
		btnCancel.setFont(new Font("Aharoni", Font.BOLD, 12));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					changePanel(new Doctors());
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(120, 483, 89, 23);
		add(btnCancel);

		DOB = new JTextField();
		DOB.setColumns(10);
		DOB.setBounds(120, 327, 156, 20);
		add(DOB);

		DOG = new JTextField();
		DOG.setColumns(10);
		DOG.setBounds(520, 141, 156, 20);
		add(DOG);
		

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				E_Gender g = null;
				if(male.isSelected())
					g = E_Gender.M;
				else
					g = E_Gender.F;
				
				Boolean manager = null;
				if(yes.isSelected())
					manager = true;
				else
					manager = false;
				
				int dID = 0;
				try {
					Integer.parseInt(depID.getText());
					int hospID = Integer.parseInt(HospitalID.getSelectedItem().toString());
					for (Department d : rh.refreshDepartment()) {
						if(d.getHospitalID() == hospID && d.getDepartmentID() == Integer.parseInt(depID.getText())) 
							dID = Integer.parseInt(depID.getText());
					}
				}
				catch (Exception e) {
					depID.setText("");
					e.printStackTrace();
				}

				int i=0;
				for(Person p : PersonHandler.getInstance().refreshPerson()) {
					if(Integer.parseInt(p.getID()) == Integer.parseInt(ContacttextField_6.getText())) {
						if(dID==0)
							JOptionPane.showMessageDialog(null,"Incorrect department number \nInsert again","Error",JOptionPane.ERROR_MESSAGE);
						else 
						{
							if(!isNumeric(phone.getText()))
								JOptionPane.showMessageDialog(null,"Phone number must be disits only\nInsert again","Error",JOptionPane.ERROR_MESSAGE);
							else {
								if(DoctorHandler.getInstance().updateDoctor(d.getID(), FNfield.getText(), SNtextField.getText(),
										d.getDateOfBirth(), citytextField_1.getText(), street.getText(), g, phone.getText(),
										d.getBloodtype(), CareFcomboBox_4_1.getSelectedItem().toString(), ContacttextField_6.getText(),
										d.getDateOfGraduation(), manager, Integer.parseInt(HospitalID.getSelectedItem().toString()),
										dID))
									JOptionPane.showMessageDialog(null, "Doctor Edited", "Success", JOptionPane.INFORMATION_MESSAGE);
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
		btnSave.setFont(new Font("Aharoni", Font.BOLD, 12));
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(Color.RED);
		btnSave.setBounds(342, 483, 89, 23);
		add(btnSave);

	}

	protected void changePanel(JPanel panel) {

		MainFrame topFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.changePanel(panel);

	}

	public void setDoctor(Doctor doc) {
		d = doc;
		System.out.println(d.toString());
	}

	public void upload() {
		
		IDField.setText(d.getID());
		IDField.setEnabled(false);
		FNfield.setText(d.getFirstName());
		SNtextField.setText(d.getSurName());
		/// DOB
		DOB.setText(d.getDateOfBirth().toString());
		DOB.setEnabled(false);
		
		// bloodtype
		bloodT.setText(d.getBloodtype().toString());
		bloodT.setEnabled(false);

		citytextField_1.setText(d.getCity());
		street.setText(d.getStreet());
		phone.setText(d.getPhone().toString());

		// care facility
		/*
		if(d.getCareFacility().equals("Leumit")) CareFcomboBox_4_1.setSelectedIndex(0);
		if(d.getCareFacility().equals("Macabi")) CareFcomboBox_4_1.setSelectedIndex(1);
		if(d.getCareFacility().equals("Clalit")) CareFcomboBox_4_1.setSelectedIndex(2);
		if(d.getCareFacility().equals("Meuhedet")) CareFcomboBox_4_1.setSelectedIndex(3);
*/
		// gender


		// dateOGRad

		DOG.setText(d.getDateOfGraduation().toString());
		DOG.setEnabled(false);
		// manager

		// hospitalID
		
		String s=""+ d.getHospitalID();
		HospitalID.setSelectedItem(s);
		

		// DEPARTMENTID
		String dep = ""+d.getDepartmentID();
		depID.setText(dep);
		
		
		ContacttextField_6.setText(d.getContactID());

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
