package DB;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CheckedBy {
	
	private String patientID;
	private int eventCode;
	private String doctorID;
	private int shiftNumber;
	private Date checkTime;
	private double bodyTemp;
	private String bloodPressure;
	
	public CheckedBy(String patientID, int eventCode, String doctorID, int shiftNumber, Date checkTime, double bodyTemp,
			String bloodPressure) {
		this.patientID = patientID;
		this.eventCode = eventCode;
		this.doctorID = doctorID;
		this.shiftNumber = shiftNumber;
		this.checkTime = checkTime;
		this.bodyTemp = bodyTemp;
		this.bloodPressure = bloodPressure;
	}

	/**
	 * @return the patientID
	 */
	public String getPatientID() {
		return patientID;
	}

	/**
	 * @param patientID the patientID to set
	 */
	protected void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	/**
	 * @return the eventCode
	 */
	public int getEventCode() {
		return eventCode;
	}

	/**
	 * @param eventCode the eventCode to set
	 */
	protected void setEventCode(int eventCode) {
		this.eventCode = eventCode;
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

	/**
	 * @return the checkTime
	 */
	public Date getCheckTime() {
		return checkTime;
	}

	/**
	 * @param checkTime the checkTime to set
	 */
	protected void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	/**
	 * @return the bodyTemp
	 */
	public double getBodyTemp() {
		return bodyTemp;
	}

	/**
	 * @param bodyTemp the bodyTemp to set
	 */
	protected void setBodyTemp(double bodyTemp) {
		this.bodyTemp = bodyTemp;
	}

	/**
	 * @return the bloodPressure
	 */
	public String getBloodPressure() {
		return bloodPressure;
	}

	/**
	 * @param bloodPressure the bloodPressure to set
	 */
	protected void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doctorID == null) ? 0 : doctorID.hashCode());
		result = prime * result + eventCode;
		result = prime * result + ((patientID == null) ? 0 : patientID.hashCode());
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
		if (!(obj instanceof CheckedBy))
			return false;
		CheckedBy other = (CheckedBy) obj;
		if (doctorID == null) {
			if (other.doctorID != null)
				return false;
		} else if (!doctorID.equals(other.doctorID))
			return false;
		if (eventCode != other.eventCode)
			return false;
		if (patientID == null) {
			if (other.patientID != null)
				return false;
		} else if (!patientID.equals(other.patientID))
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
		return "CheckedBy [patientID=" + patientID + ", eventCode=" + eventCode + ", doctorID=" + doctorID
				+ ", shiftNumber=" + shiftNumber + ", checkTime=" + checkTime + ", bodyTemp=" + bodyTemp
				+ ", bloodPressure=" + bloodPressure + "]";
	}
	
	public static ArrayList<CheckedBy> getCheckUps() {
		ArrayList<CheckedBy> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {

			cstmt = DBconn.conn.prepareCall("{call getcheckUps}");
			cstmt.execute();
			rs = cstmt.getResultSet();

			while (rs.next())
				retrieved.add(new CheckedBy(rs.getString("patientID"), Integer.parseInt(rs.getString("eventCode")),
						rs.getString("doctorID"),  Integer.parseInt(rs.getString("shiftNumber")), rs.getDate("checkTime"),
						Double.parseDouble(rs.getString("bodyTemp")), rs.getString("bloodPressure")));

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
	}
	
	public void addCheckUp() {

		CallableStatement cstmt = null;
		try {
			cstmt = DBconn.conn.prepareCall("{call addCheckUp(" 
					+ this.getPatientID() + "," 
					+ this.getEventCode()+ ","
					+ this.getDoctorID()+ "," 
					+ this.getShiftNumber()+ ",'" 
					+ this.getCheckTime().toString()+ "'," 
					+ this.getBodyTemp()+ "," 
					+ this.getBloodPressure()+ ")}");
			cstmt.execute();
			System.out.println("Added CheckUp");

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
