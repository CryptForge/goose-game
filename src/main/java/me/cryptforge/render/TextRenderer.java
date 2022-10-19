package me.cryptforge.render;

import me.cryptforge.Game;
import me.cryptforge.Player;
import me.cryptforge.tile.Tile;
import org.fusesource.jansi.Ansi;

public class TextRenderer implements GameRenderer {

    @Override
    public void render(Game game) {
        final Ansi builder = Ansi.ansi();

        for (int i = 0; i < game.getBoard().size(); i++) {
            final Tile tile = game.getBoard().getTile(i);
            final Player player = game.getPlayerAtTile(i);

            builder.a('|');

            if (player != null) {
                builder.fg(player.getColor().toAnsi()).a('G').reset();
            } else {
                builder.a(tile.toString());
            }
        }

        builder.a('|');

        System.out.println(builder);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }
}
