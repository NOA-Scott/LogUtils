package com.noalabs.logutils.util;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by noalabs on 3/8/17.
 */

public class LOG {
    private static final int LEVEL_I = 1;



    private static final int LEVEL_D = 2;



    private static final int LEVEL_W = 3;



    private static final int LEVEL_E = 4;



    private static final String FILEPATH = "/Noa-Labs";



    private static final String FILENAME = "noalabs.log";



    private static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");


    class AppConstants{
        public final static boolean DEBUG = true;
    }



    public static void logD(String msg) {

        log(LEVEL_D, msg);

    }



    public static void logI(String msg) {

        log(LEVEL_I, msg);

    }



    public static void logW(String msg) {

        log(LEVEL_W, msg);

    }



    public static void logE(String msg) {

        log(LEVEL_E, msg);

    }



    public static void logE(Throwable ex) {

        if (!AppConstants.DEBUG) {

            return;

        }

        Writer writer = new StringWriter();

        PrintWriter printWriter = new PrintWriter(writer);

        ex.printStackTrace(printWriter);

        Throwable cause = ex.getCause();

        while (cause != null) {

            cause.printStackTrace(printWriter);

            cause = cause.getCause();

        }

        printWriter.close();

        String result = writer.toString();

        final Throwable t = AppConstants.DEBUG ? new Throwable() : null;

        final StackTraceElement[] elements = t != null ? t.getStackTrace() : null;

        String callerClassName = t != null ? elements[2].getClassName() : "N/A";

        int pos = callerClassName.lastIndexOf('.');

        if (pos >= 0) {

            callerClassName = callerClassName.substring(pos + 1);

        }

        final String tag = callerClassName;

        Log.e(tag, result);

        try {

            write(tag, result);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }



    private static void log(int level, String msg) {

        if (!AppConstants.DEBUG) {

            return;

        }

        final Throwable t = AppConstants.DEBUG ? new Throwable() : null;

        final StackTraceElement[] elements = t != null ? t.getStackTrace() : null;

        String callerClassName = t != null ? elements[2].getClassName() : "N/A";

        String callerMethodName = t != null ? elements[2].getMethodName() : "N/A";

        int pos = callerClassName.lastIndexOf('.');

        if (pos >= 0) {

            callerClassName = callerClassName.substring(pos + 1);

        }

        final String tag = callerClassName;

        final StringBuffer buf = new StringBuffer();

        buf.append("[").append(callerMethodName).append("]  ").append(msg);



        switch (level) {

            case LEVEL_I:

                Log.i(tag, buf.toString());

                break;

            case LEVEL_D:

                Log.d(tag, buf.toString());

                break;

            case LEVEL_W:

                Log.w(tag, buf.toString());

                break;

            case LEVEL_E:

                Log.e(tag, buf.toString());

                break;

            default:

                break;

        }

        try {

            write(tag, buf.toString());

        } catch (IOException e) {

            e.printStackTrace();

        }
    }



    private static void write(String tag, String log) throws IOException {

        String time = formatter.format(new Date(System.currentTimeMillis()));

        String logger = time + ">>>>>" + tag + ">>>>>" + ">>>>>" + log + "\n\n";

        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

            File dir = Environment.getExternalStorageDirectory();

            File file = new File(dir, FILEPATH);

            if (!file.exists()) {

                file.mkdirs();

            }

            FileOutputStream fos = new FileOutputStream(file + "/" + FILENAME, true);

            fos.write(logger.getBytes());

            fos.close();

        }

    }
}
