package questions.leetcode.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {11, 33, 33, 11, 33, 11, 11};
        System.out.println("Max frequency number is :: " + maxFreqNumber(nums));
        System.out.println("Max Freq method_02 :: " + maxVotes(nums, 5));
        System.out.println("Max Freq method_03 :: " + maxFrequency(nums));
    }

    private static int maxFrequency(int[] nums) {
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        for (int number : nums) {
            integerHashMap.put(number, integerHashMap.getOrDefault(number, 0) + 1);
        }
        return Collections.max(integerHashMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static int maxVotes(int[] nums, int n) {
        int candidate = nums[0];
        int votes = 1;
        int frequency = 0;

        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]) {
                votes++;
            } else {
                votes--;
            }
            if (votes == 0) {
                candidate = nums[i];
                votes = 1;
            }
        }
        for (int num : nums) {
            if (num == candidate) {
                frequency++;
            }
        }
        if (frequency >= n / 2) {
            return candidate;
        } else {
            return -1;
        }
    }

    private static int maxFreqNumber(int[] nums) {
        int counter = 0;//0
        int assumedCandidate = 0;
        for (int number : nums) {
            if (counter == 0) {
                assumedCandidate = number;//2
            }
            counter = assumedCandidate == number ? counter + 1 : counter - 1;
        }
        return assumedCandidate;
    }
}
