import java.util.Scanner;

public class App {

    static String nombre = "N/A", estado = "N/A";
    static double nota1 = -1, nota2 = -1, nota3 = -1;
    static double promedio = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    // Registrar datos de un estudiante
                    registrarEstudiante(sc);
                    break;
                case 2:
                    // Mostrar datos del estudiante actual
                    mostrarEstudiante();
                    break;
                case 3:
                    // Calcular promedio de notas
                    calcularPromedio();
                    break;
                case 4:
                    // Mostrar resumen completo del estudiante
                    mostrarEstudiante();
                    System.out
                            .println("Promedio de notas: " + (promedio > 0 ? String.format("%.2f", promedio) : "N/A"));
                    setEstado();
                    break;
                case 5:
                    // Limpiar datos del estudiante actual
                    nombre = "N/A";
                    nota1 = -1;
                    nota2 = -1;
                    nota3 = -1;
                    promedio = 0;
                    estado = "N/A";
                    System.out.println("Datos del estudiante limpiados correctamente.");
                    break;
                case 0:
                    // Salir
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }

    public static void mostrarEstudiante() {
        if (nombre.equals("N/A")) {
            System.out.println();
        } else {
            System.out.println("Nombre del estudiante: " + nombre);
            System.out.println("Nota 1: " + nota1);
            System.out.println("Nota 2: " + nota2);
            System.out.println("Nota 3: " + nota3);
        }
    }

    public static void registrarEstudiante(Scanner sc) {
        System.out.println("Ingrese el nombre del estudiante: ");
        nombre = validarNombre(sc);

        nota1 = leerNota(sc, "Ingrese la nota 1: ");
        nota2 = leerNota(sc, "Ingrese la nota 2: ");
        nota3 = leerNota(sc, "Ingrese la nota 3: ");
        System.out.println("Datos del estudiante registrados correctamente.");
    }

    public static void mostrarMenu() {
        System.out.println("\n--- Menú de Gestión de Estudiantes ---");
        System.out.println("1. Registrar datos de un estudiante");
        System.out.println("2. Mostrar datos del estudiante actual");
        System.out.println("3. Calcular promedio de notas");
        System.out.println("4. Mostrar resumen completo del estudiante");
        System.out.println("5. Limpiar datos del estudiante actual");
        System.out.println("0. Salir");
    }

    public static int leerEntero(Scanner sc, String mensaje) {
        int numero = -1;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                valido = true;
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                sc.next(); // Limpiar entrada no válida
            }
        }
        sc.nextLine(); // Limpiar el buffer
        return numero;
    }

    public static double leerNota(Scanner sc, String mensaje) {
        double numero = -1;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) {
                numero = sc.nextDouble();
                if (numero >= 0 && numero <= 100) {
                    valido = true;
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese una nota entre 0 y 100.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                sc.next(); // Limpiar entrada no válida
            }
        }

        return numero;
    }

    public static void calcularPromedio() {
        if (nombre.equals("N/A")) {
            System.out.println("No hay datos de estudiante registrados.");
        } else {
            promedio = (nota1 + nota2 + nota3) / 3;
            System.out.printf("El promedio de las notas es: %.2f%n", promedio);
        }
    }

    public static void setEstado() {
        estado = promedio >= 60 ? "Aprobado" : "Reprobado";
        System.out.println("Estado: " + estado);
    }

    public static String validarNombre(Scanner sc) {
        String nombreInput = "";
        boolean valido = false;

        while (!valido) {
            nombreInput = sc.nextLine().trim();
            if (!nombreInput.isEmpty()) {
                valido = true;
            } else {
                System.out.println("El nombre no puede estar vacío. Por favor, ingrese un nombre válido:");
            }
        }

        return nombreInput;
    }
}
