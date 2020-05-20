package view;

import java.awt.Color;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import DB.DBconn;
import DB.Hospital;
import Model.RoomHandler; 

public class BarChart extends ApplicationFrame {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ChartPanel chartPanel;
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	public BarChart(String applicationTitle , String chartTitle ) throws Exception{
		 super(chartTitle );        
	      JFreeChart barChart = ChartFactory.createBarChart(
	         chartTitle,           
	         "Hospitals",            
	         "Max Capacity",            
	         createDataset(),          
	         PlotOrientation.VERTICAL,           
	         true, true, false);
	 
	      chartPanel = new ChartPanel( barChart );        
	      chartPanel.setForeground(Color.WHITE);
	      chartPanel.setMouseZoomable(false);
	      chartPanel.setBackground(Color.WHITE);
	      chartPanel.setPreferredSize(new java.awt.Dimension(388, 270 ) ); 
	      chartPanel.setBounds(0, 0, 388, 270);
	      chartPanel.setBackground(Color.white);
	 
	      setContentPane( chartPanel ); 

	}
	
	   private CategoryDataset createDataset( ) throws Exception {
		          
		      final DefaultCategoryDataset dataset = 
		      new DefaultCategoryDataset( );  
		      
		      DBconn db= new DBconn();
				db.initConn();
				ArrayList<Hospital> al= RoomHandler.getInstance(). getMaxCapacity();
				
		      for(Hospital h: al) {
		    	 String s= ""+ h.getHospitalID();
		    	
		    	 
		    		  dataset.setValue(h.getWorkersNum(),s, "");
		    	  
		      }

		      return dataset; 
		   }
	   
	   public  ChartPanel getChartPanel() {
			return chartPanel;
		}
	

}
