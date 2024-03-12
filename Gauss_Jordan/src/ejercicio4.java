

public class ejercicio4 {

    public static void main(String[] args) {
        //ejemplo de matriz [A|B]
        double[][] matrizAumentada = {
            {5, 3, 0, 8},
            {1, 5, 4, 1},
            {-8, 7, 5, 10}
        };
        gaussJordan(matrizAumentada);
        mostrarSolucion(matrizAumentada);
    }

    //algoritmo de Gauss-Jordan
    private static void gaussJordan(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        for (int i = 0; i < filas; i++) {
            //elemento de la diagonal sea igual a 1
            double divisor = matriz[i][i];
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] /= divisor;
            }

            //otros elementos en la columna sean cero
            for (int k = 0; k < filas; k++) {
                if (k != i) {
                    double factor = matriz[k][i];
                    for (int j = 0; j < columnas; j++) {
                        matriz[k][j] -= factor * matriz[i][j];
                    }
                }
            }
        }
    }

    private static void mostrarSolucion(double[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        System.out.println("Solución del sistema de ecuaciones:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas - 1; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("= " + matriz[i][columnas - 1]);
        }
    }
}


