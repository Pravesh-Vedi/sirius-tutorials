package questions.leetcode.array;

import java.util.function.BiFunction;

public class MultipleTwoNumbers {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer>integerFunction = (a, b)->a*b;
        System.out.println(integerFunction.apply(8,7));
    }
}
