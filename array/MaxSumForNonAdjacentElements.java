package questions.leetcode.array;

/**
 * <p>
 * Find maximum sum for non adjacent elements.
 * Variation is finding maximum sum non adjacent elements assuming its a circular array.
 * So first element cannot be with last element.
 * <p>
 * Time complexity O(n)
 * Space complexity O(1)
 * <p>
 * https://leetcode.com/problems/house-robber/
 * https://leetcode.com/problems/house-robber-ii/
 */
public class MaxSumForNonAdjacentElements {
    public static void main(String[] args) {
        int[] inputArray =  {50, 8, 3, 8, 9, 10 };
        System.out.println("Maximum Sum is :: " +maxSum(inputArray));
        System.out.println("Max Sum :: " +maxSumNonAdj(inputArray));
        System.out.println("Sum at Even Indices :: "+evenIndicesSum(inputArray));
        System.out.println("Sum at Odd Indices :: "+oddIndicesSum(inputArray));
        System.out.println("Maximum Sum in Circular Array is :: " +maxCircularArraySum(inputArray));
    }

    private static int maxSumNonAdj(int[] inputArray) {
        int evenSum = 0, oddSum = 0;
        for (int i=0;i<inputArray.length;i++){
            if(i%2==0){
                evenSum = evenSum+inputArray[i];
            }else{
                oddSum = oddSum+inputArray[i];
            }
        }
        return Math.max(evenSum, oddSum);
    }

    private static int oddIndicesSum(int[] inputArray) {
        int sum = 0;
        for(int i=0; i<inputArray.length;i++){
            if(i%2!=0){
               sum = sum+inputArray[i];
            }
        }
        return sum;
    }

    private static int evenIndicesSum(int[] inputArray) {
        int sum = 0;
        for(int i=0; i<inputArray.length;i++){
            if(i%2==0){
                sum = sum+inputArray[i];
            }
        }
        return sum;
    }

    private static int maxCircularArraySum(int[] inputArray) {
        int includeNum = inputArray[1];
        int excludeNum = 0;
        for(int i=2;i<inputArray.length;i++){
            int tmp = includeNum;
            includeNum = Math.max(includeNum, excludeNum + inputArray[i]);
            excludeNum = tmp;
        }
        int includeNum_01 = inputArray[inputArray.length-2];
        int excludeNum_01 = 0;
        for(int i=inputArray.length-2;i>=0;i--){
            int tmp = includeNum_01;
            includeNum_01 = Math.max(includeNum_01, excludeNum_01 + inputArray[i]);
            excludeNum_01 = tmp;
        }

        return Math.max(includeNum,includeNum_01);
    }

    private static int  maxSum(int[] inputArray) {
        int exclude = 0;
        int include = inputArray[0];

        for(int i=1;i<inputArray.length;i++){
            int tmp = include;
            include = Math.max(exclude +inputArray[i], include);
            exclude = tmp;
        }

        return include;
    }
}
