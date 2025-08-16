package LearnJava;

public class PlusOne {
    
        public int[] plusOne(int[] digits) {

            

            Integer num1 = 0, num2 = 0;

            for (int i = 0 ; i< digits.length; i++) {
               num1 = num1 +  10^(digits.length - i - 1)*digits[i];

            }
            
            num2 = num1 + 1;

            System.out.println("num1: " + num1);
            System.out.println("num2: " + num2);
            

            int digits2Length = num2.toString().length();
            int[] digits2 = new int[digits2Length];

            for(int j=0; j< digits2Length; j++) {

                digits2[j] = num2/(10^(digits2Length-j-1));
            }


            return digits2;
        
    }

    public static void main(String args[]){
        int[] digits = {3,2,1};
        PlusOne p = new PlusOne();
        int[] digits2 = p.plusOne(digits);

        for(int i=0 ; i< digits2.length; i++) {
            System.out.println(digits2[i]);
        }


    }
}
