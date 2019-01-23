package com.from206.cloudmusic.http.utils;


import com.from206.cloudmusic.http.LifeSubscription;
import com.from206.cloudmusic.http.Stateful;
import com.from206.cloudmusic.utils.HttpCode;
import com.from206.cloudmusic.utils.Utils;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



public class HttpUtils {

    public static <T> void invoke(LifeSubscription lifecycle, Observable<T> observable, Callback<T> callback) {
        Stateful target = null;
        if (lifecycle instanceof Stateful) {
            target = (Stateful) lifecycle;
            callback.setTarget(target);
        }
        if (!Utils.isNetworkAvailable()) {
            if (target != null) {
                target.setState(HttpCode.NET_BREAK_OFF,"");
            }
            return;
        }

        Subscription subscription = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback);
        lifecycle.bindSubscription(subscription);

    }
}
