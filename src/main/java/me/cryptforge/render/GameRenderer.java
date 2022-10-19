package me.cryptforge.render;

import me.cryptforge.Game;

public interface GameRenderer {

    void render(Game game);

    void sendMessage(String message);

}
