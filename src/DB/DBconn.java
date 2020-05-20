package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconn {

	public static Connection conn;
	public static java.sql.Statement s;

	public void initConn() throws Exception {
		
		try {
			
			String url = "jdbc:sqlserver://DESKTOP-2UPNHC\\SQLEXPRESS;databaseName=Hospital2018;integratedSecurity=true";
			String username = "DESKTOP-2UPNHC\\inbar";
			String password = null;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,username, password);
			s = conn.createStatement();
			
			//System.out.println("Connected sucsesfuly");
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			System.out.println("");
		}
		
		
	}
}

