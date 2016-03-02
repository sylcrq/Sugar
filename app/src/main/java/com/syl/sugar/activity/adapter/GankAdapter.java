package com.syl.sugar.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.syl.sugar.R;
import com.syl.sugar.model.WelfareResp;
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_adapter_item, null);

        return new GankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GankViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(mData.get(position).getUrl(), holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return (mData==null ? 0 : mData.size());
    }

    public static class GankViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;

        public GankViewHolder(View itemView) {
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
