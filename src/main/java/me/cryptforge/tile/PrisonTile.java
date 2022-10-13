package me.cryptforge.tile;

import me.cryptforge.Game;
import me.cryptforge.Player;
import me.cryptforge.status.PrisonEffect;

public class PrisonTile extends Tile {

    @Override
    public void activate(Game game, Player player) {
        player.addStatusEffect(new PrisonEffect(game,player));
    }


    @Override
    public String toString() {
        return "P";
    }
}
