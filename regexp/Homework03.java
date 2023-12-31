package com.hspedu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework03 {
    public static void main(String[] args) {

        /*
         "http://www.sohu.com:8080/abc/index.htm"
         得到协议：http
            域名：www.sohu.com
            端口：8080
            文件名：index.htm
         */
        String content = "http://www.sohu.com:8080/abc/index.htm";
        String regStr = "^([a-zA-Z]+)://([a-zA-Z.]+):(\\d+)[\\w-/]*/([\\w.]+)$";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);

        if (matcher.matches()) { //整体匹配成功，可以通过group(*)，获取对应分组的内容
            System.out.println("整体匹配=" + matcher.group(0));
            System.out.println("协议：" + matcher.group(1));
            System.out.println("域名：" + matcher.group(2));
            System.out.println("端口：" + matcher.group(3));
            System.out.println("文件名：" + matcher.group(4));
        } else {
            System.out.println("没有匹配成功");
        }
    }
}
