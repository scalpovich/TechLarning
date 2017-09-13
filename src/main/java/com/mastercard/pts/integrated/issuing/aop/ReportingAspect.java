package com.mastercard.pts.integrated.issuing.aop;

import java.util.Arrays;
import java.util.stream.Collectors;

import net.thucydides.core.steps.ExecutedStepDescription;
import net.thucydides.core.steps.StepArgumentWriter;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.core.steps.StepFailure;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Aspect
@Component
public class ReportingAspect {

	private static final Logger logger = LoggerFactory.getLogger(ReportingAspect.class);

	@Around("execution(public * *(..)) && @within(com.mastercard.pts.integrated.issuing.annotation.Workflow)")
	public Object proceedStep(ProceedingJoinPoint pjp) {
		try {
			if (isScenarioRunning()) {
				return proceedAndReportStep(pjp);
			}
			return pjp.proceed();
		} catch (Throwable e) {
			throw MiscUtils.propagate(e);
		}
	}

	private boolean isScenarioRunning() {
		return StepEventBus.getEventBus().resultSoFar().isPresent();
	}

	private Object proceedAndReportStep(ProceedingJoinPoint pjp) {
		Object output = null;
		ExecutedStepDescription description = null;
		try {
			description = notifyStepStarted(pjp);
			output = pjp.proceed();
			notifyStepPassed();
		} catch (Throwable e) {
			notifyStepFailed(description, e);
			throw MiscUtils.propagate(e);
		} 
		return output;
	}

	private void notifyStepPassed() {
		StepEventBus.getEventBus().stepFinished();
	}

	private void notifyStepFailed(ExecutedStepDescription description, Throwable cause) {
		if (!StepEventBus.getEventBus().aStepInTheCurrentTestHasFailed()) {
			logger.error("Step failed", cause);
		}

		StepFailure failure = new StepFailure(description, cause);
		StepEventBus.getEventBus().stepFailed(failure);
	}

	private ExecutedStepDescription notifyStepStarted(ProceedingJoinPoint pjp) {
		ExecutedStepDescription description = ExecutedStepDescription.of(pjp.getThis().getClass(),
				getTestNameFrom(pjp), pjp.getArgs());
		StepEventBus.getEventBus().stepStarted(description);
		return description;
	}

	private String getTestNameFrom(ProceedingJoinPoint pjp) {
		String methodName = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		if ((args == null) || (args.length == 0)) {
			return methodName;
		}

		String argsDescription = Arrays.stream(args).map(StepArgumentWriter::readableFormOf)
				.collect(Collectors.joining(", "));
		return String.format("%s: %s", methodName, argsDescription);
	}
}
