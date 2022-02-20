package questions.leetcode.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        int[] inputArray = {0, 0, 4, 4, 7, 7,1};
        int num = uniqueFirstNumber(inputArray);
        int number = validateAndGetSingleNumber(inputArray);
        int number1 = validateAndGetSingleNumber_case01(inputArray);
        System.out.println("Single Number is  :: " +number1 +" :: " + number + ":::" +num);
    }

    private static int validateAndGetSingleNumber_case01(int[] inputArray) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        for(int i=0;i<=inputArray.length-1;i++){
            if(integerMap.containsKey(inputArray[i])){
                integerMap.put(inputArray[i],integerMap.get(inputArray[i])+1);
            }else{
                integerMap.put(inputArray[i],1);
            }
        }
        return Collections.min(integerMap.entrySet(),Map.Entry.comparingByValue()).getKey();
    }

    private static int uniqueFirstNumber(int[] inputArray) {
        int uniqueFirstNum=0;
        for(int i=1;i<inputArray.length;i++){
            if(inputArray[uniqueFirstNum]==inputArray[i]){
                uniqueFirstNum++;
            }else{
                return inputArray[i];
            }
        }
        return 0;
    }

    private static int validateAndGetSingleNumber(int[] inputArray) {
        int a = 0;
        for (int i : inputArray) {
            a ^= i;
        }
        return a;
    }
}
