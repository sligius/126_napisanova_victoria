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
    }

    private static void callMenu() {
        System.out.println("Система учёта платежей по договорам. Вводите все данные предельно внимательно.");
        System.out.println("1 - Добавить договор");
        System.out.println("2 - Зарегистрировать платёжный документ");
        System.out.println("3 - Удалить платёж");
        System.out.println("4 - Найти все платежи по выбранному договору");
        System.out.println("5 - Получить сумму всех платежей по выбранному договору");
        System.out.println("6 - Получить список всех платежей");
        System.out.println("7 - Получить список всех договоров с их суммарными платежами");
    }
}
