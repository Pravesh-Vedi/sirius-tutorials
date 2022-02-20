package questions.leetcode.strings;

import java.util.function.Predicate;

public class DetectCapital{
    public static void main(String[] args) {
        String inputString = "PrAvesh";
        System.out.println("Usage is correct - case-01::" +capitalUsageIndicator_Case01(inputString)
                + "::case-02::" +capitalUsageIndicator_Case02(inputString));
    }

    private static boolean capitalUsageIndicator_Case02(String inputString) {
        if(inputString==null || inputString.length()==1){
            return true;
        }
        Predicate<Character> characterPredicate = Character::isLowerCase;
        if(Character.isUpperCase(inputString.charAt(0))
                && Character.isUpperCase(inputString.charAt(1))){
            characterPredicate = Character::isUpperCase;
        }
        for(int i=1;i<inputString.length();i++){
            if(!characterPredicate.test(inputString.charAt(i))){
                return false;
            }
        }

        return true;
    }

    private static boolean capitalUsageIndicator_Case01(String inputString) {
        int countCapitalLetters = 0;
        for(int i=1;i<inputString.length();i++){
            if(Character.isUpperCase(inputString.charAt(i))){
                countCapitalLetters++;
            }
        }
        return countCapitalLetters==0 || (Character.isUpperCase(inputString.charAt(0))?
                inputString.length()==countCapitalLetters+1:inputString.length()==countCapitalLetters);
    }
}
