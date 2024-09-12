grammar IsiLang;

@header {
    import io.compiler.core.ast.*;
    import io.compiler.core.ast.commands.*;
    import io.compiler.core.operators.*;
    import io.compiler.core.exceptions_warnings.*;
    import io.compiler.core.program.*;
    import io.compiler.types.*;
    import java.util.Stack;
    import java.util.ArrayList;
    import java.util.HashMap;
}

@members {
    private Program program;
    private HashMap<String, Binding> symbols = new HashMap<String, Binding>();

    private Stack<AstNode> stack = new Stack<AstNode>();
    private AstNode root = null;

    public AstNode getRoot(){
        if (root == null) {
            root = stack.pop();
        }

        return root;
    }

    private ArrayList<StatementNode> statements = new ArrayList<StatementNode>();
    private ArrayList<BindingNode> declarations = new ArrayList<BindingNode>();

    public ArrayList<StatementNode> getStatements() {
        return statements;
    }

    public ArrayList<BindingNode> getDeclarations() {
        return declarations;
    }

    private void addStatement(StatementNode statement) {
        statements.add(statement);
    }

    private void addDeclaration(BindingNode declaration) {
        declarations.add(declaration);
    }

    private boolean isInitializingVariable = false;
    private boolean hasElseBranch = false;

    public Program getProgram() {
        return program;
    }

    public void setSymbols(HashMap<String, Binding> symbols) {
        this.symbols = symbols;
    }

    public HashMap<String, Binding> getSymbols() {
        return symbols;
    }
}

END_OF_LINE : ';';

TRUE : 'verdadeiro';
FALSE : 'falso';

