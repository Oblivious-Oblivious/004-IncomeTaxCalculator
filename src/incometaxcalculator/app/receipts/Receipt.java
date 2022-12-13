package incometaxcalculator.app.receipts;

import incometaxcalculator.app.exceptions.WrongReceiptDateException;
import incometaxcalculator.app.exceptions.WrongReceiptKindException;

public class Receipt {
    public int id;
    public Date date;
    public float amount;
    public ReceiptKind kind;
    public Company company;

    Date create(String date) throws WrongReceiptDateException {
        String token[] = date.split("/");
        if(token.length != 3)
            throw new WrongReceiptDateException();

        int day = Integer.parseInt(token[0]);
        int month = Integer.parseInt(token[1]);
        int year = Integer.parseInt(token[2]);

        return new Date(day, month, year);
    }

    public Receipt(int id, String date, float amount, ReceiptKind kind, String company_name, String country, String city, String street, int number) throws WrongReceiptKindException, WrongReceiptDateException {
        this.id = id;
        this.date = create(date);
        this.amount = amount;
        this.kind = kind;
        this.company = new Company(company_name, country, city, street, number);
    }
}
