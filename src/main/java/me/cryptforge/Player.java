package me.cryptforge;

import me.cryptforge.status.StatusEffect;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final Color color;
    private final List<StatusEffect> effects;
    private int position;
    private Direction direction;

    public Player(Color color) {
        this.color = color;
        this.effects = new ArrayList<>();
        this.position = 0;

        direction = Direction.FORWARD;
    }

    public Color getColor() {
        return color;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void addStatusEffect(StatusEffect effect) {
        effects.add(effect);
    }

    public boolean tickEffects() {
        boolean doTurn = true;
        for (StatusEffect effect : effects) {
            if (!effect.tick()) {
                doTurn = false;
            }
        }
        effects.removeIf(effect -> effect.getTurnsLeft() <= 0);
        return doTurn;
    }
}
