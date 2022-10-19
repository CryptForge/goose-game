package me.cryptforge.tile;

import me.cryptforge.Game;
import me.cryptforge.Player;

public class TeleportTile extends Tile {

    private final int target;

    public TeleportTile(int target) {
        this.target = target;
    }

    @Override
    public void activate(Game game, Player player) {
        game.setPlayerPosition(player, target, false);
    }

    @Override
    public String toString() {
        return "T";
    }
}
