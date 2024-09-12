package io.mode;

import java.util.List;

public class ArgumentParser {
    public static class Arguments {
        public final CLI.Target target;
        public final String input;
        public final String output;

        public Arguments(CLI.Target target, String input, String output) {
            this.target = target;
            this.input = input;
            this.output = output;
        }
    }

    public Arguments parse(List<String> args) {
        var targetIndex = args.indexOf("--target");
        var targetString = args.get(targetIndex + 1);

        var inputIndex = args.contains("--input")
                ? args.indexOf("--input")
                : -1;
        var inputString = inputIndex != -1 ? args.get(inputIndex + 1) : null;

        var outputIndex = args.contains("--output")
                ? args.indexOf("--output")
                : -1;
        var outputString = outputIndex != -1 ? args.get(outputIndex + 1) : null;
        var target = switch (targetString) {
            case "java" -> CLI.Target.Java;
            case "interpret" -> CLI.Target.Interpret;
            case "c" -> CLI.Target.C;
            case "repl" -> CLI.Target.REPL;
            default -> throw new IllegalArgumentException("Invalid target");
        };

        return new Arguments(target, inputString, outputString);
    }
}
