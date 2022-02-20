package questions.leetcode.array;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] inputArray1 = {9,9,9,9,9,9};
        int[] numberArray = plusOne(inputArray1);
        Arrays.stream(numberArray).forEach(System.out::println);
    }

    private static int[] plusOne(int[] inputArray1) {
        /*int k=0;
        int tmpArray[] =new int[inputArray1.length];
        int x = inputArray1[inputArray1.length-1];
        for(int i=0;i<inputArray1.length;i++){
            if(i==inputArray1.length-1){
                tmpArray[k] = ++x;
            }else {
                tmpArray[k] = inputArray1[i];
            }
            k++;
        }
        return tmpArray;*/

        for (int i = inputArray1.length-1;i>=0;i--){
            if(inputArray1[i]<9){
                inputArray1[i]++;
                return inputArray1;
            }
            inputArray1[i]=0;
        }
        int[] newIntArray = new int[inputArray1.length+1];
        newIntArray[0]=1;
        return newIntArray;
    }
}
