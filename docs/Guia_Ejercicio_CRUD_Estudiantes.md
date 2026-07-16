# Guía de ejercicio individual

## Tema

CRUD completo en Java con MySQL.

## Objetivo

Practicar una operación de consulta dentro de un CRUD usando Java, JDBC, MySQL, `PreparedStatement` y `ResultSet`.

## Contexto

El proyecto base contiene una tabla llamada `estudiantes` con los siguientes campos:

- `id`
- `nombre`
- `carrera`
- `semestre`

El sistema ya permite registrar, listar, buscar por nombre, actualizar y eliminar estudiantes.

## Ejercicio propuesto

Implementar una nueva función que permita buscar estudiantes por carrera.

## Método solicitado

En la clase `EstudianteDAO.java`, agregue el método:

```java
public List<Estudiante> buscarPorCarrera(String carreraBuscada) {
    // Implementar aquí
}
```

## Consulta SQL esperada

```sql
SELECT id, nombre, carrera, semestre
FROM estudiantes
WHERE carrera LIKE ?
ORDER BY id;
```

## Requisitos del ejercicio

- Usar `PreparedStatement`.
- Usar `%` para permitir búsquedas parciales.
- Ejecutar la consulta con `executeQuery()`.
- Recorrer los resultados con `rs.next()`.
- Guardar los resultados en una lista de objetos `Estudiante`.
- Usar `try-with-resources`.
- Manejar errores con `SQLException`.
- Mostrar un mensaje si no existen coincidencias.

## Prueba sugerida

Buscar estudiantes cuya carrera contenga la palabra:

```text
Software
```

## Preguntas teóricas

1. ¿Qué operación CRUD representa esta consulta?
2. ¿Por qué se utiliza `executeQuery()` y no `executeUpdate()`?
3. ¿Qué función cumple `ResultSet`?
4. ¿Para qué sirve el símbolo `%` en una consulta con `LIKE`?
5. ¿Por qué es recomendable usar `PreparedStatement`?

## Resultado esperado

El programa debe mostrar en consola los estudiantes cuya carrera coincida parcial o totalmente con el texto ingresado.
