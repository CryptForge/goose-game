package me.cryptforge;

import me.cryptforge.tile.Tile;

import java.util.Arrays;
import java.util.function.Function;

public class Board {

    private final Tile[] tiles;

    public Board(int length) {
        tiles = new Tile[length];
    }

    public Tile getTile(int index) {
        return tiles[index];
    }

    public void setTile(int index, Tile tile) {
        tiles[index] = tile;
    }

    public void fill(Function<Integer, Tile> supplier) {
        for (int i = 0; i < size(); i++) {
            tiles[i] = supplier.apply(i);
        }
    }

    public int size() {
        return tiles.length;
    }

    @Override
    public String toString() {
        return "Board{" +
                "tiles=" + Arrays.toString(tiles) +
                '}';
    }
}
