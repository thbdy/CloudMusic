package com.from206.cloudmusic.module.user.view;

import android.view.View;

import com.from206.cloudmusic.R;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.user.model.UserRecordResult;
import com.from206.cloudmusic.module.user.presenter.ListeningMusicRankPresenter;
import com.from206.cloudmusic.module.user.presenter.ListeningMusicRankPresenterImpl;
import com.from206.cloudmusic.utils.PersonInfoUtil;
import com.from206.cloudmusic.view.CommonHeaderView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 听歌排行
 * Created by 75232 on 2019/2/19
 * Email：752323877@qq.com
 */
public class ListeningMusicRankActivity extends LoadingBaseActivity<ListeningMusicRankPresenterImpl> implements ListeningMusicRankPresenter.View {
    @BindView(R.id.head_view)
    CommonHeaderView headerView;
    @Override
    public void fetchData() {


    }

    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().build().injectListeningMusicRankActivity(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_listening_music_rank;
    }

    @Override
    protected void initViews() {
        headerView.setTitle(PersonInfoUtil.getPersonInfo().getProfile().getNickname()+"的听歌排行");
    }

    @Override
    public void setState(int state, String msg) {

    }

    @Override
    public void loadUserRecord(UserRecordResult result) {

    }
    @OnClick({R.id.iv_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
