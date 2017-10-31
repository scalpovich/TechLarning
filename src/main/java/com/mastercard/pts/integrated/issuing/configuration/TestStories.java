package com.mastercard.pts.integrated.issuing.configuration;

import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mastercard.pts.integrated.issuing.utils.CustomRallyReport;
import com.mastercard.testing.mtaf.ui.MastercardUIStories;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public class TestStories extends MastercardUIStories {
	protected final Logger log = Logger.getLogger(getClass());
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
	
	@Override
	public Embedder configuredEmbedder() {
		String testSetID = System.getProperty("testsetid");
		Embedder embedder = super.configuredEmbedder();	
		if(testSetID != null)
			embedder.useMetaFilters(Arrays.asList("groovy: TestId in ["+getResolveTestCaseID(testSetID)+"]"));
		
		return embedder;
	}
	
	public String getResolveTestCaseID(String testSetID) 
	{
		CustomRallyReport customRally = new CustomRallyReport();
		String testList = "";
		LinkedList<String> list = customRally.getTestIDByTestSetID(testSetID);		    
		for(String s:list)
		{
			testList = testList + s.replace("\"", "'") + ",";			
		}	
		return testList.substring(0, testList.lastIndexOf(","));
	}


}
