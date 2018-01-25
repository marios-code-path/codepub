package com.codepub.demo.riff.function;

import java.util.function.Function;
import java.util.stream.Stream;
import org.springframework.cloud.function.core.*;

public class RandomStreamFunction implements FluxFunction<String, String> {
    public Flux<String> apply(String strCnt) {
        int count = Integer.parseInt(strCnt);
        if (count < 1) {
            return Flux.empty();
        }

        //TODO: is there another way without streams ?
        return Flux
                .fromStream(
                        Stream.generate(() -> randomString())
                               .limit(count)
                );
    }

    String randomString() {
        return System.currentTimeMillis() + " :: ";
    }
}
