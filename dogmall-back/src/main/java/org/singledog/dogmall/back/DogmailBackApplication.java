package org.singledog.dogmall.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@ComponentScan("org.singledog.dogmall")
public class DogmailBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogmailBackApplication.class, args);
    }

}
