package LearnJava;
/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

 

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
*/
public class CountAndSay {
    public String countAndSay(int n) {
        String rlt = "";
        StringBuilder sb = new StringBuilder();
        if(n<1) return rlt;
        if(n==1) rlt = "1";
        if(n>1){
        	
        	String tempstr = countAndSay(n-1);
        	int pos=0, count=0;
        	char tempch =tempstr.charAt(pos);
        	while(pos<tempstr.length()){
        		if(tempstr.charAt(pos)==tempch){
        			count++;
        			pos++;
        		}
        		else{
        			if(count>0){
        				sb.append((char)(count+'0'));
        				sb.append(tempch);
        				count=0;
        			}
        			tempch=tempstr.charAt(pos);
        			count++;
        			pos++;
        		}
        	}
        	sb.append((char)(count+'0'));
			sb.append(tempch);
			count=0;
			
        	rlt = sb.toString();
        }
        return rlt;
    }
    
    public static void main(String[] args){
    	CountAndSay obj = new CountAndSay();
    	System.out.println(obj.countAndSay(5));
    }
}
