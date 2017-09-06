package com.gradven.springboot.redis.common;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuhangjun
 * @date 2017年3月3日
 *
 */
public class FileUtils {
    
    
    /**
     * 写文件，如果文件不存在，则创建一个文件
     * @param filePath
     * @param fileName
     * @param content
     */
    public static File writeStringToFile(String filePath, String fileName, String content) {
        
        File dir = new File(filePath);
        if(!dir.isDirectory())
            dir.mkdirs();
        
        File file = new File(filePath + fileName);
        if (!file.isFile()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
        try {
            FileOutputStream fos = new FileOutputStream(filePath + fileName);
            fos.write(content.getBytes());
            fos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return file;
    }

    public static void appendStringToFile(String filePath, String content){
    
        FileWriter writer = null;
        try {
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            writer = new FileWriter(filePath, true);
            
            if (StringUtils.isBlank(content))
                return;
            
            writer.write(content);
            
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void renameFile(String sourceFile , String targetFile){

        File oldName = new File(sourceFile);
        File newName = new File(targetFile);

        if(oldName.renameTo(newName)) {
            System.out.println("已重命名");
        } else {
            System.out.println("重命名 Error");
        }

    }
    
    /**
     * 将文件的每一行加入到一个set中，刨除空行
     * @param file
     * @return
     */
    public static List<String> file2Set(File file){
    
        List<String> stringList = new ArrayList<String>();
    
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                stringList.add(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        
        return stringList;
    }
    
    
    /**
     * 复制一个目录及其子目录、文件到另外一个目录
     * @param src
     * @param dest
     * @throws IOException
     */
    public static void copyFolder(File src, File dest){
        if (src.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
            }
            String files[] = src.list();
            for (String file : files) {
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                // 递归复制
                copyFolder(srcFile, destFile);
            }
        } else {
            InputStream in = null;
            try {
                in = new FileInputStream(src);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            OutputStream out = null;
            try {
                out = new FileOutputStream(dest);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    
            byte[] buffer = new byte[1024];
            
            int length;
    
            try {
                while ((length = in.read(buffer)) > 0) {
                    try {
                        out.write(buffer, 0, length);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        String filePath = "/Users/liuhangjun/Desktop/";
        String fileName = "link.html";

        FileUtils.writeStringToFile(filePath , fileName,"========");
    }

}
