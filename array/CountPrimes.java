package questions.leetcode.array;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CountPrimes {//implements Callable, Runnable, Comparable, Comparator {

    public static void main(String[] args) {
        /*CountDownLatch countDownLatch;
        CyclicBarrier cyclicBarrier;
        ExecutorService executorService;
        ReentrantLock reentrantLock;
        Semaphore semaphore;
        Future future;
        CompletableFuture completableFuture;*/
        int inputNumber = 20;
       /* Thread thread = new Thread();
        thread.join();*/
        Stream.iterate(1, i -> i + 1)
                .limit(20)
                .filter(CountPrimes::isPrime)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static boolean isPrime(int number) {
        return number > 1 && IntStream.range(2, number).noneMatch(n -> number % n == 0);
    }
}
