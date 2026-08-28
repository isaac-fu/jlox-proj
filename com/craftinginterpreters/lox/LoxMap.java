package lox;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoxMap implements LoxIndexable {
    private Map<Object, Object> entries = new HashMap<>();

    public LoxMap(List<Object> keys, List<Object> values) {
        if (keys.size() != values.size()) {
            throw new RuntimeError(null, "Keys and values must have the same length.");
        }
        for (int i = 0; i < keys.size(); i++) {
            entries.put(keys.get(i), values.get(i));
        }
    }

    @Override
    public Object get(Token bracket, Object key) {
        return entries.get(key);
    }

    @Override
    public Object set(Token bracket, Object key, Object value) {
        return entries.put(key, value);
    }
}
