package com.syl.sugar.view.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.syl.domain.model.Event;
import com.syl.sugar.NavigationTool;
import com.syl.sugar.R;
import com.syl.sugar.view.EventsView;
import com.syl.sugar.view.adapter.EventListAdapter;
import com.syl.sugar.presenter.EventsPresenter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 首页Fragment
 * <p/>
 * Created by Shen YunLong on 2016/05/05
 */
public class EventsFragment extends Fragment implements EventsView, AdapterView.OnItemClickListener {

    private static final String ARG_USER_NAME = "ARG_USER_NAME";

    private String mUserName;

    @Bind(R.id.user_data_list)
    ListView mUserDataList;
    @Bind(R.id.loading_bar)
    ProgressBar mLoadingBar;

    private EventListAdapter mAdapter;
    private EventsPresenter mEventsPresenter;

    private OnFragmentInteractionListener mListener;

    public EventsFragment() {
    }

    public static EventsFragment newInstance(String userName) {
        EventsFragment fragment = new EventsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_USER_NAME, userName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUserName = getArguments().getString(ARG_USER_NAME);
        }

        mAdapter = new EventListAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        mUserDataList.addHeaderView(initHeaderView());
        mUserDataList.setAdapter(mAdapter);
        mUserDataList.setOnItemClickListener(this);

        mEventsPresenter = new EventsPresenter(this);
        mEventsPresenter.loadData(mUserName);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

//    private View initHeaderView() {
//        View view = LayoutInflater.from(getActivity()).inflate(R.layout.main_listview_header, null);
//        return view;
//    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Event event = (Event) mAdapter.getItem(position);
        onItemClick(event.getActor().getLogin());
    }

    @Override
    public void showLoading() {
        mLoadingBar.setVisibility(View.VISIBLE);
        mUserDataList.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        mLoadingBar.setVisibility(View.GONE);
        mUserDataList.setVisibility(View.VISIBLE);
    }

    @Override
    public void bindData(List<Event> eventList) {
        mAdapter.setData(eventList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(String userName) {
        NavigationTool.gotoSingleUserActivity(getActivity(), userName);
    }

    @Override
    public void showToast(String content) {
        Toast.makeText(getActivity(), content, Toast.LENGTH_SHORT).show();
    }
}
