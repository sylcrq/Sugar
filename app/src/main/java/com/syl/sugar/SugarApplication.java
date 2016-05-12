package com.syl.sugar;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;
import com.syl.basecore.logger.SugarLogger;


/**
 * Custom Application
 * <p/>
 * Created by shenyunlong on 3/1/16.
 */
public class SugarApplication extends com.activeandroid.app.Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        /* Logger */
        SugarLogger.init();
        /* LeakCanary */
        LeakCanary.install(this);
        /* Custom Crash Handler  */
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler(this));
        /* Stetho */
        Stetho.initializeWithDefaults(this);
        /* UIL */
//        File cacheDir = StorageUtils.getCacheDirectory(this);
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
//                .memoryCacheExtraOptions(480, 800) // default = device screen dimensions
//                .diskCacheExtraOptions(480, 800, null)
//                .threadPoolSize(3) // default
//                .threadPriority(Thread.NORM_PRIORITY - 2) // default
//                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
//                .denyCacheImageMultipleSizesInMemory()
//                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
//                .memoryCacheSize(2 * 1024 * 1024)
//                .memoryCacheSizePercentage(13) // default
//                .diskCache(new UnlimitedDiskCache(cacheDir)) // default
//                .diskCacheSize(50 * 1024 * 1024)
//                .diskCacheFileCount(100)
//                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
//                .imageDownloader(new BaseImageDownloader(this)) // default
//                .imageDecoder(new BaseImageDecoder(true)) // default
//                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
//                .writeDebugLogs()
//                .build();
//
//        ImageLoader.getInstance().init(config);
    }
}
