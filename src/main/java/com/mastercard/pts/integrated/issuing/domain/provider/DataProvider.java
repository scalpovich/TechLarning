package com.mastercard.pts.integrated.issuing.domain.provider;

import com.fasterxml.jackson.core.type.TypeReference;

public interface DataProvider {
	
	/**
	 * Creates new instance of <code>typeToLoad</code>, loads data by <code>key</code> applying 
	 * merging and patching. Data will be loaded in this order:
	 * <ul>
	 * <li>config/Data/Baseline/${key}.json</li>
	 * <li>config/Data/Baseline/${key}.${tag1..n}.json</li>
	 * <li>config/${env}/Data/${key}.json</li>
	 * <li>config/${env}/Data/${key}.${tag1..n}.json</li>
	 * <li>config/Data/${StoryName}/${key}.json</li>
	 * <li>config/Data/${StoryName}/${key}.${tag1..n}.json</li>
	 * </ul>
	 * If file doesn't exist it is skipped during processing. Last update wins.
	 * @param typeToLoad defines the class of object where data will be loaded
	 * @param key defines initial data file
	 * @param tags defines extra data files to merge/patch initial one
	 * @return instance of <code>typeToLoad</code> with data loaded
	 * @see <a href="https://tools.ietf.org/html/rfc6902" >RFC 6902 (JSON Patch)</a>
	 * <a href="https://tools.ietf.org/html/rfc7386" >RFC 7386 (JSON Merge Patch)</a>
	 */
	<T> T getData(Class<T> typeToLoad, String key, String... tags);
	
	/**
	 * Loads data in class specified with <code>typeReference</code> using {@link #getData(Class, String, String...)}.
	 * For example <pre><code>
	 * {@code List<Program>} programs = provider.getData(new {@code TypeReference<List<Program>>}() {}, "Programs");
	 * </code></pre>
	 * @param typeReference defines generic class of object where data will be loaded 
	 * @param key key defines initial data file
	 * @param tags defines extra data files to merge/patch initial one
	 * @return instance of class specified with <code>typeReference</code> with data loaded
	 */
	<T> T getData(TypeReference<T> typeReference, String key, String... tags);
	
	/**
	 * Loads data with simple name of <code>typeToLoad</code> as a key using {@link #getData(Class, String, String...)}.
	 * @param typeToLoad defines the class of object where data will be loaded
	 * @param tags defines extra data files to merge/patch initial one
	 * @return instance of <code>typeToLoad</code> with data loaded
	 */
	default <T> T getDataBySimpleClassName(Class<T> typeToLoad, String... tags) {
		return getData(typeToLoad, typeToLoad.getSimpleName(), tags);
	}
	
	<T> T getData(Class<T> typeToLoad, String key,String institutionCode,String institutionName, String... tags);
	
	default <T> T getDataBySimpleClassNameForInstitute(Class<T> typeToLoad,String key,String value, String... tags) {
		return getData(typeToLoad, typeToLoad.getSimpleName(),key,value, tags);
	}
}
