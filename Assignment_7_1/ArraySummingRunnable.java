package Assignment_7_1;

public class ArraySummingRunnable implements Runnable {
	private int start;
	private int end;
	
	private int[] arr1;
	private int[] arr2;
	
	private long sum = 0;
	
	public ArraySummingRunnable(int start, int end, int[] arr1, int[] arr2) {
		this.start = start;
		this.end = end;
		this.arr1 = arr1;
		this.arr2 = arr2;
	}
	
	public long getSum() {
		return sum;
	}
	
	@Override
	public void run() {
		for(int i = start; i < end; i++) {
			sum += arr1[i] + arr2[i];
		}
	}
}
