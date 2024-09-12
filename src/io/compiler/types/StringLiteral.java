package io.compiler.types;

import io.interpreter.Interpreter;
import io.interpreter.Value;

public class StringLiteral extends LiteralAstNode {
    private final String value;

    public StringLiteral(String value) {
        super(Type.String);
        this.value = value;
    }

    @Override
    public String createCTarget() {
        return value;
    }

    @Override
    public String createJavaTarget() {
        return value;
    }

    @Override
    public Value interpret(Interpreter interpreter) {
        return new Value(Type.String, value);
    }
}
