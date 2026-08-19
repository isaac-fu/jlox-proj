package lox;

import java.util.List;

public class LoxClass implements LoxCallable {
    final String name;
    private final List<Stmt> methods;

    LoxClass(String name, List<Stmt> methods) {
        this.name = name;
        this.methods = methods;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments) {
        LoxInstance instance = new LoxInstance(this);
        return instance;
    }

    @Override
    public int arity() {
        return 0;
    }
}
