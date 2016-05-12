package com.syl.basecore.imageLoader;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * 封装图片加载接口
 * <p/>
 * Created by Shen YunLong on 2016/05/12.
 */
public class SugarLoader {

    public static void loadImage(Context context, String path, ImageView target) {
        Picasso.with(context)
                .load(path)
                .into(target);
    }

    public static void loadImage(Context context, String path, ImageView target, int placeholder) {
        Picasso.with(context)
                .load(path)
                .placeholder(placeholder)
                .into(target);
    }
}
