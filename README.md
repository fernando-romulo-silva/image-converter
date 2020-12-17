# image-converter

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Twitter](https://img.shields.io/twitter/follow/nandao_romulo.svg?style=social&logo=twitter)](https://twitter.com/intent/follow?screen_name=nandao_romulo)

# Author

[Fernando Romulo da Silva](https://www.linkedin.com/in/fernando-romulo-da-silva-253678136/)

[<img src="https://img.shields.io/badge/twitter-%231DA1F2.svg?&style=for-the-badge&logo=twitter&logoColor=white" />](https://twitter.com/USERNAME) [<img src="https://img.shields.io/badge/medium-%2312100E.svg?&style=for-the-badge&logo=medium&logoColor=white" />](https://medium.com/USERNAME)  [<img src="https://img.shields.io/badge/linkedin-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white" />](https://www.linkedin.com/in/USERNAME/) [<img src = "https://img.shields.io/badge/instagram-%23E4405F.svg?&style=for-the-badge&logo=instagram&logoColor=white">](https://www.instagram.com/USERNAME/) [<img src = "https://img.shields.io/badge/facebook-%231877F2.svg?&style=for-the-badge&logo=facebook&logoColor=white">](https://www.facebook.com/USERNAME)

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
