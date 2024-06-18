FROM openjdk:17
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/amazingStore-0.0.1-SNAPSHOT.jar amazingstore.jar
EXPOSE 30030
# ENTRYPOINT exec java $JAVA_OPTS -jar amazingstore.jar
# Opcional: Reduce el tiempo de inicio de Spring Boot
ENTRYPOINT ["exec", "java", "$JAVA_OPTS", "-Djava.security.egd=file:/dev/./urandom", "-jar", "amazingstore.jar"]
