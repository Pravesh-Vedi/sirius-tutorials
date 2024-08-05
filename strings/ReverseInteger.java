package questions.leetcode.strings;

public class ReverseInteger {
    public static void main(String[] args) {
        int [] inputString = {2,1,4,7,4,8,3,6,4,7};
        reverseInteger(inputString);
        for (int j : inputString) {
            System.out.println("Reversed String :: " + j);
        }
        
        int inputNumber = 2147483647;
                         // 2147483647
        int[] testArray = new int[String.valueOf(inputNumber).length()];;
        int reverseNumbered = reverseInteger(inputNumber);
        System.out.println("Reversed String :: " +reverseNumbered);
    }

    private static int reverseInteger(int inputNumber) {
        int reverse = 0;
        int pop ;
        while(inputNumber!=0){
            pop = inputNumber%10;
            inputNumber /= 10;

            if(reverse>Integer.MAX_VALUE/10 || reverse==Integer.MAX_VALUE/10 && pop>7){
                return 0;
            }
            if(reverse<Integer.MIN_VALUE/10 || reverse==Integer.MIN_VALUE/10 && pop<-8){
                return 0;
            }
            reverse = reverse*10+pop;
        }
        return reverse;
    }

    private static void reverseInteger(int[] inputString) {
       int start = 0 ;
       int end = inputString.length-1;
        while(start<=end){
            int tmp = inputString[end];
            inputString[end]=inputString[start];
            inputString[start]=tmp;
            start ++;
            end--;
        }
    }

}
