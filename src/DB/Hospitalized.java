package DB;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Hospitalized {

	private String patientID;
	private int eventCode;
	private int numberOfDays;
	private Date dateOfArrival;
	private int severityLevel;
	private int hospitalID;
	private int departmentID;
	private int roomNumber;

	public Hospitalized(String patientID, int eventCode, int numberOfDays, Date dateOfArrival, int severityLevel,
			int hospitalID, int departmentID, int roomNumber) {
		this.patientID = patientID;
		this.eventCode = eventCode;
		this.numberOfDays = numberOfDays;
		this.dateOfArrival = dateOfArrival;
		this.severityLevel = severityLevel;
		this.hospitalID = hospitalID;
		this.departmentID = departmentID;
		this.roomNumber = roomNumber;
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
	 * @return the numberOfDays
	 */
	public int getNumberOfDays() {
		return numberOfDays;
	}

	/**
	 * @param numberOfDays the numberOfDays to set
	 */
	protected void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	/**
	 * @return the dateOfArrival
	 */
	public Date getDateOfArrival() {
		return dateOfArrival;
	}

	/**
	 * @param dateOfArrival the dateOfArrival to set
	 */
	protected void setDateOfArrival(Date dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	/**
	 * @return the severityLevel
	 */
	public int getSeverityLevel() {
		return severityLevel;
	}

	/**
	 * @param severityLevel the severityLevel to set
	 */
	protected void setSeverityLevel(int severityLevel) {
		this.severityLevel = severityLevel;
	}

	/**
	 * @return the hospitalID
	 */
	public int getHospitalID() {
		return hospitalID;
	}

	/**
	 * @param hospitalID the hospitalID to set
	 */
	public void setHospitalID(int hospitalID) {
		this.hospitalID = hospitalID;
	}

	/**
	 * @return the departmentID
	 */
	public int getDepartmentID() {
		return departmentID;
	}

	/**
	 * @param departmentID the departmentID to set
	 */
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	/**
	 * @return the roomNumber
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventCode;
		result = prime * result + ((patientID == null) ? 0 : patientID.hashCode());
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
		if (!(obj instanceof Hospitalized))
			return false;
		Hospitalized other = (Hospitalized) obj;
		if (eventCode != other.eventCode)
			return false;
		if (patientID == null) {
			if (other.patientID != null)
				return false;
		} else if (!patientID.equals(other.patientID))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hospitalized [patientID=" + patientID + ", eventCode=" + eventCode + ", numberOfDays=" + numberOfDays
				+ ", dateOfArrival=" + dateOfArrival + ", severityLevel=" + severityLevel + ", hospitalID=" + hospitalID
				+ ", departmentID=" + departmentID + ", roomNumber=" + roomNumber + "]";
	}

	public static ArrayList<Hospitalized> getHospitalizations(){
		ArrayList<Hospitalized> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {

			cstmt = DBconn.conn.prepareCall("{call getHospitalizations}");
			cstmt.execute();
			rs = cstmt.getResultSet();

			while (rs.next())
				retrieved.add(new Hospitalized(rs.getString("patientID"), Integer.parseInt(rs.getString("eventCode")),
						Integer.parseInt(rs.getString("numberOfDays")), rs.getDate("dateOfArrival"), Integer.parseInt(rs.getString("severityLevel")),
						Integer.parseInt(rs.getString("hospitalID")),
						Integer.parseInt(rs.getString("departmentID")), Integer.parseInt(rs.getString("roomNumber"))));


		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
	}

	public static ArrayList<MedicalEvent> getMedicalEvents(){
		ArrayList<MedicalEvent> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {

			cstmt = DBconn.conn.prepareCall("{call getMedicalEvents}");
			cstmt.execute();
			rs = cstmt.getResultSet();

			while (rs.next())
				retrieved.add(new MedicalEvent(Integer.parseInt(rs.getString("eventCode")),
						rs.getString("discription"), Integer.parseInt(rs.getString("typeCode"))));

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;

	}

	public static ArrayList<MedicalEventTypes> getMedicalEventsTypes(){
		ArrayList<MedicalEventTypes> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {

			cstmt = DBconn.conn.prepareCall("{call getMedicalEventsTypes}");
			cstmt.execute();
			rs = cstmt.getResultSet();

			while (rs.next())
				retrieved.add(new MedicalEventTypes(Integer.parseInt(rs.getString("typeCode")), rs.getString("typeName")));

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;	
	}

	public static ArrayList<MedicalEventTypeInDepartment> getMedicalEventTypeInDepartment(){
		ArrayList<MedicalEventTypeInDepartment> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {

			cstmt = DBconn.conn.prepareCall("{call getMedicalEventTypeInDepartment}");
			cstmt.execute();
			rs = cstmt.getResultSet();

			while (rs.next())
				retrieved.add(new MedicalEventTypeInDepartment(Integer.parseInt(rs.getString("hospitalID")),
						Integer.parseInt(rs.getString("departmentID")), Integer.parseInt(rs.getString("typeCode"))));

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;	
	}

	public void addHospitalization() {

		CallableStatement cstmt = null;

		try {
			cstmt = DBconn.conn.prepareCall("{call addHospitalization(" 
					+ this.getPatientID() + "," 
					+ this.getEventCode()+ ","
					+ this.getNumberOfDays()+ ",'" 
					+ this.getDateOfArrival().toString()+ "'," 
					+ this.getSeverityLevel()+ "," 
					+ this.getHospitalID()+ "," 
					+ this.getDepartmentID()+ "," 
					+ this.getRoomNumber() + ")}");

			cstmt.execute();
			System.out.println("Added hospitalization");


		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

}
