package io.compiler.java_compiler;

import io.compiler.core.program.Program;
import io.compiler.generator.Generator;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class JavaGenerator implements Generator {
    @Override
    public String create(Program script) {
        return script.createJavaTarget();
    }

    @Override
    public void scriptToFile(Program script, String location) {
        String javaCode = create(script);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(location));

            writer.write(javaCode);
            writer.close();
        } catch (Exception exception) {
            System.err.println("Error: " + exception.getMessage());
            System.out.println("Stack trace:");
            exception.printStackTrace();
        }
    }
}
