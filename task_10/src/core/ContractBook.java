package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContractBook {
    private final HashMap<Integer, Contract> data;

    public HashMap<Integer, Contract> getCons() {
        return data;
    }

    private ContractBook() {
        data = new HashMap<>();
    }


    public void addCon(Integer number, Integer date) throws Exception {
        if (data.containsKey(number)) {
            throw new Exception("Договор с таким номером уже существует.");
        }
        else {
            if (number > 0 && String.valueOf(date).length() == 8) {
                data.put(number, new Contract());
                System.out.println("Договор успешно добавлен.");
            }
            else {
                throw new Exception("Формат введённых данных неверен.");
            }
        }
    }

    public int getConCount() {
        return data.size();
    }

    public static ContractBook create() {
        return new ContractBook();
    }



    public void registerPaymentDocs(int sum, int paymentDocNumber, TypeOfPaymentDoc type, int ConNumber, int date) throws Exception {
        if (data.get(ConNumber).getPayDocs().containsKey(paymentDocNumber)) {
            throw new Exception("Документ с таким номером уже существует.");
        }
        else {
            if (sum > 0 && paymentDocNumber > 0 && String.valueOf(date).length() == 8) {
                data.get(ConNumber).registerPaymentDocs(sum, paymentDocNumber, type, date);
                System.out.println("Платёж успешно зарегистрирован.");
            }
            else {
                throw new Exception("Формат введённых данных неверен.");
            }
        }
    }

    public List<Integer> getAllPayments() {
        List<Integer> ListOfPayments = new ArrayList<>();
        for (Contract contract: data.values()) {
            for (PaymentDocs paymentDocs: contract.getPayDocs().values())
                ListOfPayments.add(paymentDocs.getSum());
        }
        return ListOfPayments;
    }

    public HashMap<Integer, Integer> getListOfConsWithSum() {
        HashMap<Integer,Integer> contracts = new HashMap<>();
        data.forEach((k, v) -> contracts.put(k, v.getSumOfPayments()));
        return contracts;
    }
}
