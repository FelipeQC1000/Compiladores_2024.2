package io.compiler.core.exceptions_warnings;

public class UnusedVariableWarning extends Warning {
    public UnusedVariableWarning(String identifier) {
        super("A variavel " + identifier + " foi declarada, mas nao foi usada.");
    }
}
