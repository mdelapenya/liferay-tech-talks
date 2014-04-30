package io.github.migue.java8.streams.optional;

import java.util.*;

/**
 * An optional type is a wrapper for an object of type T, or no object.
 *
 * It pretends to be a safer alternative than null references (but you need
 * to be careful anyhow)
 *
 * @author Miguel Pastor
 */
public class OptionalType {
	public static final List<String> WORDS =
		Arrays.asList("java", "jvm", "java8", "programming", "tech-talks");

	public static void main(String[] args) {
		// "Default" usage
		Optional<String> result =
			WORDS.stream().parallel().filter(word -> word.length() > 11).findAny();

		// This line is no safer than String s = ...; s.toString();
		result.get().toString();

		// The following line is not easier than if (s != null) s.toString();
		if (result.isPresent()) result.get().toString();

		// Key usage of Optional type is to use a method which consumes the correct
		// value or produces an alternative

		// 1. You can use the ifPresent method as an alternative to the if
		// construction
		Set<String> words = new HashSet<>();
		result.ifPresent(word -> words.add(word));

		// 2. If you need to process the result (note the previous one does not
		// return it) you need to use the map method

		result.map(words::add);

		// We can produce an alternative
		result.orElse("String not found");

		// Even invoke a piece of code to compute the default value
		result.orElseGet(() -> System.getProperty("default.not.found.message"));

		// Or throw an exception
		result.orElseThrow(NoSuchElementException::new);

		// Creating Optional values
		double x = Math.random();
		Optional<Double> optional = x == 1.0 ? Optional.empty() : Optional.of(x);
	}
}
