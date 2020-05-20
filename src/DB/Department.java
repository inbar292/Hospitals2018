package DB;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Department {
	
	private int hospitalID;
	private int departmentID;
	private String departmentName;
	private int maxCapacity;
	
	public Department(int hospitalID, int departmentID, String departmentName, int maxCapacity) {
		this.hospitalID = hospitalID;
		this.departmentID=departmentID;
		this.departmentName= departmentName;
		this.maxCapacity=maxCapacity;
	}
	
	
	public int getHospitalID() {
		return hospitalID;
	}

	protected void setHospitalID(int hospitalID) {
		this.hospitalID = hospitalID;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + departmentID;
		result = prime * result + hospitalID;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Department))
			return false;
		Department other = (Department) obj;
		if (departmentID != other.departmentID)
			return false;
		if (hospitalID != other.hospitalID)
			return false;
		return true;
	}

	public String toString() {
		return "Department [hospitalID=" + hospitalID + ", departmentID=" + departmentID + ", departmentName="
				+ departmentName + ", maxCapacity=" + maxCapacity + "]";
	}
	
	public static ArrayList<Department> getDepartments() {
		ArrayList<Department> retrieved = new ArrayList<>();
		ResultSet rs= null;
		CallableStatement cstmt = null;
		try {
			cstmt = DBconn.conn.prepareCall("{call getDepartments}");
			cstmt.execute();
			rs = cstmt.getResultSet();
	
			while (rs.next())
				retrieved.add(new Department(Integer.parseInt(rs.getString("hospitalID")), 
						Integer.parseInt(rs.getString("departmentID")), rs.getString("departmentName"),
						 Integer.parseInt(rs.getString("maxCapacity"))));
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return retrieved;
	}
	
	public ArrayList<Department> getDepartmentsOfHospital(int hospitalID)
	{
		ArrayList<Department> departments = new ArrayList<Department>();
		CallableStatement cstmt = null;
		ResultSet rs=null;
		try {
			cstmt = DBconn.conn.prepareCall("{call getDepartmentsOfHospital("+hospitalID +")}");
			cstmt.execute();
			
			rs = cstmt.getResultSet();
			
	        while (rs.next()) {
	        	
	            departments.add(new Department(this.hospitalID, rs.getInt("departmentID"), rs.getString("departmentName"), rs.getInt("maxCapacity")));
	        }
	    }catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return departments;
    }

}
