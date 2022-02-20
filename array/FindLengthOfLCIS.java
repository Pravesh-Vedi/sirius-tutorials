package questions.leetcode.array;

import java.util.Arrays;

public class FindLengthOfLCIS {
    public static void main(String[] args) {
        int[] inputArray = {9,5,4,9,10,15,10,6};
        System.out.println(findLongestIncreasingSubSeq(inputArray));
    }

    private static int findLongestIncreasingSubSeq(int[] inputArray) {
        if (inputArray.length <= 1) {
            return inputArray.length;
        }

        int[] dpArray = new int[inputArray.length];
        int maxSequence = -1;
        Arrays.fill(dpArray, 1);
        for (int i = 1; i < inputArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if (inputArray[j] < inputArray[i]) {
                    dpArray[i] = Math.max(dpArray[i], dpArray[j] + 1);//
                }
            }
            maxSequence = Math.max(maxSequence, dpArray[i]);
        }
        return maxSequence;
    }
}
