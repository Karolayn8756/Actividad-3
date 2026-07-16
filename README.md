# CRUD de estudiantes en Java con MySQL

Proyecto individual correspondiente al tema **8.4: CRUD completo en Java con MySQL**.

## Información académica

**Autora:** Karolayn Paola Buñay Pérez  
**Institución:** Pontificia Universidad Católica del Ecuador, Sede Manabí  
**Grupo:** Java, JDBC y ORM  
**Tema:** 8.4 - CRUD completo en Java con MySQL

## Descripción del proyecto

Este proyecto presenta una aplicación de consola desarrollada en Java que permite administrar estudiantes almacenados en una base de datos MySQL.

La aplicación utiliza JDBC para establecer la comunicación entre Java y MySQL, y permite ejecutar las cuatro operaciones fundamentales de un CRUD:

| Operación | Acción en el sistema | Instrucción SQL |
|---|---|---|
| Create | Registrar estudiantes | `INSERT` |
| Read | Consultar y buscar estudiantes | `SELECT` |
| Update | Actualizar carrera y semestre | `UPDATE` |
| Delete | Eliminar estudiantes por ID | `DELETE` |

El sistema trabaja con la base de datos `universidad_java` y la tabla `estudiantes`.

## Funcionalidades

La aplicación permite:

- Registrar un estudiante.
- Mostrar todos los estudiantes almacenados.
- Buscar estudiantes por nombre.
- Actualizar la carrera y el semestre de un estudiante.
- Eliminar un estudiante mediante su identificador.
- Validar datos antes de ejecutar una operación.
- Mostrar mensajes de confirmación o error en la consola.

## Tecnologías utilizadas

- Java 17
- Maven
- JDBC
- MySQL
- MySQL Connector/J
- Visual Studio Code, IntelliJ IDEA o NetBeans

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

## Función de las clases principales

| Archivo | Función |
|---|---|
| `ConexionBD.java` | Contiene los datos necesarios para abrir la conexión con MySQL. |
| `Estudiante.java` | Representa la información de un estudiante. |
| `EstudianteDAO.java` | Contiene las operaciones de insertar, consultar, buscar, actualizar y eliminar. |
| `Main.java` | Presenta el menú principal y permite utilizar el sistema desde la consola. |

## Requisitos previos

Antes de ejecutar el proyecto debe tener instalado:

1. Java JDK 17 o superior.
2. Apache Maven.
3. MySQL, XAMPP o MySQL Workbench.
4. Un entorno de desarrollo como Visual Studio Code, IntelliJ IDEA o NetBeans.

Puede comprobar las instalaciones con los siguientes comandos:

```bash
java -version
mvn -version
```

## Preparación de la base de datos

1. Inicie el servicio MySQL.
2. Abra MySQL Workbench, phpMyAdmin o la consola de MySQL.
3. Ejecute el archivo:

```text
database/universidad_java.sql
```

El script crea la base de datos `universidad_java`, la tabla `estudiantes` y los registros iniciales necesarios para probar el sistema.

La tabla utiliza la siguiente estructura:

```sql
CREATE TABLE estudiantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    carrera VARCHAR(100) NOT NULL,
    semestre INT NOT NULL
);
```

## Configuración de la conexión

La configuración se encuentra en:

```text
src/main/java/com/puce/crud/ConexionBD.java
```

Datos utilizados:

```java
private static final String URL =
        "jdbc:mysql://localhost:3306/universidad_java?useSSL=false&serverTimezone=UTC";

private static final String USUARIO = "root";
private static final String CONTRASENA = "";
```

Si su instalación de MySQL utiliza una contraseña diferente, debe modificar el valor de `CONTRASENA`.

También debe comprobar que:

- MySQL esté iniciado.
- El puerto sea `3306`.
- La base de datos se llame `universidad_java`.
- El usuario y la contraseña sean correctos.

## Compilación del proyecto

Abra una terminal dentro de la carpeta principal del proyecto, donde se encuentra el archivo `pom.xml`, y ejecute:

```bash
mvn clean compile
```

El comando `clean` elimina los archivos generados anteriormente y `compile` compila las clases Java del proyecto.

Si todo está correctamente configurado, la terminal mostrará:

```text
BUILD SUCCESS
```

## Ejecución

Para ejecutar el proyecto mediante Maven:

```bash
mvn exec:java
```

También puede abrir el proyecto en un entorno de desarrollo y ejecutar directamente la clase:

```text
com.puce.crud.Main
```

## Menú del programa

Al iniciar la aplicación se muestra el siguiente menú:

```text
1. Registrar estudiante
2. Listar estudiantes
3. Buscar estudiante por nombre
4. Actualizar carrera y semestre
5. Eliminar estudiante
0. Salir
```

El usuario selecciona una opción e ingresa los datos solicitados desde la consola.

## Ejemplo de funcionamiento

Un estudiante puede registrarse inicialmente con los siguientes datos:

```text
Nombre: Karolayn
Carrera: Software
Semestre: 2
```

Posteriormente, el sistema puede actualizar el registro:

```text
Carrera: Ingeniería de Software
Semestre: 3
```

También permite consultar, buscar o eliminar el registro mediante su ID.

## Buenas prácticas aplicadas

El proyecto aplica las siguientes prácticas:

- Uso de `PreparedStatement` para trabajar con parámetros seguros.
- Uso de `try-with-resources` para cerrar conexiones y consultas automáticamente.
- Manejo de errores mediante `SQLException`.
- Separación de responsabilidades en diferentes clases.
- Validación de nombre, carrera, semestre e ID.
- Verificación de filas afectadas después de insertar, actualizar o eliminar.
- Uso de Maven para administrar las dependencias.

## Posibles errores

### MySQL no está iniciado

Inicie MySQL desde XAMPP, MySQL Workbench o los servicios de Windows.

### Error de usuario o contraseña

Revise los valores configurados en `ConexionBD.java`.

### No existe la base de datos

Ejecute el archivo:

```text
database/universidad_java.sql
```

### No se encuentra el controlador de MySQL

Compruebe que la dependencia de MySQL Connector/J esté incluida en el archivo `pom.xml` y ejecute:

```bash
mvn clean install
```

### Los registros aparecen repetidos

Evite ejecutar varias veces los datos iniciales o limpie la tabla antes de repetir la prueba.

## Documentación incluida

El repositorio contiene:

- Documento teórico en PDF.
- Código fuente completo.
- Script SQL.
- Diapositivas en PDF y PowerPoint.
- Guía del ejercicio práctico.
- Carpeta para evidencias de ejecución.

## Evidencias recomendadas

En la carpeta `evidencias` se pueden incluir capturas de:

1. Creación de la base de datos.
2. Tabla `estudiantes`.
3. Ejecución de `mvn clean compile`.
4. Mensaje `BUILD SUCCESS`.
5. Menú principal.
6. Registro de un estudiante.
7. Consulta de estudiantes.
8. Actualización de un registro.
9. Eliminación de un estudiante.
10. Resultado final en MySQL.

## Conclusión

Este proyecto demuestra cómo una aplicación Java puede conectarse a MySQL y administrar información mediante las operaciones Create, Read, Update y Delete.

El uso de JDBC, PreparedStatement, ResultSet, manejo de excepciones y cierre automático de recursos permite construir una aplicación funcional, segura y organizada.
