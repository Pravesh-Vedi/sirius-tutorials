package questions.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraysIntersection {
    public static void main(String[] args) {
        int[] inputArray1 = {1, 2, 2, 1};
        int[] inputArray2 = {2, 1};
        int[] intersectionArray = intersectionElement_04(inputArray1, inputArray2);
        Arrays.stream(intersectionArray).forEach(n -> System.out.print(+n + " "));
        System.out.println("\n");

        int[] numberArray = intersection_Case01(inputArray1, inputArray2);
        intersection_Case03(inputArray1, inputArray2);
        for (int i : numberArray) {
            System.out.println("Element :: " + i);
        }
    }

    private static int[] intersectionElement_04(int[] inputArray1, int[] inputArray2) {
        Arrays.sort(inputArray1);
        Arrays.sort(inputArray2);

        int size = Math.min(inputArray1.length, inputArray2.length);
        int[] resultArray = new int[size];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < inputArray1.length && j < inputArray2.length) {
            if (inputArray1[i] == inputArray2[j]) {
                resultArray[k] = inputArray1[i];
                k++;
                i++;
                j++;
            } else if (inputArray1[i] < inputArray2[j]) {
                i++;

            } else if (inputArray1[i] > inputArray2[j]) {
                j++;
            }
        }
        return resultArray;
    }

    private static void intersection_Case03(int[] inputArray1, int[] inputArray2) {
        Set<Integer> integerSet = new HashSet<>();
        for (int j : inputArray1) {
            integerSet.add(j);
        }
        for(int number : inputArray2){
            if(integerSet.contains(number)){
                System.out.println("Element case 03 :: " + number);
            }
        }
    }

    private static int[] intersection_Case01(int[] inputArray1, int[] inputArray2) {
        Arrays.sort(inputArray1);
        Arrays.sort(inputArray2);

        int i = 0, j = 0, k = 0;
        while (i < inputArray1.length && j < inputArray2.length) {
            if (inputArray1[i] > inputArray2[j]) {
                j++;
            } else if (inputArray1[i] < inputArray2[j]) {
                i++;
            } else {
                inputArray1[k++] = inputArray1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(inputArray1, 0, k);
    }
}
