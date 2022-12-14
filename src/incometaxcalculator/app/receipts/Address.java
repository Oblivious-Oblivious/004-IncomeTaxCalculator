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

    public boolean equals(Address other) {
        return this.country.equals(other.country)
            && this.city.equals(other.city)
            && this.street.equals(other.street)
            && this.number == other.number;
    }
}
