package questions.leetcode.scenerio;

import java.util.Stack;

public class ValidStringProblem {

    /**
     * "()" and "()[]{} (() " are all valid but "(]" and "([)]" are not.
     *
     * @param args
     */
    public static void main(String[] args) {
        String inputString = "";
        //int number = 4;
       /* boolean isValidString = validateInputString(inputString);
        System.out.println(isValidString);*/


        int inputNumber = 4;
        int result = calculateFactorial(inputNumber);
        //int result_01 = calculateFactorial_01(inputNumber);
        System.out.println("Result ::" + result);
    }

    /* private static int calculateFactorial_01(int inputNumber) {

     }
 */
    private static int calculateFactorial(int inputNumber) {
        int result = 1;
        if (inputNumber > 0) {
            result = inputNumber * calculateFactorial(inputNumber - 1);
        }
        return result;
    }

    private static boolean validateInputString(String inputString) {
        Stack<Character> stringStack = new Stack<>();
        for (int i = 0; i < inputString.length(); i++) {
            stringStack.push(inputString.charAt(i));//')'
        }

        return false;
    }

    //5*4*3*2
    int number = 5;

}
