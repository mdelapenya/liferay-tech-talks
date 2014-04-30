package io.github.migue.java8.lambdas.functionalinterfaces;

import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * You can supply a lambda expression whenever an interface with a single abstract
 * method is expected
 *
 * @author Miguel Pastor
 */
public class FunctionalInterfaces {
	public static void main(String[] args) {
		String[] words = {"c", "a", "b"};

		// Sort algorithm expects an instance of Comparator (an interface with
		// a single method). The compiler does the conversion for us

		Arrays.sort(words, (a, b) -> a.compareTo(b));


		// Checked exceptions have to be declared in the funcional interface

		// DOES NOT COMPILE
		// Runnable r = () -> { Thread.sleep(10000); };

		// You should catch the exception or assign the lambda to an interface
		// which declares the exception, as Callable

		Callable<Void> callable = () -> {
			Thread.sleep(10000);
			return null;
		};
	}
}

/**
 * Using the FunctionalInterface annotations will help you because the compiler
 * will check the interface has a unique single abstract method.
 *
 * It is not required, any interface with a single abstract method is a
 * functional interface by definition
 */
@java.lang.FunctionalInterface
interface ThisIsAFunctionalInterface {
	public void m();
}
