FROM bellsoft/liberica-openjdk-alpine-musl:17
COPY /target/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]