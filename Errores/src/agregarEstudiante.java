// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.Scanner;

public class agregarEstudiante {
    private ArrayList<Estudiante> estudiantes;

    public agregarEstudiante() {
        estudiantes = new ArrayList<Estudiante>();
    }

    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void imprimirPromedios() {
        System.out.println("Promedios de estudiantes:");
        for (Estudiante estudiante : estudiantes) {
            double promedio = estudiante.calcularPromedio();
            System.out.println(estudiante.getNombre() + " " + estudiante.getApellido() + ": " + promedio);
        }
    }

}



