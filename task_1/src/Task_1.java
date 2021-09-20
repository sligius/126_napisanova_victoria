public class Task_1 implements Task_1_base {
    @Override
    public int subtask_1_if(int first, int second, int third) {
        // Вычислить и вернуть минимальный из трех полученных аргументов (first, second, third)
        // ------------------------------------------------------------------------------------
        if(first < second && first < third) {
            return first;//  данный оператор кодом, решающим поставленную задачу.
        }
        else if(second < first && second < third) {
            return second;
        }
        else {
            return third;
        }
    }
    @Override
    public boolean subtask_2_if(int year) {
        // Проверить, является ли год, переданный в параметре year, високосным.
        // Високосный год - это год, кратный четырем, но не кратный 100, либо кратный 400
        // ------------------------------------------------------------------------------------
        if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            return true;// Замените данный оператор кодом, решающим поставленную задачу.
        }
        else {
            return false;
        }
    }
    @Override
    public int subtask_3_if(double x, double y, double left_up_x, double left_up_y, double width, double height) {
        // Проверить, лежит ли точка с координатами (x, y) внутри невырожденного квадрата
        // со сторонами, параллельными осям координат, левый верхний угол которого имеет
        // координаты (left_up_x, left_up_y), ширина которого width, высота height.
        // Точка на границе считается не лежащей внутри.
        // В качестве результата вернуть:
        // 0 - не лежит
        // 1 - лежит
        // 2 - аргументы функции заданы некорректно
        // Допустимой погрешностью при сравнении переменных типа double считать 0.000001
        // ------------------------------------------------------------------------------------
        double eps = 0.000001;
        if((Math.abs(x - left_up_x) > eps) && (x > left_up_x) && (eps < Math.abs(left_up_y - y)) && (y < left_up_y) && (x < (left_up_x + width)) && (Math.abs(x - (left_up_x + width)) > eps) && (Math.abs(y - (left_up_y - height)) > eps) && (y > (left_up_y - height))) {
            return 1;// Замените данный оператор кодом, решающим поставленную задачу.
        }
        else if(width <= 0 || height <= 0) {
            return 2;
        }
        else {
            return 0;
        }
    }
    @Override
    public int subtask_4_if(double x0, double y0, double k, double b) {
        // Проверить, как расположена точка с координатами (x0, y0)
        // относительно прямой y = kx + b
        // В качестве результата вернуть:
        // 0 - лежит выше прямой
        // 1 - лежит ниже прямой
        // 2 - лежит на прямой
        // Допустимой погрешностью при сравнении переменных типа double считать 0.000001
        // ------------------------------------------------------------------------------------
        double eps = 0.000001;
        int result = 0;
        if(Math.abs((k*x0 +b)-y0) <= eps) {
            result = 2;// Замените данный оператор кодом, решающим поставленную задачу.
        }
        else if(Math.abs((k*x0 +b)-y0) > eps && (k*x0 +b) > y0) {
            result = 1;
        }
        else {
            result = 0;
        }
        return result;
    }
    @Override
    public String subtask_5_switch(int day_od_week) {
        // По номеру дня недели day_od_week вернуть его название на русском языке, записанное
        // с большой буквы. Дни недели отсчитываются с единицы. Если номер задан некорректно,
        // вернуть строку "Ошибка"
        // ------------------------------------------------------------------------------------
        String result = "";
        switch (day_od_week) {
            case 1:
                result = "Понедельник";
                break;
            case 2:
                result = "Вторник";
                break;
            case 3:
                result = "Среда";
                break;
            case 4:
                result = "Четверг";
                break;
            case 5:
                result = "Пятница";
                break;
            case 6:
                result = "Суббота";
                break;
            case 7:
                result = "Воскресенье";
                break;
            default:
                result = "Ошибка";
                break;
        }
        return result; // Замените данный оператор кодом, решающим поставленную задачу.
    }
    @Override
    public String subtask_6_switch(int direction) {
        // По заданному направлению direction вернуть его название:
        // 1 - север
        // 2 - юг
        // 3 - запад
        // 4 - восток
        // Во всех остальных случаях вернуть пустую строку
        // ------------------------------------------------------------------------------------
        String result = "";
        switch (direction) {
            case 1:
                result = "север";
                break;
            case 2:
                result = "юг";
                break;
            case 3:
                result = "запад";
                break;
            case 4:
                result = "восток";
                break;
            default:
                result = "";
                break;
        }
        return result; // Замените данный оператор кодом, решающим поставленную задачу.
    }
    @Override
    public int subtask_7_if(double vx, double vy, double vz, double speed, double time, double wall) {
        // Проверить, достигнет ли снаряд, летящий из точки (0, 0, 0)
        // в направлении (vx, vy, vz) со скоростью speed стены, параллельной плоскости OYZ,
        // имеющей координату x равной wall, за время time
        // 0 - не достигнет
        // 1 - достигнет
        // 2 - аргументы функции заданы некорректно
        // Допустимой погрешностью при сравнении переменных типа double считать 0.000001
        // ------------------------------------------------------------------------------------
        double way = (vx * vy);
        double epsilon = 0.000001;
        if(Math.abs(way - wall) <= epsilon && way >= wall) {
            return 1;// Замените данный оператор кодом, решающим поставленную задачу.
        }
        else if(Math.abs(way - wall) > epsilon) {
            return 0;
        }
        else {
            return 2;
        }
    }
    @Override
    public int subtask_8_if(double k1, double b1, double k2, double b2) {
        // Проверить, как друг относительно друга располагаются прямые y = k1*x + b1 и
        // y = k2*x + b2. Вернуть
        // 1 - если параллельны
        // 2 - если пересекаются
        // 3 - если совпадают
        // Допустимой погрешностью при сравнении переменных типа double считать 0.000001
        // ------------------------------------------------------------------------------------
        if(k1 == k2 && b1 == b2) {
            return 3;// Замените данный оператор кодом, решающим поставленную задачу.
        }
        else if(k1 == k2 && b1 != b2) {
            return 1;
        }
        else {
            return 2;
        }
    }
}
