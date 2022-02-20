package questions.leetcode.strings;

public class MoveCharacter {
    public static void main(String[] args) {
        String inputString = "aabcxweradfeaaatyuab";
        String outputString=moveChar(inputString);
        System.out.println(outputString);
    }

    private static String moveChar(String inputString) {
        if(inputString.isEmpty()){
            return "";
        }
        char charAt = inputString.charAt(0);
        if(charAt=='a'){
            return moveChar(inputString.substring(1).concat(String.valueOf(charAt)));
        }else{
            return String.valueOf(charAt).concat(moveChar(inputString.substring(1)));
        }
    }
}
