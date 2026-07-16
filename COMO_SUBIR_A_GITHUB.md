# Cómo subir este proyecto a GitHub

1. Cree un repositorio en GitHub con el nombre:

```text
crud-estudiantes-java-mysql
```

2. No agregue README desde GitHub, porque este proyecto ya incluye uno.

3. Abra una terminal dentro de la carpeta del proyecto y ejecute:

```bash
git init
git add .
git commit -m "Entrega CRUD completo en Java con MySQL"
git branch -M main
git remote add origin https://github.com/TU-USUARIO/crud-estudiantes-java-mysql.git
git push -u origin main
```

4. Verifique que en GitHub aparezcan estas carpetas:

```text
src/
database/
docs/
evidencias/
```

5. Copie el enlace del repositorio y péguelo en la entrega de la actividad.

## Antes de entregar

Revise que estén incluidos:

- README.md
- pom.xml
- Código fuente en src/main/java
- Script SQL en database
- Documento teórico PDF en docs
- Diapositivas PDF en docs
- Guía del ejercicio PDF en docs
- Evidencias o capturas en evidencias
