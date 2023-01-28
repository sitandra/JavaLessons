import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Homework02 {
    public static Scanner scanner = new Scanner(System.in);
    private Logger logger;

    public Homework02() {
        logger = Logger.getAnonymousLogger();
        logger.log(Level.INFO, "Запуск выполнения домашнего задания №2");
        SimpleFormatter formatter = new SimpleFormatter();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("files/log.txt");
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);
        StringBuilder result = task1("{{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\"" +
                ":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}}");
        System.out.println(result);
        task2(result.toString(), "files/homework2.txt");
        String json = task3("files/homework2.json");
        System.out.println(task1(json));
        int[] array = task4(new int[]{6,4,3,6,7,2,1,7,9,5});
        System.out.println(Arrays.toString(array));
    }

    /**
     * Дана json строка {{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4",
     * "предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}} Задача написать метод(ы),
     * который распарсить строку и выдаст ответ вида: Студент Иванов получил 5 по предмету Математика. Студент
     * Петрова получил 4 по предмету Информатика. Студент Краснов получил 5 по предмету Физика.
     * Используйте StringBuilder для подготовки ответа
     */

    public StringBuilder task1(String jsonText) {
        logger.log(Level.INFO, "Выполняется задание #1");
        Pattern pattern = Pattern.compile("\"фамилия\":\"([^\"]+)\",\"оценка\":\"([^\"]+)\",\"предмет\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(jsonText);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            if (!result.isEmpty()) result.append(" ");
            result.append(compileDescription(matcher.group(1), matcher.group(2), matcher.group(3)));
        }
        return result;
    }

    private StringBuilder compileDescription(String student, String grade, String subject) {
        logger.log(Level.INFO, "Обрабатывается студент " + student);
        StringBuilder builder = new StringBuilder();
        builder.append("Студент ").append(student)
                .append(" получил ").append(grade)
                .append(" по предмету ").append(subject).append(".");
        return builder;
    }


    /**
     * Создать метод, который запишет результат работы в файл. Обработайте исключения и запишите ошибки в лог файл
     */
    public void task2(String text, String filePath) {
        logger.log(Level.INFO, "Выполняется задание #2");
        try {
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(text);
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Получить исходную json строку из файла, используя FileReader или Scanner
     */
    public String task3(String filePath) {
        logger.log(Level.INFO, "Выполняется задание #3");
        try {
            StringBuilder text = new StringBuilder();
            File file = new File(filePath);
            BufferedReader bufReader = new BufferedReader(new FileReader(file));
            while(bufReader.ready()) {
                text.append(bufReader.readLine());
            }
            bufReader.close();
            return text.toString();
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
     */
    public int[] task4(int[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    logger.log(Level.INFO, "Меняем " + j + " и " + (j + 1) + " элементы");
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
