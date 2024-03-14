/*
 * 
 */

/**
 *
 * @author vanee
 */
public class MetodoJacobi {
    static double[][] coefficients = {
        {10, 2, 1},
        {1, 5, 1},
        {2, 3, 10}
    };
    static double[] constants = {7, -8, 6};
    static double[] initialGuess = {0, 0, 0};
    static double tolerance = 0.0001;
    static int maxIterations = 100;
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
