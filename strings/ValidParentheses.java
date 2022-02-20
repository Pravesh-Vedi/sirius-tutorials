package questions.leetcode.strings;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("({[])}"));
    }

    private static boolean isValid(String inputSting) {
        // Stack to store left symbols
        Stack<Character> leftSymbols = new Stack<>();
        for(char inputChar : inputSting.toCharArray()){
            // If left symbol is encountered
            if ('(' == inputChar || '{' == inputChar || '[' == inputChar) {
                leftSymbols.push(inputChar);
            }else if(')'==inputChar && !leftSymbols.isEmpty() && '('==leftSymbols.peek()){
                leftSymbols.pop();
            }else if('}'==inputChar && !leftSymbols.isEmpty() && '{'==leftSymbols.peek()){
                leftSymbols.pop();
            }else if(']'==inputChar && !leftSymbols.isEmpty() && '['==leftSymbols.peek()){
                leftSymbols.pop();
            }else{
                return false;
            }
        }
        return leftSymbols.isEmpty();
    }
}
