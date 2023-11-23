package it.unibo.mvc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller implements FileController{
    private File currentFile;

    public Controller() {
        final String filePath = System.getProperty("user.home") + System.getProperty("file.separator") + "output.txt";
        this.currentFile = new File(filePath);
    }

    @Override
    public void setFile(File f) {
        this.currentFile = f;
    }

    @Override
    public File getFile() {
        return this.currentFile;
    }

    @Override
    public String getPath() {
        //ritorna il pathname corretto, non è ricorsivo
        return this.currentFile.getPath();
    }

    @Override
    public void writeLine(String s) throws IOException {
        try (FileOutputStream fileStream = new FileOutputStream(this.getPath())) {
            byte[] stringBytes = s.getBytes();
            fileStream.write(stringBytes);
        } 
    }

}
