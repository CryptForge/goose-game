package me.cryptforge.tile;

import me.cryptforge.Game;
import me.cryptforge.Player;

public class GooseTile extends Tile {
    @Override
    public void activate(Game game, Player player) {
        game.movePlayer(player, game.getDice().getTotal(), true);
    }

    @Override
    public String toString() {
        return "G";
    }
}
