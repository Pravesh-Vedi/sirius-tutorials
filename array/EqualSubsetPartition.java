package questions.leetcode.array;

public class EqualSubsetPartition {
    public static void main(String[] args) {
        int [] inputArray = {1,5,5,11};
        boolean subsetExist = isSubsetExist(inputArray);
        System.out.println("Subset Exist :: " +subsetExist);
    }

    private static boolean isSubsetExist(int[] inputArray) {
        int addition = 0;
        for(int item : inputArray){
            addition = addition+item;
        }
        if(addition%2!=0){
            return false;
        }else {
            subSetSum(inputArray,addition/2);
        }
        return false;
    }

    private static void subSetSum(int[] inputArray, int sum) {
       int[][]tw_DArry = new int [inputArray.length+1][sum+1];
       for (int i=0;i<inputArray.length;i++){
           for(int j=0;j<sum;j++){
               if(i==0){
                   tw_DArry[i][j]=0;
               }if(j==0){
                   tw_DArry[i][j]=0;
               }
           }
       }
    }
}
