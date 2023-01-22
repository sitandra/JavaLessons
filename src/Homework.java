import java.util.ArrayList;
import java.util.List;

public class Homework {
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
