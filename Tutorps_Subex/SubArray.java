
public class SubArray {

    public static int[] subarraySort(int[] array) {
        int n = array.length;
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num = array[i];
            if (isOutOfOrder(i, num, array)) {
                minOutOfOrder = Math.min(minOutOfOrder, num);
                maxOutOfOrder = Math.max(maxOutOfOrder, num);
            }
        }

        if (minOutOfOrder == Integer.MAX_VALUE) {
            return new int[] { -1, -1 };
        }

        int leftIdx = 0;
        while (minOutOfOrder >= array[leftIdx]) {
            leftIdx++;
        }

        int rightIdx = n - 1;
        while (maxOutOfOrder <= array[rightIdx]) {
            rightIdx--;
        }

        return new int[] { leftIdx, rightIdx };
    }

    public static boolean isOutOfOrder(int i, int num, int[] array) {
        if (i == 0) {
            return num > array[i + 1];
        }
        if (i == array.length - 1) {
            return num < array[i - 1];
        }
        return num < array[i - 1] || num > array[i + 1];
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
        int[] output = subarraySort(array);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }

    }
}
