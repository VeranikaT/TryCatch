package com.trafimchuk.veranika.excs.service;

import com.trafimchuk.veranika.excs.exception.InvalidFormatException;
import com.trafimchuk.veranika.excs.exception.NoSuchOperationException;
import com.trafimchuk.veranika.excs.model.Data;
import com.trafimchuk.veranika.excs.model.Sign;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserService {

    public Data parseData(String line) throws InvalidFormatException, NoSuchOperationException {

        Data data = new Data();

        Pattern p = Pattern.compile("^(\\d+)\\s(\\d+|.*\\d)\\s(.*)");
        Matcher m = p.matcher(line);

        if (m.find()) {
            data.setX(Double.valueOf(m.group(1)));
            data.setY(Double.valueOf(m.group(2)));

            switch (m.group(3)){
                case "+":
                    data.setSign(Sign.PLUS);
                    break;
                case "-":
                    data.setSign(Sign.MINUS);
                    break;
                case "/":
                    data.setSign(Sign.DIVIDE);
                    break;
                case "*":
                    data.setSign(Sign.MULTIPLY);
                    break;
            }

        } else {
            throw new InvalidFormatException("Input data is not valid");
        }

        switch (data.getSign()) {

            case PLUS:
                data.setRes(data.getX().doubleValue() + data.getY().doubleValue());
                break;
            case MINUS:
                data.setRes(data.getX().doubleValue() - data.getY().doubleValue());
                break;
            case DIVIDE:
                data.setRes(data.getX().doubleValue() / data.getY().doubleValue());
                break;
            case MULTIPLY:
                data.setRes(data.getX().doubleValue() * data.getY().doubleValue());
                break;
            default:
                throw new NoSuchOperationException("Inputted sign is not correct. PLUS, MINUS, DIVIDE, MULTIPLY - only.");
        }
        return data;
    }

}
