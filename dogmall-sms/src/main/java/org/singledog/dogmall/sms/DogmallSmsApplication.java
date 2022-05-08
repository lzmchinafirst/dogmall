package org.singledog.dogmall.sms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("org.singledog.dogmall.sms.mapper")
@ComponentScan("org.singledog.dogmall")
@SpringBootApplication
public class DogmallSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogmallSmsApplication.class, args);
    }

}
