package io.compiler.core.exceptions_warnings;

import io.compiler.types.Type;

public class DeclarationTypeMismatchException extends SemanticException {
    public DeclarationTypeMismatchException(String identifier, Type expected, Type received) {
        super("Na declaracao de " + identifier + ", esperava tipo :" + expected + ", mas recebido tipo: " + received);
    }
}
