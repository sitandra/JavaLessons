import java.util.*;
import java.util.stream.IntStream;

public class Homework03 {

    private int max;
    private int min;
    private float srv;

    public Homework03() {
        List<Integer> list = newRandomIntegerList(40);
        System.out.println(Arrays.toString(list.toArray()));
        task1(list);
        System.out.println(Arrays.toString(list.toArray()));
        task2(list);
        System.out.printf("Максимальное %s\n", max);
        System.out.printf("Минимальное %s\n", min);
        System.out.printf("Среднее арифметическое %s\n", srv);
        List<Integer> sortList = task3(list);
        System.out.println(Arrays.toString(sortList.toArray()));
    }

    private List<Integer> newRandomIntegerList(int n) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(100));
        }
        return list;
    }

    /**
     * Пусть дан произвольный список целых чисел, удалить из него четные числа
     */

    private void task1(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
    }

    /**
     * Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
     * Collections.max()
     */

    private void task2(List<Integer> list) {
        max = Collections.max(list);
        min = Collections.min(list);
        srv = 0;
        for (Integer num : list) {
            srv += num;
        }
        srv = srv / list.size();
    }

    /**
     * *Реализовать алгоритм сортировки слиянием
     */

    private List<Integer> task3(List<Integer> list) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if (list.size() <= 1) return list;
        else {
            int middle = list.size() / 2;
            for (int i = 0; i < middle; i++) {
                left.add(list.get(i));
            }
            for (int i = middle; i < list.size(); i++) {
                right.add(list.get(i));
            }
            left = task3(left);
            right = task3(right);
            result = merge(left, right);
            return result;
        }
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        while (left.size() > 0 && right.size() > 0) {
            if (left.get(0) <= right.get(0)) {
                result.add(left.get(0));
                left.remove(0);
            } else {
                result.add(right.get(0));
                right.remove(0);
            }
        }
        while (left.size() > 0) {
            result.add(left.get(0));
            left.remove(0);
        }
        while (right.size() > 0) {
            result.add(right.get(0));
            right.remove(0);
        }
        return result;
    }
}
