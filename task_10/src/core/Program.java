package core;

import java.util.Scanner;

public class Program {
    public void runProgram() {
        ContractBook data = ContractBook.create();
        call(data);
    }

    public static void call(ContractBook data) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        callMenu();
        try {
            int n = scanner.nextInt();
            if (n == 1) {
                System.out.println("Введите номер договора и дату в формате YYYYMMDD.");
                try {
                    data.addCon(scanner.nextInt(), scanner.nextInt());
                } catch (Exception exception) {
                    System.out.println("Формат введённых данных неверен.");
                }
                System.out.println();
                callChoice();
                int l = scanner1.nextInt();
                if (l == 1) {
                    call(data);
                }
                else {
                    System.out.println("Всего хорошего!");
                }
            }
            else if (n == 2) {
                try {
                    System.out.println("Введите сумму платежа, номер документа, его тип (PaymentOrder или BankOrder), номер договора и дату заключения в формате YYYYMMDD.");
                    data.registerPaymentDocs(scanner.nextInt(), scanner.nextInt(), TypeOfPaymentDoc.valueOf(scanner.next()), scanner.nextInt(), scanner.nextInt());
                } catch (Exception exception) {
                    System.out.println("Формат введённых данных неверен.");
                }
                System.out.println();
                callChoice();
                int l = scanner1.nextInt();
                if (l == 1) {
                    call(data);
                }
                else {
                    System.out.println("Всего хорошего!");
                }
            }
            else if (n == 3) {
                try {
                    System.out.println("Введите номер договора, номер платёжного документа и дату в формате YYYYMMDD.");
                    data.getCons().get(scanner.nextInt()).deletePayment(scanner.nextInt());
                } catch (Exception exception) {
                    System.out.println("Формат введённых данных неверен.");
                }
                System.out.println();
                callChoice();
                int l = scanner1.nextInt();
                if (l == 1) {
                    call(data);
                }
                else {
                    System.out.println("Всего хорошего!");
                }
            }
            else if (n == 4) {
                try {
                    System.out.println("Введите номер договора.");
                    System.out.println(data.getCons().get(scanner.nextInt()).getListOfPaymentsFromCon());
                } catch (Exception exception) {
                    System.out.println("Формат введённых данных неверен.");
                }
                System.out.println();
                callChoice();
                int l = scanner1.nextInt();
                if (l == 1) {
                    call(data);
                }
                else {
                    System.out.println("Всего хорошего!");
                }
            }
            else if (n == 5) {
                try {
                    System.out.println("Введите номер договора.");
                    System.out.println(data.getCons().get(scanner.nextInt()).getSumOfPayments());
                } catch (Exception exception) {
                    System.out.println("Формат введённых данных неверен.");
                }
                System.out.println();
                callChoice();
                int l = scanner1.nextInt();
                if (l == 1) {
                    call(data);
                }
                else {
                    System.out.println("Всего хорошего!");
                }
            }
            else if (n == 6) {
                try {
                    System.out.println(data.getAllPayments());
                } catch (Exception exception) {
                    System.out.println(data.getAllPayments());
                }
                System.out.println();
                callChoice();
                int l = scanner1.nextInt();
                if (l == 1) {
                    call(data);
                }
                else {
                    System.out.println("Всего хорошего!");
                }
            }
            else if (n == 7) {
                try {
                    System.out.println(data.getListOfConsWithSum());
                } catch (Exception exception) {
                    System.out.println("Формат введённых данных неверен.");
                }
                System.out.println();
                callChoice();
                int l = scanner1.nextInt();
                if (l == 1) {
                    call(data);
                }
                else {
                    System.out.println("Всего хорошего!");
                }
            }
        }
        catch (Exception exception) {
            System.out.println("Формат введённых данных неверен.");
            System.out.println();
            call(data);
        }
    }

    private static void callMenu() {
        System.out.println();
        System.out.println("*Система учёта платежей по договорам.*");
        System.out.println();
        System.out.println("Вводите все данные предельно внимательно. Там, где требуется несколько разных параметров, вводите их через пробел.");
        System.out.println();
        System.out.println("1 - Добавить договор");
        System.out.println("2 - Зарегистрировать платёжный документ");
        System.out.println("3 - Удалить платёж");
        System.out.println("4 - Найти все платежи по выбранному договору");
        System.out.println("5 - Получить сумму всех платежей по выбранному договору");
        System.out.println("6 - Получить список всех платежей");
        System.out.println("7 - Получить список всех договоров с их суммарными платежами");
    }

    private static void callChoice() {
        System.out.println("Продолжить или завершить работу?");
        System.out.println("1 - Продолжить");
        System.out.println("2 - Завершить");
    }
}
