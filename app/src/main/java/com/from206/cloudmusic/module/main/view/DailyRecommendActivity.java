package com.from206.cloudmusic.module.main.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.from206.cloudmusic.R;
import com.from206.cloudmusic.adapter.DailyRecommendAdapter;
import com.from206.cloudmusic.base.LoadingBaseActivity;
import com.from206.cloudmusic.http.injector.component.DaggerNetServiceComponent;
import com.from206.cloudmusic.module.main.model.DailyRecommendResult;
import com.from206.cloudmusic.module.main.presenter.DailyRecommendPresenter;
import com.from206.cloudmusic.module.main.presenter.DailyRecommendPresenterImpl;
import com.from206.cloudmusic.module.music.view.MusicActivity;
import com.from206.cloudmusic.utils.HttpCode;
import com.from206.cloudmusic.utils.StatusBarUtil;
import com.from206.cloudmusic.utils.TypeChangeUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 每日推荐歌曲
 * Created by 75232 on 2019/2/12
 * Email：752323877@qq.com
 */
public class DailyRecommendActivity extends LoadingBaseActivity<DailyRecommendPresenterImpl> implements DailyRecommendPresenter.
        View, BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.rv_recommend)
    RecyclerView rvRecommend;
    @BindView(R.id.tool_bar)
    Toolbar toolbar;
    private DailyRecommendAdapter dailyRecommendAdapter;

    @Override
    public void fetchData() {
        mPresenter.fetchDailyRecommend();
    }

    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().build().injectDailyRecommendActivity(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_daily_recommend;
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

    @Override
    protected void initViews() {
        //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
        StatusBarUtil.setRootViewFitsSystemWindows(this,true);
        //设置状态栏透明
        StatusBarUtil.setTranslucentStatus(this);
        rvRecommend.setLayoutManager(new LinearLayoutManager(mContext));

    }

    @Override
    public void setState(int state, String msg) {

    }

    @Override
    public void loadDailyRecommend(DailyRecommendResult result) {
        if(result.getCode() == HttpCode.SUCCESS){
            if(null != result.getRecommend() && result.getRecommend().size() > 0){
                if(dailyRecommendAdapter == null){
                    dailyRecommendAdapter = new DailyRecommendAdapter(result.getRecommend());
                    dailyRecommendAdapter.bindToRecyclerView(rvRecommend);
                    dailyRecommendAdapter.setOnItemClickListener(this);
                }
                dailyRecommendAdapter.notifyDataSetChanged();
            }
        }

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        DailyRecommendResult.RecommendBean recommendBean = dailyRecommendAdapter.getData().get(position);
        Intent intent = new Intent(mContext,MusicActivity.class);
        intent.putExtra("music",TypeChangeUtil.chanToMusicType(recommendBean));
        startActivity(intent);

    }
}
