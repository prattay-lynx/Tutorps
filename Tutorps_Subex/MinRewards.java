import java.util.Arrays;

public class MinRewards {
    public static int minRewards(int[] scores) {
        int n = scores.length;
        int[] rewards = new int[n];
        Arrays.fill(rewards, 1);

        // Scan from left to right and update rewards
        for (int i = 1; i < n; i++) {
            if (scores[i] > scores[i - 1]) {
                rewards[i] = rewards[i - 1] + 1;
            }
        }

        // Scan from right to left and update rewards
        for (int i = n - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
            }
        }

        int totalRewards = 0;
        for (int reward : rewards) {
            totalRewards += reward;
        }

        return totalRewards;
    }

    public static void main(String[] args) {
        int[] scores = { 8, 4, 2, 1, 3, 6, 7, 9, 5 };
        int minRewards = minRewards(scores);
        System.out.println(minRewards); // Output: 25
    }
}
