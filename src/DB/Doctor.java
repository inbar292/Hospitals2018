package DB;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import Model.PersonHandler;
import Model.RoomHandler;
import utils.E_BloodType;
import utils.E_Gender;

public class Doctor extends Person {

	private Date dateOfGraduation;
	private boolean manager;
	private int hospitalID;
	private int departmentID;

	public Doctor(String iD, String firstName, String surName, Date dateOfBirth, String city, String street,
			E_Gender gender, String phone, E_BloodType bloodtype, String careFacility, String contactID,
			Date dateOfGraduation, boolean manager, int hospitalID, int departmentID) {

		super(iD, firstName, surName, dateOfBirth, city, street, gender, phone, bloodtype, careFacility, contactID);
		this.dateOfGraduation = dateOfGraduation;
		this.manager = manager;
		this.hospitalID = hospitalID;
		this.departmentID = departmentID;
	}
	
	public Doctor(String firstName, String surName) {
		super(firstName, surName);
		
	}
	
	public Doctor(String id, String fullName, String hospital) {
		super(id, fullName.split(" ")[0], fullName.split(" ")[1]);
		int hosID = 0;
		for(Hospital h : RoomHandler.getInstance().refreshHospital()) {
			if(h.getName().equals(hospital))
				hosID = h.getHospitalID();
		}
		this.hospitalID=hosID;
		
	}

	public Date getDateOfGraduation() {
		return dateOfGraduation;
	}

