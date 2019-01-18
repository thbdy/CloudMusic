package com.from206.cloudmusic.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.from206.cloudmusic.http.LifeSubscription;
import com.from206.cloudmusic.http.Stateful;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class LoadingBaseFragment<P extends BasePresenter> extends Fragment implements LifeSubscription, Stateful {
    @Inject
    protected P mPresenter;

    private Unbinder bind;
    private View rootView;
    protected Context mContext;

    private CompositeSubscription ordersSubscription;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getContext();
        if (null == rootView) {
            rootView = inflater.inflate(getLayoutId(), null);
            bind = ButterKnife.bind(LoadingBaseFragment.this, rootView);
            initInject();
            initView();
            if (mPresenter != null) {
                mPresenter.attachView(this);
            }
            fetchData();
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (null != parent) {
            parent.removeView(rootView);
        }
        return rootView;
    }


    protected abstract void fetchData();

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initInject();

    private CompositeSubscription mCompositeSubscription;

    //用于添加rx的监听的在onDestroy中记得关闭不然会内存泄漏。
    @Override
    public void bindSubscription(Subscription subscription) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(subscription);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (bind != null) {
            bind.unbind();
        }
        if (this.mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            this.mCompositeSubscription.unsubscribe();
        }
        if (this.ordersSubscription != null && ordersSubscription.hasSubscriptions()) {
            this.ordersSubscription.unsubscribe();
        }
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    public void handleState(String state, String msg) {

    }

}
