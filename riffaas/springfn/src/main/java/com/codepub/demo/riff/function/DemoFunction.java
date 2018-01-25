package com.codepub.demo.riff.function;

import java.util.function.Function;

public class DemoFunction implements Function<String, String> {
    public String apply(String words) {
        return "DEMO" + words.toUpperCase();
    }
}
