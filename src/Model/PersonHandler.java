package Model;

import java.sql.Date;
import java.util.ArrayList;

import DB.Person;
import utils.E_BloodType;
import utils.E_Gender;

public class PersonHandler {

	/* singleton instance */
	private static PersonHandler instance;

	public static PersonHandler getInstance() {
		if (instance == null)
			instance = new PersonHandler();
		return instance;
	}

	public boolean insertPerson(String iD, String firstName, String surName, Date dateOfBirth, String city,
			String street, E_Gender gender, String phone, E_BloodType bloodtype, String careFacility,
			String contactID) {

		Person p = new Person(iD, firstName, surName, dateOfBirth, city, street, gender, phone, bloodtype, careFacility,
				contactID);
		p.toString();
		
		p.addPerson();
		return true;

	}

	public boolean updatePerson(String iD, String firstName, String surName, Date dateOfBirth, String city,
			String street, E_Gender gender, String phone, E_BloodType bloodtype, String careFacility,
			String contactID) {

		Person p = new Person(iD, firstName, surName, dateOfBirth, city, street, gender, phone, bloodtype, careFacility,
				contactID);
		System.out.println(p.toString());
		p.updatePerson();
		return true;

	}

	public boolean deletePerson(String id) {
		ArrayList<Person> per = Person.getPersons();
		for (Person p : per) {

			if (p.getID().equals(id))
				p.deletePerson();
			return true;
		}
		return false;

	}

	public ArrayList<Person> refreshPerson() {

		ArrayList<Person> per = Person.getPersons();
		return per;

	}

	public Person getSpecificPerson(String id) {

		ArrayList<Person> per = Person.getPersons();

		for (Person p : per) {

			if (p.getID().equals(id))
				return p;
		}

		return null;

	}

}
