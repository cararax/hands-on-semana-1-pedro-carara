package com.carara.util;

import java.text.SimpleDateFormat;

public class DateUtil {
    public static SimpleDateFormat getDateFormat() {
        return new SimpleDateFormat("dd/MM/yyyy");
    }
    private DateUtil() {
    }
}
