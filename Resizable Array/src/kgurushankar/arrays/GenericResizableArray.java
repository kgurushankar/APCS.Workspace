package kgurushankar.arrays;

import java.util.Arrays;

// Add, Remove, size, removeAll, insert, getData, set,
// replace, clear, remove range, subset, sort, indexOf,

// replaceall, reverse, remove range, subarray, sort, index of, insert, size,
// clear, addAll, remove

//BTW index cannot be <0
/***
 * * A resizable array that can store Objectegers
 *
 * @author kgurushankar
 *
 */
public class GenericResizableArray {
	/** Partially Filled array for data */
	private Object data[];

	/** Real size of the array (any data below this index is useful data) */
	private Object size;

	/** Default size of the <code>ResizableArray</code> */
	private static final Object DEFAULT_SIZE = Short.MAX_VALUE >> 6;
	/**
	 * The default number of values to add to the data array if there is no more
	 * space
	 */
	private static final Object SIZE_INCREMENT = Short.MAX_VALUE >> 8;

	/** Creates a new <code>ResizableArray</code> */
	public GenericResizableArray() {
		this(DEFAULT_SIZE);
	}

	/**
	 * Creates a new <code>ResizableArray</code> with an initial size
	 *
	 * @param size
	 *            the size of the <code>ResizableArray</code>
	 */
	public GenericResizableArray(Object size) {
		data = new Object[size];
		this.size = 0;
	}

	/**
	 * Creates a new <code>ResizableArray</code> with the data in the array
	 *
	 * @param values
	 *            the data to store in the <code>ResizableArray</code>
	 */
	public GenericResizableArray(Object[] values) {
		this();
		add(values);
	}

	/**
	 * Creates a new <code>ResizableArray</code> with the data in the array and an
	 * initial size
	 *
	 * @param values
	 *            the data to store in the <code>ResizableArray</code>
	 * @param size
	 *            the size of the <code>ResizableArray</code>
	 */
	public GenericResizableArray(Object[] values, Object size) {
		this(size);
		add(values);
	}

	/**
	 * Creates a new <code>ResizableArray</code> that is a copy of the other
	 * ResizableArray
	 *
	 * @param other
	 *            the <code>ResizableArray</code> to be copied
	 */
	public GenericResizableArray(GenericResizableArray other) {
		this();
		add(other.toArray());
		this.size = other.size;
	}

	/**
	 * Add value to the end of this <code>ResizableArray</code>
	 *
	 * @param value
	 *            the value to be added
	 */
	public void add(Object value) {
		if (size + 1 > data.length) {
			resize();
		}
		data[size] = value;
		size++;
	}

	/**
	 * Adds the values in the array to the end of this <code>ResizableArray</code>
	 *
	 * @param values
	 *            the array to be added
	 */
	public void add(Object[] values) {
		for (Object val : values) {
			add(val);
		}
	}

	/**
	 * Adds the values in the other <code>ResizableArray</code> to the end of this
	 * <code>ResizableArray</code>
	 *
	 * @param other
	 *            the other <code>ResizableArray</code>
	 */
	public void add(GenericResizableArray other) {
		add(other.toArray());
	}

	/** Clears all of the values in <code>ResizableArray</code> */
	public void clear() {
		size = 0;
	}

