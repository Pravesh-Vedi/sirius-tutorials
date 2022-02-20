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
        int intersectionElement_01 = intersection_Case02(inputArray1, inputArray2);
        int intersectionElement_02 = intersection_Case03(inputArray1, inputArray2);
        for (int i : numberArray) {
            System.out.println("Element :: " + i);
        }
        System.out.println("Intersection Element - Case01::" + intersectionElement_01 + " :: Case-02 :: " + intersectionElement_02);
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

    private static int intersection_Case03(int[] inputArray1, int[] inputArray2) {
        Set<Integer> integerSet = new HashSet<>();
        for (int j : inputArray1) {
            integerSet.add(j);
        }
        for (int i = 0; i < inputArray2.length; i++) {
            if (integerSet.contains(inputArray2[i])) {
                System.out.println("Element :: " + i);
                return inputArray2[i];
            }
        }

        return 0;
    }

    private static int intersection_Case02(int[] inputArray1, int[] inputArray2) {
        return 0;
    }


    private static int[] intersection_Case01(int[] inputArray1, int[] inputArray2) {
       /* int numberArray[]= new int[inputArray1.length>inputArray2.length?inputArray1.length:inputArray2.length];
        int k=0;
        for(int i=0;i<inputArray1.length;i++){
            for (int j=0;j<inputArray2.length;j++){
                if(inputArray1[i]==inputArray2[j]){
                    numberArray[k]=inputArray1[i];
                    k++;
                }
            }
        }
        return Arrays.stream(numberArray).distinct().toArray();*/
       /* HashSet<Integer> integerHashSet_01 = new HashSet<>();
        for(int i = 0;i<inputArray1.length;i++){
            integerHashSet_01.add(inputArray1[i]);
        }
        HashSet<Integer> integerHashSet_02 = new HashSet<>();
        for(int j= 0; j<inputArray2.length; j++){
            if(integerHashSet_01.contains(inputArray2[j])){
                integerHashSet_02.add(inputArray2[j]);
            }
        }
        return integerHashSet_02.stream().mapToInt(i->i).toArray();*/

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
