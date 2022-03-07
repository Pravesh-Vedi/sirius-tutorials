package questions.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMeetingRoom {
    public static void main(String[] args) {
        int[][] intervalArray = {{0, 30}, {5, 10}, {15, 20}, {17, 23}};
        int minRooms = minMeetingRoom(intervalArray);
        System.out.println("Min Room Needed are :: " + minRooms);
    }

    private static int minMeetingRoom(int[][] intervalArray) {
        Arrays.sort(intervalArray, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> integerQueue = new PriorityQueue<>();
        for (int[] interval : intervalArray) {
            if (integerQueue.isEmpty()) {
                integerQueue.add(interval[1]);
                continue;
            }
            if (integerQueue.peek() <= interval[0]) {
                integerQueue.remove();
            }
            integerQueue.add(interval[1]);
        }
        return integerQueue.size();
    }
}
