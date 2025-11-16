package LearnJava;

import java.util.HashSet;
import java.util.Set;

public class LamdaExpression2 {
	
	public static void main (String args[]) {
		Set<String> strSet = new HashSet<String>();
		strSet.add("Toyota");
		strSet.add("Audi");
		strSet.forEach((s) -> {
			System.out.println("Original String is: " + s);
			StringBuffer sb = new StringBuffer();
			for(int i=s.length()-1; i>=0; i--) {
				sb.append(s.charAt(i));
			}
			System.out.println("Reversed String is: " + sb.toString());
			}
);
}
}