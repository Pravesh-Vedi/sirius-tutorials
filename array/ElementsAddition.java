package questions.leetcode.array;

import java.util.Arrays;

public class ElementsAddition {
    public static void main(String[] args) {
        int[] inputArray = {1, 3, 4, 5, 7};
        resultingArray(inputArray, inputArray.length - 1);
        Arrays.stream(inputArray).forEach(n-> System.out.print(n+" "));
    }

    private static int resultingArray(int[] inputArray, int index) {
        if (index == 0) {
            return inputArray[index];
        }
        inputArray[index] = inputArray[index] + resultingArray(inputArray, index - 1);
        return inputArray[index];
    }
}
