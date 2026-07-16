package com.puce.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO significa Data Access Object.
 * Esta clase contiene las operaciones CRUD de la tabla estudiantes.
 */
public class EstudianteDAO {

    /**
     * CREATE: registra un estudiante en MySQL.
     */
    public boolean insertar(Estudiante estudiante) {
        if (!validarEstudiante(estudiante)) {
            return false;
        }

        String sql = "INSERT INTO estudiantes (nombre, carrera, semestre) VALUES (?, ?, ?)";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getCarrera());
            ps.setInt(3, estudiante.getSemestre());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar estudiante: " + e.getMessage());
            return false;
        }
    }

    /**
     * READ: consulta todos los estudiantes registrados.
     */
    public List<Estudiante> listarTodos() {
        List<Estudiante> estudiantes = new ArrayList<>();

        String sql = "SELECT id, nombre, carrera, semestre FROM estudiantes ORDER BY id";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                estudiantes.add(mapearEstudiante(rs));
            }

        } catch (SQLException e) {
            System.out.println("Error al listar estudiantes: " + e.getMessage());
        }

        return estudiantes;
    }

    /**
     * READ: busca estudiantes por una parte del nombre.
     */
    public List<Estudiante> buscarPorNombre(String nombreBuscado) {
        List<Estudiante> estudiantes = new ArrayList<>();

        if (nombreBuscado == null || nombreBuscado.trim().isEmpty()) {
            System.out.println("Debe ingresar un nombre para buscar.");
            return estudiantes;
        }

        String sql = "SELECT id, nombre, carrera, semestre FROM estudiantes WHERE nombre LIKE ? ORDER BY id";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, "%" + nombreBuscado.trim() + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    estudiantes.add(mapearEstudiante(rs));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar estudiante: " + e.getMessage());
        }

        return estudiantes;
    }

    /**
     * UPDATE: actualiza la carrera y el semestre de un estudiante por ID.
     */
    public boolean actualizar(int id, String nuevaCarrera, int nuevoSemestre) {
        if (id <= 0) {
            System.out.println("El ID debe ser mayor que cero.");
            return false;
        }
        if (nuevaCarrera == null || nuevaCarrera.trim().isEmpty()) {
            System.out.println("La carrera no puede estar vacía.");
            return false;
        }
        if (nuevoSemestre <= 0) {
            System.out.println("El semestre debe ser mayor que cero.");
            return false;
        }

        String sql = "UPDATE estudiantes SET carrera = ?, semestre = ? WHERE id = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nuevaCarrera.trim());
            ps.setInt(2, nuevoSemestre);
            ps.setInt(3, id);

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar estudiante: " + e.getMessage());
            return false;
        }
    }

    /**
     * DELETE: elimina un estudiante por ID.
     */
    public boolean eliminar(int id) {
        if (id <= 0) {
            System.out.println("El ID debe ser mayor que cero.");
            return false;
        }

        String sql = "DELETE FROM estudiantes WHERE id = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar estudiante: " + e.getMessage());
            return false;
        }
    }

    /**
     * Convierte una fila del ResultSet en un objeto Estudiante.
     */
    private Estudiante mapearEstudiante(ResultSet rs) throws SQLException {
        return new Estudiante(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("carrera"),
                rs.getInt("semestre")
        );
    }

    /**
     * Valida los datos antes de guardar.
     */
    private boolean validarEstudiante(Estudiante estudiante) {
        if (estudiante == null) {
            System.out.println("El estudiante no puede ser nulo.");
            return false;
        }
        if (estudiante.getNombre() == null || estudiante.getNombre().trim().isEmpty()) {
            System.out.println("El nombre es obligatorio.");
            return false;
        }
        if (estudiante.getCarrera() == null || estudiante.getCarrera().trim().isEmpty()) {
            System.out.println("La carrera es obligatoria.");
            return false;
        }
        if (estudiante.getSemestre() <= 0) {
            System.out.println("El semestre debe ser mayor que cero.");
            return false;
        }
        return true;
    }
}
