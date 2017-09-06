package com.gradven.springboot.redis.common;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by liuhangjun on 2017/8/24.
 */
public class DownloadFileUtil {
    
    /**
     * 从网络Url中下载文件
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void  downLoadFromUrl(String urlStr,String fileName, String savePath) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为5秒
        conn.setConnectTimeout(5*1000);
        
        //防止屏蔽程序抓取而返回403错误
        conn.addRequestProperty("User-Agent", "BlueSponge/1.2.0 (iPhone; iOS 10.3.3; Scale/3.00)");
        conn.addRequestProperty("", "");
        conn.addRequestProperty("", "");
        conn.addRequestProperty("", "");
        conn.addRequestProperty("", "");

   
        
        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);
        
        //文件保存位置
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdirs();
        }
        File file = new File(saveDir+File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }
        
        
        System.out.println("info:"+url+" download success");
        
    }
    
    
    
    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
    
    public static void main(String[] args) {
        try{
            downLoadFromUrl("http://daishumovie.oss-cn-shanghai.aliyuncs.com/v/1500962381662.mp4",
                    "1500962381662.mp4","./");
        }catch (Exception e) {
            // TODO: handle exception
        }
    }
}
