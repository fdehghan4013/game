package com.github.fdehghan4013;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ColumnTest { 
    private Column testColumnObj = new Column();

    @BeforeEach
    void refresh() {
        testColumnObj = new Column();
    }

    @Test
    void putDiscInRow(){
        testColumnObj.putDiscInRow(Piece.RED);
        testColumnObj.putDiscInRow(Piece.RED);

        int freeSpace = 0;
        for (Piece row : testColumnObj.getRows()) {
            if (row == null) freeSpace += 1;
        }

        assertEquals(freeSpace, 4);
    }

    @Test
    void testGetRows(){
        assertEquals(testColumnObj.getRows().length, 6);

        testColumnObj.putDiscInRow(Piece.RED);

        assertEquals(testColumnObj.getRows()[0], Piece.RED);

        testColumnObj.putDiscInRow(Piece.GREEN);

        assertEquals(testColumnObj.getRows()[1], Piece.GREEN);
    }

    @Test
    void getColumnWinnerTest(){
        testColumnObj.putDiscInRow(Piece.RED);
        testColumnObj.putDiscInRow(Piece.GREEN);
        testColumnObj.putDiscInRow(Piece.GREEN);
        testColumnObj.putDiscInRow(Piece.GREEN);

        Winner columnWinner = testColumnObj.getColumnWinner();

        assertNotNull(columnWinner);
        assertEquals(columnWinner.getWinnerPiece(), Piece.GREEN);
        assertEquals(columnWinner.getStartingRow(), 1);
        assertEquals(columnWinner.getEndingRow(), 3);
    }

    @Test
    void getStatusTest(){
        testColumnObj.putDiscInRow(Piece.RED);
        testColumnObj.putDiscInRow(Piece.GREEN);
        testColumnObj.putDiscInRow(Piece.GREEN);

        assertEquals(testColumnObj.getStatus(), " | | |G|G|R|");
    }

    @Test
    void isFullTest(){
        assertFalse(testColumnObj.isFull());
        for (int i = 0; i < 7; i++) {
            testColumnObj.putDiscInRow(Piece.GREEN);
        }
        assertTrue(testColumnObj.isFull());
    }
}
