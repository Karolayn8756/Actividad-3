-- =====================================================
-- Base de datos: universidad_java
-- Autora: Karolayn Paola Buñay Pérez
-- Tema: CRUD completo en Java con MySQL
-- Asignatura: Desarrollo de Sistemas de Información
-- Descripción: Script para crear y poblar la tabla estudiantes
-- =====================================================

CREATE DATABASE IF NOT EXISTS universidad_java
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE universidad_java;

CREATE TABLE IF NOT EXISTS estudiantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    carrera VARCHAR(100) NOT NULL,
    semestre INT NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO estudiantes (nombre, carrera, semestre) VALUES
('Karolayn Buñay', 'Software', 2),
('Eduardo Mendoza', 'Software', 2),
('Emilia Pérez', 'Diseño Gráfico', 4),
('Valentina Zambrano', 'Ingeniería de Software', 3),
('Carlos Cedeño', 'Sistemas de Información', 5);

SELECT id, nombre, carrera, semestre, fecha_registro
FROM estudiantes;
