package com.from206.cloudmusic.base;


import android.os.Bundle;

import com.from206.cloudmusic.http.Stateful;
import com.from206.cloudmusic.utils.ErrorCodes;

import javax.inject.Inject;

public abstract class LoadingBaseActivity<T extends BasePresenter> extends BaseActivity implements Stateful {
    private String TAG  ;

    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         TAG = getClass().getSimpleName();
        initInject();
        mPresenter.attachView(this);
        fetchData();
    }

    public abstract void fetchData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }


    /**
     * dagger2注入
     */
    protected abstract void initInject();

    /**
     * handle the common error
     *
     * @param state
     */
    public void handleState(String state, String msg) {
//        dismissLoadingDialog();
        switch (state) {
            case ErrorCodes.NET_BREAK_OFF://网络断开

                break;
            case ErrorCodes.COMMON_HTTP_ERROR://网络访问错误

                break;
                //会话失效,请重新登录
            case ErrorCodes.NEED_LOGIN:

                break;

            default:
                break;
        }
    }
}
