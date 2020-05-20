package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

import DB.DBconn;
import DB.Hospital;
import Model.RoomHandler;

public class PieChart extends ApplicationFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public PieChart(String title ) throws Exception {
		super( title ); 
		///
	      setContentPane(createDemoPanel( ));
	}
	
	   private static PieDataset createDataset( ) throws Exception {
		      DefaultPieDataset dataset = new DefaultPieDataset( );
		      
		      DBconn db= new DBconn();
				db.initConn();
				ArrayList<Hospital> al= RoomHandler.getInstance().getHospitalsStatistics();
				
		      for(Hospital h: al) {
		    	  if(h.getWorkersNum()!=0) {
		    		  dataset.setValue(h.getHospitalID()+"-"+ h.getName(), h.getWorkersNum());
		    	  }
		      }
		      
		      return dataset;         
		   }
		   
		   private static JFreeChart createChart( PieDataset dataset ) {
		      JFreeChart chart = ChartFactory.createPieChart(      
		         "Number Of Doctors per Hospital",   // chart title 
		         dataset,          // data    
		         true,             // include legend   
		         true, 
		         false);

		      return chart;
		   }
		   
		   public static JPanel createDemoPanel( ) throws Exception {
		      JFreeChart chart = createChart(createDataset( ) );
		      chart.setBackgroundPaint(Color.white);
		      return new ChartPanel( chart ); 
		   }

}
