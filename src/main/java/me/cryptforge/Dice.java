package me.cryptforge;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private final int count;
    private final int max;
    private final int[] results;

    public Dice(int count, int max) {
        this.count = count;
        this.max = max;

        this.results = new int[count];
    }

    public void roll() {
        for(int i = 0; i < count; i++) {
            results[i] = ThreadLocalRandom.current().nextInt(1,max + 1);
        }
    }

    public int getResult(int index) {
        return results[index];
    }

    public int getTotal() {
        int total = 0;
        for(int result : results) {
            total += result;
        }
        return total;
    }

}
