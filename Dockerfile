FROM maven:3.8.6-openjdk-18 AS build
COPY . .
RUN mvn clean package assembly:single -DskipTests
FROM openjdk:17-jdk-slim
COPY --from=build /target/my-app-name-1.0-SNAPSHOT-jar-with-dependencies.jar webapp.jar

# Variables de entorno
ENV URL_VIANDAS=http://viandas.example.com
ENV URL_HELADERAS=http://heladeras.example.com
ENV URL_COLABORADORES=http://colaboradores.example.com
ENV PORT=8080

EXPOSE 8080
CMD ["java","-classpath","webapp.jar","ar.edu.utn.dds.k3003.app.WebApp"]