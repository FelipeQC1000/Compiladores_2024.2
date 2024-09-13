package io.main;
import java.util.Arrays;

import io.mode.ArgumentParser;
import io.mode.CLI;

public class Main {
    public static void main(String[] args) {
        var Arguments = new java.util.ArrayList<>(Arrays.stream(args).toList());

        if (Arguments.isEmpty()) {
            Arguments.add("--target");
            Arguments.add("java");
            Arguments.add("--input");
            Arguments.add("input.isi");
            System.out.println("\nPor padrão, o programa roda gerando código em Java a partir do arquivo input.isi, e imprime o resultado no Terminal.");
            System.out.println("Se deseja mudar este comportamento, adicione: --target para definir o modo (java, interpret, repl, ou c), --input para definir arquivo de entrada,");
            System.out.println("e --output para definir caminho de saída.\n");
        }
        ArgumentParser argumentParser = new ArgumentParser();
        var settings = argumentParser.parse(Arguments);
        CLI cli = new CLI(settings.target, settings.input, settings.output);
        cli.run();
    }
}
