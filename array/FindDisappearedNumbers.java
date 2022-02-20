package questions.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] inputArray = {4,3,2,7,8,2,3,1};
        //int[] inputArray = {44,43,42,47,48,42,43,41};
        List<Integer>missingNumbersList = missingNumbers(inputArray);
        missingNumbersList.forEach(System.out::println);
    }

    private static List<Integer> missingNumbers(int[] inputArray) {
        List<Integer>missingNumbersList=new ArrayList<>();
        Set<Integer>integerSet = new HashSet<>();
        for(int number:inputArray){
            integerSet.add(number);
        }
        for(int i=1;i<=inputArray.length;i++){
            if(!integerSet.contains(i)){
                missingNumbersList.add(i);
            }
        }
        return missingNumbersList;
    }
}
