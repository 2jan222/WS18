package graph;

import java.util.HashMap;

public class BiMap<K, V> {
    private HashMap<K,V> map = new HashMap<>();
    private HashMap<V,K> invertedMap = new HashMap<>();

    void removeK(K k) {
        V remove = map.remove(k);
        invertedMap.remove(remove);
    }

    void removeV(V v) {
        K remove = invertedMap.remove(v);
        map.remove(remove);
    }

    void put(K k, V v) {
        map.put(k, v);
        invertedMap.put(v, k);
    }

    V get(K k) {
        return map.get(k);
    }

    K getKey(V v) {
        return invertedMap.get(v);
    }

    boolean containsK(K k) {
        return map.containsKey(k);
    }

    boolean containsV(V v) {
        return invertedMap.containsKey(v);
    }
}