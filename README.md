# CHALLENGE ONE - Catálogo de Libros - LITERALURA

Este proyecto es una aplicación en Java que permite interactuar con un catálogo de libros a través de una interfaz basada en texto. Utiliza una API externa para buscar información sobre libros y registra detalles en una base de datos local. Ofrece diversas funciones para gestionar libros y autores.

## Funcionalidades

1. **Buscar Libro por Título:**
   - Permite buscar libros en la API externa por título.
   - Registra los libros encontrados en la base de datos local para evitar duplicados.

2. **Listar Libros Registrados:**
   - Muestra una lista de los libros almacenados en la base de datos, junto con detalles como el autor, idioma y número de descargas.

3. **Listar Autores Registrados:**
   - Despliega una lista de autores almacenados, incluyendo su nombre, fecha de nacimiento y fallecimiento (si aplica).

4. **Listar Autores Vivos en un Año Determinado:**
   - Filtra y muestra autores que estaban vivos en un año específico.

5. **Listar Libros por Idioma:**
   - Muestra todos los libros registrados filtrados por idioma.

6. **Registro Automático de Libros y Autores:**
   - Al buscar un libro, verifica si ya está registrado y, en caso contrario, lo almacena junto con su autor.

## Tecnologías Utilizadas

- **Lenguaje:** Java
- **Framework:** Spring Boot
- **API Externa:** [Gutendex API](https://gutendex.com/) para obtener información de libros.
- **Base de Datos:** PostgreSQL para almacenar los datos de los libros y autores.
- **Dependencias:**
  - Spring Data JPA para la gestión de datos.
  - Gson para procesar datos JSON obtenidos de la API.
  - Spring Web para manejar solicitudes HTTP.

## Clases Principales

### `Principal`
- Contiene la lógica del menú principal.
- Maneja las opciones seleccionadas por el usuario.

### `LibroService` y `AutorService`
- Proporcionan métodos para gestionar libros y autores en la base de datos.

### `ConsumoAPI`
- Realiza solicitudes a la API externa y devuelve los datos en formato JSON.

### `ConvierteDatos`
- Convierte datos JSON en objetos utilizables en Java.

### `Libro` y `Autor`
- Modelos que representan la estructura de los datos de libros y autores.

## Requisitos Previos

1. **Java Development Kit (JDK):** Versión 11 o superior.
2. **Maven:** Para gestionar las dependencias del proyecto.
3. **PostgreSQL:** Instalar y configurar una base de datos PostgreSQL.
4. **Conexión a Internet:** Requerida para buscar libros en la API externa.

## Instalación y Ejecución

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/starman-ai/LiteraluraProyecto.git
   cd LiteraluraProyecto

Ejecuta el siguiente comando para descargar las dependencias del proyecto:
```
    mvn install
```
## Configura la base de datos PostgreSQL
1. Asegúrate de tener PostgreSQL instalado y en ejecución.
2. Crea una base de datos para el proyecto. Por ejemplo, puedes usar el siguiente comando en PostgreSQL:

  CREATE DATABASE catalogo_libros;
  
3. En el archivo `src/main/resources/application.properties`, configura la conexión a tu base de datos PostgreSQL:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/catalogo_libros
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```
## Ejecución
Ejecuta el programa desde la línea de comandos:
   ```
    mvn spring-boot:run
   ```
## Interacción
Una vez iniciado, sigue las instrucciones en la consola para interactuar con el catálogo.

## Manejo de Errores

### Validación de Entradas
- Manejo de entradas inválidas en el menú.
- Verificación de títulos y autores antes de registrar datos duplicados.

### Errores de Conexión
- Manejo de fallos al intentar conectarse con la API externa.

### Control de Excepciones
- Todas las operaciones críticas están envueltas en bloques `try-catch` para manejar errores de manera efectiva.
