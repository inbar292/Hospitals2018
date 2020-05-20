package utils;

public enum E_CareFacility {
	
	// -------------------------------------------------------------Values---------------------------------------------------------------------
	// Values of careFacilities
	
	MEUCHEDET(1), CLALIT(2), MACABI(3), LEUMIT(4);
	
	private final int facility;
	
	E_CareFacility(int facility) {
		// TODO Auto-generated constructor stub
		
		this.facility=facility;
		
	}
	
	public int getFacility() {
		return facility;
	}
	
	public static E_CareFacility returnLevel(int val) {
		switch (val) {
		case 1:
			return E_CareFacility.MEUCHEDET;
		case 2:
			return E_CareFacility.CLALIT;
		case 3:
			return E_CareFacility.MACABI;
		case 4:
			return E_CareFacility.LEUMIT;
		default: return null; 
		}
	}
	
	
	

}
