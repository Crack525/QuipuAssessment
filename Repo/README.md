## Project Description:
This project provides a robust and scalable Selenium test automation framework using Docker containers, designed to test the Search, Login, and Add to Cart functionalities on the Automation Practice website (www.automationpractice.pl/index.php).

## 🚀 Features

- Containerized test execution environment
- Chrome browser and ChromeDriver auto-configuration
- Support for Java 17 and M
- Volume mapping for test reports
- Automated dependency management

## 📋 Prerequisites

- Docker (version 20.10 or higher)
- Docker Compose (version 2.0 or higher)
- Maven is installed


## 🚀 Running Tests Using Docker Compose
1. Go to the folder in terminal
```bash
cd <project-directory>
```
2. Start the container:
```bash
docker-compose up --build
```
or 

3. Run tests locally:
```bash
 mvn test
```
