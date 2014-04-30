package io.github.migue.java8.streams.creation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author Miguel Pastor
 */
public class StreamsCreation {
	public static void main(String[] args) {

		// The collections interface has a stream method
		Stream<Integer> stream = new ArrayList<Integer>().stream();

		// If it happens you have an array (or multiple arguments), use
		// the static method defined in the Stream class

		Stream<String> streamFromArray = Stream.of("a", "b", "c");

		// You can pass a data supplier, which is executed every time you need
		// a new value in the stream

		Stream<Double> random = Stream.generate(Math::random);

		// "Infinite" sequences

		Stream<BigInteger> infinite = Stream.iterate(BigInteger.ONE, number -> number.add(BigInteger.ONE));
	}
}
