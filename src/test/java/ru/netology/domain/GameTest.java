package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GameTest {

    Game game = new Game();

    Player player1 = new Player(25, "Petya41", 700);
    Player player2 = new Player(29, "Pokemon", 930);
    Player player3 = new Player(47, "Olya21", 100);
    Player player4 = new Player(12, "Anya75", 100);
    Player player5 = new Player(5, "Nik", 330);

    @Test
    public void shouldShowErrorMsgForTheFirstPlayer() {

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player4.name, player3.name);
        });
    }

    @Test
    public void shouldShowErrorMsgForTheSecondPlayer() {

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.name, player3.name);
        });
    }

    @Test
    public void shouldFindAWinner() {

        game.register(player1);
        game.register(player4);

        int actual = game.round(player1.name, player4.name);
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAWinnerElse() {

        game.register(player5);
        game.register(player2);

        int actual = game.round(player5.name, player2.name);
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAWinnerWithTheSameStrength() {

        game.register(player3);
        game.register(player4);

        int actual = game.round(player3.name, player4.name);
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }
}
