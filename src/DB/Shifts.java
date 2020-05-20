package DB;

public class Shifts {

	private int shiftNumber;
	private String dayInWeek;
	private String shiftType;

	public Shifts(int shiftNumber, String dayInWeek, String shiftType) {
		super();
		this.shiftNumber = shiftNumber;
		this.dayInWeek = dayInWeek;
		this.shiftType = shiftType;
	}

	public int getShiftNumber() {
		return shiftNumber;
	}

	public void setShiftNumber(int shiftNumber) {
		this.shiftNumber = shiftNumber;
	}

	public String getDayInWeek() {
		return dayInWeek;
	}

	public void setDayInWeek(String dayInWeek) {
		this.dayInWeek = dayInWeek;
	}

	public String getShiftType() {
		return shiftType;
	}

	public void setShiftType(String shiftType) {
		this.shiftType = shiftType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + shiftNumber;
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
		Shifts other = (Shifts) obj;
		if (shiftNumber != other.shiftNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Shifts [shiftNumber=" + shiftNumber + ", dayInWeek=" + dayInWeek + ", shiftType=" + shiftType + "]";
	}

}
