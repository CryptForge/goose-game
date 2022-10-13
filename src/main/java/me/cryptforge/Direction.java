package me.cryptforge;

import java.util.function.Function;

public enum Direction {
    FORWARD(i -> i),
    BACKWARD(i -> -i);

    private final Function<Integer, Integer> transformer;

    Direction(Function<Integer, Integer> transformer) {
        this.transformer = transformer;
    }

    public int transform(int value) {
        return transformer.apply(value);
    }
}
