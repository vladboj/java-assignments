package Assignment_7_2;

public class ArrayDotProductRunnable implements Runnable {
	private int start;
	private int end;
	
	private int[] arr1;
	private int[] arr2;
	
	private long dotProduct;
	
	public ArrayDotProductRunnable(int start, int end, int[] arr1, int[] arr2) {
		this.start = start;
		this.end = end;
		this.arr1 = arr1;
		this.arr2 = arr2;
		
		dotProduct = 0;
	}
	
	public void resetDotProduct() {
		dotProduct = 0;
	}
	
	public long getDotProduct() {
		return dotProduct;
	}
	
	@Override
	public void run() {
		for(int i = start; i < end; i++) {
			dotProduct += arr1[i] * arr2[i];
		}
	}
}
