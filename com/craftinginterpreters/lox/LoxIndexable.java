package lox;

interface LoxIndexable {
    Object get(Token bracket, Object key);
    Object set(Token bracket, Object key, Object value);
}
