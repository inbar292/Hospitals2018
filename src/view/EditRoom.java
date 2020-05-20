package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import DB.Room;
import Model.RoomHandler;

public class EditRoom extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField roomNum;
	private JTextField Hospital;
	private JTextField Department;
	
	private Room r;

	/**
	 * Create the panel.
	 */
	public EditRoom() {
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblEditRoom = new JLabel("Edit Room");
		lblEditRoom.setForeground(Color.RED);
		lblEditRoom.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblEditRoom.setBounds(302, 22, 170, 47);
		add(lblEditRoom);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					changePanel(new Rooms());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_1.setBackground(Color.RED);
		button_1.setBounds(122, 466, 89, 23);
		add(button_1);
		
		JLabel label_1 = new JLabel("Hospital ID:");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_1.setBounds(221, 105, 78, 25);
		add(label_1);
		
		JLabel label_2 = new JLabel("Department ID:");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_2.setBounds(221, 172, 102, 25);
		add(label_2);
		
		JLabel label_3 = new JLabel("Room Number:");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_3.setBounds(425, 172, 102, 25);
		add(label_3);
		
		roomNum = new JTextField();
		roomNum.setEditable(false);
		roomNum.setColumns(10);
		roomNum.setBounds(425, 207, 156, 20);
		add(roomNum);
		
		JLabel label_4 = new JLabel("Beds Amount:");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_4.setBounds(425, 105, 102, 25);
		add(label_4);
		
		JComboBox<String> bedAmount = new JComboBox<String>();
		bedAmount.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6"}));
		bedAmount.setBounds(425, 139, 156, 20);
		add(bedAmount);
		
		Hospital = new JTextField();
		Hospital.setEditable(false);
		Hospital.setColumns(10);
		Hospital.setBounds(221, 139, 156, 20);
		add(Hospital);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			RoomHandler.getInstance().updateRoom(r.getHospitalID(), r.getDepartmentID(), r.getRoomNum(),Integer.parseInt(bedAmount.getSelectedItem().toString()) );
			JOptionPane.showConfirmDialog(null, "Room was Updaed", "success", JOptionPane.CANCEL_OPTION);
			}
		});
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Aharoni", Font.BOLD, 12));
		btnSave.setBackground(Color.RED);
		btnSave.setBounds(342, 466, 89, 23);
		add(btnSave);
		
		Department = new JTextField();
		Department.setEditable(false);
		Department.setColumns(10);
		Department.setBounds(221, 207, 156, 20);
		add(Department);

	}
	
	void setRoom(Room room) {
		
		r=room;
		
		r.toString();
		
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
	
	public void upload() {
		
		String hosID= ""+r.getHospitalID();
		String depID= ""+r.getDepartmentID();
		String roomID= ""+r.getRoomNum();
		
		Hospital.setText(hosID);
		Department.setText(depID);
		roomNum.setText(roomID);		
		
	}
	
}
