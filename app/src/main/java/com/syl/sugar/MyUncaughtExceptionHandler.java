package com.syl.sugar;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Crash Handler
 *
 * Created by shenyunlong on 3/22/16.
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    public static final String TAG = MyUncaughtExceptionHandler.class.getSimpleName();

    private Context mContext;
    // Android默认的异常处理
    private Thread.UncaughtExceptionHandler mDefaultExceptionHandler;

    public MyUncaughtExceptionHandler(Context context) {
        mContext = context;
        mDefaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        Writer result = new StringWriter();
        PrintWriter writer = new PrintWriter(result);
        ex.printStackTrace(writer);

        // Crash日志信息
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(System.currentTimeMillis()));
        Log.d(TAG, "Crash Time  : " + time);
        Log.d(TAG, dumpPhoneDetailInfo(mContext));
        Log.d(TAG, result.toString());

        String currentProcessName = getCurrentProcessName(mContext);
        if(mContext.getPackageName().equals(currentProcessName)) {
            /* 主进程 */
            Log.d(TAG, "Main Process Crash # " + currentProcessName);
            mDefaultExceptionHandler.uncaughtException(thread, ex);
        } else {
            Log.d(TAG, "Crash # " + currentProcessName);
            Process.killProcess(Process.myPid());
        }
    }

    /**
     * 获取当前进程名
     *
     * @param context
     * @return
     */
    public static String getCurrentProcessName(Context context) {
        String processName = "";

        int pid = Process.myPid();
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

        List<ActivityManager.RunningAppProcessInfo> processInfoList = manager.getRunningAppProcesses();
        for(ActivityManager.RunningAppProcessInfo info : processInfoList) {
            if (info.pid == pid) {
                processName = info.processName;
                break;
            }
        }

        return processName;
    }

    /**
     * 获取手机的详细信息
     *
     * @param context
     * @return
     */
    public static String dumpPhoneDetailInfo(Context context) {
        StringBuilder builder = new StringBuilder();

        PackageManager packageManager = context.getPackageManager();
        PackageInfo info = null;
        try {
            info = packageManager.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        // APP版本名称和版本号
        if(info != null) {
            builder.append("App Version : ").append(info.versionName).append("_").append(info.versionCode).append("\n");
        }
        // Android版本号
        builder.append("OS Version  : ").append(Build.VERSION.RELEASE).append("_").append(Build.VERSION.SDK_INT).append("\n");
        // 手机制造商
        builder.append("Vendor      : ").append(Build.MANUFACTURER).append("\n");
        // 手机型号
        builder.append("Model       : ").append(Build.MODEL).append("\n");
        // CPU架构
        builder.append("CPU ABI     : ").append(Build.CPU_ABI).append("\n");

        return builder.toString();
    }
}
