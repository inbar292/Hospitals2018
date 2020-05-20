package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import DB.CheckedBy;
import DB.DBconn;
import DB.Doctor;
import Model.CheckUpHandler;
import Model.DoctorHandler;

public class Checkups extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public Checkups() throws Exception {
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		table.setBounds(52, 246, 568, 200);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Patient ID", "Event Code", "Doctor ID", "Shift Number", "Time", "Temperature", "BP"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(119);
		table.getColumnModel().getColumn(2).setPreferredWidth(107);
		table.getColumnModel().getColumn(3).setPreferredWidth(122);
		table.getColumnModel().getColumn(4).setPreferredWidth(97);
		table.getColumnModel().getColumn(5).setPreferredWidth(101);
		
		DBconn d= new DBconn();
		d.initConn();

		DefaultTableModel model = (DefaultTableModel)table.getModel();
		CheckUpHandler ch = CheckUpHandler.getInstance();
		ArrayList<CheckedBy> lis = ch.refreshCheckUps();
		
		DoctorHandler doc= DoctorHandler.getInstance();
		@SuppressWarnings("unused")
		ArrayList<Doctor> docs = doc.refreshDoctor();
		
		/*RoomHandler rh = RoomHandler.getInstance();
		ArrayList<Room> lis = rh.refreshRoom();
		ArrayList<Department> lisDep = rh.refreshDepartment();
		ArrayList<Hospital> lisHos = rh.refreshHospital();*/

		Object [] rowdata=new Object[7];
		try{
			for (int i=0;i<lis.size();i++){
				rowdata[0]=lis.get(i).getPatientID();
				rowdata[1]=lis.get(i).getEventCode();
				rowdata[2]=lis.get(i).getDoctorID();
				rowdata[3]=lis.get(i).getShiftNumber();
				rowdata[4]=lis.get(i).getCheckTime();
				rowdata[5]=lis.get(i).getBodyTemp();
				rowdata[6]=lis.get(i).getBloodPressure();
				model.addRow(rowdata);
			}   
		} catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, "There are no check-ups in the system","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		table.setPreferredScrollableViewportSize(new Dimension(450,63));

        JScrollPane js=new JScrollPane(table);
        js.setBounds(52, 80, 670, 366);
        js.setVisible(true);
        add(js);
       
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblCheckups = new JLabel("Check Ups");
		lblCheckups.setForeground(Color.RED);
		lblCheckups.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblCheckups.setBounds(302, 22, 170, 47);
		add(lblCheckups);
		
		
		
		JButton button = new JButton("Home");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Aharoni", Font.BOLD, 12));
		button.setBackground(Color.RED);
		button.setBounds(52, 466, 89, 23);
		add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					changePanel(new Graphs());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton button_3 = new JButton("Add");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//changePanel(new AddCheckups());
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_3.setBackground(Color.RED);
		button_3.setBounds(633, 466, 89, 23);
		add(button_3);

	}
	

	protected void changePanel(JPanel panel) {
		    
		MainFrame topFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.changePanel(panel);
		
	}
}
