package com.github.fdehghan4013;

public class Board {
    private       Piece    turn       = Piece.RED;
    private final int      ColumnSize = 7;
    private final Column[] columns    = new Column[ColumnSize];

    public Board() {
        for (int i = 0; i < ColumnSize; i++) {
            columns[i] = new Column();
        }
    }

    public void putDiscInColumn(int columnIndex) {
        columns[columnIndex].putDiscInRow(turn);

        changeTurn();

        printStatus();
    }

    public void printTurnText() {
        System.out.printf("this is %s turn%n", (turn.equals(Piece.RED) ? 'R' : 'G'));
    }

    public Winner getWinner() {
        Winner winner = findWinnerInASingleColumn();

        if (winner == null) winner = findWinnerInARow();

        return winner;
    }

    private Winner findWinnerInASingleColumn() {
        Winner winner = null;
        for (int i = 0; i < columns.length; i++) {
            winner = columns[i].getColumnWinner();

            if (winner != null) {
                winner.setStartingColumn(i);
                winner.setEndingColumn(i);
                break;
            }
        }

        return winner;
    }

    private Winner findWinnerInARow() {
        Winner winner = null;

        for (int i = 0; i < 5; i++) {
            Piece[] firstColumnRows  = columns[i].getRows();
            Piece[] secondColumnRows = columns[i + 1].getRows();
            Piece[] thirdColumnRows  = columns[i + 2].getRows();

            for (int j = 0; j < firstColumnRows.length; j++) {
                if (firstColumnRows[j] != null && firstColumnRows[j] == secondColumnRows[j] && secondColumnRows[j] == thirdColumnRows[j]) {
                    winner = new Winner();
                    winner.setWinnerPiece(firstColumnRows[j]);
                    winner.setStartingColumn(i);
                    winner.setEndingColumn(i + 2);
                    winner.setStartingRow(j);
                    winner.setEndingRow(j);
                    break;
                }
            }
        }

        return winner;
    }

    public boolean gameIsOver() {
        boolean allColumnsAreFull = false;
        for (Column column : columns) {
            allColumnsAreFull = column.isFull();

            if (!allColumnsAreFull) break;
        }

        return allColumnsAreFull;
    }

    private void changeTurn() {
        turn = turn.equals(Piece.RED) ? Piece.GREEN : Piece.RED;
    }

    public void printStatus() {
        for (Column column : columns) {
            System.out.println(column.getStatus());
        }
    }
}
