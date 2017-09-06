package com.gradven.springboot.redis.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by liuhangjun on 2017/8/24.
 */
public class JsonFormat {
    
    private StringBuffer buffer = new StringBuffer();
    
    //格式化json
    public String format(Object json, int num, boolean isArray) {
        
        if (json instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) json;
            num += 5;
            
            if (isArray) {
                buffer.append(getKg(num) + "{</br>");
            } else {
                buffer.append("{</br>");
            }
            
            for (String k : jsonObject.keySet()) {
                buffer.append(getKg(num + 2) + k + " : ");
                format(jsonObject.get(k), num, false); //格式化子目录
            }
            
            buffer.append(getKg(num) + "}</br>");
            
        } else if (json instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) json;
            num += 5;
            buffer.append("[</br>");
            
            for (int k = 0; k < jsonArray.size(); k++) {
                format(jsonArray.get(k), num, true); //格式化子目录
            }
            buffer.append(getKg(num) + "]</br>");
            
        } else { //如果不是json对象就直接打印值
            buffer.append(json.toString() + "</br>");
        }
        
        return buffer.toString();
        
    }
    
    /**
     * 获取num个数个空格
     *
     * @param num
     * @return
     */
    private String getKg(Integer num) {
        StringBuffer kg = new StringBuffer();
        for (int i = 0; i < num; i++) {
            kg.append("&nbsp;");
        }
        return kg.toString();
    }
    
    public static void main(String[] args){
        
        String json = "{\"status\":0,\"desc\":\"success\",\"result\":{\"videoId\":7000,\"basisVideoInfo\":{\"cnName\":\"青禾男高\",\"sourceVideoCount\":4,\"coverUrl\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/movie/2017/7/1/A658D77D8D25410E82A46536FE7818A1.jpg\",\"categorys\":\"励志\",\"premiereDate\":\"2017-08-01上映\",\"timeInfo\":\"90分钟\",\"isSubscribe\":0,\"videoType\":1},\"scoreInfoList\":[{\"videoId\":7000,\"image\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/aiqiyi%402x.png\",\"score\":\"7.2\",\"name\":\"爱奇艺\"}],\"hightPartList\":[{\"videoId\":7000,\"episodeId\":2688,\"slogan\":\"《青禾男高》首曝预告,景甜欧豪上演霸道青春\",\"imgUrl\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/episode/2017/7/1/762AAB71B2004B328EFFFB783F4FCD32.jpg\",\"duration\":\"01:32\"}],\"summary\":\"1932年，日本帝国主义在我国东三省建立傀儡政权，开展奴化教育。大量进步师生遭到迫害，中文书籍焚烧殆尽。为了学习自己的语言和文化，以柳禾、荆浩为主的师生们成立了读书会，用自己的行动与侵略者进行着抗争。\",\"sourceList\":[{\"videoId\":7000,\"image\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/tengxun%402x.png\",\"sourceCode\":3,\"name\":\"腾讯视频\",\"title\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/logo/%E8%A7%82%E7%9C%8B.png\",\"url\":\"http://v.qq.com/x/cover/440t90j97dkrhxc/q00244fnwc0.html?ptag=iqiyi\",\"mark\":\"\"},{\"videoId\":7000,\"image\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/youku%402x.png\",\"sourceCode\":4,\"name\":\"优酷\",\"title\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/logo/%E8%A7%82%E7%9C%8B.png\",\"url\":\"http://v.youku.com/v_show/id_XMjk3NDU3OTU2MA==.html\",\"mark\":\"\"},{\"videoId\":7000,\"image\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/aiqiyi%402x.png\",\"sourceCode\":2,\"name\":\"爱奇艺\",\"title\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/logo/%E8%A7%82%E7%9C%8B.png\",\"url\":\"http://www.iqiyi.com/v_19rr7phlk4.html\",\"mark\":\"\"},{\"videoId\":7000,\"image\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/logo/%E8%8A%92%E6%9E%9CTV.png\",\"sourceCode\":9,\"name\":\"芒果TV\",\"title\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/logo/%E8%A7%82%E7%9C%8B.png\",\"url\":\"http://www.mgtv.com/b/314491/4064384.html?cxid=9571sxdjy\",\"mark\":\"\"}],\"ticketList\":[{\"videoId\":7000,\"image\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/maoyan%402x.png\",\"name\":\"猫眼\",\"title\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/logo/%E8%B4%AD%E7%A5%A8.png\",\"url\":\"http://maoyan.com/films/672202\"},{\"videoId\":7000,\"image\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/taopiaopiao%402x.png\",\"name\":\"淘票票\",\"title\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/logo/%E8%B4%AD%E7%A5%A8.png\",\"url\":\"https://h5.m.taopiaopiao.com/app/moviemain/pages/show-detail/index.html?showid=213807\"},{\"videoId\":7000,\"image\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/yupiao%402x.png\",\"name\":\"娱票儿\",\"title\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/logo/%E8%B4%AD%E7%A5%A8.png\",\"url\":\"https://m.wepiao.com/movies/244923\"},{\"videoId\":7000,\"image\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/gewala%402x.png\",\"name\":\"格瓦拉\",\"title\":\"http://daishumovie.oss-cn-shanghai.aliyuncs.com/img/logo/%E8%B4%AD%E7%A5%A8.png\",\"url\":\"http://www.gewara.com/movie/323882075?fyrq=\"}],\"recommentlist\":[]}}";
    
        JsonFormat jsonFormat = new JsonFormat();
        String ret = jsonFormat.format(JSONObject.parse(json), 0 , true);
        
        System.out.println(ret);
    }
}
