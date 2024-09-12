package io.compiler.core.operators;

public enum UnaryOperator {
    Not;

    public static UnaryOperator fromString(String value) {
        return switch (value) {
            case "!" -> Not;
            default -> throw new IllegalArgumentException("Incorrect unary operator: " + value);
        };
    }
}
