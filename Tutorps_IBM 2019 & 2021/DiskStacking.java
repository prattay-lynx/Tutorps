
/*
 * You're given a non-empty array of arrays where each subarray holds three
 * integers and represents a disk. These integers denote each disk's width,
 * depth, and height, respectively. Your goal is to stack up the disks and to
 * maximize the total height of the stack. A disk must have a strictly smaller
 * width, depth, and height than any other disk below it.
 * 
 * Write a function that returns an array of the disks in the final stack,
 * starting with the top disk and ending with the bottom disk. Note that you
 * can't rotate disks; in other words, the integers in each subarray must
 * represent [width, depth, height] at all times.
 * 
 * You can assume that there will only be one stack with the greatest total
 * height.
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
 * disks = [[2, 1, 2], [3, 2, 3], [2, 2, 8], [2, 3, 4], [1, 3, 1], [4, 4, 5]]
 * Sample output
 * [[2, 1, 2], [3, 2, 3], [4, 4, 5]]
 * // 10 (2 + 3 + 5) is the tallest height we can get by
 * // stacking disks following the rules laid out above.
 */
import java.util.*;

class Solution {
    public static List<List<Integer>> diskStacking(List<List<Integer>> disks) {
        Collections.sort(disks, (a, b) -> a.get(2) - b.get(2));
        int n = disks.size();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int maxHeight = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            int currHeight = disks.get(i).get(2);
            for (int j = i - 1; j >= 0; j--) {
                List<Integer> prevDisk = disks.get(j);
                if (prevDisk.get(0) < disks.get(i).get(0) && prevDisk.get(1) < disks.get(i).get(1)
                        && prevDisk.get(2) < disks.get(i).get(2)) {
                    if (dp[j] == -1 || dp[i] < dp[j] + currHeight) {
                        dp[i] = dp[j] + currHeight;
                        if (dp[i] > maxHeight) {
                            maxHeight = dp[i];
                            end = i;
                        }
                    }
                }
            }
            if (dp[i] == -1)
                dp[i] = currHeight;
        }

        List<List<Integer>> res = new ArrayList<>();
        while (end != -1) {
            res.add(0, disks.get(end));
            end = dp[end] == 0 ? -1 : findIndex(disks, end, dp[end]);
        }

        return res;
    }

    private static int findIndex(List<List<Integer>> disks, int index, int maxHeight) {
        for (int i = index - 1; i >= 0; i--) {
            if (disks.get(i).get(2) == maxHeight - disks.get(index).get(2)
                    && disks.get(i).get(0) < disks.get(index).get(0) && disks.get(i).get(1) < disks.get(index).get(1)) {
                return i;
            }
        }
        return -1;
    }
}

public class DiskStacking {
    public static void main(String[] args) {
        List<List<Integer>> disks = new ArrayList<>();
        disks.add(Arrays.asList(2, 1, 2));
        disks.add(Arrays.asList(3, 2, 3));
        disks.add(Arrays.asList(2, 2, 8));
        disks.add(Arrays.asList(2, 3, 4));
        disks.add(Arrays.asList(1, 3, 1));
        disks.add(Arrays.asList(4, 4, 5));

        List<List<Integer>> res = Solution.diskStacking(disks);
        System.out.println(res); // [[2, 1, 2], [3, 2, 3], [4, 4, 5]]

    }
}