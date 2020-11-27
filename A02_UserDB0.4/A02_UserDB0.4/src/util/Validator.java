package util;

public class Validator {

	public static boolean validateEMail(String text) {
		
		return text.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$");

	}
	
	public static boolean validateLength(String text, int min, int max) {
		if(text.length() >= min && text.length() <=max) 
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		//System.out.println(validateEMail("micha.schirmer@gmail.com"));
		System.out.println(validateLength("micha.schirmer@gmail.com",6,50));
	}

}
