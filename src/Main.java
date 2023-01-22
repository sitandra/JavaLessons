import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
}