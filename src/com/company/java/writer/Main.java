package com.company.java.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("resources/file.txt");
        FileWriter writer = new FileWriter("resources/file2.txt");

        Scanner scn = new Scanner(file);

        while (scn.hasNextLine()) {
            Calculator clc = new Calculator(scn.nextLine());

            Writer wrt = new Writer(writer, clc.getNewString());
            wrt.writeFile();
        }

        writer.close();

    }
}
