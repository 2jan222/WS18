package parser;

import java.util.*;

@Deprecated
public class SyntaxTable<T, V1, V2> {
    private HashMap<T,ValuePair<V1,V2>> table = new HashMap<>();

    public int size() {
       return table.size();
    }

    public boolean isEmpty() {
        return table.isEmpty();
    }

    public boolean containsKey(T key) {
        return table.containsKey(key);
    }

    public ValuePair<V1,V2> get(T key) {
        return table.get(key);
    }

    public V1 getV1(T key) {
        return table.get(key).getValue1();
    }

    public V2 getV2(T key) {
        return table.get(key).getValue2();
    }

    public ValuePair<V1,V2> put(T key, V1 v1, V2 v2) {
        return table.put(key, new ValuePair<>(v1, v2));
    }

    public ValuePair<V1,V2> remove(T key) {
        return table.remove(key);
    }

    public void clear() {
        table.clear();
    }

    public Set<T> keySet() {
        return table.keySet();
    }

    public Collection<ValuePair<V1,V2>> values() {
        return table.values();
    }

    public Set<Map.Entry<T, ValuePair<V1,V2>>> entrySet() {
        return table.entrySet();
    }
}
