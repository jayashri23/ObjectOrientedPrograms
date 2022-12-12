package com.DeckOfCards;

import java.util.Random;

public class PlayerGameUsingQueue {

    MyQueue<Player> playerQueue;
    int[][] arrayCard;

    void start() {
        playerQueue = new MyQueue<Player>();
        arrayCard = new int[4][13];
        for (int i = 0; i < 4; i++) {
            totalAddPlayer();
        }
    }

    void totalAddPlayer() {
        Player player = new Player();
        for (int i = 0; i < 9; i++) {
            shuffleCard(player);
        }
        player.enqueueCards();
        playerQueue.enqueueData(player);
    }

    void shuffleCard(Player player) {
        Random random = new Random();
        int suit = random.nextInt(4);
        int rank = random.nextInt(13);
        if (arrayCard[suit][rank] == 0) {
            player.addCard(suit, rank);
            arrayCard[suit][rank] = 1;
        } else {
            shuffleCard(player);
        }
    }

    void popPlayers() {
        for (int i = 0; i < 4; i++) {
            Player player = playerQueue.dequeueData();
            System.out.println("Player " + (i + 1) + " cards: ");
            printCardPlayers(player);
            System.out.println("_________________________________________________________________________");
            System.out.println();
        }
    }

    void printCardPlayers(Player player) {
        for (int i = 0; i < 9; i++) {

            Card card = player.getCard();
            System.out.print(card.getSuit() + " " + card.getRank());

        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("\n*************************Welcome To Deck Of Cards Game *********************");
        PlayerGameUsingQueue game = new PlayerGameUsingQueue();
        game.start();
        System.out.println("_________________________________________________________________________");
        game.popPlayers();
    }
}
