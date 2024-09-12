package io.compiler.types;

import io.interpreter.Interpreter;
import io.interpreter.Value;

public class IntegerLiteral extends LiteralAstNode {
    private final int value;

    public IntegerLiteral(int value) {
        super(Type.Integer);
        this.value = value;
    }

    @Override
    public String createCTarget() {
        return String.valueOf(value);
    }

    @Override
    public String createJavaTarget() {
        return String.valueOf(value);
    }

    @Override
    public Value interpret(Interpreter interpreter) {
        return new Value(Type.Integer, value);
    }
}
