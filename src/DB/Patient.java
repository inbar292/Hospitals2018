package DB;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import Model.PersonHandler;
import utils.E_BloodType;
import utils.E_Gender;

public class Patient extends Person{

	public Patient(String iD, String firstName, String surName, Date dateOfBirth, String city, String street,
			E_Gender gender, String phone, E_BloodType bloodtype, String careFacility, String contactID) {
		
		super(iD, firstName, surName, dateOfBirth, city, street, gender, phone, bloodtype, careFacility, contactID);
		
	}
	
	public Patient(String string, String string2, String string3) {
		super(string, string2, string3);
	}

	public Patient(String id, String firstN, String lastN, String phone) {
		super(id, firstN, lastN, phone);
	}

	public boolean getPatient(boolean upload) {
		boolean found = false;
		ResultSet rs;
		String msg = "select * from tblPatient where id=" + this.getID();
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
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return found;
	}
	
	public static ArrayList<Patient> getPatients() {
		ArrayList<Patient> retrieved = new ArrayList<>();
		ResultSet rs= null;
		CallableStatement cstmt = null;
		try {
			cstmt = DBconn.conn.prepareCall("{call getPatients}");
			cstmt.execute();
			rs = cstmt.getResultSet();
	
			while (rs.next())
				retrieved.add(new Patient(rs.getString("patientID"), rs.getString("firstName"), rs.getString("surName"), 
						rs.getDate("dateOfBirth"), rs.getString("city"), rs.getString("street"),
						utils.E_Gender.valueOf(rs.getString("gender")), rs.getString("phone"), utils.E_BloodType.valueOf(rs.getString("bloodType")),
						rs.getString("careFacility"), rs.getString("contactID")));
			    
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
	}

	public void addPatient(boolean b) {

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
				System.out.println("added person");
			}

			cstmt = DBconn.conn.prepareCall("{call addPatient(" + this.getID().toString( )+ ")}");
			cstmt.execute();
			System.out.println("Added Patient");

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}

	}

	public void updatePatient() {
		try {

			PersonHandler.getInstance().updatePerson(this.getID(), this.getFirstName(), this.getSurName(),
					this.getDateOfBirth(), this.getCity(), this.getStreet(), this.getGender(), this.getPhone(),
					this.getBloodtype(), this.getCareFacility(), this.getContactID());

			System.out.println("Patient was edited");

		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

	public void deletePatient() {
		CallableStatement cstmt = null;
		try {
			

			cstmt = DBconn.conn.prepareCall("{call deletePatient(" 
			+ this.getID().toString() + ")}");
			
			cstmt.execute();

			System.out.println("delete Patient");

		} catch (Exception e) {

			System.out.print(e.getMessage());
		}

	}
	
	public static ArrayList<Patient> getQ1b(){
		ArrayList<Patient> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {
			
			cstmt = DBconn.conn.prepareCall("{call q1b}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			
			while (rs.next())
				retrieved.add(new Patient(rs.getString("ID"),
						rs.getString("firstName"), rs.getString("surName")));
			
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
		
	}
	public static ArrayList<Patient> getQ8(){
		ArrayList<Patient> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {
			
			cstmt = DBconn.conn.prepareCall("{call q8}");
			cstmt.execute();
			rs = cstmt.getResultSet();
			
			while (rs.next())
				retrieved.add(new Patient(rs.getString("ID"), rs.getString("firstName"), rs.getString("surName"), 
						rs.getDate("dateOfBirth"), rs.getString("city"), rs.getString("street"),
						utils.E_Gender.valueOf(rs.getString("gender")), rs.getString("phone"), utils.E_BloodType.valueOf(rs.getString("bloodType")),
						rs.getString("careFacility"), rs.getString("contactID")));
			
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
		
	}
	public static ArrayList<Patient> getQ11(String s){
		ArrayList<Patient> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {
			
			cstmt = DBconn.conn.prepareCall("{call q11("+s+")}");
			cstmt.execute();
			
			rs = cstmt.getResultSet();
			while (rs.next())
				retrieved.add(new Patient(rs.getString("patientID"), rs.getString("firstName"), rs.getString("surName"), 
						rs.getString("phone")));
			
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
		
	}

}
