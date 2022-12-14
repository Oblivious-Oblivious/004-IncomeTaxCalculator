package incometaxcalculator.app.receipts;

public class Company {
    public String name;
    public Address address;

    public Company(String name, String country, String city, String street, int number) {
        this.name = name;
        this.address = new Address(country, city, street, number);
    }

    public boolean equals(Company other) {
        return this.name.equals(other.name)
            && this.address.equals(other.address);
    }
}
