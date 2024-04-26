/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trapecio;

/**
 *
 * @author vanee
 */
public class Trapecio {
    // Función a integrar: f(x) = x^2
    public static double function(double x) {
        return x * x;
    }

    public static double trapecio(double a, double b, int n) {
        if (n == 1) {
            return (function(b) + function(a)) * (b - a) / 2.0;
        } else {
            double h = (b - a) / n;
            double sum = 0.0;
            for (int i = 1; i < n; i++) {
                sum += function(a + i * h);
            }
            return (trapecio(a, b, n - 1) + 2.0 * sum) * h / 2.0;
        }
    }

    public static void main(String[] args) {
        double a = 1; // Límite inferior
        double b = 3; // Límite superior
        int n = 100; // Subdivisiones

        double result = trapecio(a, b, n);
        System.out.println("Resultado usando el método del trapecio: " + result);
    }
}
