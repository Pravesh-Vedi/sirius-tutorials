package questions.leetcode.scenerio;

import java.util.Arrays;

/* I am in a 100-story building. I have with me two glass balls. I know that if I throw the ball out of the
 window, it will not break if the floor number is less than X, and it will always breaks if the floor number
 is equal to or greater than X. Assuming that I can reuse the balls which don't break, find X in the
 minimum number of throws.
*/
public class Puzzle100StoryBuilding {
    static final int MAX = 1000;
    static int[][] memo = new int[MAX][MAX];

    static int solveEggDrop(int n, int k) {
        if (memo[n][k] != -1) {
            return memo[n][k];
        }
        if (k == 1 || k == 0) {
            return k;
        }

        if (n == 1) {
            return k;
        }

        int min = Integer.MAX_VALUE, res;
        for (int x = 1; x <= k; x++) {
            res = Math.max(solveEggDrop(n - 1, x - 1),
                    solveEggDrop(n, k - x));
            min = Math.min(res,min);
        }
        memo[n][k] = min + 1;
        return min + 1;
    }

    public static void main(String[] args) {
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        int n = 2, k = 36;
        System.out.print(solveEggDrop(n, k));
    }

    private static int ballStillExist(String[] ball, int start, int end) {
        //int expression =  end *(end+1)/2;
        int mid = start + end / 2;
        if (true) {//ball exist
            return ballStillExist(ball, mid + 1, end);
        } else {
            return ballStillExist(ball, start, mid - 1);
        }
    }

}
