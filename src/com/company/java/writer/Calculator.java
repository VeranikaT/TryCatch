package com.company.java.writer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private String str;

    public Calculator(String str) {
        this.str = str;
    }

    public String getNewString() {
        Pattern p = Pattern.compile("^(\\d+)\\s(\\d+|.*\\d)\\s(.*)");
        Matcher m = p.matcher(str);

        if (m.find()) {

            try {
                if(m.group(2).contains("."))
                throw new CalculatorException("Not valid type. Number is double");
            } catch (CalculatorException e) {
                e.printStackTrace();
            }

            String operator = m.group(3);
            double y = Double.valueOf(m.group(2));
            int x = Integer.valueOf(m.group(1));
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
        }
        return str;
    }
}
