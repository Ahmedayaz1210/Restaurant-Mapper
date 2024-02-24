package Dictionary;

import java.util.Iterator;

public class TestingSortedArrayDictionary {

    public static void main(String[] args) {
        // Instantiate the SortedArrayDictionary
        SortedArrayDictionary<Integer, String> dictionary = new SortedArrayDictionary<>();

        // Add key-value pairs
        dictionary.add(3, "Three");
        dictionary.add(1, "One");
        dictionary.add(2, "Two");
        dictionary.add(4, "Four");

        // Print the dictionary size
        System.out.println("Dictionary Size: " + dictionary.getSize());

     // Check if the dictionary contains a key
        System.out.println("Contains key 2: " + dictionary.contains(2));
        
     // Get and print the value for a key
        System.out.println("Value for key 3: " + dictionary.getValue(3));

     // Remove a key-value pair
        System.out.println("Removing the key 1: " + dictionary.remove(1));
        
     // Print the dictionary size after removal
        System.out.println("Dictionary Size after removal: " + dictionary.getSize());
     
     //   Print all keys using iterator
        System.out.println("Printing all the keys: ");
        Iterator<Integer> key = dictionary.getKeyIterator();
        while(key.hasNext()) {
        	System.out.println(key.next());
        }
     // Print all values using iterator
        System.out.println("Values in the dictionary:");
        Iterator<String> valueIterator = dictionary.getValueIterator();
        while (valueIterator.hasNext()) {
            System.out.println(valueIterator.next());
        }
        // Check if the dictionary is empty
        System.out.println("Is the dictionary empty? " + dictionary.isEmpty());

        // Clear the dictionary
        dictionary.clear();

        // Print the dictionary size after clearing
        System.out.println("Dictionary Size after clearing: " + dictionary.getSize());
    
     // Check if the dictionary is empty
        System.out.println("Is the dictionary empty? " + dictionary.isEmpty());
    }
}