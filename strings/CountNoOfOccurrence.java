package questions.leetcode.strings;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountNoOfOccurrence {

    public static void main(String[] args) {
        String inputString = "Welcome to programming programming Welcome complexity";
        Arrays.stream(inputString.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " " + v));
    }
}
