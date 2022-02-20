package questions.leetcode.strings;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String [] inputStringArray = {"flower","flow","flight"};
        String prefix = longestCommonPrefix(inputStringArray);
        System.out.println("Longest Common Prefix :: "+prefix);
    }

    private static String longestCommonPrefix(String[] inputStringArray) {
        if(inputStringArray ==null || inputStringArray.length==0){
            return "";
        }
        String prefix = inputStringArray[0];
        for(int i=1;i<inputStringArray.length;i++){
            while(inputStringArray[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
}
