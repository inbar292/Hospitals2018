package Model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import DB.Department;
import DB.Hospitalized;
import DB.MedicalEvent;
import DB.MedicalEventTypeInDepartment;
import DB.Room;

public class HospitalizationHandler {
	
	/* singleton instance */
	private static HospitalizationHandler instance;

	/**
	 * Retrieves the singleton instance of conteollerLogic return singleton instance
	 */
	public static HospitalizationHandler getInstance() {
		if (instance == null)
			instance = new HospitalizationHandler();
		return instance;
	}
	
	public boolean insertHospitalization(ArrayList<Hospitalized> lis
			/*String patientID, int eventCode, int numberOfDays, Date dateOfArrival, int severityLevel, int hospitalID, int departmentID, int roomNumber*/) throws ParseException {

		Hospitalized max_hos = null;
		if(lis.size()==1) {
			max_hos = lis.get(0);
		}
		else {
			//find max severity level		
			int max=0;
			for(Hospitalized h: lis) {
				if(h.getSeverityLevel()>max) {
					max=h.getSeverityLevel();
					max_hos = h;
				}
			}
		}
		int depID = 0, roomID = 0;
		
		for(Department d : RoomHandler.getInstance().refreshDepartment()) {
			if(d.getHospitalID()==max_hos.getHospitalID()) { //find deps in hospital
				for(MedicalEventTypeInDepartment mt : Hospitalized.getMedicalEventTypeInDepartment()) {
					if(d.getDepartmentID()==mt.getDepartmentID() && d.getHospitalID()==mt.getHospitalID()) { //deps that treat the type of event
						if(checkCapacity(d.getHospitalID(), d.getDepartmentID())) { //there is enough space in dep
							for(Room r : RoomHandler.getInstance().refreshRoom()) {//assign room
								if(r.getDepartmentID() == d.getDepartmentID() && r.getHospitalID()==d.getHospitalID()) {
									depID = d.getDepartmentID();
									roomID = r.getRoomNum();
									break;
								}
							}
						}
					}
				}
			}
		}
		if(depID==0 && roomID==0) //no room available
			return false;
		
		for(Hospitalized h : lis) {
			h.setDepartmentID(depID);
			h.setRoomNumber(roomID);
			h.addHospitalization();
		}
		return true;

	}
	
	private static boolean checkCapacity (int hosID, int depID) throws ParseException {
		//how many beds are in the dep
		int sumBed=0;
		for(Department d: RoomHandler.getInstance().refreshDepartment()) {
			if(d.getHospitalID()==hosID && d.getDepartmentID()==depID) {
				for(Room r:RoomHandler.getInstance().refreshRoom()) {
					sumBed+=r.getBedsAmount();
				}
			}
		}
		
		//count how many people are hospitalized in the department
		HashMap<String, Hospitalized> lis = new HashMap<>();
		for(Hospitalized h : Hospitalized.getHospitalizations()) {
			String dt = h.getDateOfArrival().toString();  // Start date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(dt));
			c.add(Calendar.DATE, h.getNumberOfDays());  // number of days to add
			dt = sdf.format(c.getTime());  // dt is now the new date
			Date endD = java.sql.Date.valueOf(dt);
			
			java.util.Date date=new java.util.Date();  
			
			if((h.getDateOfArrival().before(date) && date.before(endD))|| date.equals(h.getDateOfArrival()) ||date.equals(endD)) {
				lis.put(h.getPatientID(), h);
			}
		}
		if(lis.size()<sumBed+10)
			return true;
		return false;
	}
	
	public ArrayList<Hospitalized> refreshHospitalizations() {

		ArrayList<Hospitalized> rs = Hospitalized.getHospitalizations();
		return rs;

	}
	
	public ArrayList<MedicalEvent> refreshMedicalEvent (){
		ArrayList<MedicalEvent> rs = Hospitalized.getMedicalEvents();
		return rs;
	}
/*
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
*/
}
