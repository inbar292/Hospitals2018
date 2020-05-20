package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import DB.Hospital;
import DB.Room;
import Model.RoomHandler;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AddRooms extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAuto;
	private JTextField department;

	/**
	 * Create the panel.
	 */
	public AddRooms() {

		new RoomHandler();
		RoomHandler rh = RoomHandler.getInstance();

		ArrayList<Hospital> hos = rh.refreshHospital();

		String[] h = new String[hos.size() + 1];
		for (int i = 0; i <= h.length - 2; i++) {

			String str = "" + hos.get(i).getHospitalID();
			h[i] = str;
		}
		
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(221, 141, 156, 20);
		comboBox.setModel(new DefaultComboBoxModel<String>(h));
		add(comboBox);
		
		
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					changePanel(new Rooms());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Aharoni", Font.BOLD, 12));
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(112, 478, 89, 23);
		add(btnCancel);
		
		JLabel lblAddRooms = new JLabel("Add Room");
		lblAddRooms.setForeground(Color.RED);
		lblAddRooms.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblAddRooms.setBounds(303, 34, 168, 47);
		add(lblAddRooms);
		
		JLabel lblHospitalId = new JLabel("Hospital ID:");
		lblHospitalId.setForeground(Color.RED);
		lblHospitalId.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblHospitalId.setBounds(221, 105, 78, 25);
		add(lblHospitalId);
		
		
		
		JLabel lblDepartmentId = new JLabel("Department ID:");
		lblDepartmentId.setForeground(Color.RED);
		lblDepartmentId.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblDepartmentId.setBounds(221, 186, 102, 25);
		add(lblDepartmentId);
		
		JLabel lblRoomNumber = new JLabel("Room Number:");
		lblRoomNumber.setForeground(Color.RED);
		lblRoomNumber.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblRoomNumber.setBounds(405, 185, 102, 25);
		add(lblRoomNumber);
		
		JComboBox<String> Bedamount = new JComboBox<String>();
		Bedamount.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6"}));
		Bedamount.setBounds(405, 141, 156, 20);
		add(Bedamount);
		
		txtAuto = new JTextField();
		txtAuto.setEnabled(false);
		txtAuto.setText("Auto");
		txtAuto.setBounds(405, 221, 156, 20);
		add(txtAuto);
		txtAuto.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int hospitalID= Integer.parseInt(comboBox.getSelectedItem().toString());
				int departmentID= Integer.parseInt(department.getText().toString());
				//room num is last room+1
				//
				ArrayList<Room> room= RoomHandler.getInstance().refreshRoom();
				ArrayList<Room> hosANDdep= new ArrayList<Room>();
				for(Room r: room) {
					
					if(r.getHospitalID()== hospitalID && r.getDepartmentID()== departmentID) {
						
						hosANDdep.add(r);
					}
					
				}
				
				int size= hosANDdep.size();
				//			
				int roomNum= hosANDdep.get(size-1).getRoomNum()+1;
				
				int bedsAmount= Integer.parseInt(Bedamount.getSelectedItem().toString());
			
				RoomHandler.getInstance().insertRoom(hospitalID, departmentID, roomNum, bedsAmount);
				JOptionPane.showMessageDialog(null, "Room added", "Success", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Aharoni", Font.BOLD, 12));
		btnAdd.setBackground(Color.RED);
		btnAdd.setBounds(342, 478, 89, 23);
		add(btnAdd);
		
		JLabel lblBedsAmount = new JLabel("Beds Amount:");
		lblBedsAmount.setForeground(Color.RED);
		lblBedsAmount.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblBedsAmount.setBounds(405, 105, 102, 25);
		add(lblBedsAmount);
		
		department = new JTextField();
		department.setBounds(221, 222, 156, 20);
		add(department);
		department.setColumns(10);

	}
	
	protected void changePanel(JPanel panel) {
	    
		MainFrame topFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.changePanel(panel);
		
	}
}
