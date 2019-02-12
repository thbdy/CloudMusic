package com.from206.cloudmusic.base;


import android.content.Intent;
import android.os.Bundle;

import com.blankj.utilcode.util.ToastUtils;
import com.from206.cloudmusic.http.Stateful;
import com.from206.cloudmusic.module.login.view.LoginActivity;
import com.from206.cloudmusic.utils.HttpCode;

import javax.inject.Inject;

public abstract class LoadingBaseActivity<T extends BasePresenter> extends BaseActivity implements Stateful {
    private String TAG;

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
     * @param code
     */
    public void handleState(int code, String msg) {
//        dismissLoadingDialog();
        switch (code) {
            case HttpCode.SYSTEM_ERROR://网络断开

                break;
            case HttpCode.COMMON_HTTP_ERROR://网络访问错误

                break;
                //会话失效,请重新登录
            case HttpCode.NEED_LOGIN:
                startActivity(new Intent(mContext,LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                break;
            case HttpCode.PARAM_ERROR:
                ToastUtils.showShort("参数错误");
                break;

            default:
                break;
        }
    }
}
