package com.codepub.demo;

import java.util.function.Supplier;

public class DemoSupplier implements Supplier<String> {
    public String get() {
        return "SPECTRE_WAS_NOT_HERE";
    }
}
