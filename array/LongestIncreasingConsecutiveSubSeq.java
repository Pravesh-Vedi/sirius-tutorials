package questions.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestIncreasingConsecutiveSubSeq {
    public static void main(String[] args) {
        int [] inputArray = {7,5,4,9,10,15,8,6};

        int sequenceLength = findSequence(inputArray);
        System.out.println("Length is :: " +sequenceLength);

        int sequenceLength_01 = findSequence_01(inputArray);
        System.out.println("Length is :: " +sequenceLength_01);
    }

    //O(N)
    private static int findSequence_01(int[] inputArray) {
        Set<Integer>integerSet = new HashSet<>();
        for(int number:inputArray){
            integerSet.add(number);
        }
        int longestConsecutiveSequence = 0;
        for(int number :integerSet){
            if(!integerSet.contains(number-1)){
                int currentNumber = number;
                int currentConsecutiveSequence = 1 ;
                while(integerSet.contains(currentNumber+1)){
                    currentNumber = currentNumber+1;
                    currentConsecutiveSequence = currentConsecutiveSequence+1;
                }
                longestConsecutiveSequence = Math.max(currentConsecutiveSequence, longestConsecutiveSequence);
            }
        }
        return longestConsecutiveSequence;
    }

    private static int findSequence(int[] inputArray) {
        Arrays.sort(inputArray);//O(NLogN)
        int seqLength = 1;
        int maxLength = 1;
        for(int i=1;i<inputArray.length;i++){//O(N)
            if(inputArray[i]==inputArray[i-1]+1){
                seqLength++;
            }else if (inputArray[i]==inputArray[i-1]){
                continue;
            }else{
                seqLength=1;
            }
            maxLength = Math.max(maxLength,seqLength);
        }

        return maxLength;
    }
}
