package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditHospital extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public EditHospital() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblEditHospital = new JLabel("Edit Hospital");
		lblEditHospital.setForeground(Color.RED);
		lblEditHospital.setFont(new Font("Aharoni", Font.BOLD, 34));
		lblEditHospital.setBounds(287, 22, 199, 34);
		add(lblEditHospital);
		
		JButton button = new JButton("Add");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Aharoni", Font.BOLD, 12));
		button.setBackground(Color.RED);
		button.setBounds(342, 466, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					changePanel(new Hospitals());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Aharoni", Font.BOLD, 12));
		button_1.setBackground(Color.RED);
		button_1.setBounds(131, 466, 89, 23);
		add(button_1);
		
		JLabel label_1 = new JLabel("Hospital ID:");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_1.setBounds(131, 114, 78, 25);
		add(label_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(131, 149, 156, 20);
		add(textField);
		
		JLabel label_2 = new JLabel("Hospital Name:");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_2.setBounds(131, 190, 104, 25);
		add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(131, 225, 156, 20);
		add(textField_1);
		
		JLabel label_3 = new JLabel("City:");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_3.setBounds(318, 114, 104, 25);
		add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(318, 149, 156, 20);
		add(textField_2);
		
		JLabel label_4 = new JLabel("Street:");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_4.setBounds(318, 190, 104, 25);
		add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(318, 225, 156, 20);
		add(textField_3);
		
		JLabel label_5 = new JLabel("Phone Number:");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Aharoni", Font.PLAIN, 14));
		label_5.setBounds(502, 114, 104, 25);
		add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(502, 149, 156, 20);
		add(textField_4);

	}
	
	protected void changePanel(JPanel panel) {
		// TODO Auto-generated method stub

		MainFrame topFrame = (MainFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.changePanel(panel);

	}

}
