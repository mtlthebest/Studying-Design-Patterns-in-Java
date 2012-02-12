package cache;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class LruCacheMap<K, V> extends LruCache<K, V> implements Map<K, V>{

	public LruCacheMap(int max) {
		super(max);
	}

	@Override
	public void clear() {
		this.hashMap.clear();
		this.queue.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return this.hashMap.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return this.hashMap.containsValue(value);
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(Object key) {
		return this.load((K)key);
	}


	@Override
	public V put(K key, V value) {
		this.cache(key, value);
		return value;
	}
	
	@Override
	public boolean isEmpty() {
		return this.hashMap.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		return this.hashMap.keySet();
	}


	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		for (Map.Entry element : map.entrySet()) {
		    Map.Entry entry = element;
		    this.cache((K)entry.getKey(), (V)entry.getValue());
		}
		
	}

	@Override
	public V remove(Object key) {
		this.queue.remove(key);
		return this.hashMap.remove(key);
	}

	@Override
	public int size() {
		return this.hashMap.size();
	}

	@Override
	public Collection<V> values() {
		return this.hashMap.values();
	}



}
