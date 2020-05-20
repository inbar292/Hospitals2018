package view;

import java.awt.BorderLayout;
import java.awt.SystemColor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class AboutUs extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea txtrAuthorsInbarShwartz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AboutUs dialog = new AboutUs();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AboutUs() {
		setType(Type.POPUP);
		setTitle("About Us");
		setBounds(100, 100, 448, 255);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			txtrAuthorsInbarShwartz = new JTextArea();
			txtrAuthorsInbarShwartz.setBackground(SystemColor.control);
			txtrAuthorsInbarShwartz.setEditable(false);
			txtrAuthorsInbarShwartz.setText("Authors: Inbar Shwartz and Yael Wolf\r\nRelease Date: July 31, 2018\r\nVersion: 1.0\r\n\r\nWe hope that you will find this program to be\r\nuseful and worth of 10 points to our final grade.\r\n\r\nFor any further questions please contact us on:\r\ninbar_292@hotmail.com or yaelwlf@gmail.com");
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addComponent(txtrAuthorsInbarShwartz, GroupLayout.PREFERRED_SIZE, 424, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(txtrAuthorsInbarShwartz, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
		);
		
			
	}

}
