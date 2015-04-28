package com.diffplug.gradle.spotless.java;

import java.io.File;

import org.gradle.api.GradleException;
import org.junit.Test;

import com.diffplug.gradle.spotless.ResourceTest;

public class EclipseFormatterStepTest extends ResourceTest {
	@Test
	public void loadPropertiesSettings() throws Throwable {
		// setting for the formatter
		EclipseFormatterStep step = EclipseFormatterStep.load(createTestFile("formatter.properties"));
		assertStep(step::format, "JavaCodeUnformatted.test", "JavaCodeFormatted.test");
	}

	@Test
	public void loadXmlSettings() throws Throwable {
		// setting for the formatter
		EclipseFormatterStep step = EclipseFormatterStep.load(createTestFile("formatter.xml"));
		assertStep(step::format, "JavaCodeUnformatted.test", "JavaCodeFormatted.test");
	}

	@Test(expected = GradleException.class)
	public void loadUnknownSettings() throws Exception {
		EclipseFormatterStep.load(new File("formatter.unknown"));
	}
}
