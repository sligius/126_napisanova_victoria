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
    public void addCon_AddConWithNumberAndDate_ConCountEqualsOne() throws Exception{
        ContractBook contractBook = ContractBook.create();
        contractBook.addCon(1, 20220113);
        contractBook.addCon(2, 20220113);
        assertEquals(2, contractBook.getConCount());
    }



    @Test
    public void registerPaymentDocs_registerPaymentDocWithData_PaymentDocsCountEqualsThree() throws Exception {
        ContractBook contractBook = ContractBook.create();

        contractBook.addCon(1, 20220113);
        contractBook.addCon(2, 20220113);
        contractBook.registerPaymentDocs(100, 1, TypeOfPaymentDoc.PaymentOrder, 1, 20220113);
        contractBook.registerPaymentDocs(1000, 1, TypeOfPaymentDoc.PaymentOrder, 2, 20220113);
        assertEquals(1, contractBook.getCons().get(1).getPaymentDocsCount());
        assertEquals(1, contractBook.getCons().get(2).getPaymentDocsCount());
    }



    @Test
    public void deletePayment_DeletePayment_PaymentDocCountEqualsZero() throws Exception{
        ContractBook contractBook = ContractBook.create();
        contractBook.addCon(1, 20220113);
        contractBook.registerPaymentDocs(200, 1, TypeOfPaymentDoc.BankOrder, 1, 20220113);
        contractBook.registerPaymentDocs(7000, 2, TypeOfPaymentDoc.PaymentOrder, 1, 20220113);

        contractBook.getCons().get(1).deletePayment(1);
        contractBook.getCons().get(1).deletePayment(2);
        assertEquals(0, contractBook.getCons().get(1).getPaymentDocsCount());
    }



    @Test
    public void getAllPayments_GetAllPaymentsFromCon_EqualList() throws Exception{
        ContractBook contractBook = ContractBook.create();
        contractBook.addCon(39, 20220111);
        contractBook.registerPaymentDocs(100, 1, TypeOfPaymentDoc.PaymentOrder, 39, 20220107);
        contractBook.registerPaymentDocs(500, 2, TypeOfPaymentDoc.BankOrder, 39, 20211203);
        contractBook.registerPaymentDocs(1000, 3, TypeOfPaymentDoc.PaymentOrder, 39, 20210819);

        List<Integer> pays = new ArrayList<>();
        pays.add(100);
        pays.add(500);
        pays.add(1000);
        assertArrayEquals(pays.toArray(), contractBook.getCons().get(39).getListOfPaymentsFromCon().toArray());
    }


    @Test
    public void getConSum_CalculateSumOfConPayments_GeneralSumEqual1600() throws Exception {
        ContractBook contractBook = ContractBook.create();
        contractBook.addCon(39, 20220111);
        contractBook.registerPaymentDocs(100, 1, TypeOfPaymentDoc.PaymentOrder, 39, 20220111);
        contractBook.registerPaymentDocs(500, 2, TypeOfPaymentDoc.BankOrder, 39, 20220111);
        contractBook.registerPaymentDocs(1000, 3, TypeOfPaymentDoc.PaymentOrder, 39, 20220111);
        assertEquals(1600, contractBook.getCons().get(39).getSumOfPayments());
    }



    @Test
    public void getList_GetListOfAllPayments_EqualList() throws Exception {
        ContractBook contractBook = ContractBook.create();
        contractBook.addCon(1, 20220113);
        contractBook.registerPaymentDocs(100, 1, TypeOfPaymentDoc.PaymentOrder, 1, 20220113);
        contractBook.registerPaymentDocs(500, 2, TypeOfPaymentDoc.BankOrder, 1, 20220113);
        contractBook.registerPaymentDocs(1000, 3, TypeOfPaymentDoc.PaymentOrder, 1, 20220113);

        List<Integer> ListOfPayments = new ArrayList<>();
        ListOfPayments.add(100);
        ListOfPayments.add(500);
        ListOfPayments.add(1000);
        assertArrayEquals(ListOfPayments.toArray(), contractBook.getAllPayments().toArray());
    }



    @Test
    public void getConsWithSums_GetListOfConsWithSums_EqualList() throws Exception {
        ContractBook contractBook = ContractBook.create();
        contractBook.addCon(39, 20220111);
        contractBook.registerPaymentDocs(100, 1, TypeOfPaymentDoc.PaymentOrder, 39, 20220111);
        contractBook.registerPaymentDocs(500, 2, TypeOfPaymentDoc.BankOrder, 39, 20220111);

        contractBook.addCon(69, 20220111);
        contractBook.registerPaymentDocs(1000, 1, TypeOfPaymentDoc.PaymentOrder, 69, 20220111);
        contractBook.registerPaymentDocs(1500, 2, TypeOfPaymentDoc.PaymentOrder, 69, 20220111);

        HashMap<Integer, Integer> cons = new HashMap<>();
        cons.put(39, 600);
        cons.put(69, 2500);

        assertEquals(cons,contractBook.getListOfConsWithSum());
    }
}
