package Dictionary;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Scanner;

public class TDProject {
	private String municipality;
    private DictionaryInterface<BusinessName, String> dictionary;
    private DictionaryInterface<String, BusinessName> reversedDic;

    public TDProject() {
        dictionary = new SortedArrayDictionary<>();
        reversedDic = new SortedArrayDictionary<>();
    }

    public void readFile(Scanner data) {
        while (data.hasNextLine()) {
            String line = data.nextLine();

            // Define a pattern for extracting name, municipality, and phone number
            Pattern pattern = Pattern.compile("(.+),\\s(.+)\\s(\\d{3}-\\d{3}-\\d{4})");
            Matcher matcher = pattern.matcher(line);

            // Check if the pattern matches the line
            if (matcher.matches()) {
                String name = matcher.group(1).trim();
                municipality = matcher.group(2).trim();
                String phoneNumber = matcher.group(3).trim();

//                System.out.println(name);
//                System.out.println(municipality);
//                System.out.println(phoneNumber);

                
                BusinessName businessNameR = new BusinessName(name, municipality);
                add(businessNameR, phoneNumber);
                reverseAdd(phoneNumber, businessNameR); 
//                System.out.println(businessNameR.toString() + ", " + businessNameR.getMun());
                // Test to see if each key and value added successfully
//                if(dictionary.contains(businessNameR)) {
//                	System.out.println(businessNameR+ " has been added " + getPhoneNumber(businessNameR));
//                }
                
            }
        }
        
        // Test to see if Keys are present in dictionary
//        System.out.println("Printing all the keys: ");
//        Iterator<BusinessName> key = dictionary.getKeyIterator();
//        while(key.hasNext()) {
//        	System.out.println(key.next());
//        }
        
        //Testing reversed keys
//      System.out.println("Printing all the keys: ");
//        Iterator<String> key = reversedDic.getKeyIterator();
//        while(key.hasNext()) {
//        	System.out.println(key.next());
//        }
        
        // Test to see if values are present in dictionary
        //Print all values using iterator
//        System.out.println("Values in the dictionary:");
//        Iterator<String> valueIterator = dictionary.getValueIterator();
//        while (valueIterator.hasNext()) {
//            System.out.println(valueIterator.next());
//        }
      
        //Testing reversed values
//      System.out.println("Values in the dictionary:");
//      Iterator<BusinessName> valueIterator = reversedDic.getValueIterator();
//      while (valueIterator.hasNext()) {
//    	  System.out.println(valueIterator.next());
//      }
        
        data.close();
    }


    public void add(BusinessName nameWithMunicipality, String phoneNumber) {
    	
        dictionary.add(nameWithMunicipality, phoneNumber);
        
    }

    public String getPhoneNumber(BusinessName name) {
        return dictionary.getValue(name);
    }


    public void remove(BusinessName nameWithMunicipality) {
        dictionary.remove(nameWithMunicipality);
    }

    public String getFullNameAndPhone(BusinessName name) {
        String phoneNumber = dictionary.getValue(name);
        return name + ", their phone number is " + phoneNumber;
    }
    
    public boolean contains(BusinessName name) {
    	return dictionary.contains(name);
    }
    
    
    // Methods for reversed dictionary
    public void reverseAdd(String phoneNumber, BusinessName name) {
    	
        reversedDic.add(phoneNumber, name);
        
    }
    
    public BusinessName getName(String phoneNumber) {
    	return reversedDic.getValue(phoneNumber);
    }
    
}

