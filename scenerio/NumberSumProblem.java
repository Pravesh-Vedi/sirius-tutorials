package questions.leetcode.scenerio;

import java.util.Arrays;
import java.util.HashMap;

public class NumberSumProblem {
    public static void main(String[] args) {
        int []inputArray = {2,7,11,15};//{2,3,4}
        //Arrays.sort(inputArray);
        int sum = 9 ;
       // findSum(inputArray,sum);
        Arrays.stream(twoSum(inputArray,sum)).forEach(System.out::println);
    }

    private static void findSum(int[] inputArray, int sum) {
        int start =0;
        int end = inputArray.length-1;
        while(start<end){
            if(inputArray[start]+inputArray[end]>sum){
                end--;
            }else if(inputArray[start]+inputArray[end]<sum){
                start++;
            }else{
                System.out.println("Sum pair is ("+inputArray[start]+","+inputArray[end]+")");
                System.out.println("Index pair is ("+start+","+end+")");
                start++;
                end--;
            }
        }
    }

    public static int[] twoSum(int[] inputArray1, int target) {
        int[] resultArray = new int[2];
        HashMap<Integer, Integer> visitedElementMap = new HashMap<>();
        for(int i =0 ;i<inputArray1.length;i++){
            if(visitedElementMap.containsKey(target - inputArray1[i])){
                resultArray[0]= visitedElementMap.get(target - inputArray1[i]);
                resultArray[1]=i;
            }
            visitedElementMap.put(inputArray1[i], i);
        }
        return resultArray;
    }
}
