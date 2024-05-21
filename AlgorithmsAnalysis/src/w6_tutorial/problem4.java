package w6_tutorial;

public class problem4 {
    int[] borad;
    int BOARD_SIZE = 8;
    boolean ALL = false;
    boolean stop = false;

    public problem4() {
        borad = new int[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            borad[i] = i;
        }
    }

    public void start() {
        permute(new boolean[BOARD_SIZE], new int[BOARD_SIZE], 0);
    }

    public void permute(boolean[] taken, int[] current, int index) {
        if (stop) {
            return;
        }

        if (index == BOARD_SIZE) {
            process(current);
            return;
        }

        for (int i = 0; i < borad.length; i++) {
            if (taken[i]) {
                continue;
            }

            current[index] = borad[i];
            taken[i] = true;
            if (!pruning(current, index)) {
                permute(taken, current, index + 1);
            }
            taken[i] = false;
        }
    }

    void process(int[] cols) {
        System.out.print("Board configuration: ");
        for (int colValue : cols) {
            System.out.print(colValue + " ");
        }
        System.out.println();
        if (!ALL) {
            // one solution is enough
            stop = true;
            processWithMoreBeautiful(cols);
        }
    }

    void processWithMoreBeautiful(int[] cols) {
        System.out.println("Board configuration");
        char[][] board = new char[][] {
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
        };
        for (int c = 0; c < cols.length; c++) {
            board[cols[c]][c] = 'Q';
        }
        for (int r = 0; r < cols.length; r++) {
            System.out.println(new String(board[r]));
        }
    }

    boolean pruning(int[] current, int newIdx) {
        // same row?
        // do not need to check (why?)

        // same diagonal - (bottom left) -> (top right)
        // and (top left) -> (bottom right)
        for (int col = newIdx - 1; col >= 0; col--) {
            if (Math.abs(current[col] - current[newIdx]) == Math.abs(newIdx - col)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        problem4 p = new problem4();
        p.start();
    }
}
