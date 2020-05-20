package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import Model.PatientHandler;

public class Patient extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton home;
	private JButton delete;
	private JButton edit;

	/**
	 * Create the panel.
	 */
	public Patient() throws Exception{
	
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(51, 98, 670, 333);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "First Name", "Surname", "Date Of Birth", "City", "Street", "Gender", "Phone", "Blood Type", "Care Facility"
			}
		));
		
		DBconn d= new DBconn();
		d.initConn();

		DefaultTableModel model = (DefaultTableModel)table.getModel();
		PatientHandler ph= PatientHandler.getInstance();
		ArrayList<DB.Patient> lis = ph.refreshPatient();

		Object [] rowdata=new Object[10];
		
	    try{
			for (int i=0;i<lis.size();i++)
			{
				rowdata[0]=lis.get(i).getID();
				rowdata[1]=lis.get(i).getFirstName();
				rowdata[2]=lis.get(i).getSurName();
				rowdata[3]=lis.get(i).getDateOfBirth().toString();
				rowdata[4]=lis.get(i).getCity();
				rowdata[5]=lis.get(i).getStreet();
				rowdata[6]=lis.get(i).getGender().toString();
				rowdata[7]=lis.get(i).getPhone();
				rowdata[8]= lis.get(i).getBloodtype().toString();
				rowdata[9]= lis.get(i).getCareFacility(); 
				
				model.addRow(rowdata);
			}   
		} catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, " There are no patients in the system","Error",JOptionPane.ERROR_MESSAGE);
		}
	    JScrollPane js=new JScrollPane(table);
        js.setBounds(52, 80, 670, 366);
        js.setVisible(true);
        add(js);

		
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setLayout(null);
		
		JLabel lblPatient = new JLabel("Patients");
		lblPatient.setForeground(Color.RED);
		lblPatient.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblPatient.setBounds(324, 22, 126, 47);
		add(lblPatient);
		
		home = new JButton("Home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					changePanel(new Graphs());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		home.setForeground(Color.WHITE);
		home.setFont(new Font("Aharoni", Font.BOLD, 12));
		home.setBackground(Color.RED);
		home.setBounds(51, 466, 89, 23);
		add(home);
		
		delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			for(DB.Patient p: lis) {
					 
					 if(p.getID().equals(model.getValueAt(table.getSelectedRow(), 0).toString())) {
						 if(PatientHandler.getInstance().deletePatient(p.getID()))
						JOptionPane.showConfirmDialog(null, "Patient deleted", "success", JOptionPane.CANCEL_OPTION);
					 }
						 
				 }	
					try {
						changePanel(new Patient());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				
				
			}
		});
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Aharoni", Font.BOLD, 12));
		delete.setBackground(Color.RED);
		delete.setBounds(444, 466, 89, 23);
		add(delete);
		
		edit = new JButton("Edit");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EditPatient ep= new EditPatient();
				
				for(DB.Patient p: lis) {
					 
					 if(p.getID().equals(model.getValueAt(table.getSelectedRow(), 0).toString()))  ep.setPatient(p);
				 }				 
				 ep.upload();
				changePanel(ep);
				
				
			}
		});
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Aharoni", Font.BOLD, 12));
		edit.setBackground(Color.RED);
		edit.setBounds(538, 466, 89, 23);
		add(edit);
		
		JButton button_3 = new JButton("Add");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				changePanel(new AddPatient());
			}
		});
	
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_3.setBackground(Color.RED);
		button_3.setBounds(632, 466, 89, 23);
		add(button_3);
		
		
		
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
	
	public void disable() {
		
		home.setEnabled(false);
		edit.setEnabled(false);
		delete.setEnabled(false);
		
	}
}
