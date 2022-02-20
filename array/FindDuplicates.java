package questions.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicates {
    public static void main(String[] args) {
        int [] inputArray = {4,3,2,7,8,2,3,1};
        List<Integer>duplicateList =  findDuplicates(inputArray);
        duplicateList.forEach(System.out::println);

        Set<Integer> integerSet = new HashSet<>();
        Stream.of(4,3,2,7,8,2,3,1).filter(item-> !integerSet.add(item)).collect(Collectors.toList()).forEach(System.out::println);
    }

    private static List<Integer> findDuplicates(int[] inputArray) {
        List<Integer>duplicateNumberList = new ArrayList<>();
        Set<Integer>numberSet = new HashSet<>();
        for (int j : inputArray) {
            if (!numberSet.contains(j)) {
                numberSet.add(j);
            } else {
                duplicateNumberList.add(j);
            }
        }
        return duplicateNumberList;
    }
}
