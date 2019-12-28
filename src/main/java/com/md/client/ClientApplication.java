package com.md.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ClientApplication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ClientApplication.class);
        //支持生成 pid 文件
        springApplication.addListeners(new ApplicationPidFileWriter("client.pid"));
        springApplication.run(ClientApplication.class, args);
    }

}
