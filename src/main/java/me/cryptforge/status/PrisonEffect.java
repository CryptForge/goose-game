package me.cryptforge.status;

import me.cryptforge.Game;
import me.cryptforge.Player;

public class PrisonEffect extends StatusEffect {

    public PrisonEffect(Game game, Player player) {
        super(game, player, 1);
    }

    @Override
    public boolean tick() {
        decrementTurnsLeft();
        if(isPlayerBehind()) {
            setTurnsLeft(1);
        }
        return false;
    }

    private boolean isPlayerBehind() {
        for (Player player : getGame().getPlayers()) {
            if(player.getPosition() < getPlayer().getPosition())
                return true;
        }
        return false;
    }

}
