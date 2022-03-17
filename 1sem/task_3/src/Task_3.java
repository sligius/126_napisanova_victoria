public class Task_3 implements Task_3_base {
    @Override
    public int subtask_1_for(int n1, int n2, int a, int b) {
        // подсчитать, сколько чисел, кратных a, но не кратных b,
        // находится между числами n1 и n2 включительно
        int x = 0;
        if (n1 > n2) {
            for (int i = n2; i <= n1; ++i) {
                if (i % a == 0 && i % b != 0) {
                    ++x;
                }
            }
        }
        else {
            for (int i = n1; i <= n2; ++i) {
                if (i % a == 0 && i % b != 0) {
                    ++x;
                }
            }
        }
        return x;
    }

    @Override
    public int subtask_2_for(int num) {
        // Последовательность чисел строится следующим образом:
        // сначала идет одна единица,
        // потом две двойки,
        // потом три тройки,
        // ...
        // потом n раз число n
        // ...
        // Найти, какое число будет находиться в этой последовательности
        // на позиции num
        int x = 0;
        for (int i = 1, y = 1; y <= num; ++i) {
            y = y + i;
            x = i;
        }
        return x;
    }

    @Override
    public int subtask_3_for(int num, int d, int cnt) {
        // Дана последовательность
        // a(0) = num
        // a(n) = a(n - 1) * d + 1
        // Найти сумму первых cnt элементов последовательности
        int a = num;
        int a0 = num;
        int an;
        for (int i = 1; i < cnt; ++i) {
            an = a0 * d + 1;
            a0 = an;
            a = a + a0;
        }
        return a;
    }

    @Override
    public int subtask_4_for(int n) {
        // Вычислить сумму
        // S(n) = 1 + 1 * 2 + 1 * 2 * 3 + ... + n!
        // для заданного n
        // (n! - это n-факториал. Кто не знает - гуглите)
        int sn = 1;
        int x = 0;
        for (int i = 1; i <= n; ++i) {
            sn = sn * i;
            x = x + sn;
        }
        return x;
    }
}
