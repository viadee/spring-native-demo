# Spring Native Demo

## JVM Spring Boot Anwendung bauen und starten

```
./mvnw clean package
java -jar target/spring-native-demo-0.0.1-SNAPSHOT.jar 
```

## JVM Docker-Image bauen und starten

```
./mvnw clean package
docker build -t spring-jvm-demo:0.0.1-SNAPSHOT -f src/main/docker/Dockerfile.jvm .
docker run -p 8081:8080 spring-jvm-demo:0.0.1-SNAPSHOT
```

## Native Executable bauen und starten

```
./mvnw clean package -Pnative
./target/spring-native-demo
```

## Native Docker-Image bauen und starten


> **_Hinweis:_** Dieses Demo-Projekt bietet zwei M�glichkeiten, um das native Docker-Image zu bauen.
> Einerseits l�sst sich das Image per Maven-Plugin mit dem [Java Native Image Buildpack](https://paketo.io/docs/reference/java-native-image-reference/) von Paketo bauen. 
> Anderseits besteht die M�glichkeit das Image mit der beigelegten Dockerfile zu erzeugen. 
> Unter Windows empfehlen wir die Variante mit der Dockerfile und die Verwendung des Windows Subsystem for Linux (WSL), weil der Build-Prozess von keinen weiteren betreibssystemspezifischen Konfigurationen abh�ngig ist.
> Lediglich Docker muss f�r die Durchf�hrung vorhanden sein.
> Unter Linux und macOS lassen sich nach unserer Einsch�tzung beide Varianten problemlos durchf�hren.

### Mit Paketo-Buildpack

```
./mvnw spring-boot:build-image
```

### Mit Dockerfile bauen

```
docker build -t spring-native-demo:0.0.1-SNAPSHOT -f src/main/docker/Dockerfile.native .
```

### Docker-Container starten

```
docker run -p 8080:8080 spring-native-demo:0.0.1-SNAPSHOT
```
