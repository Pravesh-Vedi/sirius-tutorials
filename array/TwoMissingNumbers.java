package questions.leetcode.array;

import java.util.Arrays;

public class TwoMissingNumbers {
    public static void main(String[] args) {
        int [] inputArray = {1,3,4,5,6,7,9};
        Arrays.stream(missingNumbers_01(inputArray)).forEach(System.out::println);
    }
/*
 *inputArray = {1,3,4,5,6,7,9};
 *size=9
 *totalSum=9*10/2=45
 *arraySum=35
 *midValue=(45-35)/2=5
 *totalLeftXor=1^2^3^4^5
 *totalRightXor=6^7^8^9
 *arrayLeftXor=1^3^4^5
 *arrayRightXor=6^7^8^9
 * [1^2^3^4^5^1^3^4^5,6^7^8^9^6^7^9]
 */
    private static int[] missingNumbers_01(int[] inputArray) {
        int size = inputArray.length+2;

        int totalSum = size*(size+1)/2;
        int arraySum = 0;
        for (int number:inputArray){
            arraySum = arraySum+number;
        }
        int midValue = (totalSum-arraySum)/2;
        int totalLeftXor=0;
        int arrayLeftXor=0;

        int totalRightXor=0;
        int arrayRightXor=0;

        for(int i=1;i<=midValue;i++){
            totalLeftXor=totalLeftXor^i;
        }

        for(int i=midValue+1;i<=size;i++){
            totalRightXor=totalRightXor^i;
        }

        for(int i:inputArray){
            if(i<=midValue){
                arrayLeftXor=arrayLeftXor^i;
            }else{
                arrayRightXor=arrayRightXor^i;
            }
        }

        return new int[]{totalLeftXor^arrayLeftXor,totalRightXor^arrayRightXor};
    }
}
