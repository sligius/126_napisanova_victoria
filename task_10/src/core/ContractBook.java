package core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ContractBook {
    private int PaymentDocsCount;
    private HashMap<String, Contract> data;
    private ContractBook() {
        data = new HashMap<>();
        PaymentDocsCount = 0;
    }


    public void addCon(String number, String date) {
        StringBuilder error = new StringBuilder();

        if (number == null) {
            error.append("number cannot be null\n");
        }
        if (date == null) {
            error.append("date cannot be null\n");
        }
        if (!error.isEmpty()) {
            throw new IllegalArgumentException(error.toString());
        }
        if (!data.containsKey(number)) {
            data.put(number, new Contract(date));
            System.out.println("Документ зарегистрирован.");
        }
    }

    public int getConCount() {
        return data.size();
    }

    public static ContractBook create() {
        return new ContractBook();
    }

    public HashMap<String, Contract> getCons() {
        return data;
    }

    public void registerPaymentDocs(int sum, int paymentDocNumber, TypeOfPaymentDoc type, String ConNumber, String date) {
        StringBuilder error = new StringBuilder();

        if (sum < 0) {
            error.append("sum is a positive number\n");
        }
        if (paymentDocNumber < 0) {
            error.append("number of payment document is a positive number\n");
        }
        if (!error.isEmpty()) {
            throw new IllegalArgumentException(error.toString());
        }
        else {
            data.get(ConNumber).registerPaymentDocs(sum, paymentDocNumber, type, date);
            PaymentDocsCount++;
            System.out.println("Платёжный документ успешно создан.");
        }
    }

    public void deletePayment(String ConNumber, int paymentDocNumber,String paymentConDate) {
        data.get(ConNumber).getPayDocs().remove(paymentDocNumber);
    }

    public List<Integer> getAllPayments() {
        List<Integer> ListOfPayments = new ArrayList<>();
        for (Contract contract: data.values()) {
            for (PaymentDocs paymentDocs: contract.getPayDocs().values())
                ListOfPayments.add(paymentDocs.getSum());
        }
        return ListOfPayments;
    }
}
