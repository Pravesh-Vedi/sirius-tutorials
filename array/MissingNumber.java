package questions.leetcode.array;

import java.util.List;

public class MissingNumber {
    public static void main(String[] args) {
        int [] inputArray = {3,4,5,1,6,8,7,9};
       // int inputArray[]= {44,43,42,45,47,48,42,43,41};
        System.out.println("Missing Number ::" +missingNumber(inputArray));
        System.out.println("Missing Number Case_02 ::" +missingNumberCase_02(inputArray));
//        missingNumberCase_03(inputArray).forEach(System.out::println);
    }

   /* private static List<Integer> missingNumberCase_03(int[] inputArray) {
    }*/

    private static int missingNumberCase_02(int[] inputArray) {
        int x1=inputArray[0];
        int x2=1;

        for(int i=1;i<inputArray.length-1;i++){
            x1=x1^inputArray[i];
        }

        for(int i=2;i<inputArray.length+1;i++){
            x2=x2^i;
        }
        return (x1^x2);
    }

    private static int missingNumber(int[] inputArray) {
      /* int sum = 0;
        int expectedSum = (inputArray.length+1) * (inputArray.length + 2) / 2;
       for (int number :inputArray){
           sum = sum+number;
       }
       //int n = inputArray.length+1;
        return expectedSum-sum;*/
       //return (n*(n-1)/2)-sum;
        int expectedSum = (inputArray.length+1) * (inputArray.length + 2) / 2;
        int actualSum = 0;
        for (int i : inputArray) {
            actualSum += i;
        }
        return expectedSum - actualSum;
    }
}
