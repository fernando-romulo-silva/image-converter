# image-converter

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Twitter](https://img.shields.io/twitter/follow/nandao_romulo.svg?style=social&logo=twitter)](https://twitter.com/intent/follow?screen_name=nandao_romulo)

# About

A project that converts image text into simple text using diverse technologies.  
I used [tesseract](https://github.com/tesseract-ocr/tesseract) for it and exposes it as a web service using spring boot, jakarta microprofile, quarkus, etc. Each module use some 

# Model
![Model](https://github.com/fernando-romulo-silva/image-converter/blob/master/doc/class-diagram.png)

# Technologies

- Java
- Maven
- Tesseract

## Implantação em produção
- Back end: Heroku

# Modules

## image-converter-springboot

The idea here is to use spring boot with the smallest docker container using spring boot technologies, like layer and modularization.

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/devsuperior/sds1-wmazoni

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw spring-boot:run
```
