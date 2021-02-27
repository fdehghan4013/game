package com.github.fdehghan4013;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board boardObj;

    @BeforeEach
    void refresh(){
        boardObj = new Board();
    }

    @Test
    void putDiscInColumnGreaterThan7(){
        assertThrows(IndexOutOfBoundsException.class, () -> boardObj.putDiscInColumn(7)); // indexes start from 0
    }

    @Test
    void putDiscInColumnLowerThan1() {
        assertThrows(IndexOutOfBoundsException.class, () -> boardObj.putDiscInColumn(-1)); // indexes start from 0
    }

    @Test
    void gameIsOverTest(){
        assertFalse(boardObj.gameIsOver());
    }

    @Test
    void getWinnerTest(){
        boardObj.putDiscInColumn(0);
        boardObj.putDiscInColumn(1);
        boardObj.putDiscInColumn(0);
        boardObj.putDiscInColumn(1);
        boardObj.putDiscInColumn(0);

        assertNotNull(boardObj.getWinner());
        assertEquals(boardObj.getWinner().getWinnerPiece(), Piece.RED);
    }

}
