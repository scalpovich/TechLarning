package com.mastercard.pts.integrated.issuing.steps;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Named;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebDriver.Timeouts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.domain.provider.DataLoader;

@Component
public class TestHooks {
	
	private static final Logger logger = LoggerFactory.getLogger(TestHooks.class);
	
	@Autowired
	private TestContext testContext;
	
	@Autowired
	private WebDriverProvider driverProvider;
	
	@Value("${defailt.wait.implicitly.timeout_in_msec}")
	private long imlicitWaitTimeout;
	
	@Value("${default.wait.page.timeout_in_sec}")
	private long pageWaitTimeout;
	
	@Value("${default.wait.script.timeout_in_sec}")
	private long scriptWaitTimeout;
	
	@Autowired
	private DataLoader dataLoader;
	
	@BeforeStory
	public void initStoryContext(@Named("StoryName") String storyName) {
		testContext.initStoryContext(storyName);
		Optional<Map<String, String>> data = dataLoader.loadData(storyName);
		if (data.isPresent()) {
			testContext.put(TestContext.KEY_STORY_DATA, data.get());
		} else {
			logger.info("There is no data set for story {}", storyName);
		}
	}
	
	@BeforeScenario
	public void initTimeouts() {
		Timeouts timeouts = driverProvider.get().manage().timeouts();
		timeouts.implicitlyWait(imlicitWaitTimeout, TimeUnit.MILLISECONDS);
		timeouts.pageLoadTimeout(pageWaitTimeout, TimeUnit.SECONDS);
		timeouts.setScriptTimeout(scriptWaitTimeout, TimeUnit.SECONDS);
		
		testContext.put("DRIVER", driverProvider.get());
	}
	
	@AfterScenario
	public void clearCookies() {
		driverProvider.get().manage().deleteAllCookies();
	}
	
	@AfterStory
	public void disposeStoryContext() {
		testContext.dispose();
	}
}
