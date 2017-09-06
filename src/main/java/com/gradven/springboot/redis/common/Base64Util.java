package com.gradven.springboot.redis.common;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Created by liuhangjun on 2017/7/20.
 */
public class Base64Util {
    
    /**
     * 编码
     * @param text
     * @return
     */
    public static String encode(String text){
        final Base64.Encoder encoder = Base64.getEncoder();
    
        final byte[] textByte;
        String encodedText = null;
        try {
            textByte = text.getBytes(Constants.CHARSET);
            encodedText = encoder.encodeToString(textByte);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
        return encodedText;
    }
    
    /**
     * 解码
     * @return
     */
    public static String decode(String encodedText){
        final Base64.Decoder decoder = Base64.getDecoder();
    
        String decodedText = null;
        try {
            decodedText = new String(decoder.decode(encodedText), Constants.CHARSET);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    
        return decodedText;
    }
    
    
    public static void main(String[] args){
        String text =  Base64Util.encode("Zhangjin_123");
        
        System.out.println(text);
    }
    
    
    
}
