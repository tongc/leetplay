package a;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Fibon {

    public long fibonRecurNaive(int until) {
        if(until == 1) {
            return 1;
        }
        if(until == 2) {
            return 2;
        }
        return fibonRecurNaive(until - 1) + fibonRecurNaive(until - 2);
    }

    Map<Integer, Long> cache = new HashMap<>();
    public long fibonRecurMem(int until) {
        if(until == 1) {
            return 1;
        }
        if(until == 2) {
            return 2;
        }
        if(cache.containsKey(until)) {
            return cache.get(until);
        }
        long result = fibonRecurMem(until - 1) + fibonRecurMem(until - 2);
        cache.put(until, result);
        return result;
    }

    public long fibonBottomUp(int until) {
        long lastSum = 1;
        long lastSum2 = 2;
        for(int i=2;i<until;i++) {
            long currentSum = lastSum + lastSum2;
            lastSum = lastSum2;
            lastSum2 = currentSum;
        }
        return lastSum2;
    }

    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        System.out.println(new Fibon().fibonRecurNaive(45));
        long end1 = System.currentTimeMillis();
        System.out.println(new Fibon().fibonRecurMem(6000));
        long end2 = System.currentTimeMillis();
        System.out.println(new Fibon().fibonBottomUp(600000));
        long end3 = System.currentTimeMillis();

        System.out.println(end1 - start1);
        System.out.println(end2 - end1);
        System.out.println(end3 - end2);
    }
}
