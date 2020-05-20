package DB;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Room {
	
	private int hospitalID;
	private int departmentID;
	private int roomNumber;
	private int bedsAmount;
	
	public Room(int hospitalID, int departmentID, int roomNum, int bedsAmount) {
		this.hospitalID = hospitalID;
		this.departmentID=departmentID;
		this.roomNumber=roomNum;
		this.bedsAmount=bedsAmount;
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


	public int getRoomNum() {
		return roomNumber;
	}

	public void setRoomNum(int roomNum) {
		this.roomNumber = roomNum;
	}

	public int getBedsAmount() {
		return bedsAmount;
	}

	public void setBedsAmount(int bedsAmount) {
		this.bedsAmount = bedsAmount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + departmentID;
		result = prime * result + hospitalID;
		result = prime * result + roomNumber;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Room))
			return false;
		Room other = (Room) obj;
		if (departmentID != other.departmentID)
			return false;
		if (hospitalID != other.hospitalID)
			return false;
		if (roomNumber != other.roomNumber)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Room [hospitalID=" + hospitalID + ", departmentID=" + departmentID + ", roomNum=" + roomNumber
				+ ", bedsAmount=" + bedsAmount + "]";
	}
	
	
	public boolean getRoom(boolean upload) {
		boolean found = false;
		ResultSet rs;
		String msg = "select * from tblRoom where hospitalID =" + hospitalID + "and departmentID =" +departmentID +
				"and roomNumber =" + roomNumber;
		try {
			rs = ((java.sql.Statement) DBconn.s).executeQuery(msg);
			if (rs.next()) {
				found = true;
				if (upload) {
					this.hospitalID = Integer.parseInt(rs.getString("hospitalID"));
					this.departmentID = Integer.parseInt(rs.getString("departmentID"));
					this.roomNumber = Integer.parseInt(rs.getString("roomNumber"));
					this.bedsAmount = Integer.parseInt(rs.getString("bedsAmount"));
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return found;
	}

	public static ArrayList<Room> getAllRooms() {
		ArrayList<Room> retrieved = new ArrayList<>();
		ResultSet rs= null;
		CallableStatement cstmt = null;
		try {
			cstmt = DBconn.conn.prepareCall("{call getAllRooms}");
			cstmt.execute();
			rs = cstmt.getResultSet();
	
			while (rs.next())
				retrieved.add(new Room(Integer.parseInt(rs.getString("hospitalID")), Integer.parseInt(rs.getString("departmentID")),
						Integer.parseInt(rs.getString("roomNumber")), Integer.parseInt(rs.getString("bedsAmount"))));
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return retrieved;
		
	}

	public boolean addRoom() {
		CallableStatement cstmt = null;
		try {
			cstmt = DBconn.conn.prepareCall("{call addRoom(" + this.hospitalID+ ","
					+ this.departmentID+ ","
					+ this.roomNumber + ","
					+this.bedsAmount
					+ ")}");
			
			if(cstmt.execute())
				return true;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return false;
	}

	public void updateRoom() {
		CallableStatement cstmt = null;

		try {
			cstmt = DBconn.conn.prepareCall("{call editRoom(" + this.getHospitalID() + "," + this.getDepartmentID() + ","
					+ this.roomNumber + "," + this.bedsAmount+ ")}");
			cstmt.execute();

			System.out.println("Room was edited");

		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

	public void deleteRoom() {
		CallableStatement cstmt = null;
		try {
			cstmt = DBconn.conn.prepareCall("{call deleteRoom(" 
			+ this.getHospitalID() + "," + this.getDepartmentID() + ","
			+ this.roomNumber + ")}");
			
			cstmt.execute();

			System.out.println("delete Room");

		} catch (Exception e) {

			System.out.print(e.getMessage());
		}
	}

}
