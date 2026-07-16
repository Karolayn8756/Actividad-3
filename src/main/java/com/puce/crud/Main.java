package com.puce.crud;

import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que muestra un menú en consola para probar el CRUD.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final EstudianteDAO dao = new EstudianteDAO();

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println(" CRUD COMPLETO DE ESTUDIANTES - JAVA MYSQL ");
        System.out.println("============================================");

        if (!ConexionBD.probarConexion()) {
            System.out.println("No se pudo conectar con MySQL.");
            System.out.println("Revise que MySQL esté activo y que exista la base universidad_java.");
            return;
        }

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> registrarEstudiante();
                case 2 -> listarEstudiantes();
                case 3 -> buscarEstudiante();
                case 4 -> actualizarEstudiante();
                case 5 -> eliminarEstudiante();
                case 0 -> System.out.println("Programa finalizado.");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ CRUD ---");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Listar estudiantes");
        System.out.println("3. Buscar estudiante por nombre");
        System.out.println("4. Actualizar carrera y semestre");
        System.out.println("5. Eliminar estudiante");
        System.out.println("0. Salir");
    }

    private static void registrarEstudiante() {
        System.out.println("\n--- REGISTRAR ESTUDIANTE ---");
        String nombre = leerTexto("Nombre: ");
        String carrera = leerTexto("Carrera: ");
        int semestre = leerEntero("Semestre: ");

        Estudiante estudiante = new Estudiante(nombre, carrera, semestre);
        boolean insertado = dao.insertar(estudiante);

        if (insertado) {
            System.out.println("Estudiante registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el estudiante.");
        }
    }

    private static void listarEstudiantes() {
        System.out.println("\n--- LISTA DE ESTUDIANTES ---");
        List<Estudiante> estudiantes = dao.listarTodos();
        imprimirLista(estudiantes);
    }

    private static void buscarEstudiante() {
        System.out.println("\n--- BUSCAR ESTUDIANTE ---");
        String nombre = leerTexto("Ingrese parte del nombre: ");
        List<Estudiante> estudiantes = dao.buscarPorNombre(nombre);
        imprimirLista(estudiantes);
    }

    private static void actualizarEstudiante() {
        System.out.println("\n--- ACTUALIZAR ESTUDIANTE ---");
        int id = leerEntero("ID del estudiante: ");
        String carrera = leerTexto("Nueva carrera: ");
        int semestre = leerEntero("Nuevo semestre: ");

        boolean actualizado = dao.actualizar(id, carrera, semestre);

        if (actualizado) {
            System.out.println("Estudiante actualizado correctamente.");
        } else {
            System.out.println("No se encontró un estudiante con ese ID o los datos no son válidos.");
        }
    }

    private static void eliminarEstudiante() {
        System.out.println("\n--- ELIMINAR ESTUDIANTE ---");
        int id = leerEntero("ID del estudiante a eliminar: ");

        boolean eliminado = dao.eliminar(id);

        if (eliminado) {
            System.out.println("Estudiante eliminado correctamente.");
        } else {
            System.out.println("No se encontró un estudiante con ese ID.");
        }
    }

    private static void imprimirLista(List<Estudiante> estudiantes) {
        if (estudiantes.isEmpty()) {
            System.out.println("No se encontraron registros.");
            return;
        }

        System.out.println("ID | Nombre | Carrera | Semestre");
        System.out.println("---------------------------------------------");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }

    private static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.");
            }
        }
    }
}
