package io.main;
import java.util.Arrays;

import io.mode.ArgumentParser;
import io.mode.CLI;

public class Main {
    public static void main(String[] args) {
        try {
            var finalArgs = new java.util.ArrayList<>(Arrays.stream(args).toList());

            if (finalArgs.isEmpty()) {
                System.out.println("Defaulting to generating java code from ./input.isi file");
                System.out.println("Defaulting to printing generated code to stdout");

                System.out.println("To change the default behaviour, use one of the following options:");
                System.out.println("  --target <target>  : specify the target language (java, c) or 'interpret' for interpreting the code or 'repl' for interactive mode");
                System.out.println("  --input <input>    : specify the input file");
                System.out.println("  --output <output>  : specify the output file");
                System.out.println();

                finalArgs.add("--target");
                finalArgs.add("java");
                finalArgs.add("--input");
                finalArgs.add("input.isi");
            }

            ArgumentParser argumentParser = new ArgumentParser();
            var arguments = argumentParser.parse(finalArgs);
            CLI cli = new CLI(arguments.target, arguments.input, arguments.output);

            cli.run();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            System.out.println("Stack trace:");
            ex.printStackTrace();
        }
    }
}