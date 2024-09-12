package io.compiler.core.ast.commands;

import io.compiler.core.ast.StatementNode;
import io.compiler.core.program.Program;
import io.compiler.types.Type;
import io.interpreter.Interpreter;
import io.interpreter.Value;

public class Read extends StatementNode {
    private final String target;
    private final Type targetType;

    public Read(String target, Type targetType) {
        this.target = target;
        this.targetType = targetType;
    }

    public String getTarget() {
        return target;
    }

    public Type getTargetType() {
        return targetType;
    }

    @Override
    public String createCTarget() {
        var builder = new StringBuilder();

        switch (targetType) {
            case Integer, Boolean -> builder.append("scanf(\"%d\", &").append(target).append(");");
            case Float -> builder.append("scanf(\"%f\", &").append(target).append(");");
            case String -> builder.append("scanf(\"%s\", ").append(target).append(");");
        default -> throw new IllegalArgumentException("Unexpected value: " + targetType);
        }

        return builder.toString();
    }

    @Override
    public String createJavaTarget() {
        var builder = new StringBuilder();
        builder.append(target).append(" = ");

        switch (targetType) {
            case Integer -> builder.append(Program.SCANNER_NAME + ".nextInt()");
            case Float -> builder.append(Program.SCANNER_NAME + ".nextFloat()");
            case String -> builder.append(Program.SCANNER_NAME + ".nextLine()");
            case Boolean -> builder.append(Program.SCANNER_NAME + ".nextBoolean()");
        default -> throw new IllegalArgumentException("Unexpected value: " + targetType);
        }

        builder.append(";\n");
        return builder.toString();
    }

    @Override
    public Value interpret(Interpreter interpreter) throws Exception {
        var value = interpreter.read(targetType);
        interpreter.updateValue(target, value);

        return new Value(Type.Void, null);
    }
}
