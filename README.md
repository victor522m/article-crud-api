# 📖 Article CRUD API

## Descripción
Este proyecto es una aplicación CRUD (Crear, Leer, Actualizar, Eliminar) desarrollada con **Spring Boot, Spring Data JPA y MySQL**. La API permite gestionar artículos mediante endpoints JSON, ofreciendo operaciones básicas de almacenamiento, consulta y actualización de datos en una base de datos relacional.

---

## 🚀 Características

✅ **Gestión completa de artículos (Article) con los siguientes atributos:**
- **ID**: Identificador único del artículo.
- **Name**: Nombre del artículo.
- **Features**: Características del artículo.
- **Description**: Descripción breve del artículo.
- **ImageUrl**: URL de la imagen asociada al artículo.

✅ **Endpoints RESTful** para realizar operaciones CRUD.

✅ **Persistencia de datos** usando MySQL y Spring Data JPA.

✅ **Gestión automática de transacciones** con `@Transactional`.

---

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Web**
- **Spring Data JPA**
- **JUnit 5** para pruebas unitarias.
- **MySQL** como base de datos relacional.
- **Postman** para pruebas de API.
- **Maven** para la gestión del proyecto.

---

## 📚 Estructura del Proyecto

```plaintext
ARTICLE-CRUD
├── .mvn
├── .vscode
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example.article_crud
│   │   │       ├── controller
│   │   │       │   └── ArticleController.java
│   │   │       ├── entity
│   │   │       │   └── Article.java
│   │   │       ├── repository
│   │   │       │   ├── ArticleRepository.java
│   │   │       └── ArticleCrudApplication.java
│   │   ├── resources
│   │   │   ├── static
│   │   │   ├── templates
│   │   │   └── application.properties
│   ├── test
│   │   ├── java
│   │   │   └── com.example.article_crud
│   │   │       ├── ArticleControllerTest.java
│   │   │       ├── ArticleCrudApplicationTests.java
│   │   │       └── ArticleRepositoryTest.java
├── target
├── .gitattributes
├── .gitignore
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md


---

## ⚙️ Configuración del Proyecto

### 1️⃣ Crear la Base de Datos en MySQL
Ejecuta el siguiente script SQL para crear la base de datos y la tabla:

```sql
CREATE DATABASE article_crud;
USE article_crud;

CREATE TABLE article (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    features TEXT,
    description TEXT,
    imageUrl VARCHAR(2083)
);
```

### 2️⃣ Configuración en `application.properties`

Actualiza las credenciales y la URL de tu base de datos:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/article_crud?useSSL=false
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 💑 Endpoints Disponibles

### 1️⃣ Crear un Artículo
**POST** `/api/articles`

📌 **Body (JSON):**
```json
{
    "name": "Smart Lamp",
    "features": "Wi-Fi enabled, Adjustable brightness",
    "description": "A modern lamp that you can control with your smartphone.",
    "imageUrl": "http://example.com/smartlamp.jpg"
}
```

### 2️⃣ Obtener Todos los Artículos
**GET** `/api/articles`

### 3️⃣ Obtener un Artículo por ID
**GET** `/api/articles/{id}`

### 4️⃣ Actualizar un Artículo
**PUT** `/api/articles/{id}`

📌 **Body (JSON):**
```json
{
    "name": "Smart Lamp Pro",
    "features": "Wi-Fi enabled, Adjustable brightness, Voice Control",
    "description": "An upgraded version of the smart lamp.",
    "imageUrl": "http://example.com/smartlamppro.jpg"
}
```

### 5️⃣ Eliminar un Artículo
**DELETE** `/api/articles/{id}`

---

## 🧪 Pruebas con Postman

Puedes usar **Postman** para realizar solicitudes HTTP a los endpoints mencionados.

✅ También puedes **automatizar la creación de varios artículos** usando scripts en la pestaña **Pre-request Script**.

---

## 📚 Conceptos Clave

🔹 **Spring Boot** facilita la creación de APIs RESTful.

🔹 **Spring Data JPA** gestiona las operaciones de la base de datos con métodos listos para usar.

🔹 **`@Transactional`** asegura la consistencia de datos durante las operaciones.

🔹 **MySQL** se integra fácilmente con Spring mediante el driver `mysql-connector-java`.

---

✨ **¡Listo para usar! Implementa y prueba tu API sin complicaciones. 🚀**

