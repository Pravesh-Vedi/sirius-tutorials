package questions.leetcode.array;

public class ProductArray {
    public static void main(String[] args) {
        int [] inputArray={2,3,5,2};
        int [] outputArray= new int[inputArray.length];
        outputArray[0]=1;
        for(int i=1;i<inputArray.length;i++){
            outputArray[i]=inputArray[i-1]*outputArray[i-1];
        }
        int rightElement = 1;
        for(int i=inputArray.length-1;i>=0;i--){
            outputArray[i]=outputArray[i]*rightElement;
            rightElement=rightElement*inputArray[i];
        }
        for (int j : outputArray) {
            System.out.println("Output Array is : ---> " + j);
        }
    }
}
