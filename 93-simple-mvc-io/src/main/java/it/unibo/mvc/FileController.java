package it.unibo.mvc;

import java.io.File;
import java.io.IOException;

/**
 * FileController
 */
public interface FileController {

    void setFile(File f);
    
    File getFile();
    
    String getPath();

    void writeLine(String s) throws IOException;
}