package questions.leetcode.array;

public class ElementSubsetProblem {
    public static void main(String[] args) {
        int [] inputArray = {2,3,7,8,10};
        int sum = 11;
        boolean isElementSubsetExist = evaluateElementSubset(inputArray,sum);
        System.out.println("Subset Exists :: " +isElementSubsetExist);
    }

    private static boolean evaluateElementSubset(int[] inputArray, int sum) {
        boolean[][]resultArray = new boolean[inputArray.length + 1][sum + 1];
        /*for (int i=0;i<inputArray.length-1;i++){
            for(int j=0;j<sum-1;j++){
                Arry[i][j]=Boolean.TRUE;
                Arry[i][j]=Boolean.FALSE;
                if(inputArray[i-1]<=j){
                    Arry[i][j]=Arry[i][j-inputArray[i-1]] || Arry[i-1][j];
                }else{
                    Arry[i][j]=Arry[i-1][j];
                }
            }
        }*/

        for(int i=1; i<=sum;i++){
            resultArray[0][i] = Boolean.FALSE;
        }

        for(int j=0;j<=inputArray.length;j++){
            resultArray[j][0] = Boolean.TRUE;
        }

        for(int i=1;i<=inputArray.length;i++){
            for(int j=1;j<=sum;j++){
                resultArray[i][j] = resultArray[i-1][j];
                if(!resultArray[i][j] && j>=inputArray[i-1]){
                    resultArray[i][j]=resultArray[i][j] || resultArray[i-1][j-inputArray[i-1]];
                }
            }
        }
        return resultArray[inputArray.length][sum];
    }
}
