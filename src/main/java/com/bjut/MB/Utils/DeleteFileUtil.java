package com.bjut.MB.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by Administrator on 2017/12/25.
 */
public class DeleteFileUtil {
    private static final Logger logger = LoggerFactory.getLogger(DeleteFileUtil.class);
    /**
     * 删除单个文件
     *
     * @param fileName 要删除的文件的文件名
     */
    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
            } else {
                logger.info("删除单个文件" + fileName + "失败！");
            }
        } else {
            logger.info("删除单个文件失败：" + fileName + "不存在！");
        }
    }
}
