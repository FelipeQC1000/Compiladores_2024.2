package io.interpreter;

import io.compiler.core.ast.AstNode;
import io.compiler.core.exceptions_warnings.AlreadyDeclaredVariableException;
import io.compiler.core.exceptions_warnings.UndeclaredVariableException;
import io.compiler.core.program.Program;
import io.compiler.types.Type;

import java.util.HashMap;
import java.util.Scanner;

public class Interpreter {
    private final Program program;
    private final HashMap<String, Value> values;

    private final Scanner scanner;

    public Interpreter(Program program) {
        this.program = program;
        this.values = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    public void addValue(String name, Value value) throws AlreadyDeclaredVariableException {
        if (values.containsKey(name)) {
            throw new AlreadyDeclaredVariableException(name);
        }

        values.put(name, value);
    }

    public void updateValue(String name, Value value) throws UndeclaredVariableException {
        if (!values.containsKey(name)) {
            throw new UndeclaredVariableException(name);
        }

        values.replace(name, value);
    }

    public Value getValue(String name) throws UndeclaredVariableException {
        if (!values.containsKey(name)) {
            throw new UndeclaredVariableException(name);
        }

        return values.get(name);
    }

    public Value read(Type target) {
        switch (target) {
            case Integer -> {
                var value = scanner.nextInt();
                return new Value(Type.Integer, value);
            }
            case Float -> {
                var value = scanner.nextFloat();
                return new Value(Type.Float, value);
            }
            case String -> {
                var value = scanner.nextLine();
                return new Value(Type.String, value);
            }
            case Boolean -> {
                var value = scanner.nextBoolean();
                return new Value(Type.Boolean, value);
            }
            default -> throw new IllegalArgumentException("Invalid type: " + target);
        }
    }

    public void cliRun(AstNode input) {
        try {
            var value = input.interpret(this);

            if (value.getType() != Type.Void) {
                System.out.println(value.getValue());
            }
        } catch (Exception exception) {
            System.err.println("Error: " + exception.getMessage());
            System.out.println("Stack trace:");
            exception.printStackTrace();
        }
    }

    public void run() {
        try {
            for (var declaration : program.getDeclarations()) {
                declaration.interpret(this);
            }

            for (var statement : program.getStatements()) {
                statement.interpret(this);
            }

            scanner.close();
        } catch (Exception exception) {
            System.err.println("Error: " + exception.getMessage());
            System.out.println("Stack trace:");
            exception.printStackTrace();
        }
    }
}
