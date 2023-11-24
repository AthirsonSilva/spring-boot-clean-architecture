# Purpose: Dockerfile for building cleanarch-from-scratch
# Build: docker build -t cleanarch-from-scratch .
FROM gradle:8.4.0-jdk17 AS build

COPY src /home/app/src
COPY build.gradle /home/app
COPY settings.gradle /home/app
COPY gradle /home/app/gradle

WORKDIR /home/app

RUN gradle build


# Purpose: Sequence of commands to run cleanarch-from-scratch
# Run: docker run -p 8080:8080 cleanarch-from-scratch
FROM amazoncorretto:17

COPY --from=build /home/app/build/libs/spring-boot-clean-architecture-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar

EXPOSE 80

ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]

