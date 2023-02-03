public class QueenProblem {

    private int[][] board;
    private int size;
    private int[] idx;

    public QueenProblem(int size) {
        this.size = size;
        this.board = new int[size][size];
    }

    private void InitIndexSet() {
        idx = new int[size];
        for (int i = 0; i < size; i++)
            idx[i] = i;
    }

    /**
     * Вернет n-ое решение
     * @param n решение по порядку
     * @return
     * @throws Exception Если решений нет
     */
    public int[][] Solution(int n) throws Exception {
        int count = 0;
        InitIndexSet();
        while (NextIndexSet()) { // будет size! перестановок
            SetBoard(); // формируем массив по новой перестановке индексов
            if (CheckBoard()) {
                count++;
                if (count == n) return board;
            }
        }
        throw new Exception("Задача не решена");
    }

    public int SolutionsCount() {
        int count = 0;
        InitIndexSet();
        while (NextIndexSet()) { // будет size! перестановок
            SetBoard(); // формируем массив по новой перестановке индексов
            if (CheckBoard()) {
                count++;
                // System.out.println(count);
            }
        }
        return count;
    }

    /**
     * Заполняет шахматную доску по текущей перестановке
     */
    private void SetBoard() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                board[i][j] = 0;
        for (int i = 0; i < size; i++)
            board[i][idx[i]] = 1;
    }

    /**
     * Создает уникальную перестановку последовательных чисел
     */
    private boolean NextIndexSet() {
        int n = idx.length;
        int j = n - 2;
        while (j != -1 && idx[j] >= idx[j + 1]) j--;
        if (j == -1)
            return false; // больше перестановок нет
        int k = n - 1;
        while (idx[j] >= idx[k]) k--;
        SwapInIndexSet(j, k);
        int l = j + 1, r = n - 1; // сортируем оставшуюся часть последовательности
        while (l < r)
            SwapInIndexSet(l++, r--);
        return true;
    }

    private void SwapInIndexSet(int i, int j) {
        int s = idx[i];
        idx[i] = idx[j];
        idx[j] = s;
    }

    /**
     * Проверяем диагонали доски, чтобы сумма чисел каждой диагонали не превышала 1
     */
    private boolean CheckBoard() {
        int n = size - 1;
        for (int i = 0; i < n; i++) {
            if (!CheckDiagonal1(i, 0)) return false;
        }
        for (int j = 1; j < n; j++) {
            if (!CheckDiagonal1(0, j)) return false;
        }
        for (int i = 1; i <= n; i++) {
            if (!CheckDiagonal2(i, 0)) return false;
        }
        for (int j = 1; j < n; j++) {
            if (!CheckDiagonal2(7, j)) return false;
        }
        return true;
    }

    private boolean CheckDiagonal1(int i, int j) {
        int max = board.length;
        int sum = 0;
        while (i < max && j < max) {
            sum += board[i][j];
            i++;
            j++;
        }
        if (sum > 1) return false;
        return true;
    }

    private boolean CheckDiagonal2(int i, int j) {
        int max = board.length;
        int sum = 0;
        while (i >= 0 && j < max) {
            sum += board[i][j];
            i--;
            j++;
        }
        if (sum > 1) return false;
        return true;
    }
}
