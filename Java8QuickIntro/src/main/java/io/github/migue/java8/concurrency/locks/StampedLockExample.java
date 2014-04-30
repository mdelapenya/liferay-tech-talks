package io.github.migue.java8.concurrency.locks;

import java.util.concurrent.locks.StampedLock;

/**
 * @author Miguel Pastor
 */
public class StampedLockExample {

	public Object get(int i) {
		long stamp = lock.tryOptimisticRead();

		Object[] currentElements = elements;
		int currentSize = size;

		if (!lock.validate(stamp)) {
			// somebody has a write lock
			// get a pessimistic one

			stamp = lock.readLock();

			currentElements = elements;
			currentSize = size;
			lock.unlockRead(stamp);

			return i < currentSize ? currentElements[i] : null;
		}

		return currentElements[i];
	}

	private int size;
	private Object[] elements;
	private StampedLock lock = new StampedLock();
}
