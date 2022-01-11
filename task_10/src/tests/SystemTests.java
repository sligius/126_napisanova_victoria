package tests;

import org.junit.*;
import core.*;

public class SystemTests extends Assert {
    @Test
    public void create_CreateEmptyContractBook_ConCountEqualsZero() {
        ContractBook contractBook = ContractBook.create();
        assertEquals(0, contractBook.getConCount());
    }
}
