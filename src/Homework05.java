import java.util.*;

public class Homework05 {
    public Homework05() {
        task01();
        System.out.println(task02("Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов"));
        task03();
        task04();
    }

    /**
     * Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
     */

    private void task01() {
        PhoneBook pb = new PhoneBook();
        pb.add("Иванов", "+79990000000");
        pb.add("Иванов", "+79991000000");
        pb.add("Петров", "+79992000000");
        pb.add("Козлов", "+79993000000");
        pb.add("Козлов", "+79994000000");
        pb.print();
    }

    /**
     * Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин,
     * Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова,
     * Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. Написать программу, которая найдет и выведет повторяющиеся
     * имена с количеством повторений. Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
     */

    private TreeMap<Integer, List<String>> task02(String s) {
        String[] mans = s.split(", ");
        Map<String, Integer> names = new HashMap<>();
        for (String man : mans) {
            String name = man.split(" ")[0];
            if (names.containsKey(name)) names.put(name, names.get(name) + 1);
            else names.put(name, 1);
        }
        TreeMap<Integer, List<String>> treeMap = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));
        for (var name : names.entrySet()) {
            if (treeMap.containsKey(name.getValue())) {
                List<String> list = treeMap.get(name.getValue());
                list.add(name.getKey());
            } else {
                List<String> list = new ArrayList<>();
                list.add(name.getKey());
                treeMap.put(name.getValue(), list);
            }
        }
        return treeMap;
    }

    /**
     * Реализовать алгоритм пирамидальной сортировки (HeapSort)
     */

    private void task03() {
        int[] array = newRandomIntArray(10);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString((new HeapSort(array)).sort()));
    }

    private int[] newRandomIntArray(int n) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    /**
     * **На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
     * !!! Спасибо за интересную задачу! :)
     */
    private void task04() {
        try {
            QueenProblem qp = (new QueenProblem(8)).toDo();
            System.out.printf("Найдено решений: %s\n", qp.SolutionsCount());
            System.out.println("Первое найденное решение:");
            int[][] board = qp.Solution(1);
            for (int[] line : board) {
                System.out.println(Arrays.toString(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
