package questions.leetcode.array;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] inputArray1 = {-5,-2,-3,-4,-5,-6};
        int target = -8;
        int[] numberArray = twoSum(inputArray1, target);
        Arrays.stream(numberArray).forEach(s-> System.out.print(+s+" "));
       /* for (int i : numberArray) {
            System.out.println("Element :: " +i);
        }*/

        Arrays.sort(inputArray1);
        int start = 0, end = inputArray1.length-1;
        while(start<end){
            if(inputArray1[start]+inputArray1[end]<target){
                start++;
            }else if(inputArray1[start]+inputArray1[end]>target){
                end--;
            }else if (inputArray1[start]+inputArray1[end]==target){
                System.out.println("\nPair is ("+inputArray1[start]+","+inputArray1[end]+")");
                System.out.println("Index Pair is ("+start+","+end+")");
                start++;
                end--;
            }
        }
    }

    private static int[] twoSum(int[] inputArray1, int target) {
        /*int low = 0;
        int high = inputArray1.length-1;
        //Arrays.sort(inputArray1);
        List<Integer> tmpList = new ArrayList<>();
        while(low < inputArray1.length && high <inputArray1.length){
            if(inputArray1[low] + inputArray1[high] == target){
                tmpList.add(low);
                tmpList.add(high);
                return tmpList.stream().mapToInt(i->i).toArray();
            }else if(inputArray1[low] + inputArray1[high]<target){
                    low = low +1;
            }else{
                high = high -1;
            }
        }
        return null;*/
        int[] resultArray =new int[2];
        HashMap<Integer, Integer>visitedElement = new HashMap<>();
        Map<Integer,Integer>integerIntegerMap = new LinkedHashMap<>();
        for(int i =0 ;i<inputArray1.length;i++){
            if(visitedElement.containsKey(target - inputArray1[i])){
                resultArray[0]= inputArray1[visitedElement.get(target - inputArray1[i])];
                resultArray[1]=inputArray1[i];
            }
            visitedElement.put(inputArray1[i], i);
        }
        return resultArray;
    }
}
