package core;

public class ContractBook {
    private int contractCount;
    private ContractBook() {
        contractCount = 0;
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
        contractCount++;
    }

    public int getConCount() {
        return 0;
    }

    public static ContractBook create() {
        return new ContractBook();
    }
}
