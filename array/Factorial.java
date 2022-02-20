package questions.leetcode.array;

public class Factorial {
    public static void main(String[] args) {
        int outputNumber = findFactorial(3);
        System.out.println("Factorial is :: " +outputNumber);
    }

    private static int findFactorial(int inputNumber) {
        /*int value = 1;
        for(int i=value+1;i<=inputNumber;i++){
            value = value*i;
        }
        return  value;*/
        int factorial = 1;
        for(int i= inputNumber; i>0;i--){
            factorial = factorial * i;
        }
        return factorial;
    }
}
