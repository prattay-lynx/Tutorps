/*
! Write a function that takes in an integer matrix of potentially unequal height and width and returns the minimum number of passes required to convert all negative integers in the matrix to positive integers.
! A negative integer in the matrix can only be converted to a positive integer if one or more of its adjacent elements is positive. An adjacent element is an element that is to the left, to the right, above, or below the current element in the matrix. Converting a negative to
! a positive simply involves multiplying it by -1.
! Note that the 0 value is neither positive nor negative, meaning that a 0 can't convert an adjacent negative to a positive.
! A single pass through the matrix involves converting all the negative
! integers that can be converted at a particular point in time. For example, consider the following input matrix:

[ 
  ? [0, -2, -1], 
  ? [-5, 2, 0], 
  ? [-6, -2, 0],
]
After a first pass, only 3 values can be converted to positives:

[ 
  [0, 2, -1], 
  [5, 2, 0], 
  [-6, 2, 0],
]
After a second pass, the remaining negative values can all be converted to positives:

[ 
  [0, 2, 1], 
  [5, 2, 0], 
  [6, 2, 0],
]
Note that the input matrix will always contain at least one element. 
If the negative integers in the input matrix can't all be converted to positives, regardless of how many passes are run, your function should return -1.

Input format
NOT APPLICABLE

Output format
NOT APPLICABLE

Constraints
NOT APPLICABLE

Sample input
matrix = [
  [0, -1, -3, 2, 0],
  [1, -2, -5, -1, -3],
  [3, 0, 0, -4, -1],
]
Sample output
3*/

import java.util.LinkedList;
import java.util.Queue;

public class MinimumPasses {

    public static int minPasses(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int passes = 0;

        // Initialize the queue with all the cells containing negative integers
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < 0) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                // Check the adjacent cells and add to the queue if they contain negative
                // integers
                if (row > 0 && matrix[row - 1][col] < 0) {
                    matrix[row - 1][col] *= -1;
                    queue.offer(new int[] { row - 1, col });
                }
                if (row < rows - 1 && matrix[row + 1][col] < 0) {
                    matrix[row + 1][col] *= -1;
                    queue.offer(new int[] { row + 1, col });
                }
                if (col > 0 && matrix[row][col - 1] < 0) {
                    matrix[row][col - 1] *= -1;
                    queue.offer(new int[] { row, col - 1 });
                }
                if (col < cols - 1 && matrix[row][col + 1] < 0) {
                    matrix[row][col + 1] *= -1;
                    queue.offer(new int[] { row, col + 1 });
                }
            }
            passes++;
        }

        return passes - 1; // Subtract 1 because the last pass does not count
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, -1, -3, 2, 0 },
                { 1, -2, -5, -1, -3 },
                { 3, 0, 0, -4, -1 }
        };

        int minPasses = minPasses(matrix);

        System.out.println(minPasses);
    }
}
