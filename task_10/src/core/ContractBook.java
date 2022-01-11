package core;

public class ContractBook {
    private int contractCount;
    private ContractBook() {
        contractCount = 0;
    }

    public void addCon(String number, String date) {
        if (number == null && date == null) {
            throw new IllegalArgumentException("number and date cannot be null");
        }
        if (number == null)
            throw new IllegalArgumentException("number cannot be null");
        if (date == null)
            throw new IllegalArgumentException("date cannot be null");

    }

    public int getConCount() {
        return 0;
    }

    public static ContractBook create() {
        return new ContractBook();
    }
}
