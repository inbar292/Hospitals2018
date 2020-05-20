package Model;

import java.util.ArrayList;

import DB.Department;
import DB.Hospital;
import DB.Paymentes;
import DB.Room;

public class RoomHandler {

	/*singleton instance*/
	private static RoomHandler instance;

	/**
	 * Retrieves the singleton instance of conteollerLogic
	 * return singleton instance
	 */
	public static RoomHandler getInstance(){
		if(instance==null)
			instance=new  RoomHandler();
		return instance;
	}

	public boolean insertRoom (int hospitalID, int departmentID, int roomNum, int bedsAmount) {
		Room r = new Room(hospitalID, departmentID, roomNum, bedsAmount);
		
		ArrayList<Department> dep = Department.getDepartments();
		
		for(Department d : dep) { //check to see if department in hospital exists
			if(d.getHospitalID() == hospitalID && d.getDepartmentID() == departmentID) {
				ArrayList<Room> rs = Room.getAllRooms();
				if(rs.add(r)) {
					if(r.addRoom())
						return true;
				}
			}
		}
		return false;		
	}
	
	public boolean updateRoom(int hospitalID, int departmentID, int roomNum, int bedsAmount) {
		
		Room r= new Room(hospitalID, departmentID, roomNum, bedsAmount);
		r.updateRoom();
		
		return true;		

	}
	public boolean deleteRoom(int hospitalID, int departmentID, int roomNum) {
		ArrayList<Room> rs = Room.getAllRooms();
		for(Room r: rs) {
			 if(r.getHospitalID()==hospitalID
					 && r.getDepartmentID()==departmentID
					 && r.getRoomNum()== roomNum) {
				 r.deleteRoom();
				 return true; 
			 }
		}	
		return false;

	}
	public ArrayList<Room> refreshRoom(){

		ArrayList<Room> rs = Room.getAllRooms();
		return rs;
	}
	
	public ArrayList<Department> refreshDepartment(){

		ArrayList<Department> rs = Department.getDepartments();
		return rs;
	}
	
	public ArrayList<Hospital> refreshHospital(){

		ArrayList<Hospital> rs = Hospital.getHospitals();
		return rs;
	}
	
	
	public Room getSpecificRoom(int hospitalID, int departmentID, int roomNum) {
		
		ArrayList<Room> per= Room.getAllRooms();
		
		for(Room r: per) {
			
			if(r.getHospitalID()==hospitalID && r.getDepartmentID()==departmentID && r.getRoomNum()==roomNum )
			return r; 
		}
		return null;
		

	}
	
	public ArrayList<Department> getDepartByHos(int hospitalID){
		
		Department d= new Department(hospitalID, 0, "", 0);
		ArrayList<Department> rs= d.getDepartmentsOfHospital(hospitalID);
		
		
		return rs;
	}
	
	public ArrayList<Hospital> getHospitalsStatistics(){

		ArrayList<Hospital> rs = Hospital.getHospitalsStatistics();
		return rs;
	}
	
	public ArrayList<Hospital>getQ6() {

		ArrayList<Hospital> rs = Hospital.getQ6();
		return rs;
	}
	
	public ArrayList<Hospital>  getMaxCapacity() {

		ArrayList<Hospital> rs = Hospital. getMaxCapacity();
		return rs;
	}
	
	
	public ArrayList<String> q3() {

		ArrayList<String> lis = Hospital.getQ3();
		return lis;

	}
	public ArrayList<String> q6() {

		ArrayList<String> lis = Hospital.getQ6b();
		return lis;

	}
	public ArrayList<String> q7a() {

		ArrayList<String> lis = Hospital.getQ7a();
		return lis;

	}
	public ArrayList<String> q7b() {

		ArrayList<String> lis = Hospital.getQ7b();
		return lis;

	}
	
	public ArrayList<String> q9() {

		ArrayList<String> lis = Hospital.getQ9();
		return lis;

	}
	
	public ArrayList<Paymentes> refreshPayment(){
		
		ArrayList<Paymentes> lis = Paymentes.getPayments();
		return lis;
	}
}
