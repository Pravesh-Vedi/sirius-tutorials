package questions.leetcode.strings;

public class ValidPalindrome {
    public static void main(String[] args) {
        String inputString = "A man, a plan, a canal: Panama";
        char[] chars = inputString.toCharArray();
        boolean isValidPalindrome = isValidPalindrome(inputString);
        boolean isPalindrome = isPalindrome(chars, 0, chars.length - 1);

        System.out.println("Valid Palindrome :: " + isValidPalindrome);
        System.out.println("Valid Palindrome case-02:: " + isPalindrome);
    }

    private static boolean isPalindrome(char[] chars, int start, int end) {
        if (start > end) {
            return true;
        }
        return chars[start] == chars[end] && isPalindrome(chars, start + 1, end - 1);
    }

    private static boolean isValidPalindrome(String inputString) {
        String fixedString = "";
        for (char c : inputString.toCharArray()) {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                fixedString = fixedString + c;
            }
        }
        fixedString = fixedString.toLowerCase();
        int leftPointer = 0;
        int rightPointer = fixedString.length() - 1;
        while (leftPointer <= rightPointer) {
            if (fixedString.charAt(leftPointer) != fixedString.charAt(rightPointer)) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }
}
