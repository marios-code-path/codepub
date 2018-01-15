package com.codepub.demo.riff;

import java.util.function.Function;

public class DemoFunction implements Function<String, Integer> {
    public Integer apply(String words) {
        return words.length();
    }
}
