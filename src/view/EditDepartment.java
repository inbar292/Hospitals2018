package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditDepartment extends JPanel {
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
	public EditDepartment() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel label = new JLabel("Add Department");
		label.setForeground(Color.RED);
		label.setFont(new Font("Aharoni", Font.BOLD, 34));
		label.setBounds(252, 22, 270, 34);
		add(label);
		
		JLabel label_1 = new JLabel("Hospital Num:");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_1.setBounds(136, 112, 102, 25);
		add(label_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(136, 147, 156, 20);
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
		button.setBounds(136, 466, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("Add");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_1.setBackground(Color.RED);
		button_1.setBounds(342, 466, 89, 23);
		add(button_1);
		
		JLabel label_2 = new JLabel("Department Num:");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_2.setBounds(325, 112, 124, 25);
		add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(321, 147, 156, 20);
		add(textField_1);
		
		JLabel label_3 = new JLabel("Department Name:");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_3.setBounds(512, 112, 156, 25);
		add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(512, 147, 156, 20);
		add(textField_2);
		
		JLabel label_4 = new JLabel("Max Capacity:");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_4.setBounds(321, 190, 124, 25);
		add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(321, 225, 156, 20);
		add(textField_3);

	}
	
	protected void changePanel(JPanel panel) {
		// TODO Auto-generated method stub

		MainFrame topFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.changePanel(panel);

	}

}
