/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secante;

import java.util.function.Function;

/**
 *
 * @author vanee
 */
public class ejercicio3 {
    public static void main(String[] args) {
        Function<Double, Double> function = x -> x * x + 2 * x;
        double x0 = 1.0;
        double x1 = 2.0;
        double tolerance = 1e-6;

        // Máximo número de iteraciones
        int maxIterations = 100;

        // Iteración del método de la secante
        for (int i = 0; i < maxIterations; i++) {
            double f0 = function.apply(x0);
            double f1 = function.apply(x1);
            double x2 = x1 - f1 * (x1 - x0) / (f1 - f0);

            if (Math.abs(x2 - x1) < tolerance) {
                System.out.println("Raíz aproximada: " + x2);
                break;
            }
            x0 = x1;
            x1 = x2;
        }
    }
}
