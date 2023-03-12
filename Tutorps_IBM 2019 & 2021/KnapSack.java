/*
 * You're given an array of arrays where each subarray holds two integer values
 * and represents an item; the first integer is the item's value, and the second
 * integer is the item's weight. You're also given an integer representing the
 * maximum capacity of a knapsack that you have.
 * 
 * Your goal is to fit items in your knapsack without having the sum of their
 * weights exceed the knapsack's capacity, all the while maximizing their
 * combined value. Note that you only have one of each item at your disposal.
 * 
 * Write a function that returns the maximized combined value of the items that
 * you should pick as well as an array of the indices of each item picked.
 * 
 * If there are multiple combinations of items that maximize the total value in
 * the knapsack, your function can return any of them.
 * 
 * Input format
 * NOT APPLICABLE
 * 
 * Output format
 * NOT APPLICABLE
 * 
 * Constraints
 * NOT APPLICABLE
 * 
 * Sample input
 * items = [[1, 2], [4, 3], [5, 6], [6, 7]]
 * capacity = 10
 * Sample output
 * [10, [1, 3]] // items [4, 3] and [6, 7]
 */

import java.util.*;

public class KnapSack {
    public static int[] knapsackProblem(int[][] items, int capacity) {
        int n = items.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            int value = items[i - 1][0];
            int weight = items[i - 1][1];
            for (int j = 1; j <= capacity; j++) {
                if (j >= weight) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int maxValue = dp[n][capacity];
        List<Integer> indices = new ArrayList<>();
        int i = n, j = capacity;
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                indices.add(i - 1);
                j -= items[i - 1][1];
                i--;
            }
        }
        Collections.reverse(indices);
        int[] result = new int[indices.size() + 1];
        result[0] = maxValue;
        for (i = 0; i < indices.size(); i++) {
            result[i + 1] = indices.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] items = { { 1, 2 }, { 4, 3 }, { 5, 6 }, { 6, 7 } };
        int capacity = 10;
        int[] result = KnapSack.knapsackProblem(items, capacity);
        System.out.println(Arrays.toString(result)); // [10, 1, 3]
    }
}
