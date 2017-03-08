package com.noalabs.logutils.util;

import java.io.File;

/**
 * 文件处理工具
 *  判断文件夹是否存在
 *  SD卡是否存在
 *  等
 *
 * Created by noalabs on 2017/3/6.
 */

public class FileUtil {

    public FileUtil(){
        throw  new AssertionError();
    }

    /**
     * SD卡是否存在检查
     *
     * @return SD卡是否存在
     */
    public static boolean existSDCard() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }

    /**
     * 创建文件夹
     *
     * @param path 文件夹绝对路径
     * @return File
     */
    public static boolean createDirectory(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return file.mkdirs();
        } else {
            return true;
        }
    }
}
