package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import DB.DBconn;
import Model.DoctorHandler;

public class Graphs extends JPanel {
	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private JPanel progress;
private JPanel pieChart;
private JPanel lineChart;
private JPanel barchart;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public Graphs() throws Exception {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setLayout(null);
		
		@SuppressWarnings("unused")
		PieChart p= new PieChart("Num Of doctors");
		pieChart = PieChart.createDemoPanel();
		pieChart.setBounds(0, 270, 388, 270);
		add(pieChart);
		
		/////
		LineChart l=new LineChart("Yes", "Income Per Month");	
		lineChart = l.getChartPanel();
		lineChart.setBounds(386, 270, 388, 270);
		add(lineChart);
		//
		
		BarChart b= new BarChart( "Hospitals", "Capacity");
	
		barchart = b.getChartPanel();
	
		
		barchart.setBounds(0, 0, 388, 270);
		add(barchart);
		
		///
		progress = new CustomePanel();
		DBconn db= new DBconn();
		db.initConn();
		
		int occupied=DoctorHandler.getInstance().getOccupiedDoctors().size();
		int doctorsNum=DoctorHandler.getInstance().refreshDoctor().size();
		
		float x=(float) ((occupied*100)/doctorsNum);
		
	
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					///precents
					for(int i=1;i<=x;i++) {
						
					// TODO Auto-generated method stub
					try {
						((CustomePanel) progress).updateProgress(i);
						progress.repaint();
						Thread.sleep(25);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				}
			}).start();	
		progress.setBounds(388, 0, 388, 270);
		add(progress);
	
		
		

	}
	

}
