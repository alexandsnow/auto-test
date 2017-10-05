package com.gy.daemon.lib.util;

import java.util.Random;

/**
 * Created by yang_gao on 2017/10/5.
 */
public class StringUtil {


    private static final int UUID_LENGTH = 32;


    public static String makeUUID(){
        String dateStamp = DateUtil.longDateToString(System.currentTimeMillis(), "yyyyMMdd");
        String timeStamp = DateUtil.longDateToString(System.currentTimeMillis(), "HHmmssSSS");
        int offsetLen = (UUID_LENGTH - timeStamp.length()-dateStamp.length());
        String randomStr = genRandomNum(offsetLen);
        return dateStamp+timeStamp+randomStr;
    }

    public static String genRandomNum(int pwd_len) {
        final int maxNum = 36;
        int i;
        int count = 0;
        char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < pwd_len) {
            i = Math.abs(r.nextInt(maxNum));
            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count++;
            }
        }
        return pwd.toString();
    }
}
