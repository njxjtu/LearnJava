package LearnJava.stringManipulation;

public class StringManipulation {
	
	//Convert the first letter of a string to uppercase
	String initialCap(String input) {
		if(input.length()==0 || input == null) {
			return input;
		}
		if(input.length()==1) {
			return input.toUpperCase();
		}
		return input.substring(0, 1).toUpperCase() + input.substring(1);
	}
	
	public static void main(String args[]) {
		StringManipulation sm = new StringManipulation();
		System.out.println(sm.initialCap("how is your day?"));
		System.out.println(sm.initialCap(""));
	}

}
