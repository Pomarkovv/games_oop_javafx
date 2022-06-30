package ru.job4j.chess.firuges.black;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.ImpossibleMoveException;

public class BishopBlackTest {

    @Test
    public void whenPositionIsF8() {
        BishopBlack bb = new BishopBlack(Cell.F8);
        assertThat(bb.position(), is(Cell.findBy(5, 0)));
    }

    @Test
    public void whenDestInCopyIsA3() {
        BishopBlack bb = new BishopBlack(Cell.F8);
        assertThat(bb.copy(Cell.A3).position(), is(Cell.findBy(0, 5)));
    }

    @Test
    public void whenWayIsSuccessful() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] cell = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] result = bb.way(Cell.G5);
        assertThat(cell, is(result));
    }

    @Test (expected =  ImpossibleMoveException.class)
    public void whenWayIsNotOnDiagonal() throws ImpossibleMoveException {
        BishopBlack bb = new BishopBlack(Cell.C1);
        bb.way(Cell.C3);
    }

}