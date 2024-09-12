package io.compiler.c_compiler;

import io.compiler.types.Type;

public class FormatSpecifier {
    public static final String INTEGER = "%d";
    public static final String FLOAT = "%f";
    public static final String CHAR = "%c";
    public static final String STRING = "%s";

    public static String getSpecifier(Type type) {
        return switch (type) {
            case Integer, Boolean -> INTEGER;
            case Float -> FLOAT;
            case String -> STRING;
            default -> throw new IllegalArgumentException("Invalid type (" + type.toString() + ") for format specifier");
        };
    }
}
