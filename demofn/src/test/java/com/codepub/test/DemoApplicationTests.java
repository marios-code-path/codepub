package com.codepub.test;

import com.codepub.demo.DemoFunction;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DemoApplicationTests {

	@Test
	public void testShouldExecFunction() {
		DemoFunction demoFn = new DemoFunction();
		String test = demoFn.apply("foo");

		Assertions.assertThat(test).isNotEmpty();
	}
}
