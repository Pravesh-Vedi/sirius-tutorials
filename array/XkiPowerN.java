package questions.leetcode.array;

public class XkiPowerN {
    public static void main(String[] args) {
        int inputNumber=4;
        int power=5;
        int result = calculatePower(inputNumber,power);
        System.out.println("Result :: "+result);

    }

    private static int calculatePower(int inputNumber, int power) {
        if (power == 1){
            return inputNumber;
        } else if (power==0) {
            return 1;
        }
        return inputNumber*calculatePower(inputNumber,power-1);
    }
}
