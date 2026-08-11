FROM eclipse-temurin:21-jre
LABEL author="Riya"
LABEL project="JAVA Maven Docker Demo"
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
