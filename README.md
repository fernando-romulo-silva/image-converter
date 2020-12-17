# image-converter

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Project status](https://img.shields.io/badge/Project%20status-Maintenance-orange.svg)](https://img.shields.io/badge/Project%20status-Maintenance-orange.svg)

## Project status

I use this project to learn new technologies related to microservices. In this case, the image convert. So it'll get new things all time.


# About

A project that converts image text into simple text using diverse technologies.  
I used [tesseract](https://github.com/tesseract-ocr/tesseract) for it and exposes it as a web service using spring boot, jakarta microprofile, quarkus, etc.

# Model
It's very simple application, just a controller and a service:
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

# How to Execute

requirements: 
 - Java 11
 - Maven 3

```bash
# clone it
git clone https://github.com/fernando-romulo-silva/image-converter

# for spring boot
cd image-converter\image-converter-springboot

# execute
mvn spring-boot:run
```
