package me.cryptforge;

import me.cryptforge.render.GameRenderer;
import me.cryptforge.tile.*;
import me.cryptforge.util.WrappedInt;

import java.util.List;

public class Game {

    private final List<Player> players;
    private final Board board;
    private final WrappedInt currentPlayer;
    private final Dice dice;
    private final GameRenderer renderer;

    private boolean isDone;

    public Game(int boardSize, GameRenderer renderer, Player... players) {
        this.renderer = renderer;
        this.players = List.of(players);
        this.board = new Board(boardSize);
        this.currentPlayer = new WrappedInt(0, 0, players.length);
        this.dice = new Dice(2, 6);

        board.fill(NumberedTile::new);

        // Goose tiles
        for (double i = 5; i < boardSize; i += 4.5) {
            board.setTile((int) Math.floor(i), new GooseTile());
        }

        board.setTile(6, new TeleportTile(12)); // bridge
        board.setTile(19, new StuckTile(1)); // inn
        board.setTile(31, new PrisonTile()); // well
        board.setTile(42, new TeleportTile(37)); // thorn bush
        board.setTile(52, new PrisonTile()); // jail
        board.setTile(58, new TeleportTile(0)); // death
        board.setTile(boardSize - 1, new FinishTile()); // finish
    }

    public Tile setPlayerPosition(Player player, int target, boolean activateTile) {
        if (getPlayerAtTile(target) != null)
            return null;
        player.setPosition(target);

        final Tile tile = board.getTile(target);
        if (activateTile) {
            tile.activate(this, player);
        }

        return tile;
    }

    public Tile movePlayer(Player player, int amount, boolean activateTile) {
        final int actualAmount = player.getDirection().transform(amount);
        int target = player.getPosition() + actualAmount;

        final int finishTile = board.size() - 1;
        if (target > finishTile) {
            final int amountLeft = Math.abs(target - finishTile);
            player.setDirection(Direction.BACKWARD);
            player.setPosition(finishTile);
            return movePlayer(player, amountLeft, true);
        }

        target = Math.max(0, target);

        return setPlayerPosition(player, target, activateTile);
    }

    public void gameLoop() {
        final Player player = getCurrentPlayer();

        renderer.sendMessage(player.getColor() + "'s turn");
        boolean doTurn = player.tickEffects();

        if (doTurn) {
            player.setDirection(Direction.FORWARD);
            dice.roll();
            int amountToMove = dice.getTotal();
            if (player.getPosition() == 0) { // Shortcuts
                if ((dice.getResult(0) == 4 && dice.getResult(1) == 5) || (dice.getResult(0) == 5 && dice.getResult(1) == 4))
                    amountToMove = 53;
                if ((dice.getResult(0) == 6 && dice.getResult(1) == 3) || (dice.getResult(0) == 3 && dice.getResult(1) == 6))
                    amountToMove = 26;
            }

            renderer.sendMessage(player.getColor() + " is attempting to move " + amountToMove + " tiles");

            final Tile tile = movePlayer(player, amountToMove, true);

            renderer.sendMessage(player.getColor() + " has landed on " + tile);
        }
        currentPlayer.increment();

        renderer.render(this);
    }

    public void win(Player player) {
        System.out.println(player.getColor() + " wins!");
        isDone = true;
    }

    public Player getPlayerAtTile(int tile) {
        for (Player player : players) {
            if (player.getPosition() == tile) {
                return player;
            }
        }
        return null;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayer.get());
    }

    public Player getPlayer(int index) {
        if (index < 0 || index >= players.size())
            return null;
        return players.get(index);
    }

    public Dice getDice() {
        return dice;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isDone() {
        return isDone;
    }
}
