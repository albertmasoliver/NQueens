package org.acme.nqueens.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.acme.nqueens.common.AbstractPersistable;
import org.acme.nqueens.solver.QueenDifficultyWeightFactory;
import org.acme.nqueens.solver.RowStrengthWeightFactory;

@PlanningEntity(difficultyWeightFactoryClass = QueenDifficultyWeightFactory.class)
public class Queen extends AbstractPersistable{
    private Column column;

    private Row row;

    public Queen(){}

    public Queen(int id){
        super(id);
    }

    public Queen(int id, Column column, Row row){
        super(id);
        this.column = column;
        this.row = row;
    }

    public Column getColumn(){
        return column;
    }

    public void setColumn(Column column){
        this.column = column;
    }

    @PlanningVariable(strengthWeightFactoryClass = RowStrengthWeightFactory.class)
    public Row getRow(){
        return row;
    }

    public void setRow(Row row){}

    public int getColumnIndex(){
        return column.getIndex();
    }

    public int getRowIndex(){
        if(row == null){
            return Integer.MIN_VALUE;
        }
        return row.getIndex();
    }

    public int getAscendingDiagonalIndex(){
        return getColumnIndex() + getRowIndex();
    }

    public int getDescendingDiagonalIndex(){
        return getColumnIndex() - getRowIndex();
    }

    @Override
    public String toString(){
        return "Queen-" + column.getIndex();
    }
} 