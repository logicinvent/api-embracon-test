# 📌 HELP.md - Embracon Test Application

## 📖 About the Application
This application was developed as a **technical test for Embracon**, using **Spring Boot, JPA, MySQL, Actuator, and Swagger**.

### Features:
✅ **CEP Lookup** via the ViaCEP API.  
✅ **Logging and querying logs** in the MySQL database.  
✅ **Application monitoring** via **Spring Boot Actuator**.  
✅ **Interactive API documentation** with **Swagger (OpenAPI 3)**.  

---

## 🚀 1. How to Run the Application
### 🔹 1.1. Configure the Database (MySQL)
Before running the application, **start a MySQL container** using **Docker Compose**:

```sh
docker-compose up -d
```

If needed, create a **`docker-compose.yml`** file:

```yaml
version: '3.1'
services:
  mysql:
    image: 'mysql:latest'
    container_name: mysql_emb
    environment:
      MYSQL_DATABASE: embracon
      MYSQL_USER: embracon
      MYSQL_PASSWORD: embracon2319!
      MYSQL_ROOT_PASSWORD: embracon2319@
    ports:
      - "3306:3306"
```

---

### 🔹 1.2. Configure `application.yml`
The application is configured to connect to MySQL:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/embracon?useSSL=false&serverTimezone=UTC
    username: embracon
    password: embracon2319!
    driver-class-name: com.mysql.cj.jdbc.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

---

### 🔹 1.3. Run the Application
After configuring the database, start the application with:

```sh
mvn spring-boot:run
```

---

## 📡 2. API Endpoints
After running the application, access the **Swagger UI**:

🔹 **Swagger UI (Interactive Documentation)**:  
👉 [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)  

---

## 🔍 3. Querying the API
### ✅ **Lookup a CEP**
```sh
curl -X GET "http://localhost:8080/api/consulta-cep/01001000" -H "Content-Type: application/json"
```
📌 **Expected Response**:
```json
{
  "cep": "01001-000",
  "rua": "Praça da Sé",
  "bairro": "Sé",
  "cidade": "São Paulo",
  "uf": "SP"
}
```

---

### ✅ **List the last 20 logs by UF**
```sh
curl -X GET "http://localhost:8080/api/lista-ceps?uf=SP" -H "Content-Type: application/json"
```
📌 **Expected Response**:
```json
[
  {
    "cep": "05347030",
    "dtHrConsulta": "2025-02-21"
  },
  {
    "cep": "01001000",
    "dtHrConsulta": "2025-02-20"
  }
]
```

---

## 📊 4. Monitoring with Actuator
The application exposes **API health and metrics** via Spring Boot Actuator:

🔹 **Check application health**  
```sh
curl -X GET "http://localhost:8080/actuator/health"
```
📌 **Expected Response**:
```json
{
  "status": "UP"
}
```

🔹 **View metrics**  
```sh
curl -X GET "http://localhost:8080/actuator/metrics"
```

🔹 **List available beans**  
```sh
curl -X GET "http://localhost:8080/actuator/beans"
```

---

## 🛠 5. Project Structure
```
src/
│── main/
│   ├── java/com/embracon/api/
│   │   ├── controller/        # API Controllers
│   │   ├── service/           # Business Logic
│   │   ├── repository/        # Persistence Layer (JPA)
│   │   ├── model/             # JPA Entities
│   │   ├── exception/         # Error Handling
│   │   ├── config/            # Configurations (Swagger, Beans)
│   ├── resources/
│   │   ├── application.yml    # Spring Boot Configurations

```
