package io.compiler.core.exceptions_warnings;

public class VariableUsedWithoutInitializationWarning extends Warning {
    public VariableUsedWithoutInitializationWarning(String identifier) {
        super("A variavel " + identifier + " esta sendo usada sem ter sido inicializada.");
    }
}
