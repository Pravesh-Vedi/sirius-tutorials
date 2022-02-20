package questions.leetcode.array;

public class LongestIncreasingSubSeqLength {
    public static void main(String[] args) {
        int[] inputArray = {10, 9, 2, 5, 3, 7, 101,119};

        int sequenceLength_02 = lengthOfLIS(inputArray);
        System.out.println("Length is :: " + sequenceLength_02);
    }

    private static int lengthOfLIS(int[] inputArray) {
        int result = 0;
        int anchor = 0;

        for (int i = 0; i < inputArray.length; i++) {
            if (i > 0 && inputArray[i - 1] >= inputArray[i]) {
                anchor = i;
            }
            result = Math.max(result, i - anchor + 1);
        }
        return result;
    }
}
