package io.github.migue.java8.concurrency.futures;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.*;

/**
 * Futures in previous Java versions were pretty limited, forcing you to make
 * periodic polling
 *
 * @author Miguel Pastor
 */
public class CompletableFutures {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Future<String> f = asyncComputation();

		while(!f.isDone()) {
			Thread.sleep(1000);
			System.out.println("Doing my job ...");
		}

		System.out.println("Future is done. Result " + f.get());

		// Completable Futures have been included
		asyncInCompletableFuture();

	}

	private static Future<String> asyncComputation() {
		Future<String> future = Executors.newCachedThreadPool().submit(() -> {
			Thread.sleep(5000);

			return "Job executed in a future";
		});

		return future;
	}

	private static void asyncInCompletableFuture() {
		CompletableFuture.supplyAsync( () -> {
			for (int i = 0; i < 1000; ++i) {
				if (i % 5 == 0)
				System.out.println("Doing hard work ....");
			}
			return new File("/tmp/foo");
		}).thenApply(File::toPath).thenAccept(System.out::println);
	}
}
