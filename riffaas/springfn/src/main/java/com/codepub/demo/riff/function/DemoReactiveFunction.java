package com.codepub.demo.riff.function;

import reactor.core.publisher.Flux;

import java.util.function.Function;

public class DemoReactiveFunction implements Function<String, Flux<String>> {

    public Flux<String> apply(String s) {
        return Flux.fromArray(new String[] {"a","b","c","d","e"});
    }
}
