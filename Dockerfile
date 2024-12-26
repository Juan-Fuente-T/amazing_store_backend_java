#OPTIMIZADO PARA DESPLEGAR EN RENDER DESDE GITHUB Y EVITAR PROBELMAS CON EL TARGET QUE NO SE SUBE A GITHUB(presente en el gitignore)
# Etapa de compilación
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/amazingStore-0.0.1-SNAPSHOT.jar amazingstore.jar
EXPOSE 30030
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "amazingstore.jar"]

#VALIDO PARA IMAGENES EN LOCAL
#FROM openjdk:17
#VOLUME /tmp
#ARG JAVA_OPTS
#ENV JAVA_OPTS=$JAVA_OPTS
#COPY target/amazingStore-0.0.1-SNAPSHOT.jar amazingstore.jar
#EXPOSE 30030
## ENTRYPOINT exec java $JAVA_OPTS -jar amazingstore.jar
## Opcional: Reduce el tiempo de inicio de Spring Boot
#ENTRYPOINT ["exec", "java", "$JAVA_OPTS", "-Djava.security.egd=file:/dev/./urandom", "-jar", "amazingstore.jar"]
