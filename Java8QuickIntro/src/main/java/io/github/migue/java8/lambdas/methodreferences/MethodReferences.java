package io.github.migue.java8.lambdas.methodreferences;

import java.util.Arrays;

/**
 * Sometimes we already have a method which carries the logic we want to execute
 *
 * We can reuse this behaviour through the new method references concept
 * @author Miguel Pastor
 */
public class MethodReferences {
	public static void main(String[] args) {

		String[] words = { "c", "a", "b" };

		/**
		 * Three principal situations
		 *
		 * object::instanceMethod
		 * Class::staticMethod
		 * Class::instanceMethod
		 *
		 * You can use constructor references too. Example: String::new
		 */

		Arrays.sort(words, String::compareToIgnoreCase);
	}
}
