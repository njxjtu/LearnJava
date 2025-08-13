package LearnJava;
public class Singleton {
	
	private static int input1 = 1;
	
	private Singleton(int input){
		input1 = input;
		
	}
	
	public static int  getInt(){
		return input1;
	}
	
	enum level {Monday, Tuesday};
	
	public static void main(String[] args){
		System.out.println(Singleton.input1);
		for (level myVar : level.values()) {
			  System.out.println(myVar);
			}
	}

}
