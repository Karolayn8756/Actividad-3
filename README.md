# CRUD completo de estudiantes en Java con MySQL

Proyecto individual del tema **8.4: CRUD completo en Java con MySQL**, correspondiente a la asignatura **Desarrollo de Sistemas de Información**.

## Autora

Karolayn Paola Buñay Pérez  
Pontificia Universidad Católica del Ecuador, Sede Manabí

## Descripción

Este proyecto demuestra cómo una aplicación Java puede conectarse a MySQL mediante JDBC para realizar las operaciones básicas de un CRUD:

- **Create:** registrar estudiantes.
- **Read:** consultar estudiantes.
- **Update:** actualizar carrera y semestre.
- **Delete:** eliminar estudiantes por ID.

El sistema trabaja con la base de datos `universidad_java` y la tabla `estudiantes`.

## Tecnologías utilizadas

- Java 17
- Maven
- MySQL
- JDBC
- MySQL Connector/J

## Estructura del repositorio

```text
CRUD_Estudiantes_Java_MySQL_Completo/
├── README.md
├── pom.xml
├── .gitignore
├── database/
│   └── universidad_java.sql
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── puce/
│                   └── crud/
│                       ├── ConexionBD.java
│                       ├── Estudiante.java
│                       ├── EstudianteDAO.java
│                       └── Main.java
├── docs/
│   ├── Documento_Teorico_CRUD_Java_MySQL.pdf
│   ├── Diapositivas_CRUD_Java_MySQL.pdf
│   ├── Diapositivas_CRUD_Java_MySQL.pptx
│   └── Guia_Ejercicio_CRUD_Estudiantes.pdf
└── evidencias/
    └── README.md
```

## Requisitos previos

Antes de ejecutar el proyecto debe tener instalado:

1. Java JDK 17 o superior.
2. Maven.
3. MySQL, XAMPP o MySQL Workbench.
4. Un editor como Visual Studio Code, IntelliJ IDEA o NetBeans.

## Preparar la base de datos

1. Inicie MySQL.
2. Abra MySQL Workbench, phpMyAdmin o la consola de MySQL.
3. Ejecute el archivo:

```text
database/universidad_java.sql
```

Este script crea la base de datos `universidad_java`, la tabla `estudiantes` y algunos registros de ejemplo.

## Configuración de conexión

La conexión se encuentra en:

```text
src/main/java/com/puce/crud/ConexionBD.java
```

Configuración actual:

```java
private static final String URL = "jdbc:mysql://localhost:3306/universidad_java?useSSL=false&serverTimezone=UTC";
private static final String USUARIO = "root";
private static final String CONTRASENA = "";
```

Si su MySQL tiene contraseña, debe colocarla en `CONTRASENA`.

## Ejecutar el proyecto

Desde la carpeta principal del proyecto, ejecute:

```bash
mvn clean compile
mvn exec:java
```

También puede abrir el proyecto en un IDE y ejecutar la clase:

```text
com.puce.crud.Main
```

## Funcionamiento del programa

Al ejecutar el programa aparece un menú en consola:

```text
1. Registrar estudiante
2. Listar estudiantes
3. Buscar estudiante por nombre
4. Actualizar carrera y semestre
5. Eliminar estudiante
0. Salir
```

## Buenas prácticas aplicadas

- Uso de `PreparedStatement` para evitar concatenar datos directamente en SQL.
- Uso de `try-with-resources` para cerrar conexiones y consultas automáticamente.
- Manejo de errores con `SQLException`.
- Separación de responsabilidades en varias clases.
- Validación básica de nombre, carrera, semestre e ID.

## Entregables incluidos

- Documento teórico en PDF.
- Código fuente completo y funcional.
- Script SQL de la base de datos.
- Diapositivas en PDF y PPTX.
- Guía del ejercicio individual para la clase.
- Carpeta para evidencias de ejecución.
