package org.singledog.dogmall.pms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;

@RefreshScope
@MapperScan("org.singledog.dogmall.pms.mapper")
@SpringBootApplication
@ComponentScan("org.singledog.dogmall")
public class DogmallPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogmallPmsApplication.class, args);
    }

}
