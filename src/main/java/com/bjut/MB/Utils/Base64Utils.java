package com.bjut.MB.Utils;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2017/12/21.
 */
public class Base64Utils {
    private static final Logger logger = LoggerFactory.getLogger(Base64Utils.class);

    public static String encode(String path){
        File file = new File(path);
        FileInputStream inputFile = null;
        String base64 = null;
        try {
            inputFile = new FileInputStream(file);
            byte[] buffer = new byte[(int) file.length()];
            inputFile.read(buffer);
            inputFile.close();
            base64 = new BASE64Encoder().encode(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return base64;
    }

    public static boolean decode(String base64,String path){
        try {
            BufferedOutputStream stream = null;
            byte[] bytes = Base64.decode(base64);
            stream = new BufferedOutputStream(new FileOutputStream(new File(path)));
            stream.write(bytes);
            stream.flush();
            stream.close();
            return true;
        } catch (Exception e) {
            logger.error("文件上传失败：" + e.getMessage());
            return false;
        }
    }
}
