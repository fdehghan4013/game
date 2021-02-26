package com.github.fdehghan4013;

public class Column {
    private final Piece[] rows = new Piece[6];

    public void putDiscInRow(Piece piece) {
        int firstEmptyIndex = findFirstEmptyIndex();

        if (isFull()) throw new IndexOutOfBoundsException("there is no empty cells left");

        rows[firstEmptyIndex] = piece;
    }

    public Piece[] getRows() {
        return rows;
    }

    public Winner getColumnWinner() {
        Winner winner = null;

        for (int i = 0; i < 4; i++) {
            Piece first  = rows[i];
            Piece second = rows[i + 1];
            Piece third  = rows[i + 2];

            if (first != null && first.equals(second) && second.equals(third)) {
                winner = new Winner();
                winner.setWinnerPiece(first);
                winner.setStartingRow(i);
                winner.setEndingRow(i + 2);
                break;
            }
        }

        return winner;
    }

    public String getStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Piece row : rows) {
            if (row == null) stringBuilder.append(" ");
            else stringBuilder.append(row.equals(Piece.RED) ? "R" : "G");

            stringBuilder.append("|");
        }

        return stringBuilder.toString();
    }

    public boolean isFull() {
        return findFirstEmptyIndex() == -1;
    }

    private int findFirstEmptyIndex() {
        int emptyIndex = -1;

        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == null) {
                emptyIndex = i;
                break;
            }
        }

        return emptyIndex;
    }
}
