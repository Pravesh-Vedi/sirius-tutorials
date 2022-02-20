package questions.leetcode.array;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int [] inputArray_01 = {1,2,3,0,0,0};
        int [] inputArray_02 ={2,5,6};
        int [] mergedArray = mergedSortedArray(inputArray_01,3, inputArray_02,3);
        Arrays.stream(mergedArray).forEach(num-> System.out.print(num +" "));
       /* for(int num : mergedArray){
            System.out.println("Merged Array Element :: " +num);
        }*/
    }

    private static int[] mergedSortedArray(int[] num1, int m, int[] num2, int n) {
        int i=m+n-1;
        int pointer_01 = m-1;
        int pointer_02= n-1;
        while(pointer_02>=0 && pointer_01>=0){
            if(num1[pointer_01]>num2[pointer_02]){
                num1[i] = num1[pointer_01];
                i--;
                pointer_01--;
            }else {
                num1[i] = num2[pointer_02];
                i--;;
                pointer_02--;
            }

        }
        return num1;
    }
}
