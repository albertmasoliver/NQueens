package org.acme.nqueens;

import org.acme.nqueens.domain.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class NQueensTest {

    @Test
    void testCreateNQueensInstance() {
        int n = 4;
        List<Column> columns = new ArrayList<>();
        List<Row> rows = new ArrayList<>();
        List<Queen> queens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            columns.add(new Column(i));
            rows.add(new Row(i));
            queens.add(new Queen(i, columns.get(i), rows.get(i)));
        }
        NQueens nQueens = new NQueens(1);
        nQueens.setN(n);
        nQueens.setColumnList(columns);
        nQueens.setRowList(rows);
        nQueens.setQueenList(queens);
        assertEquals(n, nQueens.getQueenList().size());
        assertEquals(n, nQueens.getColumnList().size());
        assertEquals(n, nQueens.getRowList().size());
    }

    @Test
    void testQueenRowAndColumnIndex() {
        Column col = new Column(2);
        Row row = new Row(3);
        Queen queen = new Queen(1, col, row);
        assertEquals(2, queen.getColumnIndex());
        assertEquals(3, queen.getRowIndex());
        assertEquals(5, queen.getAscendingDiagonalIndex());
        assertEquals(-1, queen.getDescendingDiagonalIndex());
    }

    @Test
    void testQueensOnSameRowOrColumn() {
        Column col1 = new Column(0);
        Column col2 = new Column(0);
        Row row1 = new Row(1);
        Row row2 = new Row(2);
        Queen q1 = new Queen(1, col1, row1);
        Queen q2 = new Queen(2, col2, row2);
        // Same column
        assertEquals(q1.getColumnIndex(), q2.getColumnIndex());
        // Different row
        assertNotEquals(q1.getRowIndex(), q2.getRowIndex());
    }

    @Test
    void testQueensOnSameDiagonal() {
        Queen q1 = new Queen(1, new Column(1), new Row(1));
        Queen q2 = new Queen(2, new Column(0), new Row(2));
        // Same ascending diagonal
        assertEquals(q1.getAscendingDiagonalIndex(), q2.getAscendingDiagonalIndex());
        // Same descending diagonal
        Queen q3 = new Queen(3, new Column(3), new Row(1)); // 3-1=2
        Queen q4 = new Queen(4, new Column(4), new Row(2)); // 4-2=2
        assertEquals(q3.getDescendingDiagonalIndex(), q4.getDescendingDiagonalIndex());
    }

    // Integration test with OptaPlanner would go here (if solver and constraints are available)
} 