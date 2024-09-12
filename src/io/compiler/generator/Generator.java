package io.compiler.generator;

import io.compiler.core.program.Program;

public interface Generator {
    String create(Program program);
    void scriptToFile(Program program, String path);
}