IDENTIFIER : [a-zA-Z_]([a-zA-Z_0-9])*;
NUM : ('-')?[0-9]+('.'[0-9]+)?;
STRING : '"' ~[\r\n"]* '"';

OP_OR : '||';
OP_AND : '&&';
OP_COMP : '==' | '!=';
OP_REL : '<' | '>' | '<=' | '>=';
OP_TERM : '+' | '-';
OP_FACTOR : '*' | '/';
OP_NOT : '!';

DOT : '.';

OPEN_PAREN : '(';
CLOSE_PAREN : ')';

OPEN_BRACE : '{';
CLOSE_BRACE : '}';

WS			: (' ' | '\n' | '\r' | '\t' ) -> skip
			;


program : 'programa' declaration 'inicio' block 'fimprog' DOT {
    for (var declaration : declarations) {
        var identifier = declaration.getIdentifier();
        var symbol = symbols.get(identifier);

        if (!symbol.isUsed()) {
            var warning = new UnusedVariableWarning(identifier);
            System.out.println("AVISO: " + warning.getMessage());
        }
    }

    var program_ = new Program(declarations, statements, symbols);
    this.program = program_;
};

declaration : assignment*;
block : statement+;

assignment : ('inteiro' | 'flutuante' | 'texto' | 'booleano') {
    var typeString = _input.LT(-1).getText();
    var type = Type.fromString(typeString);
} IDENTIFIER {
    var identifierString = _input.LT(-1).getText();
    var identifier = new IdentifierNode(identifierString);

    if (symbols.containsKey(identifier.getName())) {
        throw new AlreadyDeclaredVariableException(identifier.getName());
    }
} ('=' {
    isInitializingVariable = true;
} expression)? {
    var initializer = isInitializingVariable ? stack.pop() : null;

    if (isInitializingVariable && initializer.getType() != type) {
        throw new DeclarationTypeMismatchException(identifier.getName(), type, initializer.getType());
    }

    var binding = new BindingNode(identifier.getName(), type, initializer);
    addDeclaration(binding);

    symbols.put(identifier.getName(), binding.asBinding());
    isInitializingVariable = false;
} END_OF_LINE;

statement : print | read | if | attribution | while | do_while;

repl_line : {
    statements.clear();
    declarations.clear();
} assignment {
    var lastDeclaration = declarations.get(declarations.size() - 1);
    declarations.remove(declarations.size() - 1);

    var declarationStatement = new Expression(lastDeclaration);
    statements.add(declarationStatement);
} | statement | expression {
    var expression = stack.pop();
    var expressionCom = new Expression(expression);

    addStatement(expressionCom);
};

print : 'imprima' OPEN_PAREN expression CLOSE_PAREN END_OF_LINE {
    var printCom = new Print(stack.pop());
    addStatement(printCom);
};

read : 'receba' OPEN_PAREN identifier {
    var identifier = (IdentifierNode)stack.pop();
    var symbol = symbols.get(identifier.getName());
    var symbolType = symbol.getType();
} CLOSE_PAREN END_OF_LINE {
    var read = new Read(identifier.getName(), symbolType);
    addStatement(read);
};

while : 'enquanto' OPEN_PAREN expression {
    var condition = stack.pop();
    var body = new ArrayList<StatementNode>();
} CLOSE_PAREN OPEN_BRACE (statement {
    var lastStatement = statements.get(statements.size() - 1);
    statements.remove(statements.size() - 1);

    body.add(lastStatement);
})+ CLOSE_BRACE {
    var whileCom = new While(condition, body);
    addStatement(whileCom);
};

do_while : 'faca' {
    var body = new ArrayList<StatementNode>();
} OPEN_BRACE (statement {
    var lastStatement = statements.get(statements.size() - 1);
    statements.remove(statements.size() - 1);

    body.add(lastStatement);
})* CLOSE_BRACE 'enquanto' OPEN_PAREN expression {
    var condition = stack.pop();
} CLOSE_PAREN END_OF_LINE {
    var doWhile = new DoWhile(body, condition);
    addStatement(doWhile);
};

attribution : attributionl END_OF_LINE;

attributionl : IDENTIFIER {
    var identifierString = _input.LT(-1).getText();
    var identifier = new IdentifierNode(identifierString);

    if (!symbols.containsKey(identifier.getName())) {
       throw new UndeclaredVariableException(identifier.getName());
    }

    var symbol = symbols.get(identifier.getName());
    var symbolType = symbol.getType();
    } '=' expression {
    var expression = stack.pop();

    if (symbolType != expression.getType()) {
       throw new AssignmentTypeMismatchException(symbolType, expression.getType());
    }

    var assignment = new Assignment(identifier.getName(), expression);
    symbol.setInitialized();

    addStatement(assignment);
};

if : 'se' OPEN_PAREN expression {
    var condition = stack.pop();

    var thenBranch = new ArrayList<StatementNode>();
    var elseBranch = new ArrayList<StatementNode>();
} CLOSE_PAREN OPEN_BRACE (statement {
    var lastStatement = statements.get(statements.size() - 1);
    statements.remove(statements.size() - 1);

    thenBranch.add(lastStatement);
})+ CLOSE_BRACE ('senao' {
    hasElseBranch = true;
} OPEN_BRACE (statement {
    if (hasElseBranch) {
        var lastStatement = statements.get(statements.size() - 1);
        statements.remove(statements.size() - 1);

        elseBranch.add(lastStatement);
    }
})+ CLOSE_BRACE)? {
    var ifCom = new If(condition, thenBranch, elseBranch);
    addStatement(ifCom);

    hasElseBranch = false;
};

expression : logical_or;
logical_or : logical_and logical_orl;

logical_orl : ((OP_OR) {
    var operator = BinaryOperator.fromString(_input.LT(-1).getText());
    var binaryOperation = new BinaryExpression(operator);

    binaryOperation.setLeft(stack.pop());
} equality {
    binaryOperation.setRight(stack.pop());
    stack.push(binaryOperation);
})*;

logical_and : equality logical_andl;

logical_andl : ((OP_AND) {
    var operator = BinaryOperator.fromString(_input.LT(-1).getText());
    var binaryOperation = new BinaryExpression(operator);

    binaryOperation.setLeft(stack.pop());
} equality {
    binaryOperation.setRight(stack.pop());
    stack.push(binaryOperation);
})*;

equality : comparison equalityl;

equalityl : ((OP_COMP) {
    var operator = BinaryOperator.fromString(_input.LT(-1).getText());
    var binaryOperation = new BinaryExpression(operator);

    binaryOperation.setLeft(stack.pop());
} comparison {
    binaryOperation.setRight(stack.pop());
    stack.push(binaryOperation);
})*;

comparison : term comparisonl;

comparisonl : ((OP_REL) {
    var operator = BinaryOperator.fromString(_input.LT(-1).getText());
    var binaryOperation = new BinaryExpression(operator);

    binaryOperation.setLeft(stack.pop());
} term {
    binaryOperation.setRight(stack.pop());
    stack.push(binaryOperation);
})*;

term : factor terml;

terml : ((OP_TERM) {
    var operator = BinaryOperator.fromString(_input.LT(-1).getText());
    var binaryOperation = new BinaryExpression(operator);

    binaryOperation.setLeft(stack.pop());
} factor {
    binaryOperation.setRight(stack.pop());
    stack.push(binaryOperation);
})*;

factor : unary factorl;

factorl : ((OP_FACTOR) {
    var operator = BinaryOperator.fromString(_input.LT(-1).getText());
    var binaryOperation = new BinaryExpression(operator);

    if (stack.peek().isLiteral() || stack.peek().isIdentifier()) {
        binaryOperation.setLeft(stack.pop());
    } else {
        var other = (BinaryExpression)stack.pop();

        if (other.getOperator().getValue() < operator.getValue()) {
            binaryOperation.setLeft(other.getRight());
            other.setRight(binaryOperation);
        } else {
            binaryOperation.setLeft(other);
            stack.push(binaryOperation);
        }
    }
} unary {
    binaryOperation.setRight(stack.pop());
    stack.push(binaryOperation);
})*;

unary : grouped_expression | boolean_literal | unary_op | NUM {
    if (_input.LT(-1).getText().contains(".")) {
        var floatLiteral = new FloatLiteral(Float.parseFloat(_input.LT(-1).getText()));
        stack.push(floatLiteral);
    } else {
        var intLiteral = new IntegerLiteral(Integer.parseInt(_input.LT(-1).getText()));
        stack.push(intLiteral);
    }
} | identifier | STRING {
    var stringLiteral = new StringLiteral(_input.LT(-1).getText());
    stack.push(stringLiteral);
};

grouped_expression : OPEN_PAREN expression CLOSE_PAREN;

boolean_literal : (TRUE | FALSE) {
    var booleanLiteral = new BooleanLiteral(_input.LT(-1).getText().equals("verdadeiro"));
    stack.push(booleanLiteral);
};

identifier : IDENTIFIER {
    var identifier = new IdentifierNode(_input.LT(-1).getText());

    if (symbols.containsKey(identifier.getName())) {
     var binding = symbols.get(identifier.getName());
     identifier.setType(binding.getType());

     var isInitialized = binding.isInitialized();
     if (!isInitialized) {
         var warning = new VariableUsedWithoutInitializationWarning(identifier.getName());
         System.out.println("AVISO: " + warning.getMessage());
     }

     binding.setUsed();
    }

    stack.push(identifier);
};

unary_op : OP_NOT {
    var operator = UnaryOperator.fromString(_input.LT(-1).getText());
    var unaryOperation = new UnaryExpression(operator);
} (boolean_literal | identifier {
    unaryOperation.setOperand(stack.pop());
    stack.push(unaryOperation);
});

