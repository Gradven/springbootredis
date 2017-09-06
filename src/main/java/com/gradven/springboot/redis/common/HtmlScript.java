package com.gradven.springboot.redis.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liuhangjun on 2017/6/7.
 */
public class HtmlScript {

    /**
     * 删除html标签
     * @param htmlStr
     * @return
     */
    public static String delHTMLTag(String htmlStr) {

        if(htmlStr == null || htmlStr.equals(""))
            return "";

        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式
        String regEx_blank = "^[\\s]*\\n"; //定义空行的正则表达式

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); //过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); //过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); //过滤html标签
    
        Pattern p_blank = Pattern.compile(regEx_blank, Pattern.CASE_INSENSITIVE);
        Matcher m_blank = p_blank.matcher(htmlStr);
        htmlStr = m_blank.replaceAll(""); //过滤空行

        return htmlStr.trim(); //返回文本字符串
    }

    public static void main(String[] args) {

        String result = HtmlScript.delHTMLTag("<p>“惨了惨了惨了。”苏哲把砖头丢掉，赶紧蹲下来，摸了摸那个男人的鼻息。恩……还没有死。她松了一口气。</p>\n" +
                "<p>qq惨了惨了惨了。”苏哲把砖头丢掉，赶紧蹲下来，摸了摸那个男人的鼻息。恩……还没有死。她松了一口气。</p>  ");

        System.out.println(result);
    }
}
