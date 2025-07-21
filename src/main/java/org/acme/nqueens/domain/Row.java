package org.acme.nqueens.domain;

import org.acme.nqueens.common.AbstractPersistable;

public class Row extends AbstractPersistable{

    private int index;

    public Row() {
    }

    public Row(int index) {
        super(index);
        this.index = index;
    }

    public int getIndex(){
        return index;
    }

    public void setIndex(int index){
        this.index = index;
    }

    @Override
    public String toString(){
        return "Row-" + index;
    }    
}
