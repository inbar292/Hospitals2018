package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DB.DBconn;
import DB.Department;
import DB.Hospital;
import DB.Hospitalized;
import DB.MedicalEvent;
import DB.Patient;
import DB.Person;
import Model.HospitalizationHandler;
import Model.PatientHandler;
import Model.PersonHandler;
import Model.RoomHandler;

public class Hospitalization extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton home;

	/**
	 * Create the panel.
	 * 
	 * @throws Exception
	 */
	public Hospitalization() throws Exception {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		table.setBounds(51, 104, 670, 333);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Full Name", "Description",
				"Days in Hospital", "Arrival", "Severity Level", "Hospital Name", "Department Name", "Room Number" }));

		DBconn d = new DBconn();
		d.initConn();

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		HospitalizationHandler hh = HospitalizationHandler.getInstance();
		ArrayList<Hospitalized> lis = hh.refreshHospitalizations();
		RoomHandler rh = RoomHandler.getInstance();
		ArrayList<Department> lisDep = rh.refreshDepartment();
		ArrayList<Hospital> lisHos = rh.refreshHospital();
		PatientHandler ph = PatientHandler.getInstance();
		ArrayList<Patient> lisPat = ph.refreshPatient();
		ArrayList<MedicalEvent> lisMe = hh.refreshMedicalEvent();

		Object[] rowdata = new Object[9];
		// model.addRow(new String[] {"ID", "Full Name", "Description", "Days in
		// Hospital", "Arrival", "Hospital Name", "Department Name" });

		for (int i = 0; i < lis.size(); i++) {
			rowdata[0] = lis.get(i).getPatientID();

			for (Patient pa : lisPat) {
				if (pa.getID().equals(lis.get(i).getPatientID()))
					rowdata[1] = pa.getFirstName() + " " + pa.getSurName();
			}

			for (MedicalEvent me : lisMe) {
				if (me.getEventCode() == lis.get(i).getEventCode())
					rowdata[2] = me.getDiscription();
			}
			rowdata[3] = lis.get(i).getNumberOfDays();
			rowdata[4] = lis.get(i).getDateOfArrival().toString();
			rowdata[5] = lis.get(i).getSeverityLevel();

			for (Department dep : lisDep) {
				if (dep.getHospitalID() == lis.get(i).getHospitalID()
						&& dep.getDepartmentID() == lis.get(i).getDepartmentID()) {
					for (Hospital hos : lisHos) {
						if (hos.getHospitalID() == dep.getHospitalID()) {
							rowdata[6] = hos.getName();
							rowdata[7] = dep.getDepartmentName();
						}
					}
				}
			}
			rowdata[8] = lis.get(i).getRoomNumber();
			model.addRow(rowdata);
		}
		table.setPreferredScrollableViewportSize(new Dimension(450, 63));

		JScrollPane js = new JScrollPane(table);
		js.setBounds(52, 80, 670, 366);
		js.setVisible(true);
		add(js);

		JLabel lblHospotalization = new JLabel("Hospitalization");
		lblHospotalization.setBounds(260, 22, 253, 34);
		lblHospotalization.setForeground(Color.RED);
		lblHospotalization.setFont(new Font("Aharoni", Font.BOLD, 34));
		add(lblHospotalization);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String inStr = JOptionPane.showInputDialog(null, "Enter Patient ID:", "Patient ID",
						JOptionPane.PLAIN_MESSAGE);
				PersonHandler ph = PersonHandler.getInstance();

				Person person = null;
				boolean b = false;
				for (Person p : ph.refreshPerson()) { // person already exists in system
					if (p.getID().equals(inStr)) {
						person = p;
						for (Patient pat : lisPat)
							if (pat.getID().equals(p.getID())) { // person exists as a patient
								b = true;
							}
					}
				}
				if (person != null) {
					if (b)
						changePanel(new AddHospitalization(inStr));
					else {// put person in patient table:
						PatientHandler.getInstance().insertPatient(person.getID(), person.getFirstName(),
								person.getSurName(), person.getDateOfBirth(), person.getCity(), person.getStreet(),
								person.getGender(), person.getPhone(), person.getBloodtype(), person.getCareFacility(),
								person.getContactID());
						changePanel(new AddHospitalization(inStr));
					}
				} else {
					JOptionPane.showMessageDialog(null, "Patient is not in System\n" + "Please Enter Patient's Details",
							"Missing Details", JOptionPane.INFORMATION_MESSAGE);
					changePanel(new AddPatientInHospitalization());
				}
			}
		});
		btnAdd.setFont(new Font("Aharoni", Font.BOLD, 12));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.RED);
		btnAdd.setBounds(632, 466, 89, 23);
		add(btnAdd);

		home = new JButton("Home");
		
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					changePanel(new Graphs());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		home.setForeground(Color.WHITE);
		home.setBackground(Color.RED);
		home.setFont(new Font("Aharoni", Font.BOLD, 12));
		home.setBounds(51, 466, 109, 23);
		add(home);

		JButton btnAddCheckUp = new JButton("Add Check Up");
		btnAddCheckUp.setForeground(Color.WHITE);
		btnAddCheckUp.setBackground(Color.RED);
		btnAddCheckUp.setFont(new Font("Aharoni", Font.BOLD, 12));
		btnAddCheckUp.setBounds(51, 500, 109, 23);
		add(btnAddCheckUp);
		btnAddCheckUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String patID = model.getValueAt(table.getSelectedRow(), 0).toString();
				String code = model.getValueAt(table.getSelectedRow(), 2).toString();
				Date d = java.sql.Date.valueOf(model.getValueAt(table.getSelectedRow(), 4).toString());
				int days = Integer.parseInt(model.getValueAt(table.getSelectedRow(), 3).toString());
				changePanel(new AddCheckups(patID, code, d, days));

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

	public void disable() {

		home.setEnabled(false);
		home.setEnabled(false);

	}
}
