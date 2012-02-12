package cache;
import java.util.HashMap;
import java.util.LinkedList;


public class LruCache<K, V> {
	
	HashMap<K, V> hashMap = new HashMap<K, V>();
	LinkedList<K> queue = new LinkedList<K>();
	int max;
	
	public LruCache(int max){
		this.max = max;
	}
	
	public void cache(K key, V value){
		hashMap.put(key, value);
		queue.remove(key);
		queue.add(key);
		if(queue.size() > max){
			hashMap.remove(queue.remove());
		}
	}
	
	public V load(K key){
		queue.remove(key);
		queue.add(key);
		return hashMap.get(key);
	}

}
