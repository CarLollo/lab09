package it.unibo.mvc;

import java.io.File;
import java.io.IOException;

/**
 * FileController
 */
public interface FileController {

    void setFile(File f);
    
    File getFile();
    
    String getPathFile();

    void writeLine(String s) throws IOException;
}