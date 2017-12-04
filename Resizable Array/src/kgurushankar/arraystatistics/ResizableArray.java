package kgurushankar.arraystatistics;

import java.util.Arrays;

// Add, Remove, size, removeAll, insert, getData, set,
// replace, clear, remove range, subset, sort, indexOf,

// replaceall, reverse, remove range, subarray, sort, index of, insert, size,
// clear, addAll, remove

//BTW index cannot be <0
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

	public ResizableArray(ResizableArray other) {
		this();
		add(other.toArray());
		this.size = other.size;
	}

	public void add(int value) {
		data[size] = value;
		size++;
	}

	public void add(int[] values) {
		for (int val : values) {
			add(val);
		}
	}

	public void add(ResizableArray other) {
		add(other.toArray());
	}

	public void clear() {
		size = 0;
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

	public int get(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index + " Size:" + size);
		}
		return data[index];
	}

	public int indexOf(int value) {
		for (int i = 0; i < size; i++) {
			if (data[i] == value) {
				return i;
			}
		}
		return -1;
	}

	public void insert(int index, int value) {
		insert(index, new int[] { value });
	}

	public void insert(int index, int[] value) {
		if (index > size) {
			throw new IllegalArgumentException("Insertion location must be within array");
		} else if (size + value.length > data.length) {
			throw new IndexOutOfBoundsException("Insufficent Space in array");
		}

		for (int i = size-1; i >= index; i--) {
			data[i + value.length] = data[i];
		}
		for (int i = 0; i < value.length; i++) {
			data[i + index] = value[i];
		}
		size += value.length;
	}

	public int remove(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException("Index:" + index + " Size:" + size);
		}
		int out = data[index];
		for (int i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return out;
	}

	// TODO finish
	public int[] remove(int start, int end) {
		int len = end - start;
		if (end >= size) {
			throw new IndexOutOfBoundsException("Index:" + end + " Size:" + size);
		}
		int out[] = new int[len];
		for (int i = 0; i < len; i++) {
			out[i] = data[start + i];
		}
		for (int i = start; i < size - len; i++) {
			data[i] = data[i + len];
		}
		size -= len;
		return out;

	}

	public int removeAll(int value) {
		int bads = 0;
		for (int i = 0; i < size; i++) {
			if (data[i] == value) {
				bads++;
			} else {
				data[i - bads] = data[i];
			}
		}
		size -= bads;
		return size;
	}

	public void replaceAll(int Old, int New) {
		for (int i = 0; i < size; i++)
			if (data[i] == Old)
				data[i] = New;
	}

	public void reverse() {
		int temp;
		for (int i = 0; i < (size / 2); ++i) {
			temp = data[i];
			data[i] = data[size - i - 1];
			data[size - i - 1] = temp;
		}
	}

	public void set(int index, int value) {
		data[index] = value;
	}

	public int size() {
		return size;
	}

	public void sort() {
		Arrays.sort(this.data, 0, size);
	}

	public ResizableArray subset(int start, int end) {
		ResizableArray out = new ResizableArray();
		for (int i = start; i < end; i++) {
			out.add(i);
		}
		return out;
	}

	public int[] toArray() {
		int[] out = new int[size];
		for (int i = 0; i < out.length; i++) {
			out[i] = this.data[i];
		}
		return out;
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		}
		String out = "[";
		for (int i = 0; i < size - 1; i++) {
			out += data[i] + ", ";
		}
		out += data[size - 1] + "]";
		return out;
	}

}
