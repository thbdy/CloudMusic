package com.from206.cloudmusic.module.music.view;

import android.view.View;

import com.from206.cloudmusic.R;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.music.model.MusicVideoResult;
import com.from206.cloudmusic.module.music.presenter.MusicVideoPresenter;
import com.from206.cloudmusic.module.music.presenter.MusicVideoPresenterImpl;
import com.from206.cloudmusic.utils.HttpCode;

import butterknife.OnClick;

/**
 * MV页面
 * Created by 75232 on 2019/2/1
 * Email：752323877@qq.com
 */
public class MusicVideoActivity extends LoadingBaseActivity<MusicVideoPresenterImpl> implements MusicVideoPresenter.View {
    private int mvId;
    @Override
    public void fetchData() {
        mPresenter.fetchMusicVideo(String.valueOf(mvId));

    }

    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().build().injectMusicVideoActivity(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_music_video;
    }

    @Override
    protected void initViews() {
        mvId = getIntent().getIntExtra("id",0);

    }

    @Override
    public void setState(int state, String msg) {

    }

    @Override
    public void loadMusicVideo(MusicVideoResult result) {
        if(result.getCode() == HttpCode.SUCCESS){

        }
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
