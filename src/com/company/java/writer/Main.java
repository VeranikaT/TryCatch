package com.company.java.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        File myObj = new File("fileWithInputData.txt");
        String str = "";

        try {
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("fileWithInputData.txt");
            myWriter.write("23 45.7 +\n");
            myWriter.write("11 23 -");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter2 = new FileWriter("fileWithOutputData.txt");

            try {
                Scanner myReader = new Scanner(myObj);
                int i = 0;

                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();

                    Pattern p = Pattern.compile("^(\\d+)\\s(\\d+|.*\\d)\\s(.*)");
                    Matcher m = p.matcher(data);

                    if (m.find()) {

                        int x = Integer.valueOf(m.group(1));
                        String operator = m.group(3);

                        if (i == 0) {

                            double y = Double.valueOf(m.group(2));
                            double result = 0;

                            switch (operator) {
                                case ("+"):
                                    result = x + y;
                                    break;
                                case ("-"):
                                    result = x - y;
                                    break;
                            }

                            str = x + m.group(3) + y + "=" + result + "\n";
                            myWriter2.write(str);
                        } else {

                            int y = Integer.valueOf(m.group(2));
                            int result = 0;

                            switch (operator) {
                                case ("+"):
                                    result = x + y;
                                    break;
                                case ("-"):
                                    result = x - y;
                                    break;
                            }
                            str = x + m.group(3) + y + "=" + result + "\n";
                            myWriter2.write(str);
                        }
                        i++;
                    }
                }
                myWriter2.close();
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
