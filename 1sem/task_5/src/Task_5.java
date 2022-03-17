import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Task_5 implements Task_5_base {
    @Override
    public ArrayList<Integer> subtask_1_ArrayList(ArrayList<Integer> data, int k, int n) {
        // Выбрать из данного списка элементы, кратные k, но не кратные n
        // и сформировать из них новый список.
        // Вернуть новый список в качестве результата
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < data.size(); ++i) {
            if (data.get(i) % k == 0 && data.get(i) % n != 0) {
                a.add(data.get(i));
            }
        }
        return a;
    }

    @Override
    public ArrayList<Integer> subtask_2_ArrayList(int size) {
        // сгенерировать и вернуть список размера size,
        // содержащий первые size элементов последовательности, описанной в
        // задаче subtask_2_for задания task_3
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0, x = 0; x < size; ++i) {
            for (int j = 0; x < size && j < i; ++j, ++x) {
                a.add(i);
            }
        }
        return a;
    }

    @Override
    public HashSet<Integer> subtask_3_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите пересечение множеств s1 и s2
        s1.retainAll(s2);
        return s1;
    }

    @Override
    public HashSet<Integer> subtask_4_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите объединение множеств s1 и s2
        s1.addAll(s2);
        return s1;
    }

    @Override
    public HashSet<Integer> subtask_5_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите дополнение множества s1 до множества s2
        s2.removeAll(s1);
        return s2;
    }

    @Override
    public HashSet<Integer> subtask_6_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // постройте множество, содержащее элементы, содержащиеся либо только в s1,
        // либо только в s2, но не в обоих множествах одновременно
        HashSet<Integer> com = new HashSet<>(s1);
        HashSet<Integer> x1 = new HashSet<>(s1);
        HashSet<Integer> x2 = new HashSet<>(s2);

        com.retainAll(s2);
        x1.removeAll(com);
        x2.removeAll(com);

        HashSet<Integer> f = new HashSet<>(x1);
        f.addAll(x2);

        return f;
    }

    @Override
    public HashMap<String, Double> subtask_7_HashMap(ArrayList<String> data) {
        // Дан список строк. Построить словарь, содержащий частоты слов
        // для данного списка в процентах
        HashMap<String,Double> words = new HashMap<>();
        for (int i = 0; i < data.size(); ++i) {
            double frequency = 0;
            for (int j = 0; j < data.size(); ++j) {
                if (data.get(i) == data.get(j)){
                    ++frequency;
                }
            }
            frequency = frequency * 100 / data.size();
            words.put(data.get(i), frequency);
        }

        return words;
    }

    @Override
    public HashMap<String, Double> subtask_8_HashMap(ArrayList<Double> data) {
        // Дан список чисел. Сформировать словарь, содержащий среднее,
        // максимальное и минимальное значения из данного списка. Ключи
        // словаря "mean", "max", "min" соответственно
        HashMap<String, Double> numbers = new HashMap<>();
        double max = data.get(0);
        double min = data.get(0);
        double mean = 0;

        for (int i = 0; i < data.size(); ++i) {
            if (data.get(i) < min) {
                min = data.get(i);
            }
            if (data.get(i) > max) {
                max = data.get(i);
            }
            mean = mean + data.get(i);
        }
        mean = mean / data.size();

        numbers.put("max", max);
        numbers.put("min", min);
        numbers.put("mean", mean);

        return numbers;
    }
}
