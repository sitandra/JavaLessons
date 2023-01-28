import netscape.javascript.JSObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Examples02 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println(ex0(6, 'a', 'b'));
//        System.out.println(ex1("aaaabbbcddf"));

//        String s = "TEST";
//        int n = 100;
//        String filePath = "/a/sa/a/a/atest.txt";
//        ex2(s, n, filePath);
        System.out.println(readFile("log.txt"));
    }

    static void ex2(String s, int n, String filePath){
        /*
        Напишите метод, который составит строку,
        состоящую из 100 повторений слова TEST и метод,
        который запишет эту строку в простой текстовый файл, обработайте исключения.
         */

        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.INFO, "Все хорошо");
        SimpleFormatter formatter = new SimpleFormatter();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt");
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(s);
        }
        try (FileWriter fileWriter = new FileWriter(filePath, false)) {
            fileWriter.write(stringBuilder.toString());
        } catch (Exception e){
            logger.log(Level.WARNING, e.getMessage());
            e.printStackTrace();
        }
    }

    static String readFile(String filePath){
        File file = new File("log.txt");
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append("\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    static String ex0(int n, char c1, char c2){
        /*
Дано четное число N (>0) и символы c1 и c2.
Написать метод, который вернет строку длины N,
которая состоит из чередующихся символов c1 и c2, начиная с c1.
Ответ: c1c2c1…c2 (всего N символов)

 */
        if (n%2 != 0 || n <= 0){
            return "значение n не подходит под условие задачи";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n / 2; i++) {
            stringBuilder.append(c1);
            stringBuilder.append(c2);
        }

        return stringBuilder.toString();
    }
    static String ex1(String s){
        /*
Напишите метод, который сжимает строку.
Пример: вход aaaabbbcdd.
Результат: a4b3cd2

 */
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)){
                count++;
            } else {
                stringBuilder.append(s.charAt(i-1));
                if (count != 1){
                    stringBuilder.append(count);
                }
                count = 1;
            }
        }

        stringBuilder.append(s.charAt(s.length()-1));
        if (count != 1){
            stringBuilder.append(count);
        }
        return stringBuilder.toString();
    }
}

