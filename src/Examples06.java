import java.util.*;
public class Examples06 {
    public static void main(String[] args) {
        ex2();
    }

    static void ex2(){
        /*
        1. Реализуйте 1 из вариантов класса Cat из предыдущего задания,
        можно использовать не все придуманные поля и методы.
        Создайте несколько экземпляров этого класса, выведите их в консоль.
        2. Добейтесь того, чтобы при выводе в консоль объекта типа Cat,
        выводилась его кличка, цвет и возраст (или другие параметры на ваше усмотрение).

         */

        /*
        1. Создайте множество, в котором будут храниться экземпляры класса Cat - HashSet<Cat>.
        Поместите в него некоторое количество объектов.
        2. Создайте 2 или более котов с одинаковыми параметрами в полях. Поместите их во множество.
        Убедитесь, что все они сохранились во множество.
        3. Создайте метод public boolean equals(Object o)
        Пропишите в нём логику сравнения котов по параметрам, хранимым в полях.
        То есть, метод должен возвращать true, только если значения во всех полях сравниваемых объектов равны.
        4. Выведите снова содержимое множества из пункта 2, убедитесь, что дубликаты удалились.
         */
        Cat cat = new Cat();
        cat.name = "Васька";
        cat.age = 5;
        cat.ownerName = "Василий Петрович";

        Cat cat1 = new Cat();
        cat1.name = "Васька";
        cat1.age = 5;
        cat1.ownerName = "Василий Петрович";

        Set<Cat> cats = new HashSet<>();
        cats.add(cat);
        cats.add(cat1);

        System.out.println(cats);
    }

    static void ex1(){
        /*
        1. Напишите метод, который заполнит массив из 1000 элементов случайными цифрами от 0 до 24.
        2. Создайте метод, в который передайте заполненный выше массив и с помощью Set
        вычислите процент уникальных значений в данном массиве и верните его в виде числа с плавающей запятой.
        Для вычисления процента используйте формулу:
        процент уникальных чисел = количество уникальных чисел * 100 / общее количество чисел в массиве.
         */
        System.out.println(percentUniq(rndArr(10, 0, 10)));
    }
    static Integer[] rndArr(int count, int min, int max){
        Integer[] arr = new Integer[count];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * (max - min) + min);
            arr[i] = random.nextInt(max-min+1) + min;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    static double percentUniq(Integer[] arr){
        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        System.out.println(set);
        return set.size() * 100.0 / arr.length;
    }
    static void ex0(){
        /*
        1. Создайте HashSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6, 3}.
        Распечатайте содержимое данного множества.
        2. Создайте LinkedHashSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6, 3}.
        Распечатайте содержимое данного множества.
        3. Создайте TreeSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6, 3}.
        Распечатайте содержимое данного множества.
         */
        Integer[] arr = new Integer[]{5, 2, 3, 2, 1, 4, 6, 3};
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(arr));
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>(Arrays.asList(arr));
        TreeSet<Integer> set3 = new TreeSet<>(Arrays.asList(arr));

        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);
    }
}
