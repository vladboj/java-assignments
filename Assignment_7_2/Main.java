package Assignment_7_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	private static void populateArray(int[] arr, int arraySize) {
		for (int i = 0; i < arraySize; i++) {
			arr[i] = i + 1;
		}
	}

	public static void main(String[] args) {
		// Create arrays
		final int ARRAY_SIZE = 100_000;

		int[] arr1 = new int[ARRAY_SIZE];
		int[] arr2 = new int[ARRAY_SIZE];

		populateArray(arr1, ARRAY_SIZE);
		populateArray(arr2, ARRAY_SIZE);

		// Set number of threads
		int numberOfThreads = 4;

		// Set interval size
		int intervalSize = ARRAY_SIZE / numberOfThreads;

		long startTime = System.currentTimeMillis();

		// Create thread pool
		ExecutorService threadPool = Executors.newFixedThreadPool(numberOfThreads);

		// Create tasks to place in the thread pool and execute them
		ArrayDotProductRunnable[] tasks = new ArrayDotProductRunnable[numberOfThreads];
		for (int i = 0; i < numberOfThreads; i++) {
			tasks[i] = new ArrayDotProductRunnable(i * intervalSize, (i + 1) * intervalSize, arr1, arr2);
			threadPool.execute(tasks[i]);
		}
		threadPool.shutdown();

		// Wait for thread pool to finish
		try {
			threadPool.awaitTermination(3000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Fetch results
		long dotProduct = 0;
		for (int i = 0; i < numberOfThreads; i++) {
			dotProduct += tasks[i].getDotProduct();
		}

		long endTime = System.currentTimeMillis();

		// Print sum and duration
		System.out.printf("dot product = %d\n", dotProduct);
		System.out.printf("duration for %d threads: %dms\n", numberOfThreads, endTime - startTime);

		// Repeat with a different number of threads
		numberOfThreads = 8;
		
		intervalSize = ARRAY_SIZE / numberOfThreads;
		
		startTime = System.currentTimeMillis();
		
		threadPool = Executors.newFixedThreadPool(numberOfThreads);
		
		tasks = new ArrayDotProductRunnable[numberOfThreads];
		for (int i = 0; i < numberOfThreads; i++) {
			tasks[i] = new ArrayDotProductRunnable(i * intervalSize, (i + 1) * intervalSize, arr1, arr2);
			threadPool.execute(tasks[i]);
		}
		threadPool.shutdown();

		try {
			threadPool.awaitTermination(3000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		dotProduct = 0;
		for (int i = 0; i < numberOfThreads; i++) {
			dotProduct += tasks[i].getDotProduct();
		}

		endTime = System.currentTimeMillis();

		System.out.printf("dot product = %d\n", dotProduct);
		System.out.printf("duration for %d threads: %dms\n", numberOfThreads, endTime - startTime);
	}

}
