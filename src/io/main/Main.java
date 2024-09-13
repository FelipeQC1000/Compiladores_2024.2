package io.main;
import java.util.Arrays;

import io.mode.ArgumentParser;
import io.mode.CLI;

public class Main {
    public static void main(String[] args) {
        try {
            var finalArgs = new java.util.ArrayList<>(Arrays.stream(args).toList());

            if (finalArgs.isEmpty()) {
                System.out.println("\nPor padrão, o programa roda gerando código em Java a partir do arquivo input.isi, e imprime o resultado no Terminal.");
                System.out.println("Se deseja mudar este comportamento, adicione:");
                System.out.println("  --target + 'java', 'c', 'interpret' ou 'repl' para gerar código de Java, C, rodar como interpretador, ou de forma interativa, respectivamente.");
                System.out.println("  --input + <caminho do arquivo> para definir o código que o programa lê a partir de um arquivo.");
                System.out.println("  --output + <caminho destino> para definir onde o código deve imprimir o resultado.");
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
