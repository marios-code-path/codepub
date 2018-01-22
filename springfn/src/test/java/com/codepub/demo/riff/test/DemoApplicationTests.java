package com.codepub.demo.riff.test;

import com.codepub.demo.riff.function.DemoFunction;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@DirtiesContext
//@TestPropertySource(properties = "function.uri=file:target/test-classes"
//        + "?handler=com.codepub.demo.riff.function.SpringDemoFunction,com.codepub.demo.riff.function.DemoFunction")
public class DemoApplicationTests {
//    @Autowired
//    private TestRestTemplate rest;
//
//    public void testShouldPipe() throws Exception {
//        String sample = "foo";
//        String sampleComplete = "foo received!";
//        ResponseEntity<String> result = rest.exchange(RequestEntity.post(new URI("/"))
//                .contentType(MediaType.TEXT_PLAIN).body(sample), String.class);
//        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(result.getBody()).isEqualTo(sampleComplete.length());
//
//    }

    @Test
    public void testShouldExecFunction() {
        String sample = "foo";
        DemoFunction demoFn = new DemoFunction();
        String length = demoFn.apply(sample);

        Assertions.assertThat(length).isEqualTo("DEMOFOO");
    }

}
