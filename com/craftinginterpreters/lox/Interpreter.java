package lox;

class Interpreter implements Expr.Visitor<Object>{

    public Object visitLiteralExpr(Expr.Literal expr) {
        return expr.value;
    }

    @Override
    public Object visitGroupExpr(Expr.Grouping expr) {
        return evaluate(expr.expression);
    }

    
}
