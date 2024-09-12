package io.compiler.core.ast.commands;

import io.compiler.core.ast.AstNode;
import io.compiler.core.ast.StatementNode;
import io.compiler.types.Type;
import io.interpreter.Interpreter;
import io.interpreter.Value;

public class Assignment extends StatementNode {
    private final String identifier;
    private final AstNode expression;

    public Assignment(String identifier, AstNode expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public String createCTarget() {
        if (expression.getType() == Type.String) {
            return "strcpy(" + identifier + ", " + expression.createCTarget() + ");\n";
        } else {
            return identifier + " = " + expression.createCTarget() + ";\n";
        }
    }

    @Override
    public String createJavaTarget() {
        return identifier + " = " + expression.createJavaTarget() + ";\n";
    }

    @Override
    public Value interpret(Interpreter interpreter) throws Exception {
        var value = expression.interpret(interpreter);
        interpreter.updateValue(identifier, value);

        return new Value(Type.Void, null);
    }
}
