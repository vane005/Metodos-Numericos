/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reglafalsa;

/**
 *
 * @author vanee
 */
public class ejercicio3 {
    public static double funcion(double x) {
        return x * x - 2 * x * x;
    }
    //método de regla falsa
    public static void regulaFalsi(double a, double b) {
        double c = 0;
        int maxIteraciones = 10;  // Número máximo de iteraciones
        int iteraciones = 0;  // Contador de iteraciones

        while (iteraciones < maxIteraciones && Math.abs(funcion(c)) >= 0.01) {
            c = (a * funcion(b) - b * funcion(a)) / (funcion(b) - funcion(a));

            if (funcion(c) == 0.0) {
                System.out.println("La raíz es: " + c);
                return; 
            }

            if (funcion(c) * funcion(a) < 0) {
                b = c;
            } else {
                a = c;
            }

            iteraciones++;
        }
        System.out.println("La raíz aproximada es: " + c);
    }

    public static void main(String[] args) {
        double a = -10;
        double b = 10;
        regulaFalsi(a, b);
    }
}
