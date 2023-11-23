package it.unibo.mvc;

import java.io.File;
import java.io.IOException;

/**
 * Application controller. Performs the I/O.
 */
public class Controller implements FileController{

    @Override
    public void setFile(File f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFile'");
    }

    @Override
    public File getFile() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFile'");
    }

    @Override
    public String getPath() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPath'");
    }

    @Override
    public void writeLine(String s) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeLine'");
    }

}
