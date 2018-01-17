package com.codepub.demo.riff;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Log
@SpringBootApplication
public class SpringFunctionApp {

    public static void main(String... args) {
        log.info("In the beginning, a context loads.");
        System.out.println("OUT Context load.");
        System.err.println("ERR Context load.");
        SpringApplication.run(SpringFunctionApp.class, args);
    }

    @Autowired
    private ConfigurableApplicationContext context;

    @PostConstruct
    public void init() {
        if (this.context == null) {
            context = new SpringApplicationBuilder(SpringFunctionApp.class).bannerMode(Banner.Mode.OFF).registerShutdownHook(false)
                    .web(false).run();
        }
    }

    @PreDestroy
    public void close() {
        if (context != null) {
            context.close();
        }
    }

    @Bean
    public SpringFn springFn() {
        return new SpringFn();
    }
}

