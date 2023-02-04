public class HeapSort {
    private int[] array;

    public HeapSort(int[] array) {
        this.array = array;
    }

    /**
     * Алгоритм сортировки отсюда: https://habr.com/ru/company/otus/blog/460087/, т.к. сортировать по вики лень и скучно
     * @return
     */
    public int[] sort() {
        int n = array.length;

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heap(n, i);

        // Один за другим извлекаем элементы из кучи   
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываем процедуру heap на уменьшенной куче
            heap(i, 0);
        }
        return array;
    }

    private void heap(int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый
        int r = 2 * i + 2; // правый

        // Если левый дочерний элемент больше корня
        if (l < n && array[l] > array[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && array[r] > array[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heap(n, largest);
        }
    }
}
