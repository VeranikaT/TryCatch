package com.trafimchuk.veranika.excs.service;

import com.trafimchuk.veranika.excs.model.Data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriterService {

    private String pathToOutput;
    private List<Data> list;

    public WriterService(String pathToOutput, List<Data> list) {
        this.pathToOutput = pathToOutput;
        this.list = list;
    }

    private String formatData(Data data) {

        String sign = "";
        String outString = "";

        switch (data.getSign()) {

            case PLUS:
                sign = "+";
                break;
            case MINUS:
                sign = "-";
                break;
            case DIVIDE:
                sign = "/";
                break;
            case MULTIPLY:
                sign = "*";
                break;
            default:
                System.out.println("Bye-bye");
                break;
        }

        outString = new StringBuilder().append(data.getX()).append(sign).append(data.getY()).append("=").append(data.getRes()).append("\n").toString();

        return outString;
    }

    public boolean save() {
        FileWriter writer = null;
        List<Data> result = new ArrayList<Data>();

        try {
            writer = new FileWriter(pathToOutput);
            for (Data data : list) {
                writer.write(formatData(data));
                writer.flush();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
