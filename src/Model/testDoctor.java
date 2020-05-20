package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.Doctor;


public class testDoctor {
	
	
	private static testDoctor instance;
	
	private testDoctor() {};
	
	public static testDoctor getInstance()
	{
		if (instance==null)
			instance=new testDoctor();
		return instance;
	}

	public ArrayList<Doctor> getDoctors()
	{
		ArrayList<Doctor> people = new ArrayList<Doctor>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			String url = "jdbc:sqlserver://DESKTOP-2UPNHC\\SQLEXPRESS;databaseName=Hospital2018;integratedSecurity=true";
			String username = "DESKTOP-2UPNHC\\inbar";
			String password = null;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(url,username, password);
			///////////////////////////
			
			cstmt = conn.prepareCall("{call getDoctors}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			while (rs.next())
			{
				people.add(new Doctor(rs.getString("doctorID"), rs.getString("firstName"), rs.getString("surName"), 
						rs.getDate("dateOfBirth"), rs.getString("city"), rs.getString("street"),
						utils.E_Gender.valueOf(rs.getString("gender")), rs.getString("phone"), utils.E_BloodType.valueOf(rs.getString("bloodType")),
						null, rs.getString("contactID"),
						rs.getDate("dateOfGraduation"), Boolean.parseBoolean(rs.getString("manager")), 
						Integer.parseInt(rs.getString("hospitalID")), Integer.parseInt(rs.getString("departmentID"))));
			    
			}
		}
		catch (Exception ex) {
	        ex.printStackTrace();
	    }
	finally {
		if (rs!=null)
		{
			try {
				rs.close();
			}
		catch (SQLException ex2) {
           System.out.println("nope");
	      }
		}
		if (cstmt!=null)
		{
			try {
				cstmt.close();
			}
			catch (SQLException ex3) {
				System.out.println("nope2");
			}
		}
	  }
		
		return people;
    }

}
