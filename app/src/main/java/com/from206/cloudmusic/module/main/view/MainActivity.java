package com.from206.cloudmusic.module.main.view;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.main.model.RefreshLoginResult;
import com.from206.cloudmusic.module.main.presenter.MainPresenter;
import com.from206.cloudmusic.module.main.presenter.MainPresenterImpl;
import com.from206.cloudmusic.module.user.view.PersonInfoActivity;
import com.from206.cloudmusic.utils.PersonInfoUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends LoadingBaseActivity<MainPresenterImpl> implements MainPresenter.View {
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    RecommendFragment recommendFragment;
    private FragmentTransaction ft;
    private FragmentManager fm;
    @BindView(R.id.iv_person_info_bg)
    ImageView ivPersonInfoBg;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_nick_name)
    TextView tvNickName;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void fetchData() {
//        mPresenter.fetchRefreshLogin();

    }

    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().build().injectMainActivity(this);
    }

    @Override
    protected void initViews() {
        fm = getSupportFragmentManager();
        recommendFragment = new RecommendFragment();
        ft = fm.beginTransaction();
        ft.add(R.id.fl_content, recommendFragment);
        ft.commit();

        tvNickName.setText(PersonInfoUtil.getPersonInfo().getProfile().getNickname());
        Glide.with(mContext).load(PersonInfoUtil.getPersonInfo().getProfile().getBackgroundUrl()).into(ivPersonInfoBg);
        Glide.with(mContext).load(PersonInfoUtil.getPersonInfo().getProfile().getAvatarUrl()).into(ivHead);

    }

    @Override
    public void setState(int state, String msg) {
        handleState(state, msg);
    }

    @Override
    public void loadRefreshLogin(RefreshLoginResult result) {
        Log.e("TAG", "loadRefreshLogin: 需要登录");
        if (result.getCode() == 200) {
            ToastUtils.showShort("刷新登录状态成功");
        }

    }

    @OnClick({R.id.iv_head})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_head:
                startActivity(new Intent(mContext,PersonInfoActivity.class));
                break;
        }
    }
}
