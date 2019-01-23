package com.from206.cloudmusic.http.utils;


import android.util.Log;

import com.from206.cloudmusic.http.Stateful;

import retrofit2.HttpException;
import rx.Subscriber;


public class Callback<T> extends Subscriber<T> {
    private static final String TAG = "Callback";
    private Stateful target;

    public void setTarget(Stateful target) {
        this.target = target;
    }

    public void detachView() {
        if (target != null) {
            target = null;
        }
    }

    @Override
    public void onCompleted() {
        Log.e(TAG, "onCompleted: " );
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "onError: "+e.getMessage() );
        if(e instanceof HttpException){
            HttpException httpException = (HttpException) e;
            onFailed(httpException.code(),httpException.message());
        }
    }



    @Override
    public void onNext(T data) {

        onResponse(data);
    }

    public void onResponse(T data) {
        Log.e(TAG, "onResponse: " );


    }
    public void onFailed(int code,String msg) {
        target.setState(code,msg);
    }
}
