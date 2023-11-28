package com.hspedu.upload;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamUtils {
    //功能：将输入流转换成byte[]，即可以把文件的内容读入到byte[]

    public static byte[] streamToByteArray(InputStream is) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(); //创建输出流对象
        byte[] b = new byte[1024]; //字节数组
        int len;
        while((len=is.read(b))!= -1) { //循环读取
            bos.write(b,0,len); //把读取到的数据写入到ByteArrayOutputStream bos
        }
        byte[] array = bos.toByteArray(); //将bos转成字节数组
        bos.close();
        return array;
    }

    //
    //功能： 将 InputStream 转换成 String

    public static String streamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){ //当读取到null时，就表示结束
            builder.append(line+"\r\n");
        }
        return builder.toString();
    }
}
