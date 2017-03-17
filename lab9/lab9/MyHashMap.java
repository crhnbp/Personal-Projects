package lab9;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

public class MyHashMap<K, V> implements Map61B<K, V> {
	
    private static class Entry<K, V> {
		final K key;
		V val;
		Entry<K, V> next;

		Entry(K k, V v) {
			key = k;
			val = v;
			next = null;
		}

		Entry(K k, V v, Entry<K, V> n) {
			key = k;
			val = v;
			next = n;
		}
	}

	private int buckets;
	private int size;
	private Set<K> set;
	private double loadFactor;
	private Entry<K, V>[] hashmap;

	public MyHashMap() {
		size = 0;
		set = new HashSet<K>(); 
		buckets = 1000;
		loadFactor = 0.75;
		hashmap = new Entry[buckets];
	}

	public MyHashMap(int initialSize) {
		size = 0;
		set = new HashSet<K>();
		buckets = initialSize;
		loadFactor = 0.75;
		hashmap = new Entry[buckets];
	}

	public MyHashMap(int initialSize, double loadFactor) {
		size = 0;
		set = new HashSet<K>();
		buckets = initialSize;
		this.loadFactor = loadFactor;
		hashmap = new Entry[buckets];
	}

    private void resize(int contents) {
        Entry<K, V>[] newHash = new Entry[contents];
        Entry<K, V>[] oldHash = hashmap;
        int oldbuckets = buckets;
        buckets = contents;
        hashmap = newHash;

        for (int i = 0; i < oldbuckets; i += 1) {
        	Entry<K, V> head = oldHash[i];
        	while(head != null) {
        		put(head.key, head.val);
        		head = head.next;
        	}
        }
		oldHash = null;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % buckets;
    }

	private Entry<K, V> getNode(int storageIndex, K key) {
		Entry<K, V> node = hashmap[storageIndex];
		while (node != null) {
			if (node.key.equals(key)) {
				return node;
			}
			node = node.next;
		}
		return null;
	}

    public void clear() {
    	size = 0;
    	hashmap = new Entry[buckets];
    	set = new HashSet<K>();
    }

    public boolean containsKey(K key) {
    	if (key == null) {
    		throw new NullPointerException("null argument to containsKey()");
    	}
    	int hashcode = hash(key);
    	Entry<K, V> node = getNode(hashcode, key);
    	if (node == null) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }

    public V get(K key) {
    	if (key == null) {
    		throw new NullPointerException("null argument to get()");
    	}
    	int hashcode = hash(key);
    	Entry<K, V> node = getNode(hashcode, key);
    	if (node == null) {
    		return null;
    	}
    	else {
    		return node.val;
    	}
    }

    public int size() {
    	return size;
    }

    public void put(K key, V value) {
    	int hashcode = hash(key);
    	Entry<K, V> node = getNode(hashcode, key);
		if (node != null) {
			node.val = value;
			return;
		}
		hashmap[hashcode] = new Entry<K, V>(key, value, hashmap[hashcode]);
    	set.add(key);
    	size += 1;
    	if ((double) (size / buckets) > loadFactor) {
    		resize(2 * buckets);
    	}
    }

    public Set<K> keySet() {
    	return set;
    }  

    private class MyHashMapIter implements Iterator<K> {
    	private Iterator<K> helper;

    	public MyHashMapIter() {
    		helper = set.iterator();
    	}

    	@Override
    	public boolean hasNext() {
    		return helper.hasNext();
    	}

    	@Override
    	public K next() {
    		K key = helper.next();
    		return key;
    	}
    }

    @Override
    public Iterator<K> iterator() {
    	return new MyHashMapIter();
    }

 	@Override   
    public V remove(K key) {
		int hashcode = hash(key);
		Entry<K, V> node = hashmap[hashcode];

		V value = null;
		if (node == null) {
			return null;
		}
		if (node.key.equals(key)) {
			hashmap[hashcode] = node.next;
			value = node.val;
			size -= 1;
			set.remove(key);
		} else {
			while (node.next != null) {
				if (node.next.equals(key)) {
					node.next = node.next.next;
					value = node.val;
					size -= 1;
					set.remove(key);
					break;
				}
				node = node.next;
			}
		}
		return value;

    }

}
