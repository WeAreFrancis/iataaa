# IAtaaa

Iataaa Server is web platform to manage artificial intelligence game. The name IAtaaa stands for the IA (Intelligence Artificielle in french) acronym and the Yatta japanese word for "We did it".

## Architecture
We test a microservice architecture with Spring-Cloud. Actually we have only one service. 

### Aiplayer-service.
You can manage artificial intelligence informations like its ip, port, difficulty etc...


### API Gateway 
Expose (future) multiple services to client. It accessible on http://172.16.0.50:8080.
| Service | Location |
| ------ | ------ |
| Aiplayer-service | http://172.16.0.50:8080/aiplayer-service/players|

### Registry
Locate services for the purpose of load balancing and failover of middle-tier servers. We use [Eureka](https://github.com/Netflix/eureka).
Navigate to http://172.16.0.30:8761 to see registry of services.

### Config
We use [Spring Config](https://github.com/spring-cloud/spring-cloud-config) for externalized configuration in a distributed system.

## Getting Started
### Requirements
* Maven
* Docker

### Building the project
Execute in the root directory to build maven project:
```sh
$ mvn clean package 
```
### Deploy the project
Execute in the root directory to deploy micro-services:
```sh
$ docker-compose up --build
```

## Contributor
* Anthony GODIN <gdn.anthony@gmail.com>
