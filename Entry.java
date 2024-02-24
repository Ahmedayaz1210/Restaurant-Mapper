package Dictionary;

public class Entry<K, V> {
	private K key;
	private V value;
	public Entry(K searchKey, V dataValue){
		key = searchKey;
		value = dataValue;		
	}
	
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}

	public void setValue(V newValue) {
		value = newValue;
	}

}
