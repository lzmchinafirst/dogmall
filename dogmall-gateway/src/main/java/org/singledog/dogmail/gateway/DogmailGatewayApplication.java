package org.singledog.dogmail.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("org.singledog.dogmail")
@SpringBootApplication
public class DogmailGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogmailGatewayApplication.class, args);
    }
}
