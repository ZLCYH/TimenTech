package com.wd.tech.mvp.model.net;


import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Administrator QQ:1228717266
 * @name DimensionTech
 * @class name：com.wd.tech.mvp.model.net
 * @time 2018/11/29 19:33
 */
public class ObjectLoader {

    public  <T>Observable<T> activityObserve(Observable<T> observable, LifecycleProvider<ActivityEvent> lifecycleProvider){

        return observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .compose(lifecycleProvider.<T>bindToLifecycle())        //绑定生命周期
                .observeOn(AndroidSchedulers.mainThread());
    }

    protected <T>Observable<T> fragmentObserve(Observable<T> observable, LifecycleProvider<FragmentEvent> lifecycleProvider){

        return observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .compose(lifecycleProvider.<T>bindToLifecycle())        //绑定生命周期
                .observeOn(AndroidSchedulers.mainThread());
    }
}
