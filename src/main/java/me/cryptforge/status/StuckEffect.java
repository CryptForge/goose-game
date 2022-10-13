package me.cryptforge.status;

import me.cryptforge.Game;
import me.cryptforge.Player;

public class StuckEffect extends StatusEffect {

    public StuckEffect(Game game, Player player, int turnsLeft) {
        super(game, player, turnsLeft);
    }

    @Override
    public boolean tick() {
        decrementTurnsLeft();
        return false;
    }
}
