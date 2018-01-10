package com.riffworld.demo;

import java.util.function.Function;

public class DemoFunction implements Function<String, String>{
    @Override
    public String apply(String s) {
        return "s"+"2";
    }
}
