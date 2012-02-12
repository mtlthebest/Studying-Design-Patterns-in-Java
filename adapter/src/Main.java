import cache.LruCacheMap;


public class Main {
	
	public static void main(String[] args){
		
		LruCacheMap<String, String> cacheMap = new LruCacheMap<String, String>(3);
		
		cacheMap.cache("key1", "value1");
		cacheMap.cache("key2", "value2");
		cacheMap.cache("key3", "value3");
		cacheMap.cache("key4", "value4");
		cacheMap.cache("key1", "value1-1");
		
		System.out.println(cacheMap.get("key2") + " should be null.");
		
		System.out.println(cacheMap.get("key1") + " should be value1-1.");
	
		
	}

}
