package view;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDepartment extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public AddDepartment() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblAddDepartment = new JLabel("Add Department");
		lblAddDepartment.setForeground(Color.RED);
		lblAddDepartment.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblAddDepartment.setBounds(252, 22, 270, 34);
		add(lblAddDepartment);
		
		JLabel lblHospitalNum = new JLabel("Hospital Num:");
		lblHospitalNum.setForeground(Color.RED);
		lblHospitalNum.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblHospitalNum.setBounds(140, 105, 102, 25);
		add(lblHospitalNum);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(140, 140, 156, 20);
		add(textField);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changePanel(new Departmens());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Aharoni", Font.BOLD, 12));
		button.setBackground(Color.RED);
		button.setBounds(140, 466, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("Add");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_1.setBackground(Color.RED);
		button_1.setBounds(373, 466, 89, 23);
		add(button_1);
		
		JLabel lblDepartmentNum = new JLabel("Department Num:");
		lblDepartmentNum.setForeground(Color.RED);
		lblDepartmentNum.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblDepartmentNum.setBounds(325, 105, 124, 25);
		add(lblDepartmentNum);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(325, 140, 156, 20);
		add(textField_1);
		
		JLabel lblDepartmentName = new JLabel("Department Name:");
		lblDepartmentName.setForeground(Color.RED);
		lblDepartmentName.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblDepartmentName.setBounds(516, 105, 156, 25);
		add(lblDepartmentName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(516, 140, 156, 20);
		add(textField_2);
		
		JLabel lblMaxCapacity = new JLabel("Max Capacity:");
		lblMaxCapacity.setForeground(Color.RED);
		lblMaxCapacity.setFont(new Font("Aharoni", Font.PLAIN, 14));
		lblMaxCapacity.setBounds(325, 183, 124, 25);
		add(lblMaxCapacity);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(325, 218, 156, 20);
		add(textField_3);

		
	}
	
	protected void changePanel(JPanel panel) {
		// TODO Auto-generated method stub

		MainFrame topFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.changePanel(panel);

	}
}
