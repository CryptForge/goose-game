package me.cryptforge.status;

import me.cryptforge.Game;
import me.cryptforge.Player;

public abstract class StatusEffect {

    private final Game game;
    private final Player player;

    private int turnsLeft;

    public StatusEffect(Game game, Player player, int turnsLeft) {
        this.game = game;
        this.player = player;
        this.turnsLeft = turnsLeft;
    }

    public abstract boolean tick();

    protected Game getGame() {
        return game;
    }

    protected Player getPlayer() {
        return player;
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }

    protected void setTurnsLeft(int value) {
        this.turnsLeft = value;
    }

    protected void decrementTurnsLeft() {
        setTurnsLeft(getTurnsLeft() - 1);
    }
}
