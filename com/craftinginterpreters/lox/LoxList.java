package lox;

import java.util.List;

public class LoxList implements LoxIndexable {
    List<Object> elements;

    public LoxList(List<Object> elements) {
        this.elements = elements;
    }

    public Object get(Token bracket, Object key) {
        if (!(key instanceof Double)) {
            throw new RuntimeError(bracket, "List index must be a number.");
        }
        int index = ((Double) key).intValue();
        if (index < 0 || index >= elements.size()) {
            throw new RuntimeError(bracket, "List index out of bounds.");
        }
        return elements.get(index);
    }

    public Object set(Token bracket, Object key, Object value) {
        if (!(key instanceof Double)) {
            throw new RuntimeError(bracket, "List index must be a number.");
        }
        int index = ((Double) key).intValue();
        if (index < 0 || index >= elements.size()) {
            throw new RuntimeError(bracket, "List index out of bounds.");
        }
        return elements.set(index, value);
    }

    @Override
    public String toString() {
        return elements.toString();
    }

}
