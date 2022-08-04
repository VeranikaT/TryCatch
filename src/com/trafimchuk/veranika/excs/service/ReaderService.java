package com.trafimchuk.veranika.excs.service;

import com.trafimchuk.veranika.excs.exception.InvalidFormatException;
import com.trafimchuk.veranika.excs.exception.NoSuchOperationException;
import com.trafimchuk.veranika.excs.exception.ParserDataException;
import com.trafimchuk.veranika.excs.model.Data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderService {

    private String pathToData;
    private ParserService parser;

    public ReaderService(String pathToData, ParserService parser) {
        this.pathToData = pathToData;
        this.parser = parser;
    }

    public List<Data> takeDataList() throws ParserDataException, InvalidFormatException {

        FileReader fileReader = null;
        List<Data> list = new ArrayList();

        try {
            fileReader = new FileReader(pathToData);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                Data line = parser.parseData(scanner.nextLine());
                list.add(line);
            }

        } catch (FileNotFoundException e) {
            throw new ParserDataException(e);
        } catch (IOException e) {
            throw new ParserDataException(e);
        } catch (NoSuchOperationException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new ParserDataException(e);
                }
            }
        }

        return list;

    }

}
