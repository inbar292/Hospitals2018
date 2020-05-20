package DB;

public class MedicalEventTypes {

	private int identity;
	private String typeName;

	public MedicalEventTypes(int identity, String typeName) {
		super();
		this.identity = identity;
		this.typeName = typeName;
	}

	public int getIdentity() {
		return identity;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + identity;
		result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
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
		MedicalEventTypes other = (MedicalEventTypes) obj;
		if (identity != other.identity)
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MedicalEventTypeInDepartment [identity=" + identity + ", typeName=" + typeName + "]";
	}

}
