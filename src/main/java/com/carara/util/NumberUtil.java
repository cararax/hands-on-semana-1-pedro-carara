package com.carara.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberUtil {
    public static Double parseNumber(String number) throws ParseException {
        if (number == null) {
            return Double.valueOf("0");
        }
        NumberFormat numberFormatter = NumberFormat.getNumberInstance(Locale.forLanguageTag("pt-BR"));
        return numberFormatter.parse(number).doubleValue();
    }
}
