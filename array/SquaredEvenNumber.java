package questions.leetcode.array;

import java.util.Arrays;

public class SquaredEvenNumber {
    public static void main(String[] args) {
        int[] inputArray = {3,8,5,4,2};
        Arrays.stream(squaredEvenNumbers(inputArray)).forEach(System.out::println);
        System.out.println("-------------------------------");
        System.out.println(reverseString("Hello World!"));
        System.out.println("-------------------------------");
        int[]inputArray_01 = {1, 2, 3, 4, 5};
        Arrays.stream(reverseArray(inputArray_01)).forEach(System.out::println);
    }

    private static int[] reverseArray(int[] inputArray_01) {
        int left=0;
        int right=inputArray_01.length-1;
        while(left<right){
            int tmp = inputArray_01[left];
            inputArray_01[left]=inputArray_01[right];
            inputArray_01[right]=tmp;
            left++;
            right--;
        }
        return inputArray_01;
    }

    private static String reverseString(String inputString) {
        StringBuilder stringBuilder = new StringBuilder(inputString);
        return stringBuilder.reverse().toString();
    }

    private static int[] squaredEvenNumbers(int[] inputArray) {
        int left = 0;
        while(left<=inputArray.length-1){
            if(inputArray[left]%2==0){
                inputArray[left]=inputArray[left]*inputArray[left];
            }
            left++;
        }
    return inputArray;
    }
}
