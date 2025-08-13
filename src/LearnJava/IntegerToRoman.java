package LearnJava;

public class IntegerToRoman {
	
    public String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        //
        for(int i=1;i<=num/1000;i++) {
        	str.append("M");
        }
        //
        if(num%1000/100==9) {
        	str.append("CM");
        }
        else if(num%1000/100==5) {
        	str.append("D");
        }
        else if(num%1000/100==4) {
        	str.append("CD");
        }
        else if(num%1000/100>5) {
        	str.append("D");
        	for(int i=1;i<=num%1000/100-5;i++) {
        		str.append("C");
        	}
        }
        else if(num%1000/100<4) {
        	for(int i=1;i<=num%1000/100;i++) {
        		str.append("C");
        	}
        }
        //
        if(num%100/10==9) {
        	str.append("XC");
        }
        else if(num%100/10==5) {
        	str.append("L");
        }
        else if(num%100/10==4) {
        	str.append("XL");
        }
        else if(num%100/10>5) {
        	str.append("L");
        	for(int i=1;i<=num%100/10-5;i++) {
        		str.append("X");
        	}
        }
        else if(num%100/10<4) {
        	for(int i=1;i<=num%100/10;i++) {
        		str.append("X");
        	}
        }
        //
        if(num%10==9) {
        	str.append("IX");
        }
        else if(num%10==5) {
        	str.append("V");
        }
        else if(num%10==4) {
        	str.append("IV");
        }
        else if(num%10>5) {
        	str.append("V");
        	for(int i=1;i<=num%10-5;i++) {
        		str.append("I");
        	}
        }
        else if(num%10<4) {
        	for(int i=1;i<=num%10;i++) {
        		str.append("I");
        	}
        }
        //
        return str.toString();
    }

    public static void main(String[] args) {
    	IntegerToRoman obj = new IntegerToRoman();
    	System.out.println("3: "+obj.intToRoman(3));
    	System.out.println("4: "+obj.intToRoman(4));
    	System.out.println("9: "+obj.intToRoman(9));
    	System.out.println("58: "+obj.intToRoman(58));
    	System.out.println("1994: "+obj.intToRoman(1994));
    }
}
