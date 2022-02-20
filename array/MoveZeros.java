package questions.leetcode.array;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] inputArray1 = {0,1,0,3,12};
        moveZeros(inputArray1);
        Arrays.stream(inputArray1).forEach(System.out::println);
    }

    private static void moveZeros(int[] inputArray1) {
        int count =0;
        for(int i=0;i<inputArray1.length;i++){
            if(inputArray1[i]!=0){
                inputArray1[count++]=inputArray1[i];
            }
        }
        while(count<inputArray1.length){
            inputArray1[count++]=0;
        }
    }

}
