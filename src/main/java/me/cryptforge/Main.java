package me.cryptforge;

import me.cryptforge.render.TextRenderer;
import org.fusesource.jansi.AnsiConsole;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AnsiConsole.systemInstall();
        final Scanner scanner = new Scanner(System.in);

        Game game = new Game(64, new TextRenderer(), new Player(Color.RED), new Player(Color.GREEN));

        System.out.println("Game started. Press enter to go to the next turn.");
        while (!game.isDone()) {
            scanner.nextLine();
            game.gameLoop();
        }
    }

}