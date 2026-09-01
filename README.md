# jlox Interpreter

A tree-walk interpreter for the Lox programming language, implemented in Java. This project follows the architecture introduced in *Crafting Interpreters* and extends the language with mutable list and map collections. It implements lexical scoping, closures, classes, inheritance, `this`, `super`, collection literals, and indexed access.

## Features

- Scanner (lexer) for converting source text into tokens
- Recursive-descent parser that builds an abstract syntax tree (AST)
- Tree-walk interpreter using the Visitor pattern
- Static resolution of local variables and lexical scope
- Numbers, strings, booleans, and `nil`
- Mutable list and map values
- Collection literals, indexed access, and indexed assignment
- Arithmetic, comparison, equality, and logical operators
- Variables, assignment, and block scope
- `if`/`else`, `while`, and `for` control flow
- First-class functions, closures, and return values
- Classes, instances, fields, and methods
- Initializers using `init`
- Single inheritance with `this` and `super`
- Native `clock()` function
- Interactive REPL and script-file execution
- Parse-time, resolution-time, and runtime error reporting

## Requirements

- Java Development Kit (JDK) 8 or newer

Verify that Java is installed:

```bash
java -version
javac -version
```

## Project Structure

All Java source files belong to the `lox` package.

| File | Responsibility |
| --- | --- |
| `Lox.java` | Application entry point, REPL, file execution, and error reporting |
| `Scanner.java` | Converts source code into tokens |
| `Parser.java` | Parses tokens into expressions and statements |
| `Expr.java`, `Stmt.java` | AST node definitions and visitor interfaces |
| `Resolver.java` | Resolves lexical scope before interpretation |
| `Interpreter.java` | Evaluates expressions and executes statements |
| `Environment.java` | Stores variables and manages nested scopes |
| `LoxCallable.java` | Common interface for callable values |
| `LoxFunction.java` | Implements functions, closures, methods, and initializers |
| `LoxClass.java` | Represents classes and inheritance |
| `LoxInstance.java` | Stores instance fields and binds methods |
| `LoxIndexable.java` | Common interface for values that support indexed access and assignment |
| `LoxList.java` | Implements mutable, numerically indexed list values |
| `LoxMap.java` | Implements mutable key-value map values |
| `Token.java`, `TokenType.java` | Token representation and token types |
| `Return.java` | Internal control-flow mechanism for function returns |

## Build and Run

The commands below assume the source files are inside a directory named `lox` and are run from its parent directory.

Compile the interpreter:

```bash
javac -d out lox/*.java
```

Start the interactive prompt:

```bash
java -cp out lox.Lox
```

Run a Lox script:

```bash
java -cp out lox.Lox path/to/script.lox
```

On Windows PowerShell, the same commands work when run from the project directory:

```powershell
javac -d out .\lox\*.java
java -cp out lox.Lox .\examples\hello.lox
```

If your repository stores the package under `src/lox`, compile it with:

```bash
javac -d out src/lox/*.java
```

## Language Examples

### Variables and control flow

```lox
var total = 0;

for (var i = 1; i <= 5; i = i + 1) {
  total = total + i;
}

if (total == 15) {
  print "The total is correct.";
}
```

### Functions and closures

```lox
fun makeCounter() {
  var count = 0;

  fun next() {
    count = count + 1;
    return count;
  }

  return next;
}

var counter = makeCounter();
print counter(); // 1
print counter(); // 2
```

### Classes and inheritance

Class methods are declared directly inside the class body. The initializer is named `init`, and a class is instantiated by calling the class itself.

```lox
class Person {
  init(name) {
    this.name = name;
  }

  greet() {
    print "Hello, " + this.name;
  }
}

class Student < Person {
  greet() {
    super.greet();
    print "I am a student.";
  }
}

var isaac = Student("Isaac");
isaac.greet();
```

### Native function

```lox
print clock();
```

`clock()` returns the current Unix time in seconds as a number.

### Lists

Lists use square brackets and may contain any Lox value. Elements can be read or replaced through zero-based indexing.

```lox
var languages = ["Java", "Lox", "Go"];

print languages[0]; // Java
languages[1] = "Python";
print languages[1]; // Python
```

Lists may also be nested, and indexing can be chained:

```lox
var grid = [[1, 2], [3, 4]];
print grid[1][0]; // 3
```

### Maps

Maps use braces with `key: value` entries. A map key can be any value supported as a Java `HashMap` key.

```lox
var student = {
  "name": "Isaac",
  "major": "Computer Science"
};

print student["name"]; // Isaac
student["year"] = 2;
print student["year"]; // 2
```

An empty list is written as `[]`, and an empty map is written as `{}` when used in an expression.

## How It Works

Source code passes through four main stages:

1. The scanner converts characters into tokens.
2. The parser converts the tokens into an AST, including collection literals and index operations.
3. The resolver determines lexical scope and validates uses of variables, functions, and classes.
4. The interpreter walks the AST and executes the program.

The AST uses the Visitor pattern so operations such as resolution and interpretation can be implemented separately from the expression and statement node classes.

## Language Notes

- Statements such as variable declarations, expression statements, `print`, and `return` end with a semicolon.
- Only `false` and `nil` are falsey; every other value is truthy.
- The `+` operator accepts either two numbers or two strings. It does not implicitly convert between types.
- Functions and classes require the exact number of arguments declared by their parameters or initializer.
- Fields are accessed through instances, such as `object.field`.
- A subclass is declared with `<`, such as `class Student < Person`.
- Lists use zero-based numeric indexes. Accessing an index outside the list bounds produces a runtime error.
- Reading a missing map key returns `nil`; assigning to a new key adds it to the map.
- Lists and maps are mutable, so indexed assignment updates the existing collection.

## Exit Codes

When running a script file, the interpreter uses these exit codes:

| Code | Meaning |
| --- | --- |
| `64` | Invalid command-line usage |
| `65` | Scanning, parsing, or resolution error |
| `70` | Runtime error |

## Acknowledgments

Based on the Java implementation of Lox from Robert Nystrom's [*Crafting Interpreters*](https://craftinginterpreters.com/).

## License

No license has been specified. Add a `LICENSE` file before distributing or accepting contributions to the project.
