package io.github.migue.java8.concurrency.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Atomic operations where introduced in Java 5 and where simple to use when you had to deal with simple updates.
 * Once you need a more complex mechanism, you were forced to use the compareAndSet method
 *
 * @author Miguel Pastor
 */
public class AtomicValues {

    public static void main(String[] args) {

        // Tracking the largest element observed by a bunch of threads previous to Java 8
        /**

            AtomicLong largest = new AtomicLong();

            // some thread ... This is not Atomic!!
            largest.set(Math.max(largest.get(), observedValue));

            // So we need to
            do {
                oldValue = largest.get();

                newValue = Matx.max(oldValue, observed)

            } while (!largest.compareAndSet(oldValue, newValue);

         */

        // With Java 8 is much simpler
        AtomicLong largest = new AtomicLong();

        Long observed = 2L;
        largest.updateAndGet(x  -> Math.max(x, observed));

        // Too threads accessing the same atomic values cause a performance degradation (contention), in general, because
        // the optimistic updates need to be retried.

        // Adders and Accumulators try to solve the previous problems, especially on those situations where the final
        // value is not needed until all the computation has already been done
    }
}
