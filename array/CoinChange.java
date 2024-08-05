package questions.leetcode.array;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int [] coinArray = {1,5,2,11};
        int amount = 17;

        int result = coinChange(coinArray,amount);
        System.out.println("Results :: " +result);
    }

    private static int coinChange(int[] coinArray, int amount) {
        //Arrays.sort(coinArray);
        int [] dpArray = new int[amount+1];
        Arrays.fill(dpArray,amount+1);
        dpArray[0] = 0;

        for(int i=0;i<=amount;i++){
            for (int k : coinArray) {
                if (k <= i) {
                    dpArray[i] = Math.min(dpArray[i], 1 + dpArray[i - k]);
                } else {
                    break;
                }

            }
        }
        return dpArray[amount]>amount?-1:dpArray[amount];
    }
}
