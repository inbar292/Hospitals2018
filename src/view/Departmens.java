package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DB.DBconn;
import DB.Department;
import Model.RoomHandler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Departmens extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public Departmens() throws Exception {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblDepartments = new JLabel("Departments");
		lblDepartments.setForeground(Color.RED);
		lblDepartments.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblDepartments.setBounds(284, 22, 205, 47);
		add(lblDepartments);
		
		JButton button = new JButton("Home");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					changePanel(new Graphs());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Aharoni", Font.BOLD, 12));
		button.setBackground(Color.RED);
		button.setBounds(56, 479, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("Delete");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_1.setBackground(Color.RED);
		button_1.setBounds(449, 479, 89, 23);
		add(button_1);
		
		JButton button_2 = new JButton("Edit");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_2.setBackground(Color.RED);
		button_2.setBounds(543, 479, 89, 23);
		add(button_2);
		
		JButton button_3 = new JButton("Add");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_3.setBackground(Color.RED);
		button_3.setBounds(637, 479, 89, 23);
		add(button_3);
		
		JTable table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(51, 98, 670, 333);
		add(table);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Hospital ID", "Department ID", "Name", "Max Capacity"
				}
			));
	
			DBconn d= new DBconn();
			d.initConn();

			DefaultTableModel model = (DefaultTableModel)table.getModel();
			
			@SuppressWarnings("static-access")
			RoomHandler dh= new RoomHandler().getInstance();
			ArrayList<Department> lis = dh.refreshDepartment();
			
			Object [] rowdata=new Object[4];
			try{
				for (int i=0;i<lis.size();i++)
				{
					rowdata[0]=lis.get(i).getHospitalID();
					rowdata[1]=lis.get(i).getDepartmentID();
					rowdata[2]=lis.get(i).getDepartmentName();
					rowdata[3]=lis.get(i).getMaxCapacity();
					
				
					model.addRow(rowdata);
					}
				   
			} catch(NullPointerException e){
				JOptionPane.showMessageDialog(null, " There are no Payments in the system","Error",JOptionPane.ERROR_MESSAGE);
			}
			
			table.setPreferredScrollableViewportSize(new Dimension(450,63));

	        JScrollPane js=new JScrollPane(table);
	        js.setBounds(52, 80, 670, 366);
	        js.setVisible(true);
	        add(js);

	}
	
	protected void changePanel(JPanel panel) {
	    
		MainFrame topFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.changePanel(panel);
		
	}

}
