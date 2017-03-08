package com.noalabs.logutils.crash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noalabs on 2017/3/6.
 */

public class ThreadNOACatchInterceptor {

    // Thread.UncaughtException
    private Thread.UncaughtExceptionHandler defaultExceptionHandler;

    // Crash Stack-related information
    private List<String> crashInfo = new ArrayList<>();

}
