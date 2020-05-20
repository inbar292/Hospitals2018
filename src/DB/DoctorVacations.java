package DB;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DoctorVacations {
	
	private String doctorID;
	private Date vacationDate;
	private String fname;
	private String sname;
	
	public DoctorVacations(String doctorID, Date vacationDate, String fname, String sname) {
		super();
		this.doctorID = doctorID;
		this.vacationDate = vacationDate;
		this.fname=fname;
		this.sname=sname;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}

	public Date getVacationDate() {
		return vacationDate;
	}

	public void setVacationDate(Date vacationDate) {
		this.vacationDate = vacationDate;
	}
	

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doctorID == null) ? 0 : doctorID.hashCode());
		result = prime * result + ((vacationDate == null) ? 0 : vacationDate.hashCode());
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
		DoctorVacations other = (DoctorVacations) obj;
		if (doctorID == null) {
			if (other.doctorID != null)
				return false;
		} else if (!doctorID.equals(other.doctorID))
			return false;
		if (vacationDate == null) {
			if (other.vacationDate != null)
				return false;
		} else if (!vacationDate.equals(other.vacationDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DoctorVacations [doctorID=" + doctorID + ", vacationDate=" + vacationDate + "]";
	}
	public static ArrayList<DoctorVacations> getVacations(){
		
		ArrayList<DoctorVacations> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {

			cstmt = DBconn.conn.prepareCall("{call getAllVacations}");
			cstmt.execute();
			rs = cstmt.getResultSet();

			while (rs.next())
				retrieved.add(new DoctorVacations(rs.getString("doctorID"), rs.getDate("vacationDate"), rs.getString("firstName"),
						rs.getString("surName")));

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
	}
	
	public ArrayList<DoctorVacations> getVacationsByDate(){
		ArrayList<DoctorVacations> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {
			
			cstmt = DBconn.conn.prepareCall("{call getDateVacation('" + this.getVacationDate().toString() + "')}");
			cstmt.execute();
			rs = cstmt.getResultSet();

			while (rs.next())
				retrieved.add(new DoctorVacations(rs.getString("doctorID"), rs.getDate("vacationDate"), rs.getString("firstName"),
						rs.getString("surName")));

		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
		return retrieved;
	
	}
	
	public void addVacation() {
		CallableStatement cstmt = null;
		try {
			
			cstmt = DBconn.conn.prepareCall("{call addDocVacation(" + this.getDoctorID().toString() +",'"+ this.getVacationDate().toString()+"')}");
			cstmt.execute();
			
			System.out.println("add Vacation");

		} catch (Exception e) {

			System.out.print(e.getMessage());
		}

	}
	
	
	public static ArrayList<DoctorVacations> getOccupiedDoctors(){
		ArrayList<DoctorVacations> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {
			
			cstmt = DBconn.conn.prepareCall("{call q4}");
			cstmt.execute();
			rs = cstmt.getResultSet();

			while (rs.next())
				retrieved.add(new DoctorVacations(rs.getString("name"), null,rs.getString("doctorID"), rs.getString("FullName")));

		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
		
		return retrieved;
	
	}
	

}
