package Assignment_4;

public class Main {

	public static void main(String[] args) {

		// Generate 3 matrices for the demo
		int x = 0;

		Matrix m1 = new Matrix(3, 3);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				m1.setElement(x++, i, j);
			}
		}

		Matrix m2 = new Matrix(3, 3);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				m2.setElement(x++, i, j);
			}
		}

		Matrix m3 = new Matrix(3, 5);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				m3.setElement(x++, i, j);
			}
		}

		// DEMO
		Matrix aux;

		// Addition
		aux = Matrix.add(m1, m2);
		aux.print();

		// Subtraction
		aux = Matrix.subtract(m1, m2);
		aux.print();

		// Multiplication
		aux = Matrix.multiply(m2, m3);
		aux.print();

	}

}
