package LearnJava;

public class Singleton2 {
	
	private static String resource = "Hello World";
	private static Singleton2 s2 = new Singleton2();
	
	private Singleton2() {
		
	}
	
	public static Singleton2 getResource() {
		return s2;
		
	}
	
	public static void main(String[] args) {
		System.out.println(Singleton2.getResource().resource);
	}
	

}
