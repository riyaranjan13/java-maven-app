# Java Maven App – Cloud & DevOps Deployment

A containerized Java/Spring Boot application demonstrating a practical **DevOps deployment workflow using Maven, Docker, Azure Container Registry (ACR), Azure App Service, Managed Identity, and Azure RBAC**.

## 🚀 Project Overview

This project demonstrates how a Java application can be built, tested, containerized, stored in a private container registry, and deployed to Azure App Service.

### Architecture

```text
                    GitHub
                       |
                       v
                  Maven Build
                       |
                  Unit Testing
                       |
                       v
               Spring Boot JAR
                       |
                       v
                 Docker Build
                       |
                       v
          Azure Container Registry
              riyaregistry
                       |
                hello-world:v2
                       |
                       v
              Azure App Service
                hello-world-v1
                       |
                 Docker Container
                       |
                  Spring Boot
                       |
                    Port 8080
                       |
                    /hello
```

## 🛠️ Technologies Used

### Application

* Java 21
* Spring Boot
* Maven
* JUnit 5

### Containerization

* Docker
* Docker Image Versioning
* Azure Container Registry (ACR)

### Azure

* Azure Resource Group
* Azure Container Registry
* Azure App Service Plan
* Azure App Service
* Azure Managed Identity
* Azure RBAC
* `AcrPull` role

### DevOps / CI-CD

* Git
* GitHub
* Maven Build & Testing
* SonarQube
* Jenkins

### Infrastructure as Code

* Terraform
* Terraform Modules
* Variables
* Outputs
* Workspaces
* Remote State
* AWS S3 Backend
* Resource Dependencies
* Lifecycle Rules

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

## 📦 Azure Container Registry

The Docker image is tagged for Azure Container Registry:

```bash
docker tag hello-world:v2 \
  riyaregistry.azurecr.io/hello-world:v2
```

Push the image:

```bash
docker push \
  riyaregistry.azurecr.io/hello-world:v2
```

Verify the repository:

```bash
az acr repository list \
  --name riyaregistry \
  --output table
```

Verify image tags:

```bash
az acr repository show-tags \
  --name riyaregistry \
  --repository hello-world \
  --output table
```

Example:

```text
v1
v2
```

## ☁️ Azure App Service Deployment

The application is deployed to Azure App Service.

### Azure Resources

```text
Resource Group
    azure-proj

ACR
    riyaregistry

App Service Plan
    azure-plan

App Service
    hello-world-v1
```

The App Service runs the Docker image:

```text
riyaregistry.azurecr.io/hello-world:v2
```

Application endpoint:

```text
https://hello-world-v1.azurewebsites.net/hello
```

## 🔐 Secure ACR Authentication

The ACR repository is private, so App Service needs permission to pull the Docker image.

Instead of storing registry credentials, the project uses:

```text
App Service
     |
     v
System-Assigned Managed Identity
     |
     v
Azure RBAC
     |
     | AcrPull
     v
Azure Container Registry
```

This provides secure, identity-based authentication.

The `AcrPull` role allows the App Service to pull container images without giving it unnecessary write or administrative permissions.

## 🔄 Deployment Flow

```text
Developer
    |
    v
GitHub
    |
    v
Maven
    |
    +--> Unit Tests
    |
    v
Spring Boot JAR
    |
    v
Docker Build
    |
    v
Docker Image
    |
    v
Azure Container Registry
    |
    v
Azure App Service
    |
    v
Running Container
    |
    v
HTTP /hello
```

## 🧪 Testing

Run unit tests:

```bash
mvn test
```

Run the application locally:

```bash
java -jar target/hello-world-1.0-SNAPSHOT.jar
```

Test the endpoint:

```bash
curl http://localhost:8080/hello
```

## 📊 SonarQube

SonarQube is configured for static code analysis.

Run:

```bash
mvn sonar:sonar
```

The project uses:

```text
Project Key: hello-world
```

## 🔧 Jenkins CI/CD

The project also includes a Jenkins pipeline for automating:

```text
Checkout
   |
   v
Maven Build
   |
   v
Unit Tests
   |
   v
SonarQube Analysis
   |
   v
Quality Gate
   |
   v
Package
   |
   v
Docker Build
   |
   v
Push to Registry
   |
   v
Deployment
```

## 🏗️ Terraform / Infrastructure as Code

Terraform is used in the broader cloud infrastructure work associated with this project.

Key Terraform concepts practiced:

* Infrastructure as Code
* Reusable Modules
* Variables
* Outputs
* Terraform Workspaces
* Remote State
* AWS S3 Backend
* State Locking
* Resource Dependencies
* Lifecycle Rules
* `terraform plan`
* `terraform apply`
* `terraform destroy`

AWS infrastructure practiced with Terraform includes:

```text
VPC
├── Subnets
├── Security Groups
├── EC2
├── ALB
├── Auto Scaling
├── IAM
└── EKS
```

## 🔐 Security Practices

* Private Docker image repository using Azure Container Registry
* Managed Identity instead of hardcoded registry credentials
* Least-privilege `AcrPull` RBAC permission
* Versioned container images
* Infrastructure managed through Terraform
* Sensitive credentials excluded from source code

## 📌 Key DevOps Concepts Demonstrated

* Git-based source control
* Maven dependency management and builds
* Unit testing
* Docker containerization
* Container image versioning
* Private container registries
* Azure App Service deployment
* Managed Identity
* Azure RBAC
* Infrastructure as Code
* Terraform modules
* CI/CD pipeline concepts
* SonarQube code analysis
* Cloud infrastructure troubleshooting

## 🎯 Resume Project Description

**Cloud & DevOps Infrastructure Automation Project**

Built and deployed a containerized Java/Spring Boot application using Maven and Docker, pushed versioned images to Azure Container Registry, and deployed the application to Azure App Service using System-Assigned Managed Identity and Azure RBAC (`AcrPull`) for secure private registry access. Implemented Maven unit testing, SonarQube integration, Jenkins CI/CD concepts, and Terraform-based infrastructure automation across AWS cloud resources.
