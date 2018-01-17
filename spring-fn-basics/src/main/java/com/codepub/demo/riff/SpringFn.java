package com.codepub.demo.riff;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.function.Function;

@Log
class SpringFn implements Function<String, String> {

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

    public String apply(String op) {
        return op + " received!";
    }
}
