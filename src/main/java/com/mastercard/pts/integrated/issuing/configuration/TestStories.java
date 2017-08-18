package com.mastercard.pts.integrated.issuing.configuration;

import java.net.URL;
import java.util.List;

import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mastercard.testing.mtaf.ui.MastercardUIStories;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;


@RunWith(JUnitReportingRunner.class)
public class TestStories extends MastercardUIStories {

    @Override
	public ApplicationContext getAnnotatedApplicationContext() {
        return new AnnotationConfigApplicationContext(TestConfiguration.class);
    }
    
    @Override
    public List<String> storyPaths() {
        String storyName = System.getProperty("storyName", "*");
        String lookUpPath = String.format("**/stories/**/%s.story", storyName);
        URL codeLocation = CodeLocations.codeLocationFromClass(this.getClass());
		return new StoryFinder().findPaths(codeLocation, lookUpPath, "");
    }

	@Override
	protected StoryReporterBuilder getStoryReporterBuilder() {
		return super.getStoryReporterBuilder()
				.withFailureTrace(true)
				.withFailureTraceCompression(false);
	}
}
