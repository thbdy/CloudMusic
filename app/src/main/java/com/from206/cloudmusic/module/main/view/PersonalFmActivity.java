package com.from206.cloudmusic.module.main.view;

import android.view.View;

import com.from206.cloudmusic.R;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.main.model.PersonalFmResult;
import com.from206.cloudmusic.module.main.presenter.PersonalFmPresenter;
import com.from206.cloudmusic.module.main.presenter.PersonalFmPresenterImpl;

import butterknife.OnClick;

/**
 * 私人FM
 * Created by 75232 on 2019/1/23
 * Email：752323877@qq.com
 */
public class PersonalFmActivity extends LoadingBaseActivity<PersonalFmPresenterImpl> implements PersonalFmPresenter.View {
    @Override
    public void fetchData() {
        mPresenter.fetchPersonalFm();

    }

    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().build().injectPersonalFmActivity(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_fm;
    }

    @Override
    protected void initViews() {

    }

    @Override
    public void setState(int state, String msg) {

    }

    @Override
    public void loadPersonalFm(PersonalFmResult result) {

    }
    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
