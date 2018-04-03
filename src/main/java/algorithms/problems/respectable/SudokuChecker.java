package algorithms.problems.respectable;

/**
 * Sudoku Matrix checker
 *
 * eg.
     {3,1,6,5,7,8,4,9,2},
     {5,2,9,1,3,4,7,6,8},
     {4,8,7,6,2,9,5,3,1},
     {2,6,3,4,1,5,9,8,7},
     {9,7,4,8,6,3,1,2,5},
     {8,5,1,7,9,2,6,4,3},
     {1,3,8,9,4,7,2,5,6},
     {6,9,2,3,5,1,8,7,4},
     {7,4,5,2,8,6,3,1,9}
 *
 *
 */
public class SudokuChecker {

    public static void main(String args[]) {
        int[][] matrix= {
            {3,1,6,5,7,8,4,9,2},
            {5,2,9,1,3,4,7,6,8},
            {4,8,7,6,2,9,5,3,1},
            {2,6,3,4,1,5,9,8,7},
            {9,7,4,8,6,3,1,2,5},
            {8,5,1,7,9,2,6,4,3},
            {1,3,8,9,4,7,2,5,6},
            {6,9,2,3,5,1,8,7,4},
            {7,4,5,2,8,6,3,1,9}
        };

        SudokuChecker sudokuChecker = new SudokuChecker();

        boolean rowsCheck = sudokuChecker.checkRows(matrix);

        boolean columnsCheck = sudokuChecker.checkColumns(matrix);
        boolean subMatricesCheck = sudokuChecker.checkSubMatrices(matrix);

        if(rowsCheck && columnsCheck && subMatricesCheck)
            System.out.println("It is a valid Sudoku matrix.");
        else
            System.out.println("It is an invalid Sudoku matrix.");
    }

    private boolean checkRows(int[][] sodukuMatrix) {
        int n = sodukuMatrix.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(sodukuMatrix[i][Math.abs(sodukuMatrix[i][j])-1] >= 0)
                    sodukuMatrix[i][Math.abs(sodukuMatrix[i][j])-1] *= -1;
                else
                    return false;
            }
            for(int j=0; j<n; j++)
                sodukuMatrix[i][j] = Math.abs(sodukuMatrix[i][j]);
        }
        return true;
    }

    private boolean checkColumns(int[][] sodukuMatrix) {

        int n = sodukuMatrix.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(sodukuMatrix[j][Math.abs(sodukuMatrix[j][i])-1] >= 0)
                    sodukuMatrix[j][Math.abs(sodukuMatrix[j][i])-1] *= -1;
                else
                    return false;
            }
            for(int j=0; j<n; j++)
                sodukuMatrix[j][i] = Math.abs(sodukuMatrix[j][i]);
        }
        return true;
    }

    private boolean checkSubMatrices(int[][] sodukuMatrix) {
        return true;
    }
}
