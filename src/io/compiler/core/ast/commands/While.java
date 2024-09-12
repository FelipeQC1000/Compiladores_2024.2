package io.compiler.core.ast.commands;

import io.compiler.core.ast.AstNode;
import io.compiler.core.ast.StatementNode;
import io.compiler.types.Type;
import io.interpreter.Interpreter;
import io.interpreter.Value;

import java.util.List;

public class While extends StatementNode {
    private final AstNode condition;
    private final List<StatementNode> body;

    public While(AstNode condition, List<StatementNode> body) {
        this.condition = condition;
        this.body = body;
    }

    public AstNode getCondition() {
        return condition;
    }

    public List<StatementNode> getBody() {
        return body;
    }

    @Override
    public String createCTarget() {
        StringBuilder builder = new StringBuilder();

        builder.append("while (");
        builder.append(condition.createCTarget());
        builder.append(") {\n");

        for (AstNode node : body) {
            builder.append(node.createCTarget());
        }

        builder.append("}\n");

        return builder.toString();
    }

    @Override
    public String createJavaTarget() {
        StringBuilder builder = new StringBuilder();

        builder.append("while (");
        builder.append(condition.createJavaTarget());
        builder.append(") {\n");

        for (AstNode node : body) {
            builder.append("          " + node.createJavaTarget());
        }

        builder.append("        }\n");

        return builder.toString();
    }

    @Override
    public Value interpret(Interpreter interpreter) throws Exception {
        while (condition.interpret(interpreter).asBoolean()) {
            for (StatementNode node : body) {
                node.interpret(interpreter);
            }
        }

        return new Value(Type.Void, null);
    }
}
