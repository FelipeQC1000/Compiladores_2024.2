package io.interpreter;

import io.compiler.types.Type;

public class Value {
    private final Type type;
    private final Object value;

    public Value(Type type, Object value) {
        this.type = type;
        this.value = value;
    }

    public boolean asBoolean() throws Exception {
        if (!this.type.equals(Type.Boolean)) {
            throw new Exception("Expected value to be boolean");
        }

        return (boolean) value;
    }
    
    public Type getType() {
        return type;
    }

    public boolean is(Type type) {
        return this.type.equals(type);
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Value any) {
            return type.equals(any.type) && value.equals(any.value);
        }

        return false;
    }
}
