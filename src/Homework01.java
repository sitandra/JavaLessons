import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Homework01 {

    public Homework01() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Задача #1. Введите n");
            int n = scanner.nextInt();
            System.out.printf("Треугольное число от %s: %s\n", n, Homework01.task1(n));

            System.out.println("Задача #2. Введите n");
            n = scanner.nextInt();
            System.out.printf("%s! = %s\n", n, Homework01.task2(n));
            System.out.printf("Задача #3. Простые числа от 1 до 1000: %s\n", Arrays.toString(Homework01.task3()));
            // Arrays.stream(Homework.task3()).forEach(System.out::println);

            System.out.println("Задача #4. Калькулятор. Введите первое число:");
            float number1 = scanner.nextFloat();
            System.out.println("Введите второе число:");
            float number2 = scanner.nextFloat();
            System.out.println("Введите операцию (+, -, *, /):");
            char operation = scanner.next().charAt(0);
            System.out.printf("%s %s %s = %s\n", number1, operation, number2, Homework01.task4(number1, number2, operation));

        } catch (Exception e) {
            System.out.printf("Ошибка: %s", e.getMessage());
        }
    }
    /**
     * Вычислить n-ое треугольного число(сумма чисел от 1 до n)
     */
    static public int task1(int n) {
        return n * (n + 1) / 2;
    }

    /**
     * Вычислить n! (произведение чисел от 1 до n)
     */
    static public int task2(int n) {
        if (n == 0) return 1;
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    /**
     * Вывести все простые числа от 1 до 1000 (простые числа - это числа которые делятся только на себя и на единицу без остатка.
     * Чтобы найти остаток от деления используйте оператор % , например 10%3 будет равно единице)
     */
    static public Integer[] task3() {
        List<Integer> simple_numbers = new ArrayList<>();
        for (int n = 1; n < 1000; n++) {
            if (isSimple(n)) simple_numbers.add(n);
        }
        Integer[] result = new Integer[simple_numbers.size()];
        simple_numbers.toArray(result);
        return result;
    }

    static private boolean isSimple(int n) {
        for (int d = 2; d < n-1; d++) {
            if (n % d == 0) return false;
        }
        return true;
    }

    /**
     * Реализовать простой калькулятор ("введите первое число"... "Введите второе число"...
     * "укажите операцию, которую надо выполнить с этими числами"... "ответ: ...")
     */
    static public float task4(float number1, float number2, char operation) throws Exception {
        switch (operation){
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '*':
                return number1 * number2;
            case '/':
                return number1 / number2;
            default:
                throw new Exception("Неизвестная операция");
        }
    }

    /**
     * * Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
     * например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
     * Предложить хотя бы одно решение или сообщить, что его нет.
     */
    static public void task5() {

    }
}
