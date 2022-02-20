package questions.leetcode.scenerio;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RunwayProblem {
    // Day runs from minute 0 to minute 1440 (exclusive)
    // Input: example 9:30 => 570
    // arr [570, 675, 990]
    // dept [705, 690, 1005]

    //arr = [9:30, 11:15, 16:30]
    // dep = [11:45, 11:30, 16:45]
    // Assume data is valid - i.e. length, no neg, etc.
    public static void main(String[] args) {
        int[] arr = {570, 675, 990};
        int[] dept = {705, 690, 1005};

        // Create a frequency map for the day
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n = 0; n < arr.length; n++) {
            int a = arr[n];
            int d = dept[n];
            for (int i = a; i <=d; i++) {
                int count = freqMap.getOrDefault(i, 0);
                freqMap.put(i, count + 1);
            }
        }
        // Calculate the max value
        System.out.println(Collections.max(freqMap.entrySet(),Map.Entry.comparingByValue()).getValue());
    }
}
