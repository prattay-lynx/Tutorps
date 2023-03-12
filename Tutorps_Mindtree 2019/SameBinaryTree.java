import java.util.*;

public class SameBinaryTree {
    public static boolean isSameBST(int[] BST1, int[] BST2, int n) {
        if (n == 0) {
            return true;
        }
        if (BST1[0] != BST2[0]) {
            return false;
        }

        if (n == 1) {
            return true;
        }
        int[] leftBST1 = new int[n - 1];
        int[] rightBST1 = new int[n - 1];
        int[] leftBST2 = new int[n - 1];
        int[] rightBST2 = new int[n - 1];

        int k = 0, l = 0, m = 0, o = 0;

        for (int i = 1; i < n; i++) {

            if (BST1[i] < BST1[0]) {
                leftBST1[k++] = BST1[i];
            }

            else {
                rightBST1[l++] = BST1[i];
            }

            if (BST2[i] < BST2[0]) {
                leftBST2[m++] = BST2[i];
            }

            else {
                rightBST2[o++] = BST2[i];
            }
        }
        if (k != m) {
            return false;
        }

        if (l != o) {
            return false;
        }
        return isSameBST(leftBST1, leftBST2, k) && isSameBST(rightBST1, rightBST2, l);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrayone[] = { 10, 15, 8, 12, 94, 81, 5, 2, 11 };
        int arrayTwo[] = { 10, 8, 5, 15, 2, 12, 11, 94, 81 };

        System.out
                .println((isSameBST(arrayone, arrayTwo, arrayTwo.length) && arrayTwo.length == arrayone.length) ? "true"
                        : "false");

    }
}
