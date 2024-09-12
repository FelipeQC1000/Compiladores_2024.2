package io.compiler.core.ast;

import io.compiler.types.Type;

public abstract class StatementNode extends AstNode {
    public StatementNode() {
        super(Type.Void);
    }
}
