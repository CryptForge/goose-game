package me.cryptforge.tile;

import me.cryptforge.Game;
import me.cryptforge.Player;

public class FinishTile extends Tile {
    @Override
    public void activate(Game game, Player player) {
        game.win(player);
    }

    @Override
    public String toString() {
        return "F";
    }
}
