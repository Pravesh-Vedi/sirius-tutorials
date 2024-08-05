package questions.leetcode.array;

public class SquareRoot {
    public static void main(String[] args) {
        int inputNumber = 36;
        System.out.println("Square Root is :: "+findSquareRoot(inputNumber));
    }

    private static int findSquareRoot(int inputNumber) {
        if(inputNumber==0 || inputNumber==1){
            return inputNumber;
        }
        long letPointer = 0 , rightPointer = inputNumber, result = 0;
        while(letPointer<=rightPointer){
            long midPoint = letPointer+(rightPointer-letPointer)/2;
            if(midPoint*midPoint==inputNumber){
                return (int)midPoint;
            }else if(midPoint*midPoint<inputNumber){
                result = midPoint;
                letPointer = midPoint+1;
            }else{
                rightPointer=midPoint-1;
            }
        }
        return (int)result;
    }
}
