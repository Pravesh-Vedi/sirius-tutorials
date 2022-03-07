package questions.leetcode.strings;

public class ReverseString {
    public static void main(String[] args) {
        char[] inputString = {'h', 'e', 'l', 'l', 'o'};
        reverseString(inputString);
        for (char c : inputString) {
            System.out.println("Reversed String :: " + c);
        }
    }

    public static void reverseString(char[] inputString) {
        char tmp;
        int start = 0;
        int end = inputString.length - 1;
        while (start < end) {
            tmp = inputString[end];
            inputString[end] = inputString[start];
            inputString[start] = tmp;
            start++;
            end--;
        }
    }
}
