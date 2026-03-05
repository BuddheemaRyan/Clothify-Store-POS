# Clothify Store POS

A **Point of Sale (POS) system** for a clothing retail store, built with Java and Maven.

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

---

## Overview

Clothify Store POS is a desktop application designed to streamline retail operations for clothing stores. It aims to provide an intuitive interface for managing sales transactions, inventory, and store operations.

---

## Features

- Point of Sale transaction management
- Clothing inventory tracking
- Sales reporting and management
- Desktop-based GUI application

---

## Tech Stack

| Technology | Version |
|------------|---------|
| Java       | 17      |
| Maven      | 3.x     |

---

## Prerequisites

Before running this project, ensure you have the following installed:

- **Java Development Kit (JDK) 17** or higher
  - Download from [Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or use [OpenJDK](https://openjdk.org/)
- **Apache Maven 3.x**
  - Download from [maven.apache.org](https://maven.apache.org/download.cgi)

Verify your installations:

```bash
java -version
mvn -version
```

---

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/BuddheemaRyan/Clothify-Store-POS.git
cd Clothify-Store-POS
```

### 2. Build the project

```bash
mvn clean compile
```

### 3. Package the application

```bash
mvn package
```

### 4. Run the application

```bash
mvn exec:java -Dexec.mainClass="Main"
```

---

## Project Structure

```
Clothify-Store-POS/
├── pom.xml                        # Maven project configuration
├── src/
│   └── main/
│       └── java/
│           ├── Main.java          # Application entry point
│           └── Starter.java       # Starter class
└── README.md
```

---

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/your-feature-name`)
3. Commit your changes (`git commit -m 'Add your feature'`)
4. Push to the branch (`git push origin feature/your-feature-name`)
5. Open a Pull Request

---

## License

This project is open source. See the repository for license details.
