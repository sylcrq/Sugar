package com.syl.sugar.activity.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.syl.sugar.R;
import com.syl.sugar.model.WelfareResp;
import com.syl.sugar.view.DynamicHeightImageView;

import java.util.List;

/**
 * Created by shenyunlong on 3/1/16.
 */
public class GankAdapter extends RecyclerView.Adapter<GankAdapter.GankViewHolder> {

    private Context mContext;
    private List<WelfareResp.Welfare> mData;

    public GankAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<WelfareResp.Welfare> data) {
        mData = data;
    }

    @Override
    public GankViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_adapter_item, parent, false);

        return new GankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GankViewHolder holder, int position) {
//        holder.mImageView.setImageResource(R.drawable.placeholder_image);
//        ImageLoader.getInstance().displayImage(mData.get(position).getUrl(), holder.mImageView);
        WelfareResp.Welfare welfare = mData.get(position);
        Picasso.with(mContext).load(welfare.getUrl())
                .placeholder(R.drawable.placeholder_image)
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return (mData==null ? 0 : mData.size());
    }

    /**
     *
     */
    public static class GankViewHolder extends RecyclerView.ViewHolder implements Target {
        DynamicHeightImageView mImageView;

        public GankViewHolder(View itemView) {
            super(itemView);

            mImageView = (DynamicHeightImageView) itemView.findViewById(R.id.image);
        }

        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            // Calculate the image ratio of the loaded bitmap
            float ratio = (float) bitmap.getHeight() / (float) bitmap.getWidth();
            // Set the ratio for the image
            mImageView.setHeightRatio(ratio);
            // Load the image into the view
            mImageView.setImageBitmap(bitmap);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {

        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    }
}
