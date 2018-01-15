package com.codepub.test.riff;

import com.codepub.demo.riff.DemoFunction;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DemoApplicationTests {

	@Test
	public void testShouldExecFunction() {
		String sample = "foo";
		DemoFunction demoFn = new DemoFunction();
		Integer length = demoFn.apply(sample);

		Assertions.assertThat(length).isEqualTo(sample.length());
	}
}
