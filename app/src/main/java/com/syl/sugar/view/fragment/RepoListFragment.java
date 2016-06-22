package com.syl.sugar.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.syl.sugar.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Repo列表页面(Owned / Starred / Trending)
 */
public class RepoListFragment extends Fragment {
    private static final String ARG_PAGE = "PAGE";
    private static final String ARG_TITLE = "TITLE";

    @Bind(R.id.repo_list_view)
    ListView mListView;

    private int mPage;
    private String mTitle;

    public RepoListFragment() {
    }

    public static RepoListFragment newInstance(int page, String title) {
        RepoListFragment fragment = new RepoListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPage = getArguments().getInt(ARG_PAGE);
            mTitle = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repo_list, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        mContent.setText(mTitle);
//
//        switch (mPage) {
//            case 0:
//                mPageLayout.setBackgroundColor(getResources().getColor(R.color.LightBlue));
//                break;
//            case 1:
//                mPageLayout.setBackgroundColor(getResources().getColor(R.color.Gold));
//                break;
//            case 2:
//                mPageLayout.setBackgroundColor(getResources().getColor(R.color.SpringGreen));
//                break;
//        }
    }
}
