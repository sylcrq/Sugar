package com.syl.sugar.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.syl.sugar.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * A simple {@link Fragment} subclass.
 */
public class NearbyFragment extends Fragment {

    public static final String TAG = NearbyFragment.class.getSimpleName();

    @Bind(R.id.button)
    Button mRxButton;

    public NearbyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nearby, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.button)
    public void submit() {
        observable.subscribe(subscriber);

        rxPrintArray(new String[] {"This", "is", "Rx", "Example"});
    }

    /**
     * 被观察者
     */
    Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> subscriber) {
            subscriber.onNext("Hello");
            subscriber.onNext("John");
            subscriber.onNext("Goodbye !");
            subscriber.onCompleted();
        }
    });

    Subscriber<String> subscriber = new Subscriber<String>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onNext(String s) {
            Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
        }
    };

    public void rxPrintArray(String[] args) {
        Observable.from(args).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, s);
            }
        });
    }
}
