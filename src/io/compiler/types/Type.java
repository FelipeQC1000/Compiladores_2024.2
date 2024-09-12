package io.compiler.types;

import io.compiler.c_compiler.ICTarget;
import io.compiler.java_compiler.IJavaTarget;

public enum Type implements IJavaTarget, ICTarget {
    Integer(1),
    Float(2),
    Boolean(3),
    String(4),
    Void(5);

    private final int value;

    private Type(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static Type fromInteger(int value) {
        return switch (value) {
            case 1 -> Integer;
            case 2 -> Float;
            case 3 -> Boolean;
            case 4 -> String;
            case 5 -> Void;
            default -> throw new IllegalArgumentException("Invalid value: " + value);
        };
    }

    public static Type fromString(String value) {
        return switch (value) {
            case "inteiro" -> Integer;
            case "flutuante" -> Float;
            case "booleano" -> Boolean;
            case "texto" -> String;
            case "void" -> Void;
            default -> throw new IllegalArgumentException("Invalid value: " + value);
        };
    }

    @Override
    public java.lang.String createCTarget() {
        return switch (this) {
            case Integer, Boolean -> "int";
            case Float -> "float";
            case String -> "char*";
            case Void -> "void";
        };
    }

    @Override
    public java.lang.String createJavaTarget() {
        return switch (this) {
            case Integer -> "int";
            case Float -> "float";
            case Boolean -> "boolean";
            case String -> "String";
            case Void -> "void";
        };
    }
}
