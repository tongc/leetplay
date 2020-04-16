package a;

import java.util.concurrent.ThreadLocalRandom;

public class Math {
    public static void main(String[] args) {
        int bound = 10;
        for(int index = 0; index<100;index++){
            int i = ThreadLocalRandom.current().nextInt(10);
            int j = ThreadLocalRandom.current().nextInt(10);

            int i1 = ThreadLocalRandom.current().nextInt(10);
            int j1 = ThreadLocalRandom.current().nextInt(10);

            int i2 = ThreadLocalRandom.current().nextInt(10);
            int j2 = ThreadLocalRandom.current().nextInt(10);

            int i3 = ThreadLocalRandom.current().nextInt(10);
            int j3 = ThreadLocalRandom.current().nextInt(10);
            System.out.println(String.format("%s + %s =              %s + %s =              %s + %s =              %s + %s =", i, j, i1, j1, i2, j2, i3, j3));
        }
    }
}
