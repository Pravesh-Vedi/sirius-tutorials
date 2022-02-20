package questions.leetcode.array;

import java.util.Arrays;

public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] inputArray_01 ={1,3,5,7};
        int[] inputArray_02 ={9,6,8,0};
        int[] inputArray_03 = addTwoNumbers(inputArray_01,inputArray_02);
        int[] inputArray_04 = addTwoNumbers_case_02(inputArray_01,inputArray_02);
       // int inputArray_05 [] = addTwoNumbers_case_03(inputArray_01,inputArray_02);
       // Arrays.stream(inputArray_05).forEach(System.out::println);
        for(int number : inputArray_03){
            System.out.println(number);
        }
        System.out.println("\n");
        for(int number : inputArray_04){
            System.out.println(number);
        }
    }

    private static int[] addTwoNumbers_case_03(int[] inputArray_01, int[] inputArray_02) {
        int start = 0;
        int end = inputArray_01.length-1;
        int position = start+inputArray_01.length-1;
        for(int i=inputArray_01.length-1;i>=0;i--){
            inputArray_01[position]= inputArray_01[end]+inputArray_02[end];
            position--;
            end--;
        }
        return inputArray_01;
    }

    private static int[] addTwoNumbers_case_02(int[] inputArray_01, int[] inputArray_02) {
        int start = 0;
        int end = inputArray_01.length-1;
        int position = start+inputArray_01.length-1;
        int carryNumber = 0;
        for(int i=inputArray_01.length-1;i>=0;i--){
            int currentSum = inputArray_01[end]+inputArray_02[end] +carryNumber;
            carryNumber = currentSum/10;
            int lastDigit = currentSum %10;
            inputArray_01[position]= lastDigit;
            position--;
            end--;
        }
        int[] newIntArray = Arrays.copyOf(inputArray_01, inputArray_01.length);
        newIntArray[0]=1;
        return newIntArray;
    }

    private static int [] addTwoNumbers(int[] inputArray_01, int[] inputArray_02) {
        int length = Math.max(inputArray_01.length, inputArray_02.length);
        int[] resultArray = new int[length];

        int i = inputArray_01.length -1;
        int j = inputArray_02.length-1;
        int k=resultArray.length-1;
        int carry = 0;

        while(k>=0){
            int digit =carry;
            if(i>=0){
                digit = digit+inputArray_01[i];
            }
            if(j>=0){
                digit = digit+inputArray_02[j];
            }
            carry = digit/10;
            digit = digit%10;

            resultArray [k] = digit;

            i--;
            j--;
            k--;
        }

       /* for(int i=0;i<length;i++){
            if( carry + inputArray_01[i] + inputArray_02[i]<=9){
                resultArray[k++] = carry + inputArray_01[i] + inputArray_02[i];
            }else{
                carry = carry+1;
                resultArray[k++]=0;
                //resultArray[] = new int[length+1];
            }
        }
        //newIntArray[0]=1;*/
        if(carry!=0){
            resultArray[0] = carry;
        }
        return resultArray;
    }
}
