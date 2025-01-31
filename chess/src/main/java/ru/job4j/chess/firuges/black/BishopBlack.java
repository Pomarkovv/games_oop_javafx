package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(dest.getX()) - Math.abs(position().getX());
        Cell[] steps = new Cell[size];
        int deltaX = Integer.compare(dest.getX(), position.getX());
        int deltaY = Integer.compare(dest.getY(), position.getY());
        int x = position.getX();
        int y = position.getY();
        for (int index = 0; index < size; index++) {
            x = x + deltaX;
            y = y + deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return (Math.abs(source.getY() - dest.getY()) == Math.abs(source.getX() - dest.getX()));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
