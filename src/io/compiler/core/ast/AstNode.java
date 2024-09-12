package io.compiler.core.ast;

import io.compiler.c_compiler.ICTarget;
import io.compiler.java_compiler.IJavaTarget;
import io.compiler.types.Type;
import io.interpreter.InterpretableHelper;

public abstract class AstNode implements IJavaTarget, ICTarget, InterpretableHelper {
    protected Type type;

    public AstNode(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isLiteral() {
        return false;
    }

    public boolean isIdentifier() {
        return false;
    }
}
