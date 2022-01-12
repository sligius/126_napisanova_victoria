package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Contract {
    private String date;
    private HashMap<Integer, PaymentDocs> PaymentDocuments;

    public Contract(String date) {
        this.date = date;
        PaymentDocuments = new HashMap<>();
    }

    public void registerPaymentDocs(int sum, int number, TypeOfPaymentDoc type, String date) {
        PaymentDocuments.put(number, new PaymentDocs(sum, type, date));
    }

    public int getPaymentDocsCount() {
        return PaymentDocuments.size();
    }

    public HashMap<Integer, PaymentDocs> getPayDocs() {
        return PaymentDocuments;
    }

    public int getSumOfPayments() {
        int sum = 0;
        for (PaymentDocs docs: PaymentDocuments.values()) {
            sum += docs.getSum();
        }
        return sum;
    }

    public List<Integer> getListOfPaymentsFromCon() {
        List<Integer> payments = new ArrayList<>();
        for (PaymentDocs paymentDocs: PaymentDocuments.values()) {
            payments.add(paymentDocs.getSum());
        }
        return payments;
    }
}
