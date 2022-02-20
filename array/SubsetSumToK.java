package questions.leetcode.array;

import java.util.HashMap;

public class SubsetSumToK {
    public static void main(String[] args) {
        //int[] inputArray = {10, 2, -2, -20, 10};
        //int targetSum = -10;

        int[] inputArray = {1,3,2,4};
        int targetSum = 4;

        int subSetSumCombination = findSubArraySum(inputArray, targetSum);
        System.out.println("Total Subsets :: " + subSetSumCombination);
    }

    private static int findSubArraySum(int[] inputArray, int targetSum) {
        HashMap<Integer, Integer> prevSum = new HashMap<>();
        int res = 0;
        int currSum = 0;

        for (int j : inputArray) {
            currSum = currSum + j;
            if (currSum == targetSum)
                res++;

            if (prevSum.containsKey(currSum - targetSum))
                res = res + prevSum.get(currSum - targetSum);

            // Add currsum value to count of
            // different values of sum.
            int count = prevSum.getOrDefault(currSum, 0);
            prevSum.put(currSum, count + 1);
        }
        return res;
    }
}
