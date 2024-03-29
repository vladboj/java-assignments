package Assignment_4;

public class Matrix {
	private int[][] data;
	private int rows;
	private int cols;

	public Matrix(int rows, int cols) {
		this.setRows(rows);
		this.setCols(cols);
		data = new int[rows][cols];
	}

	private void setRows(int rows) {
		if (rows < 1) {
			throw new IllegalArgumentException("rows must be a positive value!");
		}
		this.rows = rows;
	}

	private void setCols(int cols) {
		if (cols < 1) {
			throw new IllegalArgumentException("cols must be a positive value!");
		}
		this.cols = cols;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public void setElement(int val, int row, int col) {
		data[row][col] = val;
	}

	public int getValue(int row, int col) {
		return data[row][col];
	}

	public static Matrix add(Matrix m1, Matrix m2) {
		if (m1.rows != m2.rows || m1.cols != m2.cols) {
			throw new IllegalArgumentException("matrices must have the same dimensions!");
		}
		Matrix m3 = new Matrix(m1.rows, m1.cols);
		for (int i = 0; i < m1.rows; i++) {
			for (int j = 0; j < m1.cols; j++) {
				m3.data[i][j] = m1.data[i][j] + m2.data[i][j];
			}
		}
		return m3;
	}

	public static Matrix subtract(Matrix m1, Matrix m2) {
		if (m1.rows != m2.rows || m1.cols != m2.cols) {
			throw new IllegalArgumentException("matrices must have the same dimensions!");
		}
		Matrix m3 = new Matrix(m1.rows, m1.cols);
		for (int i = 0; i < m1.rows; i++) {
			for (int j = 0; j < m1.cols; j++) {
				m3.data[i][j] = m1.data[i][j] - m2.data[i][j];
			}
		}
		return m3;
	}

	public static Matrix multiply(Matrix m1, Matrix m2) {
		if (m1.cols != m2.rows) {
			throw new IllegalArgumentException(
					"first matrix's number of columns must be equal to second matrix's number of rows!");
		}
		Matrix m3 = new Matrix(m1.rows, m2.cols);
		for (int i = 0; i < m1.rows; i++) {
			for (int j = 0; j < m2.cols; j++) {
				int temp = 0;
				for (int k = 0; k < m1.cols; k++) {
					temp += m1.data[i][k] * m2.data[k][j];
				}
				m3.data[i][j] = temp;
			}
		}
		return m3;
	}

	public void print() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
