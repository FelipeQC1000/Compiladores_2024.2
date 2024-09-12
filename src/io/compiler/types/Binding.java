package io.compiler.types;

public class Binding {
    private final String identifier;
    private final Type type;
    private boolean initialized;
    private boolean used;

    public Binding(String identifier, Type type, boolean isInitialized) {
        this.identifier = identifier;
        this.type = type;
        this.initialized = isInitialized;
        this.used = false;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Type getType() {
        return type;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized() {
        initialized = true;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed() {
        used = true;
    }

    @Override
    public String toString() {
        return identifier + " : " + type;
    }
}
