package questions.leetcode.array;

public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        int inputNumber = 50;
        int outputTrailingZeros = trailingZeroes(inputNumber);
        System.out.println(" Zeros are :: "+outputTrailingZeros);
    }

    private static int trailingZeroes(int inputNumber) {
        int result = 0;
        while(inputNumber>0){
            inputNumber= inputNumber/5;
            result = inputNumber+result;
        }
        return result;
    }
}
