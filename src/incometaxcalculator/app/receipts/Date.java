package incometaxcalculator.app.receipts;

public class Date {
    public int day;
    public int month;
    public int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return day + "/" + month + "/" + year;
    }

    public boolean equals(Date other) {
        return this.day == other.day
            && this.month == other.month
            && this.year == other.year;
    }
}
