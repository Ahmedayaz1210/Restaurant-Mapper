package Dictionary;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class ArrayDictionary<K, V> implements DictionaryInterface<K, V> {
	private Entry <K, V>[] entries;
	private static final int DEFAULT_CAPACITY = 10;
	private int size;
	
	@SuppressWarnings("unchecked")
	public ArrayDictionary() {
		entries = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
		size = 0;
	}
	@Override
	public V add(K key, V value) {
		 if ((key == null) || (value == null))
			 throw new IllegalArgumentException();
		 else {
			 V result = null;
			 int position = (locatePosition(key));
			 if(position < size) {
					result =  entries[position].getValue();
					entries[position].setValue(value);
				}else {
					entries[size] = new Entry<>(key, value);
					size++;
					ensureCapacity();
				}
			 return result;
		 }
		
	}
	
	private int locatePosition(K key) {
		int idx; 
		for(idx = 0; idx < size; idx++) {
			if(key.equals(entries[idx])) {
				break;
			}
		}
		return idx;
		/**
		 * int index = 0;
		while((index < size) && !key.equals(entries[index].getKey())) {
			index++;
		}
		return index;
		 */
		
	}
	
	private void ensureCapacity() {
		if(size == entries.length) {
			entries = Arrays.copyOf(entries, 2 * size);
		}
	}

	@Override
	public V remove(K key) {
		int position = locatePosition(key);
		if (position < size) {
			V out = entries[position].getValue();
			entries[position] = entries[size-1];
			entries[--size]= null;
			return out;
		}
		return null;
	}

	@Override
	public V getValue(K key) {
		int position = locatePosition(key);
		if(position < size) {
			return entries[position].getValue();
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
