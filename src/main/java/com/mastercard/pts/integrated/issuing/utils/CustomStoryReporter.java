package com.mastercard.pts.integrated.issuing.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.GivenStories;
import org.jbehave.core.model.Lifecycle;
import org.jbehave.core.model.Meta;
import org.jbehave.core.model.Narrative;
import org.jbehave.core.model.OutcomesTable;
import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;
import org.jbehave.core.model.StoryDuration;
import org.jbehave.core.reporters.StoryReporter;

import com.mastercard.testing.mtaf.jbehave.alm.AlmReportScenario;

import static com.mastercard.testing.mtaf.jbehave.alm.AlmReportScenario.Verdict.Fail;
import static com.mastercard.testing.mtaf.jbehave.alm.AlmReportScenario.Verdict.Pass;

public class CustomStoryReporter implements StoryReporter {
    protected final Logger log = Logger.getLogger(getClass());
    protected CustomRallyReport rallyALM;
    protected HashMap<String, AlmReportScenario> exampleResults;
    protected boolean isExample;
    protected ThreadLocal<Boolean> runningStoryStatus = new ThreadLocal<>();
    protected ThreadLocal<Boolean> runningScenarioStatus = new ThreadLocal<>();
    protected ThreadLocal<Story> storyThreadLocal = new ThreadLocal<>();
    protected ThreadLocal<AlmReportScenario> almScenarioContext = new ThreadLocal<>();
    protected ThreadLocal<Scenario> jBehaveScenarioContext = new ThreadLocal<>();

    public CustomStoryReporter() {
    	if (isRallyReportingEnabled()) {
    		rallyALM = new CustomRallyReport();
    	}
    }
    
    protected boolean isRallyReportingEnabled() {
    	return System.getProperty("testsetid") != null;
    }
    
    @Override 
    public void storyNotAllowed(Story story, String filter) {
        log.info(String.format("%s (NOT ALLOWED [filter: %s])", story, filter));
    }

    @Override
    public void storyCancelled(Story story, StoryDuration storyDuration) {
        log.info(String.format("%s (CANCELLED [duration: %s])", story, storyDuration));
    }
    

    @Override
    public void beforeStory(Story story, boolean givenStory) {
        if (givenStory) {
            // Given Story is invoked when actual story already began.
            // Thus, if we set a thread local story to a given story,
            // It will overwrite the actual (invoking) story. So, just ignoring.
            return;
        }

        storyThreadLocal.set(story);

        if (!story.getName().equals("BeforeStories") &&
                !story.getName().equals("AfterStories")) {
            runningStoryStatus.set(true);
            runningScenarioStatus.set(true);
            reportBeforeStory(story);
        }
    }

    protected void reportBeforeStory(Story story) {
        log.info("=====================================================");
        log.info("Begin Story: " + story.getName() + "============ ");
        log.info("=====================================================");
    }

    @Override
    public void afterStory(boolean givenStory) {
        if (givenStory) {
            return;
        }

        Story story = storyThreadLocal.get();

        if (story == null) {
            log.warn("Story has not been set!");
            return;
        }

        if (story.getName() != null &&
                !story.getName().equals("BeforeStories") &&
                !story.getName().equals("AfterStories")) {
            reportAfterStory(storyThreadLocal.get());
        }
    }

    protected void reportAfterStory(Story story) {
        String status = runningStoryStatus.get() ? " PASSED " : " FAILED ";
        log.info("====================================================");
        log.info("End Story:  " + story.getName());
        log.info("Status: " + status);
        log.info("====================================================");
    }

    @Override
    public void narrative(Narrative narrative) {
        log.info(narrative);
    }

    @Override
    public void lifecyle(Lifecycle lifecycle) {
        log.info(String.format("== Executing lifecycle:%s ==", lifecycle));
    }

    @Override
    public void scenarioNotAllowed(Scenario scenario, String filter) {
        log.info(String.format("%s (NOT ALLOWED [filter: %s])", scenario, filter));
    }

    @Override
    public void beforeScenario(String scenarioTitle) {
        log.info(String.format("===> Executing scenario: %s", scenarioTitle));   
        if (storyThreadLocal.get() != null) {
        	exampleResults= new HashMap<>();
        	isExample=false;
            Scenario scenario = findScenario(storyThreadLocal.get(), scenarioTitle);
            jBehaveScenarioContext.set(scenario);
            almScenarioContext.set(new AlmReportScenario(scenario));
            log.info(String.format("===> Test ID: %s", almScenarioContext.get().getTestCaseID())); 
        } else {
            jBehaveScenarioContext.set(null);
            almScenarioContext.set(null);
        }
        
    }

