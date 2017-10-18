package com.mastercard.pts.integrated.issuing.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.springframework.context.ApplicationContext;

import com.mastercard.testing.mtaf.jbehave.alm.ALMReport;
import com.mastercard.testing.mtaf.jbehave.alm.ALMService;
import com.mastercard.testing.mtaf.jbehave.commercial.PropertyExamplesTableConverter;
import com.mastercard.testing.mtaf.jbehave.commercial.PropertyObjectParameterConverter;
import com.mastercard.testing.mtaf.jbehave.commercial.PropertyParameterConverter;
import com.mastercard.testing.mtaf.jbehave.configuration.custom.report.MCCustomFormat;
import com.mastercard.testing.mtaf.jbehave.serenity.SerenitySupport;
import com.mastercard.testing.mtaf.serenity.configuration.SerenityStoryBuilder;

public abstract class CustomJBehaveStories extends JUnitStories {
	private final Integer DEFAULT_STORY_TIMEOUT_SECS = Integer.valueOf(7200);

	private final Logger log = Logger.getLogger(super.getClass());
	private ApplicationContext applicationContext;
	protected static Logger LOGER = Logger	.getLogger(CustomJBehaveStories.class);
	protected ApplicationContext context;

	public CustomJBehaveStories() {
		this.context = getContextInstance();

		Embedder embedder = configuredEmbedder();
		embedder.embedderControls().doIgnoreFailureInStories(true)
		.useStoryTimeoutInSecs(getStoryTimeOutInSecs())
		.doFailOnStoryTimeout(false).doGenerateViewAfterStories(true)
		.doIgnoreFailureInView(false).doVerboseFailures(true);
	}

	@Override
	public Configuration configuration() {
		return new MostUsefulConfiguration()
		.useStoryReporterBuilder(getStoryReporterBuilder())
		.useStoryControls(
				new StoryControls().doResetStateBeforeScenario(true))
				.useParameterControls(
						new ParameterControls()
						.useDelimiterNamedParameters(true))
						.useParameterConverters(getConverters());
	}

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new SpringStepsFactory(configuration(), this.context);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<String> storyPaths() {
		List paths = null;
		String storyName = System.getProperty("storyName");
		if (StringUtils.isNotEmpty(storyName)) {
			paths = new StoryFinder().findPaths(
					CodeLocations.codeLocationFromClass(super.getClass()),
					"**/stories/" + storyName, "");
		} else {
			paths = new StoryFinder().findPaths(
					CodeLocations.codeLocationFromClass(super.getClass()),
					"**/stories/*.story", "");
		}

		return paths;
	}

	protected Format[] storyFormat() {
		LOGER.info("Creating bean Format[]");
		String storyFormats = System.getProperty("story.formats");

		if (storyFormats != null) {
			StringTokenizer strs = new StringTokenizer(storyFormats, ",");

			Format[] formats = new Format[strs.countTokens()];
			LOGER.info("formats.length=" + formats.length);

			return getFormatType(strs, formats);
		}

		return new Format[] { Format.IDE_CONSOLE, Format.STATS,
				new MCCustomFormat(getContextInstance().getEnvironment()),
				Format.XML };
	}

	private Format[] getFormatType(StringTokenizer strs, Format[] formats) {
		int i = 0;

		while (strs.hasMoreTokens()) 
		{
			String format = strs.nextToken().toUpperCase();

			if (format.equals(Format.ANSI_CONSOLE.name())) {
				formats[i] = Format.ANSI_CONSOLE;
			} else if (format.equals(Format.CONSOLE.name())) {
				formats[i] = Format.CONSOLE;
			} else if (format.equals(Format.IDE_CONSOLE.name())) {
				formats[i] = Format.IDE_CONSOLE;
			} else if (format.equals(Format.HTML.name())) {
				formats[i] = Format.HTML;
			} else if (format.equals(Format.STATS.name())) {
				formats[i] = Format.STATS;
			} else if (format.equals(Format.TXT.name())) {
				formats[i] = Format.TXT;
			} else if (format.equals(Format.XML.name())) {
				formats[i] = Format.XML;
			} else if (format.equals(Format.XML_TEMPLATE.name())) {
				formats[i] = Format.XML_TEMPLATE;
			} else {
				--i;
				LOGER.warn("Not a valid format:" + format);
			}
			++i;
		}

		return getFormat(formats, i);
	}

	private Format[] getFormat(Format[] formats, int i) {
		if (i != formats.length) 
		{
			LOGER.info("Actual length with valid type" + i);

			Format[] result = new Format[i];
			int j = 0;
			for (Format format : formats) 
			{
				result[(j++)] = format;
				if (j == i) {
					break;
				}
			}
			for (Format format : result) 
			{
				LOGER.info("Format:" + format);
			}
			return result;
		}
		return formats;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected ParameterConverters getConverters() {
		List converters = new ArrayList();
		converters.add(new PropertyParameterConverter(this.context
				.getEnvironment()));
		converters.add(new PropertyExamplesTableConverter(this.context
				.getEnvironment()));
		converters.add(new PropertyObjectParameterConverter(this.context
				.getEnvironment()));
		return new ParameterConverters().addConverters(converters);
	}

	protected StoryReporter[] getReporters() {
		if (isAlmReportEnabled()) {
			return new StoryReporter[] { getAlmReport() };
		}
		return new StoryReporter[] { new CustomStoryReporter() };
	}

	protected ALMReport getAlmReport() {
		ALMService almService = (ALMService) getContextInstance().getBean(
				ALMService.class);
		return new ALMReport(almService);
	}

	private boolean isAlmReportEnabled() {
		return ((System.getProperty("almIntegration") == null) ? false
				: Boolean.parseBoolean(System.getProperty("almIntegration")));
	}

	protected StoryReporterBuilder getStoryReporterBuilder() {
		if (SerenitySupport.isSerenityIntegrationEnabled()) {
			return new SerenityStoryBuilder().withFormats(storyFormat())
					.withReporters(getReporters());
		}

		return new StoryReporterBuilder().withFormats(storyFormat())
				.withReporters(getReporters())
				.withFailureTraceCompression(true);
	}

	public long getStoryTimeOutInSecs() {
		try {
			return  (System.getProperty("jbehave.story.timeout") == null) ? this.DEFAULT_STORY_TIMEOUT_SECS
					.intValue() : Integer.parseInt(System
							.getProperty("jbehave.story.timeout"));
		} catch (NumberFormatException ex) {
			this.log.error(
					"Invalid format for 'jbehave.story.timeout' parameter.", ex);
		}
		return this.DEFAULT_STORY_TIMEOUT_SECS.intValue();
	}

	protected ApplicationContext getContextInstance() {
		if (this.applicationContext == null) {
			this.applicationContext = getAnnotatedApplicationContext();
		}
		return this.applicationContext;
	}

	public abstract ApplicationContext getAnnotatedApplicationContext();
}