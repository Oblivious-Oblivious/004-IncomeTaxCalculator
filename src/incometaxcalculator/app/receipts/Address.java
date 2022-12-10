package incometaxcalculator.app.receipts;

public class Address {
    public String country;
    public String city;
    public String street;
    public int number;

    public Address(String country, String city, String street, int number) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    // TODO Eventually just use this
    public String toString() {
        return city + ", " + country + ", " + street + " " + number;
    }
}
