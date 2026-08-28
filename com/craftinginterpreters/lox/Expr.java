package lox;

import java.util.List;

abstract class Expr {
 interface Visitor<R> {
 R visitAssignExpr(Assign expr);
 R visitBinaryExpr(Binary expr);
 R visitCallExpr(Call expr);
 R visitGetExpr(Get expr);
 R visitSetExpr(Set expr);
 R visitSuperExpr(Super expr);
 R visitThisExpr(This expr);
 R visitGroupingExpr(Grouping expr);
 R visitLiteralExpr(Literal expr);
 R visitLogicalExpr(Logical expr);
 R visitUnaryExpr(Unary expr);
 R visitVariableExpr(Variable expr);
 R visitListLiteralExpr(ListLiteral expr);
 R visitMapLiteralExpr(MapLiteral expr);
 R visitIndexExpr(Index expr);
 R visitIndexSetExpr(IndexSet expr);
 }
  static class Assign extends Expr {
    Assign(Token name, Expr value) {
      this.name = name;
      this.value = value;
    }

 @Override
 <R> R accept(Visitor<R> visitor) {
 return visitor.visitAssignExpr(this);
 }

    final Token name;
    final Expr value;
  }
  static class Binary extends Expr {
    Binary(Expr left, Token operator, Expr right) {
      this.left = left;
      this.operator = operator;
      this.right = right;
    }

 @Override
 <R> R accept(Visitor<R> visitor) {
 return visitor.visitBinaryExpr(this);
 }

    final Expr left;
    final Token operator;
    final Expr right;
  }
  static class Call extends Expr {
    Call(Expr callee, Token paren, List<Expr> arguments) {
      this.callee = callee;
      this.paren = paren;
      this.arguments = arguments;
    }

 @Override
 <R> R accept(Visitor<R> visitor) {
 return visitor.visitCallExpr(this);
 }

    final Expr callee;
    final Token paren;
    final List<Expr> arguments;
  }
  static class Get extends Expr {
    Get(Expr object, Token name) {
      this.object = object;
      this.name = name;
    }

 @Override
 <R> R accept(Visitor<R> visitor) {
 return visitor.visitGetExpr(this);
 }

    final Expr object;
    final Token name;
  }
  static class Set extends Expr {
    Set(Expr object, Token name, Expr value) {
      this.object = object;
      this.name = name;
      this.value = value;
    }

 @Override
 <R> R accept(Visitor<R> visitor) {
 return visitor.visitSetExpr(this);
 }

    final Expr object;
    final Token name;
    final Expr value;
  }
  static class Super extends Expr {
    Super(Token keyword, Token method) {
      this.keyword = keyword;
      this.method = method;
    }

 @Override
 <R> R accept(Visitor<R> visitor) {
 return visitor.visitSuperExpr(this);
 }

    final Token keyword;
    final Token method;
  }
  static class This extends Expr {
    This(Token keyword) {
      this.keyword = keyword;
    }

 @Override
 <R> R accept(Visitor<R> visitor) {
 return visitor.visitThisExpr(this);
 }

    final Token keyword;
  }
  static class Grouping extends Expr {
    Grouping(Expr expression) {
      this.expression = expression;
    }

 @Override
 <R> R accept(Visitor<R> visitor) {
 return visitor.visitGroupingExpr(this);
 }

    final Expr expression;
  }
  static class Literal extends Expr {
    Literal(Object value) {
      this.value = value;
    }

 @Override
 <R> R accept(Visitor<R> visitor) {
 return visitor.visitLiteralExpr(this);
 }

    final Object value;
  }
  static class Logical extends Expr {
    Logical(Expr left, Token operator, Expr right) {
      this.left = left;
      this.operator = operator;
      this.right = right;
    }

 @Override
 <R> R accept(Visitor<R> visitor) {
 return visitor.visitLogicalExpr(this);
 }

    final Expr left;
    final Token operator;
    final Expr right;
  }
  static class Unary extends Expr {
    Unary(Token operator, Expr right) {
      this.operator = operator;
      this.right = right;
    }

 @Override
 <R> R accept(Visitor<R> visitor) {
 return visitor.visitUnaryExpr(this);
 }

    final Token operator;
    final Expr right;
  }
  static class Variable extends Expr {
    Variable(Token name) {
      this.name = name;
    }

 @Override
 <R> R accept(Visitor<R> visitor) {
 return visitor.visitVariableExpr(this);
 }

    final Token name;
  }
  static class ListLiteral extends Expr {
    ListLiteral(List<Expr> elements) {
      this.elements = elements;
    }

 @Override
 <R> R accept(Visitor<R> visitor) {
 return visitor.visitListLiteralExpr(this);
 }

    final List<Expr> elements;
  }
  static class MapLiteral extends Expr {
    MapLiteral(List<Expr> keys, List<Expr> values) {
      this.keys = keys;
      this.values = values;
    }

 @Override
 <R> R accept(Visitor<R> visitor) {
 return visitor.visitMapLiteralExpr(this);
 }

    final List<Expr> keys;
    final List<Expr> values;
  }
  static class Index extends Expr {
    Index(Expr object, Token bracket, Expr key) {
      this.object = object;
      this.bracket = bracket;
      this.key = key;
    }

 @Override
 <R> R accept(Visitor<R> visitor) {
 return visitor.visitIndexExpr(this);
 }

    final Expr object;
    final Token bracket;
    final Expr key;
  }
  static class IndexSet extends Expr {
    IndexSet(Expr object, Token bracket, Expr key, Expr value) {
      this.object = object;
      this.bracket = bracket;
      this.key = key;
      this.value = value;
    }

 @Override
 <R> R accept(Visitor<R> visitor) {
 return visitor.visitIndexSetExpr(this);
 }

    final Expr object;
    final Token bracket;
    final Expr key;
    final Expr value;
  }

 abstract <R> R accept(Visitor<R> visitor);
}
