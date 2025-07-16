package org.acme.nqueens.domain;

import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactProperty;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import java.util.List;

@PlanningSolution
public class NQueens {
    @ProblemFactProperty
    private int n;

    @PlanningEntityCollectionProperty
    private List<Queen> queenList;

    @PlanningScore
    private HardSoftScore score;

    public NQueens() {}

    public NQueens(int n, List<Queen> queenList) {
        this.n = n;
        this.queenList = queenList;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public List<Queen> getQueenList() {
        return queenList;
    }

    public void setQueenList(List<Queen> queenList) {
        this.queenList = queenList;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }
} 