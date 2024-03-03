package biseccion;

public class ejercicio2 {
    
    public static double funcion(double x) {
        return x * x + x * x * x * x - 51;
    }

    // Método de bisección
    public static double biseccion(double a, double b, double tolerance) {
        double c = 0;
        int maxIterations = 10;  // Número máximo de iteraciones
        int iterations = 0;  // Contador de iteraciones

        while (iterations < maxIterations && (b - a) >= tolerance) {
            c = (a + b) / 2;

            if (funcion(c) == 0.0) {
                System.out.println("La raíz es: " + c);
                return c;
            }

            if (funcion(c) * funcion(a) < 0) {
                b = c;
            } else {
                a = c;
            }

            iterations++;
        }
        System.out.println("La raíz aproximada es: " + c);
        return c;
    }

    public static void main(String[] args) {
        double a = -10;
        double b = 10;
        double tolerance = 0.5;  // Tolerancia deseada para la raíz
        biseccion(a, b, tolerance);
    }
}


