package io.mode;

import io.compiler.c_compiler.CGenerator;
import io.compiler.core.ast.IdentifierNode;
import io.compiler.core.ast.commands.Expression;
import io.compiler.core.generated.IsiLangLexer;
import io.compiler.core.generated.IsiLangParser;
import io.compiler.java_compiler.JavaGenerator;
import io.compiler.types.Binding;
import io.interpreter.Interpreter;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.HashMap;
import java.util.Scanner;

public class CLI {
    public enum Target {
        Java,
        Interpret,
        C,
        REPL,
    }

    private final Target target;
    private final String input;
    private final String output;

    public CLI(Target target, String input, String output) {
        this.target = target;
        this.input = input;
        this.output = output;
    }

    public void run() {
        try {
            IsiLangLexer lexer;
            IsiLangParser parser;

            if (target == Target.REPL) {
                System.out.println("REPL mode enabled. Type __exit__ to exit.");

                var scanner = new Scanner(System.in);
                var interpreter = new Interpreter(null);

                var symbols = new HashMap<String, Binding>();

                while (true) {
                    var line = scanner.nextLine();

                    lexer = new IsiLangLexer(CharStreams.fromString(line));
                    CommonTokenStream tokenStream = new CommonTokenStream(lexer);
                    parser = new IsiLangParser(tokenStream);
                    parser.setSymbols(symbols);

                    parser.repl_line();
                    symbols = parser.getSymbols();

                    var input = parser.getStatements().getFirst();

                    if (input instanceof Expression expressionStatement) {
                        if (expressionStatement.getExpression() instanceof IdentifierNode identifierNode) {
                            if (identifierNode.getName().equals("__exit__")) {
                                break;
                            }
                        }
                    }

                    interpreter.cliRun(input);
                }

                scanner.close();
                return;
            }

            if (input == null) {
                System.out.println("Input file not specified, defaulting to ./input.isi");
            }

            lexer = new IsiLangLexer(CharStreams.fromFileName(input));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            parser = new IsiLangParser(tokenStream);

            parser.program();
            var program = parser.getProgram();

            switch (target) {
                case Java: {
                    var javaGenerator = new JavaGenerator();

                    if (output == null) {
                        var code = javaGenerator.create(program);
                        System.out.println(code);
                    } else {
                        javaGenerator.scriptToFile(program, output);
                    }

                    break;
                }
                case C: {
                    var cGenerator = new CGenerator();

                    if (output == null) {
                        var code = cGenerator.create(program);
                        System.out.println(code);
                    } else {
                        cGenerator.scriptToFile(program, output);
                    }

                    break;
                }
                case Interpret: {
                    var interpreter = new Interpreter(program);
                    interpreter.run();
                }
            default:
                break;
            }
        } catch (Exception exception) {
            System.err.println("Error: " + exception.getMessage());
            System.out.println("Stack trace:");
            exception.printStackTrace();
        }
    }
}
