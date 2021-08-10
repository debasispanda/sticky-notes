package com.dpanda.stickynotes.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    public static Date stringToDate(String s, String format) {
        try {
            return new SimpleDateFormat(format).parse(s);
        } catch (ParseException e) {
            throw new IllegalArgumentException(String.format("Date (%s) must be in format (%s)", s, format));
        }
    }
}
