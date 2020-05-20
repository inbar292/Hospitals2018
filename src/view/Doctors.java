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
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DB.DBconn;
import DB.Doctor;
import Model.DoctorHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class Doctors extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public Doctors() throws Exception {
		
		
		 
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
				"ID", "First Name", "Surname","Date Of Birth","Phone", "Graduation Date", "Is Manager", "Hospital ID", "Department ID"
			}
		));
		
		
		DBconn d= new DBconn();
		d.initConn();
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		DoctorHandler doc= DoctorHandler.getInstance();
		ArrayList<Doctor> lis = doc.refreshDoctor();
		
        Object [] rowdata=new Object[9];
        
      //  model.addRow(new String[] {"ID", "First Name", "Surname","Date Of Birth","Phone", "Graduation Date", "Is Manager", "Hospital ID", "Department ID"});
        
        try{
    for (int i=0;i<lis.size();i++)
     {
         rowdata[0]=lis.get(i).getID();
         rowdata[1]=lis.get(i).getFirstName();
         rowdata[2]=lis.get(i).getSurName();
         rowdata[3]=lis.get(i).getDateOfBirth().toString();
         rowdata[4]=lis.get(i).getPhone();
         rowdata[5]=lis.get(i).getDateOfGraduation().toString();
         rowdata[6]= lis.get(i).isManager();
         rowdata[7]=lis.get(i).getHospitalID();
       	 rowdata[8]= lis.get(i).getDepartmentID();
        
       model.addRow(rowdata);
     }   
        } catch(NullPointerException e){
         JOptionPane.showMessageDialog(null, "There are no Doctors in the system","Error",JOptionPane.ERROR_MESSAGE);
       }
        
       
        JScrollPane js=new JScrollPane(table);
        js.setBounds(52, 80, 670, 366);
        js.setVisible(true);
        add(js);
		
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setLayout(null);
		

		
		JLabel lblDoctorsInfo = new JLabel("Doctors");
		lblDoctorsInfo.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblDoctorsInfo.setForeground(Color.RED);
		lblDoctorsInfo.setBounds(323, 22, 128, 47);
		add(lblDoctorsInfo);
		
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
		button.setBounds(51, 466, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("Delete");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					for(Doctor d: lis) { 
						if(d.getID().equals(model.getValueAt(table.getSelectedRow(), 0).toString())) {
							if(JOptionPane.showConfirmDialog(null, "Do You Want to Delete the Doctor?", "Delete Doctor?",
									JOptionPane.CANCEL_OPTION) == 0) {
								if(DoctorHandler.getInstance().deleteDoctor(d.getID()))
										JOptionPane.showMessageDialog(null, "Doctor Deleted");
							}	
						}
					}	
					try {
						changePanel(new Doctors());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_1.setBackground(Color.RED);
		button_1.setBounds(444, 466, 89, 23);
		add(button_1);
		
		JButton button_2 = new JButton("Edit");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 EditDoctor ed= new EditDoctor();
				 
				
				 for(Doctor d: lis) {
					 
					 if(d.getID().equals(model.getValueAt(table.getSelectedRow(), 0).toString()))  ed.setDoctor(d);
				 }				 
				 ed.upload();
				changePanel(ed);
				

			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_2.setBackground(Color.RED);
		button_2.setBounds(538, 466, 89, 23);
		add(button_2);
		
		JButton button_3 = new JButton("Add");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				changePanel(new AddDoctor());
				
				
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
