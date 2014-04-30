package io.github.migue.java8.lambdas.syntax;

import javafx.event.EventHandler;

import java.util.Comparator;

/**
 * @author Miguel Pastor
 */
public class LambdasSyntax {

	public static void main(String[] args) {

		// Regular semantics
		Comparator<String> comp1 = (String a, String b) -> a.indexOf(b);

		// Multiple inferred parameters
		Comparator<String> comp2 = (a, b) -> a.indexOf(b);

		// Single parameter with inferred type
		EventHandler eventHandler = event -> System.out.println("Event");

		// Note we never specify the return type
	}
}
