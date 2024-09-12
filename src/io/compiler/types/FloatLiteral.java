package io.compiler.types;

import io.interpreter.Interpreter;
import io.interpreter.Value;

public class FloatLiteral extends LiteralAstNode {
    private final float value;

    public FloatLiteral(float value) {
        super(Type.Float);
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
        return new Value(Type.Float, value);
    }
}
