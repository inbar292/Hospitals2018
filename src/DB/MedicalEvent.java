package DB;

public class MedicalEvent {

	private int eventCode;
	private String discription;
	private int typeCode;
	

	public MedicalEvent(int eventCode, String discription, int typeCode) {
		this.eventCode = eventCode;
		this.discription = discription;
		this.typeCode = typeCode;
	}

	

	/**
	 * @return the typeCode
	 */
	public int getTypeCode() {
		return typeCode;
	}



	/**
	 * @param typeCode the typeCode to set
	 */
	protected void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
	}



	public int getEventCode() {
		return eventCode;
	}

	public void setEventCode(int eventCode) {
		this.eventCode = eventCode;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + eventCode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalEvent other = (MedicalEvent) obj;
		if (eventCode != other.eventCode)
			return false;
		return true;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MedicalEvent [eventCode=" + eventCode + ", discription=" + discription + ", typeCode=" + typeCode + "]";
	}

	

}
