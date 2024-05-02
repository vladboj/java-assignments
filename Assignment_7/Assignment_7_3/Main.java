package Assignment_7_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static final int ROWS = 1000;
	public static final int COLS = 1000;

	public static void displayMatrix(int[][] m) {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				System.out.printf("%d ", m[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void readMatrix(int[][] m) {
		try {
			FileInputStream fis = new FileInputStream("./src/Assignment_7_3/input.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			br.readLine();
			for (int i = 0; i < ROWS; i++) {
				String[] row = br.readLine().split(" ");
				for (int j = 0; j < COLS; j++) {
					m[i][j] = Integer.parseInt(row[j]);
				}
			}

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void printMatrix(int[][] m) {
		try {
			FileOutputStream fos = new FileOutputStream("./src/Assignment_7_3/output.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);

			for (int i = 0; i < ROWS; i++) {
				for (int j = 0; j < COLS; j++) {
					bw.write(((Integer) m[i][j]).toString());
					bw.write(" ");
				}
				bw.write(System.lineSeparator());
			}

			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void sumMatrices(int[][] m1, int[][] m2) {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				m1[i][j] += m2[i][j];
			}
		}
	}

	public static void main(String[] args) {
		// Create matrices
		int[][] m1 = new int[ROWS][COLS];
		int[][] m2 = new int[ROWS][COLS];

		// Read matrices from file
		readMatrix(m1);
		readMatrix(m2);

		int numberOfThreads = 4;

		int intervalSize = ROWS / numberOfThreads;

		long startTime = System.currentTimeMillis();

		ExecutorService threadPool = Executors.newFixedThreadPool(numberOfThreads);

		MatrixSummingRunnable[] tasks = new MatrixSummingRunnable[numberOfThreads];
		for (int i = 0; i < numberOfThreads; i++) {
			tasks[i] = new MatrixSummingRunnable(i, (i + 1) * intervalSize, m1, m2);
			threadPool.execute(tasks[i]);
		}
		threadPool.shutdown();

		try {
			threadPool.awaitTermination(3000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int[][] sumMatrix = new int[ROWS][COLS];
		for (int i = 0; i < numberOfThreads; i++) {
			sumMatrices(sumMatrix, tasks[i].getSumMatrix());
		}

		long endTime = System.currentTimeMillis();

		printMatrix(sumMatrix);
		System.out.printf("duration for %d threads: %dms\n", numberOfThreads, endTime - startTime);

		// Repeat with another number of threads
		numberOfThreads = 8;

		intervalSize = ROWS / numberOfThreads;

		startTime = System.currentTimeMillis();

		threadPool = Executors.newFixedThreadPool(numberOfThreads);

		tasks = new MatrixSummingRunnable[numberOfThreads];
		for (int i = 0; i < numberOfThreads; i++) {
			tasks[i] = new MatrixSummingRunnable(i, (i + 1) * intervalSize, m1, m2);
			threadPool.execute(tasks[i]);
		}
		threadPool.shutdown();

		try {
			threadPool.awaitTermination(3000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		sumMatrix = new int[ROWS][COLS];
		for (int i = 0; i < numberOfThreads; i++) {
			sumMatrices(sumMatrix, tasks[i].getSumMatrix());
		}

		endTime = System.currentTimeMillis();

		System.out.printf("duration for %d threads: %dms\n", numberOfThreads, endTime - startTime);
	}

}
