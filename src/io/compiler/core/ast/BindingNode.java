package io.compiler.core.ast;

import io.compiler.types.Binding;
import io.compiler.types.Type;
import io.interpreter.Interpreter;
import io.interpreter.Value;

public class BindingNode extends AstNode {
    private final String identifier;
    private final AstNode initializer;

    public BindingNode(String identifier, Type type, AstNode initializer) {
        super(type);
        this.identifier = identifier;
        this.initializer = initializer;
    }

    public String getIdentifier() {
        return identifier;
    }

    public AstNode getInitializer() {
        return initializer;
    }

    public Binding asBinding() {
        return new Binding(identifier, type, initializer != null);
    }

    @Override
    public String createCTarget() {
        var builder = new StringBuilder();

        if (type == Type.String) {
            builder.append("char ").append(identifier).append("[256];\n");

            if (initializer != null) {
                builder.append("strcpy(").append(identifier).append(", ").append(initializer.createCTarget()).append(");\n");
            }
        } else {
            var typeString = type.createCTarget();

            builder.append(typeString).append(" ").append(identifier);
            if (initializer != null) {
                builder.append(" = ").append(initializer.createCTarget());
            }

            builder.append(";\n");
        }

        return builder.toString();
    }

    @Override
    public String createJavaTarget() {
        var builder = new StringBuilder();
        var typeString = type.createJavaTarget();

        builder.append(typeString).append(" ").append(identifier);
        if (initializer != null) {
            builder.append(" = ").append(initializer.createJavaTarget());
        }

        builder.append(";\n");
        return builder.toString();
    }

    @Override
    public Value interpret(Interpreter interpreter) throws Exception {
        var value = initializer == null
            ? new Value(type, null)
            : initializer.interpret(interpreter);

        interpreter.addValue(identifier, value);
        return new Value(Type.Void, null);
    }
}
