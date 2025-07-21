# NQueens

N-Queens Solver powered by OptaPlanner: a concise Java example that uses OptaPlanner’s constraint-stream engine to place *N* queens on an *N × N* chessboard with zero conflicts, showcasing incremental score calculation and declarative constraint modelling.

## Project Structure

- `src/main/java/org/acme/nqueens/`
  - `App.java`: Entry point (currently just prints "Hello World!").
  - `domain/`:
    - `NQueens.java`: Solution class, represents the board and the queens.
    - `Queen.java`: Entity representing a queen.
  - `solver/`:
    - `NQueensConstraintProvider.java`: Defines the constraints (columns and diagonals).
    - `NQueensEasyScoreCalculator.java`: Calculates the solution score.
- `pom.xml`: Maven configuration and dependencies file.

## Requirements

- Java 17 or higher
- Maven 3.6+

## Installation and Execution

1. Clone the repository:
   ```bash
   git clone <repo-url>
   cd Nqueens
   ```
2. Build the project:
   ```bash
   mvn clean package
   ```
3. Run the main class (currently just prints "Hello World!"):
   ```bash
   mvn exec:java -Dexec.mainClass="org.acme.nqueens.App"
   ```

> **Note:** The project includes all the logic to solve N-Queens with OptaPlanner, but the main class does not execute the solver. You can extend `App.java` to create and solve an instance of `NQueens` using OptaPlanner.

## How it works

- **Domain:**
  - `NQueens` defines the problem and the list of queens.
  - `Queen` represents each queen and its position.
- **Constraints:**
  - `NQueensConstraintProvider` penalizes queens in the same column or diagonal.
  - `NQueensEasyScoreCalculator` provides an alternative score calculation.

## License

This project is licensed under the Apache License 2.0. See the `LICENSE` file for details.
