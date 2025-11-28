# ===========================
# Build stage
# ===========================
FROM gradle:8.5-jdk17 AS build
WORKDIR /app

# Gradle wrapper & 설정 파일 복사
COPY build.gradle settings.gradle gradlew ./
COPY gradle gradle

# (옵션) 의존성 미리 다운로드 - 캐시효과
RUN ./gradlew dependencies --no-daemon || true

# 소스 코드 복사
COPY src src

# 애플리케이션 빌드 (bootJar)
RUN ./gradlew bootJar --no-daemon -x test

# ===========================
# Runtime stage
# ===========================
FROM eclipse-temurin:17-jre
WORKDIR /app

# non-root 유저 생성
RUN groupadd -r spring && useradd -r -g spring spring
USER spring:spring

# 빌드 단계에서 생성된 jar 복사
COPY --from=build /app/build/libs/*.jar app.jar

# 배치 서버 포트 (application.yml 의 server.port와 일치)
EXPOSE 8081

# JVM 옵션
ENV JAVA_OPTS="-Xms256m -Xmx512m"

# 애플리케이션 실행
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]