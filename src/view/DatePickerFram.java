package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DatePickerFram extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private view.Calendar cal;

	/**
	 * Launch the application.
	 */
	public static void main(view.Calendar calen) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatePickerFram frame = new DatePickerFram(calen);
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
	public DatePickerFram(view.Calendar calen) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		cal=calen;
		contentPane = new DatePicker(cal);
		contentPane.setSize(400, 400);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
