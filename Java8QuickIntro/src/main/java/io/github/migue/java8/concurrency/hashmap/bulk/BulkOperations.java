package io.github.migue.java8.concurrency.hashmap.bulk;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Operations that can operate on concurrent hash maps at the same time that
 * other threads can operate on the same map
 *
 * @author Miguel Pastor
 */
public class BulkOperations {
	public static void main(String[] args) {
		ConcurrentHashMap<String, Long> concurrentHashMap = new ConcurrentHashMap<>();

		// ForEach operation
		// Threshold: Level of parallelism

		long threshold = 0;

		concurrentHashMap.forEach(
			threshold,
			(key, value) -> System.out.println("Key: " + key + " Value:" + value)
		);

		// For each with a transformer
		concurrentHashMap.forEach(
			threshold,
			(key, value) -> "[" + key + ":" + value + "]",
			System.out::println
		);


		// reduceKeys, reduceValues
	}
}
