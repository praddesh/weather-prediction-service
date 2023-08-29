FROM openjdk:17
EXPOSE 8080
ADD target/weather-prediction-service.jar weather-prediction-service.jar
ENTRYPOINT ["java","-jar","/weather-prediction-service.jar"]
