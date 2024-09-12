package io.compiler.core.ast;

import io.compiler.core.operators.BinaryOperator;
import io.compiler.types.Type;
import io.interpreter.Interpreter;
import io.interpreter.Value;

public class BinaryExpression extends AstNode {
    private AstNode left;
    private AstNode right;
    private final BinaryOperator operator;

    public BinaryExpression(AstNode left, BinaryOperator operator, AstNode right) {
        super(left.type);
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public BinaryExpression(char operator) {
        super(Type.Void);
        this.operator = BinaryOperator.fromString(String.valueOf(operator));
    }

    public BinaryExpression(BinaryOperator operator) {
        super(Type.Void);
        this.operator = operator;
    }

    public AstNode getLeft() {
        return left;
    }

    public void setLeft(AstNode left) {
        this.left = left;
        this.type = left.type;
    }

    public AstNode getRight() {
        return right;
    }

    public void setRight(AstNode right) {
        this.right = right;
    }

    public BinaryOperator getOperator() {
        return operator;
    }

    @Override
    public String createCTarget() {
        return switch (operator) {
            case Addition -> left.createCTarget() + " + " + right.createCTarget();
            case Subtraction -> left.createCTarget() + " - " + right.createCTarget();
            case Multiplication -> left.createCTarget() + " * " + right.createCTarget();
            case Division -> left.createCTarget() + " / " + right.createCTarget();
            case LessThan -> left.createCTarget() + " < " + right.createCTarget();
            case LessThanOrEqualTo -> left.createCTarget() + " <= " + right.createCTarget();
            case GreaterThan -> left.createCTarget() + " > " + right.createCTarget();
            case GreaterThanOrEqualTo -> left.createCTarget() + " >= " + right.createCTarget();
            case Equals -> left.createCTarget() + " == " + right.createCTarget();
            case NotEquals -> left.createCTarget() + " != " + right.createCTarget();
            case And -> left.createCTarget() + " && " + right.createCTarget();
            case Or -> left.createCTarget() + " || " + right.createCTarget();
        };
    }

    @Override
    public String createJavaTarget() {
        return switch (operator) {
            case Addition -> left.createJavaTarget() + " + " + right.createJavaTarget();
            case Subtraction -> left.createJavaTarget() + " - " + right.createJavaTarget();
            case Multiplication -> left.createJavaTarget() + " * " + right.createJavaTarget();
            case Division -> left.createJavaTarget() + " / " + right.createJavaTarget();
            case LessThan -> left.createJavaTarget() + " < " + right.createJavaTarget();
            case LessThanOrEqualTo -> left.createJavaTarget() + " <= " + right.createJavaTarget();
            case GreaterThan -> left.createJavaTarget() + " > " + right.createJavaTarget();
            case GreaterThanOrEqualTo -> left.createJavaTarget() + " >= " + right.createJavaTarget();
            case Equals -> left.createJavaTarget() + " == " + right.createJavaTarget();
            case NotEquals -> left.createJavaTarget() + " != " + right.createJavaTarget();
            case And -> left.createJavaTarget() + " && " + right.createJavaTarget();
            case Or -> left.createJavaTarget() + " || " + right.createJavaTarget();
        };
    }

    @Override
    public Value interpret(Interpreter interpreter) throws Exception {
        var leftValue = left.interpret(interpreter);
        var rightValue = right.interpret(interpreter);

        switch (operator) {
            case Addition: {
                if (leftValue.is(Type.Integer) && rightValue.is(Type.Integer)) {
                    var leftInt = (int) leftValue.getValue();
                    var rightInt = (int) rightValue.getValue();

                    return new Value(Type.Integer, leftInt + rightInt);
                }

                if (leftValue.is(Type.Float) && rightValue.is(Type.Float)) {
                    var leftFloat = (float) leftValue.getValue();
                    var rightFloat = (float) rightValue.getValue();

                    return new Value(Type.Float, leftFloat + rightFloat);
                }

                throw new Exception("Invalid operation: Addition between " + leftValue.getType() + " and " + rightValue.getType());
            }
            case Subtraction: {
                if (leftValue.is(Type.Integer) && rightValue.is(Type.Integer)) {
                    var leftInt = (int) leftValue.getValue();
                    var rightInt = (int) rightValue.getValue();

                    return new Value(Type.Integer, leftInt - rightInt);
                }

                if (leftValue.is(Type.Float) && rightValue.is(Type.Float)) {
                    var leftFloat = (float) leftValue.getValue();
                    var rightFloat = (float) rightValue.getValue();

                    return new Value(Type.Float, leftFloat - rightFloat);
                }

                throw new Exception("Invalid operation: Subtraction between " + leftValue.getType() + " and " + rightValue.getType());
            }
            case Multiplication: {
                if (leftValue.is(Type.Integer) && rightValue.is(Type.Integer)) {
                    var leftInt = (int) leftValue.getValue();
                    var rightInt = (int) rightValue.getValue();

                    return new Value(Type.Integer, leftInt * rightInt);
                }

                if (leftValue.is(Type.Float) && rightValue.is(Type.Float)) {
                    var leftFloat = (float) leftValue.getValue();
                    var rightFloat = (float) rightValue.getValue();

                    return new Value(Type.Float, leftFloat * rightFloat);
                }

                throw new Exception("Invalid operation: Multiplication between " + leftValue.getType() + " and " + rightValue.getType());
            }
            case Division: {
                if (leftValue.is(Type.Integer) && rightValue.is(Type.Integer)) {
                    var leftInt = (int) leftValue.getValue();
                    var rightInt = (int) rightValue.getValue();

                    if (rightInt == 0) {
                        throw new Exception("Division by zero");
                    }

                    return new Value(Type.Integer, leftInt / rightInt);
                }

                if (leftValue.is(Type.Float) && rightValue.is(Type.Float)) {
                    var leftFloat = (float) leftValue.getValue();
                    var rightFloat = (float) rightValue.getValue();

                    if (rightFloat == 0) {
                        throw new Exception("Division by zero");
                    }

                    return new Value(Type.Float, leftFloat / rightFloat);
                }

                throw new Exception("Invalid operation: Division between " + leftValue.getType() + " and " + rightValue.getType());
            }
            case Equals: {
                return new Value(Type.Boolean, leftValue.equals(rightValue));
            }
            case NotEquals: {
                return new Value(Type.Boolean, !leftValue.equals(rightValue));
            }
            case GreaterThan: {
                if (leftValue.is(Type.Integer) && rightValue.is(Type.Integer)) {
                    var leftInt = (int) leftValue.getValue();
                    var rightInt = (int) rightValue.getValue();

                    return new Value(Type.Boolean, leftInt > rightInt);
                }

                if (leftValue.is(Type.Float) && rightValue.is(Type.Float)) {
                    var leftFloat = (float) leftValue.getValue();
                    var rightFloat = (float) rightValue.getValue();

                    return new Value(Type.Boolean, leftFloat > rightFloat);
                }

                throw new Exception("Invalid operation: GreaterThan between " + leftValue.getType() + " and " + rightValue.getType());
            }
            case GreaterThanOrEqualTo: {
                if (leftValue.is(Type.Integer) && rightValue.is(Type.Integer)) {
                    var leftInt = (int) leftValue.getValue();
                    var rightInt = (int) rightValue.getValue();

                    return new Value(Type.Boolean, leftInt >= rightInt);
                }

                if (leftValue.is(Type.Float) && rightValue.is(Type.Float)) {
                    var leftFloat = (float) leftValue.getValue();
                    var rightFloat = (float) rightValue.getValue();

                    return new Value(Type.Boolean, leftFloat >= rightFloat);
                }

                throw new Exception("Invalid operation: GreaterThanOrEqual between " + leftValue.getType() + " and " + rightValue.getType());
            }
            case LessThan: {
                if (leftValue.is(Type.Integer) && rightValue.is(Type.Integer)) {
                    var leftInt = (int) leftValue.getValue();
                    var rightInt = (int) rightValue.getValue();

                    return new Value(Type.Boolean, leftInt < rightInt);
                }

                if (leftValue.is(Type.Float) && rightValue.is(Type.Float)) {
                    var leftFloat = (float) leftValue.getValue();
                    var rightFloat = (float) rightValue.getValue();

                    return new Value(Type.Boolean, leftFloat < rightFloat);
                }

                throw new Exception("Invalid operation: LessThan between " + leftValue.getType() + " and " + rightValue.getType());
            }
            case LessThanOrEqualTo: {
                if (leftValue.is(Type.Integer) && rightValue.is(Type.Integer)) {
                    var leftInt = (int) leftValue.getValue();
                    var rightInt = (int) rightValue.getValue();

                    return new Value(Type.Boolean, leftInt <= rightInt);
                }

                if (leftValue.is(Type.Float) && rightValue.is(Type.Float)) {
                    var leftFloat = (float) leftValue.getValue();
                    var rightFloat = (float) rightValue.getValue();

                    return new Value(Type.Boolean, leftFloat <= rightFloat);
                }

                throw new Exception("Invalid operation: LessThanOrEqual between " + leftValue.getType() + " and " + rightValue.getType());
            }
            case And: {
                if (leftValue.is(Type.Boolean) && rightValue.is(Type.Boolean)) {
                    var leftBool = (boolean) leftValue.getValue();
                    var rightBool = (boolean) rightValue.getValue();

                    return new Value(Type.Boolean, leftBool && rightBool);
                }

                throw new Exception("Invalid operation: And between " + leftValue.getType() + " and " + rightValue.getType());
            }
            case Or: {
                if (leftValue.is(Type.Boolean) && rightValue.is(Type.Boolean)) {
                    var leftBool = (boolean) leftValue.getValue();
                    var rightBool = (boolean) rightValue.getValue();

                    return new Value(Type.Boolean, leftBool || rightBool);
                }

                throw new Exception("Invalid operation: Or between " + leftValue.getType() + " and " + rightValue.getType());
            }
            default: throw new Exception("Not implemented yet");
        }
    }
}
