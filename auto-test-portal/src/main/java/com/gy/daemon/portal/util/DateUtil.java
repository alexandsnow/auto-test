package com.gy.daemon.portal.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yang_gao on 2017/10/4.
 */
public class DateUtil {

    public static final String FORMAT_FULL = "yyyy-dd-MM HH:mm:sss";
    public static final String FORMAT_DATE = "yyyy-dd-MM";

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT_FULL = new SimpleDateFormat(FORMAT_FULL);
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT_DATE = new SimpleDateFormat(FORMAT_DATE);

    public static String dateToString(Date date,String formatStr){
        String result=null;
        if(formatStr == null){
            result = SIMPLE_DATE_FORMAT_FULL.format(date);
        }else{
            SimpleDateFormat format = new SimpleDateFormat(formatStr);
            result = format.format(date);
        }
        return result;
    }

    public static Date stringToDate(String dateStr,String formatStr) throws ParseException{
        Date result = null;
        if(formatStr == null){
            try {
                result = SIMPLE_DATE_FORMAT_FULL.parse(dateStr);
            } catch (ParseException e) {
                throw e;
            }
        }else{
            SimpleDateFormat format = new SimpleDateFormat(formatStr);
            result = format.parse(dateStr);
        }
        return result;
    }
}
