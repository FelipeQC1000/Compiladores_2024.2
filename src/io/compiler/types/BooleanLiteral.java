package io.compiler.types;

import io.interpreter.Interpreter;
import io.interpreter.Value;

public class BooleanLiteral extends LiteralAstNode {
    private final boolean value;

    public BooleanLiteral(boolean value) {
        super(Type.Boolean);
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public String createCTarget() {
        if (value) {
            return "1";
        } else {
            return "0";
        }
    }

    @Override
    public String createJavaTarget() {
        return String.valueOf(value);
    }

    @Override
    public Value interpret(Interpreter interpreter) throws Exception {
        return new Value(Type.Boolean, value);
    }
}
