/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpson;

/**
 *
 * @author vanee
 */
public class Simpson {
    // Función a integrar: f(x) = x^2
    public static double function(double x) {
        return x * x + x;
    }

    public static double simpson(double a, double b, int n) {
        if (n == 1) {
            return (function(b) + 4 * function((a + b) / 2) + function(a)) * (b - a) / 6.0;
        } else {
            double h = (b - a) / n;
            double sum1 = 0.0;
            double sum2 = 0.0;
            for (int i = 1; i < n; i += 2) {
                sum1 += function(a + i * h);
            }
            for (int i = 2; i < n; i += 2) {
                sum2 += function(a + i * h);
            }
            return (simpson(a, b, n - 1) + 2 * sum2 + 4 * sum1) * h / 3.0;
        }
    }

    public static void main(String[] args) {
        double a = 1; // Límite inferior
        double b = 3; // Límite superior
        int n = 100; // Subdivisiones

        double result = simpson(a, b, n);
        System.out.println("Resultado usando el método de Simpson: " + result);
    }
}
