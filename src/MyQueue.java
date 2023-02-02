import java.util.LinkedList;

public class MyQueue extends LinkedList {

    /**
     * помещает элемент в конец очереди
     */
    public MyQueue enqueue(Object e) {
        this.addLast(e);
        return this;
    }

    /**
     * возвращает первый элемент из очереди и удаляет его
     */
    public Object dequeue() {
        Object e = this.getFirst();
        this.removeFirst();
        return e;
    }

    /**
     * возвращает первый элемент из очереди, не удаляя
     */
    public Object first() {
        return this.getFirst();
    }
}
