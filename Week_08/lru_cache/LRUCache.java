package lru_cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 使用 LinkedHashMap 实现的 LRU缓存
 */
class LRUCache {

    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new LinkedCappedHashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key))
            return map.get(key);
        else
            return -1;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    private static class LinkedCappedHashMap<K, V> extends LinkedHashMap<K, V> {
        int maximumCapacity;

        LinkedCappedHashMap(int maximumCapacity) {
            // the ordering mode = true for access-order, false for insertion order
            super(16, 0.75f, true);
            this.maximumCapacity = maximumCapacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > maximumCapacity;
        }
    }
}
