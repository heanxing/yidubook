package com.yi.du.Util;

public class FileUtils {

    /*
     * 生成随机文件名
     */
    public static String generateRandomFilename(){
        Double random = Math.random();
        String str = random.toString().substring(2, 11);

        return str;
    }

    public static String prefix(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    public static String suffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

}
