package Dictionary;
import utils.Name;
import java.util.*;
public class TelephoneDirectory {
	private DictionaryInterface<Name, String> phoneBook;
	
	public TelephoneDirectory() {
		phoneBook = new SortedArrayDictionary<>();
	}
	public void readFile(Scanner data)
	{
		while (data.hasNext()){
			String firstName = data.next();
			String lastName = data.next();
			String phoneNumber = data.next();
			Name fullName = new Name(firstName, lastName);
			phoneBook.add(fullName, phoneNumber);
		} // end while
		data.close();
	} 
	public String getPhoneNumber(Name personName)
	{
		return phoneBook.getValue(personName);
	} 
}
