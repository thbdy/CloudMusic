package com.from206.cloudmusic.base;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.from206.cloudmusic.http.LifeSubscription;
import com.from206.cloudmusic.module.login.view.LoginActivity;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public  abstract class BaseActivity extends AppCompatActivity implements LifeSubscription {
    protected Context mContext;
    protected abstract int getLayoutId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mContext = this;
        initViews();
    }

    protected abstract void initViews();

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
    protected void onDestroy() {
        super.onDestroy();
        if (this.mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            this.mCompositeSubscription.unsubscribe();
        }
    }

    /**
     * 前往登录页面
     */
    public void goLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

//
//    public LoadingDialog loadingDialog;
//
//    public void showLoadingDialog() {
//        if (null == loadingDialog) {
//            loadingDialog = new LoadingDialog(this);
//        }
//        if (!loadingDialog.isShowing()) {
//            loadingDialog.show();
//        }
//    }

//    public void dismissLoadingDialog() {
//        if (null != loadingDialog) {
//            if (loadingDialog.isShowing()) {
//                loadingDialog.dismiss();
//            }
//        }
//        loadingDialog = null;
//    }
}
