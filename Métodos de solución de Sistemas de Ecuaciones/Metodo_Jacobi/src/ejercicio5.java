/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vanee
 */
public class ejercicio5 {
    static double[][] coefficients = {
        {9, 5, 2},
        {5, 6, 3},
        {6, 7, 9}
    };
    
    // Vector de términos independientes
    static double[] constants = {7, -8, 6};
    static double[] initialGuess = {0, 0, 0};
    static double tolerance = 0.0001;

    static int maxIterations = 10;
    static double[] jacobi(double[] previousIteration, int iteration) {
        double[] currentIteration = new double[previousIteration.length];
        for (int i = 0; i < coefficients.length; i++) {
            double sum = constants[i];
            for (int j = 0; j < coefficients[i].length; j++) {
                if (j != i) {
                    sum -= coefficients[i][j] * previousIteration[j];
                }
            }
            currentIteration[i] = sum / coefficients[i][i];
        }
        double maxDiff = 0;
        for (int i = 0; i < currentIteration.length; i++) {
            double diff = Math.abs(currentIteration[i] - previousIteration[i]);
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        if (maxDiff > tolerance && iteration < maxIterations) {
            return jacobi(currentIteration, iteration + 1);
        } else {
            return currentIteration;
        }
    }
    
    public static void main(String[] args) {
        double[] solution = jacobi(initialGuess, 0);
        System.out.println("Solución:");
        for (int i = 0; i < solution.length; i++) {
            System.out.println("x[" + i + "] = " + solution[i]);
        }
    }
}
