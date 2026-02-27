package modularizacion;
import java.util.Scanner;

public class modularizacion {
    
    // Scanner global
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        
        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción (1-11): ");
            
            switch (opcion) {
                case 1: calculadora(); break;
                case 2: validarContrasena(); break;
                case 3: verificarPrimo(); break;
                case 4: sumaNumerosPares(); break;
                case 5: conversionTemperatura(); break;
                case 6: contarVocalesPrograma(); break;
                case 7: calcularFactorial(); break;
                case 8: juegoAdivinanza(); break;
                case 9: simulacionPasoReferencia(); break;
                case 10: tablaMultiplicar(); break;
                case 11: System.out.println("¡Saliendo del programa! Hasta pronto."); break;
                default: System.out.println("Opción no válida. Intenta de nuevo."); break;
            }
            System.out.println(); 
        } while (opcion != 11);
        
        scanner.close();
    }

    // Métodos (Validación Try-Catch)
       
    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número entero válido.");
            }
        }
    }

    public static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número válido (usa punto para decimales).");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("========== MENÚ PRINCIPAL ==========");
        System.out.println("1. Calculadora básica");
        System.out.println("2. Validación de contraseña");
        System.out.println("3. Números primos");
        System.out.println("4. Suma de números pares");
        System.out.println("5. Conversión de temperatura");
        System.out.println("6. Contador de vocales");
        System.out.println("7. Cálculo de factorial");
        System.out.println("8. Juego de adivinanza");
        System.out.println("9. Paso por referencia");
        System.out.println("10. Tabla de multiplicar");
        System.out.println("11. Salir");
        System.out.println("====================================");
    }
    
    // 1Calculadora básica
    public static void calculadora() {
        System.out.println("--- Calculadora Básica ---");
        double num1 = leerDouble("Ingresa el primer número: ");
        double num2 = leerDouble("Ingresa el segundo número: ");
        
        System.out.println("Operaciones: 1.Suma | 2.Resta | 3.Multiplicación | 4.División");
        int opc = leerEntero("Elige operación: ");
        
        switch (opc) {
            case 1: System.out.println("Resultado: " + sumar(num1, num2)); break;
            case 2: System.out.println("Resultado: " + restar(num1, num2)); break;
            case 3: System.out.println("Resultado: " + multiplicar(num1, num2)); break;
            case 4: 
                if (num2 == 0) {
                    System.out.println("Error: No se puede dividir entre cero.");
                } else {
                    System.out.println("Resultado: " + dividir(num1, num2));
                }
                break;
            default: System.out.println("Operación no válida."); break;
        }
    }
    public static double sumar(double a, double b) { return a + b; }
    public static double restar(double a, double b) { return a - b; }
    public static double multiplicar(double a, double b) { return a * b; }
    public static double dividir(double a, double b) { return a / b; }

    // Validación de contraseña
    public static void validarContrasena() {
        String pass;
        System.out.println("--- Validación de Contraseña ---");
        do {
            System.out.print("Ingresa la contraseña: ");
            pass = scanner.nextLine();
            if (!pass.equals("1234")) {
                System.out.println("Contraseña incorrecta. Intenta nuevamente.");
            }
        } while (!pass.equals("1234"));
        System.out.println("Acceso concedido.");
    }

    // Números primos
    public static void verificarPrimo() {
        System.out.println("--- Número Primo ---");
        int num = leerEntero("Ingresa un número entero positivo: ");
        if (esPrimo(num)) {
            System.out.println("El número " + num + " SÍ es primo.");
        } else {
            System.out.println("El número " + num + " NO es primo.");
        }
    }
    public static boolean esPrimo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Suma de números pares
    public static void sumaNumerosPares() {
        System.out.println("--- Suma de Pares ---");
        int suma = 0;
        int num = leerEntero("Ingresa un número (0 para salir y sumar): ");
        
        // Uso de ciclo while 
        while (num != 0) {
            if (num % 2 == 0) {
                suma += num;
            }
            num = leerEntero("Ingresa un número (0 para salir y sumar): ");
        }
        System.out.println("La suma de todos los números pares ingresados es: " + suma);
    }

    // Conversión de temperatura
    public static void conversionTemperatura() {
        System.out.println("--- Conversión de Temperatura ---");
        System.out.println("1. Celsius a Fahrenheit");
        System.out.println("2. Fahrenheit a Celsius");
        int opc = leerEntero("Elige una opción (1 o 2): ");
        
        if (opc == 1) {
            double c = leerDouble("Ingresa grados Celsius: ");
            System.out.println(c + "°C equivale a " + celsiusAFahrenheit(c) + "°F");
        } else if (opc == 2) {
            double f = leerDouble("Ingresa grados Fahrenheit: ");
            System.out.println(f + "°F equivale a " + fahrenheitACelsius(f) + "°C");
        } else {
            System.out.println("Opción no válida.");
        }
    }
    public static double celsiusAFahrenheit(double c) { return (c * 9/5) + 32; }
    public static double fahrenheitACelsius(double f) { return (f - 32) * 5/9; }

    // Contador de vocales
    public static void contarVocalesPrograma() {
        System.out.println("--- Contador de Vocales ---");
        System.out.print("Ingresa una palabra o frase: ");
        String texto = scanner.nextLine();
        int cantidad = contarVocales(texto);
        System.out.println("La frase contiene " + cantidad + " vocales.");
    }
    public static int contarVocales(String texto) {
        int contador = 0;
        String t = texto.toLowerCase();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
                contador++;
            }
        }
        return contador;
    }

    // Cálculo de factorial
    public static void calcularFactorial() {
        System.out.println("--- Cálculo de Factorial ---");
        int num;
        do {
            num = leerEntero("Ingresa un número entero positivo: ");
            if (num < 0) System.out.println("Error: El número no puede ser negativo.");
        } while (num < 0);
        
        System.out.println("El factorial de " + num + " es: " + factorial(num));
    }
    public static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Juego de adivinanza
    public static void juegoAdivinanza() {
        System.out.println("--- Juego de Adivinanza ---");
        int numeroSecreto = (int)(Math.random() * 100) + 1;
        int intento;
        int contador = 0;
        
        System.out.println("He pensado un número entre 1 y 100. ¡Adivínalo!");
        do {
            intento = leerEntero("Tu intento: ");
            contador++;
            if (intento < numeroSecreto) {
                System.out.println("Más alto...");
            } else if (intento > numeroSecreto) {
                System.out.println("Más bajo...");
            }
        } while (intento != numeroSecreto);
        
        System.out.println("Correcto! Adivinaste el número en " + contador + " intentos.");
    }

    // Paso por referencia
    
    // Objeto auxiliar para simular el paso por referencia en Java
    static class Variable {
        int valor;
        public Variable(int valor) { this.valor = valor; }
    }

    public static void simulacionPasoReferencia() {
        System.out.println("--- Simulación: Paso por Referencia ---");
        System.out.println("Nota: Java es 'Paso por Valor', usamos un Objeto para simular la referencia.");
        
        Variable a = new Variable(10);
        Variable b = new Variable(99);
        
        System.out.println("ANTES del intercambio: A = " + a.valor + ", B = " + b.valor);
        intercambiar(a, b);
        System.out.println("DESPUÉS del intercambio: A = " + a.valor + ", B = " + b.valor);
    }
    
    public static void intercambiar(Variable v1, Variable v2) {
        int temp = v1.valor;
        v1.valor = v2.valor;
        v2.valor = temp;
    }

    // Tabla de multiplicar
    public static void tablaMultiplicar() {
        System.out.println("--- Tabla de Multiplicar ---");
        int num = leerEntero("Ingresa el número de la tabla que deseas ver: ");
        generarTabla(num);
    }
    public static void generarTabla(int n) {
        System.out.println("Tabla del " + n + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }
}