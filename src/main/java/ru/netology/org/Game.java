package ru.netology.org;

import java.util.HashSet;

public class Game {
    HashSet<Player> players = new HashSet<>();

    public boolean contain(Player player) {
        players.contains(player);
        return true;
    }


    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;

        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }

        if (player1 == null) {
            throw new NotRegisteredException("Player" + playerName1 + "doesn't exist");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player" + playerName2 + "doesn't exist");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
