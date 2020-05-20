package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DB.DBconn;
import DB.Paymentes;
import Model.RoomHandler;

public class Payments extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public Payments() throws Exception {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblPaymentMenu = new JLabel("Payment Menu");
		lblPaymentMenu.setBounds(266, 22, 241, 34);
		lblPaymentMenu.setForeground(Color.RED);
		lblPaymentMenu.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblPaymentMenu.setBackground(Color.RED);
		add(lblPaymentMenu);
		
		JTable table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(51, 98, 670, 333);
		add(table);
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Serial Number", "Min Day", "Max Day", "Amount"
				}
			));
	
			DBconn d= new DBconn();
			d.initConn();

			DefaultTableModel model = (DefaultTableModel)table.getModel();
			
			@SuppressWarnings("static-access")
			RoomHandler dh= new RoomHandler().getInstance();
			ArrayList<Paymentes> lis = dh.refreshPayment();
			
			Object [] rowdata=new Object[4];
			try{
				for (int i=0;i<lis.size();i++)
				{
					rowdata[0]=lis.get(i).getSerialNumber();
					rowdata[1]=lis.get(i).getMinDay();
					rowdata[2]=lis.get(i).getMaxDate();
					rowdata[3]=lis.get(i).getAmount();
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

}
