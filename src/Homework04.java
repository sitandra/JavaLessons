import java.util.*;

public class Homework04 {

    public Homework04() {
        // task 1
        LinkedList<Integer> list = newRandomIntegerLinkedList(10);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(Arrays.toString(task01(list).toArray()));
        // task 2
        MyQueue myQueue = task02();
        System.out.println(Arrays.toString(myQueue.toArray()));
        myQueue.enqueue(6);
        System.out.println(Arrays.toString(myQueue.toArray()));
        myQueue.dequeue();
        System.out.println(Arrays.toString(myQueue.toArray()));
        System.out.println(myQueue.first());
        System.out.println(Arrays.toString(myQueue.toArray()));
        // task 3
        System.out.printf("sum = %s\n", task03(list));
    }

    private LinkedList<Integer> newRandomIntegerLinkedList(int n) {
        Random random = new Random();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(100));
        }
        return list;
    }

    /**
     * Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
     */
    private LinkedList<Integer> task01(LinkedList<Integer> list) {
        LinkedList<Integer> resultList = new LinkedList<>();
        for (Integer item:
             list) {
            resultList.addFirst(item);
        }
        return resultList;
    }

    /** Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает элемент в конец очереди,
     * dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
     */
    private MyQueue task02() {
        MyQueue myQueue = new MyQueue();
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);
        return myQueue;
    }

    /** Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор
     */
    private Integer task03(LinkedList<Integer> list) {
        Integer sum = 0;
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            iterator.remove();
            sum += integer;
        }
        return sum;
    }
}
