# Spring Native Demo

## JVM Spring Boot Anwendung bauen und starten

```
./mvnw clean package
java -jar target/spring-native-demo-1.0.0.jar 
```

## JVM Image bauen und starten

```
./mvnw -D spring-boot.build-image.imageName=spring-jvm-demo spring-boot:build-image
docker run -p 8081:8080 spring-jvm-demo
```


## Native Docker Image bauen und starten

```
./mvnw -P native -D spring-boot.build-image.imageName=spring-native-demo spring-boot:build-image
docker run -p 8080:8080 spring-native-demo
```

