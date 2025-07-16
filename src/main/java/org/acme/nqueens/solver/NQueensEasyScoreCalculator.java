package org.acme.nqueens.solver;

import org.acme.nqueens.domain.NQueens;
import org.acme.nqueens.domain.Queen;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.calculator.EasyScoreCalculator;
import java.util.List;

public class NQueensEasyScoreCalculator implements EasyScoreCalculator<NQueens, HardSoftScore> {
    @Override
    public HardSoftScore calculateScore(NQueens nQueens) {
        int hardScore = 0;
        List<Queen> queenList = nQueens.getQueenList();
        for (int i = 0; i < queenList.size(); i++) {
            Queen a = queenList.get(i);
            if (a.getColumn() == null) continue;
            for (int j = i + 1; j < queenList.size(); j++) {
                Queen b = queenList.get(j);
                if (b.getColumn() == null) continue;
                if (a.getColumn().equals(b.getColumn())) {
                    hardScore--;
                }
                if (Math.abs(a.getRow() - b.getRow()) == Math.abs(a.getColumn() - b.getColumn())) {
                    hardScore--;
                }
            }
        }
        return HardSoftScore.of(hardScore, 0);
    }
} 