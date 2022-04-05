package org.singledog.dogmail.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.singledog.dogmail")
public class DogmailBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogmailBackApplication.class, args);
    }

}
