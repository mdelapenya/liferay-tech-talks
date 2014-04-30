package io.github.migue.java8.concurrency.arrays;

import java.util.Arrays;

/**
 * A bunch of parallelized ops have been included in the Arrays class
 *
 * @author Miguel Pastor
 */
public class ParallelArrays {
	public static void main(String[] args) {
		String[] WORDS = { "liferay", "tech talks", "java", "jvm" };

		Arrays.parallelSort(WORDS);
	}
}
