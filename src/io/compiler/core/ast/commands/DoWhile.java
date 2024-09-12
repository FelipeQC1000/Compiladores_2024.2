package io.compiler.core.ast.commands;

import io.compiler.core.ast.AstNode;
import io.compiler.core.ast.StatementNode;
import io.compiler.types.Type;
import io.interpreter.Interpreter;
import io.interpreter.Value;

import java.util.List;

public class DoWhile extends StatementNode {
    private final List<StatementNode> body;
    private final AstNode condition;

    public DoWhile(List<StatementNode> body, AstNode condition) {
        this.body = body;
        this.condition = condition;
    }

    public List<StatementNode> getBody() {
        return body;
    }

    public AstNode getCondition() {
        return condition;
    }

    @Override
    public String createCTarget() {
        var builder = new StringBuilder();

        builder.append("do {\n");
        for (var statement : body) {
            builder.append(statement.createCTarget());
        }
        builder.append("} while (");
        builder.append(condition.createCTarget());
        builder.append(");\n");

        return builder.toString();
    }

    @Override
    public String createJavaTarget() {
        var builder = new StringBuilder();

        builder.append("do {\n");
        for (var statement : body) {
            builder.append("          " + statement.createJavaTarget());
        }
        builder.append("        } while (");
        builder.append(condition.createJavaTarget());
        builder.append(");\n");

        return builder.toString();
    }

    @Override
    public Value interpret(Interpreter interpreter) throws Exception {
        do {
            for (var statement : body) {
                statement.interpret(interpreter);
            }
        } while (condition.interpret(interpreter).asBoolean());

        return new Value(Type.Void, null);
    }
}
