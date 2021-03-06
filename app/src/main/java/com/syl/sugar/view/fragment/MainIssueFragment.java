package com.syl.sugar.view.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.syl.sugar.model.Course;
import com.syl.sugar.model.Student;
import com.syl.sugar.view.adapter.MainIssueTabAdapter;
import com.syl.sugar.view.adapter.SmartFragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * 首页Issue Tab页面
 * <p/>
 * Created by Shen YunLong on 2016/07/26
 */
public class MainIssueFragment extends BaseTabFragment {

    public static final String ARG_PARAM1 = "param1";
    public static final String TAG = MainIssueFragment.class.getSimpleName();

    private String mParam1;

//    @Bind(R.id.button)
//    Button mRxButton;

    public MainIssueFragment() {
    }

    public static MainIssueFragment newInstance(String param1) {
        MainIssueFragment fragment = new MainIssueFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    //    @OnClick(R.id.button)
//    public void submit() {
//        observable.subscribe(subscriber);
//
//        rxPrintArray(new String[]{"This", "is", "Rx", "Example"});
//        rxScheduler();
//        rxMap();
//        rxFlatMap();
//    }

    @Override
    public SmartFragmentStatePagerAdapter initAdapter() {
        return new MainIssueTabAdapter(mContext, getFragmentManager());
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

    /**
     * RxJava 打印字符串数组例子
     *
     * @param args
     */
    public void rxPrintArray(String[] args) {
        Observable.from(args).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, s);
            }
        });
    }

    /**
     * RxJava Scheduler 例子
     */
    public void rxScheduler() {
        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        Log.d(TAG, "number ->" + integer);
                    }
                });
    }

    /**
     * RxJava Transformation 例子
     */
    public void rxMap() {
        Observable.just("images/logo.png")
                .map(new Func1<String, Bitmap>() {
                    @Override
                    public Bitmap call(String s) {
                        Log.d(TAG, "rxMap # " + s);
                        return null;
                    }
                })
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {
                        Log.d(TAG, "rxMap");
                    }
                });
    }

    /**
     * RxJava Transformation 例子
     */
    public void rxFlatMap() {
        Student[] students = initData();

        Subscriber<Course> subscriber = new Subscriber<Course>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(Course course) {
                Log.d(TAG, getMethodName(0) + " ==> " + course.getName());
            }
        };

        Observable.from(students)
                .flatMap(new Func1<Student, Observable<Course>>() {
                    @Override
                    public Observable<Course> call(Student student) {
                        Log.d(TAG, getMethodName(0) + " => " + student.getName());

                        return Observable.from(student.getCourse());
                    }
                })
                .subscribe(subscriber);
    }

    public static String getMethodName(int depth) {
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        return ste[ste.length - 1 - depth].getMethodName();
    }

    /**
     * 初始化测试数据
     *
     * @return
     */
    private Student[] initData() {
        Student[] students = new Student[4];

        students[0] = new Student("John");
        students[1] = new Student("Oscar");
        students[2] = new Student("Allen");
        students[3] = new Student("Stefanie");

        Course math = new Course("Mathematics");
        Course english = new Course("English");
        Course physics = new Course("Physics");
        Course algorithm = new Course("Algorithm");
        Course philosophy = new Course("Philosophy");
        Course os = new Course("Operating System");

        List<Course> john = new ArrayList<>();
        john.add(math);
        john.add(physics);
        john.add(os);

        List<Course> oscar = new ArrayList<>();
        oscar.add(physics);
        oscar.add(philosophy);

        List<Course> allen = new ArrayList<>();
        allen.add(english);
        allen.add(philosophy);

        List<Course> stefanie = new ArrayList<>();
        stefanie.add(algorithm);
        stefanie.add(os);
        stefanie.add(math);

        students[0].setCourse(john);
        students[1].setCourse(oscar);
        students[2].setCourse(allen);
        students[3].setCourse(stefanie);

        return students;
    }
}
