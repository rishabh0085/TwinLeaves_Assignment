# TwinLeaves Assignment

This project implements a RESTful API for managing inventory, including products, GTINs (Global Trade Item Numbers), and batches. It provides endpoints for creating new entries, querying data by GTIN, and retrieving batches based on specific quantity conditions.

---

## Features

- **Product Management**: Add and manage product information (name, creation date).
- **GTIN Management**: Associate unique GTINs with products.
- **Batch Tracking**: Track individual batches of products, including quantity, pricing, and inwarding date.
- **GTIN-based Queries**: Retrieve batches associated with a specific GTIN.
- **Conditional Batch Retrieval**:
  - Retrieve all batches with positive quantities.
  - For batches with negative or zero quantities, retrieve only the latest batch (based on inwarding date).

---

## Technologies Used

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **MySQL** (or your preferred database)
- **Jackson** (for JSON handling)
- **Java Time API** (`java.time.LocalDate`)

---

## Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/YOUR_USERNAME/YOUR_REPO_NAME.git
   ```

2. Configure your database connection in `application.properties` or `application.yml`.

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

---

## API Endpoints

### Product Management

- **POST /api/product**: Create a new product.
  - **Request Body**:
    ```json
    {
      "name": "string",
      "creationDate": "YYYY-MM-DD"
    }
    ```

### GTIN Management

- **POST /api/gtin**: Create a new GTIN.
  - **Request Body**:
    ```json
    {
      "gtin": "string",
      "productId": "long"
    }
    ```

### Batch Tracking

- **POST /api/batch**: Create a new batch.
  - **Request Body**:
    ```json
    {
      "gtin": "string",
      "quantity": "integer",
      "price": "decimal",
      "inwardingDate": "YYYY-MM-DD"
    }
    ```

### GTIN-based Queries

- **GET /api/gtin/{gtin}**: Get batches by GTIN.

### Conditional Batch Retrieval

- **GET /api/batches/conditions**: Get batches based on quantity conditions.

---

## Example Configurations

### `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
---

##Screen-Shots 

![Screenshot (29)](https://github.com/user-attachments/assets/b80f5cc8-e181-4962-bcb1-f71c73b4b9b3)

![Screenshot (27)](https://github.com/user-attachments/assets/991f6498-65f1-46fe-aace-b8b972fc074e)


