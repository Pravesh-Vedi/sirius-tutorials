package questions.leetcode.array;

import java.util.PriorityQueue;

public class KthHighestNumber {
    public static void main(String[] args) {
         int[] inputArray = new int[]{2,2,25,5,7,1,0,3};
         int kthHighestElement = secondHighest(inputArray,3);
         System.out.println(kthHighestElement);
    }

    private static int secondHighest(int[] inputArray, int k) {
       /* int highest = 0;
        int secondHighest = 0;
        for(int i=0;i<inputArray.length-1;i++){
            if(inputArray[i]>highest){
                secondHighest = highest;
                highest = inputArray[i];
            }else if(inputArray[i]>secondHighest){
                secondHighest = inputArray[i];
            }
        }
        return secondHighest;*/
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        for(int number:inputArray){
            integers.add(number);
            if(integers.size()>k){
                integers.poll();
            }
        }
        return integers.poll();
    }
}
