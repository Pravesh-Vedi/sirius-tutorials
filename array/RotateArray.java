package questions.leetcode.array;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] inputArray = {0, 1, 55, 44, 32, 3, 3, 4};
        int k=2;
        rotateArray(inputArray, k);
        Arrays.stream(inputArray).forEach(n-> System.out.print(+n+" "));

        int[] inputArray1 = {0, 1, 55, 44, 32, 3, 3, 4};
        int k1=2;

        System.out.println("\n");
        rotateArrayUsingRecursion(inputArray1, k1);
        Arrays.stream(inputArray1).forEach(n-> System.out.print(""+n+" "));
    }

    private static void rotateArrayUsingRecursion(int[] inputArray, int k) {
        k = k%inputArray.length;

        //int inputArray[] = {0, 1, 55, 44, 32, 3, 3, 4};

        //int inputArray[] = {4, 3, 3, 32, 44, 55, 1, 0};
        //int inputArray[] = {1, 0, 55, 44, 32, 3, 3, 4};
        //int inputArray[] = {1, 0, 4, 3, 3, 32, 44, 55};

        reverseArray(inputArray, 0, inputArray.length-1);
        reverseArray(inputArray, 0, k-1);
        reverseArray(inputArray, k, inputArray.length-1);

    }

    private static void reverseArray(int[] inputArray, int start, int end) {
        int tmp =0;
        while(start<end){
            tmp = inputArray[start];
            inputArray[start]= inputArray[end];
            inputArray[end]=tmp;

            start++;
            end--;
        }
    }

    private static void rotateArray(int[] nums, int k) {
        k %= nums.length;
        int[] temp = new int[k];
        System.arraycopy(nums, nums.length - k, temp, 0, k);

        if (nums.length - k - 1 + 1 >= 0) System.arraycopy(nums, 0, nums, k, nums.length - k - 1 + 1);

        System.arraycopy(temp, 0, nums, 0, k);
    }
}
