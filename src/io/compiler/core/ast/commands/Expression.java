package io.compiler.core.ast.commands;

import io.compiler.core.ast.AstNode;
import io.compiler.core.ast.StatementNode;
import io.interpreter.Interpreter;
import io.interpreter.Value;

public class Expression extends StatementNode {
    private final AstNode expression;

    public Expression(AstNode expression) {
        this.expression = expression;
    }

    public AstNode getExpression() {
        return expression;
    }

    @Override
    public String createCTarget() {
        return expression.createCTarget() + ";";
    }

    @Override
    public String createJavaTarget() {
        return "var _ = " + expression.createJavaTarget() + ";";
    }

    @Override
    public Value interpret(Interpreter interpreter) throws Exception {
        return expression.interpret(interpreter);
    }
}
