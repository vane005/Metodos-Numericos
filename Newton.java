/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newton;

/**
 *
 * @author vanee
 */
public class Newton {

   public static double funcion(double x) {
        return x * x * x - x * x + 2;
    }

    // Definimos la derivada de la función
    public static double derivada(double x) {
        return 3 * x * x - 2 * x;
    }

    //método de Newton
    public static void newton(double x0) {
        double x = x0;
        double epsilon = 0.0001; 
        int maxIteraciones = 10; // Número máximo de iteraciones

        for (int i = 0; i < maxIteraciones; i++) {
            double f = funcion(x);
            double df = derivada(x);
            x = x - f / df;

            if (Math.abs(f) < epsilon) {
                System.out.println("La raíz es: " + x);
                break;
            }
        }
    }

    public static void main(String[] args) {
        double x0 = 1.0; 
        newton(x0);
    }
    
}
