package io.github.migue.java8.streams.intro;

import java.util.Arrays;
import java.util.List;

/**
 * Streams are the new key abstraction included in Java 8 for processing
 * collections, specifying what you want to achieve.
 *
 * Most of Java developers are used to iterate through collections and do
 * some work with each of them.
 *
 * Some important notes:
 *
 * 1. Stream does not store its elements: stored in the underlying collection
 * or generated in demand
 *
 * 2. Don't mutate their source.
 *
 * 3. Lazy (when possible)
 *
 * How to work with streams?
 *
 * 1. Create the stream
 *
 * 2. Specify intermediate operations (transforming one stream into another one)
 *
 * 3. Apply a terminal operation to get a final result
 *
 * 4. Once we finish, the stream can no be longer used
 *
 * @author Miguel Pastor
 */
public class StreamsIntro {
	public static final List<String> WORDS =
		Arrays.asList("java", "jvm", "java8", "programming", "tech-talks");

	public static void main(String[] args) {
		countWordsTraditionalApproach(WORDS, "-");
		countWordsStreamsApproach(WORDS, "-");
	}

	private static void countWordsTraditionalApproach(
		List<String> words, String suffix) {

		int count = 0;

		for (String word : words) {
			if (word.contains(suffix)) {
				++count;
			}
		}

		System.out.println(
			"We have found " + count  + " words containing " + suffix);
	}

	private static void countWordsStreamsApproach(
		List<String> words, String suffix) {

		long count =
			words.stream().filter(word -> word.contains(suffix)).count();

		System.out.println(
			"We have found " + count  + " words containing " + suffix);
	}
}
