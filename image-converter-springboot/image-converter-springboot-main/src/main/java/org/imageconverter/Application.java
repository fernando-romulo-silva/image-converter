package org.imageconverter;

import static org.springframework.boot.SpringApplication.run;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        run(Application.class, args);
    }
}
