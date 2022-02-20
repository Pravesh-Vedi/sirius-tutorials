package questions.leetcode.array;

public class MaxProfit {
    public static void main(String[] args) {
        int [] inputArray = {7,1,5,3,6,4};
        int maxProfit = maxProfit(inputArray);
        System.out.println("Max Profit is :: " +maxProfit);
    }

    private static int maxProfit(int[] inputArray) {
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int priceOnDay : inputArray) {
            minProfit = Math.min(minProfit, priceOnDay);
            maxProfit = Math.max(maxProfit, priceOnDay - minProfit);
        }
        return maxProfit;
    }
}
