package questions.leetcode.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {

    public static void main(String[] args) {
        String inputString = "aabbddc";
        int index = firstUniqueChar(inputString);
        System.out.println("Index Value is :: " +index +" :: Char is :: " +inputString.charAt(index));

        int index_01 = firstUniqueChar_02(inputString);
        System.out.println("Index_01 Value is :: " +index_01 +" :: Char is :: " +inputString.charAt(index_01));

        char index_02 = firstUniqueChar_03(inputString);
        System.out.println("Index_02 Value is :: " +inputString.indexOf(index_02)+" :: Char is :: " +index_02);
    }

    private static char firstUniqueChar_03(String inputString) {
        HashMap<Character, Integer>hashMap = new HashMap<>();
        for(int i=0; i<inputString.length();i++){
            if(!hashMap.containsKey(inputString.charAt(i))){
                hashMap.put(inputString.charAt(i),1);
            }else{
                hashMap.put(inputString.charAt(i),hashMap.get(inputString.charAt(i))+1);
            }
        }
        return Collections.min(hashMap.entrySet(),Map.Entry.comparingByValue()).getKey();
    }

    private static int firstUniqueChar_02(String inputString) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inputString.length(); i++) {
            if (!hashMap.containsKey(inputString.charAt(i))) {
                hashMap.put(inputString.charAt(i), i);
            } else {
                hashMap.put(inputString.charAt(i), -1);
            }
        }
        int min = Integer.MAX_VALUE;
        for (char c : hashMap.keySet()) {
            if (hashMap.get(c) > -1 && hashMap.get(c) < min) {
                min = hashMap.get(c);
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }

    private static int firstUniqueChar(String inputString) {
        for(int i=0;i<inputString.length();i++){
            int indexOfFirstOcc = inputString.indexOf(inputString.charAt(i));
            if(indexOfFirstOcc ==inputString.lastIndexOf(inputString.charAt(i))){
                return indexOfFirstOcc;
            }
        }
        return -1;
    }
}
