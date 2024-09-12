package io.compiler.types;

import io.compiler.core.ast.AstNode;

public abstract class LiteralAstNode extends AstNode {
    public LiteralAstNode(Type type) {
        super(type);
    }

    @Override
    public boolean isLiteral() {
        return true;
    }
}
