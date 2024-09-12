package io.compiler.core.exceptions_warnings;

public class UndeclaredVariableException extends RuntimeException{
    public UndeclaredVariableException(String identifier) {
        super("Variavel " + identifier + " nao foi declarada");
    }
}
