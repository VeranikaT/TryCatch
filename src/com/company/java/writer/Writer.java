package com.company.java.writer;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private FileWriter writer;
    private String newString;

    public Writer() {
    }

    public Writer(FileWriter writer, String newString) {
        this.writer = writer;
        this.newString = newString;
    }

    public void writeFile() throws IOException {

        try {
            if (newString.isEmpty())
                throw new WriterException("There is nothing to write in the file");
        } catch (WriterException e) {
            e.printStackTrace();
        }
        writer.write(newString);
        return;
    }
}
