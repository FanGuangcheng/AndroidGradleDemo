package com.wenman.androidgradledemo;

import android.util.Log;

public class TimeStampPrinter {

    public static void printerLog(String log) {
        Log.d("TimeStampPrinter", "timestamp is : " + System.currentTimeMillis() + "   log is : " + log);
    }
}
