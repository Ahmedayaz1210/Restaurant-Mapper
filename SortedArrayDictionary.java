package Dictionary;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class SortedArrayDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V>{

	private Entry <K, V>[] entries;
	private static final int DEFAULT_CAPACITY = 10;
	private int size;
	
	@SuppressWarnings("unchecked")
	public SortedArrayDictionary() {
		entries = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
		size = 0;
	}
	
	
	@Override
	public V add(K key, V value) {
		if ((key == null) || (value == null)) {
			throw new IllegalArgumentException();
		}else {
			V result = null;
			int position  = locatePosition(key);
			if(position < size && key.compareTo(entries[position].getKey()) == 0) {
				result = entries[position].getValue(); //get old value
				entries[position].setValue(value); //replace old value
			}else {
				makeRoom(position);
				Entry<K, V> toAdd = new Entry<>(key, value);
				entries[position] = toAdd;
				ensureCapacity();
			}
			return result;
		}
		
	}
	
	private void ensureCapacity() {
		if(size == entries.length) {
			entries = Arrays.copyOf(entries, 2 * size);
		}
	}

	private void makeRoom(int position) {
		for(int index = size; index > position; index--) {
			entries[index] = entries[index-1];
		}
		size++;
	}
	
	private int locatePosition(K key) {
		
		int index = 0;
		while((index < size) && key.compareTo(entries[index].getKey()) > 0) {
			index++;
		}
		return index;
		 
	}
	
	
	private void removeGap(int position) {
		for(int index = position; index < size; index++) {
			entries[index] = entries[index+1];
		}
	}

	@Override
	public V remove(K key) {
		int position = locatePosition(key);
		if (position == size || key.compareTo(entries[position].getKey()) < 0) {
			return null;
		}
		V out = entries[position].getValue();
		removeGap(position);
		size--;
		return null;
	}

	@Override
	public V getValue(K key) { //binary search
		int low = 0, high = size-1;
		int mid;
		while(low <= high) {
			mid = low+(high-low)/2; //you can do low+high /2 but if it overflows that gives a - num
			int comp = key.compareTo(entries[mid].getKey());
			if(comp == 0) { //match is found
				return entries[mid].getValue();
			}
			if(comp < 0) {
				high = mid -1;
			}else {
				low = mid + 1;
			}
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		return getValue(key) != null;
	}
	
	private class KeyIterator implements Iterator<K>{

		private int cursor;
		
		public KeyIterator() {
			cursor = 0;
		}
		
		@Override
		public boolean hasNext() {
			return cursor < size;
		}

		@Override
		public K next() {
			if(!hasNext())
				throw new NoSuchElementException();
			K out = entries[cursor++].getKey();
			return out;
		}
		
	}

	@Override
	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	}
	
	private class ValueIterator implements Iterator<V>{

		private int cursor;
		
		public ValueIterator() {
			cursor = 0;
		}
		
		@Override
		public boolean hasNext() {
			return cursor < size;
		}

		@Override
		public V next() {
			if(!hasNext())
				throw new NoSuchElementException();
			V out = entries[cursor++].getValue();
			return out;
		}
		
	}

	@Override
	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void clear() {
		entries = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
		size = 0;
	}

}
