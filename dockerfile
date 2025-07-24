# OpenJDK 17 기반 이미지
FROM eclipse-temurin:17-jdk as builder

# 작업 디렉터리 설정
WORKDIR /app

# Gradle 캐시를 위한 복사
COPY gradlew .
COPY gradle/ gradle/
COPY build.gradle settings.gradle ./
COPY src/ src/

# 실행 권한 부여
RUN chmod +x gradlew

# 프로젝트 빌드
RUN ./gradlew build -x test

# 실제 실행용 이미지
FROM eclipse-temurin:17-jdk

WORKDIR /app

# 빌드 결과물 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 실행 명령
ENTRYPOINT ["java", "-jar", "app.jar"]