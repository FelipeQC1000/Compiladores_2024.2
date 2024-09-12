package io.compiler.core.exceptions_warnings;

import io.compiler.types.Type;

public class AssignmentTypeMismatchException extends SemanticException {
    public AssignmentTypeMismatchException(Type expected, Type received) {
        super("Na atribuicao, esperava tipo: " + expected + ", mas recebido tipo: " + received);
    }
}