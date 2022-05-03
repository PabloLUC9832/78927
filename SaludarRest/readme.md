# Instrucciones para que sea ejecutado desde PlayWithDocker

> docker pull rrojano/jdk8

> docker run -it --rm -p 8081:8080 -v /root:/app rrojano/jdk8 bash

> Entrar a la carpeta de SaludarRest

> ./mvnw spring-boot:run

> En en navegador ip/localhost8081/

## Rutas

- /saludar 
- /saludar1/algo
- /saludar2/algo
- /saludarme1
- /saludarme1?nombre=algo
- /saludarme2
- /saludarme2?nombre=algo
- /saludarHtml



