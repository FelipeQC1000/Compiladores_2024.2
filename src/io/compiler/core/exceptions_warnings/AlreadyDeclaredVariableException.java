package io.compiler.core.exceptions_warnings;

public class AlreadyDeclaredVariableException extends SemanticException {
    public AlreadyDeclaredVariableException(String identifier) {
        super("Variavel '" + identifier + "' ja foi declarada");
    }
}
