package DB;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import DB.DBconn;
import utils.E_BloodType;
import utils.E_Gender;

public class Person {

	private String ID;
	private String firstName;
	private String surName;
	private Date dateOfBirth;
	private String city;
	private String street;
	private E_Gender gender;
	private String phone;
	private E_BloodType bloodtype;
	private String careFacility;
	private String contactID;

	public Person(String iD, String firstName, String surName, Date dateOfBirth, String city, String street,
			E_Gender gender, String phone, E_BloodType bloodtype, String careFacility, String contactID) {
		super();
		ID = iD;
		this.firstName = firstName;
		this.surName = surName;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.street = street;
		this.gender = gender;
		this.phone = phone;
		this.bloodtype = bloodtype;
		this.careFacility = careFacility;
		this.contactID = contactID;
	}

	public Person(String firstName, String surName) {
		this.firstName = firstName;
		this.surName = surName;

	}

	public Person(String id, String firstN, String lastN) {
		this.ID =id;
		this.firstName = firstN;
		this.surName = lastN;
	}


	public Person(String id, String firstN, String lastN, String phone) {
		this.ID=id;
		this.firstName = firstN;
		this.surName = lastN;
		this.phone= phone;
		
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public E_Gender getGender() {
		return gender;
	}

	public void setGender(E_Gender gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public E_BloodType getBloodtype() {
		return bloodtype;
	}

	public void setBloodtype(E_BloodType bloodtype) {
		this.bloodtype = bloodtype;
	}

	public String getCareFacility() {
		return careFacility;
	}

	public void setCareFacility(String careFacility) {
		this.careFacility = careFacility;
	}

	public String getContactID() {
		return contactID;
	}

	public void setContactID(String contactID) {
		this.contactID = contactID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
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
		Person other = (Person) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [ID=" + ID + ", FirstName=" + firstName + ", SurName=" + surName + ", dateOfBirth=" + dateOfBirth
				+ ", city=" + city + ", street=" + street + ", gender=" + gender + ", phone=" + phone + ", bloodtype="
				+ bloodtype + ", careFacility=" + careFacility + ", contactID=" + contactID + "]";
	}

	public boolean getPerson(boolean upload) {
		boolean found = false;
		ResultSet rs;
		String msg = "select * from tblPerson where id=" + ID;
		try {
			rs = ((java.sql.Statement) DBconn.s).executeQuery(msg);
			if (rs.next()) {
				found = true;
				if (upload) {
					ID = rs.getString("id");
					firstName = rs.getString("firstName");
					surName = rs.getString("surName");

					DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
					dateOfBirth = (Date) format.parse(rs.getString("dateOfBirth"));

					city = rs.getString("city");
					street = rs.getString("street");
					gender = utils.E_Gender.valueOf(rs.getString("gender"));
					phone = rs.getString("phone");
					bloodtype = utils.E_BloodType.valueOf(rs.getString("bloodType"));
					careFacility = rs.getString("careFacility");
					contactID = rs.getString("contactID");
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return found;
	}

	public static ArrayList<Person> getPersons() {
		ArrayList<Person> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {

			cstmt = DBconn.conn.prepareCall("{call getPeople}");
			cstmt.execute();
			rs = cstmt.getResultSet();

			while (rs.next())
				retrieved.add(new Person(rs.getString("ID"), rs.getString("firstName"), rs.getString("surName"),
						rs.getDate("dateOfBirth"), rs.getString("city"), rs.getString("street"),
						utils.E_Gender.valueOf(rs.getString("gender")), rs.getString("phone"),
						utils.E_BloodType.valueOf(rs.getString("bloodType")), rs.getString("careFacility"), rs.getString("contactID")));

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
	}

	public void addPerson() {

		this.toString();

		CallableStatement cstmt = null;
		try {
			cstmt = DBconn.conn.prepareCall("{call addPerson(" + this.ID.toString() + "," + this.firstName.toString()
					+ "," + this.surName.toString() + ",'" + this.dateOfBirth.toString() + "'," + this.city.toString()
					+ "," + this.street.toString() + "," + this.gender.toString() + "," + this.phone.toString() + ","
					+ this.bloodtype.toString() + "," + this.careFacility.toString() + "," + this.contactID.toString()
					+ ")}");

			cstmt.execute();

			System.out.println("Person Added");

		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

	public void updatePerson() {

		CallableStatement cstmt = null;

		try {
			
			System.out.println(this.phone);

			cstmt = DBconn.conn.prepareCall("{call editPerson(" + this.ID.toString() + "," + this.firstName.toString()
					+ "," + this.surName.toString() + "," + this.city.toString() + ","+ this.street.toString() + ","
					+ this.gender.toString() + "," +this.phone.toString() + "," + this.careFacility.toString() + ","
					+ this.contactID.toString() + ")}");

			cstmt.execute();

			System.out.println("update Person");

		} catch (Exception e) {

			System.out.print(e.getMessage());
		}

	}

	public void deletePerson() {
		String msg = String.format("DELETE FROM tblPerson WHERE (ID=%s)", ID);
		try {
			((Statement) DBconn.s).execute(msg);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public static boolean isManager(String is) {

		if (is.equals("1"))
			return true;
		else
			return false;
	}
}
