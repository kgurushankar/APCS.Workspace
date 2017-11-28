package kgurushankar.arraystatistics;

public class PartiallyFilledArray {
	private int data[];
	private int size;
	private static final int MAX_SIZE = 10000;

	public PartiallyFilledArray() {
		data = new int[MAX_SIZE];
		size = 0;
	}

	public void addData(int data) {
		this.data[size] = data;
	}

	// Add, Remove, move index, getSize, removeAll,insert, getData, set
}
