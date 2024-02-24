package Dictionary;

public class BusinessName implements Comparable<BusinessName> {

    private String name;
    private String municipality;


    public BusinessName(String name, String municipality) {
        this.name = name;
        this.municipality = municipality;
    }
    
    
    public String getMun() {
    	return municipality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessName that = (BusinessName) o;
        return name.equals(that.name) && municipality.equals(that.municipality);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(BusinessName o) {
        return this.name.compareTo(o.name);
    }
}
