package core;

public class PaymentDocs {
    private int sum;
    private String date;
    private TypeOfPaymentDoc type;

    public PaymentDocs(int sum, TypeOfPaymentDoc type, String date) {
        this.sum = sum;
        this.type = type;
        this.date = date;
    }

    public int getSum() {
        return sum;
    }
}
