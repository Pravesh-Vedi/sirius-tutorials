package questions.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstValidDuplicate_Google {
    public static void main(String[] args) {
        int [] inputArray = {4,3,4,3,1};
        int duplicateNumber2 = duplicateNumber_02(inputArray);
        int duplicateNumber = duplicateNumber(inputArray);
        Set<Integer>integerSet = new HashSet<>();
        Stream.of(4,3,4,3,1).filter(item->!integerSet.add(item)).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("First Duplicate Number is  :: " +duplicateNumber);
        System.out.println("Duplicate Number using  duplicateNumber_02 :: " +duplicateNumber2);
    }

    private static int duplicateNumber_02(int[] inputArray) {
        Set<Integer>integerSet = new HashSet<>();
        for(int number : inputArray){
            if(integerSet.contains(number)){
                return number;
            }else{
                integerSet.add(number);
            }
        }
        return -1;
    }

    private static int duplicateNumber(int[] inputArray) {
        Arrays.sort(inputArray);//O(nlogn)
        int j=0;
        for(int i=1;i<inputArray.length;i++){
            if(inputArray[i]<1 || inputArray[i]>inputArray.length){
                return -1;
            }else if(inputArray[i]==inputArray[j]){
                return inputArray[i];
            }
            j++;
        }
        return -1;
    }
}
