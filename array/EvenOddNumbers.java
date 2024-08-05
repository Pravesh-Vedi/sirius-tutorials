package questions.leetcode.array;

import java.util.Arrays;

public class EvenOddNumbers {
    public static void main(String[] args) {
        int[]inputArray = {2,4,1,6,3,8,7};
        Arrays.stream(resultArray(inputArray)).forEach(System.out::println);
    }

    private static int[] resultArray(int[] inputArray) {
        int left = 0;
        int right = inputArray.length-1;
        while(left<right){
            if(inputArray[left]%2==0){
                left++;
            }else if(inputArray[right]%2!=0){
                right--;
            }else{
                int tmp = inputArray[left];
                inputArray[left]=inputArray[right];
                inputArray[right]=tmp;
                left++;
                right--;
            }
        }
        return inputArray;
    }
}
