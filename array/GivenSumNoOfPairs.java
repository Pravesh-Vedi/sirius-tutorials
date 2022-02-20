package questions.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

public class GivenSumNoOfPairs {
    public static void main(String[] args) {
        int sum = 12;
        int [] inputArray = {1,2,3,7,5};
        //                  {1,2,3,4,4,5,7,8,9};
        findSum(inputArray, sum);
        Arrays.sort(inputArray);
        /*Map<Integer, Integer>numberMap = new HashMap<>();
        int counter = 0;
        for(int i=0; i<inputArray.length;i++){
            if(!numberMap.containsValue(sum-inputArray[i])){
                numberMap.put(i,inputArray[i]);
            }else{
                counter++;
            }
        }
        System.out.println("-- Numbers are :: --" +counter);*/
        int low = 0;
        int high = inputArray.length-1;
        while(low<high){
            if(inputArray[low]+inputArray[high]>sum){
                high--;
            }else if (inputArray[low]+inputArray[high]<sum){
                low++;
            }else if(inputArray[low]+inputArray[high] ==sum){
                System.out.println("Pair is ("+inputArray[low]+","+inputArray[high]+")");
                System.out.println("Index Is ("+low+","+high+")");
                low++;
                high--;
            }
        }
    }

    private static void findSum(int[] inputArray, int sum) {
        HashMap<Integer, Integer>integerMap = new HashMap<>();
        for (int i=0;i<inputArray.length;i++){
            if(integerMap.containsKey(sum-inputArray[i])){
                System.out.println("Second Solution -  Pair is ("+integerMap.get(sum-inputArray[i])+","+inputArray[i]+")");
            }else{
                integerMap.put(inputArray[i],i);
            }
        }
    }
}
