package io.compiler.core.operators;

public enum BinaryOperator {
    Addition(1),
    Subtraction(1),
    Multiplication(2),
    Division(2),
    And(5),
    Or(6),
    Equals(4),
    NotEquals(4),
    LessThan(3),
    LessThanOrEqualTo(3),
    GreaterThan(3),
    GreaterThanOrEqualTo(3);

    private final int value;

    private BinaryOperator(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BinaryOperator fromString(String value) {
        return switch (value) {
            case "+" -> Addition;
            case "-" -> Subtraction;
            case "*" -> Multiplication;
            case "/" -> Division;
            case "&&" -> And;
            case "||" -> Or;
            case "==" -> Equals;
            case "!=" -> NotEquals;
            case "<" -> LessThan;
            case "<=" -> LessThanOrEqualTo;
            case ">" -> GreaterThan;
            case ">=" -> GreaterThanOrEqualTo;
            default -> throw new IllegalArgumentException("Incorrect binary operator: " + value);
        };
    }
}
