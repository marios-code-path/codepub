package com.codepub.demo;

import java.util.function.Function;

// Reverses strings.
public class DemoFunction implements Function<String, String> {

    public String apply(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
