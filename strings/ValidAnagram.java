package questions.leetcode.strings;

public class ValidAnagram {
    public static void main(String[] args) {
        String inputStr_01 = "anagram";
        String inputStr_02 = "agaamrn";

        boolean isValidAnagram= isValidAnagram(inputStr_01,inputStr_02);
        System.out.println("Valid Anagrams :: " +isValidAnagram);
    }

    private static boolean isValidAnagram(String inputStr_01, String inputStr_02) {
        if(inputStr_01.length()!=inputStr_02.length()){
            return false;
        }
        int [] char_tmp_array = new int[26];
        for(int i=0;i<inputStr_01.length();i++){
            char_tmp_array[inputStr_01.charAt(i)-'a']++;
            char_tmp_array[inputStr_02.charAt(i)-'a']--;
        }
        for(int char_01:char_tmp_array){
            if(char_01!=0){
                return false;
            }

        }
        return true;
    }
}
