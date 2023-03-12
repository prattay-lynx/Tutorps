import java.util.Arrays;

public class LargestRange {
    public static void main(String[] args) {
        int[] array = { 1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6 };

        Arrays.sort(array);
        // 0 1 2 3 4 5 6 7 10 11 12 15
        int count = 1;
        int max_count = 1;
        int u_bound = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1])
                continue;
            if (array[i] == array[i - 1] + 1) {
                count++;
                if (count > max_count) {
                    max_count = count;
                    u_bound = array[i];
                }
            } else {
                count = 1;
            }
        }
        int l_bound = u_bound - max_count + 1;

        System.out.printf("[%d %d]", l_bound, u_bound);
    }
}
