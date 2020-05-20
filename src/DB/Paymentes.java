package DB;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Paymentes {

	private int serialNumber;
	private int minDay;
	private int maxDate;
	private int amount;

	public Paymentes(int serialNumber, int minDay, int maxDate, int amount) {
		super();
		this.serialNumber = serialNumber;
		this.minDay = minDay;
		this.maxDate = maxDate;
		this.amount = amount;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getMinDay() {
		return minDay;
	}

	public void setMinDay(int minDay) {
		this.minDay = minDay;
	}

	public int getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(int maxDate) {
		this.maxDate = maxDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + serialNumber;
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
		Paymentes other = (Paymentes) obj;
		if (serialNumber != other.serialNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Paymentes [serialNumber=" + serialNumber + ", minDay=" + minDay + ", maxDate=" + maxDate + ", amount="
				+ amount + "]";
	}
	
	public static ArrayList<Paymentes> getPayments(){
		
		ArrayList<Paymentes> retrieved = new ArrayList<>();
		ResultSet rs = null;
		CallableStatement cstmt = null;
		try {

			cstmt = DBconn.conn.prepareCall("{call getPayment}");
			cstmt.execute();
			rs = cstmt.getResultSet();

			while (rs.next())
				retrieved.add(new Paymentes(Integer.parseInt(rs.getString("serialNumber")),
						Integer.parseInt(rs.getString("minDay")),
						Integer.parseInt(rs.getString("maxDay")),
						Integer.parseInt(rs.getString("amount")))
						);

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return retrieved;
	}

}
