package com.syl.sugar.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import java.io.File;


/**
 * Save a File on Internal Storage:
 * <p> 1. getFilesDir() -> /data/data/<package name>/files
 * <p> 2. getCacheDir() -> /data/data/<package name>/cache
 * <p>
 * <p> Save a File on External Storage:
 * <p> 1. Environment.getExternalStorageDirectory() -> /storage/emulated/0
 * <p> 2. Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) -> /storage/emulated/0/Pictures
 * <p> Files that should be freely available to other apps and to the user. When the user uninstalls your app, these files should remain available to the user.
 * <p>
 * <p> 3. getExternalCacheDir() -> /storage/emulated/0/Android/data/<package name>/cache
 * <p> 4. getExternalFilesDir(Environment.DIRECTORY_PICTURES) -> /storage/emulated/0/Android/data/<package name>/files/Pictures
 * <p> 5. getExternalFilesDir(null) -> /storage/emulated/0/Android/data/<package name>/files
 * <p> Files that rightfully belong to your app and should be deleted when the user uninstalls your app.
 *
 * Created by shenyunlong on 3/23/16.
 */
public class FileUtil {

    public static final String TAG = FileUtil.class.getSimpleName();

    /**
     * 获取文件缓存目录
     *
     * @param context
     * @param dirName
     * @return
     */
    public static File getCacheDir(Context context, String dirName) {
        File file;

        if(isExternalStorageWritable()) {
            /* external storage */
            File cacheDir = context.getExternalCacheDir();

            if(cacheDir == null) {
                file = new File(Environment.getExternalStorageDirectory(),
                        "/Android/data/" + context.getPackageName() + "/cache/" + dirName);
            } else {
                file = new File(cacheDir, dirName);
            }
        } else {
            /* internal storage */
            file = new File(context.getCacheDir(), dirName);
        }

        if(file.exists() || file.mkdirs()) {
            return file;
        }

        return null;
    }

    /**
     * Get the directory for the user's public pictures directory.
     *
     * @param albumName
     * @return
     */
    public static File getAlbumStorageDir(String albumName) {
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);

        if(!file.mkdirs()) {
            Log.e(TAG, "Directory not created");
        }

        return file;
    }

    /**
     * Get the directory for the app's private pictures directory.
     *
     * @param context
     * @param albumName
     * @return
     */
    public static File getAlbumStorageDir(Context context, String albumName) {
        File file = new File(context.getExternalFilesDir(
                Environment.DIRECTORY_PICTURES), albumName);

        if(!file.mkdirs()) {
            Log.e(TAG, "Directory not created");
        }

        return file;
    }

    /**
     * Checks if external storage is available for read and write
     *
     * @return
     */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    /**
     * Checks if external storage is available to at least read
     *
     * @return
     */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state));
    }
}
