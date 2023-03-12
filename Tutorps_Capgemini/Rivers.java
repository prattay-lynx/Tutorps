import java.util.ArrayList;

public class Rivers {

    // static int rows = 20;
    // static int cols =
    public static int rivercheck(int i, int j, int rivers[][]) {
        if (i > -1 && i < 5 && j < 5 && j > -1 && rivers[i][j] == 1) {
            rivers[i][j] = 2;
            return 1 + rivercheck(i, j - 1, rivers) + rivercheck(i - 1, j, rivers) + rivercheck(i, j + 1, rivers)
                    + rivercheck(i + 1, j, rivers); // left ,right,down,up
        }
        return 0;
    }

    public static void main(String[] args) {
        int rivers[][] = { { 1, 0, 0, 1, 0 },
                { 1, 0, 1, 0, 0 },
                { 0, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 0 }
        };

        ArrayList<Integer> riversize = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                {
                    if (rivers[i][j] == 0)
                        continue;
                    riversize.add(rivercheck(i, j, rivers));
                }
            }
        }
        int n = riversize.size();
        for (int i = 0; i < n; i++) {
            if (riversize.get(i) == 0) {
                continue;
            } else
                System.out.print(riversize.get(i) + " ");
        }
    }
}