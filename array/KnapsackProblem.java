package questions.leetcode.array;

public class KnapsackProblem {
    private static int[] weightArray ={1, 3, 4, 5};
    private static int[] valueArray = {1,4,5,7};
    private  static int weightLimit = 7;

    private static int n = weightArray.length+1;
    private static int m = weightLimit+1;

    private static int [][] twoD_arr  = new int[n][m];

    public static void main(String[] args) {
        int[] weightArray = {1, 3, 4, 5};
        int[] valueArray = {1,4,5,7};
        int weightLimit = 7;

        /*int maxProfit = evaluateKnapsack(weightArray, valueArray, weightLimit, weightArray.length);
        System.out.println("Max Profit is :: " + maxProfit);*/

        int maxProfitUsingTopDown = evaluateKnapsackUsingTopDown(weightArray,valueArray,weightLimit,weightArray.length);
        System.out.println("Max Profit is :: " + maxProfitUsingTopDown);
    }

    private static int evaluateKnapsackUsingTopDown(int[] weightArray, int[] valueArray, int weightLimit, int length) {
        if (length == 0 || weightLimit == 0) {
            return 0;
        }
        int[][] twoD_arr = new int[length + 1][weightLimit + 1];
        for(int i=0;i<length;i++){
            for(int j=0;j<weightLimit;j++){
                twoD_arr[i][j]=0;
            }
        }
        for(int i=1;i<=length;i++) {
            for (int j = 1; j <= weightLimit; j++) {
                if(weightArray[i-1]<=j){
                    twoD_arr[i][j]=Math.max(valueArray[i-1]+twoD_arr[i-1][j-weightArray[i-1]], twoD_arr[i-1][j]);
                }else{
                    twoD_arr[i][j]=twoD_arr[i-1][j];
                }
            }
        }

        return twoD_arr[length][weightLimit];
    }



    private static int evaluateKnapsack(int[] weightArray, int[] valueArray, int weightLimit, int length) {
        if (length == 0 || weightLimit == 0) {
            return 0;
        }
        if(twoD_arr[length][weightLimit]!=0){
            return twoD_arr[length][weightLimit];
        }
        if (weightArray[length - 1] <= weightLimit) {
            return twoD_arr[length][weightLimit] = Math.max(valueArray[length - 1] + evaluateKnapsack(weightArray, valueArray,  valueArray[length - 1]-weightLimit, length - 1),
                    evaluateKnapsack(weightArray,valueArray,weightLimit,length-1));
        }else if (weightArray[length - 1] > weightLimit) {
            return twoD_arr[length][weightLimit] = evaluateKnapsack(weightArray,valueArray,weightLimit,length-1);
        }
        return 0;
    }
}
