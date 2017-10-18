package com.mastercard.pts.integrated.issuing.utils;

import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;

public class NewStoryReporterBuilder extends StoryReporterBuilder {

@Override
public StoryReporter build(String storyPath) {
	
    @SuppressWarnings("unused")
	StoryReporter delegate = super.build(storyPath);
    return new CustomStoryReporter();
}

}