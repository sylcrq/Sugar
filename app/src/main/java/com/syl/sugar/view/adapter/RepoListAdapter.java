package com.syl.sugar.view.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.syl.basecore.imageLoader.SugarLoader;
import com.syl.domain.model.Repository;
import com.syl.sugar.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Shen YunLong on 2016/07/26.
 */
public class RepoListAdapter extends BaseListAdapter<Repository> {

    public RepoListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public BaseViewHolder createViewHolder() {
        return new ViewHolder();
    }

    @Override
    public int getLayoutId() {
        return R.layout.repo_list_adapter_item;
    }

    @Override
    public void initView(View view, BaseViewHolder viewHolder) {
        if (viewHolder instanceof ViewHolder) {
            ((ViewHolder) viewHolder).mAvatar = (CircleImageView) view.findViewById(R.id.repo_user_avatar);
            ((ViewHolder) viewHolder).mName = (TextView) view.findViewById(R.id.repo_name);
            ((ViewHolder) viewHolder).mDescription = (TextView) view.findViewById(R.id.repo_description);
        }
    }

    @Override
    public void bindData(BaseViewHolder viewHolder, int position) {
        Repository repo = getItem(position);

        if (viewHolder instanceof ViewHolder) {
            SugarLoader.loadImage(mContext, repo.getOwner().getAvatar_url(),
                    ((ViewHolder) viewHolder).mAvatar, R.drawable.github_mark_120px);
            ((ViewHolder) viewHolder).mName.setText(repo.getName());
            ((ViewHolder) viewHolder).mDescription.setText(repo.getDescription());
        }
    }

    public static class ViewHolder extends BaseViewHolder {
        public CircleImageView mAvatar;
        public TextView mName;
        public TextView mDescription;
    }
}
