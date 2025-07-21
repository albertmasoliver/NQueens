package org.acme.nqueens.common;


import org.optaplanner.core.api.domain.lookup.PlanningId;

public abstract class AbstractPersistable {
    
    protected int id;

    protected AbstractPersistable() {
    }

    protected AbstractPersistable(int id) {
        this.id = id;
    }

    @PlanningId
    public int getId() {
        return id;
    }

    protected void setId(int id){
        this.id = id;
    }

    @Override
    public String toString(){
        return getClass().getName().replaceAll(".*\\.","") + "-" + id;
    }
}