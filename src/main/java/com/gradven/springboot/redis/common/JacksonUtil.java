package com.gradven.springboot.redis.common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

/**
 * Created by liuhangjun on 2017/6/30.
 */
public final class JacksonUtil {
    
    public static ObjectMapper objectMapper;
    
    /**
     * 使用泛型方法，把json字符串转换为相应的JavaBean对象。
     * (1)转换为普通JavaBean：readValue(json,Student.class)
     * (2)转换为List,如List<Student>,将第二个参数传递为Student
     * [].class.然后使用Arrays.asList();方法把得到的数组转换为特定类型的List
     *
     * @param jsonStr
     * @param valueType
     * @return
     */
    public static <T> T readValue(String jsonStr, Class<T> valueType) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
    
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        try {
            return objectMapper.readValue(jsonStr, valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * json数组转List
     * @param jsonStr
     * @param valueTypeRef
     * @return
     */
    public static <T> T readValue(String jsonStr, TypeReference<T> valueTypeRef){
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
    
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        try {
            return objectMapper.readValue(jsonStr, valueTypeRef);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * 把JavaBean转换为json字符串
     *
     * @param object
     * @param isPretty  true:易读格式，false：紧凑格式
     * @param path 文件全路径，如果为null，则不写文件
     * @return
     */
    public static String objectToJson(Object object, Boolean isPretty, String path) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        
        String json = "";
        
        try {
            if (isPretty){
                json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            }else {
                json = objectMapper.writeValueAsString(object);
            }
            
            
            if (path != null) {
                if (isPretty) {
                    objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), object);
                } else {
                    objectMapper.writeValue(new File(path), object);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return json;
    }
    
}
