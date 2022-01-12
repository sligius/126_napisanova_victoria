package core;

import java.util.Scanner;

public class Program {
    public void runProgram() {
        ContractBook data = ContractBook.create();
        call(data);
    }

    public static void call(ContractBook data) {
        Scanner scanner = new Scanner(System.in);
        callMenu();
        try {
            int n = scanner.nextInt();
            if (n == 1) {
                System.out.println("Введите номер договора и дату в формате YYYYMMDD.");
                try {
                    data.addCon(scanner.nextLine(), scanner.nextLine());
                } catch (IllegalArgumentException argumentException) {
                    System.out.println("Формат введённых данных неверен.");
                }
                System.out.println();
                call(data);
            }
            //else if (n == 2) {
              //  try {
                //    System.out.println("Введите сумму платежа, номер документа, его тип (PaymentOrder или BankOrder), номер договора и дату заключения.");
                  //  data.registerPaymentDocs(scanner.nextInt(), scanner.nextInt(), TypeOfPaymentDoc.valueOf(scanner.next()), scanner.nextLine(), scanner.nextLine());
               // } catch (IllegalArgumentException argumentException) {
                 //   System.out.println("Формат введённых данных неверен.");
                //}
                //System.out.println();
               // call(data);
            //}
            //else if (n == 3) {
              //  try {
                   // System.out.println("Введите номер договора, номер платёжного документа и дату.");
                    //data.getCons().get(scanner.nextLine()).deletePayment(scanner.nextLine(), scanner.nextInt(), scanner.nextLine());
               // }
           // }
        }
        catch (IllegalArgumentException argumentException) {
            System.out.println("Формат введённых данных неверен.");
            System.out.println();
            call(data);
        }
    }

    private static void callMenu() {
        System.out.println("*Система учёта платежей по договорам.*");
        System.out.println("Вводите все данные предельно внимательно. Там, где требуется несколько разных параметров, вводите их через пробел.");
        System.out.println("1 - Добавить договор");
        System.out.println("2 - Зарегистрировать платёжный документ");
        System.out.println("3 - Удалить платёж");
        System.out.println("4 - Найти все платежи по выбранному договору");
        System.out.println("5 - Получить сумму всех платежей по выбранному договору");
        System.out.println("6 - Получить список всех платежей");
        System.out.println("7 - Получить список всех договоров с их суммарными платежами");
    }
}
