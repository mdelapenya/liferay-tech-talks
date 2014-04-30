package io.github.migue.java8.streams.transformations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * A Stream transformation reads data from a stream and puts the result into
 * another stream
 *
 * @author Miguel Pastor
 */
public class StreamStatelessTransformations {
	public static final List<String> WORDS =
		Arrays.asList("java", "jvm", "java8", "programming", "tech-talks");

	public static void main(String[] args) {

		// Apply a transformation to all the elements in the Stream. In this
		// example, convert to lowercase every element in the stream

		WORDS.stream().map(String::toLowerCase);

		// We can pass a lambda too
		WORDS.stream().map(word -> word.toLowerCase());

		// Limiting the streams to the first 10 elements

		Stream<Double> limiting = Stream.generate(Math::random).limit(10);

		// Or skipping the first ten elements

		Stream<Double> skipping = Stream.generate(Math::random).skip(10);

		// Peeking allows us easy debugging

		Stream.iterate(1, n -> n + 1).peek(n -> System.out.println("Generated number " + n));
	}
}
