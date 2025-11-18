package LearnJava;

public class ArmstrongNumber {
	
	boolean isArmstrongNumber(int input) {
		int n = String.valueOf(input).length();
		int sum = 0;
		int temp_input = input;
		int temp_digit;
		
		if (input == 0) {
			return true;
		}
		else if (input < 0) {
			return false;
		}
		else {
			for(int i=1; i< n; i++) {
				temp_digit = (int) (temp_input % 10);
				sum += Math.pow(temp_digit, n);
				temp_input = (int) (temp_input / 10);
			}
			sum += Math.pow(temp_input, n);
			
			return (sum == input) ? true : false;
		}
		
	
	}
	
	public static void main(String args[]) {
		ArmstrongNumber an = new ArmstrongNumber();
		System.out.println(an.isArmstrongNumber(0));
		System.out.println(an.isArmstrongNumber(153));
		System.out.println(an.isArmstrongNumber(154));
	}

}
