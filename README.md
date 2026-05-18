# Clothify Store POS

A desktop Point of Sale (POS) application for a clothing store, built with Java and JavaFX. It provides a centralized dashboard to manage customers, suppliers, employees, inventory, and orders.

## Features

- **Customer Management** – Add, update, and delete customer records (name, address, date of birth, city, province, postal code).
- **Supplier Management** – Manage supplier details including company name, contact information, and address.
- **Employee Management** – Track employee records with position, salary, NIC, contact number, and employment status.
- **Inventory Management** – Add, update, and delete clothing items with category, size, price, quantity, and availability status.
- **Order Processing** – Place orders by selecting items and quantities, apply discounts, and automatically update stock levels. Orders are processed within a database transaction for data integrity.
- **Order History / Reports** – View past orders filtered by date, with customer details and itemized order breakdowns.
- **User Login** – Secure login screen backed by a database credential check.

## Tech Stack

| Layer        | Technology                    |
|--------------|-------------------------------|
| UI           | JavaFX 19 (FXML)              |
| Language     | Java 22                       |
| Build Tool   | Apache Maven                  |
| Database     | MySQL                         |
| ORM Helpers  | Lombok                        |

## Project Structure

```
src/
└── main/
    ├── java/
    │   ├── Main.java                          # Entry point
    │   ├── Starter.java                       # JavaFX Application bootstrap
    │   ├── contraller/
    │   │   └── DashBoardFromController.java   # JavaFX controller for the dashboard
    │   ├── service/
    │   │   └── DashBoardService.java          # Business logic layer
    │   ├── repository/
    │   │   └── DashBoardRepository.java       # Database access layer
    │   ├── model/dto/
    │   │   ├── Customer.java
    │   │   ├── Employee.java
    │   │   ├── Item.java
    │   │   ├── Order.java
    │   │   ├── Report.java
    │   │   └── Supplier.java
    │   └── dbConnection/
    │       └── DBConnection.java              # Singleton JDBC connection
    └── resources/
        ├── image/
        │   └── login.jpg
        └── view/
            └── dashBoardForm.fxml             # Main dashboard UI layout
```

## Prerequisites

- **Java 22** or higher
- **Maven 3.6+**
- **MySQL 8+**

## Database Setup

1. Create a database named `clothshop` in your MySQL instance.
2. Create the required tables:

```sql
CREATE DATABASE clothshop;
USE clothshop;

CREATE TABLE Login (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE customer (
    CustID      VARCHAR(20) PRIMARY KEY,
    CustTitle   VARCHAR(10),
    CustName    VARCHAR(100),
    DOB         VARCHAR(20),
    CustAddress VARCHAR(200),
    City        VARCHAR(50),
    Province    VARCHAR(50),
    PostalCode  VARCHAR(10)
);

CREATE TABLE supplier (
    supplier_id  VARCHAR(20) PRIMARY KEY,
    name         VARCHAR(100),
    company_name VARCHAR(100),
    address      VARCHAR(200),
    city         VARCHAR(50),
    province     VARCHAR(50),
    postal_code  VARCHAR(10),
    phone        VARCHAR(20),
    email        VARCHAR(100)
);

CREATE TABLE employee (
    id             VARCHAR(20) PRIMARY KEY,
    name           VARCHAR(100),
    nic            VARCHAR(20),
    dob            VARCHAR(20),
    position       VARCHAR(50),
    salary         DOUBLE,
    contact_number VARCHAR(20),
    address        VARCHAR(200),
    joined_date    VARCHAR(20),
    status         VARCHAR(20)
);

CREATE TABLE item (
    id          VARCHAR(20) PRIMARY KEY,
    name        VARCHAR(100),
    category    VARCHAR(50),
    size        VARCHAR(10),
    price       DOUBLE,
    qty         INT,
    isAvailable BOOLEAN
);

CREATE TABLE orders (
    OrderID   VARCHAR(20) PRIMARY KEY,
    CustID    VARCHAR(20),
    OrderDate DATE,
    FOREIGN KEY (CustID) REFERENCES customer(CustID)
);

CREATE TABLE orderdetails (
    OrderID  VARCHAR(20),
    ItemID   VARCHAR(20),
    Qty      INT,
    Discount DOUBLE,
    FOREIGN KEY (OrderID) REFERENCES orders(OrderID),
    FOREIGN KEY (ItemID)  REFERENCES item(id)
);
```

3. Insert at least one login record:

```sql
INSERT INTO Login (username, password) VALUES ('admin', 'admin123');
```

## Configuration

The database connection is configured in `DBConnection.java`:

```
URL:      jdbc:mysql://localhost:3306/clothshop
Username: root
Password: 1234
```

Update these values to match your local MySQL setup before running the application.

## Building and Running

```bash
# Clone the repository
git clone https://github.com/BuddheemaRyan/Clothify-Store-POS.git
cd Clothify-Store-POS

# Build the project
mvn clean compile

# Run the application
mvn javafx:run
```

> **Note:** If `mvn javafx:run` is not configured in the POM, you can run the compiled `Main` class directly from your IDE (IntelliJ IDEA, Eclipse, etc.) after importing the project as a Maven project.

## Architecture

The application follows a layered architecture:

```
Controller (JavaFX FXML)
    └── Service (Business Logic)
            └── Repository (Database Queries)
                    └── DBConnection (JDBC / MySQL)
```

- **Controller** handles all UI events and binds data to JavaFX `TableView` components.
- **Service** contains business rules (e.g., stock validation, order ID generation, transaction management).
- **Repository** executes raw SQL via JDBC `PreparedStatement`.
- **DBConnection** is a singleton that holds the single active JDBC `Connection`.

## License

This project is intended for educational purposes.
