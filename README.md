# Aplicación de Lista de Tareas

Este proyecto es una aplicación simple de Lista de Tareas construida con Spring Boot, Thymeleaf, HTML, CSS y HTMX. El objetivo de este proyecto es crear una aplicación web dinámica sin depender de Aplicaciones de Página Única (SPA). Utilizando HTMX, logramos actualizaciones dinámicas del contenido con un uso mínimo de JavaScript, haciendo que la aplicación sea ligera y fácil de mantener.

## Características

- **Agregar Tareas:** Agrega nuevas tareas a la lista de manera dinámica sin recargar la página.
- **Actualizar Tareas:** Escribe algo en la descripción de la tarea y verás como se actualiza.
- **Eliminar Tareas:** Elimina tareas de la lista instantáneamente utilizando HTMX y Spring Boot.
- **Marcar como Completada:** Marca tareas como completadas con actualizaciones en tiempo real.

## Tecnologías Utilizadas

- **Spring Boot:** Framework backend para construir la aplicación.
- **Thymeleaf:** Motor de plantillas para renderizar HTML en el servidor.
- **HTML & CSS:** Tecnologías web estándar para estructurar y dar estilo a la aplicación.
- **HTMX:** Biblioteca para manejar solicitudes AJAX y actualizar partes de la página web de manera dinámica.

## Instalación

1. **Clonar el repositorio:**

   ```bash
   git clone https://github.com/nicosal1080/lista-tareas.git
   cd todo-application

2. **Construir y ejecutar la aplicación:**

   ```bash
  ./mvnw spring-boot:run

3. **Acceder a la aplicación:**

Abre tu navegador web y navega a http://localhost:8080.
