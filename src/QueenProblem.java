import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueenProblem {

    private final int[][] board;
    private final int size;
    private final int[] idx;

    private final List<int[][]> solutions;
    private int solutionsCounts;

    public QueenProblem(int size) {
        this.size = size;
        this.board = new int[size][size];
        this.idx = new int[size];
        this.solutions = new ArrayList<>();
    }

    public QueenProblem toDo() {
        solutionsCounts = 0;
        InitIndexSet();
        while (NextIndexSet()) { // будет size! перестановок
            SetBoard(); // формируем массив по новой перестановке индексов
            if (CheckBoard()) {
                solutionsCounts++;
                int[][] solution = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
                solutions.add(solution);
            }
        }
        return this;
    }

    private void InitIndexSet() {
        for (int i = 0; i < size; i++)
            idx[i] = i;
    }

    /**
     * Вернет n-ое решение
     * @param n решение по порядку
     * @return Решение
     * @throws Exception Если решений нет
     */
    public int[][] Solution(int n) throws Exception {
        return solutions.get(n-1);
        //throw new Exception("Задача не решена");
    }

    public int SolutionsCount() {
        return solutionsCounts;
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
        int n = size;
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
            if (Diagonal1IsBroken(i, 0)) return false;
        }
        for (int j = 1; j < n; j++) {
            if (Diagonal1IsBroken(0, j)) return false;
        }
        for (int i = 1; i <= n; i++) {
            if (Diagonal2IsBroken(i, 0)) return false;
        }
        for (int j = 1; j < n; j++) {
            if (Diagonal2IsBroken(7, j)) return false;
        }
        return true;
    }

    private boolean Diagonal1IsBroken(int i, int j) {
        int sum = 0;
        while (i < size && j < size) {
            sum += board[i][j];
            i++;
            j++;
        }
        return sum > 1;
    }

    private boolean Diagonal2IsBroken(int i, int j) {
        int sum = 0;
        while (i >= 0 && j < size) {
            sum += board[i][j];
            i--;
            j++;
        }
        return sum > 1;
    }
}
