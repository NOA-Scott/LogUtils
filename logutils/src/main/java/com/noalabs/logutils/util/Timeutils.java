package com.noalabs.logutils.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by noalabs on 2017/3/6.
 */

public class Timeutils {

    private static final SimpleDateFormat TIME_YYMMDD = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());

    private static final SimpleDateFormat TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    public Timeutils(){
        throw  new AssertionError();
    }

    /**
     * Format date
     *
     * @param rule
     *          格式规则
     * @param time
     *          时间戳
     * @return
     *          格式化后的日期
     */

    public static String formatDate(String rule, long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return new SimpleDateFormat(rule, Locale.getDefault()).format(calendar.getTime());
    }

    /**
     * 格式化当前日期
     *
     * @param rule
     *            格式规则
     * @return 格式化后的日期
     */
    public static String formatDate(String rule) {
        return new SimpleDateFormat(rule, Locale.getDefault()).format(new Date());
    }

    /**
     * 格式化当前时间
     *
     * @return Time
     */
    public static String formatTime() {
        return TIME.format(new Date());
    }

    /**
     * Current TimeMillis
     *
     * @return millis
     */
    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
