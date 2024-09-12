package io.compiler.c_compiler;

import io.compiler.core.program.Program;
import io.compiler.generator.Generator;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class CGenerator implements Generator {
    @Override
    public String create(Program script) {
        return script.createCTarget();
    }

    @Override
    public void scriptToFile(Program script, String location) {
        String cCode = create(script);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(location));
            writer.write(cCode);
            writer.close();
        } catch (Exception exception) {
            System.err.println("Error: " + exception.getMessage());
            System.out.println("Stack trace:");
            exception.printStackTrace();
        }
    }
}
