package com.syl.sugar.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.syl.domain.model.Event;
import com.syl.sugar.NavigationTool;
import com.syl.sugar.R;
import com.syl.sugar.view.EventsView;
import com.syl.sugar.view.adapter.EventListAdapter;
import com.syl.sugar.presenter.EventsPresenter;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * 首页News页面
 */
public class MyNewsFragment extends Fragment implements EventsView, AdapterView.OnItemClickListener {

    private static final String ARG_USER_NAME = "ARG_USER_NAME";

    @Bind(R.id.event_list_view_frame)
    PtrClassicFrameLayout mPtrFrame;
    @Bind(R.id.event_list_view)
    ListView mListView;
    @Bind(R.id.loading_view)
    AVLoadingIndicatorView mLoadingView;
    @Bind(R.id.empty_view)
    View mEmptyView;
    @Bind(R.id.error_view)
    View mErrorView;

    private String mUserName;
    private Context mContext;
    private EventListAdapter mAdapter;
    private EventsPresenter mEventsPresenter;
//    private OnFragmentInteractionListener mListener;

    public MyNewsFragment() {
    }

    public static MyNewsFragment newInstance(String userName) {
        MyNewsFragment fragment = new MyNewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USER_NAME, userName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;

//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUserName = getArguments().getString(ARG_USER_NAME);
        }

        mAdapter = new EventListAdapter(mContext);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_news, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPtrFrame.setLastUpdateTimeRelateObject(this);
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mEventsPresenter.loadData(mUserName, 1, hasData());
            }
        });

//        mUserDataList.addHeaderView(initHeaderView());
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);

        mEventsPresenter = new EventsPresenter(this);
//        mEventsPresenter.loadData(mUserName, 1, hasData());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
//        mListener = null;
    }

    @Override
    public void onResume() {
        super.onResume();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrame.autoRefresh();
            }
        }, 100);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private boolean hasData() {
        if (mAdapter != null && mAdapter.getCount() > 0) {
            return true;
        }

        return false;
    }
//    private View initHeaderView() {
//        View view = LayoutInflater.from(getActivity()).inflate(R.layout.main_listview_header, null);
//        return view;
//    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Event event = (Event) mAdapter.getItem(position);
        NavigationTool.gotoSingleUserActivity(mContext, event.getActor().getLogin());
    }

    @Override
    public void showLoadingView(boolean show) {
        mLoadingView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showErrorView(boolean show) {
        mErrorView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showEmptyView(boolean show) {
        mEmptyView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showDataView(boolean show) {
        mPtrFrame.setVisibility(show ? View.VISIBLE : View.GONE);
    }

//    @Override
//    public void autoRefresh() {
//        mPtrFrame.autoRefresh();
//    }

    @Override
    public void refreshComplete() {
        mPtrFrame.refreshComplete();
    }

    @Override
    public void bindData(List<Event> events, boolean isLoadMore) {
        if (isLoadMore) {
            mAdapter.addData(events);
        } else {
            mAdapter.setData(events);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

//    public interface OnFragmentInteractionListener {
//        void onFragmentInteraction(Uri uri);
//    }
}