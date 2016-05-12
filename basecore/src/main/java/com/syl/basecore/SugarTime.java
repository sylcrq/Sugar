package com.syl.basecore;

import android.text.format.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 时间戳处理工具类
 * <p>
 * Created by Shen YunLong on 2016/05/16.
 */
public class SugarTime {

    public static final String GITHUB_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    public static String convertTimeAgo(String timestamp) {
        long time = getTime(timestamp);
        long current = System.currentTimeMillis();
        String result = DateUtils.getRelativeTimeSpanString(time, current, DateUtils.MINUTE_IN_MILLIS).toString();
        return result;
    }

    public static long getTime(String timestamp) {
        TimeZone zone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat dateFormat = new SimpleDateFormat(GITHUB_TIME_FORMAT);
        dateFormat.setTimeZone(zone);

        long result = 0;

        try {
            Date date = dateFormat.parse(timestamp);
            result = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }
}
