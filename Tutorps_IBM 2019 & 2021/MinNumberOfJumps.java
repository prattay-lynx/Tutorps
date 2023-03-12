// You're given a non-empty array of positive integers where each integer
// represents the maximum number of steps you can take forward in the array. For
// example, if the element at index 1 is 3, you can go from index 1 to index 2,
// 3, or 4.

// Write a function that returns the minimum number of jumps needed to reach the
// final index.

// Note that jumping from index i to index i + x always constitutes one jump, no
// matter how large x is.

// Input format
// NOT APPLICABLE

// Output format
// NOT APPLICABLE

// Constraints
// NOT APPLICABLE

// Sample input
// array = [3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3]
// Sample output
// 4 // 3 --> (4 or 2) --> (2 or 3) --> 7 --> 3

public class MinNumberOfJumps {
    public static int minimumJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int jumps = 0, maxReach = nums[0], steps = nums[0];
        for (int i = 1; i < n; i++) {
            if (i == n - 1) {
                return jumps + 1;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                if (i >= maxReach) {
                    return -1;
                }
                steps = maxReach - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = { 3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3 };
        System.out.println(minimumJumps(array)); // expected output: 4
    }
}
