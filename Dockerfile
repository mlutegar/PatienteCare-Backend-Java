# Usando a imagem oficial do OpenJDK
FROM openjdk:17-jdk-slim

# Definindo o diretório de trabalho no container
WORKDIR /app

# Copiando o JAR da aplicação para o container
COPY target/patiente-care-0.0.1-SNAPSHOT.jar app.jar

# Expondo a porta que a aplicação usa
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
