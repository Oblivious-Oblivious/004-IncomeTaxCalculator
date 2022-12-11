package incometaxcalculator.app.receipts;

public class Company {
    public String name;
    public Address address;

    public Company(String name, String country, String city, String street, int number) {
        this.name = name;
        this.address = new Address(country, city, street, number);
    }

    // TODO Eventually just use this
    public String toString() {
        return name + ": " + address;
    }
}
