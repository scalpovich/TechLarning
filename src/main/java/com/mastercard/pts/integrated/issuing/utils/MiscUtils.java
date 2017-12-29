package com.mastercard.pts.integrated.issuing.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Strings;
import com.mastercard.pts.integrated.issuing.utils.simulator.SimulatorConstantsData;

public class MiscUtils {

	private MiscUtils() {
	}

	public static String humanizedToConstant(String text) {
		return text.replaceAll(" ", "_").replaceAll("\\W", "").toUpperCase();
	}

	public static int randomNumber(int number) {
		return Integer.parseInt(RandomStringUtils.randomNumeric(number));
	}

	public static boolean renamePinFile(String A) {
		File oldfile =new File(A);
		File newfile =new File(A +"_PinFile");
		return oldfile.renameTo(newfile);
	}
	
	public static String generateRandomNumberAsString(int number) {
		return RandomStringUtils.randomNumeric(number);
	}

	public static Boolean isProcessRuning(String taskName) {
		try {
			String line;
			Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) {
				if (line.toUpperCase().contains(taskName.toUpperCase())) {
					input.close();
					return true;
				}
			}
			input.close();
			p.destroy();
		} catch (Exception e) {
			MiscUtils.propagate(e);
			return false;
		}
		return false;
	}

	public static void killProcessFromTaskManager(String taskName) {
		try {
			String temptaskName = null;
			String command = null;
			if ("FINSIM".equalsIgnoreCase(taskName)) {
				temptaskName = SimulatorConstantsData.KILL_FINSIM_PROCESS;
			} else if ("MCPS".equalsIgnoreCase(taskName)) {
				temptaskName = SimulatorConstantsData.KILL_MCPS_PROCESS;
			} else if ("MAS".equalsIgnoreCase(taskName)) {
				temptaskName = SimulatorConstantsData.KILL_MAS_PROCESS;
			} else if ("WINIUM".equalsIgnoreCase(taskName)) {
				temptaskName = SimulatorConstantsData.KILL_WINIUM_PROCESS;
			} else if ("VTS".equalsIgnoreCase(taskName)) {
				temptaskName = SimulatorConstantsData.KILL_VTS_PROCESS;
			} else if ("MDFS".equalsIgnoreCase(taskName)) {
				temptaskName = SimulatorConstantsData.KILL_MDFS_PROCESS;
			}
			command = "taskkill /F /IM " + temptaskName + ".exe";
			Runtime.getRuntime().exec(command).waitFor(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw MiscUtils.propagate(e);
		}
	}

	public static String generateRandomNumberBetween2Number(int startingNumber, int endNumber) {
		Random r = new Random();
		int low = startingNumber;
		int high = endNumber;
		return Integer.toString(r.nextInt(high - low) + low);
	}

	public static String randomAlphabet(int alphabetLenth) {
		return RandomStringUtils.randomAlphabetic(alphabetLenth);
	}
	
	public static Boolean isNotNullAndEmpty(String variable) {
		return Strings.isNullOrEmpty(variable);
	}

	public static void reportToConsole(String message) {
		System.out.println(message);
	}

	public static void reportToConsole(String message1, String message) {
		reportToConsole(message1 + " : " + message);
	}

	public static String generate10CharAlphaNumeric() {
		return ("TA" + MiscUtils.generateRandomNumberBetween2Number(1000, 9999) + MiscUtils.randomAlphabet(4)).toUpperCase();
	}

	public static String generate8CharAlphaNumeric() {
		return ("TA" + MiscUtils.generateRandomNumberBetween2Number(1000, 9999) + MiscUtils.randomAlphabet(2)).toUpperCase();
	}

	public static String generate6CharAlphaNumeric() {
		return ("T" + MiscUtils.generateRandomNumberBetween2Number(1000, 9999) + MiscUtils.randomAlphabet(1)).toUpperCase();
	}

	public static String convertToYYMM(String data) {
		return data.substring(2) + data.subSequence(0, 2);
	}

	/**
	 * Iterates through String constants defined in class and returns value
	 * which starts with prefix ignoring case.
	 * 
	 * @param cls
	 * @param prefix
	 * @return constant string value
	 */
	public static String getConstantStringFromClassByPefixMatch(Class<?> cls, String prefix) {
		Predicate<Integer> isConstant = modifiers -> Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
		return Arrays.stream(cls.getDeclaredFields()).filter(f -> isConstant.test(f.getModifiers()) && f.getType().equals(String.class))
				.map(f -> propagate(() -> (String) f.get(null))).filter(s -> StringUtils.startsWithIgnoreCase(s, prefix)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException(prefix));
	}

	public static <T> T propagate(ThrowingSupplier<T> supplier) {
		try {
			return supplier.get();
		} catch (Exception e) {
			throw propagate(e);
		}
	}

	@FunctionalInterface
	public interface ThrowingSupplier<T> {
		T get() throws Exception; // NOSONAR: utility to handle generic exceptions
	}

	public static RuntimeException propagate(Throwable throwable) {
		throw new RuntimeException(throwable); // NOSONAR: utility to handle generic exceptions
	}

	@SuppressWarnings("unchecked")
	public static Map<String, String> namedGroups(Matcher matcher) {
		Map<String, Integer> indexes = null;
		try {
			Method method = Pattern.class.getDeclaredMethod("namedGroups");
			method.setAccessible(true);
			indexes = (Map<String, Integer>) method.invoke(matcher.pattern());
		} catch (Exception e) {
			throw propagate(e);
		}
		return indexes.entrySet().stream().collect(Collectors.toMap(Entry::getKey, e -> matcher.group(e.getValue())));
	}

	public static String toString(Object object) {
		return ReflectionToStringBuilder.toString(object, ToStringStyle.MULTI_LINE_STYLE);
	}
}