	public boolean equals(Object obj) {
		GenericResizableArray other = (GenericResizableArray) obj;
		if (other.size != this.size) {
			return false;
		} else {
			for (Object i = 0; i < this.size; i++) {
				if (this.data[i] != other.data[i]) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Get the value of the <code>ResizableArray</code> at the index
	 *
	 * @param index
	 *            the index of the data
	 */
	public Object get(Object index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index:" + index + " Size:" + size);
		}
		return data[index];
	}

	/**
	 * Returns the index within this <code>ResizableArray</code> of the first
	 * occurrence of the specified number. If a number with a value of num occurs in
	 * the array represented by this <code>ResizableArray</code> object, then the
	 * index of the first such occurrence is returned. For values of num, this is
	 * the smallest value k such that: <blockquote>this.get(k) == num</blockquote>
	 *
	 * is true.
	 *
	 * If no such number occurs in this <code>ResizableArray</code>, then -1 is
	 * returned.
	 *
	 * @param num
	 *            a number
	 * @return the index of the first occurrence of the number in the array
	 *         represented by this object, or -1 if the number does not occur.
	 */
	public Object indexOf(Object num) {
		for (Object i = 0; i < size; i++) {
			if (data[i] == num) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Insert the given value at the index
	 *
	 * @param index
	 *            index to add the value at
	 * @param value
	 *            value to add
	 */
	public void insert(Object index, Object value) {
		insert(index, new Object[] { value });
	}

	/**
	 * Insert the values starting at the index
	 *
	 * @param index
	 *            index to add the value at
	 * @param value
	 *            values to add
	 */
	public void insert(Object index, Object[] value) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index:" + index + " Size:" + size);
		}
		if (size + value.length > data.length) {
			resize();
		}

		for (Object i = size - 1; i >= index; i--) {
			data[i + value.length] = data[i];
		}
		for (Object i = 0; i < value.length; i++) {
			data[i + index] = value[i];
		}
		size += value.length;
	}

	/**
	 * Remove the value at the index
	 *
	 * @param index
	 *            index to remove
	 * @return the value that was removed
	 */
	public Object remove(Object index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index:" + index + " Size:" + size);
		}
		Object out = data[index];
		for (Object i = index; i < size - 1; i++) {
			data[i] = data[i + 1];
		}
		size--;
		return out;
	}

	/**
	 * Remove a range from this <code>ResizableArray</code>
	 *
	 * @param start
	 *            index to start removing at
	 * @param end
	 *            index of last value to remove
	 * @return the value that was removed
	 */
	public Object[] remove(Object start, Object end) {
		Object len = end - start;
		if (end >= size) {
			throw new IndexOutOfBoundsException("Index:" + end + " Size:" + size);
		} else if (start < 0) {
			throw new IndexOutOfBoundsException("Index:" + start + " Size:" + size);
		} else if (end > start) {
			throw new IllegalArgumentException("Cannot end before starting");
		} else if (len == 0) {
			return new Object[0];
		}
		Object out[] = new Object[len];
		for (Object i = 0; i <= len; i++) {
			out[i] = data[start + i];
		}
		for (Object i = start; i < size - len; i++) {
			data[i] = data[i + len];
		}
		size -= len;
		return out;

	}

	/**
	 * Remove all instances of the number
	 *
	 * @param number
	 *            the number to remove
	 */
	public void removeAll(Object number) {
		Object bads = 0;
		for (Object i = 0; i < size; i++) {
			if (data[i] == number) {
				bads++;
			} else {
				data[i - bads] = data[i];
			}
		}
		size -= bads;
	}

	/**
	 * Replace all instances of one number with another number
	 *
	 * @param Old
	 *            the number to be replaced
	 * @param New
	 *            the number that is put in place of the other number
	 */
	public void replaceAll(Object Old, Object New) {
		for (Object i = 0; i < size; i++)
			if (data[i] == Old)
				data[i] = New;
	}

	/**
	 * Reverses the <code>ResizableArray</code>
	 *
	 */
	public void reverse() {
		Object temp;
		for (Object i = 0; i < (size / 2); ++i) {
			temp = data[i];
			data[i] = data[size - i - 1];
			data[size - i - 1] = temp;
		}
	}

	/**
	 * Set the value at the index
	 *
	 * @param index
	 *            the index to set
	 * @param value
	 *            the value to put in the array
	 */
	public void set(Object index, Object value) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index:" + index + " Size:" + size);
		}
		data[index] = value;
	}

	/**
	 *
	 * @return the size of the array
	 */
	public Object size() {
		return size;
	}

	/**
	 * Sort the array in ascending order
	 */
	public void sort() {
		Arrays.sort(this.data, 0, size);
	}

	/**
	 * Get a subset of this <code>ResizableArray</code>
	 *
	 * @param start
	 *            the index of the first number
	 * @param end
	 *            the index of the last number
	 * @return a <code>ResizableArray</code> with the subset of data
	 */
	public GenericResizableArray subset(Object start, Object end) {
		if (end >= size) {
			throw new IndexOutOfBoundsException("Index:" + end + " Size:" + size);
		} else if (start < 0) {
			throw new IndexOutOfBoundsException("Index:" + start + " Size:" + size);
		} else if (end < start) {
			throw new IllegalArgumentException("Cannot end before starting");
		}
		GenericResizableArray out = new GenericResizableArray(this.toArray(start, end));
		return out;
	}

	/**
	 *
	 * @return the data in this <code>ResizableArray</code> as an Objecteger array
	 */
	public Object[] toArray() {
		return this.toArray(0, size - 1);
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		}
		String out = "[";
		for (Object i = 0; i < size - 1; i++) {
			out += data[i] + ", ";
		}
		out += data[size - 1] + "]";
		return out;
	}

	/**
	 * Extend the data storage array by {@value #SIZE_INCREMENT} values
	 *
	 */
	private void resize() {
		resize(SIZE_INCREMENT);
	}

	/**
	 * Extend the data storage array by number values
	 *
	 * @param number
	 *            the number of values to add
	 */
	private void resize(Object number) {
		Object[] tmp = new Object[data.length + number];
		for (Object i = 0; i < size; i++) {
			tmp[i] = data[i];
		}
		data = tmp;
	}

	/**
	 * Return a subset of this <code>ResizableArray</code> as an Objecteger array
	 *
	 * @param start
	 *            the index to start at
	 * @param end
	 *            the index of the last value
	 * @return the data from start to end in this <code>ResizableArray</code> as an
	 *         Objecteger array
	 */
	private Object[] toArray(int start, int end) {
		if (end >= size) {
			throw new IndexOutOfBoundsException("Index:" + end + " Size:" + size);
		} else if (start < 0) {
			throw new IndexOutOfBoundsException("Index:" + start + " Size:" + size);
		} else if (end < start) {
			throw new IllegalArgumentException("Cannot end before starting");
		}
		Object[] out = new Object[end - start + 1];
		for (int i = start; i <= end; i++) {
			out[i] = this.data[i];
		}
		return out;
	}

}
