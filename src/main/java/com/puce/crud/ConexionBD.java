package com.puce.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase responsable únicamente de abrir la conexión con MySQL.
 */
public class ConexionBD {

    // URL de conexión a la base de datos universidad_java.
    private static final String URL = "jdbc:mysql://localhost:3306/universidad_java?useSSL=false&serverTimezone=UTC";

    // Usuario local de MySQL. En XAMPP normalmente es root.
    private static final String USUARIO = "root";

    // Contraseña local. En XAMPP normalmente queda vacía.
    private static final String CONTRASENA = "";

    /**
     * Abre y devuelve una conexión activa con la base de datos.
     */
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }

    /**
     * Verifica si la conexión funciona correctamente.
     */
    public static boolean probarConexion() {
        try (Connection conexion = obtenerConexion()) {
            return conexion != null && !conexion.isClosed();
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            return false;
        }
    }
}
