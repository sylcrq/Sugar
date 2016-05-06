package com.syl.sugar.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.syl.domain.model.User;
import com.syl.sugar.R;
import com.syl.sugar.presenter.SingleUserPresenter;
import com.syl.sugar.view.SingleUserView;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 用户信息页面Fragment
 * <p/>
 * Created by Shen YunLong on 2016/05/05
 */
public class SingleUserFragment extends Fragment implements SingleUserView {

    private static final String ARG_SINGLE_USER_NAME = "ARG_SINGLE_USER_NAME";

    private String mArgUserName;
    private View mRootView;
    private Context mContext;
    private SingleUserPresenter mPresenter;

    @Bind(R.id.user_avatar)
    CircleImageView mUserAvatar;
    @Bind(R.id.user_name)
    TextView mUserName;
    @Bind(R.id.user_login_name)
    TextView mUserLoginName;
    @Bind(R.id.user_followers)
    TextView mUserFollowers;
    @Bind(R.id.user_following)
    TextView mUserFollowing;
    @Bind(R.id.user_company_layout)
    TextView mUserCompany;
    @Bind(R.id.user_location_layout)
    TextView mUserLocation;
    @Bind(R.id.user_email_layout)
    TextView mUserEmail;
    @Bind(R.id.user_blog_layout)
    TextView mUserBlog;
    @Bind(R.id.user_joined_date_layout)
    TextView mUserJoinedDate;

    public SingleUserFragment() {
    }

    public static SingleUserFragment newInstance(String userName) {
        SingleUserFragment fragment = new SingleUserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SINGLE_USER_NAME, userName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mArgUserName = getArguments().getString(ARG_SINGLE_USER_NAME);
        }

        mPresenter = new SingleUserPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_single_user, container, false);
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mContext = context;
    }

    @Override
    public void onResume() {
        super.onResume();

        mPresenter.loadData(mArgUserName);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onLoadSuccess(User user) {
        Picasso.with(mContext).load(user.getAvatar_url())
                .placeholder(R.drawable.github_mark_120px_plus)
                .into(mUserAvatar);

        mUserName.setText(user.getName());
        mUserLoginName.setText(user.getLogin());
        mUserFollowers.setText(String.valueOf(user.getFollowers()));
        mUserFollowing.setText(String.valueOf(user.getFollowing()));

        if (user.getCompany() != null) {
            mUserCompany.setText(user.getCompany());
        } else {
            mUserCompany.setVisibility(View.GONE);
        }

        if (user.getLocation() != null) {
            mUserLocation.setText(user.getLocation());
        } else {
            mUserLocation.setVisibility(View.GONE);
        }

        if (user.getEmail() != null) {
            mUserEmail.setText(user.getEmail());
        } else {
            mUserEmail.setVisibility(View.GONE);
        }

        if (user.getBlog() != null) {
            mUserBlog.setText(user.getBlog());
        } else {
            mUserBlog.setVisibility(View.GONE);
        }

        if (user.getCreated_at() != null) {
            mUserJoinedDate.setText(String.format(mContext.getString(R.string.user_joined_on),
                    user.getCreated_at().substring(0, 10)));
        } else {
            mUserJoinedDate.setVisibility(View.GONE);
        }
    }

    @Override
    public void onLoadError() {
    }
}
