package questions.leetcode.array;

public class ClimbStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("No Of Ways are :: " + climbStairs(n));
    }

    private static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
