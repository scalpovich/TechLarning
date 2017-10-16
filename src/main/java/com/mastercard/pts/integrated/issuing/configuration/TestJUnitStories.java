package com.mastercard.pts.integrated.issuing.configuration;

import java.util.List;

import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mastercard.testing.mtaf.jbehave.MastercardJBehaveStories;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class TestJUnitStories extends MastercardJBehaveStories {
	private static final Logger logger = LoggerFactory
			.getLogger(TestJUnitStories.class);

	@Override
	public List<String> storyPaths() {
		List<String> paths = new StoryFinder().findPaths(
				CodeLocations.codeLocationFromClass(this.getClass()),
				"**/stories/**/*.story", "");
		return paths;
	}

	@Override
	public ApplicationContext getAnnotatedApplicationContext() {
		return new AnnotationConfigApplicationContext(
				TestAnnotationConfigurationContext.class);
	}

}
