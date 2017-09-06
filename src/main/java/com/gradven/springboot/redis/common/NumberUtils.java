package com.gradven.springboot.redis.common;

import java.util.regex.Pattern;

/**
 * Created by liuhangjun on 2017/7/3.
 */
public class NumberUtils {
    
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