    private Scenario findScenario(Story story, String scenarioTitle) {
        for (Scenario scenario : story.getScenarios()) {        
            if (scenario.getTitle().equals(scenarioTitle)) {
                return scenario;
            }
        }
        return null;
    }
    
    @Override
    public void scenarioMeta(Meta meta) {
        log.info(String.format("** Scenario meta is:%s **", meta));
    }

    @Override
    public void afterScenario() {
    	 String verdict = runningScenarioStatus.get() ? " PASSED " : " FAILED ";
    	 log.info("<=== Scenario finished. Verdict is "+verdict);  
    	 verdict = resolveVerdict(verdict);
    	 if ((isRallyReportingEnabled() && isExample != true && almScenarioContext.get() != null && !almScenarioContext.get().getTestCaseID().equals(StringUtils.EMPTY))) {            	
         	rallyALM.updateTestResult(almScenarioContext.get(), verdict);    
         }
    }

    public String resolveVerdict(String verdict)
    {
		//Valid values are: [ Fail, Inconclusive, Blocked, Pass, Error ]
    	String status ;
		if(verdict.trim().equalsIgnoreCase("passed"))
			status = "Pass";
		else if(verdict.trim().equalsIgnoreCase("failed"))
			status = "Fail";
		else if(verdict.trim().equalsIgnoreCase("Blocked"))
			status = "Blocked";
		else 
			status ="Error";
		
		return status;    	
    }
    
    @Override
    public void successful(String step) {
      	runningScenarioStatus.set(true);
        runningStoryStatus.set(true);
        almScenarioContext.get().setVeredict(Pass);
        exampleResults.put(almScenarioContext.get().getTestCaseID(), almScenarioContext.get());
        log.info(String.format("%s (SUCCESSFUL)", step));
    }

    @Override
    public void ignorable(String step) {
        log.info(String.format("%s (IGNORED)", step));
    }

    @Override
    public void pending(String step) {
        log.info(String.format("%s (PENDING)", step));
    }

    @Override
    public void notPerformed(String step) {
        log.info(String.format("%s (NOT PERFORMED)", step));
    }

    @Override
    public void failed(String step, Throwable cause) {
    	runningScenarioStatus.set(false);
        runningStoryStatus.set(false);
        almScenarioContext.get().setVeredict(Fail);
        exampleResults.put(almScenarioContext.get().getTestCaseID(), almScenarioContext.get());
        log.info(String.format("%s (FAILED)", step));
    }

	@Override
	public void givenStories(GivenStories givenStories) {
		log.info(String.format("%s","givenStories executed"));
		
	}

	@Override
	public void givenStories(List<String> storyPaths) {
		log.info(String.format("%s","givenStories executed"));
		
	}

	@Override
	public void beforeExamples(List<String> steps, ExamplesTable table) {
		log.info(String.format("%s","beforeExamples executed"));
		
	}

	@Override
	public void example(Map<String, String> tableRow) {
		String testId = "";
        Story story = storyThreadLocal.get();
        if (story != null) {
            Meta meta = new Meta();
            if (tableRow.containsKey("Meta:")) {
                meta = meta.inheritFrom(Meta.createMeta(tableRow.get("Meta:"), new Keywords()));
                if (meta.hasProperty("TestId")) {
                    isExample = true;
                    Scenario scenario = findScenario(storyThreadLocal.get(), almScenarioContext.get().getTitle());
                    jBehaveScenarioContext.set(scenario);
                    almScenarioContext.set(new AlmReportScenario(scenario));
                    testId = meta.getProperty("TestId");
                    almScenarioContext.get().setTestCaseID(testId);
                    exampleResults.put(testId, almScenarioContext.get());
                }
            }
        }		
	}

	@Override
	public void afterExamples() {
		if(isRallyReportingEnabled())
		{
			for (Map.Entry<String, AlmReportScenario> entry : exampleResults.entrySet()) {
			    AlmReportScenario value = entry.getValue();
			    rallyALM.updateTestResult(value, value.getVerdict());
			    log.info(String.format("%s", "Test ID from Context "+value.getTestCaseID()+" Result : "+value.getVerdict()));
			}		
		}		
	}

	@Override
	public void beforeStep(String step) {
		log.info(String.format("%s","beforeStep executed"));
		
	}

	@Override
	public void failedOutcomes(String step, OutcomesTable table) {
		log.info(String.format("%s","failedOutcomes executed"));
		
	}

	@Override
	public void restarted(String step, Throwable cause) {
		log.info(String.format("%s","restarted executed"));
		
	}

	@Override
	public void dryRun() {
		log.info(String.format("%s","dryRun executed"));
		
	}

	@Override
	public void pendingMethods(List<String> methods) {
		log.info(String.format("%s","pendingMethods executed"));
		
	}
    
}

