package com.mastercard.pts.integrated.issuing.domain.provider;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.mastercard.pts.integrated.issuing.context.TestContext;
import com.mastercard.pts.integrated.issuing.utils.MiscUtils;

@Component
public class JsonDataProvider implements DataProvider {
	
	private static final String BASELINE_PATH_TEMPLATE = "config/Data/Baseline/%s.json";
	
	private static final String STORY_PATH_TEMPLATE = "config/Data/%s/%%s.json";
	
	private static final Logger logger = LoggerFactory.getLogger(JsonDataProvider.class);
	
	@Value("config/${env}/Data/%s.json")
	private String environmentPathTemplate;
	
	@Autowired
	private TestContext context;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public <T> T getData(Class<T> typeToLoad, String key, String... tags) {
		Preconditions.checkNotNull(typeToLoad, "typeToLoad");
		JsonNode node = loadNode(typeToLoad.getSimpleName(), key, tags);
		try {
			return mapper.treeToValue(node, typeToLoad);
		} catch (JsonProcessingException e) {
			throw MiscUtils.propagate(e);
		}
	}
	
	@Override
	public <T> T getData(TypeReference<T> typeReference, String key, String... tags) {
		Preconditions.checkNotNull(typeReference, "typeReference");
		JavaType type = mapper.getTypeFactory().constructType(typeReference);
		JsonNode node = loadNode(type.getTypeName(), key, tags);
		try {
			return mapper.readValue(mapper.treeAsTokens(node), type);
		} catch (Exception e) {
			throw MiscUtils.propagate(e);
		}
	}
	
	@Override
	public <T> T getData(Class<T> typeToLoad, String key,String institutionCode, String... tags) {
		Preconditions.checkNotNull(typeToLoad, "typeToLoad");
		JsonNode node = loadNodeInstitute(typeToLoad.getSimpleName(), key,institutionCode, tags);
		try {
			return mapper.treeToValue(node, typeToLoad);
		} catch (JsonProcessingException e) {
			throw MiscUtils.propagate(e);
		}
	}
	
	private JsonNode loadNode(String typeName,String key, String... tags) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(key), "key is not provided");
		List<String> keyStream = Stream.concat(Stream.of(key),
				Arrays.stream(tags).map(tag -> String.format("%s.%s", key, tag)))
				.collect(toList());
		
		logger.info("Loading data for {} by keys {}", typeName,
				String.join(", ", keyStream));
		
		Builder<String> builder = Stream.<String>builder()
				.add(BASELINE_PATH_TEMPLATE)
				.add(environmentPathTemplate);
		getStoryPathTemplate().ifPresent(builder::accept);
		
		Stream<String> pathStream = builder.build()
				.flatMap(template -> keyStream.stream()
						.map(keyValue -> String.format(template, keyValue)));
		
		JsonNode node = pathStream
				.<Function<JsonNode, JsonNode>>map(path -> target -> loadAndApplyData(target, path))
				.reduce(Function.identity(), Function::andThen)
				.apply(null);
		return node;
	}
	
	private JsonNode loadNodeInstitute(String typeName,String key,String institutionCode, String... tags) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(key), "key is not provided");
		List<String> keyStream = Stream.concat(Stream.of(key),
				Arrays.stream(tags).map(tag -> String.format("%s.%s", key, tag)))
				.collect(toList());
		
		logger.info("Loading data for {} by keys {}", typeName,
				String.join(", ", keyStream));
		
		Builder<String> builder = Stream.<String>builder()
				.add(BASELINE_PATH_TEMPLATE)
				.add(environmentPathTemplate);
		getStoryPathTemplate().ifPresent(builder::accept);
		
		Stream<String> pathStream = builder.build()
				.flatMap(template -> keyStream.stream()
						.map(keyValue -> String.format(template, keyValue)));
		
		JsonNode node = pathStream
				.<Function<JsonNode, JsonNode>>map(path -> target -> loadAndApplyData(target, path,institutionCode))
				.reduce(Function.identity(), Function::andThen)
				.apply(null);
		return node;
	}
	
	private JsonNode loadAndApplyData(JsonNode target, String path) {
		try {
			return buildJsonNode(target, path);
		} catch (Exception e) {
			throw MiscUtils.propagate(e);
		}
	}
	
	private JsonNode loadAndApplyData(JsonNode target, String path,String institutionCode) {
		try {
			return buildJsonNodeInstitute(target, path,institutionCode);
		} catch (Exception e) {
			throw MiscUtils.propagate(e);
		}
	}

	private JsonNode buildJsonNode(JsonNode target, String path)
			throws IOException, JsonPatchException {
		InputStream inputStream = getResource(path);
		if (inputStream == null) {
			return target;
		}
		
		JsonNode node = mapper.readTree(inputStream);
		
		if (target == null) {
			logger.info("Load data from {}", path);
			return node;
		}
		
		try {
			JsonPatch patch = JsonPatch.fromJson(node);
			logger.info("Patch data from {}", path);
			return patch.apply(target);
		} catch (IOException e) {
			//NO SONAR. It is based on the exception, we are performing other operations so cannot throw this as an error hence Info message
			JsonMergePatch merge = JsonMergePatch.fromJson(node);
			logger.info("Merge data from {}", path);
			return merge.apply(target);
		}
	}
	
	private JsonNode buildJsonNodeInstitute(JsonNode target, String path,String institutionCode)
			throws IOException, JsonPatchException, ParseException {
		InputStream inputStream = getResource(path);
		if (inputStream == null) {
			return target;
		}
		
		JsonNode node = mapper.readTree(inputStream).get("institute");
		JsonNode nodeArray=null;
		if (node.isArray()) {
			for (JsonNode objNode : node) {
				if (objNode.get("code").asText().equals(institutionCode)) {
					nodeArray=objNode;
					return objNode;
				}
			}

		}

		else if (target == null) {
			logger.info("Load data from {}", path);
			return node;
		}
		
		try {
			JsonPatch patch = JsonPatch.fromJson(nodeArray);
			logger.info("Patch data from {}", path);
			return patch.apply(target);
		} catch (IOException e) {
			//NO SONAR. It is based on the exception, we are performing other operations so cannot throw this as an error hence Info message
			JsonMergePatch merge = JsonMergePatch.fromJson(nodeArray);
			logger.info("Merge data from {}", path);
			return merge.apply(target);
		}
	}
	
	private Optional<String> getStoryPathTemplate() {
		return Optional.ofNullable(context.getStoryName())
				.map(story -> String.format(STORY_PATH_TEMPLATE, story));
	}
	
	private InputStream getResource(String classpath) {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(classpath);
		return inputStream;
	}
}
