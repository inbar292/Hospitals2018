package DB;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Hospital {

	private int hospitalID;
	private String name;
	private String city;
	private String street;
	private String phone;
	private int workersNum;
	private int sum;

	public Hospital(int hospitalID, String name, String city, String street, String phone) {
		super();
		this.hospitalID = hospitalID;
		this.name = name;
		this.city = city;
		this.street = street;
		this.phone = phone;
	}
	
	public Hospital(int hospitalID, String name, int workersNum, int sum) {
		
		this.hospitalID = hospitalID;
		this.name = name;
		this.setWorkersNum(workersNum);
		this.setSum(sum);
	}

	public int getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(int hospitalID) {
		this.hospitalID = hospitalID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hospitalID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospital other = (Hospital) obj;
		if (hospitalID != other.hospitalID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hospital [hospitalID=" + hospitalID + ", name=" + name + ", city=" + city + ", street=" + street
				+ ", phone=" + phone + "]";
	}
	
	public static ArrayList<Hospital> getHospitals() {
		ArrayList<Hospital> retrieved = new ArrayList<>();
		ResultSet rs= null;
		CallableStatement cstmt = null;
		try {
			cstmt = DBconn.conn.prepareCall("{call getHospitals}");
			cstmt.execute();
			rs = cstmt.getResultSet();
	
			while (rs.next())
				retrieved.add(new Hospital(Integer.parseInt(rs.getString("hospitalID")), rs.getString("name"),
						rs.getString("city"), rs.getString("street"), rs.getString("phone")));
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return retrieved;
	}

	public int getWorkersNum() {
		return workersNum;
	}

	public void setWorkersNum(int workersNum) {
		this.workersNum = workersNum;
	}
	public static ArrayList<Hospital> getHospitalsStatistics() {
		ArrayList<Hospital> retrieved = new ArrayList<>();
		ResultSet rs= null;
		CallableStatement cstmt = null;
		try {
			cstmt = DBconn.conn.prepareCall("{call departmentStatistics}");
			cstmt.execute();
			rs = cstmt.getResultSet();
	
			while (rs.next())
				retrieved.add(new Hospital(Integer.parseInt(rs.getString("hospitalID")), rs.getString("name"),
						Integer.parseInt(rs.getString("Num Of Doctors")),0));
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return retrieved;
	}
	
	public static ArrayList<Hospital> getQ6() {
		ArrayList<Hospital> retrieved = new ArrayList<>();
		ResultSet rs= null;
		CallableStatement cstmt = null;
		try {
			cstmt = DBconn.conn.prepareCall("{call q6}");
			cstmt.execute();
			rs = cstmt.getResultSet();
	
			while (rs.next())
				retrieved.add(new Hospital(Integer.parseInt(rs.getString("hospitalID")), rs.getString("name"),
						//worker num                                                         sum
						Integer.parseInt(rs.getString("Month")),Integer.parseInt(rs.getString("Total Payment"))));
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return retrieved;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	public static ArrayList<Hospital> getMaxCapacity() {
		ArrayList<Hospital> retrieved = new ArrayList<>();
		ResultSet rs= null;
		CallableStatement cstmt = null;
		try {
			cstmt = DBconn.conn.prepareCall("{call  departmentStatistics}");
			cstmt.execute();
			rs = cstmt.getResultSet();
	
			while (rs.next())
				retrieved.add(new Hospital(Integer.parseInt(rs.getString("hospitalID")), rs.getString("name"),
						//worker num                                                         sum
						Integer.parseInt(rs.getString("Max capacity")),Integer.parseInt(rs.getString("Num Of Departmens"))));
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return retrieved;
	}

	public static ArrayList<String> getQ3(){
		ArrayList<String> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {
			
			cstmt = DBconn.conn.prepareCall("{call q3}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			
			while (rs.next()) {
				retrieved.add(rs.getString("HospitalName") + " " + rs.getString("HospitalStatus"));
			}
		
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
		
	}
	
	public static ArrayList<String> getQ7a(){
		ArrayList<String> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {
			
			cstmt = DBconn.conn.prepareCall("{call q7a}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			
			while (rs.next()) {
				retrieved.add(rs.getString("hospitalID") + " " + rs.getString("name")+" "+rs.getString("departmentID") + " " +
			rs.getString("DepartmentName")+" "+rs.getString("ManagerName")+" "+rs.getString("NumOfDoctors"));
			}
		
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
		
	}
	public static ArrayList<String> getQ7b(){
		ArrayList<String> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {
			
			cstmt = DBconn.conn.prepareCall("{call q7b}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			
			while (rs.next()) {
				retrieved.add(rs.getString("hospitalID") + " " + rs.getString("HospitalName")+" "+rs.getString("departmentID") + " " +
			rs.getString("DepartmentName")+" "+rs.getString("ManagerName")+" "+rs.getString("NumOfDoctors"));
			}
		
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
		
	}
	public static ArrayList<String> getQ9(){
		ArrayList<String> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {
			
			cstmt = DBconn.conn.prepareCall("{call q9}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			
			while (rs.next()) {
				retrieved.add(rs.getString("name") + " " + rs.getString("departmentName")+" "+
			rs.getString("FreeBeds")+" "+rs.getString("load status"));
			}
		
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
		
	}	
	public static ArrayList<String> getQ6b(){
		ArrayList<String> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {
			
			cstmt = DBconn.conn.prepareCall("{call q6}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			
			while (rs.next()) {
				retrieved.add(rs.getString("name") + " " + rs.getString("Month")+" "+rs.getString("Total Payment"));
			}
		
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
		
	}
	

}
