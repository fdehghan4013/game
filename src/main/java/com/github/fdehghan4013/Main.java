package com.github.fdehghan4013;

import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    private final static Logger LOGGER =  LogManager.getLogger();

    public static void main(String[] args)  {
        LOGGER.info("Start my APP");

        System.out.println("Hello everyone, welcome to our little game");

        Board   board      = new Board();
        Scanner in         = new Scanner(System.in);
        boolean gameIsOver = false;
        Winner  winner     = null;
        int     round      = 1;

        while (!gameIsOver && winner == null) {
            System.out.printf("this is round %d%n", round);

            board.printStatus();

            board.printTurnText();

            System.out.println("please enter a number between 0 to 6:");

            int selectedColumn = in.nextInt();

            try {
                board.putDiscInColumn(selectedColumn);
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("you put a wrong number, please press any key to continue: ");
                in.next();
                continue;
            }

            gameIsOver = board.gameIsOver();
            winner     = board.getWinner();

            round += 1;

            System.out.println("---------------------------------------------");
        }

        board.printStatus();

        if (winner != null) {
            System.out.println("wow, we have a winner and the winner is:");
            System.out.println(winner.toString());
        } else {
            System.out.println("looks like this is a tie, GAME IS OVER.");
        }

        System.out.println("thank you for playing our game");
    }
}
