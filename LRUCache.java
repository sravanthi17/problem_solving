import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<Integer,Integer> {
    int capacity;

    public LRUCache(int capacity) {
        super(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        return getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
        return size() > this.capacity;
    }
}
