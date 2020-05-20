package DB;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WorksInShift {
	
	private String doctorID;
	private int shiftNumber;
	private String firstName;
	private String surename;
	private String hospitalName;
	private int departmentID;
	
	public WorksInShift(String doctorID, int shiftNumber, String firstName, String surename, String hospitalName,
			int departmentID) {
		super();
		this.doctorID = doctorID;
		this.shiftNumber = shiftNumber;
		this.firstName = firstName;
		this.surename = surename;
		this.hospitalName = hospitalName;
		this.departmentID = departmentID;
	}
	/**
	 * @return the doctorID
	 */
	public String getDoctorID() {
		return doctorID;
	}
	/**
	 * @param doctorID the doctorID to set
	 */
	protected void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	/**
	 * @return the shiftNumber
	 */
	public int getShiftNumber() {
		return shiftNumber;
	}
	/**
	 * @param shiftNumber the shiftNumber to set
	 */
	protected void setShiftNumber(int shiftNumber) {
		this.shiftNumber = shiftNumber;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doctorID == null) ? 0 : doctorID.hashCode());
		result = prime * result + shiftNumber;
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
		if (!(obj instanceof WorksInShift))
			return false;
		WorksInShift other = (WorksInShift) obj;
		if (doctorID == null) {
			if (other.doctorID != null)
				return false;
		} else if (!doctorID.equals(other.doctorID))
			return false;
		if (shiftNumber != other.shiftNumber)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WorksInShift [doctorID=" + doctorID + ", shiftNumber=" + shiftNumber + "]";
	}
	public String getSurename() {
		return surename;
	}
	public void setSurename(String surename) {
		this.surename = surename;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
	public static ArrayList<WorksInShift> getShifts() {
		ArrayList<WorksInShift> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {

			cstmt = DBconn.conn.prepareCall("{call getShifts}");
			cstmt.execute();
			rs = cstmt.getResultSet();

			while (rs.next())
				retrieved.add(new WorksInShift(rs.getString("doctorID"), Integer.parseInt(rs.getString("shiftNumber")),
						rs.getString("firstName"), rs.getString("surName"),rs.getString("Hospital Name") ,Integer.parseInt(rs.getString("departmentID"))));

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
	}

}
