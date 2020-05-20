package utils;

public enum E_BloodType {
	
	// -------------------------------------------------------------Values---------------------------------------------------------------------
	// types of blood
	
	O, A, B, AB;
	
	public String stringing(E_BloodType bt) {
		
		String re=null;
		
	if(bt==E_BloodType.A) re="A";
	else if(bt==E_BloodType.AB) re= "AB";
	else if (bt==E_BloodType.B) re= "B";
	else if (bt==E_BloodType.O) re= "O";
	
	return re;
		
	}
	
	public static E_BloodType type(String s) {
		
		switch (s) {
		case "A":return E_BloodType.A;
		case "B": return E_BloodType.B;
		case "AB": return E_BloodType.AB;
		case "O": return E_BloodType.O;
		
		default:
			return null;
		}
		
	}
	
}
