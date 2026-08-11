# Java Maven App – Cloud & DevOps Deployment

A containerized Java/Spring Boot application demonstrating a practical **DevOps deployment workflow using Maven, Docker, Jenkins integrated**

## 🚀 Project Overview


## 🛠️ Technologies Used

### Application

* Java 21
* Spring Boot
* Maven
* JUnit 5

### Containerization

* Docker
* Docker Image Versioning

### DevOps / CI-CD

* Git
* GitHub
* Maven Build & Testing
* SonarQube
* Jenkins

## 📁 Project Structure

```text
hello-world/
│
├── Dockerfile
├── Jenkinsfile
├── pom.xml
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── devops/
│   │               └── App.java
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── devops/
│                   └── AppTest.java
│
└── target/
```

## 💻 Application

The application exposes a simple REST endpoint:

```text
GET /hello
```

Response:

```text
Hello from Azure!
```

The Spring Boot application runs on:

```text
Port: 8080
```

## 🔨 Build the Application

Clone the repository:

```bash
git clone https://github.com/riyaranjan13/java-maven-app.git
cd java-maven-app
```

Build and test:

```bash
mvn clean package
```

Expected result:

```text
BUILD SUCCESS
```

## 🐳 Docker

Build the Docker image:

```bash
docker build -t hello-world:v2 .
```

Run locally:

```bash
docker run -d \
  --name hello-world-v2 \
  -p 8080:8080 \
  hello-world:v2
```

Test:

```bash
curl http://localhost:8080/hello
```

Expected:

```text
Hello from Azure!
```
