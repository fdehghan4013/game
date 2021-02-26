package com.github.fdehghan4013;

public class Winner {
    private int   startingColumn;
    private int   endingColumn;
    private int   startingRow;
    private int   endingRow;
    private Piece winnerPiece;

    public int getStartingColumn() {
        return startingColumn;
    }

    public void setStartingColumn(int startingColumn) {
        this.startingColumn = startingColumn;
    }

    public int getEndingColumn() {
        return endingColumn;
    }

    public void setEndingColumn(int endingColumn) {
        this.endingColumn = endingColumn;
    }

    public int getStartingRow() {
        return startingRow;
    }

    public void setStartingRow(int startingRow) {
        this.startingRow = startingRow;
    }

    public int getEndingRow() {
        return endingRow;
    }

    public void setEndingRow(int endingRow) {
        this.endingRow = endingRow;
    }

    public Piece getWinnerPiece() {
        return winnerPiece;
    }

    public void setWinnerPiece(Piece winnerPiece) {
        this.winnerPiece = winnerPiece;
    }

    @Override
    public String toString() {
        return "Winner{" +
                "startingColumn=" + startingColumn +
                ", endingColumn=" + endingColumn +
                ", startingRow=" + startingRow +
                ", endingRow=" + endingRow +
                ", winnerPiece=" + winnerPiece +
                '}';
    }
}
