package com.codepub.demo.riff.function;

import com.codepub.demo.riff.SpringFunctionApp;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.function.Function;

@Log
public class SpringDemoFunction implements Function<String, String> {

    @Value("com.codepub.demo.riff.prefix")
    private String prefix;

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
        return "FOO" + " " + op;
    }
}
