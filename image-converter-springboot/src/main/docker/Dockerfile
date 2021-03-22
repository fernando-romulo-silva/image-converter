FROM adoptopenjdk:14-jre-hotspot as builder
WORKDIR /application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk:14-jre-hotspot
WORKDIR /application
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader ./
COPY --from=builder application/internal-dependencies ./
COPY --from=builder application/snapshot-dependencies ./
COPY --from=builder application/application/ ./
ENTRYPOINT [\
               "java",\
               "-Dspring.profiles.active=local",\
			   "-XX:+UseContainerSupport",\ 
			   "-XX:InitialRAMPercentage=40.0",\ 
			   "-XX:MinRAMPercentage=20.0",\ 
			   "-XX:MaxRAMPercentage=80.0",\
#			   "-Dspring-datasource-username=\"$$(cat /run/secrets/spring.datasource.username)\"",\
#			   "-Dspring-datasource-password=\"$$(cat /run/secrets/spring.datasource.username)\"",\
               "org.springframework.boot.loader.JarLauncher"\
]