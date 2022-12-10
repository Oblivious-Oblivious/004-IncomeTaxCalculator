package incometaxcalculator.app.receipts;

import incometaxcalculator.app.exceptions.WrongReceiptDateException;

public class Receipt {
    public final int id;
    public final Date issueDate;
    public final float amount;
    public final String kind;
    public final Company company;

    public Receipt(int id, String issueDate, float amount, String kind, Company company) throws WrongReceiptDateException {
        this.id = id;
        this.issueDate = createDate(issueDate);
        this.amount = amount;
        this.kind = kind;
        this.company = company;
    }

    private Date createDate(String issueDate) throws WrongReceiptDateException {
        String token[] = issueDate.split("/");
        if(token.length != 3)
            throw new WrongReceiptDateException();

        int day = Integer.parseInt(token[0]);
        int month = Integer.parseInt(token[1]);
        int year = Integer.parseInt(token[2]);

        return new Date(day, month, year);
    }
}
