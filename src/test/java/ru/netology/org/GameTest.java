package ru.netology.org;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Game game = new Game();

    Player Dasha = new Player(1, "Dasha", 100);
    Player Ilia = new Player(2, "Ilia", 200);
    Player Marina = new Player(3, "Marina", 50);
    Player Mark = new Player(4, "Mark", 250);
    Player Irina = new Player(5, "Irina", 0);
    Player Anton = new Player(6, "Anton", 300);
    Player Katya = new Player(7, "Katya", 300);

    @Test
    public void player1wins() {
        game.register(Dasha);
        game.register(Marina);

        int expected = game.round("Dasha", "Marina");
        int actual = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void player2wins() {
        game.register(Mark);
        game.register(Anton);

        int expected = game.round("Mark", "Anton");
        int actual = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void noOneWins() {
        game.register(Anton);
        game.register(Katya);

        int expected = game.round("Anton", "Katya");
        int actual = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void exception1() {
        game.register(Dasha);
        game.register(Ilia);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("", "Ilia");
        });
    }

    @Test
    public void exception2() {
        game.register(Dasha);
        game.register(Ilia);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Dasha", "");
        });
    }

    @Test
    public void allExceptions() {
        game.register(Dasha);
        game.register(Ilia);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("", "");
        });
    }

    @Test
    public void Finder() {
        game.register(Dasha);
        game.register(Ilia);
        game.register(Marina);
        game.register(Mark);
        game.register(Irina);

        Boolean expected = game.contain(Irina);
        Boolean actual = true;

        Assertions.assertEquals(expected, actual);
    }
}