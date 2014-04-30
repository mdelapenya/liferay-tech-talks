package io.github.migue.java8.streams.transformations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * A Stream transformation reads data from a stream and puts the result into
 * another stream
 *
 * @author Miguel Pastor
 */
public class StreamStatefullTransformations {
	public static final List<String> WORDS =
		Arrays.asList("java", "jvm", "java8", "programming", "tech-talks");

	public static void main(String[] args) {

		// The stream must remember the elements that has already processed
		WORDS.stream().distinct();

		// We can sort the stream (no extremely useful on this example,but
		// maybe you want to sort as a part of your pipeline

		WORDS.sort(Comparator.<String>naturalOrder());

		// We can find the first element
		// Fin the first word which starts with tech
		WORDS.stream().filter(word -> word.startsWith("tech")).findFirst();

		// Look for any match, not the first one
		// TIP: Note we are building a parallel stream, so the first mach in
		// any of the parallel executions with stop the whole computation
		WORDS.stream().parallel().filter(word -> word.startsWith("tech"));
	}
}
