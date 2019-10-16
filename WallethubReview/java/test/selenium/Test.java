package test.selenium;

public class Test {

	/*public static void main(String[] args) {
		System.out.println("test method for addition");
		int number = add(2, 3, 5);
		System.out.println(number);
		
System.out.println(getCurrentWorkingDirectory());

	}*/
	
	
	public static int add(Integer...numbers) {
		int sumNumber = 0;
		for(Integer num : numbers) {
 			sumNumber += num;
		}
		return sumNumber;
	}
	
	public static String getCurrentWorkingDirectory() {
		return System.getProperty("user.dir");
	}

}
