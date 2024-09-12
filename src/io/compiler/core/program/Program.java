package io.compiler.core.program;

import io.compiler.c_compiler.ICTarget;
import io.compiler.core.ast.BindingNode;
import io.compiler.core.ast.StatementNode;
import io.compiler.java_compiler.IJavaTarget;
import io.compiler.types.Binding;

import java.util.HashMap;
import java.util.List;

public class Program implements IJavaTarget, ICTarget {
    public static final String SCANNER_NAME = "scanner";

    private final List<BindingNode> declarations;
    private final List<StatementNode> statements;

    private final HashMap<String, Binding> symbols;

    public Program(List<BindingNode> declarations, List<StatementNode> statements, HashMap<String, Binding> symbols) {
        this.declarations = declarations;
        this.statements = statements;

        this.symbols = symbols;
    }

    public List<BindingNode> getDeclarations() {
        return declarations;
    }

    public List<StatementNode> getStatements() {
        return statements;
    }

    public HashMap<String, Binding> getSymbols() {
        return symbols;
    }

    @Override
    public String createCTarget() {
        var builder = new StringBuilder();

        builder.append("\n#include <stdio.h>\n#include <string.h>\n#include <stdlib.h>\n");
        builder.append("int main() {\n");

        for (var declaration : declarations) {
            builder.append(declaration.createCTarget());
        }

        for (var statement : statements) {
            builder.append(statement.createCTarget());
        }

        builder.append("    return 0;\n");
        builder.append("}\n");

        return builder.toString();
    }

    @Override
    public String createJavaTarget() {
        var builder = new StringBuilder();
        builder.append("\nimport java.util.Scanner;\n\n");
        builder.append("public class Main {\n");
        builder.append("    public static void main(String[] args) {\n");
        builder.append("        Scanner " + SCANNER_NAME + " = new Scanner(System.in);\n");

        for (var declaration : declarations) {
            builder.append("        " + declaration.createJavaTarget());
        }

        for (var statement : statements) {
            builder.append("        " + statement.createJavaTarget());
        }

        builder.append("        " + SCANNER_NAME + ".close();\n");
        builder.append("    }\n");
        builder.append("}\n");

        return builder.toString();
    }
}
