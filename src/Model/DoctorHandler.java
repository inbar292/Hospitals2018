package Model;

import java.sql.Date;
import java.util.ArrayList;

import DB.Doctor;
import DB.DoctorVacations;
import DB.Person;
import DB.WorksInShift;
import utils.E_BloodType;
import utils.E_Gender;

public class DoctorHandler {

	/* singleton instance */
	private static DoctorHandler instance;

	/**
	 * Retrieves the singleton instance of conteollerLogic return singleton instance
	 */
	public static DoctorHandler getInstance() {
		if (instance == null)
			instance = new DoctorHandler();
		return instance;
	}

	public boolean insertDoctor(String iD, String firstName, String surName, Date dateOfBirth, String city,
			String street, E_Gender gender, String phone, E_BloodType bloodtype, String careFacility, String contactID,
			Date dateOfGraduation, boolean manager, int hospitalID, int departmentID) {

		Doctor d = new Doctor(iD, firstName, surName, dateOfBirth, city, street, gender, phone, bloodtype, careFacility,
				contactID, dateOfGraduation, manager, hospitalID, departmentID);

		boolean bool = true;
		for(Person pe : PersonHandler.getInstance().refreshPerson()) {
			if(pe.getID().equals(iD))
				bool = false;
		}
		d.addDoctor(bool);
		return true;

	}

	public boolean updateDoctor(String iD, String firstName, String surName, Date dateOfBirth, String city,
			String street, E_Gender gender, String phone, E_BloodType bloodtype, String careFacility, String contactID,
			Date dateOfGraduation, boolean manager, int hospitalID, int departmentID) {

		Doctor d = new Doctor(iD, firstName, surName, dateOfBirth, city, street, gender, phone, bloodtype, careFacility,
				contactID, dateOfGraduation, manager, hospitalID, departmentID);
		d.updateDoctor();
		return true;

	}

	public boolean deleteDoctor(String id) {

		ArrayList<Doctor> rs = Doctor.getDoctors();
		for (Doctor d : rs) {

			if (d.getID().equals(id)) {
				d.deleteDoctor();
				return true;
			}

		}

		return false;

	}

	public ArrayList<Doctor> refreshDoctor() {

		ArrayList<Doctor> rs = Doctor.getDoctors();
		return rs;

	}

	public Doctor getSpecificDoctor(String id) {

		ArrayList<Doctor> doc = Doctor.getDoctors();

		for (Doctor d : doc) {

			if (d.getID().equals(id))
				d.toString();
			return d;
		}

		return null;

	}
	public ArrayList<Doctor> q1a() {
		
		ArrayList<Doctor> doc = Doctor.getQ1a();
		return doc;

	}
	public ArrayList<Doctor> q2() {

		ArrayList<Doctor> doc = Doctor.getQ2();
		return doc;

	}
	public ArrayList<String> q4() {

		ArrayList<String> lis = Doctor.getQ4();
		return lis;

	}

	public ArrayList<String> q5() {

		ArrayList<String> lis = Doctor.getQ5();
		return lis;

	}

	public void addVacation(Date d, String string) {
		// TODO Auto-generated method stub
		
		DoctorVacations dv= new DoctorVacations(string, d, "", "");
		dv.addVacation();
		
		
	}

	public ArrayList<DoctorVacations> getAllVacations() {
		// TODO Auto-generated method stub
		
		ArrayList<DoctorVacations> lis = DoctorVacations.getVacations();
		
		return lis;
	}

	public ArrayList<DoctorVacations> getVacationsByDat(Date d) {
		// TODO Auto-generated method stub
		ArrayList<DoctorVacations> lis = DoctorVacations.getVacations();
		
		ArrayList<DoctorVacations> newLis= new ArrayList<>();
		
		for(DoctorVacations dv: lis) {
			
			if(d.equals(dv.getVacationDate())) newLis.add(dv);
		}
		
		return newLis;
	}

	public ArrayList<String> getOccupiedDoctors() {
		// TODO Auto-generated method stub

		ArrayList<String> lis = Doctor.getQ4();
		return lis;
	}
	
	public ArrayList<WorksInShift> refreshShifts() {

		ArrayList<WorksInShift> rs = WorksInShift.getShifts();
		return rs;

	}

}
