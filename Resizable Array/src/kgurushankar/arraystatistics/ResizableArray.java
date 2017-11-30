package kgurushankar.arraystatistics;

import java.util.Arrays;

public class ResizableArray {
	private int data[];
	private int size;
	private static final int MAX_SIZE = Short.MAX_VALUE;

	public ResizableArray() {
		this(MAX_SIZE);
	}

	public ResizableArray(int size) {
		data = new int[size];
		this.size = 0;
	}

	public ResizableArray(int[] value) {
		this(value.length + 1000);
		add(value);
	}

	public void insert(int index, int[] value) {
		if (index > size) {
			throw new IllegalArgumentException("Insertion location must be within array");
		} else if (size + value.length > data.length) {
			throw new IndexOutOfBoundsException("Insufficent Space in array");
		}

		for (int i = size - 1; i <= index; i++) {
			data[i + value.length] = data[i];
		}
		for (int i = 0; i < value.length; i++) {
			data[i + index] = value[i];
		}
		size += value.length;
	}

	public void insert(int index, int value) {
		insert(index, new int[] { value });
	}

	// Add, Remove, getSize, removeAll, insert, getData, set,
	// replace, clear, remove range, subset, sort, indexOf,

	// replaceall, reverse, remove range, subarray, sort, index of, insert, size,
	// clear, addAll, remove

	public int removeAll(int bad) {
		int bads = 0;
		for (int i = 0; i < size; i++) {
			if (data[i] == bad) {
				bads++;
			} else {
				data[i - bads] = data[i];
			}
		}
		size -= bads;
		return size;
	}

	public int add(int value) {
		data[size] = value;
		size++;
		return size;
	}

	public int add(int[] values) {
		for (int val : values) {
			add(val);
		}
		return size;
	}

	public void clear() {
		size = 0;
	}

	public void replaceAll(int Old, int New) {
		for (int i = 0; i < size; i++)
			if (data[i] == Old)
				data[i] = New;
	}

	public int size() {
		return size;
	}

	public int remove(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index+" Size:"+size);
		}
		int out = data[index];
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return out;
	}

	public String toString() {
		String out = "[";
		for (int i = 0; i < size - 1; i++) {
			out += data[i] + ", ";
		}
		out += data[size - 1] + "]";
		return out;
	}

	public void set(int index, int value) {
		data[index] = value;
	}

	public int indexOf(int value) {
		for (int i = 0; i < size; i++) {
			if (data[i] == value) {
				return i;
			}
		}
		return -1;
	}

	public int[] toArray() {
		int[] out = new int[size];
		for (int i = 0; i < out.length; i++) {
			out[i] = this.data[i];
		}
		return out;
	}

	public boolean equals(Object obj) {
		ResizableArray other = (ResizableArray) obj;
		if (other.size != this.size) {
			return false;
		} else {
			for (int i = 0; i < this.size; i++) {
				if (this.data[i] != other.data[i]) {
					return false;
				}
			}
		}
		return true;
	}

	public void sort() {
		Arrays.sort(this.data, 0, size);
	}

	public int get(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index+" Size:"+size);
		}
		return data[index];
	}
}
