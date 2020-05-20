package Model;

import java.sql.Date;
import java.util.ArrayList;

import DB.Patient;
import DB.Person;
import utils.E_BloodType;
import utils.E_Gender;

public class PatientHandler {
	
	 /*singleton instance*/
    private static PatientHandler instance;
   
    /**
     * Retrieves the singleton instance of conteollerLogic
     * return singleton instance
     */
    public static PatientHandler getInstance(){
        if(instance==null)
            instance=new  PatientHandler();
        return instance;
    }

	
	public boolean insertPatient(String iD, String firstName, String surName, Date dateOfBirth, String city, String street,
			E_Gender gender, String phone, E_BloodType bloodtype, String careFacility, String contactID) {
		
		Patient p= new Patient(iD, firstName, surName, dateOfBirth, city, street, gender, phone, bloodtype, careFacility, contactID);
		System.out.println(p.toString());
		
		boolean bool = true;
		for(Person pe : PersonHandler.getInstance().refreshPerson()) {
			if(pe.getID().equals(iD))
				bool = false;
		}
		p.addPatient(bool);
		return true;

	}
	public boolean updatePatient(String iD, String firstName, String surName, Date dateOfBirth, String city, String street,
			E_Gender gender, String phone, E_BloodType bloodtype, String careFacility, String contactID) {
		
		Patient p= new Patient(iD, firstName, surName, dateOfBirth, city, street, gender, phone, bloodtype, careFacility, contactID);
		p.updatePatient();
		return true;
		

	}
	public boolean deletePatient(String id) {
		ArrayList<Patient> rs = Patient.getPatients();
		for(Patient p: rs) {
			
			if(p.getID().equals(id)) {
				
				p.deletePatient();
				return true;
			}
				
		}	
		return false;


	}
	public ArrayList<Patient> refreshPatient(){
		ArrayList<Patient> rs = Patient.getPatients();
		return rs;

	}
	
	public Patient getSpecificPatient(String id) {
		
	ArrayList<Patient> pa= Patient.getPatients();
		
		for(Patient p: pa) {
			
			if(p.getID().equals(id))
				return p;
		}
		
		return null;
		
	}

	public ArrayList<Patient> q1b() {

		ArrayList<Patient> pat = Patient.getQ1b();
		return pat;

	}
	public ArrayList<Patient> q8() {

		ArrayList<Patient> pat = Patient.getQ8();
		return pat;

	}
	
	public ArrayList<Patient> q11(String s) {

		ArrayList<Patient> pat = Patient.getQ11(s);
		return pat;

	}
}
