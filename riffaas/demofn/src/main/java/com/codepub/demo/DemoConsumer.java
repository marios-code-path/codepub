package com.codepub.demo;

import lombok.extern.java.Log;

import java.util.function.Consumer;

// Computes something thats logic.
// or not!
@Log
public class DemoConsumer implements Consumer<String> {

    public void accept(String s) {
        log.info(s);
    }
}