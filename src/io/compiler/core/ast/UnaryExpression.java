package io.compiler.core.ast;

import io.compiler.core.operators.UnaryOperator;
import io.compiler.types.Type;
import io.interpreter.Interpreter;
import io.interpreter.Value;

import java.util.Objects;

public class UnaryExpression extends AstNode {
    private final UnaryOperator operator;
    private AstNode operand;

    public UnaryExpression(UnaryOperator operator) {
        super(Type.Boolean);
        this.operator = operator;
        this.operand = null;
    }

    public UnaryExpression(UnaryOperator operator, AstNode operand) {
        super(operand.type);
        this.operator = operator;
        this.operand = operand;
    }

    public UnaryOperator getOperator() {
        return operator;
    }

    public AstNode getOperand() {
        return operand;
    }

    public void setOperand(AstNode operand) {
        this.operand = operand;
        this.type = operand.type;
    }

    @Override
    public String createCTarget() {
        return switch (operator) {
            case Not -> "!(" + operand.createCTarget() + ")";
        };
    }

    @Override
    public String createJavaTarget() {
        return switch (operator) {
            case Not -> "!(" + operand.createJavaTarget() + ")";
        };
    }

    @Override
    public Value interpret(Interpreter interpreter) throws Exception {
        var operandValue = operand.interpret(interpreter);

        if (Objects.requireNonNull(operator) == UnaryOperator.Not) {
            if (!operandValue.is(Type.Boolean)) {
                throw new Exception("Invalid type for unary operator: " + operator);
            }

            return new Value(Type.Boolean, !(boolean) operandValue.getValue());
        }

        throw new Exception("Invalid unary operator: " + operator);
    }
}
