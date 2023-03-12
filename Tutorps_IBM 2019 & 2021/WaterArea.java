/*
You're given an array of non-negative integers where each non-zero integer represents the height of a pillar of width 1. 
Imagine water being poured over all of the pillars; 
write a function that returns the surface area of the water trapped between the pillars viewed from the front. 
Note that spilled water should be ignored.

You can refer to the first three minutes of this question's video explanation for a visual example.

Input format
NOT APPLICABLE

Output format
NOT APPLICABLE

Constraints
NOT APPLICABLE

Sample input
heights = [0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3]
Sample output
48

// Below is a visual representation of the sample input.
// The dots and vertical lines represent trapped water and pillars, respectively.
// Note that there are 48 dots.
//        |
//        |
//  |.....|
//  |.....|
//  |.....|
//  |..|..|
//  |..|..|
//  |..|..|.....|
//  |..|..|.....|
// _|..|..|..||.|
 */

public class WaterArea {
    public static int getTrappedWater(int[] heights) {
        int n = heights.length;
        if (n < 3)
            return 0;

        int[] leftMax = new int[n];
        leftMax[0] = heights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }

        return water;
    }

    public static void main(String[] args) {
        int[] heights = { 0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3 };
        System.out.println(getTrappedWater(heights)); // Output: 48
    }
}
