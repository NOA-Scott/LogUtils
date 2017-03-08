package com.noalabs.logutils.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by noalabs on 2017/3/6.
 */

public class AppUtils {
    /**
     * 获取当前版本号
     *
     * @param context Context
     * @return 版本号
     */
    public static String getVersionName(Context context) {
        String version;
        try {
            PackageInfo pkg = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            version = pkg.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            version = "未知版本";
            e.printStackTrace();
        }
        return version;
    }
    /**
     * 获取屏幕的尺寸
     *
     * @param context Context
     * @return 屏幕尺寸的 x,y
     */
    public static Point screenInches(Context context){
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        return point;
    }

    /**
     *
     * @return 手机的生产厂商
     */

    public static String getPhoneManufacturers() {
        return Build.BRAND;
    }
    /**
     *
     * @return 手机的名称
     */
    public static String getPhoneName() {
        return Build.MODEL;
    }

}
