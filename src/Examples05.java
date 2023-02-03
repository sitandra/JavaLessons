import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Examples05 {
    public static void main(String[] args) {
//        System.out.println(ex2("<{a}+{(d*3)}>"));
        System.out.println(ex3("Мороз и солнце день чудесный " +
                "Еще ты дремлешь друг прелестный " +
                "Пора красавица проснись."));
    }

    static TreeMap<Integer, List<String>> ex3(String s){
        /*
        Взять набор строк, например,

        Мороз и солнце день чудесный
        Еще ты дремлешь друг прелестный
        Пора красавица проснись.

        Написать метод, который отсортирует эти строки по длине с помощью TreeMap.
        Строки с одинаковой длиной не должны “потеряться”.
         */
        s = s.replace(".", "");
        String[] words = s.split(" ");
        TreeMap<Integer, List<String>> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        for (String word: words){
            if (treeMap.containsKey(word.length())){
                List<String> list = treeMap.get(word.length());
                list.add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                treeMap.put(word.length(), list);
            }
        }
        return treeMap;
    }
    static boolean ex2(String s){
        /*
        Написать программу, определяющую правильность расстановки скобок в выражении.
        Пример 1: a+(d*3) - истина
        Пример 2: [a+(1*3) - ложь
        Пример 3: [6+(3*3)] - истина
        Пример 4: {a}[+]{(d*3)} - истина
        Пример 5: <{a}+{(d*3)}> - истина
        Пример 6: {a+]}{(d*3)} - ложь
        */
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('>', '<');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            if (map.containsValue(s.charAt(i))){
                stack.push(s.charAt(i));
            }
            if (map.containsKey(s.charAt(i))){
                if (stack.isEmpty() || stack.pop() != map.get(s.charAt(i))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    static boolean ex1(String s1, String s2){
        /*
        Даны 2 строки, написать метод, который вернет true,
        если эти строки являются изоморфными и false, если нет.
        Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву во втором слове, при этом
        повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка следования.
        (Например, add - egg изоморфны)
        буква может не меняться, а остаться такой же. (Например, note - code)
        Пример 1:
        Input: s = "foo", t = "bar"
        Output: false
        Пример 2:
        Input: s = "paper", t = "title"
        Output: true
         */
        if (s1.length() != s2.length()){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            if (map.containsKey(c1[i])){
                if (c2[i] != map.get(c1[i])){
                    return false;
                }
            } else {
                map.put(c1[i], c2[i]);
            }
        }
        return true;
    }
    static void ex0(){
        /*
        Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации.
        123456 Иванов
        321456 Васильев
        234561 Петрова
        234432 Иванов
        654321 Петрова
        345678 Иванов
        Вывести данные по сотрудникам с фамилией Иванов.
         */
        Map<Integer, String> map = new HashMap<>();
        map.put(123456, "Иванов");
        map.put(321456, "Васильев");
        map.put(234561, "Петрова");
        map.put(234432, "Иванов");
        map.put(654321, "Петрова");
        map.put(345678, "Иванов");

        for (Map.Entry entry: map.entrySet()){
            if (entry.getValue().equals("Иванов")){
                System.out.println(entry);
            }
        }
    }
    static void test() {
        Logger logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);

        MyQueue myQueue = new MyQueue();
        int a = 0;
        try {
            a = (int)myQueue.dequeue();
        } catch (Exception e){
            logger.warning("Что-то пошло не так: " + "");
        }
        System.out.println(a);

        fileHandler.close();
    }
}

