package org.acme.nqueens.solver;

import org.acme.nqueens.domain.Queen;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;

public class NQueensConstraintProvider implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory factory) {
        return new Constraint[] {
            columnConflict(factory),
            diagonalConflict(factory)
        };
    }

    private Constraint columnConflict(ConstraintFactory factory) {
        // No two queens in the same column
        return factory.forEachUniquePair(Queen.class,
                org.optaplanner.core.api.score.stream.Joiners.equal(Queen::getColumn))
                .penalize("Column conflict", HardSoftScore.ONE_HARD);
    }

    private Constraint diagonalConflict(ConstraintFactory factory) {
        // No two queens on the same diagonal
        return factory.forEachUniquePair(Queen.class,
                org.optaplanner.core.api.score.stream.Joiners.filtering(
                    (queen1, queen2) -> Math.abs(queen1.getRow() - queen2.getRow()) == Math.abs(queen1.getColumn() - queen2.getColumn())
                ))
                .penalize("Diagonal conflict", HardSoftScore.ONE_HARD);
    }
} 