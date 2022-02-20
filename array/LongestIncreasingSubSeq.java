package questions.leetcode.array;

import java.util.Arrays;

public class LongestIncreasingSubSeq {
    public static void main(String[] args) {
        int[] inputArray = {10, 9, 2, 5, 3, 7, 101, 116, 187};
        System.out.println("Second Solution :: " +longestIncreasingSubsequence(inputArray));

        System.out.println(longestIncreasingSubSeq(inputArray));
    }

    private static int lowerBound(int[] a, int low, int high, int element) {
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (element > a[middle]) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }

    public static int longestIncreasingSubsequence(int[] arr) {
        // dp[i] represents i+1'th length LIS ending at minimum integer dp[i]
        int[] dp = new int[arr.length];
        int result = 0;

        for (int number : arr) {
			/*
			    Since dp array stores elements in the sorted order therefore
			    we can use binary search to find the correct position for
			    arr[i] to be placed.
			    And elements are present in the dp array from 0 to result-1 position
			    So we will be doing the binary search in this range.
			*/
            int position = lowerBound(dp, 0, result, number);
            dp[position] = number;

            if (position == result) {
                result++;
            }
        }
        return result;
    }

    private static int longestIncreasingSubSeq(int[] inputArray) {
        if (inputArray.length <= 1) {
            return inputArray.length;
        }
        int[] dpArray = new int[inputArray.length];
        int maxSequence = -1;
        Arrays.fill(dpArray, 1);
        for (int i = 1; i < inputArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if (inputArray[j] > inputArray[i]) {
                    dpArray[i] = Math.max(dpArray[j], dpArray[i] + 1);//
                }
            }
            maxSequence = Math.max(maxSequence, dpArray[i]);
        }
        return maxSequence;
    }
}
