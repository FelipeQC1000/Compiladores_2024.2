package io.compiler.core.ast.commands;

import io.compiler.c_compiler.FormatSpecifier;
import io.compiler.core.ast.AstNode;
import io.compiler.core.ast.StatementNode;
import io.compiler.types.Type;
import io.interpreter.Interpreter;
import io.interpreter.Value;

public class Print extends StatementNode {
    private final AstNode value;

    public Print(AstNode value) {
        this.value = value;
    }

    public AstNode getValue() {
        return value;
    }

    @Override
    public String createCTarget() {
        var formatSpecifier = FormatSpecifier.getSpecifier(value.getType());

        return "printf(\"" +
                formatSpecifier +
                "\\n\", " +
                value.createCTarget() +
                ");\n";
    }

    @Override
    public String createJavaTarget() {
        return "System.out.println(" + value.createJavaTarget() + ");\n";
    }

    @Override
    public Value interpret(Interpreter interpreter) throws Exception {
        var value = this.value.interpret(interpreter);
        System.out.println(value);

        return new Value(Type.Void, null);
    }
}
