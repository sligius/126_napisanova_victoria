package core;

import java.util.ArrayList;
import java.util.HashMap;

public class Contract {
    private final HashMap<Integer, PaymentDocs> PaymentDocuments = new HashMap<>();


    public Contract() {
    }

    public void registerPaymentDocs(int sum, int paymentDocNumber, TypeOfPaymentDoc type, int date) throws Exception {
        if (sum > 0 && paymentDocNumber > 0 && String.valueOf(date).length() == 8) {
            PaymentDocuments.put(paymentDocNumber, new PaymentDocs(sum, type, date));
            }
        else {
            throw new Exception("Формат введённых данных неверен.");
        }
    }


    public int getPaymentDocsCount() {
        return PaymentDocuments.size();
    }

    public void deletePayment(int paymentDocNumber) throws Exception {
        if (!PaymentDocuments.containsKey(paymentDocNumber)) {
            throw new Exception("Договора с таким номером не существует.");
        }
        else {
            PaymentDocuments.remove(paymentDocNumber);
            System.out.println("Платёж успешно удалён.");
        }
    }

    public ArrayList<Integer> getListOfPaymentsFromCon() {
        ArrayList<Integer> payments = new ArrayList<>();
        for (PaymentDocs paymentDocs: PaymentDocuments.values()) {
            payments.add(paymentDocs.getSum());
        }
        return payments;
    }

    public int getSumOfPayments() {
        int sum = 0;
        for (PaymentDocs docs: PaymentDocuments.values()) {
            sum += docs.getSum();
        }
        return sum;
    }

    public HashMap<Integer, PaymentDocs> getPayDocs() {
        return PaymentDocuments;
    }
}
