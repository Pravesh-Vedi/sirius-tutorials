package questions.leetcode.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxFrequencyNumber {

    public static void main(String[] args) {
        int [] inputArray = {1, 3, 3, 2,3};
        System.out.println("Max freq number is :: " +maxFrequencyNumber(inputArray));
    }

    public static int maxFrequencyNumber(int[] arr) {
        HashMap<Integer, Integer> integerHashMap = new HashMap<Integer, Integer>();
        for (int i : arr) {
            integerHashMap.put(i, integerHashMap.getOrDefault(i, 0) + 1);
        }
        /*int max = 0, result = Integer.MIN_VALUE;
        for (int i : arr) {
            if (integerHashMap.get(i) > max) {
                max = integerHashMap.get(i);
                result = i;
            }
        }
        return result;*/
        return Collections.max(integerHashMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
