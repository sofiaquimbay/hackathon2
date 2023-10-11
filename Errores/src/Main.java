import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        agregarEstudiante universidad = new agregarEstudiante();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingrese el nombre del estudiante (o 'salir' para terminar):");
            String nombre= scanner.nextLine();


            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.println("Ingrese el apellido del estudiante:");
            String apellido = scanner.nextLine();

            Estudiante estudiante = new Estudiante(nombre, apellido);

            boolean continuar = true;
            while (continuar) {
                System.out.println("Ingrese una nota (o -1 para terminar):");
                double nota = scanner.nextDouble();

                if (nota == -1) {
                    continuar = false;
                } else {
                    estudiante.agregarNota(nota);
                }
            }
            universidad.registrarEstudiante(estudiante);
            scanner.nextLine();

        }
        scanner.close();
        universidad.imprimirPromedios();

    }
}

