package me.cryptforge;

import org.fusesource.jansi.Ansi;

public enum Color {
    BLUE(Ansi.Color.BLUE),
    RED(Ansi.Color.RED),
    GREEN(Ansi.Color.GREEN),
    YELLOW(Ansi.Color.YELLOW),
    BLACK(Ansi.Color.BLACK),
    WHITE(Ansi.Color.WHITE);

    private final Ansi.Color ansiColor;

    Color(Ansi.Color ansiColor) {
        this.ansiColor = ansiColor;
    }

    public Ansi.Color getAnsiColor() {
        return ansiColor;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
