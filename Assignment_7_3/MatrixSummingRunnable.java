package Assignment_7_3;

public class MatrixSummingRunnable implements Runnable {
	private int start;
	private int end;

	private int[][] m1;
	private int[][] m2;

	private int[][] sumMatrix;

	public MatrixSummingRunnable(int start, int end, int[][] m1, int[][] m2) {
		this.start = start;
		this.end = end;
		this.m1 = m1;
		this.m2 = m2;

		sumMatrix = new int[Main.ROWS][Main.COLS];
	}

	public int[][] getSumMatrix() {
		return sumMatrix;
	}

	@Override
	public void run() {
		for (int i = start; i < end; i++) {
			for (int j = 0; j < Main.COLS; j++) {
				sumMatrix[i][j] = m1[i][j] + m2[i][j];
			}
		}
	}
}
