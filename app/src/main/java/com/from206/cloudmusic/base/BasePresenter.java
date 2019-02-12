package com.from206.cloudmusic.base;


import com.from206.cloudmusic.http.LifeSubscription;
import com.from206.cloudmusic.http.utils.Callback;
import com.from206.cloudmusic.http.utils.HttpUtils;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import rx.Observable;


public class BasePresenter<T extends BaseView> {

    protected Reference<T> mReferenceView;

    protected T mView;
    private Callback callback;




    public void attachView(LifeSubscription mLifeSubscription) {
        this.mReferenceView = new WeakReference<>((T) mLifeSubscription);
        mView = mReferenceView.get();
    }

    protected <T> void invoke(Observable<T> observable, Callback<T> callback) {
        this.callback = callback;
        HttpUtils.invoke((LifeSubscription) mView, observable, callback);
    }

    public void detachView() {
        if (mReferenceView != null)
            mReferenceView.clear();
        mReferenceView = null;
        if (mView != null)
            mView = null;
        if (callback != null) {
            callback.detachView();
        }
    }


}
