package com.riffworld.demo;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void testShouldExecFunction() {
		DemoFunction demoFn = new DemoFunction();
		String test = demoFn.apply("foo");

		Assertions.assertThat(test).isNotEmpty();
	}
}
