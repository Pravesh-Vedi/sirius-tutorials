package questions.leetcode.array;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int [] inputArray = {1,2,-3,0,-4,-5};
        int result = maxProductSubArray(inputArray);
        System.out.println("Max Product is :: " +result);
    }

    private static int maxProductSubArray(int[] inputArray) {
        if(inputArray.length == 0){
            return -1;
        }else if(inputArray.length==1){
            return inputArray[0];
        }else {
            int prod1 = inputArray[0];
            int prod2 = inputArray[0];
            int result = inputArray[0];

            for (int i = 1; i < inputArray.length; i++) {
                int tmp = Math.max(inputArray[i], Math.max(prod1 * inputArray[i], prod2 * inputArray[i]));
                prod2 = Math.min(inputArray[i], Math.min(prod1 * inputArray[i], prod2 * inputArray[i]));
                prod1 = tmp;

                result = Math.max(result, prod1);
            }
            return result;
        }
    }
}
