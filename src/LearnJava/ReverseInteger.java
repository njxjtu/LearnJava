package LearnJava;
public class ReverseInteger {

   public int reverse(int x) {
        int xwos = Math.abs(x);
        String xwos_str = Integer.toString(xwos);
        StringBuilder str = new StringBuilder(); 
        for (int i=xwos_str.length()-1; i>=0; i--){
        	str.append(xwos_str.charAt(i));
        	}
        try{
        return (x>=0)? Math.toIntExact(Long.parseLong(str.toString())) : -Math.toIntExact(Long.parseLong(str.toString()));
        }
        catch(Exception e){
        	return 0;
        }
    }

   public int reverse2(int x) {
       int xwos = Math.abs(x);
       int r = 0, remain = 0, j;
       try{
    	   remain = xwos%10; 
    	   System.out.println("remain: " + remain);
    	   j=2;
    	   while(remain>0){
    		   System.out.println("in while - r: " + r);
    		   r = r+ remain;
    		   remain = xwos%(int)Math.pow(10, j);
    		   j++;
    	   }
       }
       catch(Exception e){
    	   return r;
       }
       return (x>=0)? r:-r;
   }
   
   public static void main(String[] args){
	   ReverseInteger obj = new ReverseInteger();
	   System.out.println(obj.reverse(1534236469));
	   //System.out.println(obj.reverse2(1534236469));
   }
}
