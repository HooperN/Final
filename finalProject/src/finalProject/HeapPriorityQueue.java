package finalProject;


import java.util.NoSuchElementException;
/**
 * 
 * @author Nick Hooper
 * This lab is showcasing Heaped Priority Queues
 * @param <T>
 */

public class HeapPriorityQueue<T extends Comparable<? super T>>{

	private T[] elements;
	int size;
	private static final int DEFAULT_CAPACITY = 10;
	
	public HeapPriorityQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	public HeapPriorityQueue(int initialCapacity) {
		elements = (T[]) new Comparable[initialCapacity+1];
	}
	
	public HeapPriorityQueue(T[] entries) {
		this(entries.length*2);
		for(T data : entries) {
			add(data);
		}
	}
	
	public boolean isEmpty() {
		return elements[1] == null;
	}

	public boolean isFull() {
		return size + 1 == elements.length;
	}

	public void clear() {
		for (int index = 1; index <= size; index++)
			elements[index] = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public void add(T newEntry) {
		verifyCapacity();
		elements[size + 1] = newEntry;
		reheapUp(size + 1);
		size++;
	}
	
	public boolean verifyCapacity() {
		if(!isFull()) { return false; }
		
		HeapPriorityQueue<T> temp = new HeapPriorityQueue<T>(elements);
		elements = temp.elements;
		return true;
	}
	
	private void reheapUp(int index) {
		int parentIndex = index/2;
		while(parentIndex > 0 && elements[index].compareTo(elements[parentIndex]) > 0){
			swap(index, parentIndex);
			index = parentIndex;
			parentIndex = index / 2;
		}
	}

	public T peek() {
		if(isEmpty()) { return null; }
		return elements[1];
	}

	public T remove() {
		if(isEmpty()) { throw new NoSuchElementException(); }
		
		T ret = elements[1];
		elements[1] = elements[size];
		elements[size] = null;
		reheapDown(1);
		size--;
		return ret;
	}
	
	private void reheapDown(int index) {
		int l = index * 2;
		int r = index * 2 + 1;
		if (l >= size) { return; }
		
		int b = l;
		if(r < size && elements[r].compareTo(elements[l]) > 0) 
			b = r;
		if(elements[index].compareTo(elements[b])  < 0) {
			swap(b, index);
			reheapDown(b);
		}
	}
	
	private void swap(int from, int to) {
		T temp = elements[from];
		elements[from] = elements[to];
		elements[to] = temp;
	}
	
	public String toString() {
		if(isEmpty()) { return ""; }
		
		String ret = "[";
		for(T t : elements) {
			if(t != null)
				ret += (t + ", ");
		}
		ret = ret.substring(0, ret.length()-2);
		ret+="]";
		
		return ret;
	}

}
