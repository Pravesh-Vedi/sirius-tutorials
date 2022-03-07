package questions.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidateDuplicates {
    public static void main(String[] args) {
        int[] inputArray = {2, 7, 13, 1, 7, 13};
        boolean isDuplicate = validateDuplicates(inputArray);
        boolean isDuplicate_01 = validateDuplicatesSortedArray(inputArray);
        boolean isDuplicate_02 = validateDuplicates_03(inputArray);
        boolean isDuplicate_03 = validateDuplicates_04(inputArray);

        System.out.println("Array Contains Duplicates :: " + isDuplicate);
        System.out.println("Array Contains Duplicates :: " + isDuplicate_01);
        System.out.println("Array Contains Duplicates :: " + isDuplicate_02);
        System.out.println("Array Contains Duplicates :: " + isDuplicate_03);
    }

    private static boolean validateDuplicates_04(int[] inputArray) {
        Set<Integer> integerSet = new HashSet<>();
        for (int number : inputArray) {
            if (integerSet.contains(number)) {
                return true;
            } else {
                integerSet.add(number);
            }
        }
        return false;
    }

    private static boolean validateDuplicates_03(int[] inputArray) {
        int start = 0;
        int end = inputArray.length - 1;
        Arrays.sort(inputArray);
        while (start < end) {
            if (inputArray[start] == inputArray[start + 1]) {
                return true;
            } else {
                start++;
            }
        }
        return false;
    }

    private static boolean validateDuplicatesSortedArray(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if (inputArray[i] == inputArray[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean validateDuplicates(int[] inputArray) {
        Arrays.sort(inputArray);
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[i] == inputArray[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
