package com.noalabs.logutils;

import android.content.Context;

import com.noalabs.logutils.util.FileUtil;

/**
 * Created by noalabs on 2017/3/6.
 */

public class NOALogUtils {

    /**
     * 内部类实现单例模式
     * 延迟加载，减少内存开销
     *
     * @author xuzhaohu
     */
    private static class SingletonHolder {
        private static NOALogUtils instance = new NOALogUtils();
    }

    /**
     * 私有的构造函数
     */
    private NOALogUtils() {

    }

    public static NOALogUtils getInstance() {
        return SingletonHolder.instance;
    }

    public void initialization(Context context){
        FileUtil.existSDCard();
    }

}
