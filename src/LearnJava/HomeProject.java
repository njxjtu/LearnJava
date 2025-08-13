package LearnJava;

import java.util.HashMap;

public class HomeProject {
	
	public static void main(String args[]) {
		HashMap<String, Integer> expense2025 = new HashMap<>(); 
		
		expense2025.put("swimclass0714", 158);
		expense2025.put("swimclass0708", 80);
		expense2025.put("swimclass0701", 80);
		expense2025.put("swimclass0622", 80);
		expense2025.put("merryhillSummerCamp", 275);
		expense2025.put("scienceAlliance0313", 150);
		expense2025.put("dreamclassSummerCamp", 438);
		expense2025.put("makersClub03", 210);
		
		int sum = expense2025.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
		
		System.out.println("Total: " + sum);
		
		sum =0 ;
		
		for (int cost : expense2025.values()) {
			sum += cost;
		}
		
		System.out.println("Total: " + sum);
	}

}
