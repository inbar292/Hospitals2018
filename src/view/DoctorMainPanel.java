package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.LineBorder;

public class DoctorMainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("deprecation")
	public DoctorMainPanel() {
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		
		JLabel lblHelloInbar = new JLabel("Hello Inbar!");
		lblHelloInbar.setBounds(82, 44, 146, 34);
		lblHelloInbar.setForeground(Color.BLACK);
		lblHelloInbar.setFont(new Font("Aharoni", Font.BOLD, 25));
		add(lblHelloInbar);
		
		JLabel lblItSeemsThat = new JLabel("Your Vacation request for 01-12-2018 was granted.");
		lblItSeemsThat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblItSeemsThat.setBounds(82, 139, 590, 41);
		add(lblItSeemsThat);
		
		JLabel lblPleaseRememberTo = new JLabel("Please remember to fill your check ups on time and on shift.");
		lblPleaseRememberTo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPleaseRememberTo.setBounds(82, 240, 590, 41);
		add(lblPleaseRememberTo);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBackground(Color.RED);
		separator_8.setBounds(82, 81, 574, 2);
		add(separator_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBackground(Color.RED);
		separator_9.setBounds(82, 178, 574, 2);
		add(separator_9);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBackground(Color.RED);
		separator_10.setBounds(82, 279, 574, 2);
		add(separator_10);
		
		JLabel lblItSeemsYou = new JLabel("It seems you are a very busy doctor.  Please consider to take down at least one shift.");
		lblItSeemsYou.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblItSeemsYou.setBounds(82, 337, 590, 41);
		add(lblItSeemsYou);
		
		JSeparator separator_11 = new JSeparator();
		separator_11.setBackground(Color.RED);
		separator_11.setBounds(82, 376, 574, 2);
		add(separator_11);

		// create a java calendar instance
		java.util.Calendar calendar = java.util.Calendar.getInstance();

		// get a java date (java.util.Date) from the Calendar instance.
		// this java date will represent the current date, or "now".
		java.util.Date currentDate = calendar.getTime();

		/*
		 * JLabel lblNewLabel = new JLabel("Good Morning");
		 * lblNewLabel.setForeground(Color.RED); lblNewLabel.setFont(new Font("Aharoni",
		 * Font.PLAIN, 15)); lblNewLabel.setBounds(227, 58, 166, 14);
		 * changingPanel.add(lblNewLabel);
		 */

		if (currentDate.getHours() >= 6 && currentDate.getHours() <= 12) {
			JLabel lblNewLabel = new JLabel("Good Morning");
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Aharoni", Font.PLAIN, 15));
			lblNewLabel.setBounds(227, 58, 166, 14);
			add(lblNewLabel);
		}
		if (currentDate.getHours() >= 13 && currentDate.getHours() <= 17) {
			JLabel lblNewLabel = new JLabel("Good Day");
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Aharoni", Font.PLAIN, 15));
			lblNewLabel.setBounds(227, 58, 166, 14);
			add(lblNewLabel);
		}
		if (currentDate.getHours() >= 18 && currentDate.getHours() <= 24) {
			JLabel lblNewLabel = new JLabel("Good Evening");
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Aharoni", Font.PLAIN, 15));
			lblNewLabel.setBounds(227, 58, 166, 14);
			add(lblNewLabel);
		}
		if (currentDate.getHours() >= 1 && currentDate.getHours() <= 5) {
			JLabel lblNewLabel = new JLabel("Good Night");
			lblNewLabel.setForeground(Color.RED);
			lblNewLabel.setFont(new Font("Aharoni", Font.PLAIN, 15));
			lblNewLabel.setBounds(227, 58, 166, 14);
			add(lblNewLabel);
		}
		
		doctorShift progress= new doctorShift();
		int hour= currentDate.getHours()-8;
		int shiftLong=12;
		
		
		float x=(float) ((hour*100)/shiftLong);
		
	
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					///precents
					for(int i=1;i<=x;i++) {
						
					// TODO Auto-generated method stub
					try {
						((doctorShift) progress).updateProgress(i);
						progress.repaint();
						Thread.sleep(25);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}
			}).start();	
		progress.setBounds(483, 403, 232, 114);
		add(progress);

	}

}
