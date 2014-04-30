package io.github.migue.java8.concurrency.hashmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author Miguel Pastor
 */
public class ConcurrentHashMapImprovements {
	public static void main(String[] args) {
		ConcurrentHashMap<String, LongAdder> concurrentHashMap = new ConcurrentHashMap<>();

		// This is not thread-safe

		/**
		 * Long oldValue = concurrentHashMap.get(key);
		 * Long value = oldValue == null? 1 : oldValue + 1;
		 *
		 * concurrentHashMap.put(key, value); // other thread could be doing
		 * the same at the same time
		 *
		 */

		// REMEMBER: You can have non thread-safe operations in concurrent
		// data structures

		// alternative
		String key = "key";
		concurrentHashMap.putIfAbsent(key, new LongAdder()).increment();
		// We have compute, computeIfAbsent, ...

	}
}
