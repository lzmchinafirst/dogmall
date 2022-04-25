package org.singledog.dogmail.pms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;

@RefreshScope
@MapperScan("org.singledog.dogmail.pms.mapper")
@SpringBootApplication
@ComponentScan("org.singledog.dogmail")
public class DogmailPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogmailPmsApplication.class, args);
    }

}
