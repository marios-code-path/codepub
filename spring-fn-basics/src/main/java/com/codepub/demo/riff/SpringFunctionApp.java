package com.codepub.demo.riff;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
import java.util.function.Function;

@Log
@SpringBootApplication
public class SpringFunctionApp {

    public static void main(String ...args) {
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
    public OpVerify opVerifier() {
        return new OpVerify();
    }

}

@Log
class OpVerify implements Function<Op, Boolean> {
    public Boolean apply(Op op) {
        if(op!=null) {
            log.info("op name: " + op.getName());
            log.info("op id: " + op.getId());
            return true;
        }
        else {
            return false;
        }
    }
}

@ToString
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
class Op {
    Long id;
    String name;
}