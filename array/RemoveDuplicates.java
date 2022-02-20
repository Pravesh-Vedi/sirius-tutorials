package questions.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] inputArray = {0, 0, 1, 1, 1, 2, 2, 0, 10,11,3, 10,3, 4};
        Set<Integer>integerSet = new HashSet<>();

        Stream.of(0, 0, 1, 1, 1, 2, 2, 0, 10, 11, 3, 10, 3, 4)
                .filter(item -> !integerSet.add(item))
                .collect(Collectors.toList())
                        .forEach(System.out::println);
        System.out.println("-------------------------------------------");
        integerSet.forEach(System.out::println);
       // Arrays.stream(inputArray).distinct();
        //removeDuplicates(inputArray);
        //removeDuplicates_01(inputArray);
        removeDuplicates_case_03(inputArray);
        /*for (int i = 0; i < removeDuplicates_case_03(inputArray).size(); i++) {
            System.out.println(inputArray[i]);
        }*/
    }

    private static void removeDuplicates_case_03(int[] inputArray) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<=inputArray.length-1;i++){
            if(hashMap.containsKey(inputArray[i])){
                hashMap.put(inputArray[i], hashMap.get(inputArray[i])+1);
            }else{
                hashMap.put(inputArray[i], 1);
            }
        }
        hashMap.forEach((k,v)->{
            System.out.println(k +" ");
        });
        //return hashMap.keySet().stream().collect(Collectors.toList());
    }

    private static void removeDuplicates_01(int[] inputArray) {
        int nonDuplicate=0;
        Arrays.sort(inputArray);
        inputArray[nonDuplicate]=inputArray[0];
        for(int i=1;i<inputArray.length-1;i++){
            if(inputArray[nonDuplicate]==inputArray[i]){
                inputArray[nonDuplicate++]=inputArray[i];
            }
        }
        nonDuplicate++;
    }

    private static void removeDuplicates(int[] inputArray) {
        int j = 0;
        for (int i = 1; i < inputArray.length-1; i++) {
            if (inputArray[i] != inputArray[j]) {
                inputArray[j] = inputArray[i];
                j++;
                System.out.println("Sub-Method" +inputArray[j]);
            }
        }
       // Arrays.sort(inputArray);
       // return j + 1;
    }
}
