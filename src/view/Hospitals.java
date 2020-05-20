package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DB.DBconn;
import DB.Hospital;
import Model.RoomHandler;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hospitals extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private JTable table;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public Hospitals() throws Exception {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JTable table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(51, 98, 670, 333);
		add(table);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name", "Phone", "City", "Street"
				}
			));
	
			DBconn d= new DBconn();
			d.initConn();

			DefaultTableModel model = (DefaultTableModel)table.getModel();
			
			@SuppressWarnings("static-access")
			RoomHandler dh= new RoomHandler().getInstance();
			ArrayList<Hospital> lis = dh.refreshHospital();
			
			Object [] rowdata=new Object[5];
			try{
				for (int i=0;i<lis.size();i++)
				{
					rowdata[0]=lis.get(i).getHospitalID();
					rowdata[1]=lis.get(i).getName();
					rowdata[2]=lis.get(i).getPhone();
					rowdata[3]=lis.get(i).getCity();
					rowdata[4]=lis.get(i).getStreet();
				
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
		
		JLabel lblHospitals = new JLabel("Hospitals");
		lblHospitals.setForeground(Color.RED);
		lblHospitals.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblHospitals.setBounds(312, 22, 152, 50);
		add(lblHospitals);
		
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
		button.setBounds(53, 466, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("Delete");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_1.setBackground(Color.RED);
		button_1.setBounds(446, 466, 89, 23);
		add(button_1);
		
		JButton button_2 = new JButton("Edit");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_2.setBackground(Color.RED);
		button_2.setBounds(540, 466, 89, 23);
		add(button_2);
		
		JButton button_3 = new JButton("Add");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				changePanel(new AddHospital());
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_3.setBackground(Color.RED);
		button_3.setBounds(634, 466, 89, 23);
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
}
