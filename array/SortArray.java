package questions.leetcode.array;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] inputArray =  {1,1,0,2,0,2,0,1,2};
        sortArray(inputArray);
        Arrays.stream(inputArray).forEach(System.out::println);
    }

    private static void sortArray(int[] inputArray) {
        int start = 0;
        int end = inputArray.length-1;
        int index = 0;

        while(index<=end && start<end){
            if(inputArray[index]==0){
                inputArray[index] = inputArray[start];
                inputArray[start] = 0;
                index++;
                start++;
            }else if(inputArray[index]==2){
                inputArray[index]= inputArray[end];
                inputArray[end]=2;
                end--;
            }else{
                index++;
            }
        }


    }
}
