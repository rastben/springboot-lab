# ==========================
# Etapa 1 - Build
# ==========================
FROM maven:3.9.11-eclipse-temurin-21 AS builder

WORKDIR /build

COPY . .

RUN mvn clean package -DskipTests

# ==========================
# Etapa 2 - Runtime
# ==========================

# Imagen tipo Distroless: Las herramientas minimas necesarias para que la aplicacion corra
# Reduce la superficie de ataque del contenedor para un potencial atacante
# (Menos herramientas menos privilegios = menor superficie de ataque)
FROM gcr.io/distroless/java21-debian12

WORKDIR /app

# Copiar la aplicación
COPY --from=builder /build/target/springboot-lab-0.0.1-SNAPSHOT.jar app.jar

# La imagen tipo distroless ya proporciona un usuario sin privilegios
USER nonroot

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]