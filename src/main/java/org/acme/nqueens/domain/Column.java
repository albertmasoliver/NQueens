package org.acme.nqueens.domain;

import org.acme.nqueens.common.AbstractPersistable;

public class Column extends AbstractPersistable {

    private int index;

    public Column() {
    }

    public Column(int index) {
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
        return "Column-" + index;
    }    
}
