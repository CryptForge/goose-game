package me.cryptforge.tile;

import me.cryptforge.Game;
import me.cryptforge.Player;

public class NumberedTile extends Tile {

    private final int number;

    public NumberedTile(int number) {
        this.number = number;
    }

    @Override
    public void activate(Game game, Player player) {

    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
