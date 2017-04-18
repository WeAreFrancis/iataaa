# IAtaaa

Iataaa Server is web platform to manage artificial intelligence game. The name IAtaaa stands for the IA (Intelligence Artificielle in french) acronym and the Yatta japanese word for "We did it".

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

Navigate to [http://http://localhost:8761](http://http://localhost:8761) to see registry of micro-services.

## Contributor
* Anthony GODIN <gdn.anthony@gmail.com>
