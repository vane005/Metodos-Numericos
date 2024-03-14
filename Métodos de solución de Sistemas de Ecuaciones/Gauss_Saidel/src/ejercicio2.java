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
    public static void main(String[] args) {
        double[][] matrizCoeficientes = {{5, 4, -1}, {6, 8, 9}, {2, 3, 5}};
        double[] vectorTerminosIndependientes = {8, 3, 14};
        int iteracionesMaximas = 100;
        double tolerancia = 0.0001;

        double[] solucion = resolverMetodoGaussSeidel(matrizCoeficientes, vectorTerminosIndependientes, new double[vectorTerminosIndependientes.length], iteracionesMaximas, tolerancia, 0);

        System.out.println("Solución:");
        for (int i = 0; i < solucion.length; i++) {
            System.out.println("x[" + i + "] = " + solucion[i]);
        }
    }

    public static double[] resolverMetodoGaussSeidel(double[][] matrizCoeficientes, double[] vectorTerminosIndependientes,
                                                     double[] solucionActual, int iteracionesMaximas, double tolerancia, int iteracion) {
        int n = matrizCoeficientes.length;

        double[] nuevaSolucion = new double[n];

        for (int i = 0; i < n; i++) {
            double suma = 0.0;
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    suma += matrizCoeficientes[i][j] * (iteracion == 0 ? 0 : nuevaSolucion[j]);
                }
            }
            nuevaSolucion[i] = (vectorTerminosIndependientes[i] - suma) / matrizCoeficientes[i][i];
        }
        double error = calcularError(nuevaSolucion, solucionActual);
        if (error < tolerancia || iteracion >= iteracionesMaximas) {
            return nuevaSolucion;
        }
        return resolverMetodoGaussSeidel(matrizCoeficientes, vectorTerminosIndependientes, nuevaSolucion, iteracionesMaximas, tolerancia, iteracion + 1);
    }

    private static double calcularError(double[] solucionActual, double[] solucionAnterior) {
        double maxError = 0.0;
        for (int i = 0; i < solucionActual.length; i++) {
            double error = Math.abs(solucionActual[i] - solucionAnterior[i]);
            if (error > maxError) {
                maxError = error;
            }
        }
        return maxError;
    }
}
