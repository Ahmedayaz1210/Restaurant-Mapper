package Dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RestaurantReversed {
	private static final String INPUT_ERR = "error";
	private static final String QUIT = "quit";
	
	public static void main(String[] args) {
		TDProject rDic = new TDProject();
		String fileName = "C:\\Users\\Ahmed Ayaz\\eclipse-workspace\\Data Structures\\src\\Dictionary\\restaurants.txt";
		
		try {
			Scanner data = new Scanner(new File(fileName));
			rDic.readFile(data);
		}catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		}
		String nextPhone = getPhoneNum();
		while(!nextPhone.equals(QUIT)) {
			if(nextPhone.equals(INPUT_ERR)) {
				System.out.println("Error in entering Phone number. Try again.");
			}else {
				BusinessName name = rDic.getName(nextPhone);
				if(name == null) {
					System.out.println(nextPhone + " is not in the directory.");
				}else {
					System.out.println("The name for " + nextPhone + " is " + name + ", " + name.getMun());
				}
			}
			nextPhone = getPhoneNum();
		}
		System.out.println("Bye!");
	}
	
	private static String getPhoneNum() {
		String result = "";
		Scanner keyboard = new Scanner(System.in);
	    System.out.print("Enter Phone number as xxx-xxx-xxxx, " + "or quit to end: ");
	    String line = keyboard.nextLine();
	    
	    if (line.trim().toLowerCase().equals("quit")) {
	        result = QUIT;
	    }else {
	    	String number = line.trim();
	    	
	    	if(number.isEmpty()) {
	    		result = INPUT_ERR;
	    	}else {
	    		result = number;
	    	}
	    }
	    
	    return result;
	}
}
