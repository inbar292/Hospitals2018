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

import DB.DBconn;
import DB.Department;
import DB.Hospital;
import DB.Room;
import Model.RoomHandler;

public class Rooms extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton add;
	private JButton home;
	private JButton delete;
	private JButton edit;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public Rooms() throws Exception {
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		table.setBounds(52, 246, 568, 200);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hospital ID", "Hospital Name", "Department ID", "Department Name", "Room Number", "Number of Beds"
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
		RoomHandler rh = RoomHandler.getInstance();
		ArrayList<Room> lis = rh.refreshRoom();
		ArrayList<Department> lisDep = rh.refreshDepartment();
		ArrayList<Hospital> lisHos = rh.refreshHospital();

		Object [] rowdata=new Object[6];
		try{
			for (int i=0;i<lis.size();i++)
			{
				rowdata[0]=lis.get(i).getHospitalID();
				
				for(Department dep : lisDep) {
					if(dep.getHospitalID()==lis.get(i).getHospitalID() &&
							dep.getDepartmentID()==lis.get(i).getDepartmentID()) {
						for(Hospital hos : lisHos) {
							if(hos.getHospitalID()==dep.getHospitalID()) {
								rowdata[1]=hos.getName();
								rowdata[3]=dep.getDepartmentName();
							}
						}	
					}
				}
				rowdata[2]=lis.get(i).getDepartmentID();
				rowdata[4]=lis.get(i).getRoomNum();
				rowdata[5]=lis.get(i).getBedsAmount();
				model.addRow(rowdata);
			}   
		} catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, " There are no rooms in the system","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		table.setPreferredScrollableViewportSize(new Dimension(450,63));

        JScrollPane js=new JScrollPane(table);
        js.setBounds(52, 80, 670, 366);
        js.setVisible(true);
        add(js);
		
		
		//add(table);
		
		
		
		
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
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
		home.setFont(new Font("Aharoni", Font.BOLD, 12));
		home.setBackground(Color.RED);
		home.setBounds(52, 466, 89, 23);
		add(home);
		
		delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				for(Room r: lis) { 
					 if(r.getHospitalID()== Integer.parseInt((model.getValueAt(table.getSelectedRow(), 0)).toString())
							 && r.getDepartmentID()==Integer.parseInt((model.getValueAt(table.getSelectedRow(), 2)).toString())
							 && r.getRoomNum()== Integer.parseInt((model.getValueAt(table.getSelectedRow(), 4)).toString())) {
						if(JOptionPane.showConfirmDialog(null, "Do You Want to Delete the Room?", "Delete Room?",
								JOptionPane.CANCEL_OPTION) == 0) {
							if(RoomHandler.getInstance().deleteRoom(r.getHospitalID(),r.getDepartmentID(),r.getRoomNum()))
									JOptionPane.showMessageDialog(null, "Room Deleted");
						}	
					}
				}	
					try {
						changePanel(new Rooms());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
			}
		});
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Aharoni", Font.BOLD, 12));
		delete.setBackground(Color.RED);
		delete.setBounds(445, 466, 89, 23);
		add(delete);
		
		edit = new JButton("Edit");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 EditRoom er= new EditRoom();
				 
				
				 for(Room r: lis) {
					 
					 if(r.getHospitalID()== Integer.parseInt((model.getValueAt(table.getSelectedRow(), 0)).toString())
						 && r.getDepartmentID()==Integer.parseInt((model.getValueAt(table.getSelectedRow(), 2)).toString())
						 && r.getRoomNum()== Integer.parseInt((model.getValueAt(table.getSelectedRow(), 4)).toString()))
						er.setRoom(r);
				 }	
				 
				 er.upload();
				changePanel(er);
				

			}
				
		});
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Aharoni", Font.BOLD, 12));
		edit.setBackground(Color.RED);
		edit.setBounds(539, 466, 89, 23);
		add(edit);
		
		add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				changePanel(new AddRooms());
				
			}
		});
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Aharoni", Font.BOLD, 12));
		add.setBackground(Color.RED);
		add.setBounds(633, 466, 89, 23);
		add(add);
		
		
		
		JLabel lblRooms = new JLabel("Rooms");
		lblRooms.setForeground(Color.RED);
		lblRooms.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblRooms.setBounds(333, 22, 108, 47);
		add(lblRooms);

	}
	
	protected void changePanel(JPanel panel) {
	    
		MainFrame topFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.changePanel(panel);
		
	}
	
	public void disable() {
		add.setEnabled(false);
		home.setEnabled(false);
		edit.setEnabled(false);
		delete.setEnabled(false);
		
	}
}
