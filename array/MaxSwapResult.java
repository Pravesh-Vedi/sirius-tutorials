package questions.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class MaxSwapResult {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(9);
        integerList.add(8);
        integerList.add(1);
        integerList.add(8);
        integerList.add(7);
        maxSwap(integerList).forEach(n-> System.out.print(+n+" "));
    }

    private static List<Integer> maxSwap(List<Integer> integerList) {
        int[] digits = new int[10]; // This array will store last occurrence of all digits
        for (int i = 0; i < integerList.size(); i++) {
            digits[integerList.get(i)] = i;
        }

        for (int i = 0; i < integerList.size(); i++) {
            for (int j = 9; j > integerList.get(i); j--) {
                if (digits[j] > i) {// We find a maximum digit which is right side of index
                    int temp = integerList.get(i);
                    integerList.set(i, integerList.get(digits[j]));
                    integerList.set(digits[j], temp);
                    return integerList;
                }
            }
        }

        return integerList;
    }
}
