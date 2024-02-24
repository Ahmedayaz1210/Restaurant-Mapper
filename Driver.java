package Dictionary;
import utils.Name;
import java.io.*;
import java.util.*;
public class Driver {
	private static final Name INPUT_ERROR = new Name("error","error");
	private static final Name  QUIT = new Name("quit", "quit");
	public static void main(String[] args) {
		TelephoneDirectory directory = new TelephoneDirectory();
		String fileName = "C:\\Users\\Ahmed Ayaz\\eclipse-workspace\\Data Structures\\src\\Dictionary\\names.txt";
		
		try {
			Scanner data = new Scanner(new File(fileName));
			directory.readFile(data);

		}catch(FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		}
		Name nextName = getName();  
		while(!nextName.equals(QUIT)) {
			if(nextName.equals(INPUT_ERROR)) {
				System.out.println("Error in entering name. Try again.");
			}else {
				String phoneNumber = directory.getPhoneNumber(nextName);
				if(phoneNumber == null) {
					System.out.println(nextName + " is not in the direcotry.");
				}else {
					System.out.println("The phone number for " + nextName + " is " + phoneNumber);
				}
				
			}
			nextName = getName();
		}
		System.out.println("Bye!");
	}
	
	private static Name getName() {
		Name result = null;
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter first name and last name, " + "or quit to end:");
		String line = keyboard.nextLine();
		
		if(line.trim().toLowerCase().equals("quit")) {
			result = QUIT;
		}else {
			String firstName = null;
			String lastName = null;
			Scanner scan = new Scanner(line);
			if(scan.hasNext()) {
				firstName = scan.next();
				if(scan.hasNext()) {
					lastName = scan.next();
				}else {
					result = INPUT_ERROR;
				}
			}else {
				result = INPUT_ERROR;
			}
			if(result == null) {
				result = new Name(firstName,lastName);
			}
			
		}
		
	
		return result;
	}
}
