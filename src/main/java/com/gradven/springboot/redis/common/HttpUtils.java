package com.gradven.springboot.redis.common;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by liuhangjun on 2017/6/5.
 */
public class HttpUtils {
    
    private String referer;
    
    private String accept;
    
    private String sessionId;
    
    public String getSessionId() {
        return sessionId;
    }
    
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    
    public String getAccept() {
        return accept;
    }
    
    public void setAccept(String accept) {
        this.accept = accept;
    }
    
    public String getReferer() {
        return referer;
    }
    
    public void setReferer(String referer) {
        this.referer = referer;
    }
    
    /**
     * 首先获得一个post实例
     * @param url
     * @return
     */
    public HttpPost getHttpPostInstance(String url){

        HttpPost httpPost = new HttpPost(url);

        //设置头部参数信息
        httpPost.setHeader("Accept", "text/html, application/xhtml+xml, */*");
        httpPost.setHeader("Accept-Encoding", "gzip, deflate");
        httpPost.setHeader("Accept-Language", "en-US");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; WOW64; Trident/6.0)");
    
        if (accept == null)
            httpPost.setHeader("Accept", "text/html, application/xhtml+xml, */*");
        else
            httpPost.setHeader("Accept",accept);
    
        if (sessionId != null)
            httpPost.setHeader("Cookie", "JSESSIONID="+sessionId + "; usertimeout=1");
    
        if (referer != null)
            httpPost.setHeader("Referer", referer);

        return httpPost;

    }
    
    /**
     * 首先获取一个get实例
     * @param url
     * @return
     */
    public HttpGet getHttpGetInstance(String url){
        
        HttpGet httpGet = new HttpGet(url);
        
        httpGet.setHeader("Accept-Encoding", "gzip, deflate");
        httpGet.setHeader("Accept-Language", "en-US");
        httpGet.setHeader("User-Agent", "User-Agent: Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; WOW64; Trident/6.0)");
        httpGet.setHeader("X-Requested-With", "XMLHttpRequest");
        
        if (accept == null)
            httpGet.setHeader("Accept", "text/html, application/xhtml+xml, */*");
        else
            httpGet.setHeader("Accept",accept);
        
        if (sessionId != null)
            httpGet.setHeader("Cookie", "JSESSIONID="+sessionId + "; usertimeout=1");
        
        if (referer != null)
            httpGet.setHeader("Referer", referer);
        
        return httpGet;
        
    }
    
    /**
     * 执行get实例
     * @param httpGet
     * @return
     */
    public String executeHttpGet(HttpGet httpGet){
        
        String resStr;
    
        //最多执行三次
        for (int i = 0; i < 3; i ++){
            resStr = executeHttp(null, httpGet);
        
            if (resStr != null)
                return resStr;
        }
    
        return null;
    }
    
    /**
     * 执行post实例
     * @param httpPost
     * @return
     */
    public String executeHttpPost(HttpPost httpPost){
        
        String resStr;
    
        //最多执行三次
        for (int i = 0; i < 3; i ++){
            resStr = executeHttp(httpPost, null);
            
            if (resStr != null)
                return resStr;
        }
        
        return null;
    }
    
    
    
    private String executeHttp(HttpPost httpPost, HttpGet httpGet){
        
        
        CloseableHttpClient httpclient;
        CloseableHttpResponse response = null;
        
        httpclient = HttpClients.createDefault();
    
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();//设置请求和传输超时时间
    
        try {
            if (httpPost != null) {
                httpPost.setConfig(requestConfig);
                response = httpclient.execute(httpPost);
            }else {
                httpGet.setConfig(requestConfig);
                response = httpclient.execute(httpGet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (response == null){
           return null;
        }
        
        String content = "";
        
        // 获取响应实体
        HttpEntity entity = response.getEntity();
        
        if (entity != null) {
            try {
                content =  EntityUtils.toString(entity);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return content;
    }
}
