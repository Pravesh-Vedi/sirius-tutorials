package questions.leetcode.scenerio;

import java.util.Arrays;

public class ReversInputArray {

    public static void main(String[] args) {
        int [] inputArray = {3,2,4,5,1,6};
        reverseArray(inputArray);
        Arrays.stream(inputArray).forEach(n-> System.out.print(n+ " "));
    }

    private static void reverseArray(int[] inputArray) {
        int start=0; int end=inputArray.length-1;
        while(start<end){
            int tmp = inputArray[end];
            inputArray[end] = inputArray[start];
            inputArray[start] = tmp;

            start++;
            end--;
        }
    }
}
