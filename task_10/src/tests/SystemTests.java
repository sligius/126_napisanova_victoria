package tests;

import org.junit.*;
import core.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SystemTests extends Assert {
    @Test
    public void create_CreateEmptyContractBook_ConCountEqualsZero() {
        ContractBook contractBook = ContractBook.create();
        assertEquals(0, contractBook.getConCount());
    }
    @Test
    public void addCon_AddConWithNumberAndDate_ConCountEqualsOne() {
        ContractBook contractBook = ContractBook.create();
        contractBook.addCon("number", "date");
        assertEquals(1, contractBook.getConCount());
    }
    @Test
    public void addCon_AddConWithNullNumber_ThrowsException() {
        ContractBook contractBook = ContractBook.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> contractBook.addCon(null, "date"));
        assertTrue(exc.getMessage().toLowerCase().contains("number of contract cannot be null"));
    }
    @Test
    public void addCon_AddConWithNullDate_ThrowsException() {
        ContractBook contractBook = ContractBook.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> contractBook.addCon("number", null));
        assertTrue(exc.getMessage().toLowerCase().contains("date cannot be null"));
    }
    @Test
    public void addCon_AddConWithNullNumberAndNullDate_ThrowsException() {
        ContractBook contractBook = ContractBook.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> contractBook.addCon(null, null));
        assertTrue(exc.getMessage().toLowerCase().contains("number of contract cannot be null") && exc.getMessage().toLowerCase().contains("date cannot be null"));
    }


    @Test
    public void registerPaymentDocs_registerPaymentDocWithoutData_PaymentDocsCountEqualsZero() {
        ContractBook contractBook = ContractBook.create();

        contractBook.addCon("number", "date");
        assertEquals(0, contractBook.getCons().get("number").getPaymentDocsCount());
    }
    @Test
    public void registerPaymentDocs_registerPaymentDocWithData_PaymentDocsCountEqualsOne() {
        ContractBook contractBook = ContractBook.create();

        contractBook.addCon("number", "date");
        contractBook.registerPaymentDocs(100, 1, TypeOfPaymentDoc.PaymentOrder, "number", "20220107");
        assertEquals(1, contractBook.getCons().get("number").getPaymentDocsCount());
    }
    @Test
    public void registerPaymentDocs_registerPaymentDocWithData_PaymentDocsCountEqualsThree() {
        ContractBook contractBook = ContractBook.create();

        contractBook.addCon("number", "date");
        contractBook.registerPaymentDocs(100, 1, TypeOfPaymentDoc.PaymentOrder, "number", "20220107");
        contractBook.registerPaymentDocs(500, 2, TypeOfPaymentDoc.BankOrder, "number", "20211203");
        contractBook.registerPaymentDocs(1000, 3, TypeOfPaymentDoc.PaymentOrder, "number", "20210819");
        assertEquals(3, contractBook.getCons().get("number").getPaymentDocsCount());
    }
    @Test
    public void registerPaymentDocs_registerPaymentDocWithNegSum_ThrowsExceptions() {
        ContractBook contractBook = ContractBook.create();
        contractBook.addCon("number", "date");
        var exc = assertThrows(IllegalArgumentException.class, () -> contractBook.registerPaymentDocs(-100, 1, TypeOfPaymentDoc.PaymentOrder, "number", "20001010"));
        assertTrue(exc.getMessage().toLowerCase().contains("sum is a positive number"));
    }
    @Test
    public void registerPaymentDocs_registerPaymentDocWithNegPaymentDocNum_ThrowsExceptions() {
        ContractBook contractBook = ContractBook.create();
        contractBook.addCon("number", "date");
        var exc = assertThrows(IllegalArgumentException.class, () -> contractBook.registerPaymentDocs(100, -9, TypeOfPaymentDoc.PaymentOrder, "number", "20001010"));
        assertTrue(exc.getMessage().toLowerCase().contains("number of payment document is a positive number"));
    }


    @Test
    public void deletePayment_DeletePaymentWithNumConNumDate_PaymentDocCountEqualsZero() {
        ContractBook contractBook = ContractBook.create();
        contractBook.addCon("number", "20030924");
        contractBook.registerPaymentDocs(200, 3, TypeOfPaymentDoc.BankOrder, "number", "20091027");
        contractBook.registerPaymentDocs(7000, 8, TypeOfPaymentDoc.PaymentOrder, "number", "20070514");

        contractBook.deletePayment("number", 3, "20091027");
        contractBook.deletePayment("number", 8, "20070514");
        assertEquals(0, contractBook.getCons().get("number").getPaymentDocsCount());
    }
    @Test
    public void deletePayment_DeleteNonExistPayment_PaymentDocCountEqualsZeroOne() {
        ContractBook contractBook = ContractBook.create();
        contractBook.addCon("number", "20030924");
        contractBook.registerPaymentDocs(200, 3, TypeOfPaymentDoc.BankOrder, "number", "20091027");

        contractBook.deletePayment("number", 8, "20070514");
        assertEquals(1, contractBook.getCons().get("number").getPaymentDocsCount());
    }
    @Test
    public void getList_GetListOfAllPayments_EqualList() {
        ContractBook contractBook = ContractBook.create();
        contractBook.addCon("number", "20030924");
        contractBook.registerPaymentDocs(100, 1, TypeOfPaymentDoc.PaymentOrder, "number", "20220107");
        contractBook.registerPaymentDocs(500, 2, TypeOfPaymentDoc.BankOrder, "number", "20211203");
        contractBook.registerPaymentDocs(1000, 3, TypeOfPaymentDoc.PaymentOrder, "number", "20210819");

        List<Integer> ListOfPayments = new ArrayList<>();
        ListOfPayments.add(100);
        ListOfPayments.add(500);
        ListOfPayments.add(1000);
        assertArrayEquals(ListOfPayments.toArray(), contractBook.getAllPayments().toArray());
    }


    @Test
    public void getConSum_CalculateSumOfConPayments_GeneralSumEqual1600() {
        ContractBook contractBook = ContractBook.create();
        contractBook.addCon("39", "20220111");
        contractBook.registerPaymentDocs(100, 1, TypeOfPaymentDoc.PaymentOrder, "39", "20220107");
        contractBook.registerPaymentDocs(500, 2, TypeOfPaymentDoc.BankOrder, "39", "20211203");
        contractBook.registerPaymentDocs(1000, 3, TypeOfPaymentDoc.PaymentOrder, "39", "20210819");
        assertEquals(1600, contractBook.getCons().get("39").getSumOfPayments());
    }

    @Test
    public void getAllPayments_GetAllPaymentsFromCon_EqualList() {
        ContractBook contractBook = ContractBook.create();
        contractBook.addCon("39", "20220111");
        contractBook.registerPaymentDocs(100, 1, TypeOfPaymentDoc.PaymentOrder, "39", "20220107");
        contractBook.registerPaymentDocs(500, 2, TypeOfPaymentDoc.BankOrder, "39", "20211203");
        contractBook.registerPaymentDocs(1000, 3, TypeOfPaymentDoc.PaymentOrder, "39", "20210819");

        List<Integer> pays = new ArrayList<>();
        pays.add(100);
        pays.add(500);
        pays.add(1000);
        assertArrayEquals(pays.toArray(), contractBook.getCons().get("39").getListOfPaymentsFromCon().toArray());
    }


    @Test
    public void getConsWithSums_GetListOfConsWithSums_EqualList() {
        ContractBook contractBook = ContractBook.create();
        contractBook.addCon("39", "20220111");
        contractBook.registerPaymentDocs(100, 1, TypeOfPaymentDoc.PaymentOrder, "39", "20220107");
        contractBook.registerPaymentDocs(500, 2, TypeOfPaymentDoc.BankOrder, "39", "20211203");

        contractBook.addCon("69", "20220111");
        contractBook.registerPaymentDocs(1000, 1, TypeOfPaymentDoc.PaymentOrder, "69", "20211023");
        contractBook.registerPaymentDocs(1500, 2, TypeOfPaymentDoc.PaymentOrder, "69", "20210819");

        HashMap<String, Integer> cons = new HashMap<>();
        cons.put("39", 600);
        cons.put("69", 2500);

        assertEquals(cons,contractBook.getListOfConsWithSum());
    }
}
