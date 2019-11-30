package com.example.menuhub;

import java.util.regex.Pattern;

public class StringUtl {

    public static String filter(String str) {
        String regEx = "[`~!@#$%^&*()+=|{}:;\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        String rs = Pattern.compile(regEx).matcher(str).replaceAll("").trim();
        return rs;
    }

    public static boolean notNull(String str) {
        return str != null && str.length() != 0;
    }

}
