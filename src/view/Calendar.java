package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDayChooser;

import DB.DBconn;
import DB.DoctorVacations;
import Model.DoctorHandler;



public class Calendar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private JDayChooser dayChooser;
	private JTable table;
	private DatePickerFram dFrame;
	
	private JButton add;
	private JButton back;

	private Date d;
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public Calendar() throws Exception {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblCalendar = new JLabel("Calendar");
		lblCalendar.setBounds(316, 22, 145, 34);
		lblCalendar.setBackground(Color.RED);
		lblCalendar.setForeground(Color.RED);
		lblCalendar.setFont(new Font("Aharoni", Font.BOLD, 34));
		add(lblCalendar);
		
		add = new JButton("Add Vacation");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				changePanel(new AddVacation());
				dFrame.setVisible(false);
				
			}
		});
		add.setFont(new Font("Aharoni", Font.BOLD, 12));
		add.setBackground(Color.RED);
		add.setForeground(Color.WHITE);
		add.setBounds(323, 468, 128, 28);
		add(add);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(51, 98, 670, 333);
		add(table);
		
		if(dFrame==null) {
			
			System.out.println("null");
			dFrame= new DatePickerFram(this);
			dFrame.setVisible(true);
			dFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Doctor ID", "First Name", "Surname", "Vacation Date"
				}
			));
	
			DBconn d= new DBconn();
			d.initConn();

			DefaultTableModel model = (DefaultTableModel)table.getModel();
			
			@SuppressWarnings("static-access")
			DoctorHandler dh= new DoctorHandler().getInstance();
			ArrayList<DoctorVacations> lis = dh.getAllVacations();
			
			Object [] rowdata=new Object[4];
			try{
				for (int i=0;i<lis.size();i++)
				{
					rowdata[0]=lis.get(i).getDoctorID();
					rowdata[1]=lis.get(i).getFname();
					rowdata[2]=lis.get(i).getSname();
					rowdata[3]=lis.get(i).getVacationDate().toString();
					model.addRow(rowdata);
					}
				   
			} catch(NullPointerException e){
				JOptionPane.showMessageDialog(null, " There are no Vacations in the system","Error",JOptionPane.ERROR_MESSAGE);
			}
			
			table.setPreferredScrollableViewportSize(new Dimension(450,63));

	        JScrollPane js=new JScrollPane(table);
	        js.setBounds(52, 80, 670, 366);
	        js.setVisible(true);
	        add(js);
	        
	        JButton button = new JButton("Today Onwards");
	        button.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		table.setModel(new DefaultTableModel(
	        				new Object[][] {
	        				},
	        				new String[] {
	        					"Doctor ID", "First Name", "Surname", "Vacation Date"
	        				}
	        			));
	        	
	        			DBconn d= new DBconn();
	        			try {
							d.initConn();
						} catch (Exception e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}

	        			DefaultTableModel model = (DefaultTableModel)table.getModel();
	        			
	        			@SuppressWarnings("static-access")
	        			DoctorHandler dh= new DoctorHandler().getInstance();
	        			ArrayList<DoctorVacations> lis = dh.getAllVacations();
	        			
	        			Object [] rowdata=new Object[4];
	        			try{
	        				for (int i=0;i<lis.size();i++)
	        				{
	        					// create a java calendar instance
	        					java.util.Calendar calendar = java.util.Calendar.getInstance();

	        					// get a java date (java.util.Date) from the Calendar instance.
	        					// this java date will represent the current date, or "now".
	        					java.util.Date currentDate = calendar.getTime();

	        					// now, create a java.sql.Date from the java.util.Date
	        					java.sql.Date date = new java.sql.Date(currentDate.getTime());
	        					
	        					if(lis.get(i).getVacationDate().after(date)) {
	        						
	        						rowdata[0]=lis.get(i).getDoctorID();
		        					rowdata[1]=lis.get(i).getFname();
		        					rowdata[2]=lis.get(i).getSname();
		        					rowdata[3]=lis.get(i).getVacationDate().toString();
		        					model.addRow(rowdata);
	        					}
	        					
	        				
	        					}
	        				   
	        			} catch(NullPointerException e1){
	        				JOptionPane.showMessageDialog(null, " There are no Vacations in the system","Error",JOptionPane.ERROR_MESSAGE);
	        			}
	        			
	        			table.setPreferredScrollableViewportSize(new Dimension(450,63));

	        	        JScrollPane js=new JScrollPane(table);
	        	        js.setBounds(52, 80, 670, 366);
	        	        js.setVisible(true);
	        	        add(js);
	        		
	        		
	        	}
	        });
	        button.setForeground(Color.WHITE);
	        button.setFont(new Font("Aharoni", Font.BOLD, 12));
	        button.setBackground(Color.RED);
	        button.setBounds(594, 468, 128, 28);
	        add(button);
	        
	        back = new JButton("Back");
	        back.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		try {
	        			
	        			dFrame.setVisible(false);
						changePanel(new Graphs());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        	}
	        });
	        back.setForeground(Color.WHITE);
	        back.setFont(new Font("Aharoni", Font.BOLD, 12));
	        back.setBackground(Color.RED);
	        back.setBounds(52, 468, 128, 28);
	        add(back);
			
			
		
	}
	
	@SuppressWarnings("deprecation")
	public void uploadDate(String s) throws Exception {
		
		String[] parts = s.split("-");
		int day= Integer.parseInt(parts[0]);
		int month= Integer.parseInt(parts[1]);
		int year= Integer.parseInt(parts[2]);
		
		d= new Date(year-1900, month-1, day);
		
		ArrayList<DoctorVacations> dv=DoctorHandler.getInstance().getVacationsByDat(d);
		setUpTableData(dv);

	/*	try {
			changePanel(new Calendar());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

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
	
	
	public void setUpTableData(ArrayList<DoctorVacations> dv) throws Exception {
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Doctor ID", "First Name", "Surname", "Vacation Date"
				}
			));
	
			DBconn d= new DBconn();
			d.initConn();

			DefaultTableModel model = (DefaultTableModel)table.getModel();
			ArrayList<DoctorVacations> lis = dv;
			System.out.println(lis.size());
			
			Object [] rowdata=new Object[4];
			try{
				for (int i=0;i<lis.size();i++)
				{
					rowdata[0]=lis.get(i).getDoctorID();
					rowdata[1]=lis.get(i).getFname();
					rowdata[2]=lis.get(i).getSname();
					rowdata[3]=lis.get(i).getVacationDate().toString();
					model.addRow(rowdata);
					}
				   
			} catch(NullPointerException e){
				JOptionPane.showMessageDialog(null, " There are no Vacations in the system","Error",JOptionPane.ERROR_MESSAGE);
			}
			
			table.setPreferredScrollableViewportSize(new Dimension(450,63));

	        JScrollPane js=new JScrollPane(table);
	        js.setBounds(52, 80, 670, 366);
	        js.setVisible(true);
	        add(js);
			
			
		
	    /**
	    * additional code.
	    **/
	   // tableModel.fireTableDataChanged();
	    /**/
	}
	
public void disable() {
		
		back.setEnabled(false);
		add.setText("Request Vacation");	
	}
}
