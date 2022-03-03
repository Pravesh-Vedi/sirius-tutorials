package questions.leetcode.scenerio;

import java.util.*;

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

        int[][] intervalArray = {{570, 705}, {675, 690}, {990,1005},{330,540}};
        int minRunway = minRunway(intervalArray);
        System.out.println("Min Runways Needed are :: " + minRunway);

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

    private static int minRunway(int[][] intervalArray) {
        Arrays.sort(intervalArray, Comparator.comparingInt(a->a[0]));
        PriorityQueue<Integer> integerQueue = new PriorityQueue<>();
        for (int[] interval : intervalArray) {
            if (integerQueue.isEmpty()) {
                integerQueue.add(interval[1]);
                continue;
            }
            if(integerQueue.peek()<=interval[0]){
                integerQueue.remove();
            }
            integerQueue.add(interval[1]);
        }
        return integerQueue.size();
    }
}
