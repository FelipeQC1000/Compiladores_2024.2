package io.interpreter;

public interface InterpretableHelper {
    Value interpret(Interpreter interpreter) throws Exception;
}
