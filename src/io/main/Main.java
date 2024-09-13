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
            System.out.println("\nPor padrão, o programa roda gerando código em Java a partir do arquivo input.isi, e imprime o resultado no Terminal. Se deseja mudar este comportamento, adicione:");
            System.out.println("  --target + 'java', 'c', 'interpret' ou 'repl' para gerar código de Java, C, rodar como interpretador, ou de forma interativa, respectivamente.");
            System.out.println("  --input + <caminho do arquivo> para definir o código que o programa lê a partir de um arquivo.");
            System.out.println("  --output + <caminho destino> para definir onde o código deve imprimir o resultado.");
            System.out.println();
        }
        ArgumentParser argumentParser = new ArgumentParser();
        var settings = argumentParser.parse(Arguments);
        CLI cli = new CLI(settings.target, settings.input, settings.output);
        cli.run();
    }
}
