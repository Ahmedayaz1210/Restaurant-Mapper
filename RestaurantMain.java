package Dictionary;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

public class RestaurantMain {
	private static final BusinessName INPUT_ERROR = new BusinessName("error", "");
	private static final BusinessName  QUIT = new BusinessName("quit", "");
	
	public static void main(String[] args) {
		TDProject directory = new TDProject();
		String fileName = "C:\\Users\\Ahmed Ayaz\\eclipse-workspace\\Data Structures\\src\\Dictionary\\restaurants.txt";
		
		try {
			Scanner data = new Scanner(new File(fileName));
			directory.readFile(data);
		}catch(FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		}
		BusinessName nextName = getName();
		while(!nextName.equals(QUIT)) {
			if(nextName.equals(INPUT_ERROR)) {
				System.out.println("Error in entering name. Try again.");
			}else {
				String phoneNumber = directory.getPhoneNumber(nextName);
				if(phoneNumber == null) {
					System.out.println(nextName + " is not in the directory.");
				}else {
					System.out.println("The phone number for " + nextName + " is " + phoneNumber);
				}
			}
			nextName = getName();
		}
		/* TEST FOR CHECKING IF METHOD REMOVE WORKS
		directory.remove("Anchovies");
		if(!directory.contains("Anchovies"))
			System.out.println("Anchovies successfully removed!");
		System.out.println(directory.contains("Anchovies")); */
		
		/*TEST FOR CHECKING IF METHOD getFullNameAndPhone WORKS
		System.out.println(directory.getFullNameAndPhone("Anchovies"));*/
		
		
		System.out.println("Bye!");
	}

	private static BusinessName getName() {
	    BusinessName result = null;
	    Scanner keyboard = new Scanner(System.in);
	    System.out.print("Enter Restaurant name, " + "or quit to end: ");
	    String line = keyboard.nextLine();
	    
	    if (line.trim().toLowerCase().equals("quit")) {
	        result = QUIT;
	    } else {
	        String name = line.trim();

	        // Check if there is any content in the name
	        if (name.isEmpty()) {
	            result = INPUT_ERROR;
	        } else {
	            result = new BusinessName(name, "");
	        }
	    }
	    
	    return result;
	}


}
