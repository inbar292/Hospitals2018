package view;

import java.awt.Color;
import java.awt.Font;
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
import DB.WorksInShift;
import Model.DoctorHandler;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Shifts extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public Shifts() throws Exception {
		
		 
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
					"Shift Number", "Doctor ID", "Surname","First Nnme","Hospital Name", "Department ID"
				}
			));
			
			
			DBconn d= new DBconn();
			d.initConn();
			
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			DoctorHandler doc= DoctorHandler.getInstance();
			ArrayList<WorksInShift> lis = doc.refreshShifts();
			
	        Object [] rowdata=new Object[6];
	        
	        
	        try{
	    for (int i=0;i<lis.size();i++)
	     {
	         rowdata[0]=lis.get(i).getShiftNumber();
	         rowdata[1]=lis.get(i).getDoctorID();
	         rowdata[2]=lis.get(i).getSurename();
	         rowdata[3]=lis.get(i).getFirstName();
	         rowdata[4]=lis.get(i).getHospitalName();
	         rowdata[5]=lis.get(i).getDepartmentID();
	        
	       model.addRow(rowdata);
	     }   
	        } catch(NullPointerException e){
	         JOptionPane.showMessageDialog(null, "There are no Shifts in the system","Error",JOptionPane.ERROR_MESSAGE);
	       }
	        
	       
	        JScrollPane js=new JScrollPane(table);
	        js.setBounds(52, 80, 670, 366);
	        js.setVisible(true);
	        add(js);
			
	        
	        
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblS = new JLabel("Works In Shifts");
		lblS.setForeground(Color.RED);
		lblS.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblS.setBounds(268, 22, 240, 46);
		add(lblS);
		
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
		button_1.setBounds(533, 466, 89, 23);
		add(button_1);
		
		JButton button_3 = new JButton("Add");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				changePanel(new AddShifts());
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_3.setBackground(Color.RED);
		button_3.setBounds(632, 466, 89, 23);
		add(button_3);

	}
	
	protected void changePanel(JPanel panel) {
	    
		MainFrame topFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.changePanel(panel);
		
	}
}
