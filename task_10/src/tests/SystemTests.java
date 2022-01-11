package tests;

import org.junit.*;
import core.*;

import java.util.ArrayList;
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
        assertEquals(0, contractBook.getConCount());
    }
    @Test
    public void addCon_AddConWithNullNumber_ThrowsException() {
        ContractBook contractBook = ContractBook.create();
        var exc = assertThrows(IllegalArgumentException.class, () -> contractBook.addCon(null, "date"));
        assertTrue(exc.getMessage().toLowerCase().contains("number cannot be null"));
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
        assertTrue(exc.getMessage().toLowerCase().contains("number cannot be null") && exc.getMessage().toLowerCase().contains("date cannot be null"));
    }
    @Test
    public void getList_getListOfAllPayments_equalLists() {
        ContractBook contractBook = ContractBook.create();
        contractBook.addCon("number", "date");
        contractBook.addCon("number2", "date");

    }
    @Test
    public void registerPaymentDocs_registerPaymentDocWithoutData_PaymentDocsCountEqualsZero() {
        ContractBook contractBook = ContractBook.create();

        contractBook.addCon("number", "date");

    }
}
