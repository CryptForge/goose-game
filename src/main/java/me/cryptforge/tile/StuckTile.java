package me.cryptforge.tile;

import me.cryptforge.Game;
import me.cryptforge.Player;
import me.cryptforge.status.StuckEffect;

public class StuckTile extends Tile {

    private final int length;

    public StuckTile(int length) {
        this.length = length;
    }

    @Override
    public void activate(Game game, Player player) {
        player.addStatusEffect(new StuckEffect(game,player,length));
    }

    @Override
    public String toString() {
        return "S";
    }
}
