# IAtaaa

Iataaa Server is web platform to manage artificial intelligence game. The name IAtaaa stands for the IA (Intelligence Artificielle in french) acronym and the Yatta japanese word for "We did it".

## Getting Started
### Requirements
* Docker
* Docker-Compose

### Indication
Use `./mvnw` command instead of `mvn` if you haven't Maven.

### Deploy the project on your computer
Execute in the root directory to build maven project and deploy in docker container:
```sh
mvn clean package 
docker-compose up -d
```
List of deployed services :

Service name | adress
------ | ------ 
aiPlayer database | 172.16.0.15:3306 |
aiPlayer | 172.16.0.20:8080 |

## Develop mode
### To work on aiPlayer-service
Execute in the root directory to run a mysql database:
```sh
cd docker-compose-dev
docker-compose -f docker-compose.aiplayer.yml up -d
```
To run aiPlayer-service, you should add environment variable :

Environment variable | Value
------ | ------ 
DB_IP | 172.16.0.15 |
DB_PORT | 3306 |
DB_DATABASE | iataaa |
DB_USER | iataaa |
DB_PASSWORD | password |

By example, you can run aiPlayer-service like that:
```sh
mvn spring-boot:run -DDB_IP=172.16.0.15 -DDB_PORT=3306 -DDB_DATABASE=iataaa -DDB_USER=iataaa -DDB_PASSWORD=password
```
Open http://localhost:8080 in your browser

### Swagger documentation
The api documentation is accessible to http://localhost:8080/swagger-ui.html

## Architecture
We test a micro-service architecture. Actually we have only one service.

### Aiplayer-service
You can manage artificial intelligence informations like its ip, port, difficulty etc...

## Contributor
* Anthony GODIN <gdn.anthony@gmail.com>
