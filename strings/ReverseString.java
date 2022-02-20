package questions.leetcode.strings;

public class ReverseString {
    public static void main(String[] args) {
        char[] inputString = {'h','e','l','l','o'};
        reverseString(inputString);
        for(int i = 0;i<inputString.length;i++){
            System.out.println("Reversed String :: " +inputString[i]);
        }
    }

    public static void reverseString(char[] inputString) {
        char tmp;
        int start = 0; int end = inputString.length-1;
        while(start<end){
            tmp = inputString[end];
            inputString[end] = inputString[start];
            inputString[start]=tmp;
            start++;
            end--;
        }
    }
}
