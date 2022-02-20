package questions.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println("Generate Parentheses ::" + generateParentheses(4));
    }

    private static List<String> generateParentheses(int number) {
        List<String> stringList = new ArrayList<>();
        generateString(stringList,"",0,0,number);
        return stringList;
    }

    private static void generateString(List<String> stringList, String currentString, int open, int close, int max) {
        if(open==max && close == max){
            stringList.add(currentString);
            return;
        }
        /*if(currentString.length()==max*2){
             stringList.add(currentString);
             return;
        }*/
        if(open<max){
            generateString(stringList, currentString.concat("("), open+1, close, max);
        }
        if(close<open){
            generateString(stringList, currentString.concat(")"), open, close+1, max);
        }
    }
}
