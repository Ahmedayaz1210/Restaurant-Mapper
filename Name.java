package Dictionary;

public class Name implements Comparable<Name> {
	private String firstName;
	private String lastName;
	
	public Name(String fullName) {
		String[] parts = fullName.split("\\s+");
		firstName = parts[0];
		lastName = parts[1];
	}
	
	public String getFirst() {
		return firstName;
	}
	
	public String getLast() {
		return lastName;
	}
	
	public String toString() {
		return firstName + " " +  lastName;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(o == this)
			return true;
		Name other = (Name) o;
		return firstName.equals(other.getFirst()) &&
				lastName.equals(other.getLast());
	}

	@Override
	public int compareTo(Name o) {
		return lastName.compareTo(o.getLast());
	}
}
