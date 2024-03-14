/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vanee
 */
public class ejercicio2 {
    // Matriz aumentada [A | B]
    static double[][] augmentedMatrix = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    };
    static void gaussianElimination(int row, int col) {
        if (row == augmentedMatrix.length - 1) {
            return;
        }
        if (augmentedMatrix[row][col] == 0) {
            for (int i = row + 1; i < augmentedMatrix.length; i++) {
                if (augmentedMatrix[i][col] != 0) {
                    double[] temp = augmentedMatrix[i];
                    augmentedMatrix[i] = augmentedMatrix[row];
                    augmentedMatrix[row] = temp;
                    break;
                }
            }
        }
        for (int i = row + 1; i < augmentedMatrix.length; i++) {
            double factor = augmentedMatrix[i][col] / augmentedMatrix[row][col];
            for (int j = col; j < augmentedMatrix[row].length; j++) {
                augmentedMatrix[i][j] -= factor * augmentedMatrix[row][j];
            }
        }
        gaussianElimination(row + 1, col + 1);
    }
    
    public static void main(String[] args) {
        gaussianElimination(0, 0);
        System.out.println("Matriz triangular superior:");
        for (int i = 0; i < augmentedMatrix.length; i++) {
            for (int j = 0; j < augmentedMatrix[i].length; j++) {
                System.out.print(augmentedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
