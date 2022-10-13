package me.cryptforge.util;

public class WrappedInt {

    private final int min;
    private final int max;

    private int value;

    public WrappedInt(int value, int min, int max) {
        this.value = value;
        this.min = min;
        this.max = max;
    }

    public int add(int amount) {
        final int newValue = value + amount;
        value = newValue % max;
        return value;
    }

    public int increment() {
        return add(1);
    }


    public int get() {
        return value;
    }
}
