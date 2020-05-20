package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 502);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 0, 486, 154);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblHealthSystem = new JLabel("Health System");
		lblHealthSystem.setBounds(110, 53, 266, 48);
		lblHealthSystem.setFont(new Font("Aharoni", Font.PLAIN, 39));
		lblHealthSystem.setForeground(Color.WHITE);
		panel_1.add(lblHealthSystem);

		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Aharoni", Font.PLAIN, 20));
		lblUser.setForeground(Color.RED);
		lblUser.setBounds(119, 207, 59, 40);
		panel.add(lblUser);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Aharoni", Font.PLAIN, 20));
		lblPassword.setForeground(Color.RED);
		lblPassword.setBounds(119, 258, 115, 40);
		panel.add(lblPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Aharoni", Font.BOLD, 12));
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {

				if (userName.getText().equals("312230600") && (Password.getText().equals("123456"))) {

					DoctorMainFrame maina;
					try {
						maina = new DoctorMainFrame();
						maina.setVisible(true);
						maina.pack();
						maina.setSize(790, 690);
						maina.setLocationRelativeTo(null);
						maina.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						maina.setResizable(false);
						dispose();

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				if (!(userName.getText().equals("Admin")) && !(userName.getText().equals("312230600"))) {
					JOptionPane.showMessageDialog(null, "Incorrect User ID \nInsert again", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				if (!(Password.getText().equals("Admin")) && !(Password.getText().equals("123456"))) {
					JOptionPane.showMessageDialog(null, "Incorrect Password \nInsert again", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				if (userName.getText().equals("Admin") && Password.getText().equals("Admin")) {

					MainFrame maina;
					try {
						maina = new MainFrame();
						maina.setVisible(true);
						maina.pack();
						maina.setSize(790, 690);
						maina.setLocationRelativeTo(null);
						maina.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						maina.setResizable(false);
						dispose();

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		});
		btnLogin.setBackground(Color.RED);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(176, 350, 121, 48);
		panel.add(btnLogin);

		JSeparator separator = new JSeparator();
		separator.setBackground(Color.RED);
		separator.setBounds(240, 237, 131, 10);
		panel.add(separator);

		userName = new JTextField();
		userName.setForeground(Color.RED);
		userName.setBackground(Color.WHITE);
		userName.setBounds(240, 218, 131, 20);
		panel.add(userName);
		userName.setColumns(10);
		userName.setBorder(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.RED);
		separator_1.setBounds(240, 288, 131, 10);
		panel.add(separator_1);

		Password = new JPasswordField();
		Password.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyPressed(KeyEvent arg0) {

				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {

					if (userName.getText().equals("312230600") && (Password.getText().equals("123456"))) {

						DoctorMainFrame maina;
						try {
							
							maina = new DoctorMainFrame();
							maina.setVisible(true);
							maina.pack();
							maina.setSize(790, 690);
							maina.setLocationRelativeTo(null);
							maina.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							maina.setResizable(false);
							dispose();

						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

					if (!(userName.getText().equals("Admin")) && !(userName.getText().equals("312230600"))) {
						JOptionPane.showMessageDialog(null, "Incorrect User ID \nInsert again", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					if (!(Password.getText().equals("Admin")) && !(Password.getText().equals("123456"))) {
						JOptionPane.showMessageDialog(null, "Incorrect Password \nInsert again", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

					if (userName.getText().equals("Admin") && Password.getText().equals("Admin")) {

						MainFrame maina;
						try {
							maina = new MainFrame();
							maina.setVisible(true);
							maina.pack();
							maina.setSize(790, 690);
							maina.setLocationRelativeTo(null);
							maina.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							maina.setResizable(false);
							dispose();

						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}

			}

		});
		Password.setBackground(Color.WHITE);
		Password.setForeground(Color.RED);
		Password.setBounds(240, 269, 131, 20);
		panel.add(Password);
		Password.setBorder(null);
	}

}
