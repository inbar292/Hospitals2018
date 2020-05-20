package view;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import DB.DBconn;
import DB.Hospital;
import Model.RoomHandler;

public class LineChart  extends ApplicationFrame  {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ChartPanel chartPanel;
	 
	  public LineChart( String applicationTitle , String chartTitle ) throws Exception {
	      super(applicationTitle);
	      JFreeChart lineChart = ChartFactory.createLineChart(
	         chartTitle,
	         "Month","Income",
	         createDataset(),
	         PlotOrientation.VERTICAL,
	         true,true,false);
	         
	      chartPanel = new ChartPanel( lineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      setContentPane( chartPanel );
	   }

	   private DefaultCategoryDataset createDataset( ) throws Exception {
	      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	      
	      					//income		//month num
	      
	      DBconn db= new DBconn();
			db.initConn();
			ArrayList<Hospital> al= RoomHandler.getInstance().getQ6();
			
	      for(int i=0;i<=al.size()-2;i++) {
	    	  if(al.get(i).getWorkersNum()!=al.get(i+1).getWorkersNum()) {
	    		  String s= ""+al.get(i).getWorkersNum();
	    		  
	    		  dataset.setValue(al.get(i).getSum(),"Hospitals", s);
	    	  }
	      }
	  /*    dataset.addValue( 15 , "Hospitals" , "1970" );
	      dataset.addValue( 30 , "Hospitals" , "1980" );
	      dataset.addValue( 60 , "Hospitals" ,  "1990" );
	      dataset.addValue( 120 , "Hospitals" , "2000" );
	      dataset.addValue( 240 , "Hospitals" , "2010" );
	      dataset.addValue( 300 , "Hospitals" , "2014" );*/
	      return dataset;
	   }
	   
	   public  ChartPanel getChartPanel() {
			return chartPanel;
		}

}
