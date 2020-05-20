package Model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import DB.CheckedBy;
import DB.Doctor;
import DB.Hospitalized;
import DB.WorksInShift;

public class CheckUpHandler {
	
	/* singleton instance */
	private static CheckUpHandler instance;
	
	/**
	 * Retrieves the singleton instance of conteollerLogic return singleton instance
	 */
	public static CheckUpHandler getInstance() {
		if (instance == null)
			instance = new CheckUpHandler();
		return instance;
	}

	
	public ArrayList<CheckedBy> refreshCheckUps() {

		ArrayList<CheckedBy> rs = CheckedBy.getCheckUps();
		return rs;

	}
	
	public boolean insertCheckUp(String patientID, int eventCode, String doctorID, int shiftNumber, Date checkTime, double bodyTemp,
			String bloodPressure) {

		CheckedBy cb = new CheckedBy(patientID, eventCode, doctorID, shiftNumber, checkTime, bodyTemp, bloodPressure);

		int hosID = 0, depID = 0, dayW = 0;
		HospitalizationHandler h = HospitalizationHandler.getInstance();
		for(Hospitalized hos : h.refreshHospitalizations()) { //find details of hospitalization:
			if(hos.getPatientID().equals(patientID) && hos.getEventCode()==eventCode) {
				hosID = hos.getHospitalID();
				depID = hos.getDepartmentID();
			}
		}
		
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(checkTime.getTime());
		dayW = c.get(Calendar.DAY_OF_WEEK);
		
		Doctor doc = null; //the doctor doing the check up
		for(Doctor d : DoctorHandler.getInstance().refreshDoctor()) {
			if(d.getID().equals(doctorID)) 
				doc = d;
		}
		
		if(doc != null && hosID == doc.getHospitalID() && depID == doc.getDepartmentID()) { //the doc works in the department that is in the hospital
			for(WorksInShift ws : DoctorHandler.getInstance().refreshShifts()) {
				if(ws.getDoctorID().equals(doctorID)) {
					if(ws.getShiftNumber()%2==0) { //the doc works in a shift on a day the patient is hospitalized
						if(ws.getShiftNumber()/2==dayW) {
							cb.addCheckUp();
							return true;
						}
					}else {
						if((ws.getShiftNumber()+1)/2==dayW) { //the doc works in a shift on a day the patient is hospitalized
							cb.addCheckUp();
							return true;
						}
					}
				}
			}	
		}
		return false;
	}
}
