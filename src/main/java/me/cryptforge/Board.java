package me.cryptforge;

import me.cryptforge.tile.Tile;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

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

    public void fill(Function<Integer,Tile> supplier) {
        for(int i = 0; i < length(); i++) {
            tiles[i] = supplier.apply(i);
        }
    }

    public List<Tile> getTiles() {
        return List.of(tiles);
    }

    public int length() {
        return tiles.length;
    }


    @Override
    public String toString() {
        return "Board{" +
                "tiles=" + Arrays.toString(tiles) +
                '}';
    }
}
