package questions.leetcode.array;

public class TwoPlayerCoinGame {
    public static void main(String[] args) {
        int[]inputArray = {18,20,15,30,10,14};
        System.out.println("Winner should always select card from ::: "+ winningStrategy(inputArray));
    }

    private static String winningStrategy(int[] inputArray) {
        int evenSum = 0;
        int oddSum = 0;

        for(int i=0;i<inputArray.length;i++){
            if(i%2==0){
                evenSum = evenSum+inputArray[i];
            }else{
                oddSum=oddSum+inputArray[i];
            }
        }
        System.out.println("Sum at Even Indices :: "+evenSum);
        System.out.println("Sum at Odd Indices :: "+oddSum);
        if(evenSum<oddSum){
            return "Left";
        }else if(evenSum>oddSum){
            return "right";
        }else{
            return "Any Direction";
        }
    }
}