	public void setDateOfGraduation(Date dateOfGraduation) {
		this.dateOfGraduation = dateOfGraduation;
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public int getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(int hospitalID) {
		this.hospitalID = hospitalID;
	}

	public int getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	@Override
	public String toString() {
		return "Doctor [dateOfGraduation=" + dateOfGraduation + ", manager=" + manager + ", hospitalID=" + hospitalID
				+ ", departmentID=" + departmentID + "]";
	}

	public boolean getDoctor(boolean upload) {
		boolean found = false;
		ResultSet rs;
		String msg = "select * from tblDoctor where id=" + this.getID();
		try {
			rs = ((java.sql.Statement) DBconn.s).executeQuery(msg);
			if (rs.next()) {
				found = true;
				if (upload) {
					this.setID(rs.getString("id"));
					this.setFirstName(rs.getString("firstName"));
					this.setSurName(rs.getString("surName"));

					DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
					this.setDateOfBirth((Date) format.parse(rs.getString("dateOfBirth")));

					this.setCity(rs.getString("city"));
					this.setStreet(rs.getString("street"));
					this.setGender(utils.E_Gender.valueOf(rs.getString("gender")));
					this.setPhone(rs.getString("phone"));
					this.setBloodtype(utils.E_BloodType.valueOf(rs.getString("bloodType")));
					this.setCareFacility(rs.getString("careFacility"));
					this.setContactID(rs.getString("contactID"));

					this.dateOfGraduation = (Date) format.parse(rs.getString("dateOfGraduation"));
					this.manager = rs.getString("manager") != null;
					this.hospitalID = Integer.parseInt(rs.getString("hospitalID"));
					this.departmentID = Integer.parseInt(rs.getString("departmentID"));
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return found;
	}
	
	public static ArrayList<Doctor> getQ1a(){
		ArrayList<Doctor> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {
			
			cstmt = DBconn.conn.prepareCall("{call q1a}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			
			while (rs.next())
				retrieved.add(new Doctor(rs.getString("firstName"), rs.getString("surName")));
			
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
		
	}
	
	public static ArrayList<Doctor> getQ2(){
		ArrayList<Doctor> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {
			
			cstmt = DBconn.conn.prepareCall("{call q2}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			
			while (rs.next())
				
				retrieved.add(new Doctor(rs.getString("ID"), rs.getString("FullName"), rs.getString("name")));
			
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
		
	}
	
	public static ArrayList<String> getQ4(){
		ArrayList<String> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {
			
			cstmt = DBconn.conn.prepareCall("{call q4}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			
			while (rs.next())
				retrieved.add(rs.getString("name")+" " + rs.getString("doctorID")+" "+rs.getString("FullName"));
			
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
	}
	
	public static ArrayList<String> getQ5(){
		ArrayList<String> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {
			
			cstmt = DBconn.conn.prepareCall("{call q5}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			
			while (rs.next())
				retrieved.add(rs.getString("ID")+" " + rs.getString("fullName")+" "+rs.getString("checkTime")+" "+rs.getString("bloodPressure")
				+" "+rs.getString("bodyTemp"));
			
			
			
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
		
	}
	public static ArrayList<Doctor> getDoctors() {
		ArrayList<Doctor> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {

			cstmt = DBconn.conn.prepareCall("{call getDoctors}");
			cstmt.execute();
			rs = cstmt.getResultSet();

			while (rs.next())
				retrieved.add(new Doctor(rs.getString("doctorID"), rs.getString("firstName"), rs.getString("surName"),
						rs.getDate("dateOfBirth"), rs.getString("city"), rs.getString("street"),
						utils.E_Gender.valueOf(rs.getString("gender")), rs.getString("phone"),
						utils.E_BloodType.valueOf(rs.getString("bloodType")), rs.getString("careFacility"),
						rs.getString("contactID"), rs.getDate("dateOfGraduation"), isManager(rs.getString("manager")),
						Integer.parseInt(rs.getString("hospitalID")), Integer.parseInt(rs.getString("departmentID"))));

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
	}

	public static boolean isManager(String is) {

		if (is.equals("1"))
			return true;
		else
			return false;
	}

	public void addDoctor(boolean b) {

		CallableStatement cstmt = null;

		try {
			if(b) { //need to insert person as well
				cstmt = DBconn.conn.prepareCall("{call addPerson(" 
						+ this.getID() + "," 
						+ this.getFirstName()+ ","
						+ this.getSurName()+ ",'" 
						+ this.getDateOfBirth().toString()+ "'," 
						+ this.getCity()+ "," 
						+ this.getStreet()+ "," 
						+ this.getGender().toString()+ "," 
						+ this.getPhone() + ","
						+ this.getBloodtype().toString()+ "," 
						+ this.getCareFacility() + "," 
						+ this.getContactID()+ ")}");

				cstmt.execute();
			}

			cstmt = DBconn.conn
					.prepareCall("{call addDoctor(" + this.getID().toString() + ",'" + this.dateOfGraduation.toString()
					+ "'," + this.isManager() + "," + this.hospitalID + "," + this.departmentID + ")}");
			cstmt.execute();
			

			System.out.println("Added Doctor");

		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

	public void updateDoctor() {

		CallableStatement cstmt = null;

		try {

			PersonHandler.getInstance().updatePerson(this.getID(), this.getFirstName(), this.getSurName(),
					this.getDateOfBirth(), this.getCity(), this.getStreet(), this.getGender(), this.getPhone(),
					this.getBloodtype(), this.getCareFacility(), this.getContactID());
						

			cstmt = DBconn.conn.prepareCall("{call editDoctor(" + this.getID().toString() + "," + this.isManager() + ","
					+ this.hospitalID + "," + this.departmentID + ")}");
			cstmt.execute();

			System.out.println("Doctor was edited");

		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

	public void deleteDoctor() {
		CallableStatement cstmt = null;
		try {
			
			cstmt = DBconn.conn.prepareCall("{call deleteDoctor(" + this.getID().toString() + ")}");
			cstmt.execute();
			cstmt = DBconn.conn.prepareCall("{call deletePerson(" + this.getID().toString() + ")}");
			cstmt.execute();
			System.out.println("delete Doctor");

		} catch (Exception e) {

			System.out.print(e.getMessage());
		}

	}

}
