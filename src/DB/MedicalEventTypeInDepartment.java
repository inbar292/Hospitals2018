package DB;

public class MedicalEventTypeInDepartment {

	private int hospitalID;
	private int departmentID;
	private int typeCode;
	
	public MedicalEventTypeInDepartment(int hospitalID, int departmentID, int typeCode) {
		this.hospitalID = hospitalID;
		this.departmentID = departmentID;
		this.typeCode = typeCode;
	}

	/**
	 * @return the hospitalID
	 */
	public int getHospitalID() {
		return hospitalID;
	}

	/**
	 * @param hospitalID the hospitalID to set
	 */
	protected void setHospitalID(int hospitalID) {
		this.hospitalID = hospitalID;
	}

	/**
	 * @return the departmentID
	 */
	public int getDepartmentID() {
		return departmentID;
	}

	/**
	 * @param departmentID the departmentID to set
	 */
	protected void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}

	/**
	 * @return the typeCode
	 */
	protected int getTypeCode() {
		return typeCode;
	}

	/**
	 * @param typeCode the typeCode to set
	 */
	protected void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
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
		result = prime * result + typeCode;
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
		if (!(obj instanceof MedicalEventTypeInDepartment))
			return false;
		MedicalEventTypeInDepartment other = (MedicalEventTypeInDepartment) obj;
		if (departmentID != other.departmentID)
			return false;
		if (hospitalID != other.hospitalID)
			return false;
		if (typeCode != other.typeCode)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MedicalEventTypeInDepartment [hospitalID=" + hospitalID + ", departmentID=" + departmentID
				+ ", typeCode=" + typeCode + "]";
	}
	
	
	
}
